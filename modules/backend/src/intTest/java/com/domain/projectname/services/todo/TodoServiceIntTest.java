package com.domain.projectname.services.todo;

import com.domain.projectname.models.TodoEntryDto;
import com.domain.projectname.models.TodoListDto;
import com.domain.projectname.services.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {
})

//This test is a example integration test,
public class TodoServiceIntTest {
	@Autowired
	private TodoService todoService;

	@Test
	void testWorkflow() {
		String listName = "test1";
		var    list     = todoService.createList(new TodoListDto(listName));
		assertNotNull(list, "The generated list should be returned");

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
