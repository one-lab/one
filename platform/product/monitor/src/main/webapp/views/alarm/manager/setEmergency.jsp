<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>配置告警</title>
    <%@ include file="/WEB-INF/layouts/base.jsp"%>
    <script type="text/javascript">
        $(function(){
            $("#monitorType").bind("change",getMonitorNames);
            $("#monitorName").bind("change",getNewGrid);
        });
        function getMonitorNames(){
            $.ajax({
                type:"post",
                url:"${ctx}/alarm/manager/configemergency/monitornames/"+$("#monitorType").val(),
                dataType:"json",
                async:false,
                success:function(data){
                    var $mn = $("#monitorName");
                    //防止每次查询时，表格中的数据不断累积
                    $mn.html("");
                    $("#monitorName").append("<option value='choice' >" +"--选择一个监视器--"+" </option> ");
                    for(var i = 0; i<data.length;i++){
                        var key = "monitorName";
                        var name =data[i].monitorName;
                        $("#monitorName").append("<option value='"+key+"' > "+name+" </option> ");
                    }
                }
            });
        }
        function getNewGrid(_val){
            $("body").layout({
                top:{topHeight:100},
                bottom:{bottomHeight:30}
            });
            $("#myDesk").height($("#layout_center").height());
            $("#nav").delegate('li', 'mouseover mouseout', navHover);
            $("#nav,#menu").delegate('li', 'click', navClick);
            $("#natureList").html("");
            var _resourceType=$("#monitorType").val();
            $("#natureList").Grid({
                type:"post",
                url : "${ctx}/alarm/manager/configemergency/attributenames/"+_resourceType,
                dataType: "json",
                colDisplay: false,
                clickSelect: true,
                draggable:false,
                height: 225,
                colums:[
                    {id:'1',text:'属性名',name:"attributeCn",index:'1',align:''},
                    {id:'2',text:'阈值',name:"threshold",index:'1',align:''},
                    {id:'3',text:'动作',name:"action",index:'1',align:''}
                ],
                rowNum:9999,
                pager : false,
                number:false,
                multiselect: false
            });

        }
        function navHover(){
            $(this).toggleClass("hover")
        }
        function navClick(){
            $(this).addClass("seleck").siblings().removeClass("seleck");
            if($(this).hasClass('has_sub')){
                var subMav = $(this).children("ul.add_sub_menu");
                var isAdd = false;
                if($(this).parent().attr("id") == "menu"){
                    isAdd = true;
                };
                subMav.slideDown('fast',function(){
                    $(document).bind('click',{dom:subMav,add:isAdd},hideNav);
                    return false;
                });
            };
        }
        function hideNav(e){
            var subMenu = e.data.dom;
            var isAdd = e.data.add;
            subMenu.slideUp('fast',function(){
                if(isAdd){
                    subMenu.parent().removeClass('seleck');
                };
            });
            $(document).unbind();
        }
        function setEmergency(){
            var temWin = $("body").window({
                "id":"window",
                "title":'配置告警',
                "url":"setNature.html",
                "hasIFrame":true,
                "width": 740,
                "height":440,
                "diyButton":[{
                    "id": "btOne",
                    "btClass": "buttons",
                    "value": "保存",
                    "onclickEvent" : "selectLear",
                    "btFun": function() {
                        msgSuccess("系统消息", "操作成功，配置已保存！");
                        temWin.closeWin();
                    }
                },
                    {
                        "id": "btOne",
                        "btClass": "buttons",
                        "value": "关闭",
                        "onclickEvent" : "selectLear",
                        "btFun": function() {
                            temWin.closeWin();
                        }
                    },
                    {
                        "id": "btOne",
                        "btClass": "buttons",
                        "value": "删除配置",
                        "onclickEvent" : "selectLear",
                        "btFun": function() {
                            temWin.closeWin();
                        }
                    }
                ]
            });
        };
    </script>
</head>

<body>
<div id="layout_top">
    <div class="header">
        <%@ include file="/WEB-INF/layouts/menu.jsp"%>
    </div>
</div>
<div id="layout_center">
    <div class="main">
        <ul class="crumbs">
            <li><a href="#">管理</a> ></li>
            <li><b>配置告警</b></li>
        </ul>
        <div class="add_monitor set_emergency">
            <h2 class="title2"><b>配置告警</b></h2>
            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="add_monitor_box">
                <tr>
                    <td width="33%"> 选择监视器类型</td>
                    <td><select id="monitorType" name="monitorType"  class="diySelect" style="width:200px">
                        <option value="选择一个监视器类型">--选择一个监视器类型--</option>
                        <option value="应用系统">应用系统</option>
                        <option value="数据库">数据库</option>
                        <option value="操作系统">操作系统</option>
                    </select></td>
                </tr>
                <tr>
                    <td> 监视器</td>
                    <td><select id="monitorName" name="monitorName" class="diySelect" style="width:200px">
                    </select></td>
                </tr>
            </table>
        </div>
        <div class="conf_box">
            <div class="conf_title">
                <div class="conf_title_r"></div>
                <div class="conf_title_l"></div>
                健康状态
            </div>
            <div class="conf_cont_box">
                <div class="conf_cont">
                    <ul>
                        <li><b>动作：</b>配置动作，当产生告警时配置动作将被执行。</li>
                    </ul>
                    <p class="set_etc"><input type="button" class="buttons" onclick="setEmergency()" value="配置健康状态" /><span>动作</span></p>
                </div>
            </div>
        </div>
        <div class="conf_box">
            <div class="conf_title">
                <div class="conf_title_r"></div>
                <div class="conf_title_l"></div>
                可用性
            </div>
            <div class="conf_cont_box">
                <div class="conf_cont">
                    <ul>
                        <li><b>动作：</b>配置动作，当产生告警时配置动作将被执行。</li>
                    </ul>
                    <p class="set_etc"><input type="button" class="buttons" onclick="setEmergency()" value="　配置可用性　" /><span class="is_set">动作</span></p>
                </div>
            </div>
        </div>
        <br />
        <div class="threshold_file">
            <h3 class="title3">配置属性告警：</h3>
            <div id="natureList"></div>
        </div>
    </div>
</div>
<div id="layout_bottom">
    <p class="footer">Copyright &copy; 2013 Sinosoft Co.,Lt</p>
</div>
</body>
</html>
