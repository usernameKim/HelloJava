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
		<c:forEach items="${items }" var="i">
			<tr>
				<td class="image"></td>
				<td class="detail">
					<div class="category">
					[${i.itemCode }]
					</div>
					<div class="itemName">
					[${i.itemName }]
					</div>
					<div class="itemPrice">
					[${i.itemPrice }]
					</div>
					</td>
			</tr>
		</c:forEach>
	</div>
</body>
</html>