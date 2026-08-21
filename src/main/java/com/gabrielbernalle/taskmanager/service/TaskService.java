package com.gabrielbernalle.taskmanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gabrielbernalle.taskmanager.entities.Task;
import com.gabrielbernalle.taskmanager.exceptions.ResourceNotFoundException;
import com.gabrielbernalle.taskmanager.repository.TaskRepository;

@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<Task> getBd() {
		return taskRepository.findAll();
	}
	
	public Task findById(UUID id) {
		return taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task not found with ID: " + id));
	}
	
	public void deleteById(UUID id) {
		Task existingTask = this.findById(id);
		taskRepository.delete(existingTask);
	}

	public Task addTask(Task task) {
		return taskRepository.save(task);
	}
	
}
