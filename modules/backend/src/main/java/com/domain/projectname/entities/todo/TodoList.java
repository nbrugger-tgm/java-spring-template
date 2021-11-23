package com.domain.projectname.entities.todo;

import com.domain.projectname.entities.BaseEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class TodoList extends BaseEntity {
	@Column(unique = true, nullable = false)
	private String title;
	private String description;

	@Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$", message = "Invalid color")
	@NotNull
	private String color = "#32a852";


	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Set<TodoEntry> entries = new HashSet<>();

	public void addItem(TodoEntry item) {
		entries.add(item);
	}

	public void removeItem(TodoEntry item) {
		entries.remove(item);
	}
}