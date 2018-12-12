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
				margin-left:100px;
				width: 100%;
				height: 500px;
			}

			button{
				width: 200px;
				height: 30px;
			}
		</style>
</head>
<body>
		<div id="box">
			<div>
			<p>账号：${User.account}</p>
			<p>用户名：${User.name}</p>
			<p>邮箱：${User.eamil}</p>
			<p>密码：${User.psw}<a href="changerPsw.do">修改密码</a></p>
			<p>我的帖子：<a href="addNew.do">发表帖</a></p>
			</div>
			<table border="1" cellpadding="5" cellspacing=0>
				<tr>
					<th>序号</th>
					<th>标题</th>
					<th>内容</th>
					<th>时间</th>
					<th>楼主</th>			
				</tr>
				<c:forEach var="item" items="${requestScope.LstNews}" varStatus="s">
				<tr>
				<tr>
					<td>${s.index+1}</td>
					<td><a href="view?newsid=${item.id}">${item.title}</a></td>
					<td>${item.content}</td>
					<td><fmt:formatDate value="${item.time}" pattern="yyyy/MM/dd HH:mm"/></td>
					<td>
						<a href="deleteNews.do?newsid=${item.id}">删除</a>
						<a href="updateNews.do?newsid=${item.id}">编辑</a>
					</td>						
				</tr>	
			</c:forEach>	
			</table>
			
	</div>
</body>
</html>