package com.ktds.hskim.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.hskim.dao.LocationsDAO;
import com.ktds.hskim.vo.LocationsVO;

/**
 * Servlet implementation class LocationsServlet
 */
public class LocationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LocationsDAO locationsDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationsServlet() {
        super();
        locationsDAO = new LocationsDAO();
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
		
		List<LocationsVO> locations = locationsDAO.allLocations();
		
		request.setAttribute("allLocations", locations);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/lcs.jsp");
		rd.forward(request, response);
		
	}

}
