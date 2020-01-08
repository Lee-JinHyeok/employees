package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDAO;
import model.DeptEmpDAO;
import model.DeptManagerDAO;
import model.EmployeesDAO;
import model.SalariesDAO;
import model.TitlesDAO;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet({"/","/index"})
public class IndexServlet extends HttpServlet {
	private EmployeesDAO employeesDAO;
	private DepartmentsDAO departmentsDAO;
	private DeptEmpDAO deptEmpDAO;
	private DeptManagerDAO deptManagerDAO;
	private SalariesDAO salariesDAO;
	private TitlesDAO titlesDAO;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.employeesDAO = new EmployeesDAO();
		int employeesRowCount = employeesDAO.selectEmployeesRowCount();
		this.departmentsDAO = new DepartmentsDAO();
		int departmentsRowCount = departmentsDAO.selectDepartmentsRowCount();
		this.deptEmpDAO = new DeptEmpDAO();
		int deptEmpRowCount = deptEmpDAO.selectDeptEmpRowCount();
		this.deptManagerDAO = new DeptManagerDAO();
		int deptManagerRowCount = deptManagerDAO.selectDeptManagerRowCount();
		this.salariesDAO = new SalariesDAO();
		int salariesRowCount = salariesDAO.selectSalariesRowCount();
		this.titlesDAO = new TitlesDAO();
		int titlesRowCount = titlesDAO.selectTitlesRowCount();

		request.setAttribute("employeesRowCount", employeesRowCount);
		request.setAttribute("departmentsRowCount", departmentsRowCount);
		request.setAttribute("deptEmpRowCount", deptEmpRowCount);
		request.setAttribute("deptManagerRowCount", deptManagerRowCount);
		request.setAttribute("salariesRowCount", salariesRowCount);
		request.setAttribute("titlesRowCount", titlesRowCount);
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}

}
