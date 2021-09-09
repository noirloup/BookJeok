<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
</head>
<body>
<h1>오류발생 : </h1>
<% if(exception != null){  //jsp 페이지에서 발생한 에러일 때 %>
<h3>jsp 페이지 오류 : <%= exception.getMessage() %></h3>	
<% }else{ %> 
<h3>servlet 메세지 : <%= request.getAttribute("message") %></h3>
<% } %>
<a href="/bookjeok/index.jsp">시작페이지 가기</a>
</body>
</html>






