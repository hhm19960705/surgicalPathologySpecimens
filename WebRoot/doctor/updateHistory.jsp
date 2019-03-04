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
    <li> <a href="#" >病例信息修改</a></li>
    </ul>
    </div>
  <div class="formbody" >
    <s:form action="history_edit.action" method="post" namespace="/" theme="simple">
    <ul class="forminfo" >
    <li><p align="center">修改病例</p></li>
    <li> <label>病理单编号</label><s:textfield name="id" readonly="true" value="%{model.id}" class="dfinput" style="width:360px; height:32px"></s:textfield></li>
    <li> <label>患者住院号</label> 
    <s:select list="list" name="patient.pid" listKey="pid" listValue="pid"  style="width:360px; height:32px" value="%{model.patient.pid}" headerKey="" headerValue="---请选择---"
     ></s:select></li>
    <li> <label>病理单创建时间</label>
    	<input class="laydate-icon" id="demo" style="width:345px; height:32px" name="htime" value="<s:date name="model.htime" format="yyyy-MM-dd" />"/>			      
 	</li>
    <li> <label>手术名称</label><s:textfield name="oname" value="%{model.oname}" class="dfinput" style="width:360px; height:32px"></s:textfield></li> 
    <li> <label>手术部位</label><s:textfield name="oposition" value="%{model.oposition}" class="dfinput" style="width:360px; height:32px"></s:textfield>
    </li>
    <li> <label>病历摘要</label>
    <s:textfield name="blzy" value="%{model.blzy}" class="dfinput" style="width:360px; height:32px"></s:textfield>
   </li>
    <li> <label>传染病信息</label>
    <s:textfield name="crbxx" value="%{model.crbxx}" class="dfinput" style="width:360px; height:32px"></s:textfield>
    </li>
     	<s:hidden name="czstate" value="%{model.czstate}" />
      	<s:hidden name="czperson" value="%{model.czperson}" />
     	<s:hidden name="cztime" value="%{model.cztime}" />
     	<s:hidden name="cbzd" value="%{model.cbzd}" />
     	<s:hidden name="shstate" value="%{model.shstate}" />
      	<s:hidden name="shperson" value="%{model.shperson}" />
     	<s:hidden name="shtime" value="%{model.shtime}" />
     	<s:hidden name="images" value="%{model.images}" />
     	<s:hidden name="radio" value="%{model.radio}" />
    <li><label>&nbsp;</label><input type="submit" class="btn" value="修改" /></li>
    </ul>
    </s:form>
    </div>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/date/datebdys.js"></script>
</body>
</html>
