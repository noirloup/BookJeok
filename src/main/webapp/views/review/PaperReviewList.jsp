<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="review.model.vo.ReviewList, java.util.ArrayList, java.sql.Date"%>
<%
ArrayList<ReviewList> list = (ArrayList<ReviewList>) request.getAttribute("list");
int location = 0;
int category = 0;
if(request.getAttribute("location") != null) {
	location = ((Integer)request.getAttribute("location")).intValue();
	System.out.println("location" + location);
}

if(request.getAttribute("category") != null) {
	category = ((Integer)request.getAttribute("category")).intValue();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<style type="text/css">
img#paperbookimg {
	width: 250px;
	height: 400px;
	padding: 0;
}

form.sss {
	margin-top: 20px;
	
}

div.box{
	position: relative;
    left: 320px;
    top: 20px;
    margin-right: 0px;
}

.cate {
	width: 150px;
	height: 35px;
	background-color: #58ACFA;
	-webkit-border-radius: 10px;
	text-align: center;
	border: 1px solid black;
	font-size: 12pt;
	color: white;
}

.searchform {
	align: center;
	position: relative;
	left: 550px;
}
.searchset {
	position: relative;
	width: 400px;
	height: 50px;
	border: 3px solid #5F04B4;
	-webkit-border-radius: 5px;
}
.searchtype {
	color: #8904B1;
	border: 2px solid #8904B1;
	-webkit-border-radius: 10px;
	font-size: 14pt;
	margin-top: 5px;
	height: 35px;
}

.searchform .submit {
	background-color: #D358F7;
	border: 2px solid #8904B1;
	-webkit-border-radius: 10px;
	color: white;
	font-size: 16pt;
	width: 80px;
	padding-bottom: 5px;
}

.catebox{
	align: center;
	position: relative;
	left: 370px;
}

.box {
	align: right;
	position: relative;
	width: 500px;
	height: 45px;
	border: 3px solid #5F04B4;
	-webkit-border-radius: 5px;
	font-size: 14pt;
}
	
.catebox .submit {
	background-color: #D358F7;
	border: 2px solid #8904B1;
	-webkit-border-radius: 10px;
	color: white;
	font-size: 16pt;
	width: 80px;
	padding-bottom: 5px;
}

.boxsearch {
	color: #8904B1;
	border: 2px solid #8904B1;
	-webkit-border-radius: 10px;
	font-size: 14pt;
	margin-top: 5px;
	height: 35px;
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

.keyword {
   color: #8904B1;
   border: 2px solid #8904B1;
   -webkit-border-radius: 10px;
   height: 35px;
   padding-top: 5px;
}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
<form id="sss" class = "catebox" action="/bookjeok/rpcate" method="get">
<div class="box" align="center";>카테고리 분류
<select class= "boxsearch" name= "location">
		<option name= "selection" disabled>= 국내/외 =</option>
		<option name = "location" value ="0">전  체</option>
		<option name = "location" value ="1">국내도서</option>
		<option name = "location" value ="2">국외도서</option>
</select>
<select class= "boxsearch" name="category">
    <option name="selection" id ="selection" disabled>== 장르 선택 ==</option>
    <option name="category" value="0">전  체</option>
    <option name="category" value="1" >소설</option>
    <option name="category" value="2">경제/경영</option>
    <option name="category" value="3">자기계발</option>
    <option name="category" value="4">시/에세이</option>
    <option name="category" value="5">인문</option>
    <option name="category" value="6">국어/외국어</option>
    <option name="category" value="7">역사/풍속/신화</option>
    <option name="category" value="8">사회/정치/법</option>
    <option name="category" value="9">장르소설</option>
    <option name="category" value="10">코믹스</option>
    <option name="category" value="11">아동</option>
    <option name="category" value="12">유아</option>
    <option name="category" value="13">예술/대중문화</option>
    <option name="category" value="14">교재/수험서</option>
    <option name="category" value="15">청소년교양</option>
    <option name="category" value="16">자연과학/공학</option>
    <option name="category" value="17">종교/역학</option>
    <option name="category" value="18">건강/의학</option>
    <option name="category" value="19">북모닝</option>
    <option name="category" value="20">여행/취미</option>
    <option name="category" value="21">메거진</option>
    <option name="category" value="22">가정/생활/요리</option>
    <option name="category" value="23">컴퓨터/인터넷</option>
  </select>
  <input type ='submit' class = "submit" value="이동">
  </div>
</form>


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


<form id="idform" class="searchform" action="/bookjeok/papersearch" method="post" >
<% if(location > 0) { %>
	<input type="hidden" name="location" value="<%= location %>">
<% } %>
<% if(category > 0) { %>
	<input type="hidden" name="category" value="<%= category %>">
<% } %>
<div class="searchset" align="center">
<select class="searchtype" name="searchtype">
<option value="bookname">책 제목</option>
<option value="writerid">작성자</option>
</select>
<input type="search" class="keyword" name="keyword"> &nbsp; 
<input type="submit" class="submit" value="검색">
</div>
</form>




<h4 align="center" style="font-size:3em">페이퍼북 리뷰 목록</h4>
		<%
		for (ReviewList r : list) {
		%>
		<table class = "listbox" align="center" width="600" border="1" cellspacing="0">
		
			<tr>
				<td rowspan="6" class="usimg"><a
					href="/bookjeok/rdetail?booknm=<%=r.getBookNm()%>"> <img
						id="paperbookimg"
						src="/bookjeok/resources/book_img/<%=r.getBookNm()%>.png"></a></td>
				<td colspan="2" class="uslist"><a
					href="/bookjeok/rdetail?booknm=<%=r.getBookNm()%>"><%=r.getBookNm()%></a></td>
			</tr>
			<tr>
				<td colspan="2" class="uslist"><%=r.getAuthor()%> | <%=r.getPublisher()%>
					| <%=r.getPublishDate()%>일 출간</td>
			</tr>
			<tr>
				<td colspan="2" class="uslist">평점 : <%=r.getScore()%>점
				</td>
			</tr>
			<tr>
				<td class="uslist"><%=r.getKeyword()%></td>
				<td class="uslist">작성자 : <%=r.getReviewWriterId()%></td>
			</tr>
			<tr>
				<td colspan="2" class="uslist"><%=r.getReviewContent()%></td>
			</tr>
			<tr>
				<td colspan="2" class="uslist">리뷰 등록 날짜 : <%=r.getReviewRegDate()%></td>
			</tr>
			
		</table>
		<%
		}
		%>

</body>
</html>