<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://mvc.one.sinosoft.com/crypto/inputs" prefix="x"%>
<%@ taglib uri="http://mvc.one.sinosoft.com/crypto/form" prefix="f"%>
<%@ taglib uri="http://mvc.one.sinosoft.com/crypto/commons" prefix="co"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="/demo/js/jquery-1.7.1.js"></script>

    <script type="text/javascript" src="/demo/js/crypto_js/crypto.js"></script>
    <script type="text/javascript" src="/demo/js/crypto_js/ascii.js"></script>
    <script type="text/javascript" src="/demo/js/crypto_js/base64Ints.js"></script>
    <script type="text/javascript" src="/demo/js/crypto_js/hex.js"></script>
    <script type="text/javascript" src="/demo/js/crypto_js/base64.js"></script>
    <script type="text/javascript" src="/demo/js/crypto_js/xxtea.js"></script>
    <script type="text/javascript" src="/demo/js/crypto_js/crypto_codec.js"></script>
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
    <form id="fff" action="/demo/ajaxParam" method="post"
          onsubmit="<f:cryptoForm formId="fff" includes="id,name" />" >

        id:<input id="id" name="id" value="${user.id}"/><br/>
        name:<input name="name" value="${user.name}"/><br/>
        email:<input name="email" value="${user.email}"/><br/>
        info:<input name="info" value="${user.info}"/><br/>
        info2:<input name="info2" value="${user.info2}"/><br/>
        info3:<input name="info3" value="${user.info3}"/><br/>

        <input type="submit" value="解密" />
    </form>
    <div>
        <textarea id="un1" >${user.info}</textarea><br/>
        <span  id="un2">${user.info}</span><br/>
        <table>
            <tr>
                <td id="un3">${user.info}</td>
            </tr>
        </table>
        <div id="un4">${user.info}</div>

    </div>

    <x:inputs/>
    <co:unCmn eIds="un1,un2,un3,un4"/>


</body>
</html>