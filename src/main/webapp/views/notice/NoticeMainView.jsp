<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.ArrayList, notice.model.vo.Notice, java.sql.Date"  %>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css" position = "relative">
a, a:hover{ color : #2e2efe;
	text-decoration:none;
}
.nlisttable th{ background-color: #8181F7;
	color: white;
	border: 0px solid #58ACFA;
	font-weight: bold;
	-webkit-border-radius: 5px;
	border-right:none;
	}
.nlisttable{
	position: relative;
	left: 0px;
	top: 10px;
	border: 0px solid #0404B4;
	text-align: center;
}
.pagediv{	
	position: relative;
		
}
h1{
	position: relative;
	text-align: center;
}
form.sform {
	text-align: center;
	color: #0404B4;
	width : 560px;
	-webkit-border-radius : 1px;
	margin-left : 750px;
}
#title,content{
	position: relative;
	margin-left : 850px;
}
button{
	position: relative;
	margin-left : 1470px;
	border: 0px solid #58ACFA;
	background-color: #8181F7;
	color: white;
	margin-bottom : 1px;
	-webkit-border-radius: 5px;
}
.mainselected legend{
	margin-left : 850px;
}
.mainselected{
	position: relative;
	left : 100px;
}
</style>
<title>북적북적</title>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<h1 align="center">북적 북적 공지사항</h1>
<%-- 제목 검색 폼 --%>
<form id="titleform" class="sform" action="/bookjeok/nsearch" method="get">
<input type="hidden" name="action" value="title">
제목 : <input type="search" name="keyword"> &nbsp; 
<input type="submit" value="검색" readonly>
</selected>
</form>
<table align="center" width="1000" border="1"class = "nlisttable">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>분류</th>
	<th>첨부파일</th>
	<th>날짜</th>
	<th>조회수</th>
</tr>
<% for(Notice n : list){ %>
<tr>
	<td align = "center" ><%= n.getNoticeNum() %></td>
	<td align = "center" ><a href="/bookjeok/ndetail?noticeNum=<%= n.getNoticeNum() %>"><%= n.getNoticeTitle() %></a></td>
	<td align = "center"><%= n.getNoticeWriterId() %></td>
	<td align = "center"><%= n.getNoticeGroup() %></td>
	<td align="center">
		<% if(n.getNoticeOriginalFile() != null){ %>
			◎
		<% }else{ %>
			&nbsp;
		<% } %>
	</td>
	<td align = "center"><%= n.getNoticeRegDate() %></td>
	<td align = "center"><%= n.getViewCount() %></td>
</tr>
<% } %> 
</table>
<br>
</body>
<hr>
<%@ include file="../common/footer.jsp" %>
</html>