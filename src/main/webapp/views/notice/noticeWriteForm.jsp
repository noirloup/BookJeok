<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<style type="text/css">
a{ text-decoration:none; 
}
th{	
	text-align: center;
	background-color: #58ACFA;
	color: white;
	border: 0px solid #58ACFA;
}
.table td{
	margin-left : 700px;
	border: 1px solid #58ACFA;
	background-color: #58ACFA;
	position:relative;
	-webkit-border-radius: 5px;
	border-collapse: separate;
}
h1{
	margin-top : 50px;
	margin-right : 50px;
}
textarea{
	background-color : #58ACFA;
	color : white;
	border: 1px solid white;
}
#td{
	margin-top : 320px;
}
input[type="text"] {border: 1px solid #58ACFA; background-color : #58ACFA; border: 1px solid White; color : white;}
input[value="등록하기"], [value="목록"], [value="작성취소"]{border: 1px solid #58ACFA; background-color : #58ACFA; border: 1px solid White; color : white;}
input[name="title"]{ width : 200px;;}
input[name="writer"], [name = "group"]{ width : 100px; border : none; }
input[name="content"]{ width : 300px; height : 100px; }
</style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<h1 align="center">글 작성</h1>
<!-- form 에서 입력값들과 파일을 함께 전송하려면 반드시 속성을 추가해야 함 : enctype="multipart/form-data" -->
<form action="/bookjeok/nwrite.ad" method="post" enctype="multipart/form-data">
	<table align="center" width="700" border="1" class = "table">
	
	<tr><th>작성자</th><td><input type="text" name="writer" readonly value="<%= loginUser.getUserId() %>"><th>분류</th>
	<td><select name="group">
	<option value = "전체공지" selected ="selected">전체공지</option>
	<option value = "이벤트공지">이벤트공지</option>
	</select></td></tr>
	<tr><th>제 목</th><td><input type="text" name="title" size="50"><th>첨부파일</th><td><input type="file" name="nfile"></td></td></tr>
	<tr><th>내 용</th><td colspan = "3"><textarea cols = "30" name="content" ></textarea></td></tr>
	<tr><th colspan="10">
	<input type="submit" value="등록하기"> &nbsp;
	<input type="reset" value="작성취소"> &nbsp;
	<input type="button" value="목록" onclick="javascript:history.go(-1); return false;">
	</th></tr>
	
</table>
</form>
</body>
<hr>
<%@ include file="../common/footer.jsp" %>
</html>