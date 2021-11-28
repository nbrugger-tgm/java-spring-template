package com.domain.projectname.api.controllers;

import com.domain.projectname.models.TodoEntryDto;
import com.domain.projectname.models.TodoListDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RequestMapping("todo")
public interface TodoController {

	@Operation(summary = "Get all lists", description = "Get a list of all todo lists")
	@GetMapping("lists")
	Set<TodoListDto> getLists();

	@Operation(description = "Get a list of todo items with the specified name")
	@GetMapping("lists/{name}")
	TodoListDto getList(String listId);

	@Operation(description = "Add a new todo list")
	@PostMapping("lists")
	void createList(@RequestBody @Valid TodoListDto list);

	@PostMapping("lists/{name}")
	void updateList(@PathVariable String name, @RequestBody @Valid TodoListDto list);

	@DeleteMapping("lists/{name}")
	void deleteList(@PathVariable String name);

	@PostMapping("lists/{name}/items")
	void createItem(@PathVariable String name, @RequestBody @Valid TodoEntryDto item);

	@PostMapping("lists/{name}/items/{itemName}")
	void updateItem(
			@PathVariable String name,
			@PathVariable String itemName,
			@RequestBody @Valid TodoEntryDto item
	);

	@DeleteMapping("lists/{name}/items/{itemName}")
	void deleteItem(@PathVariable String name, @PathVariable String itemName);

	@GetMapping("lists/{name}/items/{itemName}")
	TodoEntryDto getItem(@PathVariable String name, @PathVariable String itemName);

	@GetMapping("lists/{name}/items")
	Set<TodoEntryDto> getItems(@PathVariable String name);

	@GetMapping("lists/{name}/itemNames")
	Set<String> getItemNames(@PathVariable String name);

	@PatchMapping("lists/{list}/items/{itemName}/done/{done}")
	void setDone(
			@PathVariable String list,
			@PathVariable String itemName,
			@PathVariable boolean done
	);
}
