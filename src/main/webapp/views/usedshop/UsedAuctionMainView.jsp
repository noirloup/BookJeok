<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="usedshop.model.vo.UsedShopAuction, java.util.ArrayList" %>
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
.allcontentbox {
	position: relative;
	left: 80px;
	top: -1070px;
}
.newcontitle {
	position: relative;
	color: #3A01DF;
}
.newcondiv {
	position: relative;
	float: left;
	border: 2px solid #8181F7;
	-webkit-border-radius: 5px;
	padding: 5px;
	margin: 5px;
	text-align: center;
}
.hotcontitle {
	position: relative;
	color: #3A01DF;
}
.hotcondiv {
	position: relative;
	float: left;
	border: 2px solid #8181F7;
	-webkit-border-radius: 5px;
	padding: 5px;
	margin: 5px;
	text-align: center;
}
.lastcontitle {
	position: relative;
	float: left;
	color: #3A01DF;
}
.lastcondiv {
	position: relative;
	float: left;
	border: 2px solid #8181F7;
	-webkit-border-radius: 5px;
	padding: 5px;
	margin: 5px;
	text-align: center;
}
.contable {
	width: 165px;
}
.contable a {
	text-decoration: none;
	color: #8181F7;
}
#bookimg {
	width: 165px;
}
.title {
	width: 100px;
	height: 40px;
}
#footer {
	position: relative;
	top: -930px;
}
.searchform {
	align: center;
	position: relative;
	top: -1060px;
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
<script type="text/javascript" src="/bookjeok/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	// 경매 경매장터 신규등록
	$.ajax({
		url: "/bookjeok/usaunewtop",
		type: "get",
		dataType: "json",
		success: function(data){
		console.log("success : " + data);
	         
		//object --> string
		var str = JSON.stringify(data);
		//string --> json 
		var json = JSON.parse(str);
	         
		values = "";
		for(var i = 0, k; i< json.list.length; i++) {
			if(i % 4 == 0) {
				k = i; //0, 4, 8, 12
				values += "<tr>";
			}
			
			values += "<td><table class='contable'><tr><td colspan='2'><a href='/bookjeok/usaudetail?marketcd="
					+ json.list[i].amarketcd + "'>"
					+ "<img id='bookimg' src='../../resources/book_img/" + json.list[i].bookimg + "'></a></td></tr><tr>"
					+ "<td class='title'><a href='/bookjeok/usaudetail?marketcd=" + json.list[i].amarketcd + "'>"
					+ json.list[i].booknm
					+ "</td></tr><tr><td class='bid'><a href='/bookjeok/usaudetail?marketcd="
					+ json.list[i].amarketcd + "'>"
					+ json.list[i].currentbid
					+ "</td></tr><tr><td class='closedate'><a href='/bookjeok/usaudetail?marketcd="
					+ json.list[i].amarketcd + "'>"
					+ json.list[i].aclosedate
					+ " 마감</td></table></td>"
			
					if(k + 3 == i) {
						values += "</tr>"
					}
			}
	         
		$('#newuslist').html($('#newuslist').html() + values);
		},	// success
		error: function(jqXHR, textstatus, errorthrown) {
			console.log("error : " + jqXHR + ", " + textstatus + ", " + errorthrown);
		}
	});
});
$(function(){
	// 경매 경쟁품목 Top4
	$.ajax({
		url: "/bookjeok/usauhottop",
		type: "get",
		dataType: "json",
		success: function(data){
		console.log("success : " + data);
	         
		//object --> string
		var str = JSON.stringify(data);
		//string --> json 
		var json = JSON.parse(str);
	         
		values = "";
		for(var i = 0, k; i< json.list.length; i++) {
			if(i % 4 == 0) {
				k = i; //0, 4, 8, 12
				values += "<tr>";
			}
			
			values += "<td><table class='contable'><tr><td colspan='2'><a href='/bookjeok/usaudetail?marketcd="
					+ json.list[i].amarketcd + "'>"
					+ "<img id='bookimg' src='../../resources/book_img/" + json.list[i].bookimg + "'></a></td></tr><tr>"
					+ "<td class='title'><a href='/bookjeok/usaudetail?amarketcd=" + json.list[i].amarketcd + "'>"
					+ json.list[i].booknm
					+ "</td></tr><tr><td class='bid'><a href='/bookjeok/usaudetail?amarketcd="
					+ json.list[i].amarketcd + "'>"
					+ json.list[i].currentbid
					+ "</td></tr><tr><td class='closedate'><a href='/bookjeok/usaudetail?amarketcd="
					+ json.list[i].amarketcd + "'>"
					+ json.list[i].aclosedate
					+ " 마감</td></table></td>"
			
					if(k + 3 == i) {
						values += "</tr>"
					}
			}
	         
		$('#hotuslist').html($('#hotuslist').html() + values);
		},	// success
		error: function(jqXHR, textstatus, errorthrown) {
			console.log("error : " + jqXHR + ", " + textstatus + ", " + errorthrown);
		}
	});
});
$(function(){
	// 경매 마감임박 Top4
	$.ajax({
		url: "/bookjeok/usaulasttop",
		type: "get",
		dataType: "json",
		success: function(data){
		console.log("success : " + data);
	         
		//object --> string
		var str = JSON.stringify(data);
		//string --> json 
		var json = JSON.parse(str);
	         
		values = "";
		for(var i = 0, k; i< json.list.length; i++) {
			if(i % 4 == 0) {
				k = i; //0, 4, 8, 12
				values += "<tr>";
			}
			
			values += "<td><table class='contable'><tr><td colspan='2'><a href='/bookjeok/usaudetail?marketcd="
					+ json.list[i].amarketcd + "'>"
					+ "<img id='bookimg' src='../../resources/book_img/" + json.list[i].bookimg + "'></a></td></tr><tr>"
					+ "<td class='title'><a href='/bookjeok/usaudetail?marketcd=" + json.list[i].amarketcd + "'>"
					+ json.list[i].booknm
					+ "</td></tr><tr><td class='bid'><a href='/bookjeok/usaudetail?marketcd="
					+ json.list[i].amarketcd + "'>"
					+ json.list[i].currentbid
					+ "</td></tr><tr><td class='closedate'><a href='/bookjeok/usaudetail?marketcd="
					+ json.list[i].amarketcd + "'>"
					+ json.list[i].aclosedate
					+ " 마감</td></table></td>"
			
					if(k + 3 == i) {
						values += "</tr>"
					}
			}
	         
		$('#lastuslist').html($('#lastuslist').html() + values);
		},	// success
		error: function(jqXHR, textstatus, errorthrown) {
			console.log("error : " + jqXHR + ", " + textstatus + ", " + errorthrown);
		}
	});
});
</script>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<%@ include file="../common/usedshopAuctionTopMenu.jsp" %>

