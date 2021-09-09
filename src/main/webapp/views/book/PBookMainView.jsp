<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 <%@ page import="book.model.vo.Book, java.util.ArrayList" %>   
<%
	ArrayList<Book> list = (ArrayList<Book>)request.getAttribute("list");
	Book book = (Book)request.getAttribute("book");
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
img{
	width: 200px;
    height: 300px;
	}
.searchform {
	position: relative;
	top: 90px;
	left: 995px;
}
.action {
	border: 2px solid #58ACFA;
	-webkit-border-radius: 10px;
	font-size: 12pt;
	margin-top: 5px;
	height: 30px;
}

.keyword {
	color: #8904B1;
	border: 2px solid #58ACFA;
	-webkit-border-radius: 10px;
	height: 30px;

}

.searchform .submit {
	background-color: #58ACFA;
	border: 2px solid #58ACFA;
	-webkit-border-radius: 10px;
	color: white;
	font-size: 12pt;
	width: 80px;

}
.booktitle {
	position: relative;
	right: -510px;
	color: #3A01DF;
	margin-top: 50px;
	margin-bottom: 0px;

}
.bookcondiv {
	position: relative;
	width: 870px;
	height: 360px;
	border: 3px solid #8181F7;
	-webkit-border-radius: 5px;
	left: 500px;
	text-align: center;
	padding: 5px;
	margin: 5px;
}
.bookcondiv a {
	text-decoration: none;
	color: #8181F7;
}


</style>
<meta charset="UTF-8">
<title>북적북적</title>
<script type="text/javascript" src="/bookjeok/resources/js/jquery-3.6.0.min.js">

</script>
<script type="text/javascript">
$(function(){
	//페이퍼북 베스트셀러
	   $.ajax({
	      url: "/bookjeok/bkbest10",
	      type: "get",
	      dataType: "json",
	      success: function(data){
	         console.log("success : " + data);
	         
	         //object --> string
	         var str = JSON.stringify(data);
	         //string --> json 
	         var json = JSON.parse(str);
	         
	         values = "";
	         for(var i = 0, k; i< json.list.length; i++){
					if(i % 4 == 0){
						k =i; //0, 4, 8, 12
						values += "<tr>";
					}
						values +="<td><table><tr><th>"
							+ json.list[i].ranking 
							+"</th></tr>"
							+	"<tr><td><a href='/bookjeok/bkdetail?bookid="
							+ json.list[i].bookid + "'>"
							+ "<img src='/bookjeok/resources/book_img/" + json.list[i].bookimg + "'></a></td></tr><tr>"
							+ "<td><a href='/bookjeok/bkdetail?booknm="
							+ json.list[i].booknm + "'>"
							+ json.list[i].booknm 
							+ "</td></tr><tr><td>"
							+ json.list[i].author
							+ "</td></table></td>"
					if(k + 3 == i){
						values += "</tr>"
					}
			}
	         
	         $('#paperbest').html($('#paperbest').html() + values);
	      
	      },
	      error: function(jqXHR, textstatus, errorthrown){
	         console.log("error : " + jqXHR + ", " + textstatus
	               + ", " + errorthrown);
	      }
	   });
	   
	//페이퍼북 신규도서
	   $.ajax({
		      url: "/bookjeok/bknew10",
		      type: "get",
		      dataType: "json",
		      success: function(data){
		         console.log("success : " + data);
		         
		         //object --> string
		         var str = JSON.stringify(data);
		         //string --> json 
		         var json = JSON.parse(str);
		         
		         values = "";
		         for(var i = 0, k; i< json.list.length; i++){
	                  if(i % 4 == 0){
	                     k =i; //0, 4, 8, 12
	                     values += "<tr>";
	                  }
	                  values +="<td><table><tr><td><a href='/bookjeok/bkdetail?bookid="
							+ json.list[i].bookid + "'>"
							+ "<img src='/bookjeok/resources/book_img/" + json.list[i].bookimg + "'></a></td></tr><tr>"
							+ "<td><a href='/bookjeok/bkdetail?booknm="
							+ json.list[i].booknm + "'>"
							+ json.list[i].booknm 
							+ "</td></tr><tr><td>"
							+ json.list[i].author
							+ "</td></table></td>"
	                  if(k + 3 == i){
	                     values += "</tr>"
	                  }
	            }
		         
		         $('#papernew').html($('#papernew').html() + values);
		      
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
<%@ include file="../common/ProductMain.jsp" %>

<form id="idform" class="searchform" action="/bookjeok/bksearch" method="post">
<div class="searchset" >
<select class="action" name="action">
<option value="booknm">책 제목</option>
<option value="author">저자</option>
</select>
<input type="search" class="keyword" name="keyword"> &nbsp; 
<input type="submit" class="submit" value="검색">
</div>
</form>

<h1 class="booktitle" style="width: 300px; margin-top:50px;">페이퍼북 베스트셀러</h1>
<div class="bookcondiv" id="bookdiv" style="white-space:nowrap; overflow:auto; height:390px;  border:1px solid navy; text-align: center; ">
	<table id="paperbest"   class="allcontentbox" align="center" >

	</table>
</div>

<h1 class="booktitle">페이퍼북 신규도서</h1>
<div class="bookcondiv" id="bookdiv" style="white-space:nowrap; overflow:auto;  height:770px;  border:1px solid navy; text-align: center;">
	<table id="papernew"  class="allcontentbox" align="center">
		
		</table>

</div>

<div style= "margin-left:0px;">
<%@ include file="../common/footer.jsp" %>
</div>

</body>

</html>
