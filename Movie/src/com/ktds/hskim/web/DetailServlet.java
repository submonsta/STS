package com.ktds.hskim.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.hskim.dao.ActorDAO;
import com.ktds.hskim.dao.DirectorDAO;
import com.ktds.hskim.dao.GenreDAO;
import com.ktds.hskim.dao.MovieDAO;
import com.ktds.hskim.vo.ActorVO;
import com.ktds.hskim.vo.DirectorVO;
import com.ktds.hskim.vo.GenreVO;
import com.ktds.hskim.vo.MovieVO;

/**
 * Servlet implementation class DetailServlet
 */
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDAO movieDAO;
	private DirectorDAO directorDAO;
	private ActorDAO actorDAO;
	private GenreDAO genreDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        movieDAO = new MovieDAO();
        directorDAO = new DirectorDAO();
        actorDAO = new ActorDAO();
        genreDAO = new GenreDAO();
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
		
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		
		// 영화 정보 가져오기
		MovieVO movie = movieDAO.getOneMovieInfoByMovieId(movieId);
		
		// 감독 정보 가져오기 
		List<DirectorVO> directors = directorDAO.getDirectorInfo(movieId);
				
		// 출연자 정보 가져오기
		List<ActorVO> actors = actorDAO.getActors(movieId);
		
		// 장르 정보 가져오기
		List<GenreVO> genres = genreDAO.getGenreInfo(movieId);
		
		request.setAttribute("selectMovie", movie);
		request.setAttribute("selectDirector", directors);
		request.setAttribute("selectActor", actors);
		request.setAttribute("selectGenre", genres);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/select.jsp");
		rd.forward(request, response);
	}

}
