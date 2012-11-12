<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>MYSQL存储过程演示</title>
    <%@ include file="/WEB-INF/layouts/base.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            //聚焦第一个输入框
            $("#mysqlProcedure-tab").addClass("active");
        });

    </script>


</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/layouts/header.jsp" %>
    <div id="view" class="span12">
        <form name="form" action="selectUserWithMysqlProResult" method="post">
            用户ID：<input name="id" id="idFrom" type="text"/>
            用户名：<input name="name" id="nameForm" type="text"/>
            <input type="submit" onClick="viewUser();" value="查询"/>
        </form>
    </div>
    <div id="view" class="span12">
        <div>
            <table id="contentTable1" class="table table-striped table-bordered table-condensed">
                <thead>
                <tr>
                    <th>用户ID个数</th>
                    <th>用户名个数</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ids}" var="id">
                    <tr>
                        <td>${id}</td>
                        <td>${names}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div>
            <table id="contentTable3" class="table table-striped table-bordered table-condensed">
                <thead>
                <tr>
                    <th>用户ID</th>
                    <th>用户电话</th>
                    <th>用户身份证号</th>
                    <th>用户性别</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userInfos}" var="userInfo">
                    <tr>
                        <td>${userInfo.userId}</td>
                        <td>${userInfo.phone}</td>
                        <td>${userInfo.idcode}</td>
                        <td>${userInfo.gender}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
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
