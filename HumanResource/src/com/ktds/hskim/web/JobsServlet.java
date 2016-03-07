package com.ktds.hskim.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.hskim.dao.JobsDAO;
import com.ktds.hskim.vo.JobsVO;

/**
 * Servlet implementation class JobsServlet
 */
public class JobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JobsDAO jobsDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobsServlet() {
        super();
        jobsDAO = new JobsDAO();
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
		
		List<JobsVO> jobs = jobsDAO.allJobs();
		
		request.setAttribute("allJobs", jobs);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/jbs.jsp");
		rd.forward(request, response);
	}

}
