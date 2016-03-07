package com.ktds.hskim.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.hskim.dao.CountriesDAO;
import com.ktds.hskim.vo.CountriesVO;

/**
 * Servlet implementation class CountriesServlet
 */
public class CountriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CountriesDAO countriesDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountriesServlet() {
        super();
        countriesDAO = new CountriesDAO();
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
		
		List<CountriesVO> countries = countriesDAO.allCountries();
		
		request.setAttribute("allCountries", countries);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/cts.jsp");
		rd.forward(request, response);
		
		
		
	}

}
