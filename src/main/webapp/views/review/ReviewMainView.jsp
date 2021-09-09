<%@page import="review.model.vo.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Review review = (Review)request.getAttribute("review");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<style type="text/css">
* { font-family: 'Noto Serif KR', serif; }
div#bookimg img {
	width: 250px;
	height: 400px;
	padding: 0;
}

div#paper img{
	width: 300px;
	height: 500px;
	padding: 0;
}

div#ebook img{
	width: 300px;
	height: 500px;
	padding: 0;
}

div#audio img{
	width: 300px;
	height: 500px;
	padding: 0;
}

.cate {
	width: 150px;
	height: 35px;
	background-color: #58ACFA;
	-webkit-border-radius: 10px;
	text-align: center;
	border: 1px solid black;
	font-size: 12pt;
	color: white;
}

.searchform {
	align: center;
	position: relative;
	left: 550px;
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

.searchform .submit {
	background-color: #D358F7;
	border: 2px solid #8904B1;
	-webkit-border-radius: 10px;
	color: white;
	font-size: 16pt;
	width: 80px;
	padding-bottom: 5px;
}

.topreview {
	align: center;
	position: relative;
	text-align: center;
	left: 500px;	
	width: 500px;
	margin-bottom: 10px;
	border: 3px solid #5F04B4;
	-webkit-border-radius: 10px;
}

.usimg {
	width: 200px;
	border: 1px solid #81BEF7;
	-webkit-border-radius: 5px;
}

.uslist {
	width: 340px;
}

.toppaper {
	align: center;
	position: relative;
	left: 300px;
	width: 950px;
	margin-bottom: 10px;
	border: 3px solid #5F04B4;
	-webkit-border-radius: 10px;
}

.topebook {
	align: center;
	position: relative;
	left: 300px;
	width: 950px;
	margin-bottom: 10px;
	border: 3px solid #5F04B4;
	-webkit-border-radius: 10px;
}

.topaudio {
	align: center;
	position: relative;
	left: 300px;
	width: 950px;
	margin-bottom: 10px;
	border: 3px solid #5F04B4;
	-webkit-border-radius: 10px;
}

a {
 	text-decoration: none;
    color: #8181F7;
}

.cate a {
	text-decoration: none;
	color: white;
}

.more a {
	text-decoration: none;
	color: white;
}

.keyword {
   color: #8904B1;
   border: 2px solid #8904B1;
   -webkit-border-radius: 10px;
   height: 35px;
   padding-top: 5px;
}
</style> 
<script type="text/javascript" src= "/bookjeok/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">



$(function(){
	$.ajax({
		url: "/bookjeok/rtop6",
		type: "get",
		dataType: "json",
		success: function(data){
			console.log("success : " + data);
			
			//object --> string
			var str = JSON.stringify(data);
			//string --> json 
			var json = JSON.parse(str);
			
			values = "";
			for(var i in json.list){				
				values += "<tr>"
						+ "<td rowspan = '5' class = 'usimg'><a href='/bookjeok/ralldetail?bookname=" + json.list[i].bname + "'>" + "<img width='100%' src = '../../resources/book_img/" + json.list[i].bimg + "'>"
						+	"</a></td><td class = 'uslist'><a href='/bookjeok/ralldetail?bookname=" + json.list[i].bname + "'>"
						+ decodeURIComponent(json.list[i].rname).replace(/\+/gi, " ")
						+ "</a></td></tr><tr><td class = 'uslist'><a href='/bookjeok/ralldetail?bookname=" + json.list[i].bname + "'>" + json.list[i].rsc
						+ "</a></td></tr><tr><td class = 'uslist'><a href='/bookjeok/ralldetail?bookname=" + json.list[i].bname + "'>" + decodeURIComponent(json.list[i].rkey).replace(/\+/gi, " ")
						+ "</a></td></tr><tr><td class = 'uslist'><a href='/bookjeok/ralldetail?bookname=" + json.list[i].bname + "'>" + decodeURIComponent(json.list[i].rcon).replace(/\+/gi, " ")
						+ "</a></td></tr><tr><td class = 'uslist'><a href='/bookjeok/ralldetail?bookname=" + json.list[i].bname + "'>" + json.list[i].rdate
						+ "</a></td></tr>";				
			}	
			$('#topreview').html($('#topreview').html() + values);
		},

			
		error: function(jqXHR, textstatus, errorthrown){
			console.log("error : " + jqXHR + ", " + textstatus
					+ ", " + errorthrown);
		}
	});
	
	$.ajax({
		url: "/bookjeok/rtoppaper",
		type: "get",
		dataType: "json",
		success: function(data){
			console.log("success : " + data);
			
			//object --> string
			var str = JSON.stringify(data);
			//string --> json 
			var json = JSON.parse(str);
			
			values = "";
			for(var i = 0, k; i < json.list.length; i++){
				if(i % 4 == 0){
					k = i;
					values += "<tr>";
				}
					values += "<td><table><tr><td colspan='2'><a href='/bookjeok/rdetail?booknm=" + json.list[i].bname + "'>"
								+ "<img src = '../../resources/book_img/" + json.list[i].bimg + "'>"
								+ "</a></td></tr><tr><td><a href='/bookjeok/rdetail?booknm=" + json.list[i].bname + "'>"
								+ decodeURIComponent(json.list[i].rname).replace(/\+/gi, " ")
								+ "</a></td><td><a href='/bookjeok/rdetail?booknm=" + json.list[i].bname + "'>"
								+ decodeURIComponent(json.list[i].rid).replace(/\+/gi, " ")
								+ "</a></td></tr><tr><td colspan = '2'><a href='/bookjeok/rdetail?booknm=" + json.list[i].bname + "'>"
								+ json.list[i].rdate
								+ "</a></td></tr><tr><td colspan = '2'><a href='/bookjeok/rdetail?booknm=" + json.list[i].bname + "'>"
								+ decodeURIComponent(json.list[i].rcon).replace(/\+/gi, " ")
								+ "</a></td></tr></table></td>";
				if(k + 3 == i){
					values += "</tr>";
				}
			}
				

			$('#toppaper').html($('#toppaper').html() + values);
		},
		
		error: function(jqXHR, textstatus, errorthrown){
			console.log("error : " + jqXHR + ", " + textstatus
					+ ", " + errorthrown);
		}
	});
		
		$.ajax({
			url: "/bookjeok/rtopebook",
			type: "get",
			dataType: "json",
			success: function(data){
				console.log("success : " + data);
				
				//object --> string
				var str = JSON.stringify(data);
				//string --> json 
				var json = JSON.parse(str);
				
				values = "";
				for(var i = 0, k; i < json.list.length; i++){
					if(i % 4 == 0){
						k = i;
						values += "<tr>";
					}
						values += "<td><table><tr><td colspan='2'><a href='/bookjeok/rdetaile?booknm=" + json.list[i].bname + "'>"
									+ "<img src = '../../resources/book_img/" + json.list[i].bimg + "'>"
									+ "</a></td></tr><tr><td><a href='/bookjeok/rdetaile?booknm=" + json.list[i].bname + "'>"
									+ decodeURIComponent(json.list[i].rname).replace(/\+/gi, " ")
									+ "</a></td><td><a href='/bookjeok/rdetaile?booknm=" + json.list[i].bname + "'>"
									+ decodeURIComponent(json.list[i].rid).replace(/\+/gi, " ")
									+ "</a></td></tr><tr><td colspan = '2'><a href='/bookjeok/rdetaile?booknm=" + json.list[i].bname + "'>"
									+ json.list[i].rdate
									+ "</a></td></tr><tr><td colspan = '2'><a href='/bookjeok/rdetaile?booknm=" + json.list[i].bname + "'>"
									+ decodeURIComponent(json.list[i].rcon).replace(/\+/gi, " ")
									+ "</a></td></tr></table></td>";
					if(k + 3 == i){
						values += "</tr>";
					}
				}
					

				$('#topebook').html($('#topebook').html() + values);
			},

		error: function(jqXHR, textstatus, errorthrown){
			console.log("error : " + jqXHR + ", " + textstatus
					+ ", " + errorthrown);
		}
	});
		
		$.ajax({
			url: "/bookjeok/rtopaudio",
			type: "get",
			dataType: "json",
			success: function(data){
				console.log("success : " + data);
				
				//object --> string
				var str = JSON.stringify(data);
				//string --> json 
				var json = JSON.parse(str);
				
				values = "";
				for(var i = 0, k; i < json.list.length; i++){
					if(i % 4 == 0){
						k = i;
						values += "<tr>";
					}
						values += "<td><table><tr><td colspan='2'><a href='/bookjeok/rdetaila?booknm=" + json.list[i].bname + "'>"
									+ "<img src = '../../resources/book_img/" + json.list[i].bimg + "'>"
									+ "</a></td></tr><tr><td><a href='/bookjeok/rdetaila?booknm=" + json.list[i].bname + "'>"
									+ decodeURIComponent(json.list[i].rname).replace(/\+/gi, " ")
									+ "</a></td><td><a href='/bookjeok/rdetaila?booknm=" + json.list[i].bname + "'>"
									+ decodeURIComponent(json.list[i].rid).replace(/\+/gi, " ")
									+ "</a></td></tr><tr><td colspan = '2'><a href='/bookjeok/rdetaila?booknm=" + json.list[i].bname + "'>"
									+ json.list[i].rdate
									+ "</a></td></tr><tr><td colspan = '2'><a href='/bookjeok/rdetaila?booknm=" + json.list[i].bname + "'>"
									+ decodeURIComponent(json.list[i].rcon).replace(/\+/gi, " ")
									+ "</a></td></tr></table></td>";
					if(k + 3 == i){
						values += "</tr>";
					}
				}
					

				$('#topaudio').html($('#topaudio').html() + values);
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


<!-- 로그인x -->
<% if(loginUser == null) { %>
	<form action="/bookjeok/views/user/loginPage.jsp">
	<input type="submit" class="newreview" name="newreview" value="리뷰 등록하기" style="float:right; color: #fff; background:#8181F7; 
				font-size:2em; border-radius:0.7em; 
				padding:5px 20px; margin-right:300px; margin-top:70px;	"><br>
	</form>
	
<% }else{ %>

	<%-- 로그인했을 때 --%>
	<form action="/bookjeok/views/review/ReviewCertificationForm.jsp">
	<input type="submit" class="newreview" name="newreview" value="리뷰 등록하기" style="float:right; color: #fff; background:#8181F7; 
				font-size:2em; border-radius:0.7em; 
				padding:5px 20px; margin-right:300px; margin-top:70px;	"><br>
	</form>
<% } %>

<button type="button" class="cate"
style="color: #fff; background:#8181F7; 
font-size:1em; border-radius:0.5em; 
padding:5px 20px; margin-left:300px; margin-top:10px;"><a href="/bookjeok/prlist">페이퍼북</a></button> <br>

<button type="button" class="cate"
style="color: #fff; background:#8181F7; 
font-size:1em; border-radius:0.5em; 
padding:5px 20px; margin-left:300px;"><a href="/bookjeok/erlist">E-Book</a></button> <br>

<button type="button" class="cate"
style="color: #fff; background:#8181F7; 
font-size:1em; border-radius:0.5em; 
padding:5px 20px; margin-left:300px;"><a href="/bookjeok/arlist">오디오북</a></button> <br>


<!-- 로그인x -->
<% if(loginUser != null) { %>
	<button type="button" class="more"
				style="float:right; color: #fff; background:#8181F7; 
				font-size:2em; border-radius:0.7em; 
				padding:5px 20px; margin-right:300px;"><a href="/bookjeok/rmylist?userid=<%=loginUser.getUserId()%>">나의 리뷰</a></button> <br> <br> <br>
<% } %>

<form id="idform" class="searchform" action="/bookjeok/allsearch" method="post" >
<div class="searchset" align="center">
<select class="searchtype" name="searchtype">
<option value="bookname">책 제목</option>
<option value="writerid">작성자</option>
</select>
<input type="search" class="keyword" name="keyword"> &nbsp; 
<input type="submit" class="submit" value="검색">
</div>
</form>

<h4 align="center" style="font-size:3em">오늘의 베스트 리뷰</h4>



<div id="bookimg" class="topreview">
   <table id="topreview"  border="1" cellspacing="0" align=center >
   </table>
</div>

<br><br><br><br><br>

<h3 align="center" style="font-size:2em">상품별 추천 리뷰</h3>
<h2 align="center" style="font-size:1em">페이퍼북 리뷰</h2>

<div id="paper" class="toppaper">
	<table id="toppaper" border="1", cellspacing="0" align=center>
	</table>
</div>

<br><br><br>

<h2 align="center" style="font-size:1em">E-Book 리뷰</h2>

<div id="ebook" class="topebook">
	<table id="topebook" border="1", cellspacing="0" align=center>
	</table>
</div>

<br><br><br>

<h2 align="center" style="font-size:1em">오디오북 리뷰</h2>

<div id="audio" class="topaudio">
	<table id="topaudio" border="1", cellspacing="0" align=center>
	</table>
</div>


<br>
<%@ include file="../common/footer.jsp" %>
</body>
</html>