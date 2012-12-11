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
		<table id="FeeInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="2"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">费用类型</td>
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
		<table id="ServiceAffixInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">门诊单证录入信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="17%">医院名称</td>
					<td width="10%">医院等级</td>
					<td width="10%">开始日期</td>
					<td width="10%">结束日期</td>
					<td width="10%">天数</td>
					<td width="10%">费用类型</td>
					<td width="17%">费用金额</td>
					<td width="10%">特殊标志</td>
				</tr>
		    </thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "HidButton" value="隐  藏" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<table id="ServiceAffixInfo" class="common" cellpadding="3" cellspacing="1">
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
			</tr>
			<tr>
				<td class="left">天数：</td>
				<td class="right"><input name="BillNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">距离意外事故发生天数：</td>
				<td  class="right"><input name="AccidDays" class="common" type="text" onchange="clickable()"></td>
				<td class="left">距离出险日期天数：</td>
				<td class="right"><input name="AppntDays" class="common" type="text" onchange="clickable()"></td>
			</tr>
		</table>
		<hr />
		<table id="HosAffixInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">住院单证录入信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="17%">医院名称</td>
					<td width="10%">医院等级</td>
					<td width="10%">开始日期</td>
					<td width="10%">结束日期</td>
					<td width="10%">天数</td>
					<td width="10%">费用类型</td>
					<td width="17%">费用金额</td>
					<td width="10%">特殊标志</td>
				</tr>
		    </thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "HidButton" value="隐  藏" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<table id="HosAffixInfo" class="common" cellpadding="3" cellspacing="1">
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
				<td class="left">开始日期：</td>
				<td class="right">
					<input name="StartDate2" id="StartDate2" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'StartDate2',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">结束日期：</td>
				<td class="right">
					<input name="EndDate2" id="EndDate2" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'EndDate2',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">实际住院天数：</td>
				<td class="right"><input name="BillNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">距离意外事故发生天数：</td>
				<td  class="right"><input name="AccidDays" class="common" type="text" onchange="clickable()"></td>
				<td class="left">距离出险日期天数：</td>
				<td class="right"><input name="AppntDays" class="common" type="text" onchange="clickable()"></td>
			</tr>
		</table>
		<hr />
		<table id="DisableInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">伤残录入信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">残疾类型</td>
					<td width="17%">伤残级别名称</td>
					<td width="15%">伤残代码</td>
					<td width="10%">残疾给付比例</td>
					<td width="10%">申请给付比例</td>
					<td width="12%">鉴定机构名称</td>
					<td width="15%">鉴定时间</td>
				</tr>
		    </thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "HidButton" value="隐  藏" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<table id="DisableInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">残疾类型：</td>
				<td class="right">
					<input class="codecode" id="injuryTypeCode" name="lcReport.injuryTypeCode" class="common" type="text" value="" style="width:20%"><input name="injuryType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">伤残级别：</td>
				<td  class="right">
					<input class="codecode" id="injuryGradeCode" name="lcReport.injuryGradeCode" class="common" type="text" value="" style="width:20%"><input name="injuryGrade" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
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
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'AppraDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
		</table>
		<hr />
		<table id="SpeciInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">特定手术、特种疾病与特定给付信息</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">类型</td>
					<td width="15%">代码</td>
					<td width="17%">名称</td>
					<td width="15%">金额</td>
					<td width="17%">医疗机构名称</td>
					<td width="15%">确诊日期</td>
				</tr>
		    </thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "HidButton" value="隐  藏" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<table id="SpeciInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">类型：</td>
				<td class="right">
					<input class="codecode" id="typeCode" name="lcReport.typeCode" class="common" type="text" value="" style="width:20%"><input name="type" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">代码：</td>
				<td  class="right">
					<input class="codecode" id="Code" name="lcReport.Code" class="common" type="text" value="" style="width:20%"><input name="Code" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">金额：</td>
				<td  class="right"><input name="Mount" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">医疗机构名称：</td>
				<td class="right"><input name="HosName" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">确诊日期：</td>
				<td class="right">
					<input name="DiagnDate" id="DiagnDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'DiagnDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="SpeciFeeList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">特种费用</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="10%">费用类型</td>
					<td width="10%">特种费用代码</td>
					<td width="17%">特种费用名称</td>
					<td width="10%">特种费用金额</td>
					<td width="17%">服务机构名称</td>
					<td width="15%">起始日期</td>
					<td width="15%">结束日期</td>
				</tr>
		    </thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "HidButton" value="隐  藏" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<table id="SpeciFeeInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">费用类型：</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">特种费用代码：</td>
				<td  class="right">
					<input class="codecode" id="speciFeeCode" name="lcReport.speciFeeCode" class="common" type="text" value="" style="width:20%"><input name="speciFee" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">特种费用金额：</td>
				<td  class="right"><input name="SubsidyGrade" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">服务机构名称：</td>
				<td  class="right"><input name="MedicalName" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">起始日期：</td>
				<td class="right">
					<input name="StartDate3" id="StartDate3" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'StartDate3',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">结束日期：</td>
				<td class="right">
					<input name="EndDate3" id="EndDate3" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'EndDate3',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
		</table>
		<hr />
		<table id="ThirdFeeList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">社保第三方给付</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="18%">费用类型</td>
					<td width="18%">费用代码</td>
					<td width="20%">费用名称</td>
					<td width="18%">费用金额</td>
					<td width="20%">服务机构名称</td>
				</tr>
		    </thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "HidButton" value="隐  藏" onclick="hidPage()" />
				</td>
			</tr>
		</table>
		<table id="ThirdFeeInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">费用类型：</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">费用代码：</td>
				<td  class="right">
					<input class="codecode" id="FeeCode" name="lcReport.FeeCode" class="common" type="text" value="" style="width:20%"><input name="Fee" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
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