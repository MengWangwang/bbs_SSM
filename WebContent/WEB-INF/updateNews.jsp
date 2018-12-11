<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
			#box{
				margin-top:50px;
				width: 100%;
				height: 500px;
			}
			#input1{
				width: 200px;
				height: 30px;
			}
			
			button{
				width: 200px;
				height: 30px;
			}
		</style>
</head>
<body>

	<div id="box" align="center">
		<form action="updateNews.do" method="post">
			<div><p>请输入新的标题：<input id="input1" type="text" name="title" value="${requestScope.News.title}"/></p></div>
			<br/>
			<div><p>请输入新的内容：<textarea rows="10" cols="30" name="content" style="vertical-align:top">${requestScope.News.content}</textarea></p></div>
			<input type="hidden" name="newsid" value="${requestScope.News.id}"/>
			<br/>
			<button type="submit">提交</button>
		</form>
	</div>

</body>
</html>