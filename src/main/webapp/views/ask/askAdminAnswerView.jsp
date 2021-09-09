<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ask.model.vo.Ask" %>
<%
	Ask ask = (Ask)request.getAttribute("ask");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
a{ text-decoration:none; 
}
th{	
	text-align: center;
	background-color: #58ACFA;
	color: white;
	border: 0px solid #58ACFA;
}
.table{
	border: 1px solid #58ACFA;
	margin-left : 650px;
	position:relative;
	-webkit-border-radius: 5px;
	border-collapse: separate;
}
td{
	font-weight: bold;
	border: 0px solid #58ACFA;
	-webkit-border-radius: 5px;
	text-align: center;
}
h1{
	margin-top : 30px;
	margin-right : 50px;
}
textarea{
	background-color : #58ACFA;
	color : white;
	border: 1px solid white;
}
input[type="text"] {border: 1px solid #58ACFA; background-color : #58ACFA; border: 1px solid White; color : white;}
input[value="등록하기"], [value="목록"], [value="작성취소"]{border: 1px solid #58ACFA; background-color : #58ACFA; border: 1px solid White; color : white;}
input[name="title"]{ width : 200px;;}
input[name="writer"], [name = "group"]{ width : 100px; border : none; }
input[name="content"]{ width : 300px; height : 100px; }
</style>

<title>북적북적</title>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<hr>
<h1 align="center"><%= ask.getAskNum() %>번 문의글 상세보기</h1>

<form action="/bookjeok/aanswer.ad" method="post">
<input type="hidden" name="askNum" value="<%= ask.getAskNum() %>">
<table align="center" width="700"  border="1" cellspacing="0" cellpadding="0" class = "table">
<tr><th>작성자</th><td colspan = "3"><%= ask.getAskWriterId() %></td><th>등록날짜</th><td><%= ask.getWriteDate() %></td></tr>
<tr><th>첨부파일</th>
<td colspan = "3">
	<% if(ask.getAskOriginalFile() != null){ %>
		<a href="/bookjeok/afiledownload.ad?afile=<%= ask.getAskOriginalFile() %>&rfile=<%= ask.getAskRenameFile() %>">
		<%= ask.getAskOriginalFile() %></a>
	<% }else{ %>
		&nbsp;
	<% } %>
</td></tr>
<tr><th>제 목</th><td colspan = "4"><%= ask.getAskTitle() %></td></tr>
<tr><th>내 용</th></tr>
<tr><th></th><td colspan = "4"  align = "center"><%= ask.getAskContent() %></td></tr>
<tr><th>답변자 아이디</th><td colspan = "3"><input type="text" name="answerwriterid" value="<%= loginUser.getUserId() %>" readonly><th>등록날짜</th><td><%= ask.getAnswerDate() %></td></tr>
<tr><th>답변 내용</th><td colspan = "3" width="100" height="100"><input type="text" name="answer" value="<%= ask.getAnswerContent() %>"></td></tr>
<tr><th colspan="10">
	
	<input type="submit" value="답변 등록"> &nbsp;
	<input type="reset" value="취소">  &nbsp;
	<button onclick="javascript:history.go(-1)';">이전으로</button>
</th></tr>
</table>
</form>
<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>