<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="user.model.vo.User"%>
<%
	//로그인 확인을 위해서 내장된 session 객체를 이용
	User loginUser = (User) session.getAttribute("loginUser");
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
.imgtd {
	position: relative;
}
.teamlogo {
	width: 181px;
	height: 104px;
	position: relative;
}

.bartd {
	position: relative;
	left: 260px;
}
.topbar {
	border: 2px solid #8181F7;
	background-color: #8181F7;
	-webkit-border-radius: 10px;
	color: white;
	position: relative;
}
.topbar td {
	border: 2px solid #8181F7;
	background-color: #8181F7;
	-webkit-border-radius: 10px;
	text-align: center;
}
.topbar td a {
	text-decoration: none;
	color: white;
}

.admintopbar {
	border: 2px solid #8181F7;
	background-color: #8181F7;
	-webkit-border-radius: 10px;
	color: white;
	position: relative;
}
.admintopbar td {
	border: 2px solid #8181F7;
	background-color: #8181F7;
	-webkit-border-radius: 10px;
	text-align: center;
}
.admintopbar td a {
	text-decoration: none;
	color: white;
}

.logintopbar {
	border: 2px solid #8181F7;
	background-color: #8181F7;
	-webkit-border-radius: 10px;
	color: white;
	position: relative;
}
.logintopbar td {
	border: 2px solid #8181F7;
	background-color: #8181F7;
	-webkit-border-radius: 5px;
	text-align: center;
}
.logintopbar td a {
	text-decoration: none;
	color: white;
}

.mainbar {
	list-style: none;
	position: relative;
}
.mainbar li {
	float: left;
	width: 180px;
	height: 40px;
	margin-right: 5px;
	padding: 0;
	font-size : 20pt;
}
.mainbar li a {
	text-decoration: none;
	width: 180px;
	height: 50px;
	display: block;
	background: #8181F7;
	color: navy;
	text-align: center;
	font-weight: bold;
	margin: 0;
	text-shadow: 1px 1px 2px white;
	padding-top: 5px;
	-webkit-border-radius: 10px;
	border: 2px solid #5858FA;
}
.mainbar li a:hover {
	text-decoration: none;
	width: 180px;
	height: 50px;
	display: block;
	background: #2E2EFE;
	color: white;
	text-align: center;
	font-weight: bold;
	margin: 0;
	text-shadow: 1px 1px 2px navy;
	padding-top: 5px;
	-webkit-border-radius: 10px;
}

.adminmainbar {
	list-style: none;
	position: relative;
	/* top: -30px; */
}
.adminmainbar li {
	width: 150px;
	height: 40px;
	margin-right: 5px;
	padding: 0;
	font-size : 18pt;
}
.admmbutton {
	text-decoration: none;
	width: 150px;
	height: 55px;
	display: block;
	background: #8181F7;
	color: navy;
	font-size: 18pt;
	text-align: center;
	font-weight: bold;
	margin: 0;
	text-shadow: 1px 1px 2px white;
	padding-top: 5px;
	-webkit-border-radius: 10px;
	border: 2px solid #5858FA;
	cursor: pointer;
}
.mainbar input.mmbutton[type="button"]:hover {
	text-decoration: none;
	width: 180px;
	height: 55px;
	display: block;
	background: #2E2EFE;
	color: white;
	text-align: center;
	font-weight: bold;
	margin: 0;
	text-shadow: 1px 1px 2px navy;
	padding-top: 5px;
	-webkit-border-radius: 10px;
}
.adminmainbar input.admmbutton[type="button"]:hover {
	text-decoration: none;
	width: 150px;
	height: 55px;
	display: block;
	background: #2E2EFE;
	color: white;
	text-align: center;
	font-weight: bold;
	margin: 0;
	text-shadow: 1px 1px 2px navy;
	padding-top: 5px;
	-webkit-border-radius: 10px;
}
.mmbutton {
	text-decoration: none;
	width: 180px;
	height: 55px;
	display: block;
	background: #8181F7;
	font-size: 18pt;
	color: navy;
	text-align: center;
	font-weight: bold;
	margin: 0;
	text-shadow: 1px 1px 2px white;
	padding-top: 5px;
	-webkit-border-radius: 10px;
	border: 2px solid #5858FA;
}
hr {
	clear: both;
}
.logintopbar .dropbtn {
  background-color: #8181F7;
  color: white;
  font-size: 16px;
  border: none;
  height: 25px;
}
.logintopbar .dropdown {
  position: relative;
  display: inline-block;
}
.logintopbar .dropdown-content {
  display: none;
  position: absolute;
  background-color: #8181F7;
  min-width: 120px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
  left: -40px;
	-webkit-border-radius: 10px;
	border: 2px solid #5858FA;
}
.logintopbar .dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  color: white;
}
.logintopbar .dropdown-content a:hover {
	background-color: #2E2EFE;
	-webkit-border-radius: 10px;
}
.logintopbar .dropdown:hover .dropdown-content {display: block;}
.logintopbar .dropdown:hover .dropbtn {
	background-color: #2E2EFE;
	-webkit-border-radius: 10px;
}
.dropdown {
	height: 10px;
}
</style>
</head>
<body>
<center>
<table width="900">
	<tr>
		<td class="imgtd"><img class="teamlogo" src="/bookjeok/resources/bookjeok/bookjeok.png" onclick="javascript:location.href='/bookjeok/index.jsp'"></td>
		<td class="bartd">
		<% if (loginUser == null) { %>
		<table class="topbar">
			<tr><td><a href="/bookjeok/nlist">공지사항</td>
				<td><a href="/bookjeok/alist">1:1 문의</a></td>
				<td><a href="/bookjeok/views/user/loginPage.jsp">로그인</a></td></tr>
		</table>
		<% } else if (loginUser != null && loginUser.getAdmin().equals("Y")) { %>
		<table class="admintopbar">
		<tr><td><%=loginUser.getNickName()%>님</td>
			<td><a href="/bookjeok/ulogout">로그아웃</td></tr>
		</table>
		<% } else if (loginUser != null) { %>
		<table class="logintopbar">
			<tr><td><a href="/bookjeok/nlist">공지사항</td>
				<td><a href="/bookjeok/alist">1:1 문의</a></td>
				<td><div class="dropdown">
					<button class="dropbtn"><%=loginUser.getNickName()%>님</button>
						<div class="dropdown-content">
								<a href="/bookjeok/umyprofile?userid=<%=loginUser.getUserId()%>">마이페이지</a>
								<a href="/bookjeok/ulogout">로그아웃</a>
						</div>
					</div></td></tr>
		</table>
		<% } %>
		<br>
		</td>
	</tr>
</table>



<% if (loginUser == null) { %>
<table class="mainbar" cellspacing="0" cellpadding="0">
	<tr>
		<td><input type="button" class="mmbutton" value="도서" onclick="javascript:location.href='/bookjeok/views/book/PBookMainView.jsp';"></td>
		<td><input type="button" class="mmbutton" value="E-Book" onclick="javascript:location.href='/bookjeok/views/book/EBookMainView.jsp';"></td>
		<td><input type="button" class="mmbutton" value="오디오북" onclick="javascript:location.href='/bookjeok/views/book/ABookMainView.jsp';"></td>
		<td><input type="button" class="mmbutton" value="중고장터" onclick="javascript:location.href='/bookjeok/views/usedshop/UsedAuctionMainView.jsp';"></td>
		<td><input type="button" class="mmbutton" value="리뷰" onclick="javascript:location.href='/bookjeok/views/review/ReviewMainView.jsp';"></td>
	</tr>
</table>
<% } else if (loginUser != null && loginUser.getAdmin().equals("Y")) { %>
<table class="adminmainbar" cellspacing="0" cellpadding="0">
	<tr>
		<td><input type="button" class="admmbutton" value="회원관리" onclick="javascript:location.href='/bookjeok/ulist.ad';"></td>
		<td><input type="button" class="admmbutton" value="상품관리" onclick="javascript:location.href='/bookjeok/bklist.ad';"></td>
		<td><input type="button" class="admmbutton" value="장터관리" onclick="javascript:location.href='/bookjeok/usaulist.ad';"></td>
		<td><input type="button" class="admmbutton" value="리뷰관리" onclick="javascript:location.href='/bookjeok/rlist.ad';"></td>
		<td><input type="button" class="admmbutton" value="공지사항관리" onclick="javascript:location.href='/bookjeok/nlist.ad';"></td>
		<td><input type="button" class="admmbutton" value="1:1 문의관리" onclick="javascript:location.href='/bookjeok/alist.ad';"></td>
	</tr>
</table>
<% } else if (loginUser != null) { %>
<table class="mainbar" cellspacing="0" cellpadding="0">
	<tr>
		<td><input type="button" class="mmbutton" value="도서" onclick="javascript:location.href='/bookjeok/views/book/PBookMainView.jsp';"></td>
		<td><input type="button" class="mmbutton" value="E-Book" onclick="javascript:location.href='/bookjeok/views/book/EBookMainView.jsp';"></td>
		<td><input type="button" class="mmbutton" value="오디오북" onclick="javascript:location.href='/bookjeok/views/book/ABookMainView.jsp';"></td>
		<td><input type="button" class="mmbutton" value="중고장터" onclick="javascript:location.href='/bookjeok/views/usedshop/UsedAuctionMainView.jsp';"></td>
		<td><input type="button" class="mmbutton" value="리뷰" onclick="javascript:location.href='/bookjeok/views/review/ReviewMainView.jsp';"></td>
	</tr>
</table>
<% } %>
</center>
</body>
</html>