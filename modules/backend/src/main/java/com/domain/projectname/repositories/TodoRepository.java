package com.domain.projectname.repositories;

import com.domain.projectname.entities.todo.TodoEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Repository
public interface TodoRepository extends CrudRepository<TodoEntry, Long> {

	void deleteByNameAndListTitle(String name, String list);

	boolean existsByNameAndListTitle(
			@NotNull String name,
			String listTitle
	);

	@Override
	Set<TodoEntry> findAll();

	TodoEntry findByNameAndListTitle(String itemName, String listId);

	Set<TodoEntry> findAllByListId(long listId);
}
