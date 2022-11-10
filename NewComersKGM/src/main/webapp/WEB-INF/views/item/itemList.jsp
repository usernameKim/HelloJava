<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>상품 목록보기</h1></div>
	<div>
		<c:forEach items="${items }" var="item"> 
			${item.itemCode } : ${item.itemTitle } : ${item.itemPrice }<br/>
		</c:forEach>
		</div>
	</div>
</body>
</html>