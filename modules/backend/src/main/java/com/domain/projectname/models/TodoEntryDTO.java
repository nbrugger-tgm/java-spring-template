package com.domain.projectname.models;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class TodoEntryDTO {
	@NonNull
	private String    name;
	private boolean   done  = false;
	private LocalDate dueTo = null;
}
