<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://mvc.one.sinosoft.com/crypto/form" prefix="f" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>前端加密后端解密</title>
    <%@ include file="/WEB-INF/layouts/base.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            //聚焦第一个输入框
            $("#frontendCrypto-tab").addClass("active");
        });

    </script>
    <script type="text/javascript">
        function sendMessage() {
            var name = $("#ajaxName").val();
            var age = $("#ajaxAge").val();
            var selectGender = $("#selectGender").val();
            var checkbox = "无";
            if ($("input:[type='checkbox']").attr("checked")) {
                checkbox = $("input:[type='checkbox']").val();
            }
            var textarea = $("#ajaxArea").val();
            $.packageAjax({
                type:"POST", //请求的方法
                url:"${ctx}/crypto_uncrypto/cryptoUncrypto/frontendAjaxCrypto", //要传递参数使用Ajax进行处理的类名称
                dataType:"json", //返回的数据类型
                data:{
                    crypto_attributies_names : "name,children.id",
                    name:name,
                    age:age,
                    selectGender:selectGender,
                    checkbox:checkbox,
                    textarea:textarea,
                    children:[
                        {
                            id:123.2,
                            name:"姓名1"
                        },
                        {
                            id:321.3,
                            name:"姓名2"
                        }
                    ]
                },
                isEncryption:true,
                success:function (data) {
                    if (data != null) {
                        $("#ciphertext3Crypto").html(data.key);
                        $("#name3Crypto").html(data.name);
                        $("#age3Crypto").html(data.age);
                        $("#gender3Crypto").html(data.gender);
                        $("#hobbies3Crypto").html(data.hobbies);
                        $("#address3Crypto").html(data.address);
                        $("#children").html(data.children1Id + ":" + data.children1Name + ", " + data.children2Id + ":" + data.children2Name);
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
    <div style="color: #808080"><b>测试1：用户名加密，用户邮箱不加密, 后端没有配置解密URL，所以加密的数据不会解密</b></div>
    <div id="view1" class="span12">
        <form id="frontend1" action="frontendCrypto" method="post"
              onsubmit="<f:cryptoForm formId="frontend1" includes="name"/>">
            用户名：<input name="name" id="name1" type="text" />
            用户邮箱：<input name="email" id="email1" type="text" />

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

    <br/>
    <div style="color: #808080"><b>测试2：用户名加密，用户邮箱不加密, 后端配置解密URL，所以加密的数据会解密</b></div>

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

    <div style="color: #808080"><b>测试3：Ajax前端加密, 后端配置解密URL，所以加密的数据会解密</b></div>
    <div id="view3" class="span12">
        <form id="ajaxForm">
            <div>姓名：<input type="text" name="ajaxName" id="ajaxName"/></div>
            <div>年龄：<input class="input_one" type="text" name="ajaxAge" id="ajaxAge"/></div>
            <div>性别：
                <select name="selectGender" id="selectGender">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
            <div>兴趣爱好：<input type="checkbox" name="ajaxCheckbox" value="足球"/>足球
                      <input type="checkbox" name="ajaxCheckbox" value="游泳"/>游泳
            </div>
            <div>家庭住址：<textarea id="ajaxArea" name="ajaxArea"></textarea></div>
            <input type="button" value="ajax前端加密" onclick="sendMessage();"/>
        </form>
    </div>

    <div id="view4" class="span12">
        <table id="contentTable3"
               class="table table-striped table-bordered table-condensed">
            <thead>
            <h>前端加密，后端解密，查看是否解密（crypto_config.xml中配置后端解密的URL）</h>
            <tr>
                <th>前端加密密钥</th>
                <th>后端姓名</th>
                <th>后端年龄</th>
                <th>后端性别</th>
                <th>兴趣爱好</th>
                <th>家庭住址</th>
                <th>children</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td id="ciphertext3Crypto"></td>
                <td id="name3Crypto"></td>
                <td id="age3Crypto"></td>
                <td id="gender3Crypto"></td>
                <td id="hobbies3Crypto"></td>
                <td id="address3Crypto"></td>
                <td id="children"></td>
            </tr>
            </tbody>
        </table>
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
    var viewUser3 = function () {
        $("#view3").show();
    }
</script>
</body>
</html>
