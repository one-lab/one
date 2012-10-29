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
    <script type="text/javascript" src="${ctx}/static/js/sinosoft.window.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/sinosoft.message.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#grid").Grid({
                type : "post",
                url : "${ctx}/account/user/viewUserInfo",
                dataType: "json",
                height: 'auto',
                colums:[
                    {id:'1',text:'员工编号',name:"appellation",width:'120',index:'1',align:'',color:''},
                    {id:'2',text:'员工姓名',name:"Status",width:'90',index:'1',align:'',color:'green'},
                    {id:'3',text:'归属机构',name:"Version",index:'1',align:'',color:''},
                    {id:'4',text:'已引入机构',name:"degrees",index:'1',align:'',color:''},
                    {id:'5',text:'操作',name:"degrees",index:'1',align:'',color:''}
                ],
                rowNum:10,
                sorts:false,
                pager : true,
                number:false,
                multiselect: false
            });
            //$("#grid > table .dis").tips({type:"toolTip",tipPostion:"left"});
        });
        function openWindow(){
            $("body").window({
                "id":"window1",
                "title":"姓名：张山  编号：10009999000",
                "content":"<h4>已引入机构</h4><ul class='jigou'><li>财产保险公司天津分公司</li><li>财产保险公司天津分公司</li><li>财产保险公司天津分公司</li></ul>",
                "width":225,
                "height":380,
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
        }
        function openQX() {
            $("body").window({
                "id":"window1",
                "url":"${ctx}/views/account/permissionSettings.jsp",
                "title":"权限设置",
                "hasIFrame":true,
                "content":"",
                "width":1080,
                "height":480,
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
        }

        function openSJ() {
            $("body").window({
                "id":"window1",
                "url":"${ctx}/views/account/dataSet.jsp",
                "title":"数据设置",
                "hasIFrame":true,
                "content":"",
                "width":820,
                "height":450,
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
                }, {
                    "id": "btTwo",
                    "class": "def_btn",
                    "value": "关 闭",
                    "btFun": function() {
                        $("#window1").remove();
                        $(".all_shadow").remove();
                    }
                }
                ]
            });
        }
    </script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td width="40%" align="right"><input type="text" value="请输入员工编号" class="seach_text" /></td>
        <td>&nbsp;</td>
        <td><input type="text" value="请输入机构代码" class="seach_text" /></td>
        <td>&nbsp;</td>
        <td><input type="button" value=" " class="seach_btn" /></td>
    </tr>
    <tr>
        <td align="right">&nbsp;</td>
        <td>&nbsp;</td>
        <td width="50">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
</table>
<div id="grid"></div>
</body>
</html>
