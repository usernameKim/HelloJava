<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<h3>게시글 등록</h3>
	<form action="./writeBoard.do" method="post" enctype="multipart/form-data">
		제목: <input type="text" name="title"><br>
		내용: <textarea name ="content" rows="10" cols="30"> 
		</textarea><br>
		작성자: <input type="text" name="writer"><br>
		이미지: <input type="file" name="image"><br>
		<input type="submit" value="글등록"><br>
		<input type="reset" value="초기화"><br>
		
	</form>
</body>
</html>