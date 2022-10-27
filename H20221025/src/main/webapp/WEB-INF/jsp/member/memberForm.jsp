<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>회원등록화면</h3>
<form action="./signUp.do" method="post" >
	아이디: <input type="text" name="id"><br>
	비밀번호: <input type="password" name="passwd"><br>
	이름: <input type="text" name="name"><br>
	이메일: <input type="email" name="email"><br>
	권한: <input type="text" name="responsibility" value="user"><br>
	<input type="submit" value="회원등록"><br>
		<input type="reset" value="취소"><br>
</form> 