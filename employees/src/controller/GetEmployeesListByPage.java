package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;
import vo.Employees;


@WebServlet("/employees/getEmployeesListByPage")
public class GetEmployeesListByPage extends HttpServlet {
		private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeesDao = new EmployeesDao();
		int rowPerPage = 10;
		int currentPage = 1;
		if(request.getParameter("rowPerPage")!=null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		System.out.println("cuurentPage  : " + currentPage);	//currentPage 확인
		int lastPage = employeesDao.selectLastPage(rowPerPage);
		System.out.println("lastPage : " + lastPage);	
		
		List<Employees> list = employeesDao.selectEmployeesListByPage(currentPage, rowPerPage);
		request.setAttribute("rowPerPage", rowPerPage);				//rowPerPage
		request.setAttribute("list", list);							//list
		request.setAttribute("currentPage", currentPage);			//currentPage
		request.setAttribute("lastPage", lastPage);					//lastPage
		
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListByPage.jsp").forward(request, response);
	}
}
