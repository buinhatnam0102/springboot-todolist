package com.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.todolist.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {
	@Query(value = "SELECT * FROM task AS t WHERE t.is_completed = 0 and t.delete_flg=0", nativeQuery = true)
	public List<Task> findTaskUnComplete();

	@Query(value = "SELECT * FROM task AS t WHERE t.is_completed = 1 and t.delete_flg=0", nativeQuery = true)
	public List<Task> findTaskCompleted();
}