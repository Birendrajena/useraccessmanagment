package com.useraccesmanagement;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.useraccesmanagement.dao.UsermanagementDAO;
import com.useraccesmanagement.model.User;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {

	UsermanagementDAO usermgmtDAO = new UsermanagementDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usernm = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		User user = new User();
		user.setUsername(usernm);
		user.setPassword(password);
		user.setRole(role);

		try {
			usermgmtDAO.insertUser(user);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		response.sendRedirect("loginsystem.jsp");
	}
}
