<%--
  Created by IntelliJ IDEA.
  User: lw
  Date: 14-6-13
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
</head>

<body>
<%response.sendRedirect(basePath + "home/goIndexPage");%>
</body>
</html>

