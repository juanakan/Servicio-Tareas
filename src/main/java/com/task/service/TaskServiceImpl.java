package com.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.model.Task;
import com.task.repository.TaskRepository;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
    private TaskRepository taskRepository;
	
	@Override
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Optional<Task> getTaskById(long id) {
		return taskRepository.findById(id);
	}
	
	@Override
	public Iterable<Task> getAllTasks() {
	    return taskRepository.findAll();
	}
	
	@Override
	public Iterable<Task> getByUserId(long idUser) {
		return taskRepository.findByUserId(idUser);
	}
	
	@Override
	public Task updateTask(Task task) {
	    return taskRepository.save(task);
	}
	
	@Override
	public void deleteTask(long id) {
	    taskRepository.deleteById(id);
	}


}

