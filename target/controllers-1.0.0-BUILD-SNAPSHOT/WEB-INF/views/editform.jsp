<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageConext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<link rel="stylesheet" href="${path}/resources/css/index.css">

</head>
<body>
<%@page import="com.inflearn.dao.QuestionDao, com.inflearn.beans.Question"%>  


<a href="community">질문 목록</a><br/>  
  
<h1>질문 수정</h1>  
<form action="/editQuestion" method="post">
<div class="question">
	<input type="hidden" value="${q.getId()}" name="id" >
	<input type="text" value="${q.getTitle()}" name="title" class='question-title'>
	<textarea name="content" placeholder="내용을 입력하세요" class='question-content' >${q.getContent()}</textarea>
	<input type="submit" value="등록" class="question-submit"/>
</div>
</form>  
</body>
</html>