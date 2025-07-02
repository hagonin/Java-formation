export class FormAddTask {
	constructor(formElement, onAdd) {
		this.form = formElement;
		this.input = this.form.querySelector('input[type="text"]');
		this.onAdd = onAdd;
		this.form.addEventListener('submit', (e) => this.handleSubmit(e));
	}

	handleSubmit(e) {
		e.preventDefault();
		const texte = this.input.value.trim();
		if (!texte) return;
		this.onAdd(texte);
		this.input.value = '';
	}
}
