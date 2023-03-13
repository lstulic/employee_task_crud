package com.lstulic.employee_task_crud.service;

import java.util.List;

import com.lstulic.employee_task_crud.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee theEmployee);

	public void delete(Employee theEmployee);

	public List<Object[]> findTop5();
}
