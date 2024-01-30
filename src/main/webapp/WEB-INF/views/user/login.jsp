<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<%@ include file="/WEB-INF/views/include/resource.jsp" %>
<style type="text/css">
	@keyframes slidein {
		from {
		  /*
		  margin-left: 100%;
		  width: 300%;
		  */
		  background:#fee500;
		  color:#6E6E6E;
		}
		
		to {
		  /*
		  margin-left: 0%;
		  width: 100%;
		  */
		  background:white;
		  color:black;
		}
	}
	
	.wrap{
		width: 450px;
		height: 500px;
 		border: 1px solid #ddd;
		margin : 7% auto;
		box-shadow: 5px 5px 5px 5px blur gray;
  		display: flex;
  		justify-content: center;
 		align-items: center;
		flex-direction: column;
		padding: 40px;
		border-radius:8px;
	}
	.wrap .item {
		width: 100%;
	}
	
	.wrap .item > div{
		padding: 5px;
	}
	
	.login-area > input {
		padding: 0px;
		display: block;
		border: 0px;
 		border-bottom: 2px solid #ddd;
 		width: 100%;
 		margin-bottom: 4px;
 		font-size: 14px;
 		height:50px;
	}
	.login-area > input::placeholder{
		font-size: 18px;
		color: #ddd;
	}
	
	.move-area button{
		font-size: 14px;
		background:white;
		border: 0px;
		border-radius:10px;
		font-weight:400;
		cursor: pointer;
	}
	.move-area button:hover{
		color: green;
	}
	.login-btn-area{
		margin-top:10px;
		text-align:center;
	}
	.login-btn{
		display: inline-block;
		width:100%;
		font-size: 16px;
		cursor: pointer;
		border: 1px solid #ddd;
		border-radius:10px;
		background:#fee500;
		height:50px;
		font-weight:400;
		/*
		animation-name:slidein;
		animation-duration:3s;
		*/
		transition: all ease 1s;
	}
	.login-btn:hover{
		background:white;
		color:black;
		font-size:18px;
	}
	.title{
		margin-bottom: 80px;
	}
	.title span{
		font-size: 40px;
    	font-weight: 800;
    	color: #a09a9a;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$(".join-btn").on("click", function(){
			document.loginForm.action="/user/join-page";
			document.loginForm.submit();
		})
	});
</script>
</head>
<body>
<form name="loginForm" action="/login">
    <div class="wrap">
    	<div class="title">
    		<span>KAKAO</span>
   		</div>
    	<div class="item">
	    	<div class="login-area">
	    		<input type="text" placeholder="아이디를 입력하세요"/>
	    		<input type="password" placeholder="비밀번호를 입력하세요"/>
	    		<div class="login-btn-area">
	    			<button type="button" class="login-btn">로그인</button>
	    		</div>
	    	</div>
	    	<div class="move-area">
	    		<button type="button" class="join-btn" title="회원가입하기">회원가입</button>
	    		<button type="button" class="find-id-btn">아이디 찾기</button>
	    		<button type="button" class="find-pw-btn">비밀번호 찾기</button>
	    	</div>
    	</div>
    </div>
</form>
</body>
</html>