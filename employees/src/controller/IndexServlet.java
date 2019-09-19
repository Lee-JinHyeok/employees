package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	
	private EmployeesDao employeesDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//제일 먼저 URL 요청(맵핑)이 되는지 확인한다
		System.out.println("/index URL 요청");
		
		this.employeesDao = new EmployeesDao();						//model을 호출해서 내가 원하는 데이터를 만들어 낸다. 이는 100% 메소드 호출이다
		int employeesRowCount = employeesDao.selectEmployeesCount();	//받은 데이터는 view로 전달한다.	받은 데이터를 전달해주는게 forward이다. request.setAttribute(매개변수이름, 보낼변수);
		
		
		
		//***** forward ***** /WEB-INF/views/index.jsp
		//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp"); 
		//rd.forward(request, response);//request와 response를 위임해준다.
		//아래처럼 쉽게 바꿀 수 있다.
		request.setAttribute("employeesRowCount", employeesRowCount);
		
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
		
	}
	
}