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
<meta charset="utf-8"/>
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
 <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li> <a href="#" >标本信息添加</a></li>
    </ul>
    </div>
   <div class="formbody">
  <s:form action="specimen_add.action" method="post" namespace="/" theme="simple">
    <table>
     <tr><td></td><td></td><td><p align="center">标本信息添加</p></td></tr>
     <tr></tr> <tr></tr> <tr></tr> <tr></tr>
     <tr>
     <td></td>
       <td><label>标本编号</label><input name="id" type="text" class="dfinput" value="" style="width:255px; height:32px"/></td>
      <td><label>患者住院号</label>
      <s:select list="list" name="patient.pid" listKey="pid" listValue="pid" headerKey="" headerValue="---请选择---" style="border:1px soid red;width:255px; height:32px;" ></s:select>
      </td>
       <td>
          <label>切取时间</label><input class="laydate-icon" id="demo1" name="ctime" value="" style="width:235px; height:32px""/>
        </td>
    </tr> 
     <tr></tr>
    <tr>
    <td></td>
        
        <td><label>标本创建时间</label>
    <input class="laydate-icon" id="demo5" name="time" value="<%=date %>" disable="true" style="width:235px; height:32px" /></td>     
     <td><label>标本名称</label><input name="name" type="text" class="dfinput" value="" style="width:255px; height:32px"/></td>
          <td>
          <label>手术时间</label><input class="laydate-icon" id="demo" name="otime" value="" style="width:235px; height:32px"/> </td> 
     </tr>
      <tr></tr>
   <tr>
    <tr>
    <td></td>
       <td><label>离体时间</label>
    <input class="laydate-icon" id="demo4" name="ltime" value="" style="width:235px; height:32px"/></td>    
      <td><label>标本类型</label><input name="type" type="text" class="dfinput" value="" style="width:255px; height:32px"/>
     </tr>
      <tr></tr> 
        <tr></tr>
      	<s:hidden name="sstate" value="0" />
     	<s:hidden name="stime" value="" />
     	<s:hidden name="sperson" value="" />  
		<s:hidden name="jsstate" value="0" />
     	<s:hidden name="jstime" value="" />
		<s:hidden name="jsperson" value="" />
     	<s:hidden name="jsfalse" value="" />
     	<s:hidden name="hdstate" value="0" />
     	<s:hidden name="hdtime" value="" />
     	<s:hidden name="hdfalse" value="" />
     	<s:hidden name="location" value="" />
      <tr><td></td><td></td><td><label>&nbsp;</label><input type="submit" class="btn" value="添加" /></td></tr>
     </table>
   </s:form>
    </div>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/date/datebdys.js"></script>
</body>
</html>
