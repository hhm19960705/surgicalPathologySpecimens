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
	var sHTML = "<p><img src='<%=request.getContextPath()%>/qRCode.action?id=<s:property value="id"/>' style='width:200px;height:200px'/></p>"+
      '<p><button onclick="window.neatDialog.close()">关闭</button><button>打印</button></p>';
    new NeatDialog(sHTML, "扫描了解详情!", false);
}
</script>
</head>
<body>
 <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li> <a href="#" >标本详情信息</a></li>
    </ul>
    </div>
  <div class="formbody">
    <table align="center">
     <tr><td></td><td><p align="center">标本详情信息</p></td></tr>
     <tr></tr> <tr></tr> <tr></tr> <tr></tr>
     <tr>
       <td><label>标本编号</label>
       <s:textfield name="id" value="%{model.id}" class="dfinput" style="width:255px; height:32px" readonly="true"></s:textfield></td>
      <td><label>患者住院号</label>
      <s:select list="list" name="patient.pid" listKey="pid" listValue="pid"  disabled="true" value="%{model.patient.pid}" headerKey="" headerValue="---请选择---"
     style="border:1px soid red;width:255px; height:32px;" ></s:select>
      </td>
      <td><label>标本名称</label>
      <s:textfield name="name" value="%{model.name}" class="dfinput" readonly="true" style="width:255px; height:32px"></s:textfield></td>
    </tr> 
     <tr></tr>
    <tr>
        <td>
          <label>手术时间</label><input   readonly="true" name="otime" value="<s:date name="model.otime" format="yyyy-MM-dd" />" style="width:255px; height:32px"/></td>	
        <td>
          <label>切取时间</label><input  readonly="true"  name="ctime" value="<s:date name="model.ctime" format="yyyy-MM-dd" />" style="width:255px; height:32px"/>
        </td>
         <td><label>离体时间</label>
    <input   name="ltime" readonly="true"  value="<s:date name="model.ltime" format="yyyy-MM-dd" />" style="width:255px; height:32px"/></td>    
     </tr>
      <tr></tr>
   
     <tr>
      <td><label>标本创建时间</label>
    <input  name="time" readonly="true" value="<s:date name="model.time" format="yyyy-MM-dd" />" style="width:255px; height:32px"/></td>    
   		 <td><label>标本类型</label>
     	<s:textfield name="type" value="%{model.type}" readonly="true" class="dfinput" style="width:255px; height:32px"></s:textfield></td> 
     <td><label>标本位置</label><s:textfield name="location" readonly="true" value="%{model.location}" class="dfinput" style="width:255px; height:32px"></s:textfield>
    </td>
    
    </tr>
     <tr>
      <td><label>送检时间</label>
    <input  name="stime" readonly="true" value="<s:date name="model.stime" format="yyyy-MM-dd" />" style="width:255px; height:32px"/></td>    
   		 <td><label>送检状态</label>
   		 <input name="sstate" readonly="true" value="<s:if test="%{model.sstate}==0">未送检</s:if>
            		<s:else>已送检</s:else>" style="width:255px; height:32px" readonly="true" /></td>    
     <td><label>送检人</label><s:textfield name="sperson" value="%{model.sperson}" readonly="true" class="dfinput" style="width:255px; height:32px"></s:textfield>
    </td>
    </tr>
     <tr>
      <td><label>接收时间</label>
    <input name="jstime" readonly="true" value="<s:date name="model.jstime" format="yyyy-MM-dd" />" style="width:255px; height:32px"/></td>    
   		 <td><label>接收状态</label>
     	 <input readonly="true" name="jsstate" readonly="true" value="<s:if test="%{model.jsstate}==0">未接收</s:if>
            		<s:elseif test="%{model.jsstate}==1">接收成功</s:elseif> 
            		<s:else>接收失败</s:else>" style="width:255px; height:32px"/></td>   
     <td><label>接收人</label><s:textfield name="jsperson" value="%{model.jsperson}" readonly="true" class="dfinput" style="width:255px; height:32px"></s:textfield>
    </td></tr>
     <tr>
      <td><label>接收错误信息</label><s:textfield name="jsfalse" readonly="true" value="%{model.jsfalse}" style="width:255px; height:32px"></s:textfield>
      <td><label>核对时间</label>
    <input name="hdtime" readonly="true" value="<s:date name="model.hdtime" format="yyyy-MM-dd" />" style="width:255px; height:32px"/></td>    
   		 <td><label>核对状态</label>
     	 <input  name="hdstate" readonly="true" value="<s:if test="%{model.hdstate}==0">未核对</s:if>
            		<s:elseif test="%{model.hdstate}==1">核对成功</s:elseif> 
            		<s:else>核对失败</s:else>" style="width:255px; height:32px"/></td>   
    </td></tr>
     <tr>
      <td><label>核对错误信息</label><s:textfield name="hdfalse" value="%{model.hdfalse}" readonly="true" class="dfinput" style="width:255px; height:32px"></s:textfield>
    </td></tr>
      <tr><td><td><label>&nbsp;</label><input id="qrcode" type="submit" class="btn" onclick="openDialog()" value="打印" /></td></tr>
     </table>
    </div>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/date/datebdys.js"></script>
</body>
</html>
