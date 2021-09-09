<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="book.model.vo.Book, java.util.ArrayList" %>    
<%
	ArrayList<Book> list = (ArrayList<Book>)request.getAttribute("list");
	Book book = (Book)request.getAttribute("book");
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
img {
	width: 200px;
    height: 300px;
}
.allcontentbox {
	position: relative;
}
.contitle {
	position: relative;
	color: #3A01DF;
	left: 20px;
	margin-bottom: 0px;
	text-align: left;
}
.bookcondiv {
	position: relative;
	width: 840px;
	height: 360px;
	border: 3px solid #8181F7;
	-webkit-border-radius: 5px;
	text-align: center;
	padding: 5px;
	margin: 5px;
}
.bookcondiv a {
	text-decoration: none;
	color: #8181F7;
}
.usedcondiv {
	position: relative;
	width: 840px;
	height: 390px;
	border: 3px solid #8181F7;
	-webkit-border-radius: 5px;
	text-align: center;
	padding: 5px;
	margin: 5px;
}
.usedcondiv a {
	text-decoration: none;
	color: #8181F7;
}
.reviewcondiv {
	position: relative;
	width: 840px;
	height: 390px;
	border: 3px solid #8181F7;
	-webkit-border-radius: 5px;
	text-align: center;
	padding: 5px;
	margin: 5px;
}
.reviewcondiv a {
	text-decoration: none;
	color: #8181F7;
}
</style>
<script type="text/javascript" src="/bookjeok/resources/js/jquery-3.6.0.min.js">
</script>
<script type="text/javascript">
$(function(){
	//페이퍼북 베스트셀러
	$.ajax({
		url : "/bookjeok/bkbest4",
		type : "get",
		dataType : "json",
		success : function(data) {
		console.log("success : " + data);

		//object --> string
		var str = JSON.stringify(data);
		//string --> json 
		var json = JSON.parse(str);

		values = "";
		for (var i = 0, k; i < json.list.length; i++) {
			if (i % 4 == 0) {
				k = i; //0, 4, 8, 12
				values += "<tr>";
			}
			
			values += "<td><table>"
					+ "<tr><td><a href='/bookjeok/bkdetail?bookid="
					+ json.list[i].bookid
					+ "'>"
					+ "<img src='/bookjeok/resources/book_img/" + json.list[i].bookimg + "'></a></td></tr><tr>"
					+ "<td><a href='/bookjeok/bkdetail?bookid="
					+ json.list[i].bookid + "'>"
					+ json.list[i].booknm
					+ "</a></td></tr><tr><td><a href='/bookjeok/bkdetail?bookid="
					+ json.list[i].bookid + "'>"
					+ json.list[i].author
					+ "</a></td></table></td>"
					
			if (k + 3 == i) {
				values += "</tr>"
			}
		}

				$('#paperbest').html($('#paperbest').html() + values);
	
		},
		error : function(jqXHR, textstatus, errorthrown) {
			console.log("error : " + jqXHR + ", " + textstatus
					+ ", " + errorthrown);
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
					+ "<img id='bookimg' src='/bookjeok/resources/book_img/" + json.list[i].bookimg + "'></a></td></tr><tr>"
					+ "<td class='title'><a href='/bookjeok/usaudetail?marketcd=" + json.list[i].amarketcd + "'>"
					+ json.list[i].booknm
					+ "</td></tr><tr><td class='bid'><a href='/bookjeok/usaudetail?marketcd="
					+ json.list[i].amarketcd + "'>"
					+ "입찰가 : " + json.list[i].currentbid
					+ "</td></tr><tr><td class='closedate'><a href='/bookjeok/usaudetail?marketcd="
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
	$.ajax({
		url: "/bookjeok/rtop4",
		type: "get",
		dataType: "json",
		success: function(data){
			console.log("success : " + data);
			
			//object --> string
			var str = JSON.stringify(data);
			//string --> json 
			var json = JSON.parse(str);
			
			values = "";
			for(var i = 0, k; i < json.list.length; i++) {
				if(i % 4 == 0) {
					k = i;
					values += "<tr>";
				}
				
					values += "<td><table><tr><td colspan='2'><a href='/bookjeok/ralldetail?bookname=" + json.list[i].bname + "'>"
								+ "<img src = '/bookjeok/resources/book_img/" + json.list[i].bimg + "'>"
								+ "</a></td></tr><tr><td><a href='/bookjeok/ralldetail?bookname=" + json.list[i].bname + "'>"
								+ decodeURIComponent(json.list[i].rname).replace(/\+/gi, " ")
								+ "</a></td></tr><tr><td><a href='/bookjeok/ralldetail?bookname=" + json.list[i].bname + "'>"
								+ json.list[i].rid
								+ "</a></td></tr><tr><td colspan = '2'><a href='/bookjeok/ralldetail?bookname=" + json.list[i].bname + "'>"
								+ json.list[i].rdate
								+ "</a></td></tr></table></td>";
				
								if(k + 3 == i) {
					values += "</tr>";
				}
			}
			
			$('#topreview').html($('#topreview').html() + values);
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
<%@ include file="views/common/menubar.jsp" %>

<table class="allcontentbox" align="center">
	<tr>
		<td>
			<tr><td><h1 class="contitle" align="center">페이퍼북 베스트셀러</h1></td></tr>
			<tr><td><div class="bookcondiv">
				<table id="paperbest" cellspacing="0" align="center">

				</table>
			</div></td></tr>
		</td>
	</tr>
	<tr>
		<td>
			<tr><td><h1 class="contitle" align="center">경매장터 경쟁 품목</h1></td></tr>
			<tr><td><div class="usedcondiv">
				<table id="hotuslist" cellspacing="0" >
			
				</table>
			</div></td></tr>
		</td>
	</tr>
	<tr>
		<td>
			<tr><td><h1 class="contitle" align="center">오늘의 베스트 리뷰</h1></td></tr>
			<tr><td><div class="reviewcondiv">
			   <table id="topreview" cellspacing="0">
			   
			   </table>
			</div></td></tr>
		</td>
	</tr>
</table>




<%@ include file="views/common/footer.jsp" %>
</body>
</html>