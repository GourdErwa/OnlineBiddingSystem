<%@ page import="com.gourderwa.entity.Users" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wei.Li
  Date: 16/3/11
  Time: 下午11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<nav>
    <ul class="nav nav-pills pull-right" id="menu">

        <li id="homeMenu" role="presentation" class=""><a href="<%=basePath%>home/goIndexPage">首页</a></li>
        <li id="candyMenu" role="presentation"><a href="<%=basePath%>candy/goIndexPage">选购糖果</a></li>

        <c:if test="${sessionScope.get('users') != null}">

            <li id="customizationMenu" role="presentation"><a href="<%=basePath%>candy/customization">手工定制</a></li>
            <c:if test="${sessionScope.get('isAdmin') != null}">
                <li id="manageCandy" role="presentation"><a href="<%=basePath%>candy/manageCandy">糖果管理</a></li>
                <li id="orderFormManage" role="presentation"><a href="<%=basePath%>orderForm/manageShowAll">订单管理</a>
                </li>
                <li id="usersMenu" role="presentation"><a href="<%=basePath%>users/goShowAllUsersIndexPage">用户管理</a>
                </li>
            </c:if>

            <li id="myMenu" role="presentation" class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                   aria-expanded="false">
                    <%=((Users) session.getAttribute("users")).getUserName()%> <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="<%=basePath%>users/goUpdateUsersIndexPage?usersId=<%=((Users) session.getAttribute("users")).getUserId()%>">个人中心</a></li>
                    <li id="myOrderFormMenu" role="presentation"><a
                            href="<%=basePath%>orderForm/showAllForMy">我的订单</a></li>
                    <li><a href="<%=basePath%>login/loginOut">退出登录</a></li>
                </ul>
            </li>
        </c:if>

        <c:if test="${sessionScope.get('users') == null}">
            <li id="loginMenu" role="presentation"><a href="<%=basePath%>login/goIndexPage">登录</a></li>
            <li id="registerMenu" role="presentation"><a href="<%=basePath%>users/goCreateUsersIndexPage">注册</a>
            </li>
        </c:if>

    </ul>
</nav>
<h3 class="text-muted">${applicationScope.projectName}</h3>

<script>

    //菜单激活控制
    var activeMenu = '${activeMenu}';
    if (activeMenu) {
        $("#menu").find("li .active").removeClass("active");
        $("#" + activeMenu).addClass("active");
    }

</script>
