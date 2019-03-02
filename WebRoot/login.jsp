<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录</title>
<link href="css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>

<script>
//切换验证码
function change(){
	var img1=document.getElementById("checkImg");
	img1.src="${pageContext.request.contextPath}/checkImg.action?"+new Date().getTime(); 
}

</script>


</head>

<body>
<div class="banner">

<div class="login-aside">
  <div id="o-box-up"></div>
  <div id="o-box-down"  style="table-layout:fixed;">
   <div class="error-box"></div>
   <h3><s:actionerror/></h3>
  <form class="registerform" action="user_login" method="post" namespace="/">
   <label for="logonId" class="form-label">用户登录</label>
   <div class="fm-item">
	   <input type="text" placeholder="用户名" name="name" value="" maxlength="100" id="username" class="i-text" ajaxurl="demo/valid.jsp"  datatype="s6-18" nullmsg="请输入用户名！"/>       
       <div class="ui-form-explain"></div>
  </div>
  
  <div class="fm-item">
	     <input type="password" placeholder="请输入密码" name="password" value="" maxlength="100" id="password" class="i-text" datatype="*6-16" nullmsg="请输入密码！" /> 
  </div>
  
  <div class="fm-item pos-r">
	    <div class="ui-form-explain">
			 <input type="text" placeholder="请输入验证码" maxlength="100" name="checkcode" id="yzm" class="i-text yzm" nullmsg="请输入验证码！" >    
			 <img id="checkImg" class="captchaImage" 
			 src="${pageContext.request.contextPath}/checkImg.action" onclick="change()" title="点击更换验证码"/>
      </div>
  </div>
  
 <div class="buttons">
	   <input name="" type="submit" class="loginbtn" value="登录" />&nbsp;
	   <input name="" type="reset" class="loginbtn" value="重置" />
  </div>
  
  </form>
  
  </div>

</div>
<div class="bd">
		<ul>
			<li style="background:url(images/background.jpg) #CCE1F3 center 0 no-repeat;"></li>
		</ul>
	</div>

	<div class="hd"><ul></ul></div>
</div>
<script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });</script>

<div class="footer">
   <p>版权所有</p>
</div>
</body>
</html>

