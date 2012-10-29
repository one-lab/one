<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>权限管理-功能菜单管理</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/static/css/sinosoft.base.css" />
    <link type="text/css" rel="stylesheet" href="${ctx}/static/css/sinosoft.tree.css" />
    <link type="text/css" rel="stylesheet" href="${ctx}/static/css/sinosoft.grid.css" />
    <link type="text/css" rel="stylesheet" href="${ctx}/static/css/sinosoft.window.css" />
    <link type="text/css" rel="stylesheet" href="${ctx}/static/css/sinosoft.message.css" />
    <script type="text/javascript" src="${ctx}/static/js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/sinosoft.tree.js"></script>
    <script language="javascript" src="${ctx}/static/js/sinosoft.grid.js"></script>
    <script language="javascript" src="${ctx}/static/js/sinosoft.tips.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/sinosoft.mouseoutclick.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/sinosoft.message.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/sinosoft.window.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#grid").Grid({
                url : "${ctx}/static/html/grid2.json",
                dataType: "json",
                height: 240,
                colums:[
                    {id:'1',text:'角色名称',name:"appellation",width:'120',index:'1',align:'',color:''},
                    {id:'2',text:'角色编号',name:"Status",width:'90',index:'1',align:'',color:''},
                    {id:'3',text:'创建日期',name:"Version",index:'1',align:'',color:''},
                    {id:'4',text:'修改日期',name:"degrees",index:'1',align:'',color:''},
                    {id:'5',text:'操作',name:"degrees",index:'1',align:'',color:''}
                ],
                rowNum:10,
                sorts:false,
                pager : true,
                number:true,
                multiselect: false
            });
            //$("#grid > table .dis").tips({type:"toolTip",tipPostion:"left"});
            var windowBox;
        });
        function openWindow(){
            $("body").window({
                "id":"window1",
                "url":"${ctx}/views/account/addPeople.jsp",
                "title":"角色管理",
                "content":"",
                "hasIFrame":true,
                "width":600,
                "height":450,
                "resizing":false,
                "diyButton":[{
                    "id": "btOne",
                    "class": "def_btn",
                    "value": "保 存",
                    "btFun": function() {
                        msgSuccess("", "保存成功！");
                        $("#window1").remove();
                        $(".all_shadow").remove();
                    }
                }, {
                    "id": "btTwo",
                    "class": "def_btn",
                    "value": "取 消",
                    "btFun": function() {
                        $("#window1").remove();
                        $(".all_shadow").remove();
                    }
                }
                ]
            });
        };
        function delRow(e){
            var row = $(e).parents('tr');
            row.remove();
            msgSuccess("", "删除成功！");
        }
    </script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td align="right">角色名称：</td>
        <td width="180"><input type="text" value="" class="seach_text" /></td>
        <td width="120"><input type="button" value=" " class="seach_btn" /></td>
        <td>
            <input type="button" class="new_btn" value="增 加" onclick="openWindow()" />
        </td>
    </tr>
    <tr>
        <td align="right">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
</table>
<div id="grid"></div>
</body>
</html>
