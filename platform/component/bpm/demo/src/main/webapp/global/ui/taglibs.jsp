<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
    var contextRootPath = "${ctx}";
</script>

<%
    request.setCharacterEncoding("UTF-8");
    response.setHeader("Cache-Control", "No-Cache");//HTTP 1.1
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
