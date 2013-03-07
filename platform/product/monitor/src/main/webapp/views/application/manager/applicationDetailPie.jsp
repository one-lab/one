<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script language="javascript" src="${ctx}/global/js/apmservice/apmservice.js" />
<table class="pie_table">
    <tr class="pie_head">
        <td>今天可用性</td>
        <td>今天健康状态</td>
    </tr>
    <tr>
        <td class="pie"><div id="pie_availability"></div></td>
        <td class="pie"><div id="pie_health"></div></td>
    </tr>
    <tr>
        <td>
            <input type="hidden" id="availabilityValue" value="${availabilityValue}">
            <input type="hidden" id="healthValue" value="${healthValue}">
        </td>
        <td>&nbsp;</td>
    </tr>
</table>
