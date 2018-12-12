var num1=0;
  var num2=0;
  num1=Math.floor(Math.random()*8999)+1000;
  document.getElementById("font1").innerHTML=num1;
  function getNum(){
	  num1=Math.floor(Math.random()*8999)+1000;
	  document.getElementById("font1").innerHTML=num1; 
	  document.getElementById("font2").innerHTML="";
  }
  function check() {
	 num2=document.getElementById("txtSN").value;
		if(num1!=num2){
			document.getElementById("font2").innerHTML="验证码错误";
		}else{
			document.getElementById("form").submit();
		}
  }
  
  function checkPassword(obj){    
      if(obj.trim().length==0){  
      	$("#checkpsw").text("密码不能为空");
          obj.focus();  
      }
  }  
  
  
  function checkUserName(obj){ 
	  
	  if(obj.trim().length==0){  
     	 $("#checkaccount").text("用户名不能为空");    
           obj.focus();  
     }  
  	var cook= document.cookie;
  	var cookArr=cook.split(", ");
  	for(var i=0;i<cookArr.length;i++){
  		var arr=cookArr[i].split("=");
  		if(arr[0] == obj){
  			$("#txtUserPassword").val(arr[1]);
  		}
  	}
  }
  
  function checkYanzheng(obj){    
      if(obj.trim().length==0){  
      	$("#font2").text("密码不能为空");
          obj.focus();  
      }
  }  
  
  $(function(){
	   $("#txtUserName").blur(function(){
		 var id=$(this).val();
		 $.ajax(
			{
				url:"checkacc",
				type:"get",
				data:{"id":id},
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