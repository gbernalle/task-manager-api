package com.gabrielbernalle.taskmanager.mapper;

import com.gabrielbernalle.taskmanager.dtos.TaskRequestDTO;
import com.gabrielbernalle.taskmanager.dtos.TaskResponseDTO;
import com.gabrielbernalle.taskmanager.entities.Task;

public class TaskMapper {
	
	public static TaskResponseDTO mapToTaskResponseDTO(Task task) {
		TaskResponseDTO taskResponseDTO = new TaskResponseDTO(
				task.getId(),
				task.getTitle(),
				task.getDescription(),
				task.getStatus(),
				task.getCreationDate()
		);
		return taskResponseDTO;	
	}
	
	public static Task mapToTask(TaskRequestDTO taskRequestDTO) {
		Task task = new Task(
				taskRequestDTO.title(),
				taskRequestDTO.description()
		);
		
		return task;
	}
}
