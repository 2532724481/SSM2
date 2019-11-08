<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'address.jsp' starting page</title>
    
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
  		<form action="<%=path %>/Addaddress.action" method="post">
  		<h1>${msg}</h1>
  		用户<select name="userId">
  		<c:forEach items="${userlist}" var="list">
  			<option value="${list.id}">${list.userName}</option>
  		</c:forEach>
  		</select>
  		地址<input type="text" name="address"><br/>
  		是否删除<input type="radio" value="1" name="isDefault"><br/>
  		详细<input type="text" name="remark"><br/>
  		日期<input type="text" name="createtime"><br/>
  		<input type="submit" value="新增"><br/>
  		</form>
  </body>
</html>
