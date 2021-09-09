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
<style type="text/css">
.contentbox {
	position: relative;
	left: 80px;
	top: -1020px;
	text-align: center;
	margin-bottom: 10px;
	border: 3px solid #5F04B4;
	-webkit-border-radius: 10px;
}
.contentbox a {
	text-decoration: none;
	color: #8904B1;
}
.usimg {
	width: 140px;
	border: 1px solid #81BEF7;
	-webkit-border-radius: 5px;
}
.uslist {
	width: 340px;
}
.contentlist {
	width: 350px;
}
.ustitle {
	font-size: 14pt;
	font-weight: bold;
	color: #8904B1;
	text-align: left;
}
.usbookinfo {
	font-size: 10pt;
	font-weight: bold;
	color: #A901DB;
	text-align: left;
}
.contentseller {
	width: 110px;
	color: #A901DB;
}
.usseltitle {
	color: white;
	border: 2px solid #8904B1;
	background-color: #D358F7;
	-webkit-border-radius: 20px;
}
.ussellerinfo {
	font-size: 10pt;
}
.usselquantity {
	color: white;
	border: 2px solid #8904B1;
	background-color: #D358F7;
	-webkit-border-radius: 20px;
}
.contentquantity {
	width: 110px;
	color: #A901DB;
}
.usselquaninfo {
	font-size: 10pt;
}
.usseldate {
	color: white;
	border: 2px solid #8904B1;
	background-color: #D358F7;
	-webkit-border-radius: 20px;
}
.usseldateinfo {
	width: 110px;
	color: #A901DB;
}
.usseldateinfo {
	font-size: 10pt;
}
.contentprice {
	text-align: center;
	width: 90px;
}
.uspricetitle {
	width: 85px;
	text-align: center;
	font-size: 10pt;
	color: white;
	border: 2px solid #8904B1;
	background-color: #D358F7;
	-webkit-border-radius: 20px;
}
.usprice {
	font-size: 12pt;
	color: #A901DB;
}
.usbidtitle {
	width: 85px;
	text-align: center;
	font-size: 10pt;
	color: white;
	border: 2px solid #8904B1;
	background-color: #D358F7;
	-webkit-border-radius: 20px;
}
.contentbid {
	text-align: center;
}
.usbid {
	font-size: 12pt;
	color: #A901DB;
}
.purchase {
	width: 85px;
	text-align: center;
	font-size: 13pt;
	color: white;
	border: 2px solid #8181F7;
	background-color: #58ACFA;
	-webkit-border-radius: 10px;
}
#footer {
	position: relative;
	top: -1000px;
}
.searchform {
	align: center;
	position: relative;
	top: -1025px;
	left: 680px;
}
.searchset {
	position: relative;
	width: 400px;
	height: 50px;
	border: 3px solid #5F04B4;
	-webkit-border-radius: 5px;
}
.searchtype {
	color: #8904B1;
	border: 2px solid #8904B1;
	-webkit-border-radius: 10px;
	font-size: 14pt;
	margin-top: 5px;
	height: 35px;
}
.keyword {
	color: #8904B1;
	border: 2px solid #8904B1;
	-webkit-border-radius: 10px;
	height: 35px;
	padding-top: 5px;
}
.searchform .submit {
	background-color: #D358F7;
	border: 2px solid #8904B1;
	-webkit-border-radius: 10px;
	color: white;
	font-size: 16pt;
	width: 80px;
	padding-bottom: 5px;
}
</style>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<%@ include file="../common/usedshopNormalTopMenu.jsp" %>

<form id="idform" class="searchform" action="/bookjeok/usnmsearch" method="post">
<div class="searchset" align="center">
<select class="searchtype" name="searchtype">
<option value="bookname">책 제목</option>
<option value="writerid">작성자</option>
</select>
<input type="search" class="keyword" name="keyword"> &nbsp; 
<input type="submit" class="submit" value="검색">
</div>
</form>

