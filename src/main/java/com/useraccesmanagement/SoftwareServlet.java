package com.useraccesmanagement;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.useraccesmanagement.dao.UsermanagementDAO;
import com.useraccesmanagement.model.Software;
import com.useraccesmanagement.model.User;

@WebServlet("/SoftwareServlet")
public class SoftwareServlet extends HttpServlet {

	UsermanagementDAO usermgmtDAO = new UsermanagementDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("software_name");
		String description = request.getParameter("description");
		String access_levels = request.getParameter("access_levels");
		Software software = new Software();
		software.setName(name);
		software.setDescription(description);
		software.setAccessLevels(access_levels);
		try {
			usermgmtDAO.insertSoftware(software);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		response.sendRedirect("admin.jsp");
	}
}
