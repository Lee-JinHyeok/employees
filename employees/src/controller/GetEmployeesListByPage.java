package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDAO;
import vo.Employees;

/**
 * Servlet implementation class GetEmployeesByPage
 */
@WebServlet("/employees/getEmployeesListByPage")
public class GetEmployeesListByPage extends HttpServlet {
	private EmployeesDAO employeesDAO;
	private int rowPerPage = 10;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int currentPage = 1;
		int pageList = 0;
		employeesDAO = new EmployeesDAO();
		int lastPage = employeesDAO.selectLastPage(rowPerPage);
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			pageList = (currentPage-1)/10;
		}
		if(currentPage<1) {
			currentPage=1;
		}
		if(currentPage>lastPage) {
			currentPage=lastPage;
		}
		
		List<Employees> list = employeesDAO.selectEmplyeesListByPage(rowPerPage, currentPage);
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("pageList", pageList);

		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListByPage.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("rowPerPage") != null){
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		doGet(request, response);
	}
}
