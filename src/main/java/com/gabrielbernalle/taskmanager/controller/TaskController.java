package com.gabrielbernalle.taskmanager.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielbernalle.taskmanager.dtos.TaskRequestDTO;
import com.gabrielbernalle.taskmanager.dtos.TaskResponseDTO;
import com.gabrielbernalle.taskmanager.dtos.TaskStatusRequestDTO;
import com.gabrielbernalle.taskmanager.entities.Task;
import com.gabrielbernalle.taskmanager.mapper.TaskMapper;
import com.gabrielbernalle.taskmanager.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	
	@GetMapping
	public List<TaskResponseDTO> allTasks(){
		List<Task> allTasks = taskService.getTasks();
		
		return allTasks.stream()
				.map(task -> TaskMapper.mapToTaskResponseDTO(task))
				.toList();
	}
	
	@PostMapping
	public TaskResponseDTO newTask(@Valid @RequestBody TaskRequestDTO requestDto) {
		return TaskMapper.mapToTaskResponseDTO(taskService.addTask(TaskMapper.mapToTask(requestDto)));
	}
	
	@GetMapping("{id}")
	public TaskResponseDTO oneTask(@PathVariable UUID id) {
		return TaskMapper.mapToTaskResponseDTO(taskService.findById(id));
	}
	
	@PutMapping("{id}")
	public TaskResponseDTO replaceTask(@Valid @RequestBody TaskRequestDTO newTask, @PathVariable UUID id) {
		return TaskMapper.mapToTaskResponseDTO(taskService.replaceTask(newTask, id));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTask(@PathVariable UUID id) {
		taskService.deleteById(id);		
	}
	
	@PatchMapping("{id}")
	public TaskResponseDTO updateTask(@Valid @RequestBody TaskStatusRequestDTO updateStatus, @PathVariable UUID id) {
		return TaskMapper.mapToTaskResponseDTO(taskService.updateTask(updateStatus,id));
	}
	
}
