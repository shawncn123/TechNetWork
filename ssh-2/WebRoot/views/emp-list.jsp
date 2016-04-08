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
    
    <title>My JSP 'emp-list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="scripts/jquery-1.12.1.min.js"></script>
	<!-- 上面，建议开发生产环境还是用绝对路径 -->
	<script type="text/javascript">
		$(function () {
			/* 1.点击delete时，弹出确定是要删除XX的信息吗？若确定，则执行，若不确定，则取消 */
			$(".delete").click(function(){
				var lastName = $(this).next(":input").val();
				var flag = confirm("确定要删除"+ lastName + "信息吗？");
				if(flag){
					var $tr =  $(this).parent().parent();
					/*删除，使用ajax的方式  */
					var url = this.href;
					//注意不要写成小写的 new date();
					var args = {"time":new Date()};
					//if()
					//alert(args.toString());
					$.post(url,args,function(data){
						//若	data 的返回值为1，则提示删除成功，则把当前行删除
						if(data == "1"){
							alert("删除成功！");
							$tr.remove();
						}else{
						//若data 的返回值不是1，则提示删除失败
							alert("删除失败！");							
						}
					});
				}
				//取消超链接的默认行为
				return false;
			});
		})
	</script>
  </head>
  
  <body>
	<h4>Employee List Page</h4>
	
	<s:if test="#request.employees == null || #request.employees.size() == 0">
		没有任何员工信息
	</s:if>
	<s:else>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>ID</td>
				<td>LASTNAME</td>
				<td>EMAIL</td>
				<td>BIRTH</td>
				<td>CREATETIME</td>
				<td>DEPT</td>
				<td>DELETE</td>
			</tr>
			<s:iterator value="#request.employees">
			<tr>
				<td>${id}</td>
				<td>${lastName}</td>
				<td>${email}</td>
				<%-- <td>${birth}</td> --%>
				<td>
					<s:date name="birth" format="yyyy-MM-dd"/>
				</td>
				
				<%-- <td>${createTime}</td> --%>
				<td>
					<s:date name="createTime" format="yyyy-MM-dd"/>
				</td>
				<td>${department.departmentName }</td>
				<td>
					<a href="emp-delete?id=${id}" class="delete">DELETE</a>
					<input type="hidden" value="${lastName }" />	
				</td>
			</tr>
			</s:iterator>
		</table>
	</s:else>
  </body>
</html>
