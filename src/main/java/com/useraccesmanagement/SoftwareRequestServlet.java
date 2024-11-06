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
import com.useraccesmanagement.model.Software;
import com.useraccesmanagement.model.User;

@WebServlet("/SoftwareRequestServlet")
public class SoftwareRequestServlet extends HttpServlet {

	UsermanagementDAO usermgmtDAO = new UsermanagementDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		Integer softid = Integer.parseInt(request.getParameter("software_id"));
		String access = request.getParameter("access_type");
		String reas = request.getParameter("reason");
		Request accrequest = new Request();
		accrequest.setUserId(userId);
		accrequest.setSoftwareId(softid);
		accrequest.setAccessType(access);
		accrequest.setReason(reas);
		accrequest.setStatus("Pending");
		try { 
			usermgmtDAO.insertRequest(accrequest);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		List<Software> softwares;
		try {
			softwares = usermgmtDAO.getSoftwares();
			request.setAttribute("availablesoftwares", softwares);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("employee.jsp");
		rd.forward(request, response);
	}
}
