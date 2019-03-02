$(document).ready(function(){
	  $(".click").click(function(){
	  	$(".tip").fadeIn(200);
	  	$("#confirmBtn").attr("url", $(this).attr("url")) ;
	  });
	  
	  $(".tiptop a").click(function(){
	  $(".tip").fadeOut(200);
	});
	
	  $(".sure").click(function(){
	  $(".tip").fadeOut(100);
	  window.location.href=$(this).attr("url") ;
	});
	
	  $(".cancel").click(function(){
	  $(".tip").fadeOut(100);
	});
	
	});
function deleteStudent(sid){
		//alert(stuid);
		var bool=confirm("你是否要删除本条信息？");
		//alert(bool);
		if(bool){
			//发送ajax
			$.post("UserServlet",{"sid":sid,"operation":"deletestudent"},function(data){
				//alert(data);
				//判断
				if(data=="success"){
					//刷新数据
					window.location.href="UserServlet?operation=selectall";
				}else{
					alert("删除失败");
				}
			});
		}
	}
	
	//删除操作--批量删除
	function deleteStudents() {
		//声明一个字符
		var varstudentids="";
		//获取所有被选中的复选框
		var varcheckall=document.getElementsByName("checkname");
		//循环判断哪个被选中
		for(var i=0;i<varcheckall.length;i++){
			//判断
			if(varcheckall[i].checked==true){
				//获取当前被选中行的id--studentid
				//alert(varcheckall[i].value);
				varstudentids +=varcheckall[i].value+",";
			}
		}
		//alert(varstudentids);
		//判断
		if(varstudentids==""){
			alert("请选择要删除的选项");
			return;//结束程序
		}else{
			var bool=confirm("你是否要删除这些信息？");
			if(bool){
				//如果有值--发生ajax传输id进行删除操作
				//alert(varstudentids);s
				varstudentids=varstudentids.substring(0, varstudentids.length-1);
				//alert(varstudentids);s
				$.post("UserServlet",{"stuids":varstudentids,"operation":"deletestudents"},function(data){
					//alert(data);
					//判断
					if(data=="success"){
						//刷新数据
						window.location.href="UserServlet?operation=selectall";
					}else{
						alert("删除失败");
					}
					});
			}
		}
	
	}
	
	//执行选择操作
	function stucheck(str) {
		//先要获取所有复选框
		var varcheckall=document.getElementsByName("checkname");
		//判断
		if(str=="all"){
			//循环
			for(var i=0;i<varcheckall.length;i++){
				varcheckall[i].checked=true;//选中
			}
		}else if(str=="notall"){
			//循环
			for(var i=0;i<varcheckall.length;i++){
				varcheckall[i].checked=false;//全否
			}
		}else if(str=="negtive"){
			//循环
			for(var i=0;i<varcheckall.length;i++){
				varcheckall[i].checked=!varcheckall[i].checked;//反选
			}
		}
	}
	