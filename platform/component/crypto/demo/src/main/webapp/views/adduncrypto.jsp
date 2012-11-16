<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://mvc.one.sinosoft.com/crypto/inputs" prefix="x"%>
<%@ taglib uri="http://mvc.one.sinosoft.com/crypto/form" prefix="f"%>
<%@ taglib uri="http://mvc.one.sinosoft.com/crypto/commons" prefix="co"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="${ctx}/js/jquery-1.7.1.js"></script>

    <script type="text/javascript" src="${ctx}/js/cryptocore.js"></script>

    <script type="text/javascript" src="${ctx}/js/crypto_codec.js"></script>
    <script type="text/javascript">
        var kkk = "${sessionScope.crypto_key_attr_name}";
        function decodefrom() {
            $.ajax({
                url:"/demo/ajaxParam",
                type:"post",
                dataType:"json",
                data : {
                    id:"NjcaB4I7UxI=",
                    name:"NjcaB4I7UxI=",
                    address:[{
                        add1:"NjcaB4I7UxI=",
                        add2:"NjcaB4I7UxI=",
                        add3:"NjcaB4I7UxI="
                    },{
                        add1:"NjcaB4I7UxI=",
                        add2:"NjcaB4I7UxI=",
                        add3:"NjcaB4I7UxI="
                    }]
                },
                success : function (data){
                    alert(data);
                }
            });
        }

        function ss(){
            alert("ss")
            return false;
        }


    </script>
    <title>uncrypto</title>
</head>

<body>
    plainText:<br/>


    <h3 id="key">${sessionScope.crypto_key_attr_name}</h3>
    <h5 id="crypto_names">${crypto_plugin_uncrypto_attr_names}</h5>
    <form id="fff" action="/demo/testAddedUncrypto" method="post"
          onsubmit="<f:cryptoForm formId="fff" includes="email" />" >

        id:<input id="id" name="id" value="${user.id}"/><br/>
        name:<input name="name" value="${user.name}"/><br/>
        email:<input name="email" value="${user.email}"/><br/>
        info:<input name="info" value="${user.info}"/><br/>
        info2:<input name="info2" value="${user.info2}"/><br/>
        info3:<input name="info3" value="${user.info3}"/><br/>

        <input type="submit" value="加密提交" />
    </form>

    <tr>
        <td class="top"></td>
        <td class="top"></td>
        <td class="top"></td>
        <td class="top"></td>
        <td class="top"></td>
        <td class="top"></td>
        <td name="aaa"></td>
        <td name="aaa"></td>
        <td name="aaa"></td>
        <td name="aaa"></td>
        <td name="aaa"></td>
        <td name="aaa"></td>
        <td name="aaa"></td>
        <td name="aaa"></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>

    <x:inputs/>
    <co:unCmn eIds="un1,un2,un3,un4" attrs_name="name,class" attrs_value="top,aaa"/>



</body>
</html>