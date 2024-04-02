package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.service.EmployeeService;
@RequestMapping(value="/employee")
@RestController
public class EmployeeController {
	@Autowired
    private EmployeeService esrc;
	
	@PostMapping(value="/add", consumes="application/json", produces="application/json")
	ResponseEntity<Employee> addEmployee(@RequestBody Employee empy){
		int id =esrc.addEmployee(empy);
		System.out.println("employee with "+id+" is added");
		return ResponseEntity.ok(empy);
	}
    @GetMapping(value="/show",produces="application/json")
    public ResponseEntity<List<Employee>> showEmployee(){
    	List<Employee> employee= esrc.showEmployee();
    	if(employee.isEmpty()) {
    		return new ResponseEntity("Sorry! Employees not available!",HttpStatus.NOT_FOUND);
    		
    	}
    	return new ResponseEntity<List<Employee>>(employee,HttpStatus.OK);
    }
    @DeleteMapping(path="/delete/{id}", produces ="application/json")
    ResponseEntity<Employee> deleteEmployee(@PathVariable("id")int id){
    	Employee employee = esrc.deleteEmployee(id);
    	System.out.println("employee with" +id+ "is deleted");
    	return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
    
    @PutMapping(path="/update/{id}", consumes="application/json")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee empy){
    	int id = esrc.updateEmployee(empy);
    	System.out.println("employee with" +id+ "is updated");
    	
    		return new ResponseEntity("Employee is updates!", HttpStatus.OK);
    	
    }
}
