<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ask.model.vo.Ask" %>
<%
   Ask ask = (Ask)request.getAttribute("ask");
   int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
a{ text-decoration:none; 
}
th{	
	text-align: center;
	background-color: #8181F7;
	color: white;
}
.detail{
	border: 1px solid #8181F7;
	margin-left : 650px;
	position:relative;
	-webkit-border-radius: 5px;
	border-collapse: separate;
}
td{
   font-weight: bold;
   border: 0px solid #58ACFA;
   -webkit-border-radius: 5px;
   text-align: center;
}
h1{
	position: relative;
	align : center;
}
textarea{
   background-color : #58ACFA;
   color : white;
   border: 1px solid white;
}
button{
	border: 1px solid #8181F7;
	background-color : #8181F7;
	border: 1px solid White; color : white;
}
</style>
<title>북적북적</title>
<script type="text/javascript">
function moveUpdateView(){
   location.href = "/bookjeok/aupdateview?askNum=<%= ask.getAskNum() %>&page=<%= currentPage %>";
}
function requestDelete(){
   location.href = "/bookjeok/adelete?askNum=<%= ask.getAskNum() %>";
}
</script>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<hr>
<h1 align="center"><%= ask.getAskNum() %>번 문의글 상세보기</h1>
<table align="center" width="800" border="1" class = "detailtable">
<tr><th>작성자</th><td><%= ask.getAskWriterId() %></td><th>등록날짜</th><td><%= ask.getWriteDate() %></td></tr>
<tr><th>첨부파일</th>
	<td colspan = "3">
   <% if(ask.getAskOriginalFile() != null){ %>
      <a href="/bookjeok/afiledownload?afile=<%= ask.getAskOriginalFile() %>&rfile=<%= ask.getAskRenameFile() %>"><%= ask.getAskOriginalFile() %></a>
   <% }else{ %>
      &nbsp;
   <% } %>
</td></tr>
<tr><th>제 목</th><td colspan = "3"><%= ask.getAskTitle() %></td></tr>
<tr><th>내 용</th></tr>
<tr><td colspan = "4"  style="text-align:left;"><%= ask.getAskContent() %></td></tr>
<% if(ask.getAskState().equals("Y")) { %>
<tr><th>답변자 아이디</th><td colspan = "3" readonly><%= loginUser.getUserId() %><th>답변 날짜</th><td><%= ask.getAnswerDate() %></td></tr>
<tr><th>답변 내용</th><td colspan = "3" width="100" height="100"><%= ask.getAnswerContent() %>"></td></tr>
<% } %>
<tr><th colspan="4">
   <%-- 댓글달기 버튼은 로그인한 경우에만 보이게 함 --%>
   <% if(loginUser != null){ 
         if(loginUser.getUserId().equals(ask.getAskWriterId())){%>
      <button onclick="moveUpdateView(); return false;">수정페이지로 이동</button> &nbsp;
      <button onclick="requestDelete(); return false;">글삭제</button>  &nbsp;
      <% }else if(loginUser.getAdmin().equals("Y")){ %>
         <button onclick="requestDelete(); return false;">글삭제</button> &nbsp;
         <button onclick="requestReply(); return false;">댓글달기</button> &nbsp;
   <% }} %> &nbsp;
   <button onclick="javascript:location.href='/bookjeok/alist?page=<%= currentPage %>';">목록</button>
</th></tr>
</table>
<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>