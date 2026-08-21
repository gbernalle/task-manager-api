package com.gabrielbernalle.taskmanager.dtos;

import com.gabrielbernalle.taskmanager.enums.StatusEnum;

public record TaskStatusRequestDTO(
		StatusEnum status	
) {}
