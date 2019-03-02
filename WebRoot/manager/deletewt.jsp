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
    <li> <a href="#" >处理用户反馈</a></li>
    </ul>
    </div>
 <div class="formbody" >
    <s:form action="user_wtcl.action" method="post" namespace="/" theme="simple">
    <ul class="forminfo" >
    <li><p align="center">反馈者信息</p></li>
    <li> <label>用户编号</label><s:textfield name="id" value="%{model.id}" class="dfinput" readonly="true" style="width:360px; height:32px"></s:textfield></li>
    <li> <label>用户名</label><s:textfield name="name" value="%{model.name}" class="dfinput" readonly="true" style="width:360px; height:32px"></s:textfield></li>
    <li> <label>用户身份</label> 
   	<s:select list="roleList" name="status" listKey="value" listValue="name"  disabled="true" style="width:360px; height:32px" value="%{model.status}" headerKey="" headerValue="---请选择---"
     ></s:select></li>
   	 <s:hidden name="status" value="%{model.status}" />
     <s:hidden name="password" value="%{model.password}" />
     <s:hidden name="wtfk" value="" />
    <li><label>&nbsp;</label><input type="submit" class="btn" value="处理" /></li>
    </ul>
    </s:form>
    </div>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/date/datebdys.js"></script>
</body>
</html>
