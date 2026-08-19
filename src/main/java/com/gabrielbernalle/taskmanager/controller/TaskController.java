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

import com.gabrielbernalle.taskmanager.entities.Task;
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
	public List<Task> allTasks(){
		return taskService.getBd();
	}
	
	@PostMapping
	public Task newTask(@Valid @RequestBody Task newTask) {
		taskService.addTask(newTask);
		return taskService.findById(newTask.getId());
	}
	
	@GetMapping("{id}")
	public Task oneTask(@PathVariable UUID id) {
		return taskService.findById(id);
	}
	
	@PutMapping("{id}")
	public Task replaceTask(@Valid @RequestBody Task newTask, @PathVariable UUID id) {
		Task existingTask = taskService.findById(id);
		
		existingTask.setTitle(newTask.getTitle());
		existingTask.setDescription(newTask.getDescription());
		
		return existingTask;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTask(@PathVariable UUID id) {
		taskService.deleteById(id);		
	}
	
	@PatchMapping("{id}")
	public Task updateTask(@Valid @RequestBody Task updateStatus, @PathVariable UUID id) {
		Task existingTask = taskService.findById(id);
		
		existingTask.setStatus(updateStatus.getStatus());
		
		return existingTask;
		
	}
	
}
