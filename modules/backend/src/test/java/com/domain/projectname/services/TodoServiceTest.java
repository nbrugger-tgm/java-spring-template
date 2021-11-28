package com.domain.projectname.services;

import com.domain.projectname.entities.todo.TodoEntry;
import com.domain.projectname.entities.todo.TodoList;
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
	ModelMapper mapper = new ModelMapper();
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
		var list = new TodoListDto("name", "desc", null);
		when(todoListRepository.existsByTitle("name")).thenReturn(true);
		var inDb = new TodoList();
		inDb.setTitle("name");
		inDb.setDescription("desc2");
		inDb.setColor("#123123");
		when(todoListRepository.findByTitle("name")).thenReturn(inDb);
		todoService.updateList("name", list);

		var expectedOverwritten = new TodoList();
		expectedOverwritten.setTitle("name");
		expectedOverwritten.setDescription("desc");
		expectedOverwritten.setColor("#123123");
		verify(todoListRepository, times(1)).save(expectedOverwritten);
	}

	@Test
	void setDone() {
		var entry = spy(new TodoEntry());
		entry.setDone(false);
		entry.setName("item");
		entry.setDueTo(LocalDate.now().plusDays(2));

		when(todoListRepository.existsByTitle("list")).thenReturn(true);
		when(todoListRepository.getIdByTitle("list")).thenReturn(123L);
		when(todoRepository.existsByNameAndListId("item", 123L)).thenReturn(true);
		when(todoRepository.findByNameAndListId("item", 123L)).thenReturn(entry);
		todoService.setDone("list", "item", true);
		verify(entry, times(1)).setDone(true);
	}
}