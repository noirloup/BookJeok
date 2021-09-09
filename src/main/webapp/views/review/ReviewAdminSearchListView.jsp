<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="review.model.vo.ReviewList, java.util.ArrayList" %>    
<%
	ArrayList<ReviewList> list = (ArrayList<ReviewList>)request.getAttribute("list");
	String action = request.getParameter("action");
	String keyword = request.getParameter("keyword");
	int listCount = ((Integer) request.getAttribute("listCount")).intValue();
	int startPage = ((Integer) request.getAttribute("startPage")).intValue();
	int endPage = ((Integer) request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer) request.getAttribute("maxPage")).intValue();
	int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<style type="text/css">
form.sform {
	background: lightgray;
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

<h2 align="center" style="font-size:2em; margin-top:50px;" >리뷰 목록</h2>
<br>

<fieldset id="ss">
<legend>검색할 항목을 선택하세요.</legend>
<input type="radio" name="item" id="uid"> 회원 아이디 &nbsp; 
<input type="radio" name="item" id="ugen"> 리뷰 제목 &nbsp; 
<input type="radio" name="item" id="uenroll"> 등록 날짜 &nbsp; 
</fieldset>
<br>

<%-- 검색 항목별 값 입력 전송용 폼 만들기 --%>
<form id="idform" class="sform" action="/bookjeok/rsearch" method="post">
<input type="hidden" name="action" value="id">
<fieldset>
<legend>검색할 아이디를 입력하세요.</legend>
<input type="search" name="keyword"> &nbsp; 
<input type="submit" value="검색">
</fieldset>
</form>


<form id="nameform" class="sform" action="/bookjeok/rsearch" method="post">
<input type="hidden" name="action" value="name">
<fieldset>
<legend>검색할 리뷰제목을 입력하세요.</legend>
<input type="search" name="keyword"> &nbsp; 
<input type="submit" value="검색">
</fieldset>
</form>

<%-- 가입날짜 검색 폼 --%>
<form id="enrollform" class="sform" action="/bookjeok/rsearch" method="post">
<input type="hidden" name="action" value="enrolldate">
<fieldset>
<legend>검색할 등록날짜를 선택하세요.</legend>
<input type="date" name="begin"> ~
<input type="date" name="end">  &nbsp; 
<input type="submit" value="검색">
</fieldset>
</form>

<table align="center" width="500" border="1" cellspacing="0" 
 cellpadding="0" style="margin-top:30px;">
<tr>
	<th>번호</th>
	<th>리뷰 제목</th>
	<th>작성자</th>
	<th>첨부파일</th>
	<th>날짜</th>
</tr>
<% for(ReviewList r : list){ %>
<tr>
	<td align="right"><%= r.getReviewCd() %></td>
	<td><a href="/bookjeok/rdetail.ad?reviewname=<%= r.getReviewName() %>"><%= r.getReviewName() %></a></td>
	<td align="center"><%= r.getReviewWriterId() %></td>
	<td align="center">
		<% if(r.getReviewOriginalFile() != null){ %>
			◎
		<% }else{ %>
			&nbsp;
		<% } %>
	</td>
	<td align="center"><%= r.getReviewRegDate() %></td>
</tr>
<% } %> 
</table>


<%-- 페이징 처리 --%>
	<div style="text-align: center;">
		<%
		if (currentPage <= 1) {
		%>
		[맨처음] &nbsp;
		<%
		} else {
		%>
		<a href="/bookjeok/rsearch?page=1">[맨처음]</a> &nbsp;
		<%
		}
		%>
		<!-- 이전 페이지 그룹으로 이동 -->
		<%
		if ((currentPage - 10) < startPage && (currentPage - 10) > 1) {
		%>
		<a href="/bookjeok/rsearch?page=<%=startPage - 10%>&action=<%= action %>&keyword=<%= keyword %>">[이전그룹]</a>
		&nbsp;
		<%
		} else {
		%>
		[이전그룹] &nbsp;
		<%
		}
		%>

		<!-- 현재 페이지 그룹의 페이지 숫자 출력 -->
		<%
		for (int p = startPage; p <= endPage; p++) {
			if (p == currentPage) {
		%>
		<font color="red" size="4"><b>[<%=p%>]
		</b></font>
		<%
		} else {
		%>
		<a href="/bookjeok/rsearch?page=<%=p%>&action=<%= action %>&keyword=<%= keyword %>"><%=p%></a>
		<%
		}
		}
		%>

		<!-- 다음 페이지 그룹으로 이동 -->
		<%
		if ((currentPage + 10) > endPage && (currentPage + 10) < maxPage) {
		%>
		<a href="/bookjeok/rsearch?page=<%=endPage + 10%>&action=<%= action %>&keyword=<%= keyword %>">[다음그룹]</a> &nbsp;
		<%
		} else {
		%>
		[다음그룹] &nbsp;
		<%
		}
		%>

		<%
		if (currentPage >= maxPage) {
		%>
		[맨끝] &nbsp;
		<%
		} else {
		%>
		<a href="/bookjeok/rsearch?page=<%= maxPage %>&action=<%= action %>&keyword=<%= keyword %>">[맨끝]</a> &nbsp;
		<% } %>
	</div>

</body>
</html>