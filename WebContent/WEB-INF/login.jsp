<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆页面</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"> </script>
<style type="text/css">
     	 *{
			margin: 0;
			padding: 0;
		}
		#box1{
			width: 100%;
			height: 279px;
			position:absolute;
			margin:50px auto;
		}
		#account{
		    width: 400px;
			height: 34px;
			position:absolute;
			top:60px;
			left:500px;
		}
		
		#psw{
		    width: 400px;
			height: 34px;
			position:absolute;
			top:120px;
			left:500px;
		}
		
		#checkaccount{
			width: 120px;
			height: 16px;
			position:absolute;
			top:100px;
			left:650px;
			color: red;
			font-size: small;
		}
		
		#checkpsw{
			width: 120px;
			height: 16px;
			position:absolute;
			top:160px;
			left:650px;
			color: red;
			font-size: small;
		}
		
		#sub{
			width: 200px;
			height: 34px;
			position:absolute;
			top:180px;
			left:600px;
		}
		
		#link{
			width: 108px;
			height: 21px;
			position:absolute;
			top:230px;
			left:640px;
		}
		
		h1{
			width: 200px;
			height: 42px;
			position:absolute;
			
			left:600px;

		}
		input{
			width: 200px;
			height: 30px;
		}
   </style>
    <script type="text/javascript">  
        function checkUserName(obj){  
        	var cook= document.cookie;
        	var cookArr=cook.split(", ");
        	for(var i=0;i<cookArr.length;i++){
        		var arr=cookArr[i].split("=");
        		if(arr[0] == obj){
        			document.getElementById("psw1").value = arr[1];
        		}
        	}
            if(obj.trim().length==0){  
            	 $("#checkaccount").text("用户名不能为空");    
                  obj.focus();  
            }
        }  
        function checkPassword(obj){    
            if(obj.trim().length==0){  
            	$("#checkpsw").text("密码不能为空");
                obj.focus();  
            }
        }  
  
    </script>  

</head>
<body >
<div id="box1" align="center">
		<div><h1>欢迎登陆</h1></div>
		<br />
		<form action="login.do" method="post">
			<div id="account">
				请输入您的账号:<input name="account" type="text" onblur="checkUserName(this.value);"/>
			</div>
			<span id="checkaccount"></span>
			<div id="psw">
				请输入您的密码:<input name="psw" id="psw1" type="password" onblur="checkPassword(this.value);"/>
				<br >
				<input type="checkbox" value="1" name="auto" />记住密码
			</div>	
			<input type="hidden" name="newsid" value="${newsid}"/>
			<span id="checkpsw"></span>
			<div id="sub">
				<input type="submit" value="登陆"/>
			</div>
			
			<div id="link">
				<a href="zhu.do" style="text-decoration: none;color:gray"><font size="1">没有账号？免费注册</font></a>
			</div>
		</form>	
	</div>	

</body>
</html>