<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'hello.jsp' starting page</title>
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
   	 注册成功<br>
   	您的注册账号为:<%out.println(request.getAttribute("name1"));out.println("<br>"); %>
   	您的注册密码为:<%out.println(request.getAttribute("pass1")); %>
   	
   	 <%
   	 String name=(String)request.getAttribute("name");
   	 out.println(name);
   	 
   	 out.println("<br>");
   	 if(name=="luoluo"){
   	 	out.println("correct name");
   	 }
   	  %>
   	 <%= name %>
  </body>
</html>
