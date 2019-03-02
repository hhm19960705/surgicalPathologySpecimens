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
</head>
<body>
 <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li> <a href="#" >患者信息添加</a></li>
    </ul>
    </div>
  <div class="formbody" >
   <s:form action="patient_add.action" method="post" namespace="/" theme="simple">
    <ul class="forminfo" >
    <li><p align="center">患者登记</p></li>
    <li> <label>患者住院号</label><input name="pid" type="text" class="dfinput" value="" /></li>
    <li> <label>入院时间</label>
    <input class="laydate-icon" id="demo" name="date" value="" style="width:345px; height:32px"/></li>
    <li> <label>患者姓名</label><input name="pname" type="text" class="dfinput" value="" /></li> 
    <li> <label>患者性别</label><cite>
  	<input type="radio" name="sex" checked='checked' value="0" >男&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="1">女</cite></li>
    <li> <label>患者年龄</label><input name="age" type="text" class="dfinput" value="" /></li>
    <li> <label>备注</label><input name="remark" type="text" class="dfinput" value="" /></li>
    <li><label>&nbsp;</label><input type="submit" class="btn" value="添加" /></li>
    </ul>
    </s:form>
    </div>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/date/datebdys.js"></script>
</body>
</html>
