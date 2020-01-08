package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDAO;


@WebServlet("/employees/getEmployeesCountByGender")
public class GetEmployeesCountGroupByGenderServlet extends HttpServlet {
	EmployeesDAO employeesDAO;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeesDAO = new EmployeesDAO();
		List<Map<String, Object>> list = (List<Map<String, Object>>)employeesDAO.selectEmployeesCountGroupByGender();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesCountByGender.jsp").forward(request, response);
		
	}

}
