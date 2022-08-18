<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/list.jsp</title>
<script type="text/javascript"
src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#btn').click(function(){
//			alert("클릭");
		$.ajax({
			url:'${pageContext.request.contextPath}/member/listjson',
			dataType:'json',
			success:function(rdata){
// 				each : 반복문 // rdata : 배열
// 				== 배열을 반복하겠다
				$.each(rdata,function(index,item){
					
				$('table').append("<tr><td>"+item.id
								 +"</td><td>"+item.pass
								 +"</td><td>"+item.name
								 +"</td><td>"+item.date
								 +"</td></tr>");
				});
			}
		});
	});
});

</script>

</head>
<body>
<input type="button" value="회원목록" id="btn">
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

</table>
</body>
</html>