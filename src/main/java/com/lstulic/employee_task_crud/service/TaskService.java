package com.lstulic.employee_task_crud.service;

import java.util.List;

import com.lstulic.employee_task_crud.entity.Task;

public interface TaskService {

	public List<Task> findAll();

	public Task findById(int theId);

	public void save(Task theTask);

	public void delete(Task theTask);

}
