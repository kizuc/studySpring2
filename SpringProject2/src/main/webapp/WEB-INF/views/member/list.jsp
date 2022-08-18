<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/list.jsp</title>
</head>
<body>
<%
// // MemberDAO 객체생성
// MemberDAO memberDAO=new MemberDAO();
// // 리턴할형 List   getMemberList() 메서드 정의
// // List memberList = getMemberList() 메서드 호출
// List memberList=memberDAO.getMemberList();

// model.addAttribute("memberList", memberList);
%>
<table border="1">
<tr><td>아이디</td><td>비밀번호</td><td>이름</td><td>가입날짜</td></tr>
<%-- <c:forEach var="i" begin="1" end="10" step="1"> --%>
<!-- 배열을 멤버DTO에 담아서 -->
<c:forEach var="memberDTO" items="${memberList }">
	<tr>
	<td>${memberDTO.id }</td><td>${memberDTO.pass }</td>
    <td>${memberDTO.name }</td><td>${memberDTO.date }</td>
    </tr>
</c:forEach>

<%
// for(int i=0;i<memberList.size();i++){
// 	MemberDTO memberDTO =(MemberDTO)memberList.get(i);
	%>
<%-- <tr><td><%//=memberDTO.getId() %></td><td><%///=memberDTO.getPass() %></td> --%>
<%--     <td><%//=memberDTO.getName() %></td><td><%//=memberDTO.getDate() %></td></tr>	 --%>
	<%
// }
%>
</table>
</body>
</html>