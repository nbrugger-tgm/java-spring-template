package com.domain.projectname.repositories;

import com.domain.projectname.entities.todo.TodoEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<TodoEntry, Long> {
	TodoEntry findByName(String itemName);
}
