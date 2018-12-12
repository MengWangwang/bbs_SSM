<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>

   <style type="text/css">
     	 *{
			margin: 0;
			padding: 0;
		}
		#box1{
			width: 100%;
			height: 279px;
			margin:50px auto;
		}
		
		#account{
		    width: 400px;
			height: 34px;
			position:absolute;
			top:100px;
			left:500px;
		}
		
		#checkaccount{
			width: 120px;
			height: 16px;
			position:absolute;
			top:140px;
			left:650px;
			color: red;
			font-size: small;
		}
		#checkname{
			width: 120px;
			height: 16px;
			position:absolute;
			top:200px;
			left:650px;
			color: red;
			font-size: small;
		}
		#checkeamil{
			width: 120px;
			height: 16px;
			position:absolute;
			top:260px;
			left:650px;
			color: red;
			font-size: small;
		}
		#checkpsw{
			width: 120px;
			height: 16px;
			position:absolute;
			top:320px;
			left:650px;
			color: red;
			font-size: small;
		}
		#checkrepsw{
			width: 120px;
			height: 16px;
			position:absolute;
			top:380px;
			left:650px;
			color: red;
			font-size: small;
		}
		
		#name{
		    width: 400px;
			height: 34px;
			position:absolute;
			top:160px;
			left:500px;
		}
		#eamil{
		    width: 400px;
			height: 34px;
			position:absolute;
			top:220px;
			left:500px;
		}
		#psw{
		    width: 400px;
			height: 34px;
			position:absolute;
			top:280px;
			left:500px;
		}
		#repsw{
		    width: 400px;
			height: 34px;
			position:absolute;
			top:340px;
			left:500px;
		}
		
		#sub{
		    width: 400px;
			height: 34px;
			position:absolute;
			top:400px;
			left:500px;
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
   function checkaccount(obj){    
       if(obj.trim().length==0){  
    	   $("#checkaccount").text("账号不能为空");
    	   obj.focus();  
       }
   }  
   
   function checkname(obj){  
       if(obj.trim().length==0){  
    	   $("#checkname").text("用户名不能为空");    
           obj.focus();  
       }
   }  
   function checkeamil(obj){  
       if(obj.trim().length==0){  
    	   $("#checkeamil").text("邮箱不能为空");    
           obj.focus();  
       }
   }  
   function checkpsw(obj){  
       if(obj.trim().length==0){  
    	   $("#checkpsw").text("密码不能为空");    
           obj.focus();  
       } 
   }  
   function checkrepsw(obj){  
       if(obj.trim().length==0){  
    	   $("#checkrepsw").text("确认密码不能为空");    
           obj.focus();  
       }
   }  
   $(function(){
	   $("#account1").blur(function(){
		 var account=$(this).val();
		 $.ajax(
			{
				url:"checkacc",
				type:"get",
				data:{"account":account},
				dataType:"json",
				success:function(data){
					if(data==false){
					$("#checkaccount").text("该用户名已存在！");
					$("#checkaccount").focus();
					}
				}
			}
			);
	   });
   });
 
   
   </script>
</head>
<body>
<div id="box1" align="center">
			<div><h1>欢迎注册</h1></div>
			<br />
			<form action="zhu.do" method="post">
				<div id="account">
					<font>请输入您的账号:</font><input id="account1" type="text" name="account" onblur="checkaccount(this.value);"/>
				</div>
				<span id="checkaccount"></span>
				<div id="name">
					<font>请输入您的昵称:</font><input type="text" name="name" onblur="checkname(this.value);"/>
				</div>
				<span id="checkname"></span>
				<div id="eamil">
					<font>请输入您的邮箱:</font><input type="text" name="eamil" onblur="checkeamil(this.value);"/>
				</div>
				<span id="checkeamil"></span>
				<div id="psw">
					<font>请输入您的密码:</font><input type="password" name="psw" onblur="checkpsw(this.value);"/>
				</div>
				<span id="checkpsw"></span>
				<div id="repsw">
					<font>请确认您的密码:</font><input type="password" name="repsw" onblur="checkrepsw(this.value);"/>
				</div>
				<span id="checkrepsw"></span>
				<div id="sub"><input type="submit" name="submit" value="注册"/></div>
			</form>
		</div>
</body>
</html>