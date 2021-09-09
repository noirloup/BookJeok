<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="book.model.vo.Book, java.util.ArrayList" %>    


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북적북적</title>
<style type="text/css">
.cateform {
	margin-top: -90px;
	margin-left: 1065px;
	position: relative;
	align: center;
}

</style>
<script type="text/javascript" src="/bookjeok/resources/js/jquery-3.6.0.min.js"></script>
<script>
//$(function(){
//	$("#selcate").on("change", function(){
//		var category = $("select[name=selcate]").val(""):
//	});
//});
function movepage(){

	location.href="/bookjeok/plist?category=" + category;

}

</script>
</head>
<body>
<form  class="cateform" action="/bookjeok/plist" method="get">장르검색
<select name= "location">
	<option name= "selection" disabled>= 국내/외 =</option>
	<option name = "location" value ="0">전체</option>
	<option name = "location" value ="1">국내도서</option>
	<option name = "location" value ="2">국외도서</option>
</select>
<select name="category">
    <option name="selection" id ="selection" disabled>== 장르 선택 ==</option>
    <option name="category" value="0" >전체</option>
    <option name="category" value="1" >소설</option>
    <option name="category" value="2">경제/경영</option>
    <option name="category" value="3">자기계발</option>
    <option name="category" value="4">시/에세이</option>
    <option name="category" value="5">인문</option>
    <option name="category" value="6">국어/외국어</option>
    <option name="category" value="7">역사/풍속/신화</option>
    <option name="category" value="8">사회/정치/법</option>
    <option name="category" value="9">장르소설</option>
    <option name="category" value="10">코믹스</option>
    <option name="category" value="11">아동</option>
    <option name="category" value="12">유아</option>
    <option name="category" value="13">예술/대중문화</option>
    <option name="category" value="14">교재/수험서</option>
    <option name="category" value="15">청소년교양</option>
    <option name="category" value="16">자연과학/공학</option>
    <option name="category" value="17">종교/역학</option>
    <option name="category" value="18">건강/의학</option>
    <option name="category" value="19">북모닝</option>
    <option name="category" value="20">여행/취미</option>
    <option name="category" value="21">메거진</option>
    <option name="category" value="22">가정/생활/요리</option>
    <option name="category" value="23">컴퓨터/인터넷</option>
  </select>
  <input type ='submit' value="이동">
</form>


</body>
</html>