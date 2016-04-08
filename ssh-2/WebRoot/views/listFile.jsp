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

<title>文件列表</title>

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
		<h4 style="color:#666666;">合作伙伴：<span style="color:080808;">凤凰网</span> 近期报表</h4>
		<table align="center" width="50%" border="1"
			style="border-spacing:1px;border-color:#F3CDCD;">
			<s:iterator value="#request.listfilenames" id="st" status="tl">
				<tr>
					<s:if test="#tl.getIndex() < 10">
					<td style="padding:10px;"><span><s:property value="#st" /></span>
						<a href="filedownload?fileName=<s:property value="#st" />">下载</a></td>
						</s:if>
				</tr>
			</s:iterator>

		</table>
	</div>
</body>
<%-- <s:debug></s:debug> --%>
</html>
