<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>权限管理-功能菜单管理</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/static/css/sinosoft.base.css" />
    <link type="text/css" rel="stylesheet" href="${ctx}/static/css/sinosoft.tree2.css" />
    <link type="text/css" rel="stylesheet" href="${ctx}/static/css/sinosoft.grid.css" />
    <script type="text/javascript" src="${ctx}/static/js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/sinosoft.tree.js"></script>
    <script language="javascript" src="${ctx}/static/js/sinosoft.grid.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/sinosoft.mouseoutclick.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#treeTow").jstree({
                "themes" : {
                    "theme" : "default",
                    "dots" : false
                },
                "json_data" : {
                    "ajax" : {
                        "url" : "${ctx}/static/html/tree.json"
                    }
                },
                "plugins" : [ "themes", "json_data", "checkbox", "ui" ]
            });
            fitHeight();
            $("#grid").Grid({
                url : "${ctx}/static/html/grid2.json",
                dataType: "json",
                height: 220,
                colums:[
                    {id:'1',text:'角色名称',name:"appellation",index:'1',align:'',color:''},
                    {id:'2',text:'角色编号',name:"Status",index:'1',align:'',color:''},
                    {id:'3',text:'创建日期',name:"Version",index:'1',align:'',color:''},
                    {id:'4',text:'修改日期',name:"degrees",index:'1',align:'',color:''}
                ],
                rowNum:2,
                sorts:false,
                pager : true,
                number:false,
                multiselect: true
            });
        });
        function fitHeight(){
            var pageHeight = $(document).height() - 102;
            $("#treeOne").height(pageHeight);
            $("#treeTow").height(pageHeight);
        };
    </script>
</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" class="authorize">
    <tr>
        <td width="568" colspan="3" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="info_form add_user">
            <tr>
                <td align="right">角色名称：</td>
                <td><input type="text" style="width:160px;" /></td>
                <td>类型：</td>
                <td><select name="select2">
                    <option>默认类型</option>
                    <option>所有可见类型</option>
                </select></td>
            </tr>
            <tr>
                <td align="right">角色描述：</td>
                <td colspan="3"><textarea name="textarea" cols="30" rows="1" style="width:90%;"></textarea></td>
            </tr>
        </table></td>
    </tr>
    <tr>
        <td colspan="3" valign="top">
            <div id="grid"></div>
        </td>
    </tr>
</table>
</body>
</html>
