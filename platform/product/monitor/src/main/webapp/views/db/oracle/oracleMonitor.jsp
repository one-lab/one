<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看预警配置文件</title>
<%@ include file="/WEB-INF/layouts/base.jsp" %>
<link href="${ctx }/global/css/sinosoft.tabs.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="${ctx }/global/js/sinosoft.tabs.js"></script>
<script language="javascript" src="${ctx }/global/js/highcharts.src.js"></script>
<script language="javascript" src="${ctx }/global/js/oracleMonitor.js"></script>
<script type="text/javascript">
var rootPath = '${ctx}';
$(function(){
	$("body").layout({
		top:{topHeight:100},
		bottom:{bottomHeight:30}
	});
	
	$("#thresholdList").Grid({
		url : "oracleMonitor2.json",  
		dataType: "json",
		colDisplay: false,  
		clickSelect: true,
		draggable:false,
		height: "auto",  
		colums:[  
			{id:'1',text:'名称',name:"appellation",index:'1',align:''},
			{id:'2',text:'可用性',name:"appellation",index:'1',align:''},
			{id:'3',text:'健康状态',name:"appellation",index:'1',align:''},
			{id:'4',text:'操作',name:"appellation",index:'1',align:''}
		],  
		rowNum:9999,
		pager : false,
		number:false,  
		multiselect: true  
	});
	
	$("#healthList").Grid({
		url : rootPath+"/db/oracle/healthList",  
		dataType: "json",
		colDisplay: false,  
		clickSelect: true,
		draggable:false,
		height: 'auto',  
		colums: dayColumnStyle,  
		rowNum:9999,
		pager : false,
		number:false,  
		multiselect: false  
	});
	
	$.ajax({
		type:"get",
		dataType: "json",
		url : rootPath+"/db/oracle/performance",  
		success:function(data) {
			$(data).each(function(i, d){
				buildHighchart(d);
			});
		}
	});
	
	$("#tabs").tabs({closeTab:false});
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
<%@include file="/WEB-INF/layouts/menu.jsp" %>
<div id="layout_center">
	<div class="main">
    	<ul class="crumbs">
        	<li><a href="#">监视器</a> ></li>
            <li><b> oracle - 批量配置视图 (总计 3 监视器)</b></li>
        </ul>
        <hr class="top_border" />
        <div id="tabs">
        	<ul>
            	<li class="tabs_select">可用性</li>
                <li>性能</li>
                <li>列表视图</li>
            </ul>
            <div><br />
            	<div class="threshold_file availability">
                  <h2 class="title2"><b>可用性历史纪录- oracle　</b>
                  	<select name="" class="diySelect">
                            <option value="">最近24小时</option>
                            <option value="">最近30天</option>
                    </select>
                  </h2>
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="my_table">
                      <tr>
                        <th width="20%">名称</th>
                        <th width="75%" style="text-align:center">可用性</th>
                        <th>可用性%</th>
                      </tr>
                      <tr>
                        <td>
                        	<a href="oracle.html">oracle1</a>
                        </td>
                        <td><table width="100%" border="0" cellspacing="0" cellpadding="0" class="green_bar">
                          <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td class="not_available">&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                          </tr>
                        </table></td>
                        <td>100</td>
                      </tr>
                      <tr>
                        <td><a href="oracle.html">oracle2</a></td>
                        <td><table width="100%" border="0" cellspacing="0" cellpadding="0" class="green_bar">
                          <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td class="xp_available">&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                          </tr>
                        </table></td>
                        <td>100</td>
                      </tr>
                      <tr class="last_row">
                        <td>&nbsp;</td>
                        <td><table width="100%" border="0" cellspacing="0" cellpadding="0" class="ruler_bar">
                          <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                          </tr>
                        </table></td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr class="last_row">
                        <td>&nbsp;</td>
                        <td><table width="100%" border="0" cellspacing="0" cellpadding="0" class="time_bar">
                          <tr>
                            <td>01:00</td>
                            <td>02:00</td>
                            <td>03:00</td>
                            <td>04:00</td>
                            <td>05:00</td>
                            <td>06:00</td>
                            <td>07:00</td>
                            <td>08:00</td>
                            <td>09:00</td>
                            <td>10:00</td>
                            <td>11:00</td>
                            <td>12:00</td>
                          </tr>
                        </table></td>
                        <td>&nbsp;</td>
                      </tr>
                    </table>
                    <div class="explain">
                    	<ul>
                        	<li><span class="ex_no"></span>不可用</li>
                            <li><span class="ex_is"></span>可用</li>
                            <li><span class="ex_xp"></span>预警</li>
                        </ul>
                    	查看监视器/业务组最近24小时或30天的可用性状态
                    </div>
                </div>
            </div>
            <div>
            	<br />
                <div class="threshold_file">
                	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="my_table">
                      <tr>
                        <td class="group_name"><h3><strong>已用的内存</strong></h3></td>
                        <td class="group_name"><h3><strong>连接时间</strong></h3></td>
                      </tr>
                      <tr>
                        <td width="50%"><div id="memory_utilization"></div></td>
                        <td width="50%"><div id="exchange_utilization"></div></td>
                      </tr>
                      <tr>
                        <td class="group_name"><h3><strong>活动的远程连接数</strong></h3></td>
                        <td class="group_name"><h3><strong>活动的用户连接数</strong></h3></td>
                      </tr>
                      <tr>
                        <td><div id="CPU_utilization"></div></td>
                        <td><div id="reply_utilization"></div></td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                    </table>
                	<div class="threshold_file availability">
                	  <h2 class="title2"><b> 健康状态操控板</b>
                	    <select name="select" class="diySelect">
                	      <option value="">最近24小时</option>
                	      <option value="">最近30天</option>
              	      </select>
              	    </h2>
                	  <div id="healthList"></div>
                	  <div class="explain">
                	    <ul>
                          <li><span class="ex_is"></span>正常</li>
                          <li><span class="ex_xp"></span>警告</li>
                	      <li><span class="ex_no"></span>严重</li>
              	      </ul>
                	     查看监视器/业务组过去24小时或30天的健康状态告警</div>
              	  </div>
                </div>
            </div>
            <div>
            	<br />
                <div class="threshold_file">
                  <h2 class="title2"><b>数据库列表视图　</b></h2>
                  <div class="tool_bar_top"><a href="javascript:void(0);" class="batch_del" onclick="batchDel()">批量删除</a></div>
                  <div id="thresholdList"></div>
                  <div class="tool_bar"></div>
                </div>
            </div>
        </div>
    	
    </div>
</div>
<div id="layout_bottom">
	<p class="footer">Copyright &copy; 2013 Sinosoft Co.,Lt</p>
</div>
</body>
</html>
