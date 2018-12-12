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
<script type="text/javascript">
		$(function(){
			$("#see").click(function(){
				
				if($("#see").text()=="查看评论"){
					
					var newid= $("#newid").val();
					$.ajaxSetup({cache:false});//取消ajax缓存
					$.get("seecomments.do",{"newid":newid},function(data){
						var arr=eval("("+data+")");
						var html="";
						$.each(arr,function(index,item){
							html+="<P>"+item.userName+"【"+item.time+"】"+item.content+"</p>";
						});
						$("#comment").append(html);
						
						
						$("#see").text("关闭评论");
					});	
				}else if($("#see").text()=="关闭评论"){
					
					$("#comment p").remove();	
					$("#see").text("查看评论");
				}
				
				return false;
			});
		});
		</script>
<title>Insert title here</title>
<style type="text/css">
			#box{
				margin-left:100px;
				width: 100%;
			}

			button{
				width: 200px;
				height: 30px;
			}
		</style>
</head>
<body>
	
	<div id="box">
		<p id="title">标题：${requestScope.News.title}</p>
		<div id="lable">
			<p>发帖人:${requestScope.News.userName}</p>
			<p>发帖时间：<fmt:formatDate value="${requestScope.News.time}" pattern="yyyy/MM/dd HH:mm"/></p>
		</div>
		<div id="content"></div>
		<p>贴子内容：${requestScope.News.content}</P>
		
		
		<div><a id="see">查看评论</a></div>
		<div id="comment">
		
		</div>
		
		 <%-- <c:forEach var="ele"  items="${requestScope.Comments}">
 			<p>${ele.userName}【<fmt:formatDate value="${ele.time}" pattern="yyyy/MM/dd HH:mm"/>】:${ele.content}</p>
		 </c:forEach> --%>
			
		
		<form action="view.do" method="post">
		<p id="myComment">我的评论：<textarea rows="10" cols="30" id="input" name="content"></textarea></p>
		<input type="hidden" name="newsid" value="${requestScope.News.id}" id="newid">
		<p id="myCommentSubmit"><input type="submit" value="发送"></p>
		</form>
	</div>
</body>
</html>