package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDAO;
import model.EmployeesDAO;
import vo.Departments;
import vo.Employees;

/**
 * Servlet implementation class GetDepartmentsListServlet
 */
@WebServlet("/employees/getEmployeesList")
public class GetEmployeesListServlet extends HttpServlet {
	private EmployeesDAO employeesDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.employeesDAO = new EmployeesDAO();
		int limit = 10;
		if(request.getParameter("limit") != null){
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		
		List<Employees> list = (List<Employees>)employeesDAO.selectEmplyeesList(limit);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesList.jsp").forward(request, response);
		
	}

}
