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
table th { background-color: #8181F7; }
table#outer { border: 2px solid navy; }

.updateform .button {
	background-color: #D358F7;
	border: 1px solid #8904B1;
	-webkit-border-radius: 10px;
	color: white;
	font-size: 10pt;
	width: 80px;
	padding-bottom: 5px;
}

.updateform .pagebutton {
	background-color: #D358F7;
	border: 1px solid #8904B1;
	-webkit-border-radius: 10px;
	color: white;
	font-size: 10pt;
	width: 120px;
	padding-bottom: 5px;
}

.updateform .inbutton {
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

<form class = "updateform" action="/bookjeok/rupdate" method="post" style="margin-top:50px;" enctype="multipart/form-data">

<input type="hidden" name="rcd" value="<%= review.getReviewCd() %>">

<input type="hidden" name="ofile" value="<%= review.getReviewOriginalFile() %>">
<input type="hidden" name="rfile" value="<%= review.getReviewRenameFile() %>">

<table id="outer" align="center" width="900" cellspacing="5" cellpadding="0">
	<tr><th width="150">리뷰제목</th>
		<td><input type="text" name="reviewname" value="<%= review.getReviewName() %>"></td></tr>
	<tr><th width="150">아이디</th>
		<td><input type="text" name="reviewwriterid" readonly value="<%= review.getReviewWriterId() %>"></td>	
	<tr><th width="150">평점</th>
		<td><input type="number" name="score" min="1" max="10"  value="<%= review.getScore() %>"> &nbsp;
			<input class = "inbutton" type="button" value="키워드체크" onclick="movePage()"></td>
		<th width="150">첨부파일</th>
			<td>
			<% if(review.getReviewOriginalFile() != null){ %>
			<%= review.getReviewOriginalFile() %> &nbsp; 
			<input type="checkbox" name="deleteFlag" value="yes"> 
				파일삭제 <br>
				변경 : <input type="file" name="upfile">
			<% }else{ %>
				첨부된 파일 없음 <br>
				추가 : <input type="file" name="upfile">			
			<% } %>
			</td>
		</tr>
	<tr><th width="150">체크한 키워드</th>
		<td><input type="text" name="keyword" id="pcheck" style="width:375px"  value="<%= review.getKeyword() %>"></td></tr>		
	<tr><th width="150">리뷰 내용</th>
		<td><textarea name="content" rows="3" cols="50"><%= review.getReviewContent() %></textarea></td></tr>
<tr><th colspan="4">
	<input class = "button" type="submit" value="수정하기"> &nbsp; 
	<input class = "button" type="reset" value="수정취소"> &nbsp;
	<input class = "pagebutton" type="button" value="이전페이지로 이동" 
		onclick="javascript:history.go(-1); return false;"> &nbsp;
	<input class = "button" type="button" value="목록" 
		onclick="javascript:location.href='/bookjeok/rmylist'; return false;">
</th></tr>
</table>
</form>
</body>
</html>