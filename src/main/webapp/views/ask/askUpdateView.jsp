<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ask.model.vo.Ask" %>
<%
	Ask ask = (Ask)request.getAttribute("ask");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<style type="text/css">
th{	
	text-align: center;
	background-color: #8181F7;
	color: white;
}
h1{
	margin-top : 50px;
	margin-right : 50px;
}
input[type="text"] {border: 1px solid #8181F7; background-color : #8181F7; border: 1px solid White; color : white;}
input[value="수정하기"], [value="목록"], [value="수정취소"]{border: 1px solid #8181F7; background-color : #8181F7; border: 1px solid White; color : white;}
input[name="title"]{ width : 200px;;}
input[name="writer"], [name = "group"]{ width : 100px; border : none; }
input[name="content"]{ width:300px; height :100px; font-size : 20px;  }
</style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<hr>
<h1 align="center"><%= ask.getAskNum() %>번 문의글 수정</h1>
<br>
<!-- form 에서 입력값들과 파일을 함께 전송하려면
반드시 속성을 추가해야 함 : enctype="multipart/form-data" -->
<form action="/bookjeok/aupdate" method="post" enctype="multipart/form-data">

<input type="hidden" name="askNum" value="<%= ask.getAskNum() %>">	
<input type="hidden" name="afile" value="<%= ask.getAskOriginalFile()%>">
<input type="hidden" name="rfile" value="<%= ask.getAskRenameFile() %>">

<table align="center" width="800" border="1" class = "table">
<tr><th>작성자</th><td><input type="text" name="writer" readonly value="<%= loginUser.getUserId() %>"></td></tr>
<tr><th>첨부파일</th>
	<td>
		<% if(ask.getAskOriginalFile() != null){ %>
			<%= ask.getAskOriginalFile() %> &nbsp; 
			<input type="checkbox" name="deleteFlag" value="yes"> 파일삭제 <br> 변경 : <input type="file" name="upfile">
		<% }else{ %>
			첨부된 파일 없음 <br> 추가 : <input type="file" name="upfile">			
		<% } %>	
	</td></tr>
<tr><th>제 목</th><td><input type="text" name="title" size="100" value="<%= ask.getAskTitle() %>"></td></tr>
<tr><th>내 용</th><td><textarea rows="5" cols="50" name="content"><%= ask.getAskContent() %></textarea></td></tr>
<tr><th colspan="2">
	<input type="submit" value="수정하기"> &nbsp; 
	<input type="reset" value="수정취소"> &nbsp;
	<input type="button" value="목록" onclick="javascript:location.href='/bookjeok/alist'; return false;">
</th></tr>
</table>
</form>
<br>
<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>