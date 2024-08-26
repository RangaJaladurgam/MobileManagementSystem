package com.project.mobile_management_system;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchBrand")
public class searchBrand extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String brand = req.getParameter("brand");
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_mobile_management_system","root","123456");
			PreparedStatement pst=null;
			pst = conn.prepareStatement("SELECT * FROM mobile WHERE mobileBrand LIKE ?");
			pst.setString(1, "%"+brand+"%");
			ResultSet rst = pst.executeQuery();
			req.setAttribute("resultSet",rst);
			req.getRequestDispatcher("displayMobile.jsp").forward(req, resp);
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
