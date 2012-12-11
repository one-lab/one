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
    
    <title>无名单补名单</title>
    
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
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     集体合同信息</td>
			</tr>
			<tr> 
				<td class="left">投保单号：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">呈报件号：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">销售渠道：</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" ></td>
			</tr>
			<tr> 
				<td  class="left">中介机构：</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:90%" ></td>
				<td class="left">投保申请日期：</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='2012-04-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="left">保单生效日期：</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='2012-04-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
			<tr>
				<td class="left">管理机构：</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" ></td>
				<td class="left">财务收费日期：</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='2012-04-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr>
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr> 
				<td class="left">业务员代码：</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:90%" ></td>
				<td class="left">业务员姓名：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">所属机构：</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" ></td>
			</tr>
			<tr> 
				<td class="left">所属分部：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>
				<td class="left">星级业务员：</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" ></td>
				<td class="left">多业务员，请勾选：</td>
				<td class="right"><input type="checkbox" name="checkbox" value="checkbox"></td>
			</tr>
		</table>
		<hr>
		<table id="CompanyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">投保单位资料（客户号）</td>
			</tr>
			<tr>
				<td class="left">单位名称：</td>
				<td class="right"><input name="GrpName" class="common" type="text" ></td>
				<td class="left">资产总额（万元）：</td>
				<td class="right"><input name="Money" class="common" type="text" ></td>				
				<td class="left">单位性质：</td>
				<td class="right"><input name="CompanyNature" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">行业类别：</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" ></td>
				<td class="left">员工总数：</td>
				<td class="right"><input name="Money" class="common" type="text" ></td>
				<td class="left">单位传真：</td>
				<td class="right"><input name="RegistNo" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">社保登记证号：</td>
				<td class="right"><input name="SocialSecurityNo" class="common" type="text" ></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>			
			</tr>
			<tr>
				<td class="left">单位地址编码：</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:90%" ></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>			
			</tr>
			<tr>
				<td class="left">单位地址：</td>
				<td class="right" colspan="3"><input name="AdressNo" class="common" type="text" ></td>
				<td class="left">邮政编码：</td>
				<td class="right"><input name="ZipCode" class="common" type="text" ></td>
			</tr>			
			<tr>
				<td class="left">保险联系人一</td>
			</tr>
			<tr>
				<td class="left">姓名：</td>
				<td class="right"><input name="Telephone1" class="common" type="text" ></td>
				<td class="left">联系电话：</td>
				<td class="right"><input name="Department" class="common" type="text" ></td>
				<td class="left">E-MAIL：</td>
				<td class="right"><input name="Department" class="common" type="text" ></td>	
			</tr>
			<tr>
				<td class="left">部门：</td>
				<td class="right" colspan="3"><input name="AdressNo" class="common" type="text" ></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
			<tr>
				<td class="left">保险联系人二</td>
			</tr>
			<tr>
				<td class="left">姓名：</td>
				<td class="right"><input name="Telephone1" class="common" type="text" ></td>
				<td class="left">联系电话：</td>
				<td class="right"><input name="Department" class="common" type="text" ></td>
				<td class="left">E-MAIL：</td>
				<td class="right"><input name="Department" class="common" type="text" ></td>	
			</tr>
			<tr>
				<td class="left">部门：</td>
				<td class="right" colspan="3"><input name="AdressNo" class="common" type="text" ></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">付款方式：</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" ></td>
				<td class="left">开户银行：</td>
				<td class="right"><input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" ></td>
				<td class="left">账号 ：</td>
				<td class="right"><input name="MainInsuredCount" class="common" type="text" ></td>
			</tr>
		</table>
	</div>
	<div style="width:80%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" >备注</td>
			</tr>
			<tr>
				<td colspan="3"><textarea id="clmHistory"  name="lcRepInfo.clmHistory" cols="100%" rows="5"></textarea></td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     集体保单险种信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="14%">险种编码</td>
					<td width="13%">险种名称</td>
					<td width="13%">交费期间</td>
					<td width="13%">参保人数</td>
					<td width="13%">保费/保额合计</td>	
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckBox" type="CheckBox" value="" /></td>
					<td>1</td>
					<td>SE86012012005</td>
					<td>P5646860101</td>
					<td>新华书店</td>
					<td>11</td>
					<td>860101</td>
				</tr>
				<tr class="content">
					<td><input name="CheckBox" type="CheckBox" value="" /></td>
					<td>2</td>
					<td>SE86012012005</td>
					<td>P5646860101</td>
					<td>新华书店</td>
					<td>11</td>
					<td>860101</td>
				</tr>								
			</tbody>
		</table>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="EndorAccept" value="补名单" onclick="">
					<input type = "button" class="cssbutton" name="EndorAccept" value="保险计划查看" onclick="location.href='./AddFreeListInput.jsp'">
				</td>
			</tr>
		</table>
	</div>
	<div style="width:100%">
		<hr>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="95%" align="right"><input type = "button" class="cssbutton" name="EndorAccept" value="团体问题件查询" onclick=""></td>
				<td width="5%" align="left"><input type = "button" class="cssbutton" name="EndorAccept" value="返  回" onclick="javascript:history.go(-1);"></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
