<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.vo.User" %>
<%
	User user = (User)request.getAttribute("user");    
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
div { position: relative; }
.quitcontent {
	position: relative;
	left: 770px;
	top: -100px;
	border: 3px solid #58ACFA;
	width: 500px;
	height: 330px;
	-webkit-border-radius: 10px;
}
.leftmenu {
	left: -375px;
}
.leftmenu input[type='button'] {
	position: relative;
	z-index: 1;
}
.leftmenu .textdiv {
	align: center;
	background-color: #8181F7;
	width: 146px;
	height: 40px;
	-webkit-border-radius: 10px;
	border: 2px solid navy;
	font-size: 16pt;
	text-align: center;
	padding-top: 7px;
}
.leftmenu input[type=button] {
	width: 150px;
	height: 35px;
	background-color: #58ACFA;
	-webkit-border-radius: 10px;
	font-color: white;
}
.outer {
	border: 2px solid #8181F7;
	background-color: #CED8F6;
	-webkit-border-radius: 10px;
	left: 75px;
}
input[type=submit] { 
	background-color: #8181F7; 
	-webkit-border-radius: 10px;
	color: white; 
	width: 120px;
	height: 50px;
	font-size: 18pt;
	margin-top: 30px;
}
form input[type=button] {
	background-color: #8181F7;
	-webkit-border-radius: 10px;
	color: white;
	width: 120px;
	height: 50px;
	margin-right: 30px;
	font-size: 18pt;
}
#footer {
	top: -60px;
}
</style>
<script type="text/javascript" src="/bookjeok/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
// 비밀번호 입력 확인
function checkValue(){
    if(!document.deleteform.password.value){
        alert("비밀번호를 입력하지 않았습니다.");
        return false;
    }
}

</script>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>

<div class="leftmenu" align="center">
<table>
	<tr><td><div class="textdiv">마이페이지</div></td></tr>
	<tr><td><input type="button" value="프로필 수정" onclick="javascript:location.href='umyprofile?userid=<%= user.getUserId() %>';"></td></tr>
	<tr><td><input type="button" value="회원 정보 수정" onclick="javascript:location.href='umyuser?userid=<%= user.getUserId() %>';"></td></tr>
	<tr><td><input type="button" value="회원 탈퇴" onclick="javascript:location.href='uquitview?userid=<%= user.getUserId() %>';"></td></tr>
</table>
</div>

<div class="quitcontent" align="center">
<br><br>
<b><font size="14" font-color="#08088A">회원 탈퇴</font></b>
<br><br>
<form action="/bookjeok/uquit" method="post" onsubmit="return checkValue()">
	<table class="outer">
		<tr><th width="120">아이디</th>
			<td><input type="text" name="userid" value="<%= user.getUserId() %>"></td></tr>
		<tr><th width="120">비밀번호</th>
			<td><input type="password" name="userpwd" maxlength="50"></td></tr>
	</table>
<br> 
<input type="button" value="취소" onclick="javascript:window.location='umyprofile?userid=<%= user.getUserId() %>'">
<input type="submit" value="탈퇴">
</form>
</div>

<%@ include file="../common/footer.jsp" %>
</body>
</html>