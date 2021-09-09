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
.searchtitle {
	margin-bottom: 0px;
	color: #8904B1;
}
.navtext {
	color: #A901DB;
}
.bookname {
	width: 180px;
	height: 35px;
	-webkit-border-radius: 10px;
	border: 1px solid black;
	font-size: 12pt;
	color: #D358F7;
}
.searchbook {
	width: 80px;
	height: 40px;
	background-color: #D358F7;
	-webkit-border-radius: 15px;
	border: 1px solid black;
	font-size: 12pt;
	color: white;
}
.newcancel {
	width: 50px;
	height: 35px;
	background-color: #D358F7;
	-webkit-border-radius: 10px;
	border: 1px solid black;
	color: white;
}
</style>
<script type="text/javascript">
function movePage() {
	this.close(); 
	self.opener = self; 
	opener.close();
}
</script>
</head>
<body>
<h2 class="searchtitle" align="center" style="">도서 검색</h2>
<form action="/bookjeok/usnmwritebooksearsh" method="post" onsubmit="return movePage();" target="opener">
<h3 class="navtext" align="center">검색할 도서명을 입력해주세요.</h3>
<table align="center">
	<tr>
		<td width="180px"><input type="text" class="bookname" name="bookname"></td>
		<td><input type="submit" class="searchbook" name="searchbook" value="도서검색"></td>
	</tr>
	<tr height="15px"></tr>
	<tr><td colspan="2" align="center"><input type="button" class="newcancel" value="취소" onclick="window.close()"></td></tr>
</table>
</form>
</body>
</html>