$(function(){

	$(".chooseIt").click(function(){
		var id=$(this).attr("id");
		var pageIndex=$("#pageIndex").val();
		var pageCount=$("#pageCount").val();
		pageIndex=parseFloat(pageIndex);
		pageCount=parseFloat(pageCount);
		
		if(id == "frist"){
			pageIndex=1;
		}else if(id == "previous"){
			
			if(pageIndex==1){
				return false;
			}else{
				pageIndex=pageIndex-1;
			}
			
		}else if(id == "next"){
			
			if(pageIndex==pageCount){
				return false;
			}else{
				pageIndex=pageIndex+1;
			}
			
		}else{
			pageIndex=pageCount;
		}
		
		$("#pageIndex").val(pageIndex);
		$("#form").submit();
		return false;
	});
});