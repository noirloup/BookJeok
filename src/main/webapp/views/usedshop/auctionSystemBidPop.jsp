<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="usedshop.model.vo.UsedShopAuctionSelect, user.model.vo.User"%>
<%
	User auctionloginUser = (User) session.getAttribute("loginUser");
	UsedShopAuctionSelect usauselect = (UsedShopAuctionSelect)request.getAttribute("usauselect");
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
.bidtitle {
	margin-bottom: 5px;
	color: #642EFE;
	position: relative;
	left: -90px;
}
.usedinfo {
	position: relative;
	left: -70px;
	font-size: 12pt;
	color: #8181F7;
}
.eachtitle {
	margin-top: 0px;
	margin-bottom: 0px;
}
.usedprice {
	position: relative;
	font-size: 12pt;
	color: #8181F7;
	margin-top: 15px;
}
.pricetitle {
	margin-top: 3px;
	margin-bottom: 3px;
	border: 2px solid #9A2EFE;
	background-color: #9F81F7;
	color: white;
	-webkit-border-radius: 10px;
	text-align: center;
	width: 120px;
}
.pricebox {
	border: 2px solid #9A2EFE;
	-webkit-border-radius: 10px;
	width: 100px;
	margin-top: 3px;
	margin-bottom: 3px;
	padding-left: 10px;
}
.bidinput {
	border: 2px solid #9A2EFE;
	-webkit-border-radius: 10px;
	font-size: 12pt;
	color: #9F81F7;
	width: 355px;
}
.bidnotice {
	margin-top: 3px;
	margin-bottom: 3px;
	color: #FE2E64;
}
.newbidbutton {
	margin-top: 15px;
	margin-right: 30px;
	margin-bottom: 20px;
	border: 3px solid #8258FA;
	-webkit-border-radius: 15px;
	width: 100px;
	height: 40px;
	font-size: 12pt;
	background-color: #9A2EFE;
	color: white;
}
</style>
<script type="text/javascript">
function movePage() {
	this.close(); 
	self.opener = self; 
	opener.close();
}
</script>
</head>
<body>
<h1 class="bidtitle" align="center">자동 입찰</h1>
<form action="/bookjeok/usaubid" method="post" onsubmit="return movePage();" target="opener">
<input type="hidden" name="marketcd" value="<%= usauselect.getaMarketCd() %>">
<input type="hidden" name="biduserid" value="<%= auctionloginUser.getUserId() %>">
<table class="usedinfo" cellpadding="4" align="center">
	<tr>
		<td><h3 class="eachtitle">도서제목</h3></td><td class="eachcontent"><%= usauselect.getBookNm() %></td>
	</tr>
	<tr>
		<td><h3 class="eachtitle">판매자</h3></td><td class="eachcontent"><%= usauselect.getUserWriterId() %></td>
	</tr>
	<tr>
		<td><h3 class="eachtitle">판매자 등급</h3></td><td class="eachcontent"><%= usauselect.getUserRank() %></td>
	</tr>
	<tr>
		<td><h3 class="eachtitle">품질</h3></td><td class="eachcontent"><%= usauselect.getaQuality() %></td>
	</tr>
	<tr>
		<td><h3 class="eachtitle">마감 날짜</h3></td><td class="eachcontent"><%= usauselect.getaCloseDate() %></td>
	</tr>
</table>

<table class="usedprice" align="center" width="480">
	<tr>
		<td><h3 class="pricetitle">정 가</h3></td>
		<td><h3 class="pricebox"><%= usauselect.getBookPrice() %></h3></td>
		<td><h3 class="pricetitle">현재 입찰가</h3></td>
		<td><h3 class="pricebox"><%= usauselect.getCurrentBid() %></h3></td>
	</tr>
	<tr>
		<td><h3 class="pricetitle">자동 입찰가</h3></td>
		<td colspan="3"><input type="number" name="newbid" class="bidinput" 
							value="<%= usauselect.getCurrentBid() + (int)(usauselect.getCurrentBid() * 0.1) %>" readonly></td>
	</tr>
</table>
<center>
<h4 class="bidnotice">입찰 등록하면, 되돌릴 수 없습니다.</h4>
<h4 class="bidnotice">신중히 결정해주세요.</h4>
<input type="submit" class="newbidbutton" value="입찰 등록">
<input type="button" class="newbidbutton" value="취소" onclick="window.close()">
</center>
</form>
</body>
</html>