<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>monitor监控系统</title>
<link href="${ctx}/global/css/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/oracle.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/sinosoft.grid.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/sinosoft.tabs.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="${ctx}/global/js/jquery-1.7.1.js"></script>
<script language="javascript" src="${ctx}/global/js/sinosoft.layout.js"></script>
<script language="javascript" src="${ctx}/global/js/sinosoft.grid.js"></script>
<script language="javascript" src="${ctx}/global/js/highcharts.src.js"></script>
<script language="javascript" src="${ctx}/global/js/highcharts-more.js"></script>
<script language="javascript" src="${ctx}/global/js/sinosoft.tabs.js"></script>
<script language="javascript" src="${ctx}/global/js/oracle.js"></script>
<script type="text/javascript">
$(function(){
	$("body").layout({
		top:{topHeight:100},
		bottom:{bottomHeight:30}
	});
	$("#myDesk").height($("#layout_center").height());
	$("#nav").delegate('li', 'mouseover mouseout', navHover);
	$("#nav,#menu").delegate('li', 'click', navClick);
	
	$("#table_space_detail").Grid({
		url : "oracle.json",
		dataType: "json",
		height: 'auto',
		colums:[
			{id:'1',text:'名称',name:"methodName",width:'',index:'1',align:'',color:''},
			{id:'2',text:'表空间使用情况',name:"maxTime",width:'300',index:'1',align:'',color:''},
			{id:'3',text:'总空间大小(MB) ',name:"minTime",width:'',index:'1',align:'',color:''},
			{id:'4',text:'总块数',name:"avgTime",width:'',index:'1',align:'',color:''},
			{id:'5',text:'已使用(MB) ',name:"status",width:'',index:'1',align:'',color:''},
            {id:'6',text:'已用百分比 ',name:"status",width:'',index:'1',align:'',color:''},
            {id:'7',text:'未使用 ',name:"status",width:'',index:'1',align:'',color:''},
			{id:'8',text:'可用百分比',name:"status",width:'',index:'1',align:'',color:''}
		],
		rowNum:10,
		rowList:[10,20,30],
		pager : false,
		number:false,
		multiselect:true
	});
	
//	$("#table_space_status").Grid({
//		url : "oracle2.json",
//		dataType: "json",
//		height: 'auto',
//		colums:[
//			{id:'1',text:'名称',name:"methodName",width:'',index:'1',align:'',color:''},
//			{id:'2',text:'状态',name:"maxTime",width:'300',index:'1',align:'',color:''},
//			{id:'3',text:' 	数据文件 ',name:"minTime",width:'',index:'1',align:'',color:''},
//			{id:'4',text:'读次数/分 ',name:"avgTime",width:'',index:'1',align:'',color:''},
//			{id:'5',text:'写次数/分',name:"status",width:'',index:'1',align:'',color:''},
//			{id:'6',text:'读时间 ',name:"status",width:'',index:'1',align:'',color:''},
//			{id:'7',text:'写时间 ',name:"status",width:'',index:'1',align:'',color:''},
//			{id:'8',text:'健康状况',name:"status",width:'',index:'1',align:'',color:''},
//			{id:'9',text:'告警配置',name:"status",width:'',index:'1',align:'right',color:''}
//		],
//		rowNum:10,
//		rowList:[10,20,30],
//		pager : false,
//		number:false,
//		multiselect:true
//	});
	
//	$("#table_space_performance").Grid({
//		url : "oracle1.json",
//		dataType: "json",
//		height: 'auto',
//		colums:[
//			{id:'1',text:'数据文件名 ',name:"methodName",width:'',index:'1',align:'',color:''},
//			{id:'2',text:'表空间名  ',name:"maxTime",width:'300',index:'1',align:'',color:''},
//			{id:'3',text:'状态',name:"minTime",width:'',index:'1',align:'',color:''},
//			{id:'4',text:'自动扩展',name:"avgTime",width:'',index:'1',align:'',color:''},
//			{id:'5',text:'数据文件大小 (MB)',name:"status",width:'',index:'1',align:'',color:''},
//			{id:'6',text:'读次数 ',name:"status",width:'',index:'1',align:'',color:''},
//			{id:'7',text:'写次数  ',name:"status",width:'',index:'1',align:'',color:''},
//			{id:'8',text:'平均读时间 (ms)  ',name:"status",width:'',index:'1',align:'',color:''},
//			{id:'9',text:'健康状况',name:"status",width:'',index:'1',align:'',color:''},
//			{id:'10',text:'告警配置',name:"status",width:'',index:'1',align:'',color:''}
//		],
//		rowNum:10,
//		rowList:[10,20,30],
//		pager : false,
//		number:false,
//		multiselect:true
//	});
	
		$("#sga_detail").Grid({
		url : "oracle3.json",
		dataType: "json",
		height: 'auto',
		colums:[
			{id:'1',text:'属性 ',name:"methodName",width:'',align:'',color:''},
			{id:'2',text:'值  ',name:"maxTime",width:'300',align:'',color:''},
			{id:'3',text:'阈值',name:"minTime",width:'',align:'',color:''}
		],
		rowNum:10,
		rowList:[10,20,30],
		pager : false,
		number:false,
		multiselect:false
	});
	
	$("#sga_status").Grid({
		url : "oracle3.json",
		dataType: "json",
		height: 'auto',
		colums:[
			{id:'1',text:'属性 ',name:"methodName",width:'',index:'1',align:'',color:''},
			{id:'2',text:'值  ',name:"maxTime",width:'300',index:'1',align:'',color:''},
			{id:'3',text:'阈值',name:"minTime",width:'',index:'1',align:'',color:''}
		],
		rowNum:10,
		rowList:[10,20,30],
		pager : false,
		number:false,
		multiselect:true
	});
	$("#tabs").tabs({closeTab:false});
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
</script>
</head>

<body>
<div id="layout_top">
	<div class="header">
    	<p class="user">您好,系统管理员 <span>|</span> <a href="#">退出系统</a></p>
    	<div class="menu_box">
        	<ul class="nav" id="nav">
            	<li ><a href="index.html">首页</a></li>
                <li class="has_sub">
                	<a href="javascript:viod(0)">监视器</a><span class="show_sub_anv"></span>
                	<ul class="add_sub_menu" id="subNav">
                    	<li class="action"><span class="sever">操作系统</span>
                        	<ul class="list">
                            	<li><a href="systemMonitor.html"> Linux(2)</a></li>
                            </ul>
                        </li>
                        <li class="action"><span class="system">应用系统</span>
                        	<ul class="list">
                                <li><a href="performance.html">在线查询</a></li>
                            </ul>
                        </li>
                        <li class="action" style="border:none"><span>数据库</span>
                        	<ul class="list">
                            	<li><a href="oracleMonitor.html">oracle</a></li>
                            </ul>
                        </li>
                        <li class="clear"></li>
                    </ul>
                    
                </li>
                <li><a href="performance.html">应用性能</a></li>
                <li><a href="BusinessSimulation.html">业务仿真</a></li>
                <li><a href="alertList.html">告警</a></li>
                <li><a href="userManager.html">用户管理</a></li>  
            </ul>
        </div>
        <ul class="add_menu" id="menu">
        	<li><a href="addMonitorList.html">新建监视器</a></li>
            <li class="has_sub">
            	<a href="javascript:viod(0)"><span>阈值配置文件</span></a>
            	<ul class="add_sub_menu">
                    <li><a class="addThreshold" href="addThreshold.html">新建阈值文件</a></li>
                    <li><a class="thresholdFile" href="thresholdFile.html">查看阈值配置文件</a></li>
                </ul>
            </li>            
            <li><a href="javascript:viod(0)">配置监视器</a></li>
            <li class="has_sub">
            	<a href="javascript:viod(0)"><span>动作</span></a>
            	<ul class="add_sub_menu">
                	<li class="title"><a href="javascript:viod(0)">显示动作</a></li>
                    <li class="action">创建新动作</li>
                    <li><a class="sms" href="javascript:viod(0)">短信动作</a></li>
                    <li><a class="email" href="javascript:viod(0)">邮件动作</a></li>
                </ul>
            </li>
            <li><a href="setEmergency.html">配置告警</a></li>
        </ul>
    </div>
</div>
<div id="layout_center">
	<div class="main">
  <ul class="crumbs">
      <li><a href="#">管理</a> </li>
      <li><b>配置告警</b></li>
    </ul>
     <hr class="top_border" />
     <div id="tabs">
        	<ul>
            	<li class="tabs_select">概览</li>
                <li>表空间</li>
                <li>SGA</li>
            </ul>
  	 <br />
    
    
    <div id="db_overview" >
  	<table class="main_table" width="100%" cellpadding="0" cellspacing="0" >
      <tr>
        <td style="vertical-align:top">
          <div class="threshold_file">
            <div class="sub_title">基本信息</div>
            <table class="base_info" width="100%" cellpadding="0" cellspacing="0" >
              <tr><td>名称</td><td>${oracleInfoModel.monitorName }</td></tr>
              <tr><td>健康状况</td><td>${oracleInfoModel.health[2] }</td></tr>
              <tr><td>类型</td><td>${oracleInfoModel.MONITOR_TYPE }</td></tr>
              <tr><td>Oracle版本</td><td>${oracleInfoModel.version }</td></tr>
              <tr><td>Oracle启动时间</td><td>${oracleInfoModel.startTime }</td></tr>
              <tr><td>端口</td><td>${oracleInfoModel.port }</td></tr>
              <tr><td>主机名</td><td>${oracleInfoModel.hostName }</td></tr>
              <tr><td>操作系统</td><td>${oracleInfoModel.os }</td></tr>
              <tr><td>最后轮询时间</td><td>${oracleInfoModel.lastExecTime }</td></tr>
              <tr><td>下次轮询时间</td><td>${oracleInfoModel.nextExecTime }</td></tr>
            </table>
          </div>  
        </td>
        <td style="vertical-align:top">
          <div class="threshold_file">
            <div class="sub_title">今日可用性</div>
            <div class="days_data">
              <a href="#"><div class="thirty_days"></div></a>
            	<a href="#"><div class="seven_days"></div></a>
            </div>
            <div id="day_available" ></div>
             <a href="#" ><div class="tool_bar_bottom"><div class="warn_set">警告配置</div></div></a>
          </div>
        </td>
      </tr>
      <tr>
      	<td style="vertical-align:top">
      		 <div class="threshold_file">
            <div class="sub_title">连接时间图 - 最后1小时</div>
            <div class="days_data">
              <a href="#"><div class="thirty_days"></div></a>
            	<a href="#"><div class="seven_days"></div></a>
            </div>
            <div id="last_onehour" ></div>
          </div>
          <div class="threshold_file">
            	<table class="last_onehour_table" cellpadding="0" cellspacing="0">
              	<tr><th>属性</th><th>值</th><th>阈值</th></tr>
                <tr><td>连接时间</td><td>340ms</td><td></td></tr>
                <tr><td colspan="3"><a href="#" ><div class="warn_set">警告配置</div></a></td></tr>
              </table>
         	</div>
         
      	</td>
        <td style="vertical-align:top">
        	 <div class="threshold_file">
            <div class="sub_title">用户活动性 - 最后1小时</div>
            <div class="days_data">
              <a href="#"><div class="thirty_days"></div></a>
            	<a href="#"><div class="seven_days"></div></a>
            </div>
            <div id="user_last_onehour" ></div>
          </div>
           <div class="threshold_file">
            	<table class="last_onehour_table" cellpadding="0" cellspacing="0">
              	<tr><th>属性</th><th>值</th><th>阈值</th></tr>
                <tr><td>连接时间</td><td>340ms</td><td></td></tr>
                  <tr><td colspan="3"><a href="#" ><div class="warn_set">警告配置</div></a></td></tr>
              </table>
         	</div>
        </td>
      </tr>
      <tr>
      	<td colspan="2">
        	<div class="threshold_file">
            	<table class="last_onehour_table" cellpadding="0" cellspacing="0">
              	<div class="sub_title">
                	最少可用字节的表空间
                  <a class="show_table_space_a" href="#">显示所有表空间</a>
                </div>
                
                <tr><td>名称</td><td>可用字节 (MB)</td><td> 	%可用</td></tr>
                <tr><td>SYSTEM</td><td> 32,281.55</td><td>  98.52</td></tr>
                <tr><td>SYSTEM</td><td> 32,281.55</td><td>  98.52</td></tr>
                <tr><td>SYSTEM</td><td> 32,281.55</td><td>  98.52</td></tr>
                <tr><td>SYSTEM</td><td> 32,281.55</td><td>  98.52</td></tr>
                <tr><td>SYSTEM</td><td> 32,281.55</td><td>  98.52</td></tr>
              </table>
         	</div>
        </td>
      </tr>
			<tr>
      	<td colspan="2">
      		<div class="threshold_file">
            	<table class="last_onehour_table" cellpadding="0" cellspacing="0">
              	<div class="sub_title">数据库明细</div>
                <tr class="samll_th"><td>属性</td><td>值</td></tr>
                <tr><td>数据库创建时间 </td><td> ${oracleDetailModel.dbCreateTime }</td></tr>
                <tr><td>Open模式</td><td>${oracleDetailModel.openType }</td></tr>
                <tr><td>Log模式 </td><td>${oracleDetailModel.logType }</td></tr>
              </table>
         	</div>
      	</td>
      </tr>
      <tr>
      	<td style="vertical-align:top;">
        	<div class="threshold_file">
            <div class="sub_title">击中率</div>
            <div class="days_data">
              <a href="#"><div class="thirty_days"></div></a>
            	<a href="#"><div class="seven_days"></div></a>
            </div>
            	<div class="hit_rate">
              	<div style="width:100%;">
                	<div class="hit_rate_head">缓冲器</div>
                </div>
                <div  class="hit_rate_c_l"></div>
                <div class="hit_rate_c">
                	<div class="hit_rate_c_t">
                  	<div class="hit_rate_c_m">
                    	<div class="hit_rate_c_m_m"></div>
                    </div>
                    <div  class="hit_rate_c_m_b" >97%</div>
                  </div>
                </div>
                <div class="hit_rate_c_r"></div>
                <div style="clear:both"></div>
                <div class="hit_rate_b_l">&nbsp;</div>
                <div class="hit_rate_b"></div>
                <div class="hit_rate_b_r" >&nbsp;</div>
              </div>
              <div class="hit_rate">
              	<div style="width:100%;">
                	<div class="hit_rate_head">数据字典</div>
                </div>
                <div  class="hit_rate_c_l"></div>
                <div class="hit_rate_c">
                	<div class="hit_rate_c_t">
                  	<div class="hit_rate_c_m">
                    	<div class="hit_rate_c_m_m"></div>
                    </div>
                    <div  class="hit_rate_c_m_b" >97%</div>
                  </div>
                </div>
                <div class="hit_rate_c_r"></div>
                <div style="clear:both"></div>
                <div class="hit_rate_b_l">&nbsp;</div>
                <div class="hit_rate_b"></div>
                <div class="hit_rate_b_r" >&nbsp;</div>
              </div>
              <div class="hit_rate">
              	<div style="width:100%;">
                	<div class="hit_rate_head">库</div>
                </div>
                <div  class="hit_rate_c_l"></div>
                <div class="hit_rate_c">
                	<div class="hit_rate_c_t">
                  	<div class="hit_rate_c_m">
                    	<div class="hit_rate_c_m_m"></div>
                    </div>
                    <div  class="hit_rate_c_m_b" >97%</div>
                  </div>
                </div>
                <div class="hit_rate_c_r"></div>
                <div style="clear:both"></div>
                <div class="hit_rate_b_l">&nbsp;</div>
                <div class="hit_rate_b"></div>
                <div class="hit_rate_b_r" >&nbsp;</div>
              </div>
          </div>
        </td>
        <td style="vertical-align:top;width:50%">
        	<div class="threshold_file">
            <div class="sub_title">共享的SGA</div>
            <div id="share_sga" ></div>
          </div>
        </td>
        
      </tr>
      <tr>
      	<td colspan="2">
        	<div class="threshold_file">
            	<table class="last_onehour_table" cellpadding="0" cellspacing="0">
              	<div class="sub_title">服务器快照-<a href="#">192.168.18.217</a></div>
                <tr>
                  <td>
                    <a href="#"><div id="use_cpu"></div></a>
                    <a href="#"><div id="use_memory"></div></a>
                    <a href="#"><div id="use_disk"></div></a>
                  </td>
                </tr>
              </table>
         	</div>
        </td>
      </tr>
  	</table>
    </div>
    
    <div id="table_space" >
    	 <div class="threshold_file">
            <div class="sub_title">表空间明细</div>
            <div id="table_space_detail"></div>
          	<div class="tool_bar_top">
              <div><img src="images/db/legend-green.png" /><span>可用空间</span>
             <img src="images/db/legend-red.png" /><span>已用空间</span></div>
            </div>
       </div>
       <div class="threshold_file">
            <div class="sub_title">表空间状态</div>
            <div id="table_space_status"></div>
          	<div class="tool_bar_top"></div>
       </div>
       <div class="threshold_file">
            <div class="sub_title">数据文件的性能指标</div>
            <div id="table_space_performance"></div>
          	<div class="tool_bar_top"></div>
       </div>
    </div>
    <div id="sga">
    		<table width="100%" cellpadding="0" cellspacing="0">
        	<tr>
          	<td colspan="2" >
            	<div class="threshold_file">
                <div class="sub_title">SGA的指标</div>
                <div class="days_data">
                  <a href="#"><div class="thirty_days"></div></a>
                  <a href="#"><div class="seven_days"></div></a>
                </div>
                <div id="sga_target"></div>
              </div>
            </td>
          </tr>
          <tr>
          	<td width="50%">
            	<div style=' border:1px solid #dfe9f2;'>
                <div class="sub_title">SGA明细</div>
                <div id="sga_detail"></div>
                <a href="#" ><div class="tool_bar_bottom"><div class="warn_set">警告配置</div></div></a>
              </div>
            </td>
            <td width="50%">
            	<div style=' border:1px solid #dfe9f2;'>
                <div class="sub_title">SGA状态</div>
                <div id="sga_status"></div>
                <a href="#" ><div class="tool_bar_bottom"><div class="warn_set">警告配置</div></div></a>
              </div>
            </td>
          </tr>
        </table>
    </div>
  </div>
</div></div>
<div id="layout_bottom">
	<p class="footer">Copyright &copy; 2013 Sinosoft Co.,Lt</p>
</div>
</body>
</html>

