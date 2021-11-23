package com.domain.projectname.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Getter
	private long id;

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		BaseEntity that = (BaseEntity) o;
		return id == that.id;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "#" + id;
	}
}
