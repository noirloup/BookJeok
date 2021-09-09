<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="book.model.vo.Book"  import="book.model.vo.OtherSite"  import="review.model.vo.Review"%>
 <%
 	Book book = (Book)request.getAttribute("book");
 	OtherSite othersite = (OtherSite)request.getAttribute("othersite");
	Review review = (Review)request.getAttribute("review");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<style type="text/css">
div{
	margin-left: 550px;
}
div#detail1{
	margin-top: 0px;
}

div#detail2{
	margin-left: 0px;
}
img{
	display: block;
	width:195px; 
	height:291px;
	}

h4{
	margin-bottom: 0px;
	color: #3A01DF;
}
table{
	border-color: blue;
}

</style>
<script type="text/javascript" src="/bookjeok/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		url: "/bookjeok/osite?bookid=<%= book.getBookId()%>",
		type: "get",
		dataType: "json",
		success: function(data){
			console.log("success : " + data);
			
			var str = JSON.stringify(data);
			var json = JSON.parse(str);
			
			values = "";
			for(var i in json.list){
				values +=
					"<tr><td>"
					+ json.list[i].sitenm 
					+"</td><td>"
					+ json.list[i].siteprice 
					"</td></tr>"
			}
			
			$('#othersitelist').html($('#othersitelist').html() + values);
		},
		error: function(jqXHR, textstatus, errorthrown){
			console.log("error : " + jqXHR + ", " + textstatus
					+ ", " + errorthrown);
		}
	});  
	
	
	
});
</script>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>

<hr  style="border:0px">
<br>
<div id="detail1"  >		
	<table border ="01" align="left" style="margin-left:0;">
		<tr><td rowspan="3"><img src="/bookjeok/resources/book_img/<%= book.getBookImg() %>" ></td>
	</table>
	<table border ="1" width="400" bgcolor="LightskyBlue" >
		<tr align=center ><th  colspan="3"><%= book.getBookNm()%></th></tr>
		<tr align=center><td>출판사</td><th colspan="2"><%= book.getPublisher()%></th></tr>
		<tr align=center><td>저자</td><th><%= book.getAuthor()%></th><td>
		<button onclick="javascript: location.href = '/bookjeok/ralldetail?bookname=<%= book.getBookNm()%>';">리뷰게시판</button></td></tr>
	</table>
</div>
	<div id="detail2"  style="white-space:nowrap; overflow:auto;  height:218;  text-align: center;">
	<table  id="othersitelist"  border ="1" width="400"  height="207" bgcolor="LightskyBlue">
		<tr align=center ><th colspan ="3">서점별 가격</th></tr>
	</table>
	</div>
	

<div>
<table id="detailreview" border ="1'" width="610" height="200" >

		<h4 style="margin-bottom: 0px;">리뷰</h4>
		<tr height="50" >
			<% if(review != null) { %>
			<td>리뷰평점: <%= review.getScore() %>/10</td>
			</tr>
		<tr><td><%= review.getReviewContent() %></td>
			<% } %></tr>
</table>
</div>
<hr  style="border:0px">
<div>
<table id="" border ="1'" width="610" height="150" align="left">
		<h4>책소개</h4>
		<tr><td><%= book.getBookIntro() %></td></tr>
</table>
</div>
<hr  style="border:0px">
<div>
<table id="" border ="1'" width="610" height="200" align="left">
		<h4>목차</h4>
		<tr><td><%= book.getBookIndex() %></td></tr>
</table>
</div>
<hr style="border:0px">
<div>
<table id="" border ="1'" width="610" height="100" align="left">
		<h4>저자소개</h4>
		<tr><td><%= book.getAuthorIntro() %></td></tr>

</table>
</div>
<div style="margin-right: 1150px; margin-left: 0; margin-top: 150px;">
<%@ include file="../common/footer.jsp" %>
</div>
</body>
</html>