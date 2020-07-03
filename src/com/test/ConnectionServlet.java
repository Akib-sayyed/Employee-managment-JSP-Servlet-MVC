package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConnectionServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String uname = "root";
		String pass = "root";
		String JDBCurl = "jdbc:mysql://localhost:3306/employeedirectory";
		String driver = "com.mysql.jsbc.Driver";

		PrintWriter writer = response.getWriter();
		writer.println("connection to DB" + JDBCurl);

		Connection con;
		try {
			con = DriverManager.getConnection(JDBCurl, uname, pass);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
