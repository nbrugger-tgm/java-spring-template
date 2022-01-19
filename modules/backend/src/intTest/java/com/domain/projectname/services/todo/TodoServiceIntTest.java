package com.domain.projectname.services.todo;

import com.domain.projectname.models.TodoEntryDto;
import com.domain.projectname.models.TodoListDto;
import com.domain.projectname.services.TodoService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.slf4j.LoggerFactory.getLogger;


@SpringBootTest
//This test is a example integration test,
class TodoServiceIntTest {
	private final Logger      LOG = getLogger(TodoServiceIntTest.class);
	@Autowired
	private       TodoService todoService;

	@Test
	void testWorkflow() {
		deleteAllTodoLists();

		String listName = "test1";

		var list = todoService.createList(new TodoListDto(listName));
		assertNotNull(list, "The generated list should be returned");
		assertThrows(
				IllegalArgumentException.class,
				() -> todoService.createList(new TodoListDto(listName))
		);

		var lists = todoService.getAllLists();
		assertEquals(1, lists.size(), "There should be one list");
		assertEquals(
				list,
				lists.iterator().next(),
				"The returned list from the container should match the created one!"
		);

		list.setDescription("test description");
		list.setColor("#FF0000");
		todoService.updateList(listName, list);

		var updated = todoService.getList(listName);
		assertEquals(list.getColor(), updated.getColor(), "The list color was not updated");
		assertEquals(list.getTitle(), updated.getTitle(), "The list title was not updated");
		assertEquals(
				list.getDescription(),
				updated.getDescription(),
				"The list desc. was not updated"
		);

		list = new TodoListDto(listName, "yeeee", null);
		todoService.updateList(listName, list);
		updated = todoService.getList(listName);
		assertNotNull(updated.getColor(), "Updating should not copy null values");
		assertEquals(
				list.getDescription(),
				updated.getDescription(),
				"Updating should overwrite non-null values"
		);

		var entries = todoService.getEntries(listName);
		assertEquals(0, entries.size(), "Initially the list should have no tasks");

		var item = new TodoEntryDto("yikes");
		item.setDone(true);
		assertTrue(
				todoService.addItem(listName, item),
				"adding this entry is possible and should return true"
		);
		assertEquals(1, todoService.getEntries(listName).size(), "The list should have one task");
		assertTrue(todoService.getEntry(listName, item.getName()).getDone());

		entries = todoService.getEntries(listName);
		assertEquals(1, entries.size(), "A task was added so fetching the list should yield one");
		assertEquals(
				item.getName(),
				entries.iterator().next().getName(),
				"The task title should match"
		);


		var newName     = "fancy name";
		var entry       = todoService.getEntry(listName, item.getName());
		var updateEntry = new TodoEntryDto(newName);
		updateEntry.setDueTo(LocalDate.now().plusDays(2));
		todoService.updateItem(listName, entry.getName(), updateEntry);
		assertDoesNotThrow(
				() -> todoService.getEntry(listName, newName),
				"The entry should exist with the new name"
		);
		assertThrows(
				IllegalArgumentException.class,
				() -> todoService.getEntry(listName, item.getName()),
				"THe old name should not exist anymore"
		);
		assertEquals(
				newName,
				todoService.getEntry(listName, newName).getName(),
				"The task title should be updated"
		);
		item.setName(updateEntry.getName());
		item.setDueTo(updateEntry.getDueTo());
		assertEquals(
				item,
				todoService.getEntry(listName, newName),
				"The task should be updated (but just the name)"
		);
		assertTrue(
				todoService.getEntry(listName, newName).getDone(),
				"Done should not have been overwritten"
		);

		LOG.info("Delete entry {} in list {}", item.getName(), listName);
		todoService.deleteItem(listName, item.getName());
		var entriesAfterDelete = todoService.getEntries(listName);
		assertEquals(
				0,
				entriesAfterDelete.size(),
				"The list should have no tasks after removal (%s)".formatted(entriesAfterDelete)
		);
	}

	private void deleteAllTodoLists() {
		todoService.getAllLists().forEach(list -> todoService.deleteList(list.getTitle()));
		assertEquals(
				0,
				todoService.getAllLists().size(),
				"There should be no lists after deleting each one"
		);
	}

	@Test
	void testChangeListName() {
		deleteAllTodoLists();


		String oldName = "test3";
		String newName = "test4";

		var list = todoService.createList(new TodoListDto(oldName));
		assertNotNull(list, "The generated list should be returned");

		list.setTitle(newName);
		todoService.updateList(oldName, list);

		var updated = todoService.getList(newName);

		assertNotNull(updated, "Fetching by the new name should yield results");
		assertEquals(newName, updated.getTitle(), "The list title was not updated");
		assertThrows(IllegalArgumentException.class, () -> todoService.getList(oldName));
	}
}
