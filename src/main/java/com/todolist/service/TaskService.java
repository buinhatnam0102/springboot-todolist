package com.todolist.service;

import java.util.List;
import java.util.Optional;

import com.todolist.entity.Task;

public interface TaskService {
	List<Task> getAllTask();

	void saveTask(Task task);

	void deleteTask(int id);

	public Task get(int id);

	Optional<Task> findTaskByID(int id);

	List<Task> getTaskUncomplete();

	List<Task> getTaskCompleted();
}

