package com.domain.projectname.services;

import com.domain.projectname.models.TodoEntryDto;
import com.domain.projectname.models.TodoListDto;

import java.util.Set;

public interface TodoService {
	TodoListDto createList(TodoListDto listName);

	TodoListDto getList(String listName);

	void deleteList(String listName);

	void updateList(String name, TodoListDto list);

	boolean addItem(String listName, TodoEntryDto item);

	void deleteItem(String listName, String itemName);

	void updateItem(String list, String itemName, TodoEntryDto item);

	Set<TodoListDto> getAllLists();

	Set<TodoEntryDto> getEntries(String listName);

	TodoEntryDto getEntry(String listName, String itemName);

	void setDone(String list, String itemName, boolean done);
}
