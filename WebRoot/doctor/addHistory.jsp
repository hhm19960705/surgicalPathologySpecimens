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
    <li> <a href="#" >病例信息添加</a></li>
    </ul>
    </div>
  <div class="formbody" >
    <s:form action="history_add.action" method="post"  theme="simple" enctype="multipart/form-data">
    <ul class="forminfo" >
    <li><p align="center">新增病例</p></li>
    <li> <label>病理单编号</label><input name="id" type="text" class="dfinput" value="" style="width:360px; height:22px"/></li>
    <li> <label>患者住院号</label> <s:select style="width:360px; height:22px" list="list" name="patient.pid" listKey="pid" listValue="pid" headerKey="" headerValue="---请选择---"></s:select></li>
    <li> <label>病理单创建时间</label>
    <input class="laydate-icon" id="demo" name="htime" value="" style="width:345px; height:22px"/></li>
    <li> <label>手术名称</label><input name="oname" type="text" class="dfinput" value="" style="width:360px; height:22px"/></li> 
    <li> <label>手术部位</label><input name="oposition" type="text" class="dfinput" value="" style="width:360px; height:22px"/></li>
    <li> <label>病历摘要</label><input name="blzy" type="text" class="dfinput" value="" style="width:360px; height:22px"/></li>
    <li> <label>传染病信息</label><input name="crbxx" type="text" class="dfinput" value="" style="width:360px; height:22px"/></li>
    <li><label>上传图片</label><input type="file" name="files"></li>
    <li><label>上传录音</label><input type="file" name="files"></li>
   	    <s:hidden name="czstate" value="0" />
      	<s:hidden name="czperson" value="" />
     	<s:hidden name="cztime" value="" />
     	<s:hidden name="cbzd" value="" />
     	<s:hidden name="shstate" value="0" />
      	<s:hidden name="shperson" value="" />
     	<s:hidden name="shtime" value="" />
    <li><label>&nbsp;</label><input type="submit" class="btn" value="添加" /></li>    	
    </ul>
    </s:form>
    </div>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/date/datebdys.js"></script>
</body>
</html>
