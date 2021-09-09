<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.ArrayList, ask.model.vo.Ask, java.sql.Date"  %>
<%
	ArrayList<Ask> list = (ArrayList<Ask>)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<style type="text/css">
a, a:hover{ color : #2e2efe;
	text-decoration:none;
}
.asklisttable th{
	background-color: #8181F7;
	color: white;
	border: 0px solid #58ACFA;
	font-weight: bold;
	-webkit-border-radius: 5px;
	border-right:none;
}
.asklisttable{
	position: relative;
	left: 0px;
	top: 10px;
	border: 0px solid #0404B4;
	text-align: center;
}
h1{
	position: relative;
	text-align: center;
}
form.sform {
	text-align: center;
	width : 560px;
	margin-left : 1100px;
	margin-bottom : 1px;
}
.aid{
	position: relative;
	left : 1470px;
	border: 0px solid #58ACFA;
	background-color: #8181F7;
	color: white;
	-webkit-border-radius: 5px;
}
input[name="keyword"]{ background-color: #8181F7;}
</style>
<title>북적북적</title>
<body>
<%@ include file="../common/menubar.jsp" %>
<h1 align="center">북적 북적 1:1문의</h1>
<%-- 제목 검색 폼 --%>
<form id="titleform" class="sform" action="/bookjeok/asearch" method="get">
<input type="hidden" name="action" value="title">
제목 : <input type="search" name="keyword"> &nbsp; 
<input type="submit" value="검색" readonly>
</form>
<% if (loginUser == null) { %>
 &nbsp;
<%}else{ %>
<button onclick="javascript:location.href='/bookjeok/views/ask/askWriteForm.jsp';" class= "aid">문의글 작성</button>
<%} %>
<table align="center" width="1000" border="1" id ="table" class="asklisttable">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>문의분류</th>
	<th>작성일</th>
	<th>문의상태</th>
	<th>첨부파일</th>
</tr>
<% for(Ask a : list){ %>
<tr>
	<td><%= a.getAskNum() %></td>
	<td><a href="/bookjeok/adetail?askNum=<%= a.getAskNum() %>"><%= a.getAskTitle() %></a></td>
	<td><%= a.getAskWriterId() %></td>
	<td><%= a.getAskGroup() %></td>
	<td><%= a.getWriteDate() %></td>
	<td><%= a.getAskState() %></td>
	<td>
		<% if(a.getAskOriginalFile() != null){ %>
		◎
		<% }else{ %>
			&nbsp;
		<% } %>
		</td>
	</tr>
	<% } %> 
	</table>
	<br>
</body>
<hr>
<%@ include file="../common/footer.jsp" %>
</html>