package com.project.mobile_management_system;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateDetails")
public class UpdateDetailsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mobileId = Integer.parseInt(req.getParameter("mobileId"));
		//jdbc
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_mobile_management_system","root","123456");
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM mobile WHERE mobileId=?");
			pst.setInt(1, mobileId);
			
			ResultSet rs = pst.executeQuery();
			
			req.setAttribute("resultSet",rs);
			req.getRequestDispatcher("updateForm.jsp").forward(req, resp);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
