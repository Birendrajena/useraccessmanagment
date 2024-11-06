package com.useraccesmanagement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.useraccesmanagement.dao.UsermanagementDAO;
import com.useraccesmanagement.model.Request;
import com.useraccesmanagement.model.Software;
import com.useraccesmanagement.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	UsermanagementDAO usermgmtDAO = new UsermanagementDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usernm = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			User user = usermgmtDAO.getUser(usernm, password);
			HttpSession sess = request.getSession();
			sess.setAttribute("user", user);
			String role = user.getRole() ;
			if(role!= null) {
				switch(role) {
				case "Employee" : 
					List<Software> softwares = usermgmtDAO.getSoftwares();
					request.setAttribute("availablesoftwares", softwares);
					RequestDispatcher rd = request.getRequestDispatcher("/employee.jsp");
					rd.forward(request, response);
					break;
				case "Admin" : 
					softwares = usermgmtDAO.getSoftwares();
					request.setAttribute("availablesoftwares", softwares);
					rd = request.getRequestDispatcher("/admin.jsp");
					rd.forward(request, response);
					break;
					
				case "Manager" : 
					List<Request> requests = usermgmtDAO.getRequests();
					request.setAttribute("pendingRequests", requests);
					rd = request.getRequestDispatcher("/manager.jsp");
					rd.forward(request, response);
					break;


				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
