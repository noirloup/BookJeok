<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String newreview = request.getParameter("newreview");
	String newauction = request.getParameter("newauction");
	String newnormal = request.getParameter("newnormal");
	String myusedpage = request.getParameter("myusedpage");
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
h1 {
	font-size : 52pt;
	color: #08088A;
	position: relative;
	text-align: center;
}
.loginForm {
	width: 500px;
	height: 185px;
	border: 3px solid #8181F7;
	position: relative;
	-webkit-border-radius: 10px;
}
form .loginForm {
	font-size: 16pt;
	color: #8181F7;
	font-weight: bold;
	margin: 10px;
	padding: 10px;
	position: relative;
	margin-top: 20px;
}
form .loginForm input.pos {
	position: relative;
	width: 300px;
	height: 25px;	
	color: #8181F7;
	font-size: 14pt;
}
form .loginForm .login {
	margin: 10px;
	width: 150px;
	height: 40px;
	position: relative;
	color: white;
	font-size: 16pt;
	font-weight: bold;
	background-color: #8181F7;
	-webkit-border-radius: 10px;
	margin-top: 20px;
}
form .loginForm .enroll {
	margin: 10px;
	width: 150px;
	height: 40px;
	color: white;
	font-size: 16pt;
	font-weight: bold;
	background-color: #8181F7;
	-webkit-border-radius: 10px;
	margin-top: 20px;
}
form .loginForm a {
	left: 200px;
}
input#uid, input#upwd {
	border: 2px solid #8181F7;
	-webkit-border-radius: 5px;
}
.eachtitle {
	margin-top: 0px;
	margin-bottom: 0px;
}
.findlink {
	font-size: 12pt;
	border: none;
	text-decoration: none;
	color: #8181F7;
	margin-right: 10px;
	background-color: white;
}
</style>
</head>
<body>
<form action="/bookjeok/ulogin" method="post">
<% if(newreview != null) { %>
<input type="hidden" name="newreview" value="리뷰등록하기">
<% } %>
<% if(newauction != null) { %>
<input type="hidden" name="newauction" value="경매등록하기">
<% } %>
<% if(newnormal != null) { %>
<input type="hidden" name="newnormal" value="경매등록하기">
<% } %>
<% if(myusedpage != null) { %>
<input type="hidden" name="myusedpage" value="내장터">
<% } %>
<table align="center">
	<tr>
		<td colspan="2"><h1 style="margin-bottom: 0px; font-size: 28pt;"><img src="/bookjeok/resources/bookjeok/bookjeok.png" onclick="javascript:location.href='/bookjeok/index.jsp'"><br>로그인</h1></td>
	</tr>
	<tr>
		<td><table class="loginForm">
			<tr>
				<td align="center" width="150px"><h3 class="eachtitle">아이디 : </h3></td>
				<td><input type="text" name="userid" id="uid" class="pos"></td>
			</tr>
			<tr>
				<td align="center"><h3 class="eachtitle">암 호 : </h3></td>
				<td><input type="password" name="userpwd" id="upwd" class="pos"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" name="findlink" class="findlink" value="아이디 찾기" 
						onClick="window.open('/bookjeok/views/user/userFindIdView.jsp', 
							'findIdWindow', 'width=650, height=550, scrollbars=no, resizable=no, status=no, menubar=no, toolbar=no');">
					<input type="button" name="findlink" class="findlink" value="암호 찾기" 
						onClick="window.open('/bookjeok/views/user/userFindPwdView.jsp', 
							'findPwdWindow', 'width=650, height=550, scrollbars=no, resizable=no, status=no, menubar=no, toolbar=no');">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="로그인" class="login">
				<input type="button" name="enroll" class="enroll" value="회원가입" onClick="location.href='enrollPage.html'"></td>
			</tr>
		</table></td>
	</tr>
</table>
</form>
</body>
</html>