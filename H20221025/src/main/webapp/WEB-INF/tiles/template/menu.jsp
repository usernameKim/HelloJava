<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <div class="border-end bg-white" id="sidebar-wrapper">
        	<c:choose>
        		<c:when test="${empty id }"> <div class="sidebar-heading border-bottom bg-light"><p>손님</p></div></c:when>
        		<c:otherwise> <div class="sidebar-heading border-bottom bg-light">${id }님 </div></c:otherwise>
        	</c:choose>
         <div class="list-group list-group-flush">
             <a class="list-group-item list-group-item-action list-group-item-light p-3" href="bulletin.do?page=13">게시판</a>
             <a class="list-group-item list-group-item-action list-group-item-light p-3" href="writeBoardForm.do">글등록</a>
             <a class="list-group-item list-group-item-action list-group-item-light p-3" href="signUpForm.do">회원가입</a>
             <a class="list-group-item list-group-item-action list-group-item-light p-3" href="memberList.do">회원목록</a>
             <a class="list-group-item list-group-item-action list-group-item-light p-3" href="signInForm.do">로그인</a>
             <a class="list-group-item list-group-item-action list-group-item-light p-3" href="signOut.do">로그아웃</a>
         </div>
     </div>