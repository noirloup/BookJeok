<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.vo.User, java.util.ArrayList" %>
<%
	ArrayList<User> list = (ArrayList<User>)request.getAttribute("list");
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
body { height: 100%; }
h1, h2 {
	position: relative;
	color: #08088A;
}
button#allshow {
	position: relative;
	background-color: #58ACFA;
	color: white;
	border: 2px solid #58ACFA;
	-webkit-border-radius: 5px;
	top: -20px;
}
fieldset#ss {
	text-align: center;
	color: #0404B4;
	width: 400px;
	height: 50px;
	position: relative;
	border: 2px solid #8181F7;
	-webkit-border-radius: 5px;
	top: -10px;
}
form.sform {
	text-align: center;
	color: #0404B4;
	display: none;
	width: 560px;
	position: relative;
	-webkit-border-radius: 5px;
	margin-bottom: 10px;
	top: -20px;
}
form.sform fieldset {
	border: 2px solid #8181F7;
	-webkit-border-radius: 5px;
}
form.sform input[type=submit] {
	width: 60px;
	color: white;
	background-color: #58ACFA;
	border: 2px solid #58ACFA;
	-webkit-border-radius: 5px;
}
hr#hr1 { 
	width: 60%;
	position: relative;
	top: -30px;
}
.userlist {
	position: relative;
	top: -30px;
	width: 850px;
	border: 2px solid #8181F7;
	text-align: center;
	-webkit-border-radius: 5px;
}
.userlist th {
	height: 15px;
	color: #0404B4;
}
input#delbutton {
	background-color: #58ACFA;
	-webkit-border-radius: 10px;
}
hr#hr2 { 
	width: 60%;
	position: relative;
	top: -10px;
}
#footer {
	position: relative;
}
</style>
<script type="text/javascript" src="/bookjeok/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	//이 영역 안에서 작성된 이벤트핸들러는 자동 실행 준비상태가 됨
	$("input[name=item]").on("change", function(){
		//여러개의 태그중에 체크상태가 바뀐 태그 처리
		$("input[name=item]").each(function(index){
			//radio 순번대로 하나씩 checked 인지 확인함
			if($(this).is(":checked")){
				$("form.sform").eq(index).css("display", "block");
			}else{
				$("form.sform").eq(index).css("display", "none");
			}
		});
	});
});
</script>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>

<h1 align="center">회원 관리</h1>
<h2 align="center">현재 회원수 : <%= list.size() %> 명</h2>
<br>
<center>
	<button onclick="javascript:location.href='/bookjeok/ulist.ad?page=1';" id="allshow">전체 목록 보기</button>
<br>
<%-- 항목별 검색 기능 추가 --%>
<fieldset id="ss">
<legend>검색할 항목을 선택하세요.</legend>
<input type="radio" name="item" id="uid"> 회원 아이디 &nbsp; 
<input type="radio" name="item" id="unick"> 회원 닉네임 &nbsp; 
<input type="radio" name="item" id="ugen"> 성별 &nbsp; 
<input type="radio" name="item" id="uage"> 연령대 &nbsp; 
</fieldset>
<br>

<%-- 검색 항목별 값 입력 전송용 폼 만들기 --%>
<form id="idform" class="sform" action="/bookjeok/usearch.ad" method="post">
<input type="hidden" name="action" value="id">
<fieldset>
아이디 : <input type="search" name="keyword"> &nbsp; 
<input type="submit" value="검색">
</fieldset>
</form>

<%-- 닉네임 검색 폼 --%>
<form id="nickform" class="sform" action="/bookjeok/usearch.ad" method="post">
<input type="hidden" name="action" value="nick">
<fieldset>
닉네임 : <input type="search" name="keyword"> &nbsp; 
<input type="submit" value="검색">
</fieldset>
</form>

<%-- 성별 검색 폼 --%>
<form id="genderform" class="sform" action="/bookjeok/usearch.ad" method="post">
<input type="hidden" name="action" value="gender">
<fieldset>
성별 : <input type="radio" name="keyword" value="M"> 남자 &nbsp; 
<input type="radio" name="keyword" value="F"> 여자 &nbsp; 
<input type="submit" value="검색">
</fieldset>
</form>

<%-- 연령대 검색 폼 --%>
<form id="ageform" class="sform" action="/bookjeok/usearch.ad" method="post">
<input type="hidden" name="action" value="age">
<fieldset>
연령대 : <input type="radio" name="keyword" value="20"> 20대 &nbsp; 
<input type="radio" name="keyword" value="30"> 30대 &nbsp; 
<input type="radio" name="keyword" value="40"> 40대 &nbsp; 
<input type="radio" name="keyword" value="50"> 50대 &nbsp; 
<input type="radio" name="keyword" value="60"> 60대 이상 &nbsp; 
<input type="submit" value="검색">
</fieldset>
</form>
</center>
<br>
<hr color="#0404B4" size="4px" id="hr1"><br>
<table align="center" class="userlist" border="2" cellspacing="0" cellpadding="4">
<tr><th>아이디</th><th>닉네임</th><th>이름</th><th>성별</th><th>나이</th>
<th>전화번호</th><th>이메일</th><th>회원 삭제</th>
<% for(User u : list){ %>
<tr>
	<td><input type="hidden" id="userid" value="<%= u.getUserId() %>"><%= u.getUserId() %></td>
	<td><%= u.getNickName() %></td>
	<td><%= u.getUserNm() %></td>
	<td><%= (u.getGender().equals("M"))? "남자": "여자" %></td>
	<td><%= u.getAge() %></td>
	<td><%= u.getPhone() %></td>
	<td><%= u.getEmail() %></td>
	<td align="center"><input id="delbutton" type="button" value="삭제" 
			onclick="window.open('/bookjeok/views/user/userDelete.jsp?userid=<%= u.getUserId() %>', 
				'deleteWindow', 'width=550, height=450, scrollbars=no, resizable=no, status=no, menubar=no, toolbar=no');"></td>
</tr>
<% } %>
</table>
<hr color="#0404B4" size="4px" id="hr2">

<%@ include file="../common/footer.jsp" %>
</body>
</html>