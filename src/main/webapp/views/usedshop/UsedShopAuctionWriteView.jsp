<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="book.model.vo.Book" %>
<%
	User auctionloginUser = (User) session.getAttribute("loginUser");
	Book book = (Book)request.getAttribute("book");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<style type="text/css">
.newautitle {
	color: #642EFE;
	margin-bottom: 0;
	position: relative;
	left: -330px;
}
.booksearch {
	width: 120px;
	height: 40px;
	background-color: #8258FA;
	-webkit-border-radius: 15px;
	border: 2px solid #642EFE;
	font-size: 14pt;
	color: white;
}
.searchtable {
	position: relative;
	left: -230px;
}
.bookname {
	width: 220px;
	height: 35px;
	-webkit-border-radius: 10px;
	border: 1px solid black;
	font-weight: bold;
	font-size: 14pt;
	color: #8258FA;
}
.bookinfo {
	-webkit-border-radius: 10px;
	position: relative;
	margin-top: 15px;
	left: 100px;
}
.imgdiv {
	width: 220px;
	height: 280px;
	border: 2px solid #A9D0F5;
	-webkit-border-radius: 5px;
	float: left;
	position: relative;
	left: 650px;
	top: 5px;
}
.eachtitle {
	border: 3px solid #8258FA;
	-webkit-border-radius: 10px;
	width: 120px;
	height: 30px;
	margin-top: 0;
	margin-bottom: 0;
	text-align: center;
	color: white;
	background-color: #8181F7;
}
.eachcontent {
	margin-left: 3px;
	margin-top: 0;
	margin-bottom: 0;
	color: #8258FA;
}

.usinfo {
	-webkit-border-radius: 10px;
	position: relative;
	margin-top: 15px;
}
.qualitytitle {
	margin-top: 0;
	margin-bottom: 0;
	border: 3px solid #8258FA;
	-webkit-border-radius: 10px;
	text-align: center;
	color: white;
	background-color: #8181F7;
	height: 30px;
	width: 120px;
}
.usauquality {
	float: left;
	border: 2px solid #8258FA;
	-webkit-border-radius: 10px;
	color: #8258FA;
	width: 184px;
	height: 30px;
	margin-right: 10px;
	text-align: center;
	font-size: 14pt;
	font-weight: bold;
}
.infotitle {
	margin-top: 0;
	margin-bottom: 0;
	border: 3px solid #8258FA;
	-webkit-border-radius: 10px;
	text-align: center;
	color: white;
	background-color: #8181F7;
	height: 30px;
	width: 120px;
}
.startbid {
	border: 3px solid #8258FA;
	-webkit-border-radius: 10px;
	height: 28px;
	width: 255px;
	font-size: 13pt;
	color: #8258FA;
}
.closedate {
	border: 3px solid #8258FA;
	-webkit-border-radius: 10px;
	height: 30px;
	width: 255px;
	font-size: 13pt;
	color: #8258FA;
}
.usauintro {
	border: 3px solid #8258FA;
	-webkit-border-radius: 10px;
	font-size: 14pt;
	color: #8258FA;
}

.newnotice {
	color: #FE2E64;
	position: relative;
}
.newauctionend {
	margin-top: 15px;
	margin-right: 30px;
	margin-bottom: 20px;
	border: 3px solid #8258FA;
	-webkit-border-radius: 15px;
	width: 140px;
	height: 50px;
	font-size: 14pt;
	background-color: #5882FA;
	color: white;
	position: relative;
}
</style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>

<h1 class="newautitle" align="center">경매 등록</h1>
<br>
<table align="center" class="searchtable">
	<tr>
		<td><input type="button" class="booksearch" name="booksearch" value="도서검색" 
				onclick="window.open('/bookjeok/views/usedshop/usedshopAuctionBookSearch.jsp', 
					'searchWindow', 'width=550, height=280, scrollbars=no, resizable=no, status=no, menubar=no, toolbar=no');"></td>
		<td><input type="text" class="bookname" name="bookname" value=" <%= book.getBookNm() %> "<%= book.getBookNm() %> readonly></td>
	</tr>
</table>

<form action="/bookjeok/usauwrite" method="post" onsubmit="return validate();">
<input type="hidden" name="writerid" value="<%= auctionloginUser.getUserId() %>">
<input type="hidden" name="usedbookid" value="<%= book.getBookId() %>">

<center>
<div class="imgdiv">
	<img class="bookimg" width="100%" src="/bookjeok/resources/book_img/<%= book.getBookImg() %>">
</div>
</center>

<table class="bookinfo" align="center" width="400" cellspacing="5" cellpadding="0">
	<tr><td width="120px"><h3 class="eachtitle">도서명</h3></td>
		<td><h3 class="eachcontent"><%= book.getBookNm() %></h3></td></tr>
	<tr><td><h3 class="eachtitle">ISBN</h3></td>
		<td><h3 class="eachcontent"><%= book.getIsbn() %></h3></td></tr>
	<tr><td><h3 class="eachtitle">도서분류</h3></td>
		<td><h3 class="eachcontent"><%= book.getBookCategory() %></h3></td></tr>
	<tr><td><h3 class="eachtitle">저 자</h3></td>
		<td><h3 class="eachcontent"><%= book.getAuthor() %></h3></td></tr>
	<tr><td><h3 class="eachtitle">출판사</h3></td>
		<td><h3 class="eachcontent"><%= book.getPublisher() %></h3></td></tr>
	<tr><td><h3 class="eachtitle">출판날짜</h3></td>
		<td><h3 class="eachcontent"><%= book.getPublishDate() %></h3></td></tr>
	<tr><td><h3 class="eachtitle">정 가</h3></td>
		<td><h3 class="eachcontent"><%= book.getBookPrice() %></h3></td></tr>
</table>

<table class="usinfo" id="usauinfo" align="center" width="800" cellspacing="5" cellpadding="0">
	<tr><td colspan="4"><h3 class="qualitytitle">품 질</h3></td></tr>
	<tr><td colspan="4" style="padding-left: 3px">
			<div class="usauquality"><input type="radio" name="usauquality" value="S" required>S 급</div>
			<div class="usauquality"><input type="radio" name="usauquality" value="A" required>A 급</div>
			<div class="usauquality"><input type="radio" name="usauquality" value="B" required>B 급</div>
			<div class="usauquality"><input type="radio" name="usauquality" value="C" required>C 급</div>
		</td>
	</tr>
	<tr><th width="120px"><h3 class="infotitle">입찰 시작가</h3></th>
		<td width="265px"><input type="number" class="startbid" name="startbid" required></td>
		<th width="120px"><h3 class="infotitle">마감 날짜</h3></th>
		<td><input type="date" class="closedate" name="closedate" required></td>
	</tr>
	<tr><th colspan="4" align="left"><h3 class="infotitle">상품 소개</h3></th></tr>
	<tr>
		<td colspan="4">
			<textarea rows="7" cols="70" class="usauintro" name="usauintro"></textarea>
		</td>
	</tr>
</table>

<h3 class="newnotice" style="margin-bottom: 0px;" align="center">경매는 등록하면 정보를 바꿀 수 없습니다.</h3>
<h3 class="newnotice" style="margin-top: 0px; margin-bottom: 5px;" align="center">허위 매물이 되지 않도록, 신중히 작성해주세요.</h3>
<center>
<input type="submit" class="newauctionend" name="submit" value="등록하기">
<input type="reset" class="newauctionend" name="reset" value="취소하기">
</center>
</form>

<%@ include file="../common/footer.jsp" %>
</body>
</html>