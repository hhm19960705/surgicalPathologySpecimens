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
<link href="${pageContext.request.contextPath}/css/nurse.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/date/laydate.js"></script>
<script type="text/javascript"src="${pageContext.request.contextPath}/js/jquery.js"></script>

</head>
<body>
 <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li> <a href="#" >用户信息添加</a></li>
    </ul>
    </div>
  <div class="formbody" >
    <s:form action="user_add.action" method="post" namespace="/" theme="simple">
    <ul class="forminfo" >
    <li><p align="center">新增用户</p></li>
    <li> <label>用户ID</label><input name="id" type="text" class="dfinput" value="" /></li>
    <li> <label>用户名</label><input name="name" type="text" class="dfinput" value="" /></li> 
    <li> <label>密码</label><input name="password" type="text" class="dfinput" value="" /></li>
    <li> <label>用户身份</label> 
    <s:select list="roleList" name="status" listKey="value" listValue="name"  style="width:360px; height:32px" value="" headerKey="" headerValue="---请选择---"
     ></s:select></li>   
    <s:hidden name="wtfk" value="" />
    <li><label>&nbsp;</label><input type="submit" class="btn" value="添加" /></li>    	
    </ul>
    </s:form>
    </div>
</body>
</html>
