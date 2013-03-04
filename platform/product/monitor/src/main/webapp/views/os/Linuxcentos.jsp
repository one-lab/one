<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${ctx}/global/css/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/sinosoft.grid.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/bussiness.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/sinosoft.message.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/sinosoft.window.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="${ctx}/global/js/jquery-1.7.1.js"></script>
<script language="javascript" src="${ctx}/global/js/sinosoft.layout.js"></script>
<script language="javascript" src="${ctx}/global/js/sinosoft.grid.js"></script>
<script language="javascript" src="${ctx}/global/js/sinosoft.message.js"></script>
<script language="javascript" src="${ctx}/global/js/sinosoft.window.js"></script>
<script language="javascript" src="${ctx}/global/js/highcharts.js"></script>
<script language="javascript" src="${ctx}/global/js/exporting.js"></script>
<script language="javascript" src="${ctx}/global/js/highcharts-more.js"></script>
<script type="text/javascript">
$(function(){
	$("body").layout({
		top:{topHeight:100}
	});
	$("#myDesk").height($("#layout_center").height());
	$("#nav").delegate('li', 'mouseover mouseout', navHover);
	$("#nav,#menu").delegate('li', 'click', navClick);
});
$(function(){
		$("#grid_Memory").Grid({
		url : "gridMemory.json",
		dataType: "json",
		height: 'auto',
		colums:[
			{id:'1',text:'Memory Usage',name:"appellation",index:'1',align:'',color:''},
			{id:'2',text:'%',name:"degrees",index:'1',align:'',color:''},
			{id:'6',text:'',name:"degrees",index:'1',align:'',color:''},
			{id:'3',text:'MB',name:"degrees",index:'1',align:'',color:''},
			{id:'4',text:'Threshold',name:"degrees",index:'1',align:'',color:''}
		],
		rowNum:10,
		number:false,
		sorts:false,
		colDisplay:false,
		multiselect:false,
		draggable:false
	});
})
$(function(){
		$("#grid_cpu").Grid({
		url : "grid_cpu.json",
		dataType: "json",
		height: 'auto',
		colums:[
			{id:'1',text:'CPU Usage',name:"appellation",index:'1',align:'',color:''},
			{id:'2',text:'%',name:"degrees",index:'1',align:'',color:''},
			{id:'6',text:'',name:"degrees",index:'1',align:'',color:''},
			{id:'4',text:'Threshold',name:"degrees",index:'1',align:'',color:''}
		],
		rowNum:10,
		number:false,
		sorts:false,
		colDisplay:false,
		multiselect:false,
		draggable:false
	});
})
$(function(){
	$("body").layout({
		top:{topHeight:100},
		bottom:{bottomHeight:30}
	});
	$("#grid_cpudo").Grid({
		url : "griddo.json",  
		dataType: "json",
		colDisplay: false,  
		clickSelect: true,
		draggable:false,
		height: "auto",
		colums:[  
			{id:'1',text:'参数名称',name:"appellation",index:'1',align:''},
			{id:'2',text:'当前值',name:"appellation",index:'1',align:''},
			{id:'3',text:'状态',name:"appellation",index:'1',align:''},
			{id:'4',text:'',name:"appellation",index:'1',align:''}
		],  
		rowNum:9999,
		pager : false,
		number:false,  
		sorts: false,
		multiselect: false
		 
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
$(function () {
    var chart;
    
    $(document).ready(function () {
    	
    	// Build the chart
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'container',
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: ''
            },
            tooltip: {
                formatter: function() {
                    return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
                }
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: false
                    },
                    showInLegend: true
                }
            },
            series: [{
                type: 'pie',
                name: 'Browser share',
                data: [
                       {
                        name: '可用',
                        y: 81.2,
						 color:"#0f6",
                        sliced: false,
                        selected: false
                    },
                    {
                        name: '不可用',
                        y: 12.8,
						 color:"#f00",
                        sliced: false,
                        selected: false
                    }
                ]
            }]
        });
    });
    
});
$(function () {
	 $(document).ready(function() {
		
    var chart = new Highcharts.Chart({
	
	    chart: {
	        renderTo: 'speed',
	        type: 'gauge',
	        plotBackgroundColor: null,
	        plotBackgroundImage: null,
	        plotBorderWidth: 0,
	        plotShadow: false
	    },
	    
	    title: {
	        text: ''
	    },
		credits: { 
			text: '',
			href: ''
		},
	    
	    pane: {
	        startAngle: -150,
	        endAngle: 150,
	        background: [{
	           //backgroundColor:'#ccc' // 默认表盘颜色
	        }, {
	            backgroundColor: '#222',
	            borderWidth: 0,
	            outerRadius: '105%',
	            innerRadius: '103%'
	        }]
	    },
			labels:{
					style:{
							color:'#222'
						}
				},
	       
	    // the value axis
	    yAxis: {
	        min: 0,
	        max: 100,
	        minorTickInterval: 'auto',
	        minorTickWidth: 1,
	        minorTickLength: 10,
	        minorTickPosition: 'inside',
	        minorTickColor: '#666',
	
	        tickPixelInterval: 30,
	        tickWidth: 2,
	        tickPosition: 'inside',
	        tickLength: 15,
	        tickColor: '#666',
	        labels: {
	            step: 5, //步长 *5的数值
	            rotation: 'auto',
	        },
	        title: {
	            text: '' //表盘中央显示数值信息
	        },
	        plotBands: [{
	            from: 0,
	            to: 60,
	            color: '#55BF3B' // green
	        }, {
	            from: 60,
	            to: 80,
	            color: '#DDDF0D' // yellow
	        }, {
	            from: 80,
	            to: 100,
	            color: '#DF5353' // red
	        }]        
	    },
	
	    series: [{
	        name: '使用率',
	        data: [0],
	        tooltip: {
	            valueSuffix: ' %'
	        }
	    }]
	
	}, 
	// Add some life
	function (chart) {
			
	    setInterval(function () {
	        var point = chart.series[0].points[0],
	            newVal,
	            inc = Math.round((Math.random() - 0.5) * 20);
	        newVal = point.y + inc;
	        if (newVal < 0 || newVal > 100) {
	            newVal = point.y - inc;
	        }
	        point.update(newVal);
	    }, 500);
		});
	});
});
$(function () {
	 $(document).ready(function() {
		
    var chart = new Highcharts.Chart({
	
	    chart: {
	        renderTo: 'speed2',
	        type: 'gauge',
	        plotBackgroundColor: null,
	        plotBackgroundImage: null,
	        plotBorderWidth: 0,
	        plotShadow: false
	    },
	    
	    title: {
	        text: ''
	    },
		credits: { 
			text: '',
			href: ''
		},
	    
	    pane: {
	        startAngle: -150,
	        endAngle: 150,
	        background: [{
	           //backgroundColor:'#ccc' // 默认表盘颜色
	        }, {
	            backgroundColor: '#222',
	            borderWidth: 0,
	            outerRadius: '105%',
	            innerRadius: '103%'
	        }]
	    },
			labels:{
					style:{
							color:'#222'
						}
				},
	       
	    // the value axis
	    yAxis: {
	        min: 0,
	        max: 100,
	        minorTickInterval: 'auto',
	        minorTickWidth: 1,
	        minorTickLength: 10,
	        minorTickPosition: 'inside',
	        minorTickColor: '#666',
	
	        tickPixelInterval: 30,
	        tickWidth: 2,
	        tickPosition: 'inside',
	        tickLength: 15,
	        tickColor: '#666',
	        labels: {
	            step: 5, //步长 *5的数值
	            rotation: 'auto',
	        },
	        title: {
	            text: '' //表盘中央显示数值信息
	        },
	        plotBands: [{
	            from: 0,
	            to: 60,
	            color: '#55BF3B' // green
	        }, {
	            from: 60,
	            to: 80,
	            color: '#DDDF0D' // yellow
	        }, {
	            from: 80,
	            to: 100,
	            color: '#DF5353' // red
	        }]        
	    },
	
	    series: [{
	        name: '使用率',
	        data: [0],
	        tooltip: {
	            valueSuffix: ' %'
	        }
	    }]
	
	}, 
	// Add some life
	function (chart) {
			
	    setInterval(function () {
	        var point = chart.series[0].points[0],
	            newVal,
	            inc = Math.round((Math.random() - 0.5) * 20);
	        newVal = point.y + inc;
	        if (newVal < 0 || newVal > 100) {
	            newVal = point.y - inc;
	        }
	        point.update(newVal);
	    }, 500);
		});
	});
});
$(function () {
	 $(document).ready(function() {
		
    var chart = new Highcharts.Chart({
	
	    chart: {
	        renderTo: 'speed3',
	        type: 'gauge',
	        plotBackgroundColor: null,
	        plotBackgroundImage: null,
	        plotBorderWidth: 0,
	        plotShadow: false
	    },
	    
	    title: {
	        text: ''
	    },
		credits: { 
			text: '',
			href: ''
		},
	    
	    pane: {
	        startAngle: -150,
	        endAngle: 150,
	        background: [{
	           //backgroundColor:'#ccc' // 默认表盘颜色
	        }, {
	            backgroundColor: '#222',
	            borderWidth: 0,
	            outerRadius: '105%',
	            innerRadius: '103%'
	        }]
	    },
			labels:{
					style:{
							color:'#222'
						}
				},
	       
	    // the value axis
	    yAxis: {
	        min: 0,
	        max: 100,
	        minorTickInterval: 'auto',
	        minorTickWidth: 1,
	        minorTickLength: 10,
	        minorTickPosition: 'inside',
	        minorTickColor: '#666',
	
	        tickPixelInterval: 30,
	        tickWidth: 2,
	        tickPosition: 'inside',
	        tickLength: 15,
	        tickColor: '#666',
	        labels: {
	            step: 5, //步长 *5的数值
	            rotation: 'auto',
	        },
	        title: {
	            text: '' //表盘中央显示数值信息
	        },
	        plotBands: [{
	            from: 0,
	            to: 60,
	            color: '#55BF3B' // green
	        }, {
	            from: 60,
	            to: 80,
	            color: '#DDDF0D' // yellow
	        }, {
	            from: 80,
	            to: 100,
	            color: '#DF5353' // red
	        }]        
	    },
	
	    series: [{
	        name: '使用率',
	        data: [0],
	        tooltip: {
	            valueSuffix: ' %'
	        }
	    }]
	
	}, 
	// Add some life
	function (chart) {
			
	    setInterval(function () {
	        var point = chart.series[0].points[0],
	            newVal,
	            inc = Math.round((Math.random() - 0.5) * 20);
	        newVal = point.y + inc;
	        if (newVal < 0 || newVal > 100) {
	            newVal = point.y - inc;
	        }
	        point.update(newVal);
	    }, 500);
		});
	});
});

