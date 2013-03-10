<%@ page language="java" pageEncoding="UTF-8" %>
<h2 class="title2"><b>新建监视器类型　</b>
    <select id="monitorType" name="monitorType" class="diySelect" onchange="top.location=this.value;">
        <optgroup label="应用服务器">
            <option value="${ctx}/addmonitor/addapp">应用系统</option>
        </optgroup>
        <optgroup label="数据库">
            <option value="${ctx}/addmonitor/addoracle">Oracle</option>
        </optgroup>
        <optgroup label="操作系统">
            <option value="${ctx}/addmonitor/addos">Linux</option>
        </optgroup>
    </select>
</h2>
<script type="text/javascript">
    var  _url = window.location.href;
    var _url2 = _url.substring(_url.lastIndexOf("/")+1);
    if(_url2=="addapp"){
        $("#monitorType").find("optgroup").eq(0).find("option").attr("selected","selected");
    }else if(_url2=="addoracle"){
        $("#monitorType").find("optgroup").eq(1).find("option").attr("selected","selected");
    }else if(_url2=="addos"){
        $("#monitorType").find("optgroup").eq(2).find("option").attr("selected","selected");
    }
</script>