<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="review.model.vo.Review"%>
<%
	Review review = (Review)request.getAttribute("review");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<style type="text/css">
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
	width: 150px;
	border: 1px solid #81BEF7;
	-webkit-border-radius: 5px;
}

.uslistcon {
	width: 340px;
	border: 1px solid #81BEF7;
	-webkit-border-radius: 5px;
}
</style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>


<table class = "listbox" align="center" width="500" border="1" cellspacing="0" 
 cellpadding="5" style="margin-top:50px;">
<tr><th class="uslist">리뷰 제목</th><td class="uslistcon"><%= review.getReviewName() %></td></tr>
<tr><th class="uslist">작성자</th><td class="uslistcon"><%= review.getReviewWriterId() %></td></tr>
<tr><th class="uslist">등록날짜</th><td class="uslistcon"><%= review.getReviewRegDate() %></td></tr>
<tr><th class="uslist">평점</th><td class="uslistcon"><%= review.getScore() %></td></tr>
<tr><th class="uslist">키워드</th><td class="uslistcon"><%= review.getKeyword() %></td></tr>
<tr><th class="uslist">첨부파일</th>
   <td class="uslistcon">
   		<% if(review.getReviewOriginalFile() != null){ %>
   			<a href="/bookjeok/rfdown?ofile=<%= review.getReviewOriginalFile() %>&rfile=<%= review.getReviewRenameFile() %>"><%= review.getReviewOriginalFile() %></a>
   		<% }else{ %>
   			&nbsp;
   		<% } %>
   </td>
</tr>
<tr><th class="uslist">내 용</th><td class="uslistcon"><%= review.getReviewContent() %></td></tr>
<tr><th colspan="3">
	<button onclick="location.href = '/bookjeok/rdelete.ad?reviewcd=<%= review.getReviewCd() %>&rfile=<%= review.getReviewRenameFile() %>'; return false;">삭제하기</button> &nbsp; 
	<button onclick="javascript:history.go(-1); return false;">목록으로 이동</button>
	</th></tr>
</table>
</body>
</html>