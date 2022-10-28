<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인 화면</h3>
	<form action="./signIn.do" method="post">
		ID: <input type="text" name="id"><br>
		PW: <input type="password" name ="passwd"><br>
		<input type="submit" value="로그인">
	</form>
	
	<a href="passwdReConfirmForm.do">비밀번호 재전송</a>
	<!-- passwdReConfirm.jsp : 아이디를 입력하고 재전송 : 메일주소로 변경된 비번 전송.
		 passwdReConfirm.do : 아이디를 받아서 이메일정보로 메일을 발송.
		 -->
</body>
</html>