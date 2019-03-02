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
<link href="${pageContext.request.contextPath}/css/work.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/date/laydate.js"></script>
<script type="text/javascript"src="${pageContext.request.contextPath}/js/jquery.js"></script>
</head>
<body>
<div class="formbody" >
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">接收错误</a></li>
    </ul>
  </div>
  <div class="formbody" >
    <s:form action="specimen_jsfalse.action" method="post" namespace="/" theme="simple">
    <p align="center">接收错误信息录入</p>
    <div align="center"><textarea rows="25" cols="70" name="jsfalse"></textarea></div>
    	<s:hidden name="id" value="%{model.id}" />
     	<s:hidden list="list" name="patient.pid" listKey="pid" listValue="pid"  value="%{model.patient.pid}"/>
     	<s:hidden name="name" value="%{model.name}" />
     	<s:hidden name="type" value="%{model.type}" />
     	<s:hidden name="otime" value="%{model.otime}" />
     	<s:hidden name="ctime" value="%{model.ctime}" />
     	<s:hidden name="ltime" value="%{model.ltime}" />
     	<s:hidden name="time" value="%{model.time}" />  
     	<s:hidden name="sstate" value="%{model.sstate}" />
     	<s:hidden name="stime" value="%{model.stime}" />
     	<s:hidden name="sperson" value="%{model.sperson}" />  
		<s:hidden name="jsstate" value="2" />
     	<s:hidden name="jstime" value="%{model.jstime}" />
		<s:hidden name="jsperson" value="%{model.jsperson}" />
     	<s:hidden name="hdstate" value="%{model.hdstate}" />
     	<s:hidden name="hdtime" value="%{model.hdtime}" />
     	<s:hidden name="hdfalse" value="%{model.hdfalse}" />
     	<s:hidden name="location" value="%{model.location}" />
    	<div align="center"> <input type="submit" class="btn" value="提交" /></div>
  	</s:form>
    </div>
</body>
</html>
