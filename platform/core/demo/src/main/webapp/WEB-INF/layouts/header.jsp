<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="java.util.Locale" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="rc" uri="http://util.one.sinosoft.com/RCDate" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script>
    var ctx = '${ctx}';
</script>
<%
    //Locale locale = Locale.getDefault();
   // Locale.setDefault(Locale.CHINESE);


%>
<div id="header" class="span12">
    <div id="title">
        <a href="${ctx}/logout" style="float:right;margin-top:14px"><font size="2">退出登录&nbsp; </font></a>
        <span class="pull-right" style="margin:14px 8px 0 0"> ${date}&nbsp;&nbsp;${welInfo}</span>

        <h1>
            MVCDemo
            <small>--CRUD管理界面演示
                <%--<c:forEach items="${date}" var="l">--%>
                    <%--<rc:rcDate value="${l}" format="yyyy/MM/dd hh:mm:ss"/>--%>
                <%--</c:forEach>--%>
                <s:iterator value="#request.test2" >
                    <rc:rcDate format="yyyy/MM/dd hh:mm:ss" />
                </s:iterator>
                <s:iterator value="#request.test3"  var="tt">
                    <rc:rcDate format="yyyy/MM/dd hh:mm:ss" name="createTime"/>
                </s:iterator>
                <rc:rcDate format="yy-MM-dd" name="t1"/>
                <rc:rcDate format="yy-MM-dd" value="${t1}"/>
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


