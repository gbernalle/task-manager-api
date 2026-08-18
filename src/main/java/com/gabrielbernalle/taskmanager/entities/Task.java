package com.gabrielbernalle.taskmanager.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.gabrielbernalle.taskmanager.enums.StatusEnum;

public class Task {
	private UUID id = UUID.randomUUID();
	private String title;
	private String description;
	private StatusEnum status = StatusEnum.PENDENTE;
	private LocalDateTime creationDate = LocalDateTime.now();
	
	public Task() {
		
	}
	
	public Task(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public UUID getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(creationDate, description, id, status, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(creationDate, other.creationDate) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && status == other.status && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", creationDate=" + creationDate + "]";
	}

}
