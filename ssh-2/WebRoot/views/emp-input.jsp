<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'emp-input.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(":input[name=lastName]").change(function(){
				var val = $(this).val();
				val = $.trim(val);
				var $this = $(this);
				
				if(val != ""){
					//把当前节点后面的所有font 兄弟节点删除
					$this.nextAll("font").remove();
					//alert("发送AJAX 请求");
					var url = "emp-validateLastName";
					var args = {"lastName":val,"time":new Date()};
					$.post(url,args,function(data){
						alert(data);
						//表示可用
						if(data == 1){
							$this.after("<font color='green'>LastName可用！</fongt>");
						}
						//不可用
						else if(data == "0"){
							$this.after("<font color='red'>LastName不可用！</fongt>");
						}
						//服务器错误
						else{
							alert("服务器错误！");
							}
					})
				}else{
					alert("lastName 不能为空");
					//this.focus();
				}
			});
		})
	</script>
  </head>
  
  <body>
	<h4>Employee Input Page</h4>
	<s:form action="emp-save" method="post">
		<s:textfield name="lastName" label="LastName"></s:textfield>
		<s:textfield name="email" label="Email"></s:textfield>
		<s:textfield name="birth" label="Birth"></s:textfield>
		<s:select list="#request.departments"
			listKey="id" listValue="departmentName" name="department.id" label="Department"></s:select>
			<s:submit></s:submit>
	</s:form>
  </body>
</html>