$(function(){
	$(document).ready(function() {
chart8 = new Highcharts.Chart({
            chart: {
                renderTo: 'CPU_line',
                type: 'line',
								height:300
            },
            title: {
                text: ''
            },
            subtitle: {
                text: ''
            },
            xAxis: {
                categories: ['08:20', '08:21', '08:22', '08:23', '08:24', '08:25', '08:26']
            },
            yAxis: {
                title: {
                    text: '值%'
                }
								
									
            },
            tooltip: {
                enabled: false,
                formatter: function() {
                    return '<b>'+ this.series.name +'</b><br/>'+
                        this.x +': '+ this.y ;
                }
            },
            plotOptions: {
                line: {
                    dataLabels: {
                        enabled: true
                    },
                    enableMouseTracking: false,
									  marker:{  
											enabled:false
										}
                }
            },
						credits: { 
							text: '',
							href: ''
						},
            series: [{
                name: '缓冲区击中率',
                data: [98, 42, 57, 85, 79, 12, 17]
            },
						{
                name: '数据字典击中率',
                data: [57, 85, 19, 42, 57, 85, 19]
            },
						{
                name: '缓存击中率',
                data: [19, 42, 57, 85, 57, 85, 29]
            }],
						colors: ['#00b200', '#0000b2', '#b200b2'] 
        });
	});	
	
	})
	$(function(){
	$(document).ready(function() {
chart8 = new Highcharts.Chart({
            chart: {
                renderTo: 'CPU_line2',
                type: 'line',
								height:300
            },
            title: {
                text: ''
            },
            subtitle: {
                text: ''
            },
            xAxis: {
                categories: ['08:20', '08:21', '08:22', '08:23', '08:24', '08:25', '08:26']
            },
            yAxis: {
                title: {
                    text: '值%'
                }
								
									
            },
            tooltip: {
                enabled: false,
                formatter: function() {
                    return '<b>'+ this.series.name +'</b><br/>'+
                        this.x +': '+ this.y ;
                }
            },
            plotOptions: {
                line: {
                    dataLabels: {
                        enabled: true
                    },
                    enableMouseTracking: false,
									  marker:{  
											enabled:false
										}
                }
            },
						credits: { 
							text: '',
							href: ''
						},
            series: [{
                name: '缓冲区击中率',
                data: [98, 42, 57, 85, 79, 12, 17]
            },
						{
                name: '数据字典击中率',
                data: [57, 85, 19, 42, 57, 85, 19]
            },
						{
                name: '缓存击中率',
                data: [19, 42, 57, 85, 57, 85, 29]
            }],
						colors: ['#00b200', '#0000b2', '#b200b2'] 
        });
	});	
	
	})
