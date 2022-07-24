<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>

<%@page import="com.inflearn.dao.QuestionDao"%>  
<jsp:useBean id="q" class="com.inflearn.beans.Question"></jsp:useBean>  
<jsp:setProperty property="*" name="q"/>  


</body>
</html>