<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>ORACLE存储过程演示</title>
    <%@ include file="/WEB-INF/layouts/base.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            //聚焦第一个输入框
            $("#oracleprocedure-tab").addClass("active");
        });

    </script>


</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/layouts/header.jsp" %>
    <div id="view" class="span12">
        <form name="form" action="selectUserWithProResult" method="post">
            用户ID：<input name="id" id="idFrom" type="text"/>
            用户名：<input name="name" id="nameForm" type="text"/>
            <input type="submit" onClick="viewUser();" value="查询"/>
        </form>
    </div>
    <div id="view" class="span12">
        <table id="contentTable" class="table table-striped table-bordered table-condensed">
            <div>
                <tr>
                    <th>
                        <table id="contentTable1" class="table table-striped table-bordered table-condensed">
                            <thead>
                            <tr>
                                <th>用户ID</th>
                                <th>用户名</th>
                                <th>登录名</th>
                                <th>邮箱</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.name}</td>
                                    <td>${user.loginName}</td>
                                    <td>${user.email}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </th>
                    <th>
                        <table id="contentTable2" class="table table-striped table-bordered table-condensed">
                            <thead>
                            <tr>
                                <th>电话</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${phones}" var="phone">
                                <tr>
                                    <td>${phone}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </th>
                </tr>
            </div>
        </table>
    </div>
    <%@ include file="/WEB-INF/layouts/footer.jsp" %>
</div>
<script type="text/javascript">
    var viewUser = function () {
        $("#view").show();
    }
</script>
</body>
</html>
