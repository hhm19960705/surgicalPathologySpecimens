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
    <li><a href="#">标本信息列表</a></li>
    </ul>
    <div align="right" id="add"><span><img src="${pageContext.request.contextPath}/images/t01.png" /></span><a href="specimen_saveUI.action">添加</a></div>
    </div>
    
    <div class="rightinfo">
    
    <s:form action="specimen_findAll.action" method="post" namespace="/" theme="simple">
     <table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">标本编号：</td>
								<td>
									<input name="id" type="text" class="allInput" value=""/>
								</td>
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
        <th>标本编号</th>
        <th>患者住院号</th>
        <th>标本名称</th>
        <th>标本类型</th>
        <th>切取时间</th>
        <th>离体时间</th>
        <th>标本创建时间</th>
        <th>核对状态</th>
        <th>核对时间</th>
        <th>送检状态</th>
        <th>送检时间</th>
        <th>核对及送检人</th>
        <th>接收状态</th>
        <th>接收时间</th>
        <th>接收人</th>
       	<th>标本位置</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>  
         <s:iterator var="s" value="list">       
	        	 <tr>
	        	 	<td><s:property value="#s.id"></s:property></td>
	        	 	<td><s:property value="#s.patient.pid"></s:property></td>
	        	 	<td><s:property value="#s.name"></s:property></td>
	        	 	<td><s:property value="#s.type"></s:property></td>
	        	 	<td><s:date name="#s.ctime" format="yyyy-MM-dd"></s:date></td>
	        	 	<td><s:date name="#s.ltime" format="yyyy-MM-dd"></s:date></td>
	        	 	<td><s:date name="#s.time" format="yyyy-MM-dd"></s:date></td>
	        	 	<td><s:if test="#s.hdstate==0">未核对</s:if>
            		<s:elseif test="#s.hdstate==1">核对成功</s:elseif> 
            		<s:else>核对失败</s:else></td>
            		<td><s:date name="#s.hdtime" format="yyyy-MM-dd"></s:date></td>
            		<td><s:if test="#s.sstate==0">未送检</s:if>
            		<s:else>已送检</s:else></td>
	        	 	<td><s:date name="#s.stime" format="yyyy-MM-dd"></s:date></td>
	        	 	<td><s:property value="#s.sperson"></s:property></td>
	        	 	<td><s:if test="#s.jsstate==0">未接收</s:if>
            		<s:elseif test="#s.jsstate==1">接收成功</s:elseif> 
            		<s:else>接收失败</s:else></td>
	        	 	<td><s:date name="#s.jstime" format="yyyy-MM-dd"></s:date></td>
	        	 	<td><s:property value="#s.jsperson"></s:property></td>
	        	 	<td><s:property value="#s.location"></s:property></td>
	        	 	<td>
	        	 		<a href="specimen_editUI.action?id=<s:property value="#s.id"/>" class="tablelink click">修改</a>
	        	 		<a href="specimen_delete.action?id=<s:property value="#s.id"/>" class="tablelink">删除</a>
	        	 		<a href="specimen_detailsUI.action?id=<s:property value="#s.id"/>" class="tablelink">查看</a>
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
       <a href="${pageContext.request.contextPath}/specimen_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/specimen_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
    </s:if>
    <s:if test="currPage!=totalPage">
       <a href="${pageContext.request.contextPath}/specimen_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/specimen_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
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
