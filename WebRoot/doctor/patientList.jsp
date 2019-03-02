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
<script type="text/javascript"src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"src="${pageContext.request.contextPath}/js/work.js"></script>
</head>
<%
	// 获取请求的上下文
	String context = request.getContextPath();
%>
<body>
<div class="formbody" >
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">患者信息列表</a></li>
    </ul>
    <div align="right" id="add"><span><img src="${pageContext.request.contextPath}/images/t01.png" /></span><a href="patient_saveUI.action">添加</a></div>
    </div>
    
    <div class="rightinfo">
    
    <s:form action="patient_findAll.action" method="post" namespace="/" theme="simple">
     <table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">患者住院号：</td>
								<td>
									<input name="pid" type="text" class="allInput" value=""/>
								</td>
	                            <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
	       					</tr>
						</tbody>
					</table>
    </s:form>
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>患者住院号</th>
        <th>患者姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>入院时间</th>
        <th>备注</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>  
         <s:iterator var="s" value="list">       
	        	 <tr>
	        	 	<td><s:property value="#s.pid"></s:property></td>
	        	 	<td><s:property value="#s.pname"></s:property></td>
	        	 	<td>
	        	 	<s:if test="#s.sex==0">男</s:if>
            		<s:else>女</s:else></td>
            		<td><s:property value="#s.age"></s:property></td>            		
	        	 	<td><s:date name="#s.date" format="yyyy-MM-dd"></s:date></td>
	        	 	<td><s:property value="#s.remark"></s:property></td>
	        	 	<td>
	        	 		<a href="patient_editUI.action?pid=<s:property value="#s.pid"/>" class="tablelink click">修改</a>
	        	 		<a href="patient_delete.action?pid=<s:property value="#s.pid"/>" class="tablelink">删除</a>
	        	 	</td>
	        	 </tr>
	      	</s:iterator>
	        </tbody>
	    </table>
	    
	   
<table  border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="left" style="font-size:13px; color:#dc4e00;">
   <span>共<s:property value="totalCount"/>条记录&nbsp;&nbsp;每页显示<s:property value="pageSize"/>条</span>&nbsp;&nbsp;
   <span>当前显示第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>
  
   <span>
       <s:if test="currPage!=1">
       <a href="${pageContext.request.contextPath}/patient_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/patient_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
    </s:if>
    <s:if test="currPage!=totalPage">
       <a href="${pageContext.request.contextPath}/patient_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/patient_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
    </s:if>
   </span>
</td>
</tr>
</table>
	    
	    <script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		</script>
        </div>
</body>
</html>
