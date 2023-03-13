package com.lstulic.employee_task_crud.dao;

import java.util.List;

import com.lstulic.employee_task_crud.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee theEmployee);

	public void delete(Employee theEmployee);

	public List<Object[]> findTop5();

}
