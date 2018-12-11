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

		<form action="changerPsw.do" method="post">
	     <div>请输入新密码<input type="text" name="newPsw"/></div>
	     <br />
	     <div><button type="submit">(修改密码并重新登陆)确认</button></div>
	    </form>
	</div>
</body>
</html>