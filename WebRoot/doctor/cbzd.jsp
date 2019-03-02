<%@ page language="java" import="java.util.*,java.text.*" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<%
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
String date= format.format(new Date());
%>
 <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li> <a href="#" >创建病理申请单</a></li>
    </ul>
    </div>
  	<div class="formbody" >
    <s:form action="history_cbsuccess.action" method="post" namespace="/" theme="simple">
    <ul class="forminfo" >
    <li><p align="center">创建病理申请单</p></li>
    <li> <label>病理单编号</label><s:textfield name="id" value="%{model.id}" class="dfinput" readonly="true" style="width:360px; height:25px"></s:textfield></li>
    <li> <label>手术名称</label><s:textfield name="oname" value="%{model.oname}" class="dfinput" readonly="true" style="width:360px; height:25px"></s:textfield></li> 
    <li> <label>手术部位</label><s:textfield name="oposition" value="%{model.oposition}" class="dfinput" readonly="true" style="width:360px; height:25px"></s:textfield>
    </li>
    <li> <label>病历摘要</label>
    <s:textfield name="blzy" value="%{model.blzy}" class="dfinput" readonly="true" style="width:360px; height:25px"></s:textfield>
   </li>
    <li> <label>传染病信息</label>
    <s:textfield name="crbxx" value="%{model.crbxx}" class="dfinput" readonly="true" style="width:360px; height:25px"></s:textfield>
    </li>
    <li><label>创建时间</label><input name="cztime" type="text" value="<%=date%>" readonly="true" style="width:360px; height:25px"/></li>
    <li><label>创建人</label><input name="czperson" type="text" value="<%=session.getAttribute("userName") %>" readonly="true" style="width:360px; height:25px"/></li>
    <li> <label>手术及临床所见</label>
   		 <textarea rows="2" cols="50" name="cbzd"></textarea>
    </li>
    	<s:hidden list="list" name="patient.pid" listKey="pid" listValue="pid"  value="%{model.patient.pid}"/>
    	<s:hidden name="htime" value="%{model.htime}" />
     	<s:hidden name="czstate" value="1" />
     	<s:hidden name="shstate" value="%{model.shstate}" />
      	<s:hidden name="shperson" value="%{model.shperson}" />
     	<s:hidden name="shtime" value="%{model.shtime}" />
    <li><label>&nbsp;</label><input type="submit" class="btn" value="提交" /></li>
    </ul>
    </s:form>
    </div>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/date/datebdys.js"></script>
</body>
</html>
