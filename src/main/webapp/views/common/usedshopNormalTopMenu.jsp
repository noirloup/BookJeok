<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.vo.User" %>
<%
	User normalloginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR&display=swap" rel="stylesheet">
<style type="text/css">
* { font-family: 'Noto Serif KR', serif; }
.topmenu input[type=button] {
	align: center;
	float: left;
	width: 300px;
	height: 50px;
	background-color: #8258FA;
	-webkit-border-radius: 15px;
	font-size: 16pt;
	color: white;
	position: relative;
}
.topmenu input[type=submit] {
	align: center;
	float: left;
	width: 300px;
	height: 50px;
	background-color: #8258FA;
	-webkit-border-radius: 15px;
	font-size: 16pt;
	color: white;
	position: relative;
}
.leftmenu {
	position: relative;
}
.textdiv {
	align: center;
	background-color: #8181F7;
	width: 146px;
	height: 35px;
	-webkit-border-radius: 10px;
	border: 2px solid #5858FA;
	font-size: 14pt;
	text-align: center;
	padding-top: 7px;
}
.lmenubutton[type=button] {
	width: 150px;
	height: 35px;
	background-color: #58ACFA;
	-webkit-border-radius: 10px;
	color: white;
}
.leftmenu {
	position: relative;
	left: -375px;
}
.leftmenu .catemenu {
	width: 148px;
	height: 33px;
	background-color: #58ACFA;
	-webkit-border-radius: 10px;
	text-align: center;
	border: 1px solid black;
}
.category {
	width: 150px;
	height: 35px;
	background-color: #58ACFA;
	-webkit-border-radius: 10px;
	text-align: center;
	border: 1px solid black;
	font-size: 12pt;
	color: white;
}
.catemenu a {
	text-decoration: none;
	color: white;
}
.leftmenu table tr {
	margin-top: 0px;
}
.newnormal {
	position: relative;
	background-color: #7B3F3F;
	border: 3px solid #4C2E2E;
	-webkit-border-radius: 20px;
	color: white;
	font-size: 18pt;
	width: 180px;
	height: 50px;
	left: 350px;
	top: -975px;
	z-index: 1;
}
</style>
</head>
<body>

<table cellspacing="0" cellpadding="0" class="topmenu" align="center">
	<tr>
		<td><input type="button" value="경매 장터" onclick="javascript:location.href='/bookjeok/views/usedshop/UsedAuctionMainView.jsp';"></td>
		<td><input type="button" value="일반 장터" onclick="javascript:location.href='/bookjeok/views/usedshop/UsedNormalMainView.jsp';"></td>
		<% if(normalloginUser == null) { %>
			<%-- 비로그인일 때 --%>
			<form action="/bookjeok/views/user/loginPage.jsp" method="get">
			<td><input type="submit" name="myusedpage" value="내 장터"></td>
			</form>
		<% }else{ %>
			<%-- 로그인했을 때 --%>
			<td><input type="button" name="myusedpage" value="내 장터" 
						onclick="javascript:location.href='/bookjeok/usaumylist?userid=<%= normalloginUser.getUserId() %>';"></td>
		<% } %>
	</tr>
</table>

<table cellspacing="1" cellpadding="0" align="center" class="leftmenu">
	<tr><td><div class="textdiv">북적북적</div></td></tr>
	<tr><td><input class="lmenubutton" type="button" value="특가 상품" onclick="javascript:location.href='/bookjeok/usnmlowpricelist';"></td></tr>
	<tr><td><div class="textdiv">장르별</div></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmalllist';">전체</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=1';">소설</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=2';">장르 소설</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=3';">경제 / 경영</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=4';">자기계발</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=5';">시 / 에세이</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=6';">인문</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=7';">국어 / 외국어</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=8';">역사 / 풍속 / 신화</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=9';">사회 / 정치 / 법</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=10';">코믹스</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=11';">아동</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=12';">유아</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=13';">예술 / 대중문화</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=14';">교재 / 수험서</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=15';">청소년 교양</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=16';">자연과학 / 공학</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=17';">종교 / 역학</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=18';">건강 / 의학</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=19';">북모닝</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=20';">여행 / 취미</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=21';">매거진</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=22';">가정 / 생활 / 요리</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmlist?category=23';">컴퓨터 / 인터넷</button></td></tr>
</table>

<center>
<% if(normalloginUser == null) { %>
	<%-- 비로그인일 때 --%>
	<form action="/bookjeok/views/user/loginPage.jsp" method="get">
	<input type="submit" class="newnormal" name="newnormal" value="등록하기"><br>
	</form>
<% }else{ %>
	<%-- 로그인했을 때 --%>
	<input type="button" class="newnormal" name="newnormal" value="등록하기" 
				onclick="window.open('/bookjeok/views/usedshop/usedshopNormalBookSearch.jsp', 
				'searchWindow', 'width=550, height=280, scrollbars=no, resizable=no, status=no, menubar=no, toolbar=no');"> <br>
<% } %>
</center>

</body>
</html>