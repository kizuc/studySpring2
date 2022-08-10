package com.itwillbs.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	// 마이바티스 객체생성(rootcontext)
	@Inject
	private SqlSession sqlSession;
	
	// memberMapper 파일에 정의된 전체 이름을 변수에 저장(중요한 데이터는 아무도 접근 못하게 객체 생성 못하게 수정하지 못하게)
	private static final String namespace="com.itwillbs.mappers.memberMapper";
	
	
	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl insertMember()");
		// 마이바티스 메서드 호출
//		sqlSession.insert(sql구문이름, memberDTO -null값);
		sqlSession.insert(namespace + ".insertMember", memberDTO);
	}

	@Override
	public MemberDTO userCheck(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl userCheck()");
		// 하나만 선택할 떄는 selectOne
		return sqlSession.selectOne(namespace+".userCheck", memberDTO);
	}

	@Override
	public MemberDTO getMember(String id) {
		System.out.println("MemberDAOImpl getMember()");
		return sqlSession.selectOne(namespace+".getMember", id);
	}
	
	

}
