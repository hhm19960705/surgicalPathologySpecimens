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
<link href="${pageContext.request.contextPath}/css/work.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/date/laydate.js"></script>
<script type="text/javascript"src="${pageContext.request.contextPath}/js/jquery.js"></script>
<link href="${pageContext.request.contextPath}/css/code.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/code.js"></script>
<script type="text/javascript">
//切换验证码
function change(){
	var img1=document.getElementById("checkImg");
	img1.src="${pageContext.request.contextPath}/checkImg.action"; 
}
$(function(){

$(".i-text").focus(function(){
$(this).addClass('h-light');
});

$(".i-text").focusout(function(){
$(this).removeClass('h-light');
});

});

function openDialog()
{
	var sHTML = "<p><img src='<%=request.getContextPath()%>/qRCodeDoctor.action?id=<s:property value="id"/>' style='width:200px;height:200px'/></p>"+
      '<p><button onclick="window.neatDialog.close()">关闭</button><button>打印</button></p>';
    new NeatDialog(sHTML, "扫描了解详情!", false);
}
</script>
</head>
<body>
 <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li> <a href="#" >病理申请单详情信息</a></li>
    </ul>
    </div>
  	<div class="formbody">
    <table>
     <tr><td></td><td></td><td><p align="center">病理申请单详情信息</p></td></tr>
     <tr></tr> <tr></tr> <tr></tr> <tr></tr>
     <tr>
     <td></td>
       <td><label>病理单编号</label><s:textfield name="id" value="%{model.id}" class="dfinput" readonly="true" style="width:360px; height:25px"></s:textfield></td>
      <td><label>手术名称</label><s:textfield name="oname" value="%{model.oname}" class="dfinput" readonly="true" style="width:360px; height:25px"></s:textfield>
      </td>
       <td>
         <label>手术部位</label><s:textfield name="oposition" value="%{model.oposition}" class="dfinput" readonly="true" style="width:360px; height:25px"></s:textfield>
        </td>
    </tr> 
     <tr></tr>
    <tr>
    <td></td>
        
        <td><label>病历摘要</label>
    <s:textfield name="blzy" value="%{model.blzy}" class="dfinput" readonly="true" style="width:360px; height:25px"></s:textfield></td>     
     <td><label>传染病信息</label>
    <s:textfield name="crbxx" value="%{model.crbxx}" class="dfinput" readonly="true" style="width:360px; height:25px"></s:textfield></td>
          <td>
          <label>创建时间</label>
   <input name="cztime" type="text" class="dfinput" readonly="true" style="width:360px; height:25px" value="<s:date name="model.cztime" format="yyyy-MM-dd" />" /></li>
    </li></td> 
     </tr>
      <tr></tr>
   <tr>
    <tr>
    <td></td>
       <td><label>创建人</label>
   <s:textfield name="czperson" value="%{model.czperson}" class="dfinput" readonly="true" style="width:360px; height:25px"></s:textfield></td>    
      <td><label>手术及临床所见</label>
    <s:textarea rows="2" cols="50" name="cbzd" value="%{model.cbzd}" readonly="true"></s:textarea>
     </tr>
      <tr>
      <td></td>
    <td></td>
       <td><img name="images" src="${pageContext.request.contextPath}/${model.images}" alt="病例" style="width:360px; height:100px"></td>         
      <td></td>
     </tr>
     <tr></tr>
      <tr>
      <td></td>
    <td></td>
      <td><label>录音</label><audio name="radio" src="${pageContext.request.contextPath}/${model.radio}" controls muted autoplay>
    当浏览器不支持时，此处给出提示
    </audio></td>
      </tr> 
        <tr></tr>
     <s:hidden list="list" name="patient.pid" listKey="pid" listValue="pid"  value="%{model.patient.pid}"/>
    	<s:hidden name="htime" value="%{model.htime}" />
     	<s:hidden name="czstate" value="1" />
     	<s:hidden name="shstate" value="%{model.shstate}" />
      	<s:hidden name="shperson" value="%{model.shperson}" />
     	<s:hidden name="shtime" value="%{model.shtime}" />
     	
      <tr><td></td><td></td><td><input id="qrcode" type="submit" class="btn" onclick="openDialog()" value="打印" /></td></tr>
     </table>
    </div>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/date/datebdys.js"></script>
</body>
</html>
