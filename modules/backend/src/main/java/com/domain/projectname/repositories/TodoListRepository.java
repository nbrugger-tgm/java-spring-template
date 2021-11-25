package com.domain.projectname.repositories;

import com.domain.projectname.entities.todo.TodoList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TodoListRepository extends CrudRepository<TodoList, Long> {
	TodoList findByTitle(String listName);

	boolean existsByTitle(String listName);

	long deleteByTitle(String title);

	Set<TodoList> findAll();

	@Query("select t.id from TodoList t where t.title = :title")
	long getIdByTitle(@Param("title") String title);
}
