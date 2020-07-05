package com.dao;

import java.util.List;

import com.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> get();
	
	boolean save(Employee e);

}
