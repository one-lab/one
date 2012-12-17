<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>投保单撤件</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript">ctx = "${ctx}";</script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     请输入查询条件</td>
			</tr>
			<tr> 
				<td class="left">投保单号码：</td>
				<td class="right"><input name="ManageCom" class="common" type="text"></td>
				<td class="left">管理机构：</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="都邦北京分公司"></td>
				<td class="left">代理人编码：</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="10004545 " style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="张三"></td>
			</tr>
			<tr>
				<td class="left">投保日期起期：</td>
				<td class="right">
					<input name="proposalDate" id="proposalDate" class="common" type="text" style="width: 73%" value='2012-05-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'proposalDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>	
				<td class="left">投保日期止期：</td>
				<td class="right">
					<input name="endDate" id="endDate" class="common" type="text" style="width: 73%" value='2012-05-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'endDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="common"></td>
				<td class="common"></td>				
			</tr>
			<tr>
				<td class="left">投保单位名称：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>			
			</tr>
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick=""></td>
			</tr>
		</table>
		<br>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     投保单信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="8%">投保单号</td>
					<td width="18%">投保单位名称</td>
					<td width="8%">录入人员</td>
					<td width="10%">录入日期</td>
					<td width="8%">复核人员</td>
					<td width="10%">复核日期</td>
					<td width="10%">核保人员</td>
					<td width="10%">核保日期</td>
					<td width="10%">核保结论</td>					
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>G86012012005</td>
					<td>都邦保险公司北京分公司</td>
					<td>张三</td>
					<td>2012-05-18</td>
					<td>李四</td>
					<td>2012-05-18</td>
					<td>王五</td>
					<td>2012-05-18</td>
					<td>通过</td>					
				</tr>
			</tbody>
		</table>
		<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick="location.href='ReportAuditDeal.jsp'"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>		
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr> 
				<td class="left">撤单原因分类：</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">付费方式：</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value=""></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>	
			</tr>
			<tr>
				<td class="left">申请人：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">证件类型：</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="01" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="身份证"></td>
				<td class="left">证件号码：</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
			</tr>
		</table>
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     撤单说明（125个字符以内，回车占一个汉字）</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5"></textarea></td>
			</tr>
		</table>
		<br><br>
		<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6"><input type = "button" class="cssbutton" value="确  认" onclick=""></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
