package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import vo.Employees;

/**
 * Servlet implementation class GetEmployeesListByOrderServlet
 */
@WebServlet("/employees/getEmployeesListOrderby")
public class GetEmployeesListOrderByServlet extends HttpServlet {
	private EmployeesDAO employeesDAO;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String order = "asc";
		
		this.employeesDAO = new EmployeesDAO();
		if(request.getParameter("order")!=null) {
			order = request.getParameter("order");
		}
		List<Employees> list = (List<Employees>)employeesDAO.selectEmplyeesListOrderBy(order);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListOrderBy.jsp").forward(request, response);
		
	}


}
