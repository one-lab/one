<%@ taglib prefix="xx" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script type="text/javascript">
        var enText = "";
        var dnText = "";
        var enText2 = "";
        var dnText2 = "";
        var data = 'a string data';

        $(function () {
            var strkey = $("#pass").val();
            key = mvc.crypto.hex.decode(strkey);

            var buffer = mvc.crypto.base64Ints.decode($(".plainText").val());
            mvc.crypto.xxtea.decryptInPlace(buffer, key);
            var clear64 = mvc.crypto.ascii.fromInts(buffer);
            var clear = Base64.decode(clear64);
            $(".plainText").val(clear);
            $(".en").bind("click", function () {

                data = $(".plainText").val();

                var data64 = Base64.encode(data);

                $("#detailtext").val($("#detailtext").val()+"\n"+data64);
                $("#detailtext").val($("#detailtext").val()+"\n"+Base64.decode(data64));
                var buffer = mvc.crypto.ascii.toInts(data64);
                enText = mvc.crypto.xxtea.encryptInPlace(buffer, key);
                var b64 = mvc.crypto.base64Ints.encode(buffer);

                $(".miwen").val(enText);
                $(".miwen2").val(b64);

                $.ajax({
                    url:"/demo/send",
                    type:"post",
                    data:{
                        data:b64
                    },
                    success : function (data) {
                        $(".result").val(data);
                    },
                    error : function() {
                        alert("error");
                    }
                });
            });

        });
    </script>
    <title>XXTEA</title>
</head>

<body>
    plainText:<br/>

    <h3>${sessionId}</h3>
    <h3>${md5}</h3>

    ${user.id}
    ${user.name}
    password:<input class="password" id="pass" style="width: 400px;" value="${md5}" type="text"/>
    <input class="en" type="button" value="加密"/>
    <input class="dn" type="button" value="解密"/>
    <br/>
    <textarea class="plainText" rows="6" cols="100">${crpydata}</textarea>
    <br/>
    加密之后的密文：<br/>
    <textarea class="miwen" rows="6" cols="100"></textarea><br/>
    <textarea class="miwen2" rows="6" cols="100"></textarea><br/>

    result:<br/>
    <textarea class="result" rows="6" cols="100"></textarea>
    <textarea id="detailtext"  rows="6" cols="100"></textarea>


</body>
</html>