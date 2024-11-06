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

import com.useraccesmanagement.dao.UsermanagementDAO;
import com.useraccesmanagement.model.Request;
import com.useraccesmanagement.model.User;

@WebServlet("/ApprovalServlet")
public class ApprovalServlet extends HttpServlet {

	UsermanagementDAO usermgmtDAO = new UsermanagementDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int reqId = Integer.parseInt(request.getParameter("request_id"));
		String action = request.getParameter("action");

		try {
			usermgmtDAO.updateRequest(action, reqId);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		List<Request> requests;
		try {
			requests = usermgmtDAO.getRequests();
			request.setAttribute("pendingRequests", requests);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/manager.jsp");
		rd.forward(request, response);

	}
}
