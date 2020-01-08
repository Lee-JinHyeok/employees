package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TitlesDAO;

/**
 * Servlet implementation class GetTitlesListDistinctServlet
 */
@WebServlet("/titles/getTitlesListDistinct")
public class GetTitlesListDistinctServlet extends HttpServlet {
	TitlesDAO titlesDAO;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.titlesDAO = new TitlesDAO();
		List<String> list = (List<String>)titlesDAO.selectTitlesListDistinct();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/titles/titlesListDistinct.jsp").forward(request, response);;
	}


}
