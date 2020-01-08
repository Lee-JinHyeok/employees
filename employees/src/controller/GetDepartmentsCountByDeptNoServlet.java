package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDAO;
import vo.Departments;

@WebServlet("/departments/getDepartmentsCountByDeptNo")
//extends 상속
public class GetDepartmentsCountByDeptNoServlet extends HttpServlet {
	private DepartmentsDAO departmentsDAO;
	//protected는  자기 패키지와 상속된 클래스에서만 치근덕댈수잇다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this 자기자신 
		this.departmentsDAO = new DepartmentsDAO();
		List<Map<String, Object>> list = (List<Map<String, Object>>)departmentsDAO.selectDepartmentsCountByDeptNo();
		//Attribute 톰캣에 머가잇는데 거기다 저장함 
		request.setAttribute("list", list);
		//forward 포워딩을함 여기서 포워딩이란 절루 가라 ~ 연결시켜줌
		request.getRequestDispatcher("/WEB-INF/views/departments/getDepartmentsCountByDeptNo.jsp").forward(request, response);
		
	}

}
