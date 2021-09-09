<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
.findPwdForm {
	width: 500px;
	height: 185px;
	border: 3px solid #8181F7;
	position: relative;
	-webkit-border-radius: 10px;
}
form .findPwdForm {
	font-size: 16pt;
	color: #8181F7;
	font-weight: bold;
	margin: 10px;
	padding: 10px;
	position: relative;
	margin-top: 20px;
}
form .findPwdForm input.pos {
	position: relative;
	width: 300px;
	height: 25px;
	border: 2px solid #8181F7;
	-webkit-border-radius: 5px;
	color: #8181F7;
	font-size: 14pt;
}
.userid {
	position: relative;
	width: 150px;
	height: 25px;
	border: 2px solid #8181F7;
	-webkit-border-radius: 5px;
	color: #8181F7;
	font-size: 14pt;
}
form .findPwdForm .login {
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
form .findPwdForm .cancel {
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
<form action="/bookjeok/ufindpwd" method="post">
<table align="center">
	<tr>
		<td colspan="2"><h1 style="margin-bottom: 0px; font-size: 28pt;"><img src="/bookjeok/resources/bookjeok/bookjeok.png"><br>암호 찾기</h1></td>
	</tr>
	<tr>
		<td><table class="findPwdForm">
			<tr>
				<td align="center" width="150px"><h3 class="eachtitle">아이디 : </h3></td>
				<td><input type="text" name="userid" id="uid" class="pos"></td>
			</tr>
			<tr>
				<td align="center" width="150px"><h3 class="eachtitle">이 름 : </h3></td>
				<td><input type="text" name="username" id="uname" class="pos"></td>
			</tr>
			<tr>
				<td align="center"><h3 class="eachtitle">전화번호 : </h3></td>
				<td><input type="tel" name="phone" id="phone" class="pos"></td>
			</tr>
			<tr>
				<td></td><td><b style="color: #8181F7;">( - 없이 입력해주세요.)</b></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="찾기" class="login">
				<input type="button" name="cancel" class="cancel" value="취소" onClick="window.close()"></td>
			</tr>
		</table></td>
	</tr>
</table>
</form>
</body>
</html>