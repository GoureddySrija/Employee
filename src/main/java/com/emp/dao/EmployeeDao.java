package com.emp.dao;

import java.util.List;

import com.emp.model.Employee;

public interface EmployeeDao {
  List<Employee> showEmployee();
  int addEmployee(Employee emp);
  Employee deleteEmployee(int id);
  int updateEmployee(Employee emp);
}
