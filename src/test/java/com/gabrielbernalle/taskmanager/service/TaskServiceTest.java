package com.gabrielbernalle.taskmanager.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gabrielbernalle.taskmanager.entities.Task;
import com.gabrielbernalle.taskmanager.exceptions.ResourceNotFoundException;
import com.gabrielbernalle.taskmanager.repository.TaskRepository;

import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

	@Mock
	private TaskRepository taskRepository;
	
	@InjectMocks
	private TaskService taskService;
	
	@Test
	public void shouldCreateTaskSuccessfully() {
		Task newTask = new Task();
		newTask.setTitle("Criando primeiro Teste");
		newTask.setDescription("TODO");
		
		Task savedTask = new Task();
		savedTask.setId(UUID.randomUUID());
		savedTask.setTitle("Criando primeiro Teste");
		savedTask.setDescription("TODO");
		
		
		when(taskRepository.save(any(Task.class))).thenReturn(savedTask);
		
		//Act
		Task result = taskService.addTask(newTask);
		
		//Assert
		assertNotNull(result.getId());
		assertEquals("Criando primeiro Teste", result.getTitle());
		
		verify(taskRepository, times(1)).save(newTask);
		
	}
	
	@Test
	public void shouldReturnTaskWhenFoundById() {
		UUID id = UUID.randomUUID();
		Task task = new Task();
		task.setId(id);
		task.setTitle("Tarefa encontrada");
		
		when(taskRepository.findById(id)).thenReturn(Optional.of(task));
		
		//Act
		Task result = taskService.findById(id);
		
		//Assert
		assertNotNull(result.getId());
		assertEquals(id, result.getId());
		assertEquals("Tarefa encontrada", result.getTitle());
	}
	
	@Test
	public void shouldThrowResourceNotFoundExceptionWhenTaskNotFound() {
		UUID id = UUID.randomUUID();
		
		when(taskRepository.findById(id)).thenReturn(Optional.empty());
		
		//Assert
		assertThrows(ResourceNotFoundException.class, () -> {
			taskService.findById(id);
		});	
	}
	
	
}
