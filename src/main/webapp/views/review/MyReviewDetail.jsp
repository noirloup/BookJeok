<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="review.model.vo.ReviewList, java.util.ArrayList, java.sql.Date" %>
<%
	ArrayList<ReviewList> list = (ArrayList<ReviewList>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<style type="text/css">
img#detailbookimg  {
	width: 250px;
	height: 400px;
	padding: 0;
	margin: 0;
}

div#detail1{
	margin-top: 50px;
}

.listbox {
	align: center;
	position: relative;
	text-align: center;
	width: 600px;
	margin-bottom: 10px;
	border: 3px solid #5F04B4;
	-webkit-border-radius: 10px;
}

.usimg {
	width: 200px;
	border: 1px solid #81BEF7;
	-webkit-border-radius: 5px;
}

.uslist {
	width: 340px;
	border: 1px solid #81BEF7;
	-webkit-border-radius: 5px;
}

.button {
	background-color: #8181F7;
	border: 1px solid #8904B1;
	-webkit-border-radius: 10px;
	color: white;
	font-size: 10pt;
	width: 100px;
	padding-bottom: 5px;
}
</style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>

<div id="detail1">	
<% for(ReviewList r : list) { %>	
<% if(loginUser.getUserId().equals(r.getReviewWriterId())) { %>
	<table class = "listbox" align="center" width="600" border="1" cellspacing="0">
	<tr>
		<td rowspan="5" class="usimg"><img id="detailbookimg" src="/bookjeok/resources/book_img/<%= r.getBookNm() %>.png"></td>
		<td colspan="2" class="uslist"><%= r.getReviewName() %></td>
	</tr>	
	<tr>
		<td class="uslist">평점 : <%= r.getScore() %> 점</td>
		<td class="uslist">작성자 : <%= r.getReviewWriterId() %></td>
	</tr>
	<tr>
		<td colspan="2" class="uslist"><%= r.getKeyword() %></td>
    </tr>
    <tr>
		<td colspan="2" class="uslist"><%= r.getReviewContent() %></td>
	</tr>
	<tr>
		<td colspan="2" class="uslist"><%= r.getReviewRegDate() %></td>
	</tr>
	<tr><th colspan="3" class="uslist">
	<button class = "button" onclick="location.href = '/bookjeok/rupdateview?reviewname=<%= r.getReviewName() %>'; return false;">수정하기</button> &nbsp; 
	<input class = "button" type="button" class="ususerbid" value="삭제하기" 
											onclick="window.open('/bookjeok/rdeleteview?reviewcd=<%= r.getReviewCd() %>', 
												'bidWindow', 'width=550, height=450, scrollbars=no, resizable=no, status=no, menubar=no, toolbar=no');"> &nbsp;
	<!-- 
	<button onclick="location.href = '/bookjeok/rdelete?reviewcd=<%= r.getReviewCd() %>&rfile=<%= r.getReviewRenameFile() %>'; return false;">삭제하기</button> &nbsp;
	 --> 
	<button class = "button" onclick="javascript:history.go(-1); return false;">목록으로 이동</button>
	</th></tr>
	</table>	
<% } %>
<% } %>
</div>


</body>
</html>