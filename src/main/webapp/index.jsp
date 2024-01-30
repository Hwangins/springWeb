<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인덱스</title>

<link rel="stylesheet" href="/css/initialization.css" />
<script src="/js/jquery-3.7.1.min.js"></script>
<script src="/js/jquery.tmpl.js"></script>

<style type="text/css">
	.wrap{
		width: 500px;
		height: 500px;
	}
	.wrap .top {
		width: 100%;
		height: 100%;
		display: flex;
		justify-content: right;
		border: 1px solid black;
		padding : 10px;
	}
	.top .start-btn{
		width: 100px;
		height: 25px;
		border: 1px rgba(0,0,0,0.16) solid;
		border-radius: 15px;
		animation : test 1s step-end infinite;
		cursor: pointer;
	}
	
	@keyframes test{
		50%{ 
/* 			opacity : 0%; */
			background-color:black;
			color: white;
		}
	}
</style>
<script type="text/javascript">
	
	$(document).ready(function(){
		var r = {"a1" : "1", "b1" : "2"};
		
		var tmp = $("#tmpl").tmpl(r);
		$("#test").append(tmp);
		
	});
	
	function loginPage(){
		document.indexForm.action = "/user/login-page";
		document.indexForm.submit();
	}
	
</script>
<script type="text/template" id="tmpl">
<div>{{= a1 }}</div>
<div>{{= b1 }}</div>
</script>
</head>
<body>

	<div>
		<header>
			<nav>
			</nav>
		</header>
		<main>
			<form action="/user/join">
				<button type="submit">회원가입 화면</button>
			</form>
		</main>
		<footer>
		</footer>
	</div>
</div>	
</body>
</html>