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
import com.ktds.hskim.dao.GradeDAO;
import com.ktds.hskim.vo.ActorVO;
import com.ktds.hskim.vo.DirectorVO;
import com.ktds.hskim.vo.GenreVO;
import com.ktds.hskim.vo.GradeVO;

/**
 * Servlet implementation class AddNewMovieServlet
 */
public class AddNewMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DirectorDAO directorDAO;
	private ActorDAO actorDAO;
	private GradeDAO gradeDAO;
	private GenreDAO genreDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewMovieServlet() {
        super();
        directorDAO = new DirectorDAO();
        actorDAO = new ActorDAO();
        gradeDAO = new GradeDAO();
        genreDAO = new GenreDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String errorCode = request.getParameter("errorCode");
		errorCode = ( errorCode == null ? "" : errorCode);
		
		if ( errorCode.equals(MovieValidateConst.MISSING_ACTORS) ) {
			request.setAttribute("errorMessage", "출연진 입력");
		}
		else if ( errorCode.equals(MovieValidateConst.MISSING_DIRECTORS) ) {
			request.setAttribute("errorMessage", "감독 입력");
		}
		else if ( errorCode.equals(MovieValidateConst.MISSING_GENRES) ) {
			request.setAttribute("errorMessage", "장르 입력");
		}
		else if ( errorCode.equals(MovieValidateConst.MISSING_GRADE) ) {
			request.setAttribute("errorMessage", "등급 입력");
		}
		else if ( errorCode.equals(MovieValidateConst.MISSING_MOVIE_TITLE) ) {
			request.setAttribute("errorMessage", "영화 제목 입력");
		}
		else if ( errorCode.equals(MovieValidateConst.MISSING_OPEN_DATE) ) {
			request.setAttribute("errorMessage", "개봉일 입력");
		}
		else if ( errorCode.equals(MovieValidateConst.MISSING_RATE) ) {
			request.setAttribute("errorMessage", "평점 입력");
		}
		else if ( errorCode.equals(MovieValidateConst.MISSING_RUNNING_TIME) ) {
			request.setAttribute("errorMessage", "상영 시간 입력");
		}
		
		
		// 1 장르 리스트
		List<GenreVO> genreList = genreDAO.getAllGenreInfo();
		
		// 2 등급 리스트
		List<GradeVO> gradeList = gradeDAO.getAllGradeInfo();
		
		// 3 감독 리스트
		List<DirectorVO> directorList = directorDAO.getAllDirectorInfo();
		
		// 4 배우 리스트
		List<ActorVO> actorList = actorDAO.getAllActors();
		
		request.setAttribute("genreList", genreList);
		request.setAttribute("gradeList", gradeList);
		request.setAttribute("directorList", directorList);
		request.setAttribute("actorList", actorList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addNewMovie.jsp");
		rd.forward(request, response);
		
		
		
		
	}

}
