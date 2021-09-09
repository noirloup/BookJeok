<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="review.model.vo.ReviewList, java.util.ArrayList, java.sql.Date" %>
<%
	ArrayList<ReviewList> list = (ArrayList<ReviewList>)request.getAttribute("list");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<style type="text/css">
form.sform {
	display: none;   /* 안 보이게 됨 */
}

fieldset#ss {
	text-align: center;
	width: 400px;
	height: 50px;
	position: relative;
	margin-left: 530px;
}

form {
	text-align: center;
	width: 400px;
	height: 50px;
	margin-left: 550px;
}

.listbox {
	align: center;
	position: relative;
	text-align: center;
	width: 600px;
	margin-bottom: 10px;
	border: 3px solid #5F04B4;
	-webkit-border-radius: 10px;
}

.uslist {
	width: 300px;
	border: 1px solid #81BEF7;
	-webkit-border-radius: 5px;
}

.uslisttitle {
	width: 800px;
	border: 1px solid #81BEF7;
	-webkit-border-radius: 5px;
}

.uslistuser {
	width: 200px;
	border: 1px solid #81BEF7;
	-webkit-border-radius: 5px;
}

.listboxS {
	align: center;
	position: relative;
	right: 20px;
	text-align: center;
	width: 400px;
	margin-bottom: 10px;
	border: 3px solid #5F04B4;
	-webkit-border-radius: 10px;
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


<h3 align="center" style="font-size:2em; margin-top:50px;" >나의 리뷰</h3>

<fieldset class = "listbox" id="ss">
<legend>검색할 항목을 선택하세요.</legend>
<input type="radio" name="item" id="ugen"> 리뷰 제목 &nbsp; 
<input type="radio" name="item" id="uenroll"> 등록 날짜 &nbsp; 
</fieldset>
<br>


<form id="nameform" class="sform" action="/bookjeok/mrsearch" method="post">
<input type="hidden" name="action" value="name">
<fieldset class = "listboxS">
<legend class="legend">검색할 리뷰제목을 입력하세요.</legend>
<input type="search" name="keyword"> &nbsp; 
<input type="submit" value="검색">
</fieldset>
</form>

<%-- 가입날짜 검색 폼 --%>
<form id="enrollform" class="sform" action="/bookjeok/mrsearch" method="post">
<input type="hidden" name="action" value="enrolldate">
<fieldset class = "listboxS">
<legend>검색할 등록날짜를 선택하세요.</legend>
<input type="date" name="begin"> ~
<input type="date" name="end">  &nbsp; 
<input type="submit" value="검색">
</fieldset>
</form>

<table class = "listbox" align="center" width="500" border="1" cellspacing="0" 
 cellpadding="0" style="margin-top:30px;">
<tr>
	<th class="uslisttitle">리뷰 제목</th>
	<th class="uslist">등록 날짜</th>
	<th class="uslist">수정 날짜</th>
	<th class="uslistuser">작성자</th>
</tr>

<% for(ReviewList r : list){ %>
<% if(loginUser.getUserId().equals(r.getReviewWriterId())) { %>
<tr>
	<td align="center" class="uslisttitle"><a href="/bookjeok/rmydetail?reviewname=<%= r.getReviewName() %>"><%= r.getReviewName() %></a></td>
	<td align="center" class="uslist"><%= r.getReviewRegDate() %></td>
	<td align="center" class="uslist"><%= r.getReviewModifyDate() %></td>
	<td align="center" class="uslistuser"><%= r.getReviewWriterId() %></td>
</tr>
<% } %>
<% } %>
</table>

</body>
</html>