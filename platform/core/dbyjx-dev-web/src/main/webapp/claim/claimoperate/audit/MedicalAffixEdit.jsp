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
    
	    <title>医疗单证录入</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>
		<script type="text/javascript">
		function showAllPage()
		{
			tt = document.getElementById("AffixInfo");
			tt.style.display="block";
		}
		function hidAllPage()
		{
			alter("test")
			tt = document.getElementById("AffixInfo");
			tt.style.display="none";
		}
		function showPage()
		{
			tt = document.getElementByName("AddButton");
			tt.style.display="block";
		}
		function hidPage()
		{
			tt = document.getElementById("HidButton");
			tt.style.display="none";
		}
		</script>

	</head>
<body>
	<form name="fm" method="post" onkeypress="KeyDown()">
	<div style="width:100%">
		<table id="QueryCondition" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">请输入查询条件</td>
			</tr>
			<tr>
				<td  class="left">费用类型：</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
	</div>
	<div style="width:100%" id="AffixInfo" style="display:none">
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">门诊单证录入信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">医院名称</td>
					<td width="9%">医院等级</td>
					<td width="10%">开始日期</td>
					<td width="10%">结束日期</td>
					<td width="10%">天数</td>
					<td width="10%">费用类型</td>
					<td width="15%">费用金额</td>
					<td width="15%">自负金额</td>
				</tr>
		    </thead>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">费用总计：</td>
				<td class="right"><input name="FeeTotal" class="common" type="text" onchange="clickable()"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="FeeBillInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">账单号：</td>
				<td class="right"><input name="BillNum" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">医院名称：</td>
				<td class="right">
					<input class="codecode" id="hosCode" name="lcReport.hosCode" class="common" type="text" value="" style="width:20%"><input name="hosName" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">费用类型：</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">费用金额：</td>
				<td class="right"><input name="FeeMount" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">自负金额：</td>
				<td  class="right"><input name="MountSelf" class="common" type="text" onchange="clickable()"></td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
			<tr>
				<td class="left">开始日期：</td>
				<td class="right">
					<input name="StartDate1" id="StartDate1" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'StartDate1',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">结束日期：</td>
				<td class="right">
					<input name="EndDate1" id="EndDate1" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'EndDate1',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="增  加" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "DelButton" value="删  除" onClick="" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="修  改" onClick="" />
					<input type="button" class="cssbutton" name = "HidButton" value="隐  藏" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">住院单证录入信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">医院名称</td>
					<td width="10%">医院等级</td>
					<td width="10%">开始日期</td>
					<td width="10%">结束日期</td>
					<td width="10%">天数</td>
					<td width="9%">费用类型</td>
					<td width="15%">费用金额</td>
					<td width="15%">自负金额</td>
				</tr>
		    </thead>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">费用总计：</td>
				<td class="right"><input name="FeeTotal" class="common" type="text" onchange="clickable()"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="FeeBillInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">账单号：</td>
				<td class="right"><input name="BillNum" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">医院名称：</td>
				<td class="right">
					<input class="codecode" id="hosCode" name="lcReport.hosCode" class="common" type="text" value="" style="width:20%"><input name="hosName" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">费用类型：</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">费用金额：</td>
				<td class="right"><input name="FeeMount" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">自负金额：</td>
				<td  class="right"><input name="MountSelf" class="common" type="text" onchange="clickable()"></td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
			<tr>
				<td class="left">开始日期：</td>
				<td class="right">
					<input name="StartDate1" id="StartDate1" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'StartDate1',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">结束日期：</td>
				<td class="right">
					<input name="EndDate1" id="EndDate1" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'EndDate1',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="增  加" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "DelButton" value="删  除" onClick="" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="修  改" onClick="" />
					<input type="button" class="cssbutton" name = "HidButton" value="隐  藏" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">伤残录入信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">残疾类型</td>
					<td width="15%">伤残级别名称</td>
					<td width="14%">伤残代码</td>
					<td width="10%">残疾给付比例</td>
					<td width="10%">申请给付比例</td>
					<td width="15%">鉴定机构名称</td>
					<td width="15%">鉴定时间</td>
				</tr>
		    </thead>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">残疾类型：</td>
				<td class="right">
					<input class="codecode" id="injuryCode" name="lcReport.injuryCode" class="common" type="text" value="" style="width:20%"><input name="injuryType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">伤残级别：</td>
				<td  class="right">
					<input class="codecode" id="injuryCode" name="lcReport.injuryCode" class="common" type="text" value="" style="width:20%"><input name="injuryGrade" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">伤残代码：</td>
				<td class="right">
					<input class="codecode" id="injuryCode" name="lcReport.injuryCode" class="common" type="text" value="" style="width:20%"><input name="injuryCode" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">残疾给付比例：</td>
				<td class="right"><input name="InjuryGetRate" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">鉴定机构：</td>
				<td  class="right"><input name="AppraCom" class="common" type="text" onchange="clickable()"></td>
				<td class="left">鉴定日期：</td>
				<td class="right">
					<input name="AppraDate" id="AppraDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'AppraDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="增  加" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "DelButton" value="删  除" onClick="" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="修  改" onClick="" />
					<input type="button" class="cssbutton" name = "HidButton" value="隐  藏" onclick="hidPage()" />
					<input type="button" class="cssbutton" name = "InjuryCodeQuery" value="伤残代码查询" onclick="" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">住院津贴录入信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="20%">医院名称</td>
					<td width="17%">医院等级</td>
					<td width="20%">住院日期</td>
					<td width="20%">出院日期</td>
					<td width="17%">住院天数</td>
				</tr>
		    </thead>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">医院名称：</td>
				<td class="right">
					<input class="codecode" id="hosCode" name="lcReport.hosCode" class="common" type="text" value="" style="width:20%"><input name="hosName" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">住院类型：</td>
				<td  class="right">
					<input class="codecode" id="inHosCode" name="lcReport.inHosCode" class="common" type="text" value="" style="width:20%"><input name="inHosType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
			<tr>
				<td class="left">住院日期：</td>
				<td class="right">
					<input name="InHosDate" id="InHosDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'InHosDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">出院日期：</td>
				<td class="right">
					<input name="OutHosDate" id="OutHosDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'OutHosDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">住院天数：</td>
				<td class="right"><input name="InHosDay" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="增  加" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "DelButton" value="删  除" onClick="" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="修  改" onClick="" />
					<input type="button" class="cssbutton" name = "HidButton" value="隐  藏" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">手术津贴录入信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="10%">手术类型</td>
					<td width="15%">手术代码</td>
					<td width="15%">手术名称</td>
					<td width="10%">津贴等级</td>
					<td width="14%">津贴金额</td>
					<td width="15%">医疗机构名称</td>
					<td width="15%">手术日期</td>
				</tr>
		    </thead>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">手术类型：</td>
				<td  class="right">
					<input class="codecode" id="OpsTypeCode" name="lcReport.OpsTypeCode" class="common" type="text" value="" style="width:20%"><input name="OpsType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">手术编码：</td>
				<td  class="right">
					<input class="codecode" id="OpsCode" name="lcReport.OpsCode" class="common" type="text" value="" style="width:20%"><input name="OpsCode" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">津贴等级：</td>
				<td  class="right"><input name="SubsidyGrade" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">医疗机构名称：</td>
				<td  class="right"><input name="MedicalName" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">手术日期：</td>
				<td class="right">
					<input name="OpsDate" id="OpsDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'OpsDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="增  加" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "DelButton" value="删  除" onClick="" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="修  改" onClick="" />
					<input type="button" class="cssbutton" name = "HidButton" value="隐  藏" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">社保补充给付</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="20%">费用类型</td>
					<td width="17%">费用代码</td>
					<td width="20%">费用名称</td>
					<td width="17%">费用金额</td>
					<td width="20%">服务机构名称</td>
				</tr>
		    </thead>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">费用类型：</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">费用编码：</td>
				<td  class="right">
					<input class="codecode" id="feeCode" name="lcReport.feeCode" class="common" type="text" value="" style="width:20%"><input name="feeCode" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">费用金额：</td>
				<td  class="right"><input name="FeeMount" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">服务机构名称：</td>
				<td  class="right"><input name="ServiceName" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td >备注</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="AccidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="增  加" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "DelButton" value="删  除" onClick="" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="修  改" onClick="" />
					<input type="button" class="cssbutton" name = "HidButton" value="隐  藏" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">特殊手术给付</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="17%">手术类型</td>
					<td width="17%">手术代码</td>
					<td width="20%">手术名称</td>
					<td width="20%">医疗机构名称</td>
					<td width="20%">手术日期</td>
				</tr>
		    </thead>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">手术类型：</td>
				<td  class="right">
					<input class="codecode" id="OpsTypeCode" name="lcReport.OpsTypeCode" class="common" type="text" value="" style="width:20%"><input name="OpsType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">手术编码：</td>
				<td  class="right">
					<input class="codecode" id="OpsCode" name="lcReport.OpsCode" class="common" type="text" value="" style="width:20%"><input name="OpsCode" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td  class="left">服务机构名称：</td>
				<td  class="right"><input name="ServiceName" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">手术日期：</td>
				<td class="right">
					<input name="OpsDate2" id="OpsDate2" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'OpsDate2',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="增  加" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "DelButton" value="删  除" onClick="" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="修  改" onClick="" />
					<input type="button" class="cssbutton" name = "HidButton" value="隐  藏" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">其他费用</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="20%">费用类型</td>
					<td width="17%">费用代码</td>
					<td width="20%">费用名称</td>
					<td width="17%">费用金额</td>
					<td width="20%">服务机构名称</td>
				</tr>
		    </thead>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">费用类型：</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">费用编码：</td>
				<td  class="right">
					<input class="codecode" id="feeCode" name="lcReport.feeCode" class="common" type="text" value="" style="width:20%"><input name="feeCode" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">费用金额：</td>
				<td  class="right"><input name="FeeMount" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">服务机构名称：</td>
				<td  class="right"><input name="ServiceName" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td >备注</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="AccidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AddButton" value="增  加" onClick="showPage()" />
					<input type="button" class="cssbutton" name = "DelButton" value="删  除" onClick="" />
					<input type="button" class="cssbutton" name = "ModifyButton" value="修  改" onClick="" />
					<input type="button" class="cssbutton" name = "HidButton" value="隐  藏" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<hr />
	</div>
	<div style="width:100%">
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AppButton" value="查看全部" onClick="showAllPage()" />
					<input type="button" class="cssbutton" name = "AppButton" value="隐藏全部" onClick="HidAllPage()" />
					<input type="button" class="cssbutton" name = "AppButton" value="返  回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>