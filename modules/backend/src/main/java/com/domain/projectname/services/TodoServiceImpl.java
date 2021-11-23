package com.domain.projectname.services;

import com.domain.projectname.entities.todo.TodoEntry;
import com.domain.projectname.entities.todo.TodoList;
import com.domain.projectname.repositories.TodoListRepository;
import com.domain.projectname.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
class TodoServiceImpl implements TodoService {
	private final TodoListRepository listRepo;
	private final TodoRepository     todoRepo;

	public TodoServiceImpl(
			TodoListRepository listRepo,
			TodoRepository todoRepo
	) {
		this.listRepo = listRepo;
		this.todoRepo = todoRepo;
	}

	@Override
	public TodoList createList(String listName) {
		TodoList list = new TodoList();
		list.setTitle(listName);
		listRepo.save(list);
		return list;
	}

	@Override
	public TodoList getList(String listName) {
		if (!listRepo.existsByTitle(listName))
			throwListNotFound();
		return listRepo.findByTitle(listName);
	}

	@Override
	public void deleteList(String listName) {
		listRepo.deleteByTitle(listName);
	}

	@Override
	public void updateList(TodoList newList) {
		var oldList = listRepo.findById(newList.getId());
		if (oldList.isEmpty())
			throwListNotFound();

		listRepo.save(newList);
	}

	@Override
	@Transactional
	public void addItem(String listName, TodoEntry item) {
		var list = listRepo.findByTitle(listName);
		if (list == null)
			throwListNotFound();
		list.addItem(item);
		todoRepo.save(item);
		listRepo.save(list);
	}

	@Override
	@Transactional
	public void deleteItem(String listName, String itemName) {
		var list = listRepo.findByTitle(listName);
		if (list == null)
			throwListNotFound();
		var item = todoRepo.findByName(itemName);
		if (item == null)
			throw new IllegalArgumentException("Item does not exist");
		list.removeItem(item);
		listRepo.save(list);
	}

	@Override
	public void updateItem(TodoEntry item) {
		if (!todoRepo.existsById(item.getId()))
			throw new IllegalArgumentException("Item does not exist");
		todoRepo.save(item);
	}

	@Override
	public Set<TodoList> getAllLists() {
		return listRepo.findAll();
	}

	@Override
	@Transactional
	public Set<TodoEntry> getEntries(String listName) {
		var list = listRepo.findByTitle(listName);
		if (list == null)
			throwListNotFound();
		var set = new HashSet<>(list.getEntries());
		return set;
	}

	private void throwListNotFound() {
		throw new IllegalArgumentException("List does not exist");
	}
}
