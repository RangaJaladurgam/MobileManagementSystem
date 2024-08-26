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

@WebServlet("/update")
public class SaveUpdateDetailsServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int mobileId =Integer.parseInt(req.getParameter("mobileId"));
		String mobileModel =req.getParameter("mobileModel");
		String mobileBrand =req.getParameter("mobileBrand");
		int mobilePrice =Integer.parseInt(req.getParameter("mobilePrice"));

		Connection conn=null;
		//jdbc
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_mobile_management_system","root","123456");
			PreparedStatement pst = conn.prepareStatement("UPDATE mobile SET mobileModel=?,mobileBrand=?,mobilePrice=? WHERE mobileId=?");
			pst.setInt(4, mobileId);
			pst.setString(1, mobileModel);
			pst.setString(2, mobileBrand);
			pst.setInt(3, mobilePrice);

			pst.executeUpdate();

			resp.sendRedirect("display-mobiles");
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
