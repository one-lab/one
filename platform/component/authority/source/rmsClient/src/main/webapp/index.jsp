<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<script >
function login(){
window.location.href='${pageContext.request.contextPath }'+'/login.jsp';
}
</script>
<body onload="login();">
</body>
</html>
