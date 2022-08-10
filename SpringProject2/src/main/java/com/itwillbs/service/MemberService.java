package com.itwillbs.service;

import com.itwillbs.domain.MemberDTO;

public interface MemberService {
	//추상메서드 
	public void insertMember(MemberDTO memberDTO);
	
	public MemberDTO userCheck(MemberDTO memberDTO);

	public MemberDTO getMember(String id);
}
