package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;
import com.itwillbs.service.MemberServiceImpl;

@Controller
public class MemberController {

	// 멤버변수 (부모인터페이스변수) 객체생성 자동화 됨=> @Service MemberServiceImpl 찾아감
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
		// 회원가입
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

	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		return "member/loginForm";
	}

	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	// jsp는 세션이 자동으로 만들어지지만 자바는 HttpSession으로 만들어야한다
	public String loginPro(MemberDTO memberDTO, HttpSession session) {
		System.out.println("MemberController loginPro()");
		// 메서드 호출
		MemberDTO memberDTO2=memberService.userCheck(memberDTO);
		if(memberDTO2!=null) {
			// 아이디 비밀번호가 일치하면 null 아닌 값이 들고오는
			// 세션값 생성 "id", id
			session.setAttribute("id", memberDTO.getId());

			// member/main 이동
			return "redirect:/member/main";
		}else {
			// null일 경우 아이디 비밀번호 틀림
			// "틀림" 뒤로이동
			// 주소변경없이 이동
			// WEB-INF/views/member/msg.jsp 이동
			return "/member/msg";
		}
	}
	//	가상주소 시작점 http://localhost:8080/myweb2/member/main
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {
		// 주소변경없이 이동
		// WEB-INF/views/member/insertForm.jsp 이동
		return "member/main";
	}

	//	가상주소 시작점 http://localhost:8080/myweb2/member/logout
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 세션값 초기화
		session.invalidate();
		// /member/main 이동
		// 주소변경 이동
		return "redirect:/member/main";
	}

	//	가상주소 시작점 http://localhost:8080/myweb2/member/info
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info(HttpSession session, Model model) {
//		// 세션값 가져오기
		String id=(String)session.getAttribute("id");
		// id에 대한 정보를 디비에 가져오기
		MemberDTO memberDTO = memberService.getMember(id);
		// 가져온 정보를 담아 info.jsp 이동
		model.addAttribute("memberDTO",memberDTO);

//		// 주소변경없이 이동
		// WEB-INF/views/member/info.jsp 이동
		return "member/info";
	}

	//	가상주소 시작점 http://localhost:8080/myweb2/member/update
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
//		// 세션값 가져오기
		String id=(String)session.getAttribute("id");
		// id에 대한 정보를 디비에 가져오기
		MemberDTO memberDTO = memberService.getMember(id);
		// 가져온 정보를 담아 info.jsp 이동
		model.addAttribute("memberDTO", memberDTO);

//		// 주소변경없이 이동
		// WEB-INF/views/member/info.jsp 이동
		return "member/updateForm";
	}

	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberDTO memberDTO, HttpSession session) {
		System.out.println("MemberController updatePro()");
		// 메서드 호출
		MemberDTO memberDTO2=memberService.userCheck(memberDTO);
		if(memberDTO2!=null) {
			//아이디 비밀번호 일치
			// 수정작업
			memberService.updateMember(memberDTO);
			// /member/main 이동
			// 주소변경 이동
			return "redirect:/member/main";
		}else {
			//아이디 비밀번호 틀림
			// "틀림" 뒤로이동
			// 주소변경없이 이동
			// WEB-INF/views/member/msg.jsp 이동
			return "member/msg";
		}
	}

	//	가상주소 시작점 http://localhost:8080/myweb2/member/update
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete(HttpSession session, Model model) {

//		// 주소변경없이 이동
		// WEB-INF/views/member/delete.jsp 이동
		return "member/deleteForm";
	}

	@RequestMapping(value = "/member/deletePro", method = RequestMethod.POST)
	public String deletePro(MemberDTO memberDTO, HttpSession session) {
		System.out.println("MemberController deletePro()");
		// 메서드 호출
		MemberDTO memberDTO2=memberService.userCheck(memberDTO);
		if(memberDTO2!=null) {
			//아이디 비밀번호 일치
			// 수정작업
			memberService.deleteMember(memberDTO);
			// 세션값 초기화
			session.invalidate();
			// /member/main 이동
			// 주소변경 이동
			return "redirect:/member/main";
		}else {
			//아이디 비밀번호 틀림
			// "틀림" 뒤로이동
			// 주소변경없이 이동
			// WEB-INF/views/member/msg.jsp 이동
			return "member/msg";
		}
	}

	//	가상주소 시작점 http://localhost:8080/myweb2/member/list
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list(HttpSession session,Model model) {

		//모든회원에 대한 정보를 디비에서 가져오기
		List<MemberDTO> memberList=memberService.getMemberList();
		// 가져온 정보를 담아서 list.jsp 이동
		model.addAttribute("memberList", memberList);

		// 주소변경없이 이동
		// WEB-INF/views/member/list.jsp 이동
		return "member/list";
	}

	//	가상주소 시작점 http://localhost:8080/myweb2/member/list
	@RequestMapping(value = "/member/list2", method = RequestMethod.GET)
	public String list2(HttpSession session,Model model) {

		// 주소변경없이 이동
		// WEB-INF/views/member/list2.jsp 이동
		return "member/list2";
	}
}
