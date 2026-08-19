package com.gabrielbernalle.taskmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gabrielbernalle.taskmanager.entities.Task;
import com.gabrielbernalle.taskmanager.exceptions.ResourceNotFoundException;

@Service
public class TaskService {
	
	private List<Task> bd = new ArrayList<>();
	
	public TaskService() {
		
	}

	public TaskService(List<Task> bd) {
		this.bd = bd;
	}

	public List<Task> getBd() {
		return bd;
	}
	
	public Task findById(UUID id) {
		return bd.stream()
			.filter(tk -> tk.getId().equals(id))
			.findFirst()
			.orElseThrow(()-> new ResourceNotFoundException("Task not found with ID: " + id));
	}
	
	public void deleteById(UUID id) {
		bd.removeIf(tk -> tk.getId().equals(id));
	}

	public void addTask(Task task) {
		bd.add(task);
	}
	
}
