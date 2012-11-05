<%--
  Created by IntelliJ IDEA.
  User: seline
  Date: 12-9-20
  Time: 下午2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>权限管理系统</title>
    <link href="${ctx}/static/css/sinosoft.base.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/css/sinosoft.layout.css" rel="stylesheet" type="text/css" />
    <script language="javascript" src="${ctx}/static/js/jquery-1.7.1.js"></script>
    <script language="javascript" src="${ctx}/static/js/sinosoft.layout.js"></script>
    <script type="text/javascript">
        $(function(){
            <!--layout控件-->
            $("body").layout({
                top:{topHeight:68,topHide:false,topSwitch:false},
                bottom:{bottomHeight:45,bottomHide:false,bottomSwitch:false}
            });
            alignTop();
            $(window).resize(alignTop);
        });
        function alignTop(){
            var marginTop = $("#layout_center").height()/2 - 180;
            $("#login").css('margin-top',marginTop)
        };
    </script>
    <title>登入页面</title>
</head>
<body>
<div id="layout_top">
    <div class="header">
        <img src="${ctx}/static/images/system/login.gif" class="logo"  />
    </div>
</div>

<!--内容-->
<div id="layout_center" class="login_cont" >
    <div class="login_line" ></div>
    <form action="${ctx}/login/userLogin" id="index" method="post" class="form-horizontal">
    <div class="login" id="login">
        <ul class="list" >
            <li>用户名 <input type="text" class="inp_text" name="loginName" value="${loginName}"/></li>
            <li>密　码 <input type="password" class="inp_text" name="password"/></li>
            <li>机　构
                <select name=""  class="inp_selec">
                    <option>1</option>
                    <option>2</option>
                </select>
            </li>
        </ul>
        <input type="submit" value="" class="login_btn" />
        <p class="prompt">请输入正确的信息进行登录，如果您还没有账号，请联系管理员。</p>
    </div>
    </form>
</div>

<!--版权栏-->
<div id="layout_bottom">
    <p class="copyright">
        <span class="author">技术支持 中科软科技 www.sinofoft.com.cn</span>
        <span class="help">帮助</span>
    </p>
</div>
</body>
</html>