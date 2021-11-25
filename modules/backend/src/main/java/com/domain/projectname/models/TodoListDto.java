package com.domain.projectname.models;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class TodoListDto {
	@NotNull
	@NotBlank
	@NonNull
	@Size(min = 2, max = 64)
	private String title;

	@Size(max = 2048)
	private String description;

	@Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$", message = "Invalid color")
	@NotNull
	private String color = "#32a852";
}