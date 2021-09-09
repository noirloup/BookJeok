<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="usedshop.model.vo.UsedShopAuctionSelect" %>
<%
	UsedShopAuctionSelect usauselect = (UsedShopAuctionSelect)request.getAttribute("usauselect");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<style type="text/css">
.contentbox {
	position: relative;
	left: 80px;
	top: -970px;
	text-align: center;
	margin-bottom: 10px;
	border: 3px solid #5F04B4;
	-webkit-border-radius: 10px;
}
.usimg {
	width: 210px;
	margin-bottom: 25px;
}
.usinfo {
	-webkit-border-radius: 10px;
	position: relative;
	margin-top: 15px;
}
.eachtitle {
	border: 3px solid #8258FA;
	-webkit-border-radius: 10px;
	width: 120px;
	height: 30px;
	margin-top: 0;
	margin-bottom: 0;
	text-align: center;
	color: white;
	background-color: #8181F7;
}
.eachcontent {
	margin-left: 5px;
	margin-top: 0;
	margin-bottom: 0;
	color: #8258FA;
	text-align: left;
}
.usedintro {
	margin-top: 0;
	margin-bottom: 0;
	color: #8258FA;
	text-align: left;
	border: 3px solid #8258FA;
	-webkit-border-radius: 10px;
	padding-left: 5px;
	width: 675px;
	height: 120px;
	font-size: 14pt;
	font-weight: bold;
}
.ususerbid {
	width: 120px;
	height: 40px;
	text-align: center;
	font-size: 13pt;
	color: white;
	border: 2px solid #8181F7;
	background-color: #58ACFA;
	-webkit-border-radius: 10px;
	margin-top: 15px;
}
.ussystembid {
	width: 120px;
	height: 40px;
	text-align: center;
	font-size: 13pt;
	color: white;
	border: 2px solid #8181F7;
	background-color: #58ACFA;
	-webkit-border-radius: 10px;
	margin-top: 15px;
}
.updateend {
	width: 120px;
	height: 40px;
	text-align: center;
	font-size: 13pt;
	color: white;
	border: 2px solid #8181F7;
	background-color: #58ACFA;
	-webkit-border-radius: 10px;
	margin-top: 15px;
}
</style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<%@ include file="../common/usedshopAuctionTopMenu.jsp" %>

<form action="/bookjeok/usauupdate" method="post">
<input type="hidden" name="marketid" value="<%= usauselect.getaMarketCd() %>">
<table align="center" width="700px" height="180px" class="contentbox">
	<tr>
		<td class="usimg"><img width="100%" class="usimg" style="border: 1px solid #81BEF7; -webkit-border-radius: 5px;" 
											src="/bookjeok/resources/book_img/<%= usauselect.getBookimg() %>"></td>
		<td>
			<table width="470px" height="180px" class="usinfo">
				<tr><td width="120px"><h3 class="eachtitle">도서명</h3></td>
					<td colspan="3"><h3 class="eachcontent"><%= usauselect.getBookNm() %></h3></td></tr>
				<tr><td width="120px"><h3 class="eachtitle">카테고리</h3></td>
					<td colspan="3"><h3 class="eachcontent"><%= usauselect.getBookCategory() %></h3></td></tr>
				<tr><td width="120px"><h3 class="eachtitle">도서정보</h3></td>
					<td colspan="3"><h4 class="eachcontent"><%= usauselect.getAuthor() %> | <%= usauselect.getPublisher() %> | <%= usauselect.getPublishDate() %></h4></td></tr>
				<tr><td width="120px"><h3 class="eachtitle">판매자</h3></td>
					<td><h3 class="eachcontent"><%= usauselect.getUserWriterId() %></h3></td>
					<td width="120px"><h3 class="eachtitle">등 급</h3></td>
					<td><h3 class="eachcontent"><%= usauselect.getUserRank() %></h3></td></tr>
				<tr><td width="120px"><h3 class="eachtitle">정 가</h3></td>
					<td><h3 class="eachcontent"><%= usauselect.getBookPrice() %></h3></td>
					<td width="120px"><h3 class="eachtitle">품 질</h3></td>
					<td><h3 class="eachcontent"><%= usauselect.getaQuality() %></h3></td></tr>
				<tr><td width="120px"><h4 class="eachtitle" style="padding-top: 3px;">시작 입찰가</h4></td>
					<td><h3 class="eachcontent"><%= usauselect.getStartBid() %></h3></td>
					<td width="120px"><h4 class="eachtitle" style="padding-top: 3px;">현재 입찰가</h4></td>
					<td><h3 class="eachcontent"><%= usauselect.getCurrentBid() %></h3></td></tr>
				<tr><td width="120px"><h3 class="eachtitle">마감날짜</h3></td>
					<td colspan="3"><h3 class="eachcontent"><%= usauselect.getaCloseDate() %></h3></td></tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="2"><h3 class="eachtitle">상품 소개</h3></td>
	</tr>
	<tr>
		<td colspan="2"><input type="text" name="usedintro" class="usedintro" value="<%= usauselect.getaUsedBookIntro() %>"></td>
	</tr>
	<tr><td><input type="submit" class="updateend" value="수정 완료">
		<td><input type="button" class="updateend" value="취소" onclick="javascript:history.go(-1);"></td></tr>
</table>
</form>

<%@ include file="../common/footer.jsp" %>
</body>
</html>