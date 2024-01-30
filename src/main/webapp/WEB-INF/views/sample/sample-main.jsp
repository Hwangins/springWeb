<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/sample/sample-header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<script type="text/javascript">
	
	window.onload = function(){
		console.log('param.id' + '${param.id}');
		
		var searchBtn = document.getElementById("searchBtn");
		searchBtn.addEventListener("click", function(event){
			//Message property
			alert("<spring:message code='success.search.msg'/>");
		});
		
		addElement();
	}
	
	function addElement(id, strHtml){
		id = 'art';
		strHtml = "<button type='button' name='test'>test</button>";
		
		var art = document.querySelector("#"+id);
		art.insertAdjacentHTML("beforeend", strHtml);
		
		var testBtn = document.getElementsByName("test");
		
		for(var i = 0; i < testBtn.length; i++){
			testBtn[i].addEventListener("click", function(event){
				alert("<spring:message code='success.search.msg'/>");
			});
		}
	}
</script>
</head>
<body>
<form action="/sample/list">
	<button type="submit">제출</button>
</form>
	<div>
		<header>
			sample-main.jsp
			<!-- Message property 예시 -->
			<!--  <h1><spring:message code='success.save.msg'/></h1> -->
		</header>
		<nav></nav>
		<main>
			<article></article>
			<section></section>
			<aside>
				<article id="art">
					<button type="button" id="searchBtn">조회</button>
				</article>
			</aside>
		</main>
		<footer></footer>
	</div>
</body>
<%@ include file="/WEB-INF/views/sample/sample-footer.jsp" %>
</html>