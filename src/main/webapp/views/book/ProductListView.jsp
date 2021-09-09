<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 <%@ page import="book.model.vo.Book, java.util.ArrayList" %>    
<%
	ArrayList<Book> list = (ArrayList<Book>)request.getAttribute("list");
	int location = 0;
	int category = 0;
	if(request.getAttribute("location")!= null){
		location = ((Integer)request.getAttribute("location")).intValue();
	}
	if(request.getAttribute("category")!= null){
		category = ((Integer)request.getAttribute("category")).intValue();
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>

<style type="text/css">
img{
	display: block;
	width:195px; 
	height:291px;
	}
table#bklistviewtb{
		margin-left: 550px;
		margin-top: 0px;
		width: 680px; 
		height: 300px;
}

form.sform1 {
	text-align: center;
	width: 320px;
	height: 50px;
	position: relative;
	top: 60px;
	margin-top: 56px;
	margin-left: 703px;
}
form.sform2 {
	text-align: center;
	width: 280px;
	position: relative;
	top: 10px;
	margin-top: 0px;
	margin-left: 985px;
}

form.sform input[type=submit] {
	width: 60px;
	color: white;
	background-color: #58ACFA;
	border: 2px solid #58ACFA;
	-webkit-border-radius: 5px;
}
.booklist {
	position: relative;
	right: -850px;
	color: #3A01DF;
	margin-top: -70px;
	margin-bottom: 40px;

}
button {
	background-color: #3A01DF;
	border: 2px solid;
	-webkit-border-radius: 10px;
	color: white;
	font-size: 12pt;
	width: 95px;
	padding-bottom: 5px;
}
</style>
<script type="text/javascript" src="/bookjeok/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<%@ include file="../common/ProductMain.jsp" %>
<section>

<form id="idform" class="searchform" action="/bookjeok/plistsearch" method="post">
<% if(location>0){ %>
<input type="hidden" name="location" value="<%= location %>">
<%} %>
<% if(category>0){ %>
<input type="hidden" name="category" value="<%= category %>">
<%} %>
<div class="searchset" >
<select class="action" name="action">
<option value="booknm">책 제목</option>
<option value="author">저자</option>
</select>
<input type="search" class="keyword" name="keyword"> &nbsp; 
<input type="submit" class="submit" value="검색">
</div>
</form>

<h1 class="booklist">도서리스트</h1>
<div class="bklistviewdiv">

	<table id="bklistviewtb" border ="1"  bgcolor="LightskyBlue" style="text-align:center">
		<%for(Book book: list){%>
		<tr><td rowspan="5" ><img src="/bookjeok/resources/book_img/<%= book.getBookImg() %>" ></td></tr>
		<tr><th width="150">도서명</th><td  width="150"><%= book.getBookNm()%></td><th  width="50">평점</th><td width="150"><%= book.getAvgScore()%>/10</td></tr>
		<tr><th>출판사</th><td><%= book.getPublisher()%></td><th>저자</th><td><%= book.getAuthor()%></td></tr>
		<tr><th>도서소개</th><td colspan="4"> <%= book.getBookIntro()%></td></tr>
		<tr>
		<th width="150" colspan="2"><button class="show" onclick="javascript: location.href = '/bookjeok/bkdetail?bookid=<%= book.getBookId()%>';">상세정보</button></th>
		<th colspan="2"><button onclick="javascript: location.href = '/bookjeok/ralldetail?bookname=<%= book.getBookNm()%>';">리뷰게시판</button></th></tr>
		<%} %>
	</table>


</div>
<div>

</div>
</section>


<%@ include file="../common/footer.jsp" %>
</body>
</html>