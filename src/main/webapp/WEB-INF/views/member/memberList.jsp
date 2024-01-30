<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery CDN을 사용하여 jQuery 라이브러리 불러오기 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style type="text/css">
	.chk{
		margin-right:30px;
		display:inline-block;
	}
	table{
		text-align:center;
	}
	.d-in-bl{
		float : right;
	}
	.main{
		width:750px;
	}
</style>
<script type="text/javascript">
	$().ready(function(){
	});
	
	function save(){
		alert('test');
		document.memberForm.submit();
	}
	
	function autoAssign(obj){
		if(obj.checked){
// 			console.log(obj);
		}else{
			var objs = $("table tr input[type=checkbox]");
			$(objs).each(function(idx, obj){
				console.log(obj.checked);
			});
		}
	}
	
</script>
</head>
<body>
<form action="/member/insertMembersTm" method="get" name="memberForm">
	<div class="main">
		<div>
			<h2>예상 시간</h2>
		</div>
		<div>
			<div class="chk">
				<input type="checkbox" onclick="autoAssign(this);"/>자동 분배
			</div>
			총 사용가능 시간 <input type="text" value="${totAvlTm }" />
			예상 작업 시간 <input type="txet" value="${estTm }" />
		</div>
		<br>
		<br>
		<div>
			<table>
				<colgroup>
					<col style="width:25%">
					<col style="width:25%">
					<col style="width:50%">
				</colgroup>
				<thead>
					<tr>
						<th>ID</th>
						<th>이름</th>
						<th>사용 가능시간</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${memberList }" var="m" varStatus="i">
						<tr id="${i.index }">
							<td>${m.usrId}</td>
							<td>${m.usrNm}</td>
							<td>
								<input type="checkbox" name="chkYn" />
								<input type="text" name="assTm" value="${m.assTm }" />
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		<div class="d-in-bl">
			<input type="button" id="save-btn" value="저장" onclick="save();"/>
		</div>
		</div>
	</div>
</form>
</body>
</html>