package com.gabrielbernalle.taskmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gabrielbernalle.taskmanager.entities.Task;

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
	
	public Task getById(Task task) {
		for (Task tk : bd) {
			if(tk.getId().equals(task.getId())) {
				return tk;
			}
		}
		return null;
	}
	
	public Task findById(UUID id) {
		for (Task tk : bd) {
			if(tk.getId().equals(id)) {
				return tk;
			}
		}
		return null;
	}

	public void addTask(Task task) {
		bd.add(task);
	}
	
}
