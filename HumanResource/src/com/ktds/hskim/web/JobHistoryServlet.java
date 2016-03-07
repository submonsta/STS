package com.ktds.hskim.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.hskim.dao.JobHistoryDAO;
import com.ktds.hskim.vo.JobHistoryVO;

/**
 * Servlet implementation class JobHistoryServlet
 */
public class JobHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JobHistoryDAO jobHistoryDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobHistoryServlet() {
        super();
        jobHistoryDAO = new JobHistoryDAO();
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
		
		List<JobHistoryVO> jobHistorys = jobHistoryDAO.allJobHistory();
		
		request.setAttribute("allJobHistorys", jobHistorys);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/jhs.jsp");
		rd.forward(request, response);
		
	}

}
