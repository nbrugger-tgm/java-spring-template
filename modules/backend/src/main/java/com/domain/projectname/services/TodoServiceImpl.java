package com.domain.projectname.services;

import com.domain.projectname.entities.todo.TodoEntry;
import com.domain.projectname.entities.todo.TodoList;
import com.domain.projectname.models.TodoEntryDto;
import com.domain.projectname.models.TodoListDto;
import com.domain.projectname.repositories.TodoListRepository;
import com.domain.projectname.repositories.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@Slf4j
class TodoServiceImpl implements TodoService {
	private final TodoListRepository listRepo;
	private final TodoRepository     todoRepo;
	private final ModelMapper        mapper;

	public TodoServiceImpl(
			TodoListRepository listRepo,
			TodoRepository todoRepo,
			ModelMapper mapper
	) {
		this.listRepo = listRepo;
		this.todoRepo = todoRepo;
		this.mapper   = mapper;
	}

	@Override
	public TodoListDto createList(TodoListDto dto) {
		if (listRepo.existsByTitle(dto.getTitle()))
			throw new IllegalArgumentException(format(
					"List with name %s already exists",
					dto.getTitle()
			));

		var list = new TodoList();
		mapper.map(dto, list);
		listRepo.save(list);

		TodoListDto created = new TodoListDto();
		mapper.map(list, created);
		return created;
	}

	@Override
	public TodoListDto getList(String listName) {
		verifyListExistence(listName);
		return mapper.map(listRepo.findByTitle(listName), TodoListDto.class);
	}

	private void verifyListExistence(String listName) {
		if (!listRepo.existsByTitle(listName)) throwListNotFound();
	}

	private void throwListNotFound() {
		throw new IllegalArgumentException("List does not exist");
	}

	@Override
	public void deleteList(String listName) {
		verifyListExistence(listName);
		listRepo.deleteByTitle(listName);
	}

	@Override
	public void updateList(String name, TodoListDto list) {
		TodoList listToUpdate = fetchList(name);
		mapper.map(list, listToUpdate);
		listRepo.save(listToUpdate);
	}

	private TodoList fetchList(String name) {
		verifyListExistence(name);
		return listRepo.findByTitle(name);
	}

	@Override
	@Transactional
	public boolean addItem(String listName, TodoEntryDto item) {
		TodoList list = fetchList(listName);
		var      entry = new TodoEntry();
		mapper.map(item, entry);
		return list.addItem(entry);
	}

	@Override
	@Transactional
	public void deleteItem(String listName, String itemName) {
		verifyListExistence(listName);
		long listId = listRepo.getIdByTitle(listName);
		verifyItemExistence(itemName, listId);
		todoRepo.deleteByNameAndListId(itemName, listId);
	}

	private void verifyItemExistence(String itemName, long listId) {
		if (!todoRepo.existsByNameAndListId(itemName, listId))
			throwEntryNotFound(itemName, listId);
	}

	private void throwEntryNotFound(String itemName, long listId) {
		throw new IllegalArgumentException(format(
				"Entry '%s' does not exist in list %d",
				itemName, listId
		));
	}

	@Override
	@Transactional
	public void updateItem(
			String list, String itemName, TodoEntryDto item
	) {
		verifyListExistence(list);
		long listId = listRepo.getIdByTitle(list);
		verifyItemExistence(itemName, listId);
		var entry = todoRepo.findByNameAndListId(itemName, listId);
		mapper.map(item, entry);
	}

	@Override
	public Set<TodoListDto> getAllLists() {

		return listRepo.findAll()
		               .stream()
		               .map(todo -> mapper.map(todo, TodoListDto.class))
		               .collect(Collectors.toSet());
	}

	@Override
	@Transactional(readOnly = true)
	public Set<TodoEntryDto> getEntries(String listName) {
		var list = fetchList(listName);
		return list.getEntries()
		           .stream()
		           .map(entry -> mapper.map(entry, TodoEntryDto.class))
		           .collect(Collectors.toSet());
	}

	@Override
	public TodoEntryDto getEntry(String listName, String itemName) {
		verifyListExistence(listName);
		long listId = listRepo.getIdByTitle(listName);
		verifyItemExistence(itemName, listId);
		return mapper.map(todoRepo.findByNameAndListId(itemName, listId), TodoEntryDto.class);
	}
}
