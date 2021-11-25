package com.domain.projectname.repositories;

import com.domain.projectname.entities.todo.TodoEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Repository
public interface TodoRepository extends CrudRepository<TodoEntry, Long> {
	TodoEntry findByName(@NotNull String itemName);

	void deleteByNameAndListId(@NotNull String name, long listId);

	boolean existsByNameAndListId(@NotNull String itemName, long listId);


	@Override
	Set<TodoEntry> findAll();

	TodoEntry findByNameAndListId(String itemName, long listId);

	Set<TodoEntry> findAllByListId(long listId);
}
