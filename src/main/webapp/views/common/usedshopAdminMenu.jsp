<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<style type="text/css">
.leftmenu {
	position: relative;
	left: -375px;
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
.leftmenu table tr {
	margin-top: 0px;
}
</style>
</head>
<body>

<table cellspacing="1" cellpadding="0" align="center" class="leftmenu">
	<tr><td><input type="button" class="category" value="경매 장터" onclick="javascript:location.href='/bookjeok/usaulist.ad';"></td></tr>
	<tr><td style="position: relative; z-index:1;"><input type="button" class="category" value="일반 장터" onclick="javascript:location.href='/bookjeok/usnmlist.ad';"></td></tr>
</table>

</body>
</html>