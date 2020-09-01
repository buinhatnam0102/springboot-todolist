package com.todolist.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.entity.Task;
import com.todolist.repository.TaskRepository;
import com.todolist.service.TaskService;


@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return (List<Task>) taskRepository.findAll();
	}

	@Override
	public void saveTask(Task task) {
		taskRepository.save(task);
	}

	@Override
	public void deleteTask(int id) {
		taskRepository.deleteById(id);

	}

	@Override
	public List<Task> getTaskUncomplete() {
		// TODO Auto-generated method stub
		return taskRepository.findTaskUnComplete();
	}

	@Override
	public List<Task> getTaskCompleted() {
		// TODO Auto-generated method stub
		return taskRepository.findTaskCompleted();
	}

	@Override
	public Task get(int id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id).get();
	}

	@Override
	public Optional<Task> findTaskByID(int id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id);
	}

}