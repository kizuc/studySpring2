<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/main.jsp</title>
</head>
<body>
<%-- <% --%>
<!-- String id=(String)session.getAttribute("id"); -->
<!-- // 세션값이 없으면(세션값이 null이면) loginForm.jsp 이동 -->
<!-- if(id==null){ -->
<!-- // 	response.sendRedirect("loginForm.jsp"); -->
<!-- // } -->
<!-- %> -->

<!-- 

jsp 화면에서 태그처럼 if, for 사용
JSTL(JSP Standard Tag Lib)
1. JSTL 프로그램 설치
2. JSTL 프로그램 가져오기
	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
 -->

<!-- 아이디는 널이랑 같냐 == 세션값이 비어있냐 -->
<c:if test="${empty sessionScope.id }">
	<c:redirect url="/member/login"></c:redirect>
</c:if>

<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.js"></script>
<img src="${pageContext.request.contextPath }/resources/img/hero-4.jpg">
${sessionScope.id }님 로그인 하셨습니다. 
<a href="${pageContext.request.contextPath }/member/logout">로그아웃</a><br>
<a href="${pageContext.request.contextPath }/member/info">회원정보조회</a>
<a href="${pageContext.request.contextPath }/member/update">회원정보수정</a>
<a href="${pageContext.request.contextPath }/member/delete">회원정보삭제</a>

<%-- <a href="<%=request.getContextPath() %>/member/list">회원목록</a> --%>
<%-- <% --%>
<!-- if(id!=null){ -->
<!-- 	if(id.equals("admin")){ -->
<!-- 		%> -->
<%-- 		<a href="<%=request.getContextPath() %>/member/list">회원목록</a> --%>
<%-- 		<% --%>
<!-- // 	} -->
<!-- // } -->
<!-- %> -->

<!-- 비어있는 경우가 아닌 경우==스코프가 비어있지 않으면 if문이 동작 조건연산자 -->
<c:if test="${ !( empty sessionScope.id )}">
<!-- 세션스코프의 아이디가 admin 같다 -->
	<c:if test="${sessionScope.id eq 'admin'}">
		<a href="${pageContext.request.contextPath }/member/list">회원목록</a>
	</c:if>
</c:if>
</body>
</html>


