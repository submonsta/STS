package com.ktds.hskim.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.hskim.member.biz.MemberBiz;
import com.ktds.hskim.member.vo.MemberVO;

/**
 * Servlet implementation class DoLoginServlet
 */
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberBiz memberBiz;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLoginServlet() {
        super();
        memberBiz = new MemberBiz();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "로그인 할 수 없음");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("userId");
		String memberPassword = request.getParameter("userPw");
		
		MemberVO loginMember = new MemberVO();
		loginMember.setMemberId(memberId);
		loginMember.setPassword(memberPassword);
		
		boolean isLoginSuccess = memberBiz.login(loginMember, request);
		
		if ( isLoginSuccess ) {
			response.sendRedirect("/list");
			return;
		}
		else {
			response.sendRedirect("/login?errorCode=1");
			return;
		}
	}

}
