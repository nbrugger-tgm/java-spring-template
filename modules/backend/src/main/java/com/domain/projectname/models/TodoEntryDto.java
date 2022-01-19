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
	private Boolean   done;
	private LocalDate dueTo = null;
}
