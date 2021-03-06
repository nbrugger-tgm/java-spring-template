package com.domain.projectname.models;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class TodoEntryDto {
	@NonNull
	private String    name;
	private boolean   done  = false;
	private LocalDate dueTo = null;
}
