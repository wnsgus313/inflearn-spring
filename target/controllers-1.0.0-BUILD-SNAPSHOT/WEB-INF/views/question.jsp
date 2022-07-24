<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question</title>
<link rel="stylesheet" href="index.css" type="text/css">

</head>
<body>
<%@ page import="com.inflearn.dao.QuestionDao, com.inflearn.beans.Question" %>


<a href="community.jsp">질문 목록</a><br/>  

<p class="question">제목 <span class="question">${q.getTitle()}</span></p>
<p class="question">내용 <span class="question">${q.getContent()}</span></p>

<button onclick="location.href='/editQuestion/${q.getId()}'">편집</button>
<button onclick="location.href='/deleteQuestion/${q.getId()}'">삭제</button>

</body>
</html>