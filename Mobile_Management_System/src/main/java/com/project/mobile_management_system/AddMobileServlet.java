package com.project.mobile_management_system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-mobile")
public class AddMobileServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int mobileId =Integer.parseInt(req.getParameter("mobileId"));
		String mobileModel =req.getParameter("mobileModel");
		String mobileBrand =req.getParameter("mobileBrand");
		int mobilePrice =Integer.parseInt(req.getParameter("mobilePrice"));
		
		//jdbc
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_mobile_management_system","root","123456");
			PreparedStatement pst = conn.prepareStatement("INSERT INTO mobile VALUES (?,?,?,?)");
			pst.setInt(1, mobileId);
			pst.setString(2, mobileModel);
			pst.setString(3, mobileBrand);
			pst.setInt(4, mobilePrice);
			
			pst.execute();
			
			resp.sendRedirect("index.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
