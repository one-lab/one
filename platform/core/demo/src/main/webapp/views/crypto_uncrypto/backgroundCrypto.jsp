<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="one" uri="http://mvc.one.sinosoft.com/uncrypto" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>后端加密前端解密</title>
    <%@ include file="/WEB-INF/layouts/base.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            //聚焦第一个输入框
            $("#backgroundCrypto-tab").addClass("active");
        });

    </script>
</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/layouts/header.jsp" %>
    <div class="span12">
        <p>
            <div style="color: red;">为了演示方便，加密数据展示：</div>
            <div id="encryptoDataShow"></div>
        </p>
    </div>

    <div class="span12">
        <div style="color: #808080"><b>测试1：
        基本数据类型初始化数据：[
        用户名：abc123,
        用户邮箱：email1@demo.com]</b></div>
        <b style="color:red">如果需要解密的是input输入框，输入框必须要有id属性</b>
        <form id="frontendUncrypto1">
            解密后的用户名：<input name="name" id="name" value=""><one:uncrypto value='${name}' id="name" />
            解密后的用户邮箱：<input name="email" id="email" value=""/><one:uncrypto value='${email}' id="email" />
        </form>
    </div>
    <div class="span12">
        <div style="color: #808080"><b>测试2：
        实体数据类型初始化数据：用户[
        登录名：ZhangSan,
        密码：abc123d,
        邮箱：email3@demo.com]</b></div>
        <table id="contentTable"
               class="table table-striped table-bordered table-condensed">
            <thead>
            <tr>
                <th>解密后的登录名</th>
                <th>解密后的密码</th>
                <th>解密后的邮箱</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="loginName"><one:uncrypto value='${user.loginName}' /></td>
                <td class="password"><one:uncrypto value='${user.password}' /></td>
                <td class="email"><one:uncrypto value='${user.email}' /></td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="span12">
        <div style="color: #808080"><b>测试3：
        集合类型初始化数据：<br/>
        用户1：[
        登录名：登录名1！@,
        密码：123.456,
        邮箱：email23@123demo.com]<br />
        用户2：[
        登录名：登录名2!@#$%^&*()[]-=,
        密码：!1q@2w#3e$4r%5t^6y&7u*8i,
        邮箱：email32@demo.com]</b></div>
        <table class="table table-striped table-bordered table-condensed">
            <thead>
            <tr>
                <th>解密后的登录名</th>
                <th>解密后的密码</th>
                <th>解密后的邮箱</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="aUser">
                <tr>
                    <td class="loginName"><one:uncrypto value='${aUser.loginName}' /></td>
                    <td class="password"><one:uncrypto value='${aUser.password}' /></td>
                    <td class="email"><one:uncrypto value='${aUser.email}' /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%@ include file="/WEB-INF/layouts/footer.jsp" %>
</div>
</body>
</html>
