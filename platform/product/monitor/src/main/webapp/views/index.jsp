<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>monitor监控系统</title>
<%@ include file="/WEB-INF/layouts/base.jsp" %>
<script type="text/javascript">
var columStyle = 
	[  
		{id:'1',text:'名称',name:"appellation",index:'1',align:''},
		{id:'2',text:'可用性',name:"appellation",index:'1',align:''},
		{id:'3',text:'健康状态',name:"appellation",index:'1',align:''}
	];
var columStyle2 = 
	[  
		{id:'1',text:'名称',name:"appellation",index:'1',align:''},
		{id:'2',text:'可用性',name:"appellation",index:'1',align:''},
		{id:'3',text:'健康状态',name:"appellation",index:'1',align:''}
	];
$(function(){
	$("body").layout({
		top:{topHeight:100},
		bottom:{bottomHeight:30}
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
</script>
</head>

<body>
<%@include file="/WEB-INF/layouts/menu.jsp" %>
<div id="layout_center">
	<div class="main">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="48%" rowspan="3" style="vertical-align:top">
	            <div class="threshold_file">
	                <h3 class="title3">应用系统：</h3>
	                <div id="thresholdList"></div>
	            </div>
	            <br/>
	        	<div class="threshold_file">
	                <h3 class="title3">预警信息：</h3>
	                <div id="emergencyList"></div>
	            </div>
	        </td>
	        <td width="4%">&nbsp;</td>
	        <td rowspan="3" style="vertical-align:top">
	        	<div class="threshold_file">
	                <h3 class="title3">操作系统：</h3>
	                <div id="systemList"></div>
	            </div>
	            <br />
	        	<div class="threshold_file">
	                <h3 class="title3">数据库：</h3>
	                <div id="oracleList"></div>
	            </div>
	        </td>
	      </tr>
	      <tr>
	        <td>&nbsp;</td>
	      </tr>
	      <tr>
	        <td>&nbsp;</td>
	      </tr>
	    </table>
	</div>
</div>
<div id="layout_bottom">
	<p class="footer">Copyright &copy; 2013 Sinosoft Co.,Lt</p>
</div>
</body>
</html>
