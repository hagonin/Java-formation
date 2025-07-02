export class Task {
	constructor(data, onUpdate, onDelete, onEdit) {
		this.data = data;
		this.onUpdate = onUpdate;
		this.onDelete = onDelete;
		this.onEdit = onEdit;
		this.element = this.render();
	}

	render() {
		const li = document.createElement('li');
		li.className = 'mb-3';

		const card = document.createElement('div');
		card.className =
			'd-flex align-items-center justify-content-between rounded shadow-sm px-3 py-2 bg-white';
		card.style.minHeight = '56px';

		// Checkbox
		const checkbox = document.createElement('input');
		checkbox.type = 'checkbox';
		checkbox.className = 'form-check-input me-3';
		checkbox.checked = !!this.data.done;
		checkbox.style.width = '1.3em';
		checkbox.style.height = '1.3em';

		// Task text
		const label = document.createElement('span');
		label.textContent = this.data.text;
		label.className = 'fw-semibold';
		if (this.data.done) {
			label.classList.add(
				'text-decoration-line-through',
				'text-secondary',
				'opacity-50'
			);
		}

		// Modify button
		const btnModify = document.createElement('button');
		btnModify.type = 'button';
		btnModify.className =
			'btn btn-light btn-sm rounded-circle ms-2 d-flex align-items-center justify-content-center';
		btnModify.style.width = '2rem';
		btnModify.style.height = '2rem';
		btnModify.innerHTML = `<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-pencil' viewBox='0 0 16 16'><path d='M12.146.854a.5.5 0 0 1 .708 0l2.292 2.292a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-4 1.5a.5.5 0 0 1-.65-.65l1.5-4a.5.5 0 0 1 .11-.168l10-10zm.708-.708a1.5 1.5 0 0 0-2.121 0l-10 10a1.5 1.5 0 0 0-.328.497l-1.5 4A1.5 1.5 0 0 0 2.5 16a1.5 1.5 0 0 0 .497-.328l4-1.5a1.5 1.5 0 0 0 .497-.328l10-10a1.5 1.5 0 0 0 0-2.121l-2.292-2.292z'/></svg>`;

		// Delete button
		const btnDelete = document.createElement('button');
		btnDelete.type = 'button';
		btnDelete.className =
			'btn btn-light btn-sm rounded-circle ms-2 d-flex align-items-center justify-content-center';
		btnDelete.style.width = '2rem';
		btnDelete.style.height = '2rem';
		btnDelete.innerHTML = '<span aria-hidden="true">&times;</span>';

		// Layout
		const left = document.createElement('div');
		left.className = 'd-flex align-items-center flex-grow-1';
		left.appendChild(checkbox);
		left.appendChild(label);

		card.appendChild(left);
		card.appendChild(btnModify);
		card.appendChild(btnDelete);
		li.appendChild(card);

		// Events
		checkbox.addEventListener('change', () => {
			this.onUpdate(this.data.id, { done: !this.data.done });
		});
		btnDelete.addEventListener('click', () => {
			this.onDelete(this.data.id);
		});
		btnModify.addEventListener('click', () => {
			this.onEdit(this.data.id, this.data.text);
		});

		return li;
	}
}