package com.domain.projectname.controllers;

import com.domain.projectname.api.controllers.TodoController;
import com.domain.projectname.models.TodoEntryDto;
import com.domain.projectname.models.TodoListDto;
import com.domain.projectname.services.TodoService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class TodoControllerImpl implements TodoController {

	private final TodoService service;

	public TodoControllerImpl(TodoService service) {this.service = service;}

	@Override
	public Set<TodoListDto> getLists() {
		return service.getAllLists();
	}

	@Override
	public TodoListDto getList(String name) {
		return service.getList(name);
	}

	@Override
	public void createList(TodoListDto list) {
		service.createList(list);
	}

	@Override
	public void updateList(String name, TodoListDto list) {
		service.updateList(name, list);
	}

	@Override
	public void deleteList(String name) {
		service.deleteList(name);
	}

	@Override
	public void createItem(String name, TodoEntryDto item) {
		service.addItem(name, item);
	}

	@Override
	public void updateItem(
			String name, String itemName, TodoEntryDto item
	) {
		service.updateItem(name, itemName, item);
	}

	@Override
	public void deleteItem(String name, String itemName) {
		service.deleteItem(name, itemName);
	}

	@Override
	public TodoEntryDto getItem(String name, String itemName) {
		return service.getEntry(name, itemName);
	}

	@Override
	public Set<TodoEntryDto> getItems(String name) {
		return service.getEntries(name);
	}

	@Override
	public Set<String> getItemNames(String name) {
		return service.getEntries(name)
		              .stream()
		              .map(TodoEntryDto::getName)
		              .collect(Collectors.toSet());
	}

	@Override
	public void setDone(String list, String itemName, boolean done) {
		service.setDone(list, itemName, done);
	}
}
