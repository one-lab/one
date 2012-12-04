<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://mvc.one.sinosoft.com/crypto/inputs" prefix="x" %>
<%@ taglib uri="http://mvc.one.sinosoft.com/crypto/form" prefix="f" %>
<%@ taglib uri="http://mvc.one.sinosoft.com/crypto/commons" prefix="co" %>
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
    <div>
        <p><span
                style="color: red;">为了演示方便，在crypto_codec.js和enAndDe.js文件中加入了“alert()”语句，所以页面初始化的弹窗属正常现象（加密数据写在java文件中）</span>
        </p>
    </div>
    <div id="view1" class="span12">
        <form id="frontendUncrypto1">
            form1：<br>
            解密后的用户名：<input name="nameForm1" value="${nameForm1}"/>
        </form>
    </div>
    <div id="view2" class="span12">
        <form id="frontendUncrypto2" action="frontendUncrypto" method="get">
            form2：<br>
            解密后的用户名1：<input name="name1" value="${name1}"/>
            解密后的用户名2：<input name="name2" value="${name2}"/><br>
            解密后的邮箱1：<textarea class="email1" name="email1">${email1}</textarea>
            解密后的邮箱2：<textarea class="email2" name="email2">${email2}</textarea><br>
            解密后的邮箱3：<textarea id="email3">${user.email}</textarea>
            <table id="contentTable"
                   class="table table-striped table-bordered table-condensed">
                <thead>
                <tr>
                    <th>解密后的登录名</th>
                    <th>解密后的密码</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="loginName">${user.loginName}</td>
                    <td class="password">${user.password}</td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
    <%@ include file="/WEB-INF/layouts/footer.jsp" %>
</div>

<script type="text/javascript">
    var viewUser1 = function () {
        $("#view1").show();
    }
</script>
<script type="text/javascript">
    var viewUser2 = function () {
        $("#view2").show();
    }
</script>

<x:inputs formIds="frontendUncrypto1,frontendUncrypto2"/>
<co:unCmn eIds="email3" eClasses="email1,email2,loginName,password"/>
</body>
</html>
