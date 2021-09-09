<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="usedshop.model.vo.UsedShopNormalSelect" %>
<%
	UsedShopNormalSelect usnmselect = (UsedShopNormalSelect)request.getAttribute("usnmselect");
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
form {
	position: relative;
	color: #8181F7;
}
input[type='text'] {
	position: relative;
	text-align: center;
	width: 120px;
	color: #8181F7;
	font-size: 14pt;
	border: 2px solid #8181F7;
	-webkit-border-radius: 5px;
}
.context {
	color: #8181F7;
	font-size: 18pt;
}
b.navtext {
	position: relative;
	color: #FE2E64;
	top: 25px;
	font-size: 18pt;
}
input[type=button], input[type=submit] {
	position: relative;
	font-size: 16pt;
	top: 50px;
	width: 150px;
	height: 60px;
	border: 3px solid #210B61;
	-webkit-border-radius: 10px;
}
input[type=button] {
	background-color: #8181F7;
	margin-right: 30px;
	color: white;
}
input[type=submit] {
	background-color: #FE2E64;
	color: white;
	font-weight: bolder;
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
<center>
<br>
<b id="title"><font size="14" color="#8181F7">장터 글 삭제</font></b>
<br><br>
<form action="/bookjeok/usnmdelete" method="post" onsubmit="return movePage();" target="opener">
<input type="hidden" name="marketid" value="<%= usnmselect.getnMarketCd() %>">
<input type="text" name="writerid" value="<%= usnmselect.getUserWriterId() %>"><b class="context"> 님이 작성한</b><br>
<input type="text" name="bookname" value="<%= usnmselect.getBookNm() %>" readonly><b class="context"> 글을</b><br>
<b class="navtext">정말로 삭제하시겠습니까?</b><br>
<b class="navtext">삭제한 글은 되돌릴 수 없습니다.</b><br>
<input type="button" value="취소" onclick="window.close()">
<input type="submit" value="삭제"">
</form>
</center>
</body>
</html>