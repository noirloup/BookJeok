<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<script type="text/javascript" src="/bookjeok/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<%@ include file="../common/adminbookmenu.jsp" %>
<h1 align="center" style="margin-top: 0px;">상품 등록</h1>
<form action="/bookjeok/bkinsert.ad" method="post" enctype="multipart/form-data">
<table align="center"  border="1" cellspacing="0" cellpadding="5">
<tr><th>도서명</th><td><input type="text" name="booknm" ></td></tr>
<tr><th rowspan="5">장르</th><td>
<input type="radio" name="bookcatecd" value="1" checked>소설  
<input type="radio" name="bookcatecd" value="2" >경제/경영 
<input type="radio" name="bookcatecd" value="3" >자기계발 
<input type="radio" name="bookcatecd" value="4" >시/에세이 
<input type="radio" name="bookcatecd" value="5" >인문 </td></tr>
<tr><td><input type="radio" name="bookcatecd" value="6" >국어/외국어 
<input type="radio" name="bookcatecd" value="7" >역사/풍속/신화 
<input type="radio" name="bookcatecd" value="8" >사회/정치/법 
<input type="radio" name="bookcatecd" value="9" >장르소설 
<input type="radio" name="bookcatecd" value="10" >코믹스 </td></tr>
<tr><td><input type="radio" name="bookcatecd" value="11" >아동 
<input type="radio" name="bookcatecd" value="12" >유아 
<input type="radio" name="bookcatecd" value="13" >예술/대중문화 
<input type="radio" name="bookcatecd" value="14" >교재/수험서 
<input type="radio" name="bookcatecd" value="15" >청소년/교양 </td></tr>
<tr><td><input type="radio" name="bookcatecd" value="16" >자연과학/공학 
<input type="radio" name="bookcatecd" value="17" >종교/역학 
<input type="radio" name="bookcatecd" value="18" >건강/의학 
<input type="radio" name="bookcatecd" value="19" >북모닝 
<input type="radio" name="bookcatecd" value="20" >여행/취미 </td></tr>
<tr><td><input type="radio" name="bookcatecd" value="21" >매거진 
<input type="radio" name="bookcatecd" value="22" >가정/생활/요리 
<input type="radio" name="bookcatecd" value="23" >컴퓨터 인터넷  </td></tr>

<tr><th>분류번호</th><td>
<input type="radio" name="booktypenum" value="1" checked>페이퍼북 
<input type="radio" name="booktypenum" value="2" >E-Book 
<input type="radio" name="booktypenum" value="3" >오디오북 </td></tr>

<tr><th>국내외번호</th><td>
<input type="radio" name="booklocnum" value="1" checked>국내 
<input type="radio" name="booklocnum" value="2">국외 </td></tr>

<tr><th>도서 이미지</th><td><input type="file" name="bookimg"></td></tr>
<tr><th>저자</th><td><input type="text" name="author"></td></tr>
<tr><th>저자소개</th><td><textarea rows="5" cols="60" name="authorintro"></textarea></td></tr>
<tr><th>ISBN</th><td><input type="number" name="isbn"></td></tr>
<tr><th>순위</th><td><input type="number" name="ranking"></td></tr>
<tr><th>도서소개</th><td><textarea rows="5" cols="60" name="bookintro"></textarea></td></tr>
<tr><th>가격</th><td><input type="number" name="bookprice"></td></tr>
<tr><th>평점</th><td><input type="number" min='1' max='10' name="avgscore"></td></tr>
<tr><th>출판사</th><td><input type="text" name="publisher"></td></tr>
<tr><th>발행일</th><td><input type="date" name="publishdate"></td></tr>
<tr><th>목차</th><td><textarea rows="5" cols="60" name="bookindex"></textarea></td></tr>
<tr><th colspan="2">
	<input type="submit" value="등록하기"> &nbsp; 
	<input type="reset" value="작성취소"> &nbsp;
	<input type="button" value="메인화면" onclick="javascript:location.href='/bookjeok/index.jsp'; return false;">
</th></tr>
</table>
</form>
<%@ include file="../common/footer.jsp" %>
</body>
</html>