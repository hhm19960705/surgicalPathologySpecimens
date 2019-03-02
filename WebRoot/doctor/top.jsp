<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<title>手术病理标本信息管理系统</title>

<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<!--[if IE]><script src="Scripts/html5.js"></script><![endif]-->
</head>
<body>
<div class="container">
  <header>
    <div class="header_top">
     <ul class="header_tip">
        <li class="header_tipl"></li>
        <li> <a href="${pageContext.request.contextPath}/user_wtfkUI.action?id=<s:property value="#session['existUser'].id"/>" class="header_tip_a" target="_top">问题反馈 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|</a></li>
        <li> <a href="${pageContext.request.contextPath}/user_updateUI.action?id=<s:property value="#session['existUser'].id"/>" class="header_tip_a" target="_top">修改密码 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|</a></li>
        <li> <a href="${pageContext.request.contextPath}/user_exist.action" class="header_tip_a" target="_top">退出</a></li>
        <li class="header_tipr"></li>
      </ul>
      <div class="clear"></div>
      <a href="#" class="logo"></a>
    	<ul class="nav">
    	   <li class="er"><a target="bottomFrame" href="${pageContext.request.contextPath}/history_findcbAll.action">创建病理申请单</a></li>
           <li><a target="bottomFrame" href="${pageContext.request.contextPath}/specimen_findAll.action">标本信息</a></li>
           <li><a target="bottomFrame" href="${pageContext.request.contextPath}/history_findAll.action">病历信息</a></li>
           <li><a target="bottomFrame" href="${pageContext.request.contextPath}/patient_findAll.action">患者信息</a></li>
	     </ul>
    </div>
  	
   
	  
</body>
</html>
