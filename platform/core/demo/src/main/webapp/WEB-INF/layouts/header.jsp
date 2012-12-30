<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<div id="header" class="span12">
    <div id="title">
        <a href="${ctx}/logout" style="float:right;margin-top:14px"><font size="2">退出登录&nbsp; </font></a>
        <span class="pull-right" style="margin:14px 8px 0 0"> ${date}&nbsp;&nbsp;${welInfo}</span>

        <h1>
            MVCDemo
            <small>--CRUD管理界面演示
            </small>
        </h1>
    </div>

    <div id="menu">
        <ul class="nav nav-tabs">
            <li class="active"><a href="${ctx}/login">登录</a></li>
            <li id="user-tab"><a href="${ctx}/account/user/list">帐号列表</a></li>
            <li id="group-tab"><a href="${ctx}/account/group/">权限组列表</a></li>
            <li id="portal-tab"><a href="${ctx}/user_group/portal/main">帐号及权限信息(portal)</a></li>
            <li id="pipe-tab"><a href="${ctx}/user_group/pipe/main">帐号及权限信息(pipe)</a></li>
            <li id="file-tab"><a href="${ctx}/file/download/main">文件下载</a></li>
            <li id="qsl-tab"><a href="${ctx}/account/user/qslList">QSL演示</a></li>
            <li id="dynamicsql-tab"><a href="${ctx}/account/user/complexSql">动态SQL演示</a></li>
            <li id="jpql-tab"><a href="${ctx}/account/user/queryResult">JPQL演示</a></li>
            <li id="sqlresource-tab"><a href="${ctx}/account/user/resourceResult">SQL资源文件查询</a></li>
            <li id="jparesource-tab"><a href="${ctx}/account/user/namedQuerylList">JPA资源文件查询</a></li>
            <li id="oracleProcedure-tab"><a href="${ctx}/account/user/selectUserWithOraclePro">ORACLE存储过程</a></li>
            <li id="mysqlProcedure-tab"><a href="${ctx}/account/user/selectUserWithMysqlPro">MYSQL存储过程</a></li>
            <li id="frontendCrypto-tab"><a href="${ctx}/crypto_uncrypto/cryptoUncrypto/frontendCrypto">前端加密</a></li>
            <li id="backgroundCrypto-tab"><a href="${ctx}/crypto_uncrypto/cryptoUncrypto/backgroundCrypto">后端加密</a></li>
        </ul>
    </div>
</div>


