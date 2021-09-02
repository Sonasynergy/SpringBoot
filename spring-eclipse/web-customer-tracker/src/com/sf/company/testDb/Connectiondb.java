package com.sf.company.testDb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Connectiondb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setup connection variables
				String user = "postgres";
				String pass = "Sonaramanavel@5";
				
				String jdbcUrl = "jdbc:postgresql://localhost:5432/customerdb";
				String driver = "org.postgresql.Driver";
				
				// get connection to database
				try {
					PrintWriter out = response.getWriter();
					
					out.println("Connecting to database: " + jdbcUrl);
					
					Class.forName(driver);
					
					Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
					
					out.println("SUCCESS!!!");
					
					myConn.close();
					
				}
				catch (Exception exc) {
					exc.printStackTrace();
					throw new ServletException(exc);
				}
	}
}