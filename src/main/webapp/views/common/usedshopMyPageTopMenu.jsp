<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.vo.User" %>
<%
	User mypageloginUser = (User) session.getAttribute("loginUser");
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
</style>
</head>
<body>

<table cellspacing="0" cellpadding="0" class="topmenu" align="center">
	<tr>
		<td><input type="button" value="경매 장터" onclick="javascript:location.href='/bookjeok/views/usedshop/UsedAuctionMainView.jsp';"></td>
		<td><input type="button" value="일반 장터" onclick="javascript:location.href='/bookjeok/views/usedshop/UsedNormalMainView.jsp';"></td>
		<td><input type="button" value="내 장터" onclick="javascript:location.href='/bookjeok/usaumylist?userid=<%= mypageloginUser.getUserId() %>';"></td>
	</tr>
</table>

<table cellspacing="1" cellpadding="0" align="center" class="leftmenu">
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usaumylist?userid=<%= mypageloginUser.getUserId() %>';">나의 경매</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usnmmylist?userid=<%= mypageloginUser.getUserId() %>';">나의 일반</button></td></tr>
	<tr><td><button class="category" onclick="javascript:location.href='/bookjeok/usaumybidlist?userid=<%= mypageloginUser.getUserId() %>';">입찰 상품</button></td></tr>
</table>

</body>
</html>