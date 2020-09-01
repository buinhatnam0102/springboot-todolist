package com.todolist.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.todolist.entity.Task;
import com.todolist.service.TaskService;

@Controller

public class TaskController {
	@Autowired
	private TaskService taskService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	List<Task> listComplete = new ArrayList<>();
	List<Task> listUnComplete = new ArrayList<>();

	@RequestMapping("/")
	public String index(Model model) {
		
	
		List<Task> tasks = taskService.getAllTask();
		listComplete = new ArrayList<>();
		listUnComplete = new ArrayList<>();
		for (Task task : tasks) {
			if (task.getDelete_flag() == 0) {
				if (task.getIs_completed()== 1) {
					listComplete.add(task);
				} else {
					listUnComplete.add(task);
				}
			}
		}

		sortTaskCompleted(listComplete);
		sortTaskUncomplete(listUnComplete);

		model.addAttribute("listTasksComplete", listComplete);
		model.addAttribute("listTasksUnComplete", listUnComplete);
		return "index";
	}

	@RequestMapping(value = "add")
	public String addTask(Model model) {
		model.addAttribute("task", new Task());
		return "addTask";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editTask(@RequestParam("id") int taskId, Model model) {
		Optional<Task> taskEdit = taskService.findTaskByID(taskId);
		taskEdit.ifPresent(task -> model.addAttribute("task", task));
		return "editTask";

	}

	@RequestMapping(value = "/complete", method = RequestMethod.GET)
	public String complete(@RequestParam("id") int taskId, Model model) {
		Task task = taskService.get(taskId);
		task.setIs_completed(1);
		taskService.saveTask(task);
		return "redirect:/";

	}
	@RequestMapping(value = "/uncomplete", method = RequestMethod.GET)
	public String uncomplete(@RequestParam("id") int taskId, Model model) {
		Task task = taskService.get(taskId);
		task.setIs_completed(0);
		taskService.saveTask(task);
		return "redirect:/";
	}

	/*
	 * @RequestMapping(value = "save", method = RequestMethod.POST) public String
	 * save(@Valid Task task, Errors errors, Model model) { if (null != errors &&
	 * errors.getErrorCount() > 0) { return "redirect:/"; } else {
	 * 
	 * return "index"; } }
	 */
	
	  public String save(Task task) { taskService.saveTask(task);
	  
	  return "redirect:/";
	
	}
 
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteTask(@RequestParam("id") int taskId, Model model) {
		Task task = taskService.get(taskId);
		task.setDelete_flag(1);
		taskService.saveTask(task);
		return "redirect:/";
		/*
		 * taskService.deleteTask(taskId);
		 * 
		 * return "redirect:/";
		 */
	}

	public void sortTaskUncomplete(List<Task> task) {
		Collections.sort(task, new Comparator<Task>() {
			@Override
			public int compare(Task task1, Task task2) {
				Date curday = new Date();
				Date date1 = null;
				Date date2 = null;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					date1 = sdf.parse(task1.getScheduled_date());
					date2 = sdf.parse(task2.getScheduled_date());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if ((date1.getTime() - curday.getTime() > (date2).getTime() - curday.getTime())) {
					return 1;

				} else if ((date1.getTime() - curday.getTime() < (date2).getTime() - curday.getTime())) {
					return -1;

				} else {
					return 0;
				}

			}

		});

	}

	public void sortTaskCompleted(List<Task> task) {
		Collections.sort(task, new Comparator<Task>() {

			@Override
			public int compare(Task task1, Task task2) {

				return task2.getCompleted_date().compareTo(task1.getCompleted_date());
			}
		});
	}
}

