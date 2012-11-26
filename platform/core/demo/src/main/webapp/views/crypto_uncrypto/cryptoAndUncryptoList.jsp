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
    <title>加密解密演示</title>
    <%--<form id="ajaxForm" action="frontendAjaxCrypto" method="post">--%>
    <%@ include file="/WEB-INF/layouts/base.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            //聚焦第一个输入框
            $("#cryptoAndUncrypto-tab").addClass("active");
        });

    </script>
    <script type="text/javascript">
        function sendMessage() {
            var name = $("input:[name='ajaxName']").val();
            var age = $(".input_one").eq(0).val();
            var selectGender = $("select").val();
            if ($("input:[type='checkbox']").attr("checked") == undefined) {
                var checkbox = "no";
            } else {
                var checkbox = $("input:[type='checkbox']").val();
            }
            var textarea = $("#area").val();
            $.packageAjax({
                type:"POST", //请求的方法
                url:"${ctx}/crypto_uncrypto/cryptoUncrypto/frontendAjaxCrypto", //要传递参数使用Ajax进行处理的类名称
                dataType:"json", //返回的数据类型
                data:{
                    name:name,
                    age:age,
                    selectGender:selectGender,
                    checkbox:checkbox,
                    textarea:textarea,
                    children:[
                        {
                            id1:"123",
                            name1:"name111"
                        },
                        {
                            id2:"321",
                            name2:"name222"
                        }
                    ]
                },
                isEncryption:true,
                success:function (data) {
                    if (data != null) {
                        alert("success,解密后的数据（其中children为测试数据）:\n" + data.name);
                    }
                },
                error:function () {
                    alert("Ajax请求数据失败!");
                }
            });
        }

    </script>
</head>
<body>

<input id="key" value="${sessionScope.crypto_key_attr_name}" type="hidden">

<div class="container">
    <%@ include file="/WEB-INF/layouts/header.jsp" %>
    <div>
        <p><span style="color: red;">为了演示方便，在crypto_codec.js和enAndDe.js文件中加入了“alert()”语句，所以页面初始化的弹窗属正常现象</span></p>
    </div>
    <div id="view1" class="span12">
        <form id="frontend1" action="frontendCrypto" method="post"
              onsubmit="<f:cryptoForm formId="frontend1" includes="name"/>">
            用户名：<input name="name" id="name1" type="text"/>
            用户邮箱：<input name="email" id="email1" type="text"/>
            <input type="submit" onClick="viewUser1();" value="前端加密"/>
        </form>
    </div>
    <div id="view1" class="span12">
        <table id="contentTable1"
               class="table table-striped table-bordered table-condensed">
            <thead>
            <h>前端加密，后端不解密，查看是否加密（crypto_config.xml中不配置后端解密的URL）</h>
            <tr>
                <th>前端加密密钥</th>
                <th>后端得到用户名（未解密）</th>
                <th>后端得到用户邮箱（未加密）</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${ciphertext1}</td>
                <td>${name1}</td>
                <td>${email1}</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div id="view2" class="span12">
        <form id="background2" action="backgroundUncrypto" method="post"
              onsubmit="<f:cryptoForm formId="background2" includes="name"/>">
            用户名：<input name="name" id="name2" type="text"/>
            用户邮箱：<input name="email" id="email2" type="text"/>
            <input type="submit" onClick="viewUser2();" value="前端加密后端解密"/>
        </form>
    </div>
    <div id="view2" class="span12">
        <table id="contentTable2"
               class="table table-striped table-bordered table-condensed">
            <thead>
            <h>前端加密，后端解密，查看是否解密（crypto_config.xml中配置后端解密的URL）</h>
            <tr>
                <th>前端加密密钥</th>
                <th>后端得到用户名（已解密）</th>
                <th>后端得到用户邮箱（未加密）</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${ciphertext2}</td>
                <td>${name2}</td>
                <td>${email2}</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div id="view4" class="span12">
        <form id="frontendUncrypto" action="frontendUncrypto" method="post">
            解密后的用户名：<input name="name4" value="${name4}"/>
            解密后的邮箱4：<textarea class="email4" name="email4">${email4}</textarea><br>
            解密后的邮箱5：<textarea class="email5" name="email5">${email5}</textarea>
            <input type="submit" onClick="viewUser3();" value="后端加密前端解密"/>
        </form>
    </div>
    <div id="view5" class="span12">
        <form id="ajaxForm">
            姓名：<input type="text" name="ajaxName"/>
            年龄：<input class="input_one" type="text" name="ajaxAge"/>
            <select name="selectGender">
                <option value="0">男</option>
                <option value="1">女</option>
            </select>
            <input type="checkbox" name="ajaxCheckbox"/>
            <textarea id="area" name="ajaxArea"></textarea>
            <input type="button" value="ajax前端加密" onclick="sendMessage();"/>
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
<script type="text/javascript">
    var viewUser4 = function () {
        $("#view4").show();
    }
</script>
<x:inputs/>
<co:unCmn eClasses="email4,email5"/>
</body>
</html>
