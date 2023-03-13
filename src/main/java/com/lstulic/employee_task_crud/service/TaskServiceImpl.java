package com.lstulic.employee_task_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lstulic.employee_task_crud.dao.TaskDAO;
import com.lstulic.employee_task_crud.entity.Task;

@Service
public class TaskServiceImpl implements TaskService {

	private TaskDAO taskDAO;

	@Autowired
	public TaskServiceImpl(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

	@Override
	@Transactional
	public List<Task> findAll() {
		return this.taskDAO.findAll();
	}

	@Override
	@Transactional
	public Task findById(int theId) {
		return this.taskDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Task theTask) {
		this.taskDAO.save(theTask);
	}

	@Override
	@Transactional
	public void delete(Task theTask) {
		this.taskDAO.delete(theTask);
	}

}
