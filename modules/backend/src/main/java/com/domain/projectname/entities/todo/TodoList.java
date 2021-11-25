package com.domain.projectname.entities.todo;

import com.domain.projectname.entities.BaseEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

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

	@OneToMany(cascade = ALL, mappedBy = "list")
	private Set<TodoEntry> entries = new HashSet<>();

	public boolean addItem(TodoEntry item) {
		item.setList(this);
		return entries.add(item);
	}

	public boolean removeItem(TodoEntry item) {
		return entries.remove(item);
	}
}