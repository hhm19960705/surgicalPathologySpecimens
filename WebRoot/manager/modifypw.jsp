<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8"/>
<title>手术病理标本信息管理系统</title>
<link href="${pageContext.request.contextPath}/css/work.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/date/laydate.js"></script>
<script type="text/javascript"src="${pageContext.request.contextPath}/js/jquery.js"></script>
</script>

</head>
<body>
 <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li> <a href="#" >修改密码</a></li>
    <li> <a href="${pageContext.request.contextPath}/login.jsp" > 退出 </a></li>
    </ul>
    </div>
 <div class="formbody" >
    <s:form action="user_update.action" method="post" theme="simple">
    <ul class="forminfo" >
    <li><p align="center">修改密码</p></li>
    <s:hidden name="id" value="%{model.id}" />
   	<li> <label>原密码</label><s:password name="opassword" value="" class="dfinput" style="width:360px; height:32px"/></li>
    <li> <label>新密码</label><s:password name="npassword" value="" class="dfinput" style="width:360px; height:32px"/></li>
    <li> <label>确认密码</label><s:password name="confirmPwd" value="" class="dfinput" style="width:360px; height:32px"/></li>
    </li>
    <li><label>&nbsp;</label><input type="submit" class="btn" value="修改" /></li>
    </ul>
    </s:form>
    </div>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/date/datebdys.js"></script>
</body>
</html>
