package com.ktds.hskim.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.hskim.dao.MovieDAO;
import com.ktds.hskim.vo.MovieVO;

/**
 * Servlet implementation class MovieActorServlet
 */
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDAO movieDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
        movieDAO = new MovieDAO();
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
		
		List<MovieVO> movies = movieDAO.allMovie();
		
		
		request.setAttribute("allMovie", movies);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mvs.jsp");
		rd.forward(request, response);
	}

}
