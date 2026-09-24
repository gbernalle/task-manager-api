package com.gabrielbernalle.taskmanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielbernalle.taskmanager.dtos.TaskRequestDTO;
import com.gabrielbernalle.taskmanager.dtos.TaskStatusRequestDTO;
import com.gabrielbernalle.taskmanager.entities.Task;
import com.gabrielbernalle.taskmanager.exceptions.ResourceNotFoundException;
import com.gabrielbernalle.taskmanager.repository.TaskRepository;

@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Transactional(readOnly = true)
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Task findById(UUID id) {
		return taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task not found with ID: " + id));
	}
	
	@Transactional
	public void deleteById(UUID id) {
		Task existingTask = this.findById(id);
		taskRepository.delete(existingTask);
	}

	@Transactional
	public Task addTask(Task task) {
		return taskRepository.save(task);
	}
	
	@Transactional
	public Task replaceTask(TaskRequestDTO newTask, UUID id) {
		Task existingTask = findById(id);

		existingTask.setTitle(newTask.title());
		existingTask.setDescription(newTask.description());
		
		return existingTask;
	}
	
	@Transactional
	public Task updateTask(TaskStatusRequestDTO updateStatus, UUID id) {
		Task existingTask = findById(id);
		existingTask.setStatus(updateStatus.status());
		
		return existingTask;
	}
	
}
