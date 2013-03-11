<%@ page language="java" pageEncoding="UTF-8" %>
<h2 class="title2"><b>新建监视器类型　</b>
    <select id="monitorType" name="monitorType" class="diySelect" onchange="top.location=this.value;">
        <optgroup label="应用服务器">
            <option selected="selected" value="${ctx}/addmonitor/addapp">应用系统　　</option>
        </optgroup>
        <optgroup label="数据库">
            <%--@todo 在这里改成新建数据库页面的url--%>
            <option value="${ctx}/addmonitor/addapp">Oracle</option>
        </optgroup>
        <optgroup label="操作系统">
            <%--@todo 在这里改成新建操作系统页面的url--%>
            <option value="${ctx}/addmonitor/addapp">Linux</option>
        </optgroup>
    </select>
</h2>