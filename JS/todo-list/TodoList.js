import { Task } from './Task.js';

export class TodoList {
	constructor(apiUrl, listElement, counterElement, modalElements) {
		this.apiUrl = apiUrl;
		this.listElement = listElement;
		this.counterElement = counterElement;

		// instantiate the modal Bootstrap object
		this.modal = new bootstrap.Modal(modalElements.modal);
		this.modalBody = modalElements.body;
		this.modalValiderBtn = modalElements.validerBtn;
		//
		this.currentAction = null;
		this.currentTaskId = null;
		this.currentEditText = null;

		this.tasks = [];
		this.setupModalHandler();
		this.fetchTodos();
	}
	// manage modal actions when user delete or edit a task
	setupModalHandler() {
		this.modalValiderBtn.onclick = async () => {
			if (this.currentAction === 'delete') {
				await fetch(`${this.apiUrl}/${this.currentTaskId}`, {
					method: 'DELETE',
				});
			} else if (this.currentAction === 'edit') {
				const newText = document.getElementById('modalEditInput').value.trim();
				if (newText) {
					await fetch(`${this.apiUrl}/${this.currentTaskId}`, {
						method: 'PATCH',
						headers: { 'Content-Type': 'application/json' },
						body: JSON.stringify({ text: newText }),
					});
				}
			}
			this.modal.hide();
			this.currentAction = null;
			this.currentTaskId = null;
			this.currentEditText = null;
			this.fetchTodos();
		};
	}

	async fetchTodos() {
		const res = await fetch(this.apiUrl);
		const todos = await res.json();
		this.renderTodos(todos);
	}

	renderTodos(todos) {
		this.listElement.innerHTML = '';
		let remaining = 0;
		let completed = 0;
		this.tasks = todos.map((todo) => {
			const task = new Task(
				todo,
				(id, data) => this.updateTask(id, data),
				(id) => this.confirmDelete(id),
				(id, text) => this.confirmEdit(id, text)
			);
			this.listElement.appendChild(task.element);
			if (!todo.done) remaining++;
			else completed++;
			return task;
		});
		const total = todos.length;
		this.counterElement.innerHTML = `<span>Tasks: ${total} | Completed: ${completed} | Remaining: ${remaining}</span>`;
	}

	async addTask(text) {
		await fetch(this.apiUrl, {
			method: 'POST',
			headers: { 'Content-Type': 'application/json' },
			body: JSON.stringify({ text, done: false }),
		});
		this.fetchTodos();
	}

	async updateTask(id, data) {
		await fetch(`${this.apiUrl}/${id}`, {
			method: 'PATCH',
			headers: { 'Content-Type': 'application/json' },
			body: JSON.stringify(data),
		});
		this.fetchTodos();
	}

	confirmDelete(id) {
		this.currentAction = 'delete';
		this.currentTaskId = id;
		this.modalBody.textContent = 'Do you want to delete this task ?';
		this.modal.show();
	}

	confirmEdit(id, text) {
		this.currentAction = 'edit';
		this.currentTaskId = id;
		this.currentEditText = text;
		
		this.modalBody.innerHTML = `<div class='mb-2'>Change the task below</div><input type='text' id='modalEditInput' class='form-control' value="${text.replace(
			/"/g,
			'&quot;'
		)}">`;
		setTimeout(() => {
			document.getElementById('modalEditInput').focus();
		}, 200);
		this.modal.show();
	}
}