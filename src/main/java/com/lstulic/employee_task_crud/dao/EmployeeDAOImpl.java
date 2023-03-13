package com.lstulic.employee_task_crud.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lstulic.employee_task_crud.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {

		Session currentSession = this.entityManager.unwrap(Session.class);

		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int theId) {

		Session currentSession = this.entityManager.unwrap(Session.class);

		Employee theEmployee = currentSession.get(Employee.class, theId);

		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		Session currentSession = this.entityManager.unwrap(Session.class);
		System.out.println(theEmployee.getTasks());

		currentSession.merge(theEmployee);
	}

	@Override
	public void delete(Employee theEmployee) {

		Session currentSession = this.entityManager.unwrap(Session.class);

		currentSession.remove(theEmployee);
	}

	@Override
	public List<Object[]> findTop5() {
		Session currentSession = this.entityManager.unwrap(Session.class);

		LocalDate localDate = LocalDate.now();
		localDate = localDate.minusMonths(1);

		Date startDate = Date.valueOf(localDate);
		Date endDate = Date.valueOf(LocalDate.now());

		String hql = "SELECT E, COUNT(T.id) " + "FROM Employee E INNER JOIN E.tasks T "
				+ "WHERE T.dueDate BETWEEN :startDate AND :endDate " + "GROUP BY E.id " + "ORDER BY COUNT(T.id) DESC";

		Query<Object[]> query = currentSession.createQuery(hql, Object[].class).setParameter("startDate", startDate)
				.setParameter("endDate", endDate).setMaxResults(5);

		List<Object[]> results = query.getResultList();

		return results;
	}

}
