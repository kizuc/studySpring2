package com.itwillbs.dao;

import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	//마이바티스 객체생성
	
	
	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl insertMember()");
		//마이바티스 메서드 호출
		
	}

}
