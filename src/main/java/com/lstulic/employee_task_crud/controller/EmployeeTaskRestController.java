package com.lstulic.employee_task_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lstulic.employee_task_crud.entity.Employee;
import com.lstulic.employee_task_crud.entity.Task;
import com.lstulic.employee_task_crud.service.EmployeeService;
import com.lstulic.employee_task_crud.service.TaskService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class EmployeeTaskRestController {

	private EmployeeService employeeService;
	private TaskService taskService;

	@Autowired
	public EmployeeTaskRestController(EmployeeService employeeService, TaskService taskService) {
		this.employeeService = employeeService;
		this.taskService = taskService;
	}

	@GetMapping("/employees")
	public List<Employee> findAllEmployees() {
		return this.employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {

		Employee theEmployee = this.employeeService.findById(employeeId);

		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}

		return theEmployee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {

		theEmployee.setId(0);

		this.employeeService.save(theEmployee);

		return theEmployee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {

		this.employeeService.save(theEmployee);

		return theEmployee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {

		Employee tempEmployee = this.employeeService.findById(employeeId);

		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}

		this.employeeService.delete(tempEmployee);

		return "Deleted employee id - " + employeeId;
	}

	@GetMapping("/employees/top5")
	public List<Object[]> findTop5() {
		return this.employeeService.findTop5();
	}

	@GetMapping("/tasks")
	public List<Task> findAllTasks() {
		return this.taskService.findAll();
	}

	@GetMapping("/tasks/{taskId}")
	public Task getTask(@PathVariable int taskId) {

		Task theTask = this.taskService.findById(taskId);

		if (theTask == null) {
			throw new RuntimeException("Task id not found - " + taskId);
		}

		return theTask;
	}

	@PostMapping("/tasks/{employeeId}")
	public Task addTask(@RequestBody Task theTask, @PathVariable int employeeId) {

		theTask.setId(0);

		Employee theEmployee = this.employeeService.findById(employeeId);
		theEmployee.add(theTask);

		this.employeeService.save(theEmployee);

		return theTask;
	}

	@PutMapping("/tasks")
	public Task updateTask(@RequestBody Task theTask) {

		this.taskService.save(theTask);

		return theTask;
	}

	@DeleteMapping("/tasks/{taskId}")
	public String deleteTask(@PathVariable int taskId) {

		Task tempTask = this.taskService.findById(taskId);

		if (tempTask == null) {
			throw new RuntimeException("Task id not found - " + taskId);
		}

		this.taskService.delete(tempTask);

		return "Deleted task id - " + taskId;
	}

}
