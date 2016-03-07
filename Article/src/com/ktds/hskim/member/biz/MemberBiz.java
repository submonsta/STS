package com.ktds.hskim.member.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ktds.hskim.member.dao.MemberDAO;
import com.ktds.hskim.member.vo.MemberVO;

public class MemberBiz {
	
	private MemberDAO memberDAO;
	
	public MemberBiz() {
		memberDAO = new MemberDAO();
	}
	
	public boolean login (MemberVO member, HttpServletRequest request) {
		
		// 1 회원 정보 가져오기
		MemberVO loginMember = memberDAO.getMemberByIdAndPassword(member);
		
		// 2 일치하는 회원 정보 세션에 넣기
		if ( loginMember != null ) {
			 HttpSession session = request.getSession();
			 session.setAttribute("_MEMBER_", loginMember);
		}
		
		// 3 결과 보고
		return loginMember != null;
	}
}
