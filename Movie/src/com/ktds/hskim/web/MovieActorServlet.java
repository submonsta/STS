package com.ktds.hskim.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.hskim.dao.MovieActorDAO;
import com.ktds.hskim.vo.MovieActorVO;

/**
 * Servlet implementation class MovieActorServlet
 */
public class MovieActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieActorDAO movieActorDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieActorServlet() {
        super();
        movieActorDAO = new MovieActorDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MovieActorVO> movieActors = movieActorDAO.allList();
		
		request.setAttribute("allList", movieActors);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mas.jsp");
		rd.forward(request, response);
	}

}
