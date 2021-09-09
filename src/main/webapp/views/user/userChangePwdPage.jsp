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
h1 {
	font-size : 52pt;
	color: #08088A;
	position: relative;
	text-align: center;
}
.changePwdForm {
	width: 500px;
	height: 185px;
	border: 3px solid #8181F7;
	position: relative;
	-webkit-border-radius: 10px;
}
form .changePwdForm {
	font-size: 16pt;
	color: #8181F7;
	font-weight: bold;
	margin: 10px;
	padding: 10px;
	position: relative;
	margin-top: 20px;
}
form .changePwdForm input.upwd {
	position: relative;
	width: 300px;
	height: 25px;
	border: 2px solid #8181F7;
	-webkit-border-radius: 5px;
	color: #8181F7;
	font-size: 14pt;
}
form .changePwdForm input.upwd2 {
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
form .changePwdForm .login {
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
form .changePwdForm .cancel {
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
<script type="text/javascript">
function movePage() {
	var pwdValue = document.getElementById("upwd").value;
	var pwdValue2 = document.getElementById("upwd2").value;
	
	if(pwdValue !== pwdValue2){
		alert("암호와 암호확인의 값이 일치하지 않습니다.");
		document.getElementById("upwd2").value = "";
		document.getElementById("upwd").select();
		return false;
	}
	
	this.close(); 
	self.opener = self; 
	opener.close();
}
</script>
</head>
<body>
<form action="/bookjeok/uchangepwd" method="post" onsubmit="return movePage();" target="opener">
<table align="center">
	<tr>
		<td colspan="2"><h1 style="margin-bottom: 0px; font-size: 28pt;"><img src="/bookjeok/resources/bookjeok/bookjeok.png"><br>암호 변경</h1></td>
	</tr>
	<tr>
		<td><table class="changePwdForm">
			<tr>
				<td align="center" width="150px" colspan="2"><h3 class="eachtitle"><%= user.getUserNm() %> 님의 아이디는<br>
					<input type="text" name="userid" id="uid" class="userid" value="<%= user.getUserId() %>" readonly> 입니다.</h3></td>
			</tr>
			<tr>
				<td align="center" style="margin-top: 15px;"><h5 class="eachtitle" style="margin-top: 15px;">변경할 암호 : </h5></td>
				<td><input type="password" name="userpwd" id="upwd" class="upwd" style="margin-top: 15px;"></td>
			</tr>
			<tr>
				<td align="center"><h5 class="eachtitle">변경할 암호 확인 : </h5></td>
				<td><input type="password" name="userpwd" id="upwd2" class="upwd2"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="변경하기" class="login">
				<input type="button" name="cancel" class="cancel" value="취소" onClick="window.close()"></td>
			</tr>
		</table></td>
	</tr>
</table>
</form>
</body>
</html>