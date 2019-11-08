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
    
    <title>My JSP 'selectList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	--> 
		<link type="text/css" rel="stylesheet" href="css/style.css" />

  </head>
  <script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
	<script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>
    
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>    
        
	<script type="text/javascript" src="js/select.js"></script>
    
	<script type="text/javascript" src="js/lrscroll.js"></script>
    
    <script type="text/javascript" src="js/iban.js"></script>
    <script type="text/javascript" src="js/fban.js"></script>
    <script type="text/javascript" src="js/f_ban.js"></script>
    <script type="text/javascript" src="js/mban.js"></script>
    <script type="text/javascript" src="js/bban.js"></script>
    <script type="text/javascript" src="js/hban.js"></script>
    <script type="text/javascript" src="js/tban.js"></script>
    
	<script type="text/javascript" src="js/lrscroll_1.js"></script>
	
	<script type="text/javascript">
		function lxj(pageIndex){
			$("#PageIndex").val(pageIndex);
			$("#fo").submit();
		}
	</script>
  <body>
		<div class="m_right">
            <p></p>
            <div class="mem_tit">查看用户</div>
            <div>
             <form action="${pageContext.request.contextPath}/selectUserpage" method="post"  id="fo">
          	       用户名:<input type="text" name="loginName">
                                     姓名:<input type="text" name="userName">
                                     电话:<input type="text" name="mobile">
                  <input type="hidden" name="pageIndex" id="PageIndex">
                  <input type="submit" value="搜索">
             </form>
         </div>
            <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
              <tr>                                                                                                                                                    
                <td width="20%">账户</td>
                <td width="25%">姓名</td>
                <td width="15%">性别</td>
                <td width="25%">电话</td>
                <td width="25%">操作</td>
              </tr>
              
              <c:forEach items="${pageList.dataList}" var="list">
              <tr>
              	<td width="20%">${list.loginName }</td>
              	<td width="20%">${list.userName }</td>
              	<td width="20%">${list.sex }</td>
              	<td width="20%">${list.mobile }</td>
              	<td width="20%"><a href="#">修改</a> <a href="#">删除</a></td>
              </tr>
              </c:forEach>
     	<tr>
     	</tr>
    </table>
		一共${pageList.pageCount}页，每页显示${pageList.pageSize }条,当前第${pageList.pageIndex}页
     	<a href="javascript:;" onclick="lxj(${1})">首页</a>
     	<a href="javascript:;" onclick="lxj(${pageList.pageIndex-1})">上一页</a>
     	<a href="javascript:;" onclick="lxj(${pageList.pageIndex+1})">下一页</a>
     	<a href="javascript:;" onclick="lxj(${pageList.pageCount})">尾页</a>
        </div>  
  </body>
</html>
