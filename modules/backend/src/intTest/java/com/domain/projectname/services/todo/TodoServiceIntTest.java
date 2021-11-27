package com.domain.projectname.services.todo;

import com.domain.projectname.models.TodoEntryDto;
import com.domain.projectname.models.TodoListDto;
import com.domain.projectname.services.TodoService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.slf4j.LoggerFactory.getLogger;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//This test is a example integration test,
class TodoServiceIntTest {
	private final Logger      LOG = getLogger(TodoServiceIntTest.class);
	@Autowired
	private       TodoService todoService;

	@Test
	void testWorkflow() {
		String listName = "test1";
		var    list     = todoService.createList(new TodoListDto(listName));
		assertNotNull(list, "The generated list should be returned");
		assertThrows(
				IllegalArgumentException.class,
				() -> todoService.createList(new TodoListDto(listName))
		);

		var lists = todoService.getAllLists();
		LOG.info(lists.toString());
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

		var entries = todoService.getEntries(listName);
		assertEquals(0, entries.size(), "Initially the list should have no tasks");

		var item = new TodoEntryDto("yikes");
		item.setDone(true);
		todoService.addItem(listName, item);
		assertEquals(1, todoService.getEntries(listName).size(), "The list should have one task");

		entries = todoService.getEntries(listName);
		assertEquals(1, entries.size(), "The fetched list should have one task");
		assertEquals(
				item.getName(),
				entries.iterator().next().getName(),
				"The task title should match"
		);


		var newName     = "fancy name";
		var entry       = todoService.getEntry(listName, item.getName());
		var updateEntry = new TodoEntryDto(newName);
		updateEntry.setDone(false);
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
		item.setDone(updateEntry.isDone());
		assertEquals(
				item,
				todoService.getEntry(listName, newName),
				"The task should be updated (but just the name)"
		);

		todoService.deleteItem(listName, item.getName());
		assertEquals(
				0,
				todoService.getEntries(listName).size(),
				"The list should have no tasks after removal"
		);
	}

	@Test
	void testChangeListName() {
		String oldName = "test3";
		String newName = "test4";

		var list = todoService.createList(new TodoListDto(oldName));
		assertNotNull(list, "The generated list should be returned");

		list.setTitle(newName);
		todoService.updateList(oldName, list);

		var updated = todoService.getList(newName);

		assertNotNull(updated, "Fetching by the nre name should yield results");
		assertEquals(newName, updated.getTitle(), "The list title was not updated");
		assertThrows(IllegalArgumentException.class, () -> todoService.getList(oldName));
	}
}
