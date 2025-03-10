package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	Iterable<Task> findByUserId(long idUser);

}

