package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;

@RestController
public class AjaxController {
	
	@Inject
	private MemberService memberService;
	
	// /myweb2/member/iddup
	@RequestMapping(value = "/member/iddup", method = RequestMethod.GET)
//	주소값이 아닌 출력값 담은 걸 리턴하겠다(데이터를 담아서 리턴한다), httpSR=아이디값
	public ResponseEntity<String> iddup(HttpServletRequest request) {
		String id=request.getParameter("id");
//		아이디가 중복인지 아닌지를 멤버DTO에 담아와서
		MemberDTO memberDTO=memberService.getMember(id);
		
		String result="";
		if(memberDTO!=null) {
			// 아이디 있음 , 아이디 중복
			result="iddup";
		}else {
			// 아이디 없음, 아이디 사용가능
			result="idok";
		}
		
		ResponseEntity<String> entity=new ResponseEntity<String>(result,HttpStatus.OK);
		return entity;
	}
	
	// /myweb2/member/listjson
	@RequestMapping(value="/member/listjson", method= RequestMethod.GET)
//	주소값이 아닌 출력값 담은 걸 리턴하겠다(데이터를 담아서 리턴한다), httpSR=아이디값
	public ResponseEntity<List<MemberDTO>> listjson(HttpServletRequest request) {
		
		List<MemberDTO> memberList=memberService.getMemberList();
		
		ResponseEntity<List<MemberDTO>> entity=
				new ResponseEntity<List<MemberDTO>>(memberList,HttpStatus.OK);
		return entity;
		
		// json 데이터 변경 프로그램 설치 시 => 자동으로 json 데이터 변환
	}
	
}
