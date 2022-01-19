package com.domain.projectname.services;

import com.domain.projectname.BackendSpringConfig;
import com.domain.projectname.entities.todo.TodoEntry;
import com.domain.projectname.entities.todo.TodoList;
import com.domain.projectname.general.ModelUpdater;
import com.domain.projectname.models.TodoListDto;
import com.domain.projectname.repositories.TodoListRepository;
import com.domain.projectname.repositories.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {
	@Spy
	ModelMapper  mapper  = new BackendSpringConfig().modelMapper();
	@Spy
	ModelUpdater updater = new BackendSpringConfig().modelUpdater();
	@InjectMocks
	private TodoServiceImpl    todoService;
	@Mock
	private TodoRepository     todoRepository;
	@Mock
	private TodoListRepository todoListRepository;

	@Test
	void savingList() {
		var dto  = new TodoListDto("Test list", "Test description", "#121212");
		var list = todoService.createList(dto);
		assertEquals(dto, list);
		verify(todoListRepository, times(1)).save(argThat(arg -> arg.getTitle()
		                                                            .equals(dto.getTitle())));
	}


	@Test
	void savingExistingList() {
		var dto = new TodoListDto("Test list", "Test description", "#121212");


		when(todoListRepository.existsByTitle(dto.getTitle())).thenReturn(true);

		assertThrows(
				IllegalArgumentException.class,
				() -> todoService.createList(dto),
				"Cannot save list with existing title"
		);
		verify(todoListRepository, never()).save(argThat(arg -> arg.getTitle()
		                                                           .equals(dto.getTitle())));
	}

	@Test
	void deleteList() {
		when(todoListRepository.existsByTitle("yikker")).thenReturn(true);
		todoService.deleteList("yikker");
		verify(todoListRepository, times(1)).deleteByTitle("yikker");
	}

	@Test
	void deleteNonExisting() {
		when(todoListRepository.existsByTitle("test")).thenReturn(false);
		assertThrows(IllegalArgumentException.class, () -> todoService.deleteList("test"));
	}

	@Test
	void updating() {
		var list = new TodoListDto("name2", "desc", null);
		var inDb = new TodoList();
		inDb.setTitle("name");
		inDb.setDescription("desc2");
		inDb.setColor("#123123");

		inDb = spy(inDb);
		when(todoListRepository.existsByTitle("name")).thenReturn(true);
		when(todoListRepository.findByTitle("name")).thenReturn(inDb);

		todoService.updateList("name", list);

		verify(inDb, times(1)).setTitle("name2");
		verify(inDb, times(1)).setDescription("desc");
		verify(inDb, never()).setColor(any());
	}

	@Test
	void setDone() {
		var listname = "list";
		var entry    = spy(new TodoEntry());
		entry.setDone(false);
		entry.setName("item");
		entry.setDueTo(LocalDate.now().plusDays(2));

		when(todoListRepository.existsByTitle(listname)).thenReturn(true);
		when(todoRepository.existsByNameAndListTitle(entry.getName(), listname)).thenReturn(true);
		when(todoRepository.existsByNameAndListTitle("item", listname)).thenReturn(true);
		when(todoRepository.findByNameAndListTitle("item", listname)).thenReturn(entry);
		todoService.setDone(listname, "item", true);
		verify(entry, times(1)).setDone(true);
	}
}