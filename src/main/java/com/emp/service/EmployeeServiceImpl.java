package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.EmployeeDao;
import com.emp.model.Employee;

import jakarta.transaction.Transactional;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao dao;

	@Override
	public List<Employee> showEmployee() {
		List<Employee> empList = dao.showEmployee();
		return empList;
	}

	@Transactional
	@Override
	public int addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return dao.addEmployee(emp);
	}
     
	@Override
	@Transactional
	public Employee deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
		return dao.deleteEmployee(id);
	}

	@Override
	@Transactional
	public int updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		return dao.updateEmployee(emp);
	}

}
