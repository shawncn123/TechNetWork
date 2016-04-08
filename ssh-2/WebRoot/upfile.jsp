<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>文件上传</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="scripts/updown.js"></script>
<!-- <style>
a{display:inline-block; width:100px; height:40px; background:red; position:relative; overflow:hidden;}
a:hover{background:green;}
input{position:absolute; right:0; top:0; font-size:100px; opacity:0; filter:alpha(opacity=0);}
</style> -->
</head>

<body style="width:960px;">
	<a href="index.jsp" style="text-decoration:none;"><h1 style="color:#E2CECE;padding:20px;border-bottom:1px solid;">IDG TechNetwork 业务服务-Beta</h1></a>
	<div style=" padding=10px 15px;margin: 10px auto;" align="center">
		<h4>选择上传文件</h4>
		<form action="upload" method="post" enctype="multipart/form-data">
			<table align="center" width="50%" border="1"
				style="border-spacing:1px;border-color:#F3CDCD;">
				<tr>
					<td id="more"><input type="file" name="file"
						style="margin:3px;" value="test"></td>
					<!-- 	<td><input
					type="button" value="Add More.." onclick="addMore()"></td> -->
				</tr>
				<tr>
					<td id="more"><input type="file" name="file"
						style="margin:3px;" value="test"></td>
				</tr>
				<tr>
					<td id="more"><input type="file" name="file"
						style="margin:3px;" value="test"></td>
				</tr>
				<tr>
					<td id="more"><input type="file" name="file"
						style="margin:3px;" value="test"></td>
				</tr>
				<tr>
					<td id="more"><input type="file" name="file"
						style="margin:3px;" value="test"></td>
				</tr>

			</table>
			<input type="submit" value="提交" onclick="return checkf()"
				style="margin:10px 10px;padding:2px 20px;"> <input
				type="reset" value="取消" style="margin:10px 10px;padding:2px 20px;">
		</form>

	</div>
</body>
</html>
