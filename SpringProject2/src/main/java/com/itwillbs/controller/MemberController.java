package com.itwillbs.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;
import com.itwillbs.service.MemberServiceImpl;

@Controller
public class MemberController {
	
	//멤버변수 (부모인터페이스변수) 객체생성 자동화 됨=> @Service MemberServiceImpl 찾아감 
//	MemberService memberService=new MemberServiceImpl();
	@Inject
	private MemberService memberService;

	//	가상주소 시작점 http://localhost:8080/myweb2/member/insert 
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		// 주소변경없이 이동
		// WEB-INF/views/member/insertForm.jsp 이동
		return "member/insertForm";
	}
	
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
	public String insertPro(MemberDTO memberDTO) {
		System.out.println("MemberController insertPro()");
		//회원가입
//		패키지 com.itwillbs.service
//		인터페이스 MemberService 추상메서드 
//		자바파일 만들기 MemberServiceImpl 상속 MemberService
		
//		패키지 com.itwillbs.dao
//		인터페이스 MemberDAO 추상메서드 
//		자바파일 만들기 MemberDAOImpl 상속 MemberDAO
		
		// 객체생성 
//		MemberService memberService=new MemberServiceImpl();
		// 메서드 호출
		memberService.insertMember(memberDTO);
		
		// 주소변경 이동
		return "redirect:/member/login";
	}
	
}
