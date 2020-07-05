package com.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.entity.Employee;


public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Create reference variable for employee
	
	EmployeeDAO employeeDAO = null;
	RequestDispatcher rd = null;
	
	//Create constructor and initialize employee dao
	
	public EmployeeController(){
		employeeDAO = new EmployeeDAOImpl();
	}
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action=request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		switch(action) {
		case "LIST": 
			listEmployees(request,response); //it will call listEmployee method of below
			break;
		default:
			listEmployees(request,response);
			break;
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("firstname");
		String dob = request.getParameter("dob");
		String department = request.getParameter("department");
		//System.out.println(firstname+dob+designation);
		
		Employee e = new Employee();
		e.setName(name);
		e.setDob(dob);
		e.setDepartment(department);
		employeeDAO.save(e);
		if(employeeDAO.save(e)) {
			request.setAttribute("message", "saved sucessfully");
		}
		listEmployees(request,  response);
		
	}
	
	public void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Call dao method to get list of employee
		
				List<Employee> list = employeeDAO.get();
				//System.out.println(list);
				
				
				//Add employee to request object
				
				request.setAttribute("list", list);
				
				rd=request.getRequestDispatcher("/views/employee-list.jsp");
				rd.forward(request, response);
				
	}

}