<form id="idform" class="searchform" action="/bookjeok/usausearch" method="post" align="center">
<div class="searchset" align="center">
<select class="searchtype" name="searchtype">
<option value="bookname">책 제목</option>
<option value="writerid">작성자</option>
</select>
<input type="search" class="keyword" name="keyword"> &nbsp; 
<input type="submit" class="submit" value="검색">
</div>
</form>

<table class="allcontentbox" align="center">
	<tr>
		<td>
			<tr><td><h2 class="newcontitle">최근 등록 상품</h2></td></tr>
			<tr><td><div class="newcondiv">
				<table id="newuslist" cellspacing="0">
					
				</table>
			</div></td></tr>
		</td>
	</tr>
	<tr>
		<td>
			<tr><td><h2 class="hotcontitle">경쟁 품목</h2></td></tr>
			<tr><td><div class="hotcondiv">
				<table id="hotuslist" cellspacing="0" >
			
				</table>
			</div></td></tr>
		</td>
	</tr>
	<tr>
		<td>
			<tr><td><h2 class="lastcontitle">마감 임박</h2></td></tr>
			<tr><td><div class="lastcondiv">
				<table id="lastuslist" cellspacing="0" >
			
				</table>
			</div></td></tr>
		</td>
	</tr>
</table>
<%@ include file="../common/footer.jsp" %>
</body>
</html>