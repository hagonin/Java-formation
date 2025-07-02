import { FormAddTask } from './FormAddTask.js';
import { TodoList } from './todoList.js';

document.addEventListener('DOMContentLoaded', () => {
	const API_URL = 'http://localhost:3000/tasks';
	const listElement = document.getElementById('listeTaches');
	const counterElement = document.getElementById('todoCounter');
	const modalElements = {
		modal: document.getElementById('actionModal'),
		body: document.getElementById('actionModalBody'),
		validerBtn: document.getElementById('modalValiderBtn'),
	};
	const formElement = document.getElementById('formulaire');

	const todoList = new TodoList(
		API_URL,
		listElement,
		counterElement,
		modalElements
	);
	new FormAddTask(formElement, (text) => todoList.addTask(text));
});
