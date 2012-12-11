<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>QSL查询方式演示</title>
    <%@ include file="/WEB-INF/layouts/base.jsp"%>
    <script type="text/javascript">
        $(document).ready(function() {
            //聚焦第一个输入框
            $("#qsl-tab").addClass("active");
        });

    </script>


</head>

<body>
<div class="container">
    <%@ include file="/WEB-INF/layouts/header.jsp"%>
    <div id="view" class="span12" >
        <form name="form" action="qslListResult" method="post">
            用户名：<input name="mapa:name" id="name" type="text" />
            用户邮箱：<input name="mapa:email" id="email" type="text" /></br>
            用户ID：<input name="mapa:id" id="idFrom" type="text" />
            <input type="submit"  onClick="viewUser();" value="查询" />
        </form>
    </div>
    <div id="view" class="span12" >
            <table id="contentTable"
                   class="table table-striped table-bordered table-condensed">
                <thead>
                <tr>
                    <th>用户ID</th>
                    <th>用户名</th>
                    <th>登录名</th>
                    <th>邮箱</th>
                    <th>创建时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.loginName}</td>
                        <td>${user.email}</td>
                        <td>${user.createTime}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
    </div>
    <%@ include file="/WEB-INF/layouts/footer.jsp"%>
</div>
<script type="text/javascript">
    var viewUser=function () {
        $("#view").show();
    }
</script>

</body>
</html>
