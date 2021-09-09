<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="book.model.vo.Book, user.model.vo.User"%>
<%
	String bkname = request.getParameter("book_nm");
	Book book = (Book)request.getAttribute("book");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
</script>
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

.certiform .inbutton {
	background-color: #8181F7;
	border: 1px solid #8181F7;
	-webkit-border-radius: 10px;
	color: white;
	font-size: 10pt;
	width: 80px;
	padding-bottom: 5px;
}
</style>
<script type="text/javascript">
function movePage(){
	window.name = "WriteForm";
	var openWin = window.open("/bookjeok/views/review/KeywordCheck.html","keywordcheck","width=500, height=600, status=no, menubar=no, toolbar=no");
	
}
</script>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>

<form class = "certiform" action="/bookjeok/rwrite" method="post" style="margin-top:40px;" enctype="multipart/form-data">
<table id="outer" align="center" width="900" cellspacing="5" cellpadding="0">


	<tr><th width="150">책제목</th>
		<td><input type="text" name="bkname" value="<%= bkname %>" readonly></td></tr>
	<tr><th width="150">리뷰제목</th>
		<td><input type="text" name="reviewname"></td></tr>
	<tr><th width="150">아이디</th>
		<td><input type="text" name="reviewwriterid" value="<%= loginUser.getUserId() %>" readonly></td>
		  <th width="150">닉네임</th>
		<td><input type="text" name="usernm" value="<%= loginUser.getNickName() %>" readonly></td></tr>	
	<tr><th width="150">이메일</th>
		<td><input type="email" name="email" value="<%= loginUser.getEmail() %>" readonly></td>
		  <th width="150">전화번호</th>
		<td><input type="tel" name="phone" value="<%= loginUser.getPhone() %>" readonly></td></tr>	
	<tr><th width="150">평점</th>
		<td><input type="number" name="score" min="1" max="10"> &nbsp;
			<input class = "inbutton" type="button" value="키워드체크" onclick="movePage()"></td>
		<th width="150">첨부파일</th><td><input type="file" name="ofile"></td></tr>
	<tr><th width="150">체크한 키워드</th>
		<td><input type="text" name="keyword" id="pcheck" style="width:375px"></td></tr>		
	<tr><th width="150">리뷰 내용</th>
		<td><textarea name="content" rows="3" cols="50"></textarea></td></tr>
	
	<tr><th colspan="5">
	<input class = "button" type="submit" value="등록하기"> &nbsp;
	<a href="/bookjeok/views/review/ReviewMainView.jsp">리뷰페이지로 이동</a>
</th></tr>





</table>
</form>
</body>
</html>