package com.gabrielbernalle.taskmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielbernalle.taskmanager.entities.User;

public interface UserRepository extends JpaRepository<User, Long>  {
	Optional<User> findByEmail(String email);
}