<table align="center" cellspacing="0" cellpadding="0" class="contentbox" style="border: none;">
	<% for(UsedShopNormalSelect usaushop : list) { %>
	<table align="center" width="700px" height="180px" class="contentbox">
	<tr>
		<td rowspan="5" class="usimg"><a href='/bookjeok/usnmdetail?marketcd=<%= usaushop.getnMarketCd() %>'><img width="100%" src="/bookjeok/resources/book_img/<%= usaushop.getBookimg() %>"></a></td>	<!-- 도서 이미지 -->
		<td class="uslist">
			<table class="contentlist" cellpadding="5">
				<tr colspan="3" class="ustitle"><td><a href='/bookjeok/usnmdetail?marketcd=<%= usaushop.getnMarketCd() %>'><%= usaushop.getBookNm() %></a></td></tr>	<!-- 도서 제목 -->
				<tr colspan="3" class="usbookinfo"><td><a href='/bookjeok/usnmdetail?marketcd=<%= usaushop.getnMarketCd() %>'><%= usaushop.getAuthor() %> | <%= usaushop.getPublisher() %> | <%= usaushop.getPublishDate() %></a></td></tr>	<!-- 저자 | 출판사 | 출판 날짜 -->
				<tr>
					<td><table style="float:left;" class="contentseller">
						<tr><td class="usseltitle"><a href='/bookjeok/usnmdetail?marketcd=<%= usaushop.getnMarketCd() %>' style="color: white;">판매자</a></td></tr>
						<tr><td class="ussellerinfo"><a href='/bookjeok/usnmdetail?marketcd=<%= usaushop.getnMarketCd() %>'><%= usaushop.getUserId() %></a></td></tr>		<!-- 판매자 아이디 -->
						<tr><td class="ussellerinfo"><a href='/bookjeok/usnmdetail?marketcd=<%= usaushop.getnMarketCd() %>'><%= usaushop.getUserRank() %></a></td></tr>		<!-- 등급 -->
					</table>
					<table style="float:left" class="contentquantity">
						<tr><td class="usselquantity"><a href='/bookjeok/usnmdetail?marketcd=<%= usaushop.getnMarketCd() %>' style="color: white;">수량</a></td></tr>		<!-- 수량 -->
						<tr><td class="usselquaninfo"><a href='/bookjeok/usnmdetail?marketcd=<%= usaushop.getnMarketCd() %>'><%= usaushop.getRegCount() - usaushop.getSaleCount() %></a></td></tr>		<!-- 등록시 입력 수량 - 판매한 수량 -->
					</table>
					<table class="contentregdate">
						<tr><td class="usseldate"><a href='/bookjeok/usnmdetail?marketcd=<%= usaushop.getnMarketCd() %>' style="color: white;">등록 날짜</a></td></tr>
						<tr><td class="usseldateinfo"><a href='/bookjeok/usnmdetail?marketcd=<%= usaushop.getnMarketCd() %>'><%= usaushop.getnRegDate() %></a></td></tr>	<!-- 날짜 -->
					</table></td>
				</tr>
			</table>
		</td>
		<td>
			<table class="contentprice">
				<tr><td><a href='/bookjeok/usnmdetail?marketcd=<%= usaushop.getnMarketCd() %>'><input type="text" class="uspricetitle" value="정가" readonly></a></td></tr>
				<tr><td class="usprice"><a href='/bookjeok/usnmdetail?marketcd=<%= usaushop.getnMarketCd() %>'><%= (int)usaushop.getBookPrice() %></a></td></tr>	<!-- 도서 가격 -->
				<tr><td><a href='/bookjeok/usnmdetail?marketcd=<%= usaushop.getnMarketCd() %>'><input type="text" class="usbidtitle" value="판매 가격" readonly></a></td></tr>
				<tr><td class="usbid"><a href='/bookjeok/usnmdetail?marketcd=<%= usaushop.getnMarketCd() %>'><%= (int)usaushop.getPrice() %></a></td></tr>		<!-- 판매 가격 -->
			</table>
		</td>
	</tr>
	</table>
	<% } %>
</table>

<%@ include file="../common/footer.jsp" %>
</body>
</html>