<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="usedshop.model.vo.UsedShopNormalSelect, java.util.ArrayList" %>
<%
	ArrayList<UsedShopNormalSelect> list = (ArrayList<UsedShopNormalSelect>)request.getAttribute("list");
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
* { font-family: 'Noto Serif KR', serif; }
body { height: 100%; }
h1, h2 {
	position: relative;
	top: -50px;
	color: #08088A;
}
button#allshow {
	position: relative;
	top: -70px;
	background-color: #58ACFA;
	color: white;
	border: 2px solid #58ACFA;
	-webkit-border-radius: 5px;
}
fieldset#ss {
	text-align: center;
	color: #0404B4;
	width: 400px;
	height: 50px;
	position: relative;
	top: -60px;
	border: 2px solid #8181F7;
	-webkit-border-radius: 5px;
}
form.sform {
	text-align: center;
	color: #0404B4;
	display: none;
	width: 560px;
	position: relative;
	top: -70px;
	-webkit-border-radius: 5px;
	margin-bottom: 10px;
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
	top: -80px;
}
.userlist {
	position: relative;
	top: -80px;
	width: 900px;
	border: 2px solid #8181F7;
	text-align: center;
	-webkit-border-radius: 5px;
}
.userlist a {
	text-decoration: none;
	color: #0404B4;
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
	top: -60px;
}
#footer {
	position: relative;
	top: -50px;
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
<%@ include file="../common/usedshopAdminMenu.jsp" %>

<h1 align="center">일반 장터 관리</h1>
<h2 align="center">현재 장터 글 수 : <%= list.size() %> 개</h2>
<br>
<center>
	<button onclick="javascript:location.href='/bookjeok/usnmlist.ad?page=1';" id="allshow">전체 목록 보기</button>
<br>
<%-- 항목별 검색 기능 추가 --%>
<fieldset id="ss">
<legend>검색할 항목을 선택하세요.</legend>
<input type="radio" name="item" id="uid"> 책 제목 &nbsp; 
<input type="radio" name="item" id="unick"> 작성자 아이디 &nbsp;
</fieldset>
<br>

<%-- 책 제목 검색 폼 --%>
<form id="idform" class="sform" action="/bookjeok/usnmsearch.ad" method="post">
<input type="hidden" name="action" value="bookname">
<fieldset>
책 제목 : <input type="search" name="keyword"> &nbsp; 
<input type="submit" value="검색">
</fieldset>
</form>

<%-- 작성자 아이디 검색 폼 --%>
<form id="nickform" class="sform" action="/bookjeok/usnmsearch.ad" method="post">
<input type="hidden" name="action" value="writerid">
<fieldset>
작성자 아이디 : <input type="search" name="keyword"> &nbsp; 
<input type="submit" value="검색">
</fieldset>
</form>
</center>

<br>
<hr color="#0404B4" size="4px" id="hr1"><br>
<table align="center" class="userlist" border="2" cellspacing="0" cellpadding="4">
<tr><th>장터 번호</th><th>책 제목</th><th>작성자</th><th>작성자 등급</th><th>품질</th>
<th>정 가</th><th>판매 가격</th><th>남은 수량</th><th>등록 날짜</th><th></th>
<% for(UsedShopNormalSelect usnmselect : list){ %>
<tr>
	<td><a href='/bookjeok/usnmdetail?marketcd=<%= usnmselect.getnMarketCd() %>'><%= usnmselect.getnMarketCd() %></a></td>
	<td style="font-size: 10pt;"><a href='/bookjeok/usnmdetail?marketcd=<%= usnmselect.getnMarketCd() %>'><%= usnmselect.getBookNm() %></a></td>
	<td><a href='/bookjeok/usnmdetail?marketcd=<%= usnmselect.getnMarketCd() %>'><%= usnmselect.getUserId() %></a></td>
	<td><a href='/bookjeok/usnmdetail?marketcd=<%= usnmselect.getnMarketCd() %>'><%= usnmselect.getUserRank() %></a></td>
	<td><a href='/bookjeok/usnmdetail?marketcd=<%= usnmselect.getnMarketCd() %>'><%= usnmselect.getnQuality() %></a></td>
	<td><a href='/bookjeok/usnmdetail?marketcd=<%= usnmselect.getnMarketCd() %>'><%= usnmselect.getBookPrice() %></a></td>
	<td><a href='/bookjeok/usnmdetail?marketcd=<%= usnmselect.getnMarketCd() %>'><%= usnmselect.getPrice() %></a></td>
	<td><a href='/bookjeok/usnmdetail?marketcd=<%= usnmselect.getnMarketCd() %>'><%= usnmselect.getRegCount() - usnmselect.getSaleCount() %></a></td>
	<td><a href='/bookjeok/usnmdetail?marketcd=<%= usnmselect.getnMarketCd() %>'><%= usnmselect.getnRegDate() %></a></td>
	<td align="center"><input id="delbutton" type="button" value="삭제" 
			onclick="window.open('/bookjeok/views/usedshop/usedNormalDelete.jsp?marketid=<%= usnmselect.getnMarketCd() %>', 
				'deleteWindow', 'width=550, height=450, scrollbars=no, resizable=no, status=no, menubar=no, toolbar=no');"></td>
</tr>
<% } %>
</table>
<hr color="#0404B4" size="4px" id="hr2">

<%@ include file="../common/footer.jsp" %>
</body>
</html>