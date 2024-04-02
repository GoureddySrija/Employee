package com.emp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.emp.model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Employee> showEmployee() {
		jakarta.persistence.TypedQuery<Employee> emptqury=em.createQuery("select emp from Employee emp",Employee.class);
		List<Employee> empList = emptqury.getResultList();
		Iterator<Employee> c = empList.iterator();
		while(c.hasNext()) {
			System.out.println(c.next());
		}
		return empList;
	}
	@Override
	public int addEmployee(Employee emp) {
		em.persist(emp);
		return emp.getId();
	}
	@Override
	public Employee deleteEmployee(int id) {
		Employee emp = em.find(Employee.class,id);
	
			em.remove(emp);
		return emp;
	}
	@Override
	public int updateEmployee(Employee emp) {
		em.merge(emp);
		return emp.getId();
	}

}
