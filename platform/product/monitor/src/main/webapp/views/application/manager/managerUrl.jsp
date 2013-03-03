<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看预警配置文件</title>
<link href="${ctx}/global/css/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/sinosoft.message.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/sinosoft.grid.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/sinosoft.window.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/manageBusScene/manageBusScene.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="${ctx}/global/js/jquery-1.7.1.js"></script>
<script language="javascript" src="${ctx}/global/js/sinosoft.layout.js"></script>
<script language="javascript" src="${ctx}/global/js/sinosoft.grid.js"></script>
<script language="javascript" src="${ctx}/global/js/sinosoft.window.js"></script>
<script language="javascript" src="${ctx}/global/js/sinosoft.message.js"></script>
<script type="text/javascript">
$(function(){
	$("body").layout({
		top:{topHeight:100},
		bottom:{bottomHeight:30}
	});
	$("#thresholdList").Grid({
        type:"post",
		url : "${ctx}/application/manager/urlmanager/urllist/${bizScenarioId}",
		dataType: "json",
		colDisplay: false,  
		clickSelect: true,
		draggable:false,
		height: "auto",  
		colums:[  
			{id:'1',text:'URL地址',name:"url",index:'1',align:''},
			{id:'2',text:'名称',name:"description",index:'1',align:''},
			{id:'3',text:'可用性',name:"status",index:'1',align:''},
			{id:'4',text:'健康状态',name:"threshold",index:'1',align:''},
			{id:'5',text:'操作',name:"operation",index:'1',align:''}
		],  
		rowNum:9999,
		pager : false,
		number:false,  
		multiselect: true  
	});
	$("#myDesk").height($("#layout_center").height());
	$("#nav").delegate('li', 'mouseover mouseout', navHover);
	$("#nav,#menu").delegate('li', 'click', navClick);
});
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
function delRow(e){
	var rows = $(e).parent().parent();
	var id = rows.attr('id');
	msgConfirm('系统消息','确定要删除该条配置文件吗？',function(){
		msgSuccess("系统消息", "操作成功，配置已删除！");
		alert(id);
		rows.remove();
	});
}
function eidRow(e){
    var rows = $(e).parent().parent();
    var id = rows.attr('id');
    /*id前面多了“rows”*/
    var urlId=id.substr(4,32);
    /*管理method页面*/
    window.location.href="${ctx}/application/manager/methodmanager/methodlist/"+urlId;
}
function batchDel(){
	var $g = $("#thresholdList div.grid_view > table");
	var selecteds = $("td.multiple :checked",$g);
	if(selecteds.length > 0){
		msgConfirm('系统消息','确定要删除该条配置文件吗？',function(){
			var checks = [];
			selecteds.each(function(){
				var rows = $(this).parent().parent();
				checks.push(rows.attr('id'));
				rows.remove();
			});
			alert(checks);
			msgSuccess("系统消息", "操作成功，配置已删除！");
		});
	}else{
		msgAlert('系统消息','没有选中的文件！<br />请选择要删除的文件后，继续操作。')
	};
}
</script>
</head>

<body>
<div id="layout_top">
	<div class="header">
    	<p class="user">您好,系统管理员 <span>|</span> <a href="#">退出系统</a></p>
    	<div class="menu_box">
        	<ul class="nav" id="nav">
            	<li><a href="index.html">首页</a></li>
                <li class="has_sub">
                	<a href="javascript:viod(0)">监视器</a><span class="show_sub_anv"></span>
                	<ul class="add_sub_menu" id="subNav">
                    	<li class="action"><span class="sever">操作系统</span>
                        	<ul class="list">
                            	<li><a href="javascript:viod(0)">操作系统1</a></li>
                                <li><a href="javascript:viod(0)">操作系统2</a></li>
                            </ul>
                        </li>
                        <li class="action"><span class="system">应用系统</span>
                        	<ul class="list">
                            	<li><a href="javascript:viod(0)">在线投保</a></li>
                                <li><a href="javascript:viod(0)">在线查询</a></li>
                                <li><a href="javascript:viod(0)">应急处置</a></li>
                                <li><a href="javascript:viod(0)">人员角色管理</a></li>
                            </ul>
                        </li>
                        <li class="action" style="border:none"><span>数据库</span>
                        	<ul class="list">
                            	<li><a href="javascript:viod(0)">SQL DBA</a></li>
                                <li><a href="javascript:viod(0)">SQL SYS</a></li>
                            </ul>
                        </li>
                        <li class="clear"></li>
                    </ul>
                    
                </li>
                <li><a href="${ctx}/application/manager/appmanager/applist">应用性能</a></li>
                <li><a href="javascript:viod(0)">业务仿真</a></li>
                <li><a href="javascript:viod(0)">告警</a></li>
            </ul>
        </div>
        <ul class="add_menu" id="menu">
        	<li><a href="addMonitorList.html">新建监视器</a></li>
            <li><a href="javascript:viod(0)">配置监视器</a></li>
            <li class="has_sub">
            	<a href="javascript:viod(0)"><span>预警对象管理</span></a>
            	<ul class="add_sub_menu">
                	<li class="title"><a href="javascript:viod(0)">显示动作</a></li>
                    <li class="action">创建新动作</li>
                    <li><a class="sms" href="javascript:viod(0)">短信动作</a></li>
                    <li><a class="email" href="javascript:viod(0)">邮件动作</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<div id="layout_center">
	<div class="main">
    	<div class="threshold_file">
       	  <h2 class="title2"><b>业务场景名:${bizScenarioName}</b></h2>
          <div class="tool_bar_top">
          	<a href="${ctx}/application/manager/urlmanager/createurl/${bizScenarioId}" class="add_bus_scene" >添加url</a>
          	<a href="javascript:void(0);" class="batch_del" onclick="batchDel()">批量删除</a>
          </div>
          <div id="thresholdList"></div>
          <div class="tool_bar"></div>
        </div>
    </div>
</div>
<div id="layout_bottom">
	<p class="footer">Copyright &copy; 2013 Sinosoft Co.,Lt</p>
</div>
</body>
</html>
