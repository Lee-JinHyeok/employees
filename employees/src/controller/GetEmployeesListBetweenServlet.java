package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDAO;
import sun.awt.RepaintArea;
import vo.Employees;

/**
 * Servlet implementation class GetEmployeesListBetweenServlet
 */
@WebServlet("/employees/getEmployeesListBetween")
public class GetEmployeesListBetweenServlet extends HttpServlet {
	EmployeesDAO employeesDAO;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeesDAO = new EmployeesDAO();
		int begin = 0;
		int end = 0;
		if(request.getParameter("begin")!=null && request.getParameter("end")!=null) {
			begin = Integer.parseInt(request.getParameter("begin"));
			end = Integer.parseInt(request.getParameter("end"));
		}else {
			response.sendRedirect("/");
			return;
		}
		List<Employees> list = employeesDAO.selectEmployeesBetween(begin, end);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListBetween.jsp").forward(request, response);
		
	}


}
