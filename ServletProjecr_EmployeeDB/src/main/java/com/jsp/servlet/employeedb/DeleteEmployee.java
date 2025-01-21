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

public class DeleteEmployee extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int employeeId = Integer.parseInt(req.getParameter("employeeId"));



		//JDBC LOGIC

		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_employeedb?user=root&password=Nayan@123");

			PreparedStatement pst= conn.prepareStatement("DELETE FROM employee WHERE EmployeeId = ?");
			pst.setInt(1, employeeId);

			int rowsdeleted = pst.executeUpdate();
			
			PrintWriter pw = res.getWriter();
			
			if(rowsdeleted> 0) {
				pw.print("<h1>"+rowsdeleted+"Data deleted </h1>");
			}else {
				pw.print("<h1>Data not deleted </h1>");
			}
		}catch (Exception e) {

			e.printStackTrace();
		}

		finally {
			if(conn!= null) {

				try {
					conn.close();
				} catch (Exception e) {

					e.printStackTrace();
				}

			}


		}

	}
}
