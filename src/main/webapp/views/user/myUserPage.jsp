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
.outer th { 
	background-color: #8181F7; 
	-webkit-border-radius: 5px;
}
.outer { 
	border: 2px solid #8181F7;
	position: relative;
	-webkit-border-radius: 5px;
}
table input[type=submit] { background-color: #58ACFA; -webkit-border-radius: 10px; }
table input[type=reset] { background-color: #58ACFA; -webkit-border-radius: 10px; }
div { position: relative; }
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
.content {
	left: 80px;
	top: -150px;
}
.outer input[type=text] {
	width: 350px;
}
.outer input[type=password] {
	width: 350px;
}
.outer button {
	width: 70px;
	background-color: #8181F7;
	-webkit-border-radius: 10px;
}
.outer input[type=email] {
	width: 350px;
}
.outer input[type=textarea] {
	width: 350px;
	height: 50px;
}
.outer input#maingo {
	background-color: #58ACFA;
	-webkit-border-radius: 10px;
}
#footer {
	top: -130px;
}
</style>
<script type="text/javascript" src="/bookjeok/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function validate(){
	var pwdValue = document.getElementById("upwd").value;
	var pwdValue2 = document.getElementById("upwd2").value;
	
	if(pwdValue !== pwdValue2){
		alert("암호와 암호확인의 값이 일치하지 않습니다.");
		document.getElementById("upwd2").value = "";
		document.getElementById("upwd").select();
		return false;
	}
	
	return true;
}

function dupNickCheck(){
	$.ajax({
		url: "/bookjeok/udupnickcheck",
		type: "post",
		data: {nickname: $("#nickname").val()},
		success: function(data){
			console.log("success : " + data);
			if(data == "ok"){
				alert("사용 가능한 닉네임입니다.");
				$("#usernm").focus();
			}else{
				alert("이미 사용중인 닉네임입니다.");
				$("#nickname").select();
			}
		},
		error: function(jqXHR, textStatus, errorThrown){
			console.log("error : " + jqXHR + ", " 
					+ textStatus + ", " + errorThrown);
		}
	});
	
	return false;
}

function moveMain() {
	location.href="index.jsp";
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

<div class="content">
<center>
<br>
<form action="/bookjeok/uinfoupdate" method="post" onsubmit="return validate();">
<table class="outer" align="center" width="600" cellspacing="5" cellpadding="0" style="color: white;">
	<tr><th colspan="2" style="font-size: 16pt;">회원정보</th></tr>
	<tr><th width="120">아이디</th>
		<td><input type="text" name="userid" value="<%= user.getUserId() %>" readonly></td></tr>
	<tr><th width="120">암호</th>
		<td><input type="password" name="userpwd" id="upwd" value="<%= user.getUserPwd() %>"></td></tr>
	<tr><th width="120">암호확인</th>
		<td><input type="password" id="upwd2"></td></tr>
	<tr><th width="120">이름</th>
		<td><input type="text" name="usernm" id="usernm" value="<%= user.getUserNm() %>"></td></tr>
	<tr><th width="120">나이</th>
		<td><input type="number" name="age" value="<%= user.getAge() %>"></td></tr>
	<tr><th width="120">성별</th>
	<td style="color:black;">
		<% if(user.getGender().equals("M")){ %>
		<input type="radio" name="gender" value="M" checked> 남자 &nbsp;
		<input type="radio" name="gender" value="F"> 여자
		<% }else{ %>
		<input type="radio" name="gender" value="M"> 남자 &nbsp;
		<input type="radio" name="gender" value="F" checked> 여자
		<% } %>
	</td></tr>
	<tr><th width="120">전화번호</th>
		<td><input type="tel" name="phone" value="<%= user.getPhone() %>"></td></tr>
	<tr><th width="120">이메일</th>
		<td><input type="email" name="email" value="<%= user.getEmail() %>"></td></tr>
	
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script>
		/*  검색 단추를 누르면 팝업 레이어가 열리도록 설정한다. */
		$(function(){
			$("#postcodify_search_button").postcodifyPopUp();
		});
	</script>
	
	<tr><th width="120">우편번호</th>
		<td><input type="text" name="post" class="postcodify_postcode5" size="6" value="<%= user.getPost() %>">
			<button type="button" id="postcodify_search_button">검색</button></td></tr>
	<tr><th width="120">도로명 주소</th>
		<td><input type="text" name="address1" class="postcodify_address" value="<%= user.getAddr() %>"></td></tr>
	<tr><th width="120">상세 주소</th>
		<td><input type="text" name="address2" class="postcodify_extra_info" value="<%= user.getAddrDetail() %>"></td></tr>
	<tr height="35"><th colspan="2">
		<input type="submit" value="수정하기"> &nbsp; 
		<input type="reset" value="작성취소"> &nbsp;
		<input type="button" id="maingo" value="메인으로" onclick="return moveMain()">
	</th></tr>
</table>
</form>
</center>
</div>

<%@ include file="../common/footer.jsp" %>
</body>
</html>