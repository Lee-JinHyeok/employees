package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;
import vo.Employees;

@WebServlet("/employees/getEmployeesListOrderBy")
public class GetEmployeesOrderByServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<Employees> list = new ArrayList<Employees>();	
	employeesDao= new EmployeesDao();

	list = employeesDao.selcetEmployeesListOrderBy(request.getParameter("order"));
	System.out.println(request.getParameter("order"));
	
	request.setAttribute("list", list);
	
	request.getRequestDispatcher("/WEB-INF/views/employees/employeesList.jsp").forward(request, response);
	}
}
