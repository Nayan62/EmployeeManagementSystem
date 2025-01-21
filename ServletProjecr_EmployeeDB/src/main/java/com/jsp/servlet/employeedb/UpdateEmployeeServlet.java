package com.jsp.servlet.employeedb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UpdateEmployeeServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		String employeeName = req.getParameter("employeeName");
		String employeeEmail = req.getParameter("employeeEmail");
		int employeeSalary = Integer.parseInt(req.getParameter("employeeSalary"));
		
		
		//DB Connection
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_employeedb?user=root&password=Nayan@123");
			
			PreparedStatement pst = conn.prepareStatement("UPDATE employee SET EmployeeName = ?, EmployeeEmail = ?, EmployeeSalary = ? WHERE EmployeeId = ?");
			
			
			pst.setInt(4, employeeId);
			pst.setString(1, employeeName);
			pst.setString(2, employeeEmail);
			pst.setInt(3, employeeSalary);
			
			int rowupdate = pst.executeUpdate();
			
			PrintWriter pw = res.getWriter();
			
			if(rowupdate>0) {
				pw.print("<h1>"+rowupdate+"data Updated!!</h1>");
			}else {
				pw.print("<h1>Data Not Updated<h1>");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			
			}
		}

}
