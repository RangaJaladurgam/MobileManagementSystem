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

@WebServlet("/sort")
public class SortLowToHigh extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String value = req.getParameter("sortOrder");
		
		Connection conn=null;
		
//		jdbc
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_mobile_management_system","root","123456");
			PreparedStatement pst=null;
			switch(value) {
			case "lowToHigh":
				pst = conn.prepareStatement("SELECT * FROM mobile ORDER BY mobilePrice ASC");
				break;
			case "highToLow":
				pst = conn.prepareStatement("SELECT * FROM mobile ORDER BY mobilePrice DESC");
				break;
			default:
				pst = conn.prepareStatement("SELECT * FROM mobile");
			
			}
			ResultSet rst = pst.executeQuery();
			req.setAttribute("resultSet",rst);
			req.setAttribute("selectedSortOrder", value);
			req.getRequestDispatcher("displayMobile.jsp").forward(req, resp);
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
