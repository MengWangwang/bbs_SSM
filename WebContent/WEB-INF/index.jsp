<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/Index.js"></script>
<title>Insert title here</title>
	<style type="text/css">
			#div1{
				width: 100px;
				height: 50px;
				margin-left: 70px;
				margin-top: 30px;
				float: left;
			}
			
			#div2{
				width: 150px;
				height: 50px;
				margin-right: 60px;
				margin-top: 30px;
				float: right;
			}
			
			#div3{
				width: 700px;
				height: 30px;
				position: absolute;
				top: 150px;
				left: 380px;
				align="center"
			}
			
			#page_jump{
				width: 350px;
				height: 30px;
				position: absolute;
				left:160px;
				top:300px;
			
			}
			
			table{
				width: 700px;
				
				position: absolute;
				top: 80px;
				
			}
			#div3-1{
				width: 350px;
				height: 30px;
				position: absolute;
				left:200px;
			}
			
			
		</style>
</head>
<body>
<div id="box">
		 <c:if test="${User==null}">
			<div id="div1">
				<span>您好，游客</span>
				<br />
				<a href="zhu.do">注册</a>
				<a href="login.do">登陆</a>
				
			</div>
			</c:if>
			<c:if test="${User!=null}">
			
			<div id="div2">
				<span>欢迎您,${User.name}</span>
				<br />
				<a href="logout.do">注销</a>
				<a href="lookAccount.do">我的账户</a>
			</div>
			
			</c:if>

			<div id="div3">
			<form id="form" action="index.do" method="post">
				<div id="div3-1">请输入标题:<input type="text" name="title"/>
				<input type="submit" value="搜索"></div>
			
				<br />
				<br />
			<table border="1" cellpadding="5" cellspacing=0>
				<tr>
					<th>序号</th>
					<th>标题</th>
					<th>内容</th>
					<th>时间</th>
					<th>楼主</th>	
				</tr>
				<c:forEach var="item" items="${LstNews}" varStatus="s">
				<tr>
					<td>${s.index+1}</td>
					<td><a href="view.do?newsid=${item.id}">${item.title}</a></td>
					<td>${item.content}</td>
					<td><fmt:formatDate value="${item.time}" pattern="yyyy/MM/dd HH:mm"/> </td>
					<td>${item.userName}</td>			
				</tr>	
				</c:forEach>				
			</table>
			<input type="hidden" value="${PageIndex}" id="pageIndex" name="pageIndex">
			<input type="hidden" value="${PageCount}" id="pageCount" name="pageCount">
			<div id="page_jump" align="center">
				<a href="#" id="frist" class="chooseIt">首页</a>
				<a href="#" id="previous" class="chooseIt">上一页</a>
				<a href="#" id="next" class="chooseIt">下一页</a>
				<a href="#" id="last" class="chooseIt">尾页</a>
				<br />
				<span>第${PageIndex}页</span>/<span>共${PageCount}页</span>	
			</div>
			</form>
			</div>
		</div>
</body>
</html>