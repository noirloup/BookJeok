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
.asklisttable th{ background-color: #8181F7;
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
	border: 0px solid #58ACFA;
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
	background-color: #58ACFA;
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
<body>
<%@ include file="../common/menubar.jsp" %>
<h1 align="center">북적 북적 1:1문의</h1>
<%-- 제목 검색 폼 --%>
<form id="titleform" class="sform" action="/bookjeok/asearch" method="get">
<input type="hidden" name="action" value="title">
제목 : <input type="search" name="keyword"> &nbsp; 
<input type="submit" value="검색" readonly>
</form>
<table align="center" width="1000" border="1" cellspacing="0" cellpadding="0" class="asklisttable">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>분류</th>
	<th>작성일</th>
	<th>문의상태</th>
	<th>첨부파일</th>

</tr>
<% for(Ask a : list){ %>
<tr>
	<td align = "center" ><%= a.getAskNum() %></td>
	<td align = "center" ><a href="/bookjeok/adetail.ad?askNum=<%= a.getAskNum() %>"><%= a.getAskTitle() %></a></td>
	<td align	= "center"><%= a.getAskWriterId() %></td>
	<td align = "center"><%= a.getAskGroup() %></td>
	<td align = "center"><%= a.getWriteDate() %></td>
	<td align = "center"><%= a.getAskState() %></td>												
	<td align = "center">
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