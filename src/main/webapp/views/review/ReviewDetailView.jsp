<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="review.model.vo.ReviewList, java.util.ArrayList, java.sql.Date" %>
<%
	ArrayList<ReviewList> list = (ArrayList<ReviewList>)request.getAttribute("list");
	ReviewList review = (ReviewList)request.getAttribute("review");
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

a {
 	text-decoration: none;
    color: #8181F7;
}

.cate a {
	text-decoration: none;
	color: white;
}

.more a {
	text-decoration: none;
	color: white;
}
</style>
</head>
<body>
<%@ include file="../common/menubar.jsp"%>

<!-- 로그인x -->
<% if(loginUser == null) { %>
	<form action="/bookjeok/views/user/loginPage.jsp">
	<input type="submit" class="newreview" name="newreview" value="리뷰 등록하기" style="float:right; color: #fff; background:#8181F7; 
				font-size:2em; border-radius:0.7em; 
				padding:5px 20px; margin-right:300px; margin-top:30px;	"><br>
	</form>
	
<% }else{ %>

	<%-- 로그인했을 때 --%>
	<form action="/bookjeok/views/review/ReviewCertificationForm.jsp">
	<input type="submit" class="newreview" name="newreview" value="리뷰 등록하기" style="float:right; color: #fff; background:#8181F7; 
				font-size:2em; border-radius:0.7em; 
				padding:5px 20px; margin-right:300px; margin-top:30px;	"><br>
	</form>
<% } %>

	<button type="button" class="cate"
		style="color: #fff; background: #8181F7; font-size: 1em; border-radius: 0.5em; padding: 5px 20px; margin-left: 300px; margin-top:10px; ">
		<a href="/bookjeok/prlist">페이퍼북</a>
	</button>
	<br>

	<button type="button" class="cate"
		style="color: #fff; background: #8181F7; font-size: 1em; border-radius: 0.5em; padding: 5px 20px; margin-left: 300px;">
		<a href="/bookjeok/erlist">E-Book</a>
	</button>
	<br>

	<button type="button" class="cate"
		style="color: #fff; background: #8181F7; font-size: 1em; border-radius: 0.5em; padding: 5px 20px; margin-left: 300px;">
		<a href="/bookjeok/arlist">오디오북</a>
	</button>
	
	<!-- 로그인x -->
<% if(loginUser != null) { %>
	<button type="button" class="more"
				style="float:right; color: #fff; background:#8181F7; 
				font-size:2em; border-radius:0.7em; 
				padding:5px 20px; margin-right:300px;"><a href="/bookjeok/rmylist?userid=<%=loginUser.getUserId()%>">나의 리뷰</a></button> <br> <br> <br>
<% } %>

<div id="detail1">		
	<table class = "listbox" align="center" width="600" border="1" cellspacing="0">
	<tr>
		<td rowspan="5" class="usimg"><img id="detailbookimg" src="/bookjeok/resources/book_img/<%= review.getBookNm() %>.png"></td>
		<td colspan="2" class="uslist"><%= review.getBookNm() %></td>
	</tr>	
	<tr>
		<td colspan="2" class="uslist"><%= review.getAuthor() %> | <%= review.getPublisher() %> | <%= review.getPublishDate() %>일 출간</td>
	</tr>
	<tr>
		<td colspan="2" class="uslist">등록된 리뷰 건수 : <%= list.size() %> </td>
	</tr>
	<tr>
		<td colspan="2" class="uslist">평균평점 : <%= review.getAvgScore() %> 점</td>
    </tr>
    <tr>
		<td colspan="2" class="uslist">리뷰 키워드 : <%= review.getKeyword() %></td>
	</tr>
	</table>	
</div>

<% for(ReviewList r : list) { %>
	<table class = "listbox" align="center" width="600" border="1" cellspacing="0">
	<tr>
		<td class="uslist"><%= r.getBookNm() %> 리뷰</td>
 	  <td class="uslist">첨부파일 : 
   		<% if(r.getReviewOriginalFile() != null){ %>
   			<a href="/bookjeok/rfdown?ofile=<%= r.getReviewOriginalFile() %>&rfile=<%= r.getReviewRenameFile() %>"><%= r.getReviewOriginalFile() %></a>
   		<% }else{ %>
   			&nbsp;
   		<% } %>
 	  </td>
	</tr>
	<tr>
		<td class="uslist">평점 : <%= r.getScore() %>점</td>
		<td class="uslist">키워드 : <%= r.getKeyword() %></td>
	</tr>
	<tr>
		<td colspan="2" class="uslist"><%= r.getReviewContent() %></td>
	</tr>
	<tr>
		<td class="uslist">리뷰 등록 날짜 : <%= r.getReviewRegDate() %></td>
		<td class="uslist">작성자: <%= r.getReviewWriterId() %></td>
	</tr><br>
	</table>
<% } %>

</body>
</html>