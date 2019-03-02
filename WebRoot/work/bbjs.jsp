<%@ page language="java" import="java.util.*,java.text.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<%
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
String date= format.format(new Date());
%>
<div class="formbody" >
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">标本接收</a></li>
    </ul>
  </div>
  <div class="formbody">
    <s:form action="specimen_jssuccess.action" method="post" namespace="/" theme="simple">
    <ul class="forminfo" >
    <li><p align="center">标本接收确认单</p></li>
    <li> <label>标本编号</label>
    <s:textfield name="id" value="%{model.id}" class="dfinput" style="width:360px; height:25px" readonly="true"></s:textfield></li>
    <li> <label>标本创建时间</label>
    <input name="time" class="dfinput" readonly="true" value="<s:date name="model.time" format="yyyy-MM-dd" />" style="width:360px; height:25px"/>
    <li> <label>标本名称</label>
    <s:textfield name="name" value="%{model.name}" readonly="true" class="dfinput" style="width:360px; height:25px"></s:textfield>
    <li> <label>标本类型</label>
    <s:textfield name="type" value="%{model.type}" readonly="true" class="dfinput" style="width:360px; height:25px"></s:textfield>
	 <li> <label>接收时间</label>
    <input name="jstime" type="text" readonly="true" class="dfinput" style="width:360px; height:25px" value="<%=date%>" />
	 <li> <label>接收人</label>
    <input name="jsperson" type="text" value="<%=session.getAttribute("userName") %>" readonly="true" style="width:360px; height:25px"/>
	 <li> <label>标本位置</label>
    <input name="location" type="text" value="" placeholder="确认接收前请输入标本放置的位置" style="width:360px; height:25px"/>
     	<s:hidden list="list" name="patient.pid" listKey="pid" listValue="pid"  value="%{model.patient.pid}"/>
     	<s:hidden name="otime" value="%{model.otime}" />
     	<s:hidden name="ctime" value="%{model.ctime}" />
     	<s:hidden name="ltime" value="%{model.ltime}" />
     	<s:hidden name="sstate" value="%{model.sstate}" />
     	<s:hidden name="stime" value="%{model.stime}" />
     	<s:hidden name="sperson" value="%{model.sperson}" />  
		<s:hidden name="jsstate" value="1" />
		<s:hidden name="jsfalse" value="" />
     	<s:hidden name="hdstate" value="%{model.hdstate}" />
     	<s:hidden name="hdtime" value="%{model.hdtime}" />
     	<s:hidden name="hdfalse" value="%{model.hdfalse}" />
     	<s:hidden name="location" value="%{model.location}" />
    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认接收" /><label>&nbsp;</label></li>
    
    </s:form>
    <s:form action="specimen_jsfalseUI.action" method="post" namespace="/" theme="simple">
		 <s:hidden name="id" value="%{model.id}" />
   		 <td><label>&nbsp;</label><input type="submit" class="btn" value="接收失败" /><label>&nbsp;</label></td>  
   	  </s:form> 
   	  </ul>
    </div>
   <script type="text/javascript" src="${pageContext.request.contextPath}//js/date/datebdys.js"></script>
</body>
</html>
