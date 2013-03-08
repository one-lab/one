<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>monitor监控系统</title>
<link href="css/base.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/oracle.css" rel="stylesheet" type="text/css" />
<link href="css/sinosoft.grid.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="js/jquery-1.7.1.js"></script>
<script language="javascript" src="js/sinosoft.layout.js"></script>
<script language="javascript" src="js/sinosoft.grid.js"></script>  
<script language="javascript" src="js/highcharts.src.js"></script>
<script type="text/javascript">
$(function(){
	$("body").layout({
		top:{topHeight:100},
		bottom:{bottomHeight:30}
	});
	$("#myDesk").height($("#layout_center").height());
	$("#nav").delegate('li', 'mouseover mouseout', navHover);
	$("#nav,#menu").delegate('li', 'click', navClick);
	
	$("#sevenday_grid").Grid({
		url : "historyCPU.json",
		dataType: "json",
		height: 'auto',
		colums:[
			{id:'1',text:'日期',name:"methodName",width:'',index:'1',align:'',color:''},
			{id:'2',text:'时间',name:"maxTime",width:'300',index:'1',align:'',color:''},
			{id:'3',text:'最小值  ',name:"minTime",width:'',index:'1',align:'',color:''},
			{id:'4',text:'最大值 ',name:"avgTime",width:'',index:'1',align:'',color:''},
			{id:'5',text:'每小时平均值 ',name:"status",width:'',index:'1',align:'',color:''}
		],
		rowNum:10,
		rowList:[10,20,30],
		pager : false,
		number:false,
		multiselect:true,
	});
});
$(function(){
	var chart;
	$(document).ready(function(){
			chart = new Highcharts.Chart({
            chart: {
                renderTo: 'last_sevenday',
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
                categories: ['26-二月,12:00', '27-二月,00:00', '27-二月,12:00', '28-二月,00:00', '28-二月,12:00', '1-三月,00:00', '1-三月,12:00']
            },
            yAxis: {
                title: {
                    text: '总的磁盘利用率%'
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
                name: '所选时间内的平均值',
                data: [98, 42, 57, 85, 79, 12, 17]
            },
						{
                name: '平均值(每小时)',
                data: [57, 85, 19, 42, 57, 85, 19]
            },
						{
                name: '移动平均值',
                data: [19, 42, 57, 85, 57, 85, 29]
            }],
						colors: ['#00b200', '#0000b2', '#b200b2'] 
        });
		})	
})
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
<div id="layout_center">
  <div class="main" style="margin-bottom:60px;">
     <div class="threshold_file">
          <div class="sub_title">磁盘利用率</div>
          
          <table class="base_info" width="100%" cellpadding="0" cellspacing="0">
            <tr><td>监视器名称</td><td>oracle</td></tr>
            <tr><td>属性 </td><td>用户数 </td></tr>
            <tr><td>从  </td><td> 	2013-2-26 上午11:00 </td></tr>
            <tr><td>到 </td><td> 	2013-3-1 下午6:22</td></tr>
             <tr><td colspan="2"> 
            	<div class="days_data">
                  <a href="historyDiskThirtyDay.html"><div class="thirty_days"></div></a>
                  <a href="historyDiskSevenDay.html"><div class="seven_days"></div></a>
                </div></td></tr>
             <tr><td colspan="2"><div id="last_sevenday" ></div></td></tr>
             <tr>
               <td colspan="2">
               
                 <div class="buttom_mark">
                    <div>总的磁盘利用率(%) :</div><div>1</div>
                    <div>最小平均值</div><div>2</div>
                    <div>最大平均值:</div><div>23</div>
                    <div>平均:</div><div>13.489 </div>
                 </div>
             </td></tr>
          </table>
          
         
     </div>
     
     <div class="threshold_file">
       <div class="sub_title">总的磁盘利用率(%)</div>
       <div id="sevenday_grid"></div>
     </div>
  </div>
</div>
</body>
</html>
