package com.gabrielbernalle.taskmanager.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.gabrielbernalle.taskmanager.enums.StatusEnum;

public record TaskResponseDTO (
	UUID id,
	String title,
	String description,
	StatusEnum status,
	LocalDateTime creationDate
) {}