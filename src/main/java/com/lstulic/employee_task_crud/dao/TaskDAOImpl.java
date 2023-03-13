package com.lstulic.employee_task_crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lstulic.employee_task_crud.entity.Task;

import jakarta.persistence.EntityManager;

@Repository
public class TaskDAOImpl implements TaskDAO {

	private EntityManager entityManager;

	@Autowired
	public TaskDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Task> findAll() {

		Session currentSession = this.entityManager.unwrap(Session.class);

		Query<Task> theQuery = currentSession.createQuery("from Task", Task.class);

		List<Task> tasks = theQuery.getResultList();

		return tasks;

	}

	@Override
	public Task findById(int theId) {

		Session currentSession = this.entityManager.unwrap(Session.class);

		Task task = currentSession.get(Task.class, theId);

		return task;

	}

	@Override
	public void save(Task theTask) {

		Session currentSession = this.entityManager.unwrap(Session.class);

		currentSession.merge(theTask);

	}

	@Override
	public void delete(Task theTask) {
		Session currentSession = this.entityManager.unwrap(Session.class);

		currentSession.remove(theTask);

	}

}