</script>
</head>

<body>
<div id="layout_top">
  <div class="header">
    <p class="user">您好,系统管理员 <span>|</span> <a href="#">退出系统</a></p>
    <div class="menu_box">
      <ul class="nav" id="nav">
        <li><a href="index.html">首页</a></li>
        <li class="has_sub"> <a href="javascript:viod(0)">监视器</a><span class="show_sub_anv"></span>
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
            <li class="action" style="border:none "><span>数据库</span>
              <ul class="list">
                <li><a href="javascript:viod(0)">SQL DBA</a></li>
                <li><a href="javascript:viod(0)">SQL SYS</a></li>
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
      <li><a href="javascript:viod(0)">新建监视器</a></li>
      <li><a href="javascript:viod(0)">配置监视器</a></li>
      <li class="has_sub"> <a href="javascript:viod(0)"><span>预警对象管理</span></a>
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
  <div class="head-h4">
    <h4>监视器 > Linux > app-centos5-64-1_Linux</h4>
  </div>
  <div class="linux-on" style="width:99%; height:280px">
    <div>
      <table width="50%" cellspacing="0" cellpadding="0" border="0" class="lrtbdarkborder" height="280px">
        <tbody>
          <tr>
            <td colspan="2" class="jsq-message">监视器信息</td>
          </tr>
          <tr>
            <td class="monitorinfoodd">名称 </td>
            <td width="70%" class="monitorinfoeven">app-centos5-64-1_Linux</td>
          </tr>
          <tr>
            <td class="monitorinfoodd">系统健康状况</td>
            <td class="monitorinfoeven"><img src="${ctx}/global/images/bussinessY.gif" />&nbsp;&nbsp;健康状态为正常  .&nbsp;没有出现严重的告警。 </td>
          </tr>
          <tr>
            <td class="monitorinfoodd" >类型 </td>
            <td class="monitorinfoeven">服务器</td>
          </tr>
          <tr>
            <td class="monitorinfoodd" >主机名</td>
            <td class="monitorinfoeven">app-centos5-64-1&nbsp;(172.18.131.121)</td>
          </tr>
          <tr>
            <td class="monitorinfoodd">操作系统 </td>
            <td class="monitorinfoeven"> Linux </td>
          </tr>
          <tr>
            <td class="monitorinfoodd">最后轮询时间</td>
            <td class="monitorinfoeven">Feb 28, 2013 11:13 PM</td>
          </tr>
          <tr>
            <td class="monitorinfoodd">下次轮询时间</td>
            <td class="monitorinfoeven">Feb 28, 2013 11:23 PM</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="tableheadingbborder" style="width:49%; height:280px">
      <div class="head-cpu">今天的可用性</div>
      <div class="cpu-img"><a class="cpu7-img" href="#"></a><a class="cpu30-img" href="#"></a></div>
      <div id="container" style="width: 300px; height: 240px; margin: 0 auto"></div>
      <div class="cpu-text"><b>当前状态&nbsp;&nbsp;<a class="cpu-textimg">&nbsp;</a><a class="bodytext-img" href="#">Configure Alarms</a></b></div>
    </div>
  </div>
  <div class="know-time" style="width:49.5%; height:80px">
    <table width="100%" cellspacing="0" cellpadding="0" border="0" class="dashboard-time" height="80">
      <tbody>
        <tr>
          <td class="dashLeft"><img width="7" height="7" src="${ctx}/global/images/spacer.gif"></td>
          <td width="100%" align="center" class="dashboard"><table width="100%" cellspacing="0" cellpadding="0" border="0">
              <tbody>
                <tr>
                  <td width="60%" class="bodytextbold">&nbsp;&nbsp;应答时间&nbsp;&nbsp;<a href="#" class="bodytextbold1"></a></td>
                  <td width="30%" align="right"><a class="cpu7-img" href="#"></a><a class="cpu30-img" href="#"></a></td>
                </tr>
                <tr>
                  <td align="center" class="textResponseTime" colspan="1"> 0 毫秒 </td>
                  <td valign="bottom" align="right"><a class="bodytext-img" href="#">Configure Alarms</a>&nbsp;</td>
                </tr>
              </tbody>
            </table></td>
          <td class="dashRight"><img width="7" height="7" src="${ctx}/global/images/spacer.gif"></td>
        </tr>
      </tbody>
    </table>
  </div>
  <div class="linux-midd" style="width:99.1%; height:200px; padding-bottom:10px;" >
    <table width="100%" cellspacing="0" cellpadding="0" border="0" class="lrtbdarkborder3">
      <tbody>
        <tr>
          <td height="26" align="center" class="tableheading" >CPU使用率</td>
          <td height="26" align="center" class="tableheading">内存使用率</td>
          <td height="26" align="center" class="tableheading">磁盘利用率</td>
        </tr>
      </tbody>
    </table>
    <table width="99%" cellspacing="0" cellpadding="10" border="0" class="lrbborder">
      <tbody>
        <tr>
          <td width="30%" valign="top" height="180"><table width="100%" cellspacing="0" cellpadding="0" border="0" class="dashboard">
              <tbody>
                <tr>
                  <td class="dashLeft"><img width="7" height="7" src="${ctx}/global/images/spacer.gif"></td>
                  <td width="100%" align="center" class="dashboard"><table width="99%" cellspacing="0" cellpadding="3" border="0">
                      <tbody >
                        <tr>
                          <td height="28" align="center" title="CPU使用率-3 %" class="bodytext" colspan="1"><div id="speed" style="width: 200px; height: 140px; margin: 0 auto; "></div></td>
                        </tr>
                        <tr>
                          <td align="center" class="bodytextbold"><a class="staticlinks"  href="javascript:void(0)">CPU使用率 - 3</a> % </td>
                        </tr>
                      </tbody>
                    </table></td>
                </tr>
              </tbody>
            </table></td>
          <td width="30%" height="180"><table width="100%" cellspacing="0" cellpadding="0" border="0" class="dashboard">
              <tbody>
                <tr>
                  <td class="dashLeft"><img width="7" height="7" src="${ctx}/global/images/spacer.gif"></td>
                  <td width="100%" align="center" class="dashboard"><table cellspacing="0" cellpadding="3" border="0">
                      <tbody>
                        <tr>
                          <td height="28" align="center" title="内存使用率-16 %" class="bodytext" colspan="1"><div id="speed2" style="width: 200px; height: 140px; margin: 0 auto"></div></td>
                        </tr>
                        <tr>
                          <td align="center" class="bodytextbold"><a class="staticlinks"  href="javascript:void(0)">内存使用率-16</a> % </td>
                        </tr>
                      </tbody>
                    </table>
                    
                    <!--$Id$--></td>
                  <td class="dashRight"><img width="7" height="7" src="${ctx}/global/images/spacer.gif"></td>
                </tr>
              </tbody>
            </table></td>
          <td width="30%" height="180"><table width="100%" cellspacing="0" cellpadding="0" border="0" class="dashboard">
              <tbody>
                <tr>
                  <td class="dashLeft"><img width="7" height="7" src="${ctx}/global/images/spacer.gif"></td>
                  <td width="100%" align="center" class="dashboard"><table cellspacing="0" cellpadding="3" border="0">
                      <tbody>
                        <tr>
                          <td height="28" align="center" title="磁盘利用率-12%" class="bodytext" colspan="1"><div id="speed3" style="width: 200px; height:140px; margin: 0 auto"></div></td>
                        </tr>
                        <tr>
                          <td align="center" class="bodytextbold"><a href="#" class="staticlinks" onclick= href="javascript:void(0)">磁盘使用率-12</a> % </td>
                        </tr>
                      </tbody>
                    </table>
                    
                    <!--$Id$-->
              </tbody>
            </table>
      </tbody>
    </table>
  </div>
  <div class="linux-down" style="width:99%; height:500px; float:right">
    <table width="100%" cellspacing="0" cellpadding="0" border="0" class="linux-downhead">
      <tbody>
        <tr>
          <td width="100%" height="29" class="tableheadingtrans">&nbsp;CPU及内存使用率 - 最近6小时<a name="Memory Utilization"></a></td>
        </tr>
      </tbody>
    </table>
    <div id="CPU_line" style="height:230px"></div>
    <div class="grid-total">
      <div id="grid_Memory" class="grid-Memory" style="width:50%; height:50px"> </div>
      <div class="Memory1" style="width:50%"><a class="Memory" href="#"> Configure Alarms </a></div>
      <div id="grid_cpu" class="grid_cpu" style="width:50%; height:50px"> </div>
      <div class="cpu1" style="height:20px"><a class="cpu" href="#"> Configure Alarms </a></div>
    </div>
  </div>
  <div class="linux-bottom" style="width:99%; float:right; height:650px">
    <table width="100%" cellspacing="0" cellpadding="0" border="0" class="linux-downhead">
      <tbody>
        <tr>
          <td width="100%" height="29" class="tableheadingtrans">&nbsp;分解CPU利用率<a name="Memory Utilization"></a></td>
        </tr>
      </tbody>
    </table>
    <div id="CPU_line2"></div>
    <div class="grid_cpudo" id="grid_cpudo" style="width:70%"> </div>
    <div class="tool_bar2" style="width:70.2%"><a class="gaojin" href="#">告警配置</a></div>
  </div>
</div>
</body>
</html>
