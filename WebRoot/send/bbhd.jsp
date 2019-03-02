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
    <li><a href="#">标本核对</a></li>
    </ul>
  </div>
  <div class="formbody">
    <s:form action="specimen_hdsuccess.action" method="post" namespace="/" theme="simple">
    <ul class="forminfo" >
    <li><p align="center">标本核对确认单</p></li>
    <li> <label>标本编号</label>
    <s:textfield name="id" value="%{model.id}" class="dfinput" style="width:360px; height:25px" readonly="true"></s:textfield></li>
    <li> <label>标本名称</label>
    <s:textfield name="name" value="%{model.name}" readonly="true" class="dfinput" style="width:360px; height:25px"></s:textfield>
    <li> <label>标本类型</label>
    <s:textfield name="type" value="%{model.type}" readonly="true" class="dfinput" style="width:360px; height:25px"></s:textfield>
    <li> <label>手术时间</label>
    <input name="otime" type="text" class="dfinput" readonly="true" style="width:360px; height:25px" value="<s:date name="model.otime" format="yyyy-MM-dd" />" /></li>
    <li> <label>切取时间</label><input name="ctime" type="text" readonly="true" class="dfinput" style="width:360px; height:25px" value="<s:date name="model.ctime" format="yyyy-MM-dd" />" /></li>
    <li> <label>离体时间</label><input name="ltime" type="text" readonly="true" class="dfinput" style="width:360px; height:25px" value="<s:date name="model.ltime" format="yyyy-MM-dd" />" /></li>
    <li> <label>核对时间</label><input name="hdtime" type="text" readonly="true" class="dfinput" style="width:360px; height:25px" value="<%=date%>" /></li>
     	<s:hidden list="list" name="patient.pid" listKey="pid" listValue="pid"  value="%{model.patient.pid}"/>
     	<s:hidden name="time" value="%{model.time}" />
     	<s:hidden name="sstate" value="0" />
     	<s:hidden name="stime" value="" />
     	<s:hidden name="sperson" value="" />  
		<s:hidden name="jsstate" value="0" />
     	<s:hidden name="jstime" value="" />
		<s:hidden name="jsperson" value="" />
     	<s:hidden name="jsfalse" value="" />
     	<s:hidden name="hdstate" value="1" />
     	<s:hidden name="hdfalse" value="" />
     	<s:hidden name="location" value="" />
    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认成功" /><label>&nbsp;</label></li>
    
    </s:form>
    <s:form action="specimen_hdfalseUI.action" method="post" namespace="/" theme="simple">
		 <s:hidden name="id" value="%{model.id}" />
   		 <td><label>&nbsp;</label><input type="submit" class="btn" value="确认失败" /><label>&nbsp;</label></td>  
   	  </s:form> 
   	  </ul>
    </div>
   <script type="text/javascript" src="${pageContext.request.contextPath}//js/date/datebdys.js"></script>
</body>
</html>
