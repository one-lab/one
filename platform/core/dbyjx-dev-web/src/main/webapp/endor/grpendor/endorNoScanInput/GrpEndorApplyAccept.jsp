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
    
    <title>团体保全申请受理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="EndorAcceptInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     保全受理信息</td>
			</tr>
			<tr> 
				<td class="left">保全受理号：</td>
				<td class="right"><input name="EndorAcceptNo" class="common" type="text" readonly></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr> 
				<td class="left">团体保单号：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">批改状态：</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">申请人姓名：</td>
				<td class="right"><input name="State" class="common" type="text" value="晓岚" readonly></td>
			</tr>
			<tr>
				<td class="left">申请方式：</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">受理日期：</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='2012-04-28' readonly>
				</td>
				<td class="common"></td>
				<td class="common"></td>		
			</tr>
		</table>
		<table id="endorItemInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     团单详细信息</td>
			</tr>
			<tr> 
				<td class="left">团体保单号：</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" value="P2012321352" readonly></td>
				<td class="left">投保单位：</td>
				<td class="right"><input name="GrpName" class="common" type="text" value="中石油" readonly></td>
				<td class="left">生效日期：</td>
				<td class="right"><input name="State" class="common" type="text" value="2012-07-23" readonly></td>
			</tr>
			<tr>
				<td class="left">投保人数：</td>
				<td class="right"><input name="State" class="common" type="text" value="20" readonly></td>
				<td class="left">联系人：</td>
				<td class="right"><input name="State" class="common" type="text" value="李四" readonly></td>
				<td class="left">业务员：</td>
				<td class="right"><input name="State" class="common" type="text" value="笑天" readonly></td>		
			</tr>
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="保单明细查询"  onclick="location.href='./GrpContDetailView.jsp'">
					<input type = "button" class="cssbutton" name="ReturnBack" value="人名清单查询"  onclick="location.href='./InsuredListView.jsp'">
				</td>
			</tr>
		</table>
		<table id="grpContInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     保全项目信息</td>
			</tr>
			<tr> 
				<td class="left">批改类型：</td>
				<td class="right">
					<input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" >
				</td>
				<td class="left">申请日期：</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='2012-04-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="left">操作员：</td>
				<td class="right"><input name="State" class="common" type="text" value="新一" readonly></td>
			</tr>
			<tr> 
				<td class="left">申请原因：</td>
				<td class="right">
					<input name="ApplyReason" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" >
				</td>
				<td class="left">生效日期：</td>
				<td class="right"><input name="Cvalidate" class="common" type="text" value="2012-07-23" readonly></td>
			</tr>			
		</table>
		<table id="ButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="AddEndorItem" value="添加保全项目" onclick="">
				</td>
			</tr>
		</table>
		<br>
		<table id="endorItemListInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="7%">序号</td>
					<td width="18%">批改类型</td>
					<td width="18%">申请日期</td>
					<td width="18%">生效日期</td>
					<td width="18%">申请原因</td>
					<td width="18%">处理状态</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td ><input name="checkRadio" type="radio" value="" /></td>
					<td>1</td>
					<td ><a href="javascript:void(0)" onclick="location.href='./ChangeInsuredInfoInput.jsp'">BB-被保险人基本信息变更</a></td>
					<td >2012-05-01</td>
					<td >2012-05-01</td>
					<td >客户申请</td>
					<td >申请录入</td>
				</tr>
				<tr class="content">
					<td ><input name="checkRadio" type="radio" value="" /></td>
					<td>2</td>
					<td ><a href="javascript:void(0)" onclick="location.href='./EndorNIDetailInput.jsp'">NI-增加被保险人</a></td>
					<td >2012-05-01</td>
					<td >2012-05-01</td>
					<td >客户申请</td>
					<td >申请录入</td>
				</tr>				
			</tbody>
		</table>
		<table>
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="保全项目明细" onclick="">
					<input type = "button" class="cssbutton" name="ReturnBack" value="保全项目撤销" onclick="">
				</td>				
			</tr>
		</table>
		<br><br>
	</div>
	<div style = "width:100%" >
		<table id="endorItemInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     收付费方式信息</td>
			</tr>
			<tr> 
				<td class="left">收付费方式：</td>
				<td class="right">
					<input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" >
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">补退费领取人：</td>
				<td class="right">张三</td>
				<td class="left">身份证号：</td>
				<td class="right">42154613131455</td>
				<td class="common"></td>
				<td class="common"></td>	
			</tr>
			<tr> 
				<td class="left">是否强制人工核保：</td>
				<td class="right">
					<input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" >
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>			
		</table>
	</div>
	<div style = "width:100%">
		<table>
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="ApplyConfirm" value="申请确认" onclick="">
					<input type = "button" class="cssbutton" name="ReturnBack" value="返  回" onclick="javascript:history.go(-1);">
				</td>				
			</tr>
		</table>		
	</div>
	</form>
  </body>
</html>
