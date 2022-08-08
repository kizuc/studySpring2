<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp5/list.jsp</title>
</head>
<body>
<%
//1단계 JDBC 프로그램 불러오기
Class.forName("com.mysql.cj.jdbc.Driver");
// 2단계 JDBC 프로그램 이용해서 디비서버에 접속 => 연결정보 저장
// 디비서버에 접근할 디비주소
String dbUrl="jdbc:mysql://localhost:3306/jspdb1?serverTimezone=UTC";
// 디비에 접근할 아이디
String dbId="root";
// 디비에 접근할 비밀번호
String dbPass="1234";
// 디비연결 정보를 Connection형 con변수에 저장
Connection con =DriverManager.getConnection(dbUrl, dbId, dbPass);
// 3단계 연결정보를 이용해서 sql구문을 만들기 => PreparedStatement 내장객체 준비
// String sql="select * from 테이블이름";
String sql="select * from board";
PreparedStatement pstmt=con.prepareStatement(sql);
// 4단계 sql구문을 실행=> 실행 결과 저장(select) 
//=> sql구문을 실행한 결과 저장하는 내장객체 ResultSet
ResultSet rs=pstmt.executeQuery();
// 5단계 결과를 가지고 출력하거나 배열변수 저장(select)
// rs.next() 결과에서 다음행 이동하고 데이터 있으면 true/없으면 false 
// while(rs.next()){
	// 데이터 있으면 true => 열접근		
%>
<table border="1">
<tr><td>번호</td><td>작성자</td><td>제목</td><td>등록일</td><td>조회수</td></tr>
<%
while(rs.next()){
	%>
<tr><td><%=rs.getInt("num") %></td>
    <td><%=rs.getString("name") %></td>
    <td><a href="content.jsp?num=<%=rs.getInt("num")%>"><%=rs.getString("subject") %></a></td>
    <td><%=rs.getString("date") %></td>
    <td><%=rs.getInt("readcount") %></td></tr>	
	<%
}
%>
</table>
</body>
</html>
