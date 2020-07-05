package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Employee;
import com.util.DBConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	PreparedStatement preparedStatment = null;
	

	@Override
	public List<Employee> get() {
		
		//create reference variables
		
		List<Employee> list = null;
		Employee employee = null;
		
		try {
			list = new ArrayList<Employee>();
			String sql = "SELECT * FROM tbl_employee";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(sql);
			while(resultset.next()) {
				employee = new Employee();
				employee.setId(resultset.getInt("id"));
				employee.setName(resultset.getString("name"));
				employee.setDob(resultset.getString("dob"));
				employee.setDepartment(resultset.getString("department"));
				
				list.add(employee);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public boolean save(Employee e) {
		
		boolean flag=false;
		try {
			String sql="insert into tbl_employee(name,dob,department)values('"+e.getName()+"','"+e.getDob()+"','"+e.getDepartment()+"')";
			connection=DBConnectionUtil.openConnection();
			preparedStatment=connection.prepareStatement(sql);
			preparedStatment.executeUpdate();
			flag=true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
		
	}

}
