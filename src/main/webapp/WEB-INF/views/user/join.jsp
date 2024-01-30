<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%@ include file="/WEB-INF/views/include/resource.jsp" %>
<style type="text/css">
	.wrap{
		width: 450px;
		height: 500px;
 		border: 1px solid #ddd;
		margin : 7% auto;
		box-shadow: 5px 5px 5px 5px blur gray;
  		display: flex;
  		justify-content: center;
 		align-contents: center;
		flex-direction: column;
		padding: 40px;
		border-radius:8px;
	}
	.wrap .content {
		width: 100%;
	}
	
	.wrap .content > div{
		padding: 5px;
	}
	.join-area {
		position:relative;
	}
	.join-area > input, .join-confirm-area > input{
		padding: 0px;
		display: block;
		border: 0px;
 		/* border-bottom: 2px solid #e65f3e; */
 		border-bottom: 2px solid #a09a9a;
 		width: 100%;
 		margin-bottom: 4px;
 		font-size: 20px;
 		height:50px;
 		outline: none;
	}
	input::placeholder{
		font-size: 18px;
		color: #a09a9a;
		vertical-align:center;
		font-weight:400;
	}
	.next-btn-area{
		margin-top:10px;
		text-align:center;
	}
	.next-btn{
		display: inline-block;
		width:100%;
		font-size: 16px;
		cursor: pointer;
		border: 1px solid #ddd;
		border-radius:10px;
		background:#fee500;
		height:50px;
		font-weight:400;
		transition: all ease 1s;
	}
	.next-btn:hover{
		background:white;
		color:black;
		font-size:18px;
	}
	.title{
		margin-bottom: 20px;
		text-align:center;
	}
	.title span{
		font-size: 40px;
    	font-weight: 800;
    	color: #a09a9a;
	}
	.content{
		padding:0px;
	}
	.word-wrap {
		margin-bottom: 50px;
	}
	.word-wrap > div{
		font-size:22px;
		fonte-weight:200;
	}
	.auth-btn{
		width:80px;
		height:30px;
		background:white;
		color:black;
		border: 1px solid #a09a9a;
		border-radius: 20px;
		position: absolute;
		right:4px;
		top: 18px;
		cursor:pointer;
	}
	.explain-area{
		font-size: 12px;
    	margin-top: -10px;
    	color: #999999;
	}
	.explain-area ul {
		font-size: 11px;
		margin-top: 25px;
	}
	
	.explain-area ul, .explain-area li{
		list-style: disc;
		list-style-position: inside;
	}
	.email-err{
		color:#e65f3e;
		display: none;
	}
	.join-confirm-area{
		display: none;
	}
	
</style>
<script type="text/javascript">
	var isValidOk = false;
	
	$(document).ready(function(){
		/* 회원 가입 */
		/*
		$("#join-btn").on("click", function(){
			document.loginForm.action="/user/join-page";
			document.loginForm.submit();
		});
		*/
		
		/* 이메일 유효성 검사 */
		$("#email").on('keyup', function(){
			validEmail();
		});
		
		/* 인증번호 받기 */
		$("#auth-btn").on('click', function(e){
			makeCertificationNumber();
		});
	});
	
	/* 인증요청 : 인증 번호 메일로 받기 */
	function makeCertificationNumber(){
		
		if(isValidOk){
			//인증요청 버튼 제거 & 이메일 주소 readonly
			$(".join-area button").remove();
			$(".join-area input").attr("readonly", "readonly");
			
			//인증번호 확인 입력란 출력
			$(".join-confirm-area").show();
		}else{
			alert("유효한 이메일 주소를 입력해주세요.");
			return;
		}
		
		$.ajax({
			url : "/user/join/auth-code", 
			type : "POST",
			data : { email : $("#email").val()},
			dataType : 'text',
			success : function(result){
				console.log(result);
			},
			error : function(e){
				console.log(e);
			}
		});
	}
	
	/* 인증 번호 일치 확인 */
	function confirmCertificationNumber(){
		
	}
	
	/* 입력된 이메일 유효성 검사 */
	function validEmail(){
		let email = $("#email").val();
		const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		
		let valid = emailRegex.test(email);
		
		if(email == null || email == ''){
			$(".email-err").text("카카오계정 이메일을 입력해 주세요.");
			$(".join-area input").css("border-bottom","2px solid #e65f3e");
			$(".email-err").show();
			return;
		}
		
		if(valid){ //이메일 유효성 OK
			$(".email-err").hide();
			$(".join-area input").css("border-bottom","2px solid #a09a9a");
			isValidOk = true;
		}else{
			$(".join-area input").css("border-bottom","2px solid #e65f3e");
			$(".email-err").text("이메일 형식이 올바르지 않습니다.");
			$(".email-err").show();
			isValidOk = false;
		}
		
		return; 
	}
	
	function doNext(){
		
	}
</script>
</head>
<body>
<form name="joinForm" action="/doJoin">
    <div class="wrap">
    	<div class="title">
    		<span>KAKAO</span>
   		</div>
   		<div class="word-wrap">
   			<div>카카오계정으로 사용할</div>
   			<div>이메일 주소를 입력해 주세요.</div>
   		</div>
    	<div class="content">
	    	<div class="join-area">
	    		<input type="email" id="email" class="email-input" placeholder="이메일 주소 입력"/>
	    		<button type="button" class="auth-btn" id="auth-btn">인증요청</button>
	    	</div>
	    	<div class="join-confirm-area">
	    		<input type="text" id="auth-code" class="auth-code-input" placeholder="인증번호 입력"/>
	    	</div>
	    	<div class="explain-area">
				<div class="email-err"></div>
				<ul>
					<li>입력한 이메일 주소로 인증번호가 발송됩니다.</li>
					<li>인증메일을 받을 수 있도록 자주 쓰는 이메일 주소를 입력해 주세요.</li>
					<li>사용 중인 Daum 이메일이 있다면, Daum 아이디로 가입해 주세요.</li>
				</ul>
	    	</div>
    	</div>
   		<div class="next-btn-area">
   			<button type="button" class="next-btn" onclick="doNext();">다음</button>
   		</div>
    </div>
</form>
</body>
</html>