<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<style type="text/css">
table th { background-color: #8181F7; }
table#outer { border: 2px solid navy; }

.certiform .button {
	background-color: #D358F7;
	border: 1px solid #8904B1;
	-webkit-border-radius: 10px;
	color: white;
	font-size: 10pt;
	width: 80px;
	padding-bottom: 5px;
}

</style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>

<form class = "certiform" action="/bookjeok/rcerti" method="post" style="margin-top:40px;">
<table id="outer" align="center" width="900" cellspacing="5" cellpadding="0">
	<tr><th colspan="2">* 인 증 *</th></tr>
	<tr><th width="150">책제목</th>
		<td><input type="text" name= "book_nm"></td></tr>
	<tr><th width="150">ISBN or 상품번호</th>
		<td><input type="text" name= "isbn"></td></tr>
	<!--  	
	<tr><th width="150">바코드 사진 등록</th>
		<td><input type="file" name="rfile"></td></tr>
	-->	 
	<tr><th colspan="2">
	<input class = "button" type="submit" value="확인" > &nbsp;
	<input class = "button" type="reset" value="취소" onclick="javascript:history.go(-1); return false;"> &nbsp;
	</th></tr>
</table>
</form>
</body>
</html>