<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>成功上传的文件</title>

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
	<a href="index.jsp" style="text-decoration:none;"><h1 style="color:#E2CECE;padding:20px;border-bottom:1px solid;">IDG
		TechNetwork 业务服务-Beta</h1></a>
		<div style=" padding=10px 15px;margin: 10px auto;" align="center">
		<h4 style="color:#666666;">成功上传的文件:</h4>
	<s:form>
		<div style="border:1px solid black">
			<ul style="list-style-type:decimal">
				<s:iterator value="#request.fileName" id="file" status="status">
					<li><s:property /></li>
				</s:iterator>
			</ul>
		</div>
	</s:form>
	</div>
</body>
</html>
