<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "notice.model.vo.Notice" %>
 <%
 	Notice notice = (Notice)request.getAttribute("notice");
 	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<style type="text/css">
a{ text-decoration:none; 
}
th{	
	text-align: center;
	background-color: #8181F7;
	color: white;
}
.detail{
	border: 1px solid #8181F7;
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
	position: relative;
	align : center;
}
textarea{
   background-color : #58ACFA;
   color : white;
   border: 1px solid white;
}
button{
	border: 1px solid #8181F7;
	background-color : #8181F7;
	border: 1px solid White; color : white;
}
</style>
</head>
<body>
<%@ include file = "../common/menubar.jsp" %>
<hr>
<h1 align = "center"><%= notice.getNoticeNum() %>번 공지글 상세보기</h1>
<br>
<table align = "center" width = "800" border = "1" class = "ntable">
<tr><th>작성자</th><td><%= notice.getNoticeWriterId() %></td><th>등록날짜</th><td><%= notice.getNoticeRegDate() %></td></tr>
<tr><th>첨부파일</th>
   <td>
   		<% if(notice.getNoticeOriginalFile() != null){ %><a href="/bookjeok/nfiledownload?nfile=<%= notice.getNoticeOriginalFile() %>&rfile=<%= notice.getNoticeRenameFile() %>">
   			<%= notice.getNoticeOriginalFile() %></a>
   		<% }else{ %>
   			&nbsp;					
   		<% } %>
   </td></tr>
<tr><th>제 목</th><td colspan = "3"><%= notice.getNoticeTitle() %></td></tr>
<tr><th>내 용</th></tr>
<tr><td colspan = "4" style="text-align:left;"><%= notice.getNoticeContent() %></td></tr>
<tr><th colspan="4"><button onclick="javascript:history.go(-1);">목록</button></th></tr>
</table>
</body>
<hr>
<%@ include file="../common/footer.jsp" %>
</html>