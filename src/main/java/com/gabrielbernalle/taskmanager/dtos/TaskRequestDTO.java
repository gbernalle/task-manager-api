package com.gabrielbernalle.taskmanager.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record TaskRequestDTO (
	@NotBlank(message = "Title cannot be empty")
	@Size(min = 3, max=20, message="Title must be between 3 and 20 characters")
	String title,
	@Size(max = 500)
	String description
) {}
