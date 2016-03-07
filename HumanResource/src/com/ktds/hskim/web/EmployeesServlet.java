package com.ktds.hskim.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.hskim.dao.EmployeesDAO;
import com.ktds.hskim.vo.EmployeesVO;

/**
 * Servlet implementation class EmployeesServlet
 */
public class EmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private EmployeesDAO employeesDAO;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesServlet() {
        super();
        employeesDAO = new EmployeesDAO();
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
		
		List<EmployeesVO> employees = employeesDAO.getAllEmployees();
		
		request.setAttribute("allEmployees", employees);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/emp.jsp");
		rd.forward(request, response);
		
	}

}
