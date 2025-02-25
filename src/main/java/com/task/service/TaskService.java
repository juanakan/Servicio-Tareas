package com.task.service;

import java.util.Optional;

import com.task.model.Task;

public interface TaskService {
	Task createTask(Task task);
	Optional<Task> getTaskById(long id);
	Iterable<Task> getAllTasks();
	Task updateTask(Task task);
	void deleteTask(long id);

}
