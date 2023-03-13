package com.lstulic.employee_task_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lstulic.employee_task_crud.dao.EmployeeDAO;
import com.lstulic.employee_task_crud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return this.employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return this.employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		this.employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void delete(Employee theEmployee) {
		this.employeeDAO.delete(theEmployee);
	}

	@Override
	public List<Object[]> findTop5() {
		return this.employeeDAO.findTop5();
	}

}
