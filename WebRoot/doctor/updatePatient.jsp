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
    <li> <a href="#" >患者信息修改</a></li>
    </ul>
    </div>
  <div class="formbody" >
   <s:form action="patient_edit.action" method="post" namespace="/" theme="simple">
    <ul class="forminfo" >
    <li><p align="center">患者信息修改</p></li>
    <li> <label>患者住院号</label><s:textfield name="pid" value="%{model.pid}" class="dfinput" style="width:360px; height:32px" readonly="true"></s:textfield></li>
    <li> <label>入院时间</label>
    <input type="text" name="date" class="laydate-icon" style="width:345px; height:32px" value="<s:date name="model.date" format="yyyy-MM-dd" />"/></li>
    <li> <label>患者姓名</label><s:textfield name="pname" value="%{model.pname}" class="dfinput" style="width:360px; height:32px"></s:textfield></li> 
    <li> <label>患者性别</label>
    <cite>
    <input type="radio" name="sex" 
    	<s:if test="%{model.sex}==0">checked='checked'</s:if>
    	<s:else>checked=''</s:else> value="0" >男&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="radio" name="sex" 
    	<s:if test="%{model.sex}==1">checked='checked'</s:if>
    	<s:else>checked=''</s:else> value="1" >女</cite>
    <li> <label>患者年龄</label><s:textfield name="age" value="%{model.age}" class="dfinput" style="width:360px; height:32px"></s:textfield></li>
    <li> <label>备注</label><s:textfield name="remark" value="%{model.remark}" class="dfinput" style="width:360px; height:32px"></s:textfield></li>
    <li><label>&nbsp;</label><input type="submit" class="btn" value="修改" /></li>
    </ul>
    </s:form>
    </div>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/date/datebdys.js"></script>
</body>
</html>
