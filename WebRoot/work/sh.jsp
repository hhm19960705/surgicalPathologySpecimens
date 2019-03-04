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
<link href="${pageContext.request.contextPath}/css/nurse.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/date/laydate.js"></script>
<script type="text/javascript"src="${pageContext.request.contextPath}/js/jquery.js"></script>
<link href="${pageContext.request.contextPath}/css/code.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
String date= format.format(new Date());
%>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li> <a href="#" >最终审核</a></li>
    </ul>
    </div>
  	<div class="formbody" >
    <s:form action="history_shsuccess.action" method="post" namespace="/" theme="simple">
    <ul class="forminfo" >
    <li><p align="center">最终审核</p></li>
    <li> <label>病理单编号</label><s:textfield name="id" value="%{model.id}" class="dfinput" readonly="true" style="width:360px; height:30px"></s:textfield></li>
    <li> <label>病历摘要</label>
    <s:textfield name="blzy" value="%{model.blzy}" class="dfinput" readonly="true" style="width:360px; height:30px"></s:textfield>
   </li>
    <li> <label>传染病信息</label>
    <s:textfield name="crbxx" value="%{model.crbxx}" class="dfinput" readonly="true" style="width:360px; height:30px"></s:textfield>
    </li>
    <li> <label>初步诊断结果</label>
    <s:textarea rows="3" cols="50" name="cbzd" value="%{model.cbzd}" class="dfinput" readonly="true" style="width:360px; height:30px"></s:textarea>
    </li>
    <li><label>最终审核时间</label><input name="shtime" type="text" value="<%=date%>" readonly="true" style="width:360px; height:30px"/></li>
    <li><label>最终审核人</label><input name="shperson" type="text" value="<%=session.getAttribute("userName") %>" readonly="true" style="width:360px; height:30px"/></li>
    	<s:hidden list="list" name="patient.pid" listKey="pid" listValue="pid"  value="%{model.patient.pid}"/>
    	<s:hidden name="htime" value="%{model.htime}" />
    	<s:hidden name="oname" value="%{model.oname}" />
    	<s:hidden name="oposition" value="%{model.oposition}" />
     	<s:hidden name="czstate" value="%{model.czstate}" />
      	<s:hidden name="czperson" value="%{model.czperson}" /> 
      	<s:hidden name="cztime" value="%{model.cztime}" />    
     	<s:hidden name="shstate" value="1" />
     	<s:hidden name="images" value="%{model.images}" />
     	<s:hidden name="radio" value="%{model.radio}" />
    <li><label>&nbsp;</label><input type="submit" class="btn" value="提交" /></li>
    </ul>
    </s:form>
    </div>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/date/datebdys.js"></script>
</body>
</html>
