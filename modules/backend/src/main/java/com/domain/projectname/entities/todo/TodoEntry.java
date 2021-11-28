package com.domain.projectname.entities.todo;

import com.domain.projectname.entities.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "TodoEntry", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"name", "list_id"})
})
public class TodoEntry extends BaseEntity {
	@NotNull
	@Column(nullable = false)
	private String    name;
	private boolean   done  = false;
	private LocalDate dueTo = null;
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false, name = "list_id")
	private TodoList  list;
}
