package com.domain.projectname.entities.todo;

import com.domain.projectname.entities.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class TodoEntry extends BaseEntity {
	@Column(nullable = false, unique = true)
	@NotNull
	private String    name;
	private boolean   done  = false;
	private LocalDate dueTo = null;
}
