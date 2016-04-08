<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body style="width:960px;">
	<h1 style="color:#E2CECE;padding:20px;border-bottom:1px solid;">IDG TechNetwork 业务服务-Beta</h1>
	<div style=" padding=10px 15px;margin: 10px auto;" align="center">
	<!-- <a href="emp-list">List All Employees</a>
	<br><br>
	<a href="emp-input">Add New Employees</a>
	<br><br>
	<a href="operfile">import fiel</a>
	<br><br> -->
	<a href="listfile">下载文件</a>
	<br><br>
	<!-- <a href="filedownload?fileName=test1.xls">下载test1.xls</a>
	<br><br>
	<a href="filedownload?fileName=中文测试凤凰网.xlsx">下载 中文测试凤凰网.xlsx</a>
	<br><br> -->
<!-- 	<a href="upfileurl">上传文件</a> -->
	<a href="upfile.jsp">上传文件</a>
	</div>
  </body>
</html>
