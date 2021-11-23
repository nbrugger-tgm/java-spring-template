package com.domain.projectname.services;

import com.domain.projectname.entities.todo.TodoEntry;
import com.domain.projectname.entities.todo.TodoList;

import java.util.Set;

public interface TodoService {
	TodoList createList(String listName);

	TodoList getList(String listName);

	void deleteList(String listName);

	void updateList(TodoList list);

	void addItem(String listName, TodoEntry item);

	void deleteItem(String listName, String itemName);

	void updateItem(TodoEntry item);

	Set<TodoList> getAllLists();

	Set<TodoEntry> getEntries(String listName);
}
