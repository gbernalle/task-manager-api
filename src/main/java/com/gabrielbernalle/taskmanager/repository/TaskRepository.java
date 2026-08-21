package com.gabrielbernalle.taskmanager.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gabrielbernalle.taskmanager.entities.Task;

public interface TaskRepository extends JpaRepository<Task, UUID> {

}
