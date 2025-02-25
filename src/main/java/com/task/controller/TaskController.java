package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.Task;
import com.task.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Tareas", description = "API para gestionar tareas")
public class TaskController {

	@Autowired
    private TaskService taskService;

    @PostMapping("/create")
    @Operation(summary = "Crear una tarea", description = "Crea una tarea nueva")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener tarea", description = "Obtiene una tarea por su ID")
    public Task getTaskById(@PathVariable long id) {
        return taskService.getTaskById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @GetMapping("/")
    @Operation(summary = "Obtener todas las tareas", description = "Devuelve una lista de las tareas")
    public Iterable<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PutMapping("/modify/{id}")
    @Operation(summary = "Actualizar una tarea", description = "Modifica una tarea existente")
    public Task updateTask(@PathVariable long id, @RequestBody Task task) {
        task.setId(id);
        return taskService.updateTask(task);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Eliminar una tarea", description = "Elimina una tarea por su ID")
    public void deleteTask(@PathVariable long id) {
        taskService.deleteTask(id);
    }
}