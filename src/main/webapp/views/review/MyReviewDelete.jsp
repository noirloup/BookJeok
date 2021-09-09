<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="review.model.vo.ReviewList"%>
<%
	ReviewList rselect = (ReviewList)request.getAttribute("rselect");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
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
<b id="title"><font size="14" color="#8181F7">리뷰 글 삭제</font></b>
<br><br>
<form action="/bookjeok/rdelete" method="post" onsubmit="return movePage();" target="opener">
<input type="hidden" name="reviewcd" value="<%= rselect.getReviewCd() %>">
<input type="text" name="writerid" value="<%= rselect.getReviewWriterId() %>"><b class="context"> 님이 작성한</b><br>
<input type="text" name="reviewname" value="<%= rselect.getReviewName() %>" readonly><b class="context"> 글을</b><br>
<b class="navtext">정말로 삭제하시겠습니까?</b><br>
<b class="navtext">삭제한 글은 되돌릴 수 없습니다.</b><br>
<input type="button" value="취소" onclick="window.close()">
<input type="submit" value="삭제"">
</form>
</center>

</body>
</html>