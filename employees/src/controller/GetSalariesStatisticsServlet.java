package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SalariesDAO;


@WebServlet("/salaries/getSalariesStatistics")
public class GetSalariesStatisticsServlet extends HttpServlet {
	SalariesDAO salariesDAO;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		salariesDAO = new SalariesDAO();

		Map<String, Long> map =(Map<String, Long>)salariesDAO.selectSalariesStatistics();
		request.setAttribute("map", map);
		
		request.getRequestDispatcher("/WEB-INF/views/salaries/salariesStatistics.jsp").forward(request, response);
	}


}
