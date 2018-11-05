<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/RegisterServlet" onsubmit="">
    	<table>
    		<tr>
    			<td>姓名</td>
    			<td><input type="text" name="userName" value="${formBean.userName}"/>${formBean.errors.userName}</td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td><input type="password" name="userPwd" value="${formBean.userPwd}">${formBean.errors.userPwd}</td>
    		</tr>
    		<tr>
    			<td>确认密码</td>
    			<td><input type="password" name="confirmPwd" value="${formBean.confirmPwd}">${formBean.errors.confirmPwd}</td>
    		</tr>
    		<tr>
    			<td>生日</td>
    			<td><input type="text" name="birthday" value="${formBean.birthday}"/>${formBean.errors.birthday}</td>
    		</tr>
    		<tr>
    			<td>生日</td>
    			<td><input type="reset" value="清空"/></td>
    		</tr>
    		<tr>
    			<td>生日</td>
    			<td><input type="submit" value="提交" /></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
