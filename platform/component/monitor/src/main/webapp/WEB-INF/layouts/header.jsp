<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<div id="header" class="span12">
    <div id="title">
        <a href="${ctx}/logout" style="float:right;margin-top:14px"><font size="2">退出登录&nbsp; </font></a>
        <span class="pull-right" style="margin:14px 8px 0 0"> ${date}&nbsp;&nbsp;${welInfo}</span>
        <h1>
         	   监控系统配置管理页面
        </h1>
    </div>

    <div id="menu">
        <ul class="nav nav-tabs">
            <li class="active"><a href="${ctx}/login">登录</a></li>
            <li id="user-tab"><a href="${ctx}/account/user/list">用户管理</a></li>
            <li id="url-tab"><a href="${ctx}/notification/urlConfigure/listAll">时效性及资源扫面配置</a></li>
            <li id="emailAndSms-tab"><a href="${ctx}/email_sms/emailSms/list">预警对象配置</a></li>
            <li id="warn-tab"><a href="${ctx}/notification/notification/listAll">预警信息</a></li>
        </ul>
    </div>
</div>