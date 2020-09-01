package com.todolist.entity;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name = "task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull(message = "タイトルは空白にできません!")
	@NotEmpty(message = "タイトルは空白にできません!")
	@Size
	@Column(name = "title")
	private String title;
	@NotNull(message = "内容は空白にできません!")
	@NotEmpty(message = "内容は空白にできません!")
	@Size
	@Column(name = "description")
	private String description;
	@NotNull(message = "予定日は空白にできません!")
	@NotEmpty(message = "予定日は空白にできません!")
	@Column(name = "scheduled_date")
	private String scheduled_date;
	@NotNull(message = "完了日は空白にできません!")
	@NotEmpty(message = "完了日は空白にできません!")
	@Column(name = "completed_date")
	private String completed_date;
	@Column(name = "priority")
	private int priority;
	@Column(name = "created_at")
	private String created_at;
	@Column(name = "update_at")
	private String update_at;
	@Column(name = "delete_flag")
	private int delete_flag;
	@Column(name = "is_completed")
	private int is_completed;

	public Task() {
	}

	public Task(String title, String description, String scheduled_date, String completed_date, int priority,
			String created_at, String update_at, int delete_flag, int is_completed) {
		this.title = title;
		this.description = description;
		this.scheduled_date = scheduled_date;
		this.completed_date = completed_date;
		this.priority = priority;
		this.created_at = created_at;
		this.update_at = update_at;
		this.delete_flag = delete_flag;
		this.is_completed = is_completed;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getScheduled_date() {
		return scheduled_date;
	}

	public void setScheduled_date(String scheduled_date) {
		this.scheduled_date = scheduled_date;
	}

	public String getCompleted_date() {
		return completed_date;
	}

	public void setCompleted_date(String completed_date) {
		this.completed_date = completed_date;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}

	public int getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(int delete_flag) {
		this.delete_flag = delete_flag;
	}

	public int getIs_completed() {
		return is_completed;
	}

	public void setIs_completed(int is_completed) {
		this.is_completed = is_completed;
	}

	

}


