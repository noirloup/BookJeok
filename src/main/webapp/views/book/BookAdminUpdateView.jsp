<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="book.model.vo.Book" %>
<%
	Book book = (Book)request.getAttribute("book");

	int booktypenum = book.getBookTypeNum();
	
	String[] typechecked = new String[3];

	switch(booktypenum){
		case 1: typechecked[0] = "checked";  break;
		case 2: typechecked[1] = "checked";  break;
		case 3: typechecked[2] = "checked";  break;
	}

	int bookcatecd = book.getBookCateCd();
	
	String[] catechecked = new String[23];

	switch(bookcatecd){
		case 1: catechecked[0] = "checked";  break;
		case 2: catechecked[1] = "checked";  break;
		case 3: catechecked[2] = "checked";  break;
		case 4: catechecked[3] = "checked";  break;
		case 5: catechecked[4] = "checked";  break;
		case 6: catechecked[5] = "checked";  break;
		case 7: catechecked[6] = "checked";  break;
		case 8: catechecked[7] = "checked";  break;
		case 9: catechecked[8] = "checked";  break;
		case 10: catechecked[9] = "checked";  break;
		case 11: catechecked[10] = "checked";  break;
		case 12: catechecked[11] = "checked";  break;
		case 13: catechecked[12] = "checked";  break;
		case 14: catechecked[13] = "checked";  break;
		case 15: catechecked[14] = "checked";  break;
		case 16: catechecked[15] = "checked";  break;
		case 17: catechecked[16] = "checked";  break;
		case 18: catechecked[17] = "checked";  break;
		case 19: catechecked[18] = "checked";  break;
		case 20: catechecked[19] = "checked";  break;
		case 21: catechecked[20] = "checked";  break;
		case 22: catechecked[21] = "checked";  break;
		case 23: catechecked[22] = "checked";  break;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<style type="text/css">
.introtext {
	width: 500px;
	height: 60px;
}
</style>
<script type="text/javascript" src="/bookjeok/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<%@ include file="../common/adminbookmenu.jsp" %>
<h1 align="center" style="margin-top: 0px;">상품 등록</h1>
<form action="/bookjeok/bkupdate.ad" method="post" enctype="multipart/form-data">
<input type="hidden" name="bookid" value="<%= book.getBookId() %>">
<table align="center"  border="1" cellspacing="0" cellpadding="5">
<tr><th>도서명</th><td><input type="text" name="booknm" value="<%= book.getBookNm() %>"></td></tr>
<tr><th rowspan="5">장르</th><td>
<input type="radio" name="bookcatecd" value="1" <%= catechecked[0] %>>소설  
<input type="radio" name="bookcatecd" value="2" <%= catechecked[1] %>>경제/경영 
<input type="radio" name="bookcatecd" value="3" <%= catechecked[2] %>>자기계발 
<input type="radio" name="bookcatecd" value="4" <%= catechecked[3] %>>시/에세이 
<input type="radio" name="bookcatecd" value="5" <%= catechecked[4] %>>인문 </td></tr>
<tr><td>
<input type="radio" name="bookcatecd" value="6" <%= catechecked[5] %>>국어/외국어 
<input type="radio" name="bookcatecd" value="7" <%= catechecked[6] %>>역사/풍속/신화 
<input type="radio" name="bookcatecd" value="8" <%= catechecked[7] %>>사회/정치/법 
<input type="radio" name="bookcatecd" value="9" <%= catechecked[8] %>>장르소설 
<input type="radio" name="bookcatecd" value="10" <%= catechecked[9] %>>코믹스 </td></tr>
<tr><td>
<input type="radio" name="bookcatecd" value="11" <%= catechecked[10] %>>아동 
<input type="radio" name="bookcatecd" value="12" <%= catechecked[11] %>>유아 
<input type="radio" name="bookcatecd" value="13" <%= catechecked[12] %>>예술/대중문화 
<input type="radio" name="bookcatecd" value="14" <%= catechecked[13] %>>교재/수험서 
<input type="radio" name="bookcatecd" value="15" <%= catechecked[14] %>>청소년/교양 </td></tr>
<tr><td>
<input type="radio" name="bookcatecd" value="16" <%= catechecked[15] %>>자연과학/공학 
<input type="radio" name="bookcatecd" value="17" <%= catechecked[16] %>>종교/역학 
<input type="radio" name="bookcatecd" value="18" <%= catechecked[17] %>>건강/의학 
<input type="radio" name="bookcatecd" value="19" <%= catechecked[18] %>>북모닝 
<input type="radio" name="bookcatecd" value="20" <%= catechecked[19] %>>여행/취미 </td></tr>
<tr><td>
<input type="radio" name="bookcatecd" value="21" <%= catechecked[20] %>>매거진 
<input type="radio" name="bookcatecd" value="22" <%= catechecked[21] %>>가정/생활/요리 
<input type="radio" name="bookcatecd" value="23" <%= catechecked[22] %>>컴퓨터 인터넷  </td></tr>

<tr><th>분류번호</th><td>
<input type="radio" name="booktypenum" value="1" <%= typechecked[0] %>>페이퍼북 
<input type="radio" name="booktypenum" value="2" <%= typechecked[1] %>>E-Book 
<input type="radio" name="booktypenum" value="3" <%= typechecked[2] %>>오디오북 </td></tr>

<tr><th>국내외번호</th><td>
<% if(book.getBookLocNum() == 1){ %>
<input type="radio" name="booklocnum" value="1" checked>국내 
<input type="radio" name="booklocnum" value="2">국외 
<% } else { %>
<input type="radio" name="booklocnum" value="1">국내 
<input type="radio" name="booklocnum" value="2" checked>국외 
<% } %>
</td></tr>

<input type="hidden" name="bfile" value="<%= book.getBookImg() %>">

<tr><th>도서 이미지</th>
	<td><% if(book.getBookImg() != null) { %>
        <%= book.getBookImg() %> &nbsp; 
        <br> 변경 : <input type="file" name="bookimg">
		<% } else { %>
		첨부된 파일 없음 <br> 추가 : <input type="file" name="bookimg">         
		<% } %></td>
	</tr>
<tr><th>저자</th><td><input type="text" name="author" value="<%= book.getAuthor() %>"></td></tr>
<tr><th>저자소개</th><td><input type="text" class="introtext" name="authorintro" value="<%= book.getAuthorIntro() %>"></textarea></td></tr>
<tr><th>ISBN</th><td><input type="number" name="isbn" value="<%= book.getIsbn() %>"></td></tr>
<tr><th>순위</th><td><input type="number" name="ranking" value="<%= book.getRanking() %>"></td></tr>
<tr><th>도서소개</th><td><input type="text" class="introtext" name="bookintro" value="<%= book.getBookIntro() %>"></textarea></td></tr>
<tr><th>가격</th><td><input type="number" name="bookprice" value="<%= book.getBookPrice() %>"></td></tr>
<tr><th>평점</th><td><input type="number" min='1' max='10' name="avgscore" value="<%= book.getAvgScore() %>"></td></tr>
<tr><th>출판사</th><td><input type="text" name="publisher" value="<%= book.getPublisher() %>"></td></tr>
<tr><th>발행일</th><td><input type="date" name="publishdate" value="<%= book.getPublishDate() %>"></td></tr>
<tr><th>목차</th><td><input type="text" class="introtext"name="bookindex" value="<%= book.getBookIndex() %>"></textarea></td></tr>
<tr><th colspan="2">
	<input type="submit" value="수정하기"> &nbsp; 
	<input type="reset" value="작성취소"> &nbsp;
	<input type="button" value="메인화면" onclick="javascript:location.href='/bookjeok/index.jsp'; return false;">
</th></tr>
</table>
</form>
<%@ include file="../common/footer.jsp" %>
</body>
</html>