package com.lstulic.employee_task_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

	@GetMapping("/")
	public String list_employees() {
		return "list_employees";
	}

	@GetMapping("/employee_form.html")
	public String employee_form() {
		return "employee_form";
	}

	@GetMapping("/list_tasks.html")
	public String list_tasks() {
		return "list_tasks";
	}

	@GetMapping("/task_form.html")
	public String task_form() {
		return "task_form";
	}

}
