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
    <li> <a href="#" >标本信息修改</a></li>
    </ul>
    </div>
  <div class="formbody">
  <s:form action="specimen_edit.action" method="post" namespace="/" theme="simple">
    <table align="center">
     <tr><td></td><td><p align="center">标本信息修改</p></td></tr>
     <tr></tr> <tr></tr> <tr></tr> <tr></tr>
     <tr>
       <td><label>标本编号</label>
       <s:textfield name="id" value="%{model.id}" class="dfinput" style="width:255px; height:32px" readonly="true"></s:textfield></td>
      <td><label>患者住院号</label>
      <s:select list="list" name="patient.pid" listKey="pid" listValue="pid"  value="%{model.patient.pid}" headerKey="" headerValue="---请选择---"
     style="border:1px soid red;width:255px; height:32px;" ></s:select>
      </td>
      <td><label>标本名称</label>
      <s:textfield name="name" value="%{model.name}" class="dfinput" style="width:255px; height:32px"></s:textfield></td>
    </tr> 
     <tr></tr>
    <tr>
        <td>
          <label>手术时间</label><input class="laydate-icon" id="demo" name="otime" value="<s:date name="model.otime" format="yyyy-MM-dd" />" style="width:235px; height:32px"/></td>	
        <td>
          <label>切取时间</label><input class="laydate-icon" id="demo1" name="ctime" value="<s:date name="model.ctime" format="yyyy-MM-dd" />" style="width:235px; height:32px"/>
        </td>
         <td><label>离体时间</label>
    <input class="laydate-icon" id="demo4" name="ltime" value="<s:date name="model.ltime" format="yyyy-MM-dd" />" style="width:235px; height:32px"/></td>    
     </tr>
      <tr></tr>
   
     <tr>
   		 <td><label>标本类型</label>
     	<s:textfield name="type" value="%{model.type}" class="dfinput" style="width:255px; height:32px"></s:textfield></td> 
     <td><label>标本位置</label><s:textfield name="location" value="%{model.location}" class="dfinput" style="width:255px; height:32px"></s:textfield>
    </td>
    
    </tr>
    <tr></tr>
   		<s:hidden name="time" value="%{model.time}" />
    	<s:hidden name="sstate" valsue="%{model.sstate}" />
     	<s:hidden name="stime" value="%{model.stime}" />
     	<s:hidden name="sperson" value="%{model.sperson}" />  
		<s:hidden name="jsstate" value="%{model.jsstate}" />
     	<s:hidden name="jstime" value="%{model.jstime}" />
		<s:hidden name="jsperson" value="%{model.jsperson}" />
     	<s:hidden name="jsfalse" value="%{model.jsfalse}" />
     	<s:hidden name="hdstate" value="%{model.hdstate}" />
     	<s:hidden name="hdtime" value="%{model.hdtime}" />
     	<s:hidden name="hdfalse" value="%{model.hdfalse}" />
      <tr><td><td><label>&nbsp;</label><input type="submit" class="btn" value="修改" /></td></tr>
     </table>
   </s:form>
    </div>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/date/datebdys.js"></script>
</body>
</html>
