<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>保全定义</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/common/css/TagPage.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript">
	//开始定义保全
	function defineRiskEdorItem(){
		$("#riskEdorItemForm").attr("action",contextRootPath + "/product/findRiskEdorItemFields.do");
		$("#riskEdorItemForm").submit();
	}
	//查询定义中的险种
	function findRiskEdorItem(){
		var url = contextRootPath + "/product/";
		$("#riskName").val()
	}
	</script>
  </head>
  <body>
  <div id="con">
	<ul id="tags">
		<li class="selectTag"><a href="javascript:void(0)" onclick="selectTag('tagContent0',this)">定义中的产品</a></li>
		<li ><a href="javascript:void(0)" onclick="selectTag('tagContent1',this)">已上线产品查询</a></li>
	</ul>			 

	<div id="tagContent" style="width:100%;height:100%">
	   <div id="tagContent0" class="tagContent selectTag" style="width:100%;height:500px;background-color:#ffffff;overflow:auto;">
	        <table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">定义中险种查询</td>
			</tr>
			<tr>
				<td class="left">险种名称：</td>
				<td class="right"><input id="riskName"  class="common" type="text"></td>
				<td class="left">险种编码：</td>
				<td class="right"><input id="riskCode" class="common" type="text"></td>
				<td class="left">申请日期：</td>
				<td class="right" colspan="6">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="middle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>				
			</tr>
			<tr>
				<td >
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="findRiskEdorItem();">
				</td>
			</tr>
		</table>
		<form id="riskEdorItemForm" method="post">
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="23%">产品险种代码</td>
					<td width="23%">产品险种名称</td>
					<td width="23%">申请日期</td>
					<td width="23%">申请人</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>
						<input type = "button" class="cssbutton" name="defineButton" value="开始定义" onclick="defineRiskEdorItem();">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	   </div>
	   <div id="tagContent1" class="tagContent" style="width:100%;height:500px;background-color:#ffffff;overflow:auto;">
	   		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已上线产品查询</td>
			</tr>
			<tr>
				<td class="left">产品险种编码：</td>
				<td class="right"><input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:65%"></td>
				<td>
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="">
				</td>
			</tr>
		</table>
		<table id="scanApplycInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">险种信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="16%">产品险种代码</td>
					<td width="24%">产品险种名称</td>
					<td width="16%">申请日期</td>
					<td width="20%">申请人</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>1</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>2</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
			
		</table>	
		<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" align="right"><input type = "button" class="cssbutton" value="查  看" onclick="location.href='pdclaimedit.jsp'"></td>
			</tr>
		</table>	
	   </div>	   
	</div>
	</div>
  </body>
</html>
