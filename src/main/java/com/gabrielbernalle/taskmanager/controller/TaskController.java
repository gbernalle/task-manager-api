package com.gabrielbernalle.taskmanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielbernalle.taskmanager.entities.Task;
import com.gabrielbernalle.taskmanager.service.TaskService;

@RestController
public class TaskController {
	
	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	
	@GetMapping("/tasks")
	public List<Task> allTasks(){
		return taskService.getBd();
	}
	
	@PostMapping("/tasks")
	public Task newTask(@RequestBody Task newTask) {
		taskService.addTask(newTask);
		return taskService.getById(newTask);
	}
	
}
