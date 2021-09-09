<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.vo.User" %>
<%
	User user = (User)request.getAttribute("user");

	//취미 : 하나의 문자열을 "," 로 각각 분리 처리
	String[] preferres = user.getPreferred().split(",");
	
	//checkbox 의 checked 속성 설정을 위한 배열 만듦
	String[] checked = new String[12];
	
	for(String preferred : preferres){
		switch(preferred){
		case "소설": checked[0] = "checked";  break;
		case "경제/경영": checked[1] = "checked";  break;
		case "자기계발": checked[2] = "checked";  break;
		case "시/에세이": checked[3] = "checked";  break;
		case "인문": checked[4] = "checked";  break;
		case "국어/외국어": checked[5] = "checked";  break;
		case "역사/풍속/신화": checked[6] = "checked";  break;
		case "사회/정치/법": checked[7] = "checked";  break;
		case "가정/생활/요리": checked[8] = "checked";  break;
		case "여행/취미": checked[9] = "checked";  break;
		case "건강/의학": checked[10] = "checked";  break;
		case "기타 장르": checked[11] = "checked";  break;
		}
	}
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
.outer input[type=button] {
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

<div class="content" align="center">
<center>
<br>
<form action="/bookjeok/uprofileupdate" method="post" onsubmit="return validate();">
<input type="hidden" name="userid" value="<%= user.getUserId() %>">
<table class="outer" align="center" width="600" cellspacing="5" cellpadding="0" style="color: white;">
	<tr><th colspan="2" style="font-size: 16pt;">회원정보</th></tr>
	<tr><th width="120">닉네임</th>
		<td><input type="text" name="nickname" id="nickname" value="<%= user.getNickName() %>"> &nbsp;
			<input type="button" value="중복체크" onclick="return dupNickCheck();"></td></tr>
	<tr><th width="120">이름</th>
		<td><input type="text" name="usernm" id="usernm" value="<%= user.getUserNm() %>"></td></tr>
	<tr><th width="120">등 급</th>
		<td><input type="text" name="userrank" value="<%= user.getUserRank() %>" readonly></td></tr>
	<tr><th width="120">포인트</th>
		<td><input type="text" name="point" value="<%= user.getPoint() %>" readonly></td></tr>
	<tr><th width="120">소 개</th>
		<td><textarea name="intro" rows="3" cols="48"><%= user.getUserIntro() %></textarea></td></tr>
	<tr><th width="120">선호 장르</th>
	<td>
		<table width="450" style="color: black;">
		<tr>
			<td><input type="checkbox" name="preferred" value="소설" <%= checked[0] %>> 소설</td>
			<td><input type="checkbox" name="preferred" value="경제/경영" <%= checked[1] %>> 경제/경영</td>
			<td><input type="checkbox" name="preferred" value="자기계발" <%= checked[2] %>> 자기계발</td>
			<td><input type="checkbox" name="preferred" value="시/에세이" <%= checked[3] %>> 시/에세이</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="preferred" value="인문" <%= checked[4] %>> 인문</td>
			<td><input type="checkbox" name="preferred" value="국어/외국어" <%= checked[5] %>> 국어/외국어</td>
			<td><input type="checkbox" name="preferred" value="역사/풍속/신화" <%= checked[6] %>> 역사/풍속/신화</td>
			<td><input type="checkbox" name="preferred" value="사회/정치/법" <%= checked[7] %>> 사회/정치/법</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="preferred" value="가정/생활/요리" <%= checked[8] %>> 가정/생활/요리</td>
			<td><input type="checkbox" name="preferred" value="여행/취미" <%= checked[9] %>> 여행/취미</td>
			<td><input type="checkbox" name="preferred" value="건강/의학" <%= checked[10] %>> 건강/의학</td>
			<td><input type="checkbox" name="preferred" value="기타 장르" <%= checked[11] %>> 기타 장르</td>
		</tr>
		</table>
	</td></tr>
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