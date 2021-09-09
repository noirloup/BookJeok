<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="book.model.vo.Book, java.util.ArrayList" %>
  <%
  	ArrayList<Book> list = (ArrayList<Book>)request.getAttribute("list");

 %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
a {
	text-decoration: none;
	color: #8181F7;
}
.searchform {
	position: relative;
	top: 38px;
	left: 1045px;
	padding: 5px;
}
.action {
	border: 2px solid #58ACFA;
	-webkit-border-radius: 10px;
	font-size: 12pt;
	margin-top: 5px;
	height: 30px;
}

.keyword {
	color: #8904B1;
	border: 2px solid #58ACFA;
	-webkit-border-radius: 10px;
	height: 30px;
}

.searchform .submit {
	background-color: #58ACFA;
	border: 2px solid #58ACFA;
	-webkit-border-radius: 10px;
	color: white;
	font-size: 12pt;
	width: 80px;

}
.bookcondiv {
	position: relative;
	width: 870px;
	height: 360px;
	border: 2px solid #58ACFA;
	-webkit-border-radius: 5px;
	left: 500px;
	text-align: center;
	padding: 5px;
	margin: 5px;
}

</style>
<meta charset="UTF-8">
<title>북적북적</title>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<%@ include file="../common/adminbookmenu.jsp" %>

<form id="idform" class="searchform" action="/bookjeok/plistsearch.ad"" method="post">
<div class="searchset" >
<select class="action" name="action" >
<option value="booknm">책 제목</option>
<option value="author">작성자</option>
<option value="publisher">출판사</option>
</select>
<input type="search" class="keyword" name="keyword" style="width:150px;"> &nbsp; 
<input type="submit" class="submit" value="검색">
</div>
</form>

<h1 align="center" style="margin-bottom:30px; margin-top:-30px">도서목록</h1>
<br>
<table class="bookcondiv"  align="center" width="800" border="1" cellspacing="0" cellpadding="0"  style="margin-top:-30px;">
<tr>
	<th>도서아이디</th>
	<th>도서명</th>
	<th>저자</th>
	<th>출판사</th>
</tr>
<% for(Book b : list){ %>
<tr>
	<td align="center"><a href="/bookjeok/bkdetail.ad?bookid=<%= b.getBookId() %>"><%= b.getBookId() %></a></td>
	<td align="center"><a href="/bookjeok/bkdetail.ad?bookid=<%= b.getBookId() %>"><%= b.getBookNm() %></a></td>
	<td align="center"><a href="/bookjeok/bkdetail.ad?bookid=<%= b.getBookId() %>"><%= b.getAuthor() %></a></td>
	<td align="center"><a href="/bookjeok/bkdetail.ad?bookid=<%= b.getBookId() %>"><%= b.getPublisher() %></a></td>

</tr>
<% } %> 
</table>
<br>
<hr>

<%@ include file="../common/footer.jsp" %>
</body>
</html>