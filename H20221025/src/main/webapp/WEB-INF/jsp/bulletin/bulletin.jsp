
<%@page import="co.edu.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- bulletin/bulletin.tiles -->
<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("bList");
%>
<h3>게시판 페이지입니다.</h3>
	<table border='1'>
		<thead><tr><th>글번호</th><th>제목</th><th>작성자</th><th>작성일자</th></tr></thead>
		<tbody>
<%
	for(BoardVO vo : list){
%>	
	<tr><td><a href="searchBoard.do?bno=<%=vo.getBoardNo() %>"><%=vo.getBoardNo() %></a></td>
		<td><%=vo.getTitle() %></td>
		<td><%=vo.getWriter() %></td>
		<td><%=vo.getWriteDate() %></td>
	</tr>
<% 	
	}
%>
	</tbody>
</table>