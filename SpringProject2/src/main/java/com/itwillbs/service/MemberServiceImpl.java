package com.itwillbs.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{

	//멤버변수 (부모인터페이스변수) 객체생성 자동화 됨 => @Repository MemberDAOImpl 찾아감
	@Inject
	private MemberDAO memberDAO;
	
	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberServiceImpl insertMember()");
		//메서드 호출
		memberDAO.insertMember(memberDTO);
	}

}
