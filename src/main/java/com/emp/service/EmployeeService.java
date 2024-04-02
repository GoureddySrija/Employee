package com.emp.service;

import java.util.List;

import com.emp.model.Employee;

public interface EmployeeService {
	List<Employee> showEmployee();
	  int addEmployee(Employee emp);
	  Employee deleteEmployee(int id);
	  int updateEmployee(Employee emp);
}
