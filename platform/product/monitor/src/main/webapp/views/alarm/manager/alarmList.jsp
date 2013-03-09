<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看预警配置文件</title>
<%@include file="/WEB-INF/layouts/base.jsp"%>
<script type="text/javascript">
$(function(){
	$("body").layout({
		top:{topHeight:100},
		bottom:{bottomHeight:30}
	});
    getAlarmListOfGivenTimeAndType();
	$("#myDesk").height($("#layout_center").height());
	$("#nav").delegate('li', 'mouseover mouseout', navHover);
	$("#nav,#menu").delegate('li', 'click', navClick);
    $("#timeSelect").bind("change",getAlarmListOfGivenTimeAndType);
    $("#typeSelect").bind("change",getAlarmListOfGivenTimeAndType);
});

/*得到指定时间段和指定类型的告警信息列表*/
function getAlarmListOfGivenTimeAndType(){
    var _givenTime=$("#timeSelect").val();
    var _givenType=$("#typeSelect").val();
    var _url="${ctx}/alarm/manager/alarmmanager/alarm";
    /*没有选择*/
    if(''==_givenTime&&''==_givenType){
        _url="${ctx}/alarm/manager/alarmmanager/alarm";
        /*只选择时间段*/
    }else if(''!=_givenTime&&''==_givenType){
        _url="${ctx}/alarm/manager/alarmmanager/onecondition/"+_givenTime;
        /*只选择类型*/
    }else if(''==_givenTime&&''!=_givenType){
        _url="${ctx}/alarm/manager/alarmmanager/onecondition/"+_givenType;
        /*时间和类型都选择*/
    }else{
        _url="${ctx}/alarm/manager/alarmmanager/twocondition/"+_givenTime+"/"+_givenType;
    }
    var $mn = $("#thresholdList");
    //防止每次查询时，表格中的数据不断累积
    $mn.html("");
    $("#thresholdList").Grid({
        type:"post",
        url : _url,
        dataType: "json",
        colDisplay: false,
        clickSelect: true,
        draggable:false,
        height: "auto",
        colums:[
            {id:'1',text:'状态',name:"status",index:'1',align:'',width:'52'},
            {id:'2',text:'消息',name:"message",index:'1',align:''},
            {id:'3',text:'名称',name:"appName",index:'1',align:''},
            {id:'4',text:'类型',name:"monitorType",index:'1',align:''},
            {id:'5',text:'时间',name:"recordTime",index:'1',align:''}/*,
             {id:'6',text:'用户',name:"ownerName",index:'1',align:''}*/
        ],
        rowNum:10,
        pager : true,
        number:false,
        multiselect: true
    });
}
function alarmDetailInfo(e){
    var rows = $(e).parent().parent();
    var id = rows.attr('id');
    /*id前面多了“rows”*/
    var _alarmId=id.substr(4,32);
    /*告警详细信息页面*/
    window.location.href="${ctx}/alarm/manager/alarmmanager/detail/"+_alarmId;
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
function delRow(e){
	var rows = $(e).parent().parent();
	var id = rows.attr('id');
	msgConfirm('系统消息','确定要删除该条配置文件吗？',function(){
		msgSuccess("系统消息", "操作成功，配置已删除！");
		alert(id);
		rows.remove();
	});
}
function batchDel(){
	var $g = $("#thresholdList div.grid_view > table");
	var selecteds = $("td.multiple :checked",$g);
	if(selecteds.length > 0){
		msgConfirm('系统消息','确定要删除该条配置文件吗？',function(){
			var _alarmIds = [];
			selecteds.each(function(){
				var rows = $(this).parent().parent();
                /*id前面多了“rows”*/
                _alarmIds.push(rows.attr('id').substr(4,32));
			});
            $.ajax({
                type:"post",
                url:"${ctx}/alarm/manager/alarmmanager/batchdelete/",
                data:{alarmIds:_alarmIds},
                async:false,
                success:function(data){
                    if("successDeleted"==data){
                        /*selecteds.each(function(){
                            $(this).parent().parent().remove();
                        });*/
                        alert("删除成功");
                        /*调用ajax，重新获得告警信息列表*/
                        getAlarmListOfGivenTimeAndType();
                    }
                },
                error:function(){
                    alert("删除失败");
                }
            });
		});
	}else{
		msgAlert('系统消息','没有选中的文件！<br />请选择要删除的文件后，继续操作。')
	};
}
function viewRelevance(){
	var temWin = $("body").window({
		"id":"window",   
        "title":'根本原因分析',  
		"url":"basicReaon.html",   
        "hasIFrame":true,
		"width": 740,
		"height":440,
		"diyButton":[{
			"id": "btOne",
			"btClass": "buttons",
			"value": "关闭",
			"onclickEvent" : "selectLear",
			"btFun": function() {
					temWin.closeWin();
				}
			}
		]
	});
}
</script>
</head>

<body>
<div id="layout_top">
	<div class="header">
    	<%@include file="/WEB-INF/layouts/menu.jsp"%>
    </div>
</div>
<div id="layout_center">
	<div class="main">
    	<div class="threshold_file alerts">
       	  <h2 class="title2">
          	<strong class="right">筛选表单：
                <select id="timeSelect" name="timeSelect" class="diySelect">
                    <option value="">选择时间</option>
                    <option value="twentyFourHours">最近24小时</option>
                    <option value="thirtyDays">最近30天</option>
                </select>
                <select id="typeSelect" name="typeSelect" class="diySelect">
                    <option value="">选择类型</option>
                    <option value="APPLICATION">应用系统</option>
                    <option value="OS">操作系统</option>
                    <option value="DB">数据库</option>
                </select>
            </strong>
          	<b>告警信息列表　</b>
          </h2>
          <div class="tool_bar_top"><a href="javascript:void(0);" class="batch_del" onclick="batchDel()">批量删除</a></div>
          <div id="thresholdList"></div>
        </div>
    </div>
</div>
<div id="layout_bottom">
	<p class="footer">Copyright &copy; 2013 Sinosoft Co.,Lt</p>
</div>
</body>
</html>
