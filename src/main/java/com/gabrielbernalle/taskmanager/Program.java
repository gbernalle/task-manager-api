package com.gabrielbernalle.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gabrielbernalle.taskmanager.entities.Task;
import com.gabrielbernalle.taskmanager.service.TaskService;

@SpringBootApplication
public class Program {

	public static void main(String[] args) {
		SpringApplication.run(Program.class, args);
		
		TaskService task1 = new TaskService();
		
		task1.addTask(new Task("Teste1","primeiro teste"));
		
		System.out.println(task1.getBd());
	}

}
