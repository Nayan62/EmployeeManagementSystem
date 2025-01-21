package com.jsp.servlet.employeedb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FindEmployeeServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int employeeid = Integer.parseInt(req.getParameter("employeeId"));
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_employeedb?user=root&password=Nayan@123");

			PreparedStatement pst = conn.prepareStatement("SELECT * FROM employee WHERE EmployeeId = ?");

			pst.setInt(1, employeeid);

			ResultSet rs = pst.executeQuery();

			PrintWriter pw = res.getWriter();
			while(rs.next()) {
				pw.print("<h1>EmployeeID: "+rs.getInt("employeeId")+"</h1>");
				pw.print("<h1>EmployeeName: "+rs.getString("employeeName")+"</h1>");
				pw.print("<h1>EmployeeEmail: "+rs.getString("employeeEmail")+"</h1>");
				pw.print("<h1>EmployeeSalary: "+rs.getInt("employeeSalary")+"</h1>");
			}
			
		} catch (Exception  e) {

			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch ( Exception e) {

					e.printStackTrace();
				}
			}
		}

	
		
	}

}
