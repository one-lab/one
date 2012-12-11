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
    
    <title>案件调查信息录入</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript">
		function showPage()
		{
			tt = document.getElementById("Affix");
			tt.style.display="block";
		}
		</script>

  </head>
  
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style="width:100%">
		<table id="SurveyApplyInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">调查申请详细信息</td>
			</tr>
			<tr>
				<td  class="left">赔案号：</td>
				<td  class="right"><input name="ClaimNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">调查序号：</td>
				<td  class="right"><input name="SurveyNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">出险人姓名：</td>
				<td  class="right"><input name="AppntName" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">申请人：</td>
				<td  class="right"><input name="Apply" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">申请日期：</td>
				<td  class="right"><input name="ApplyDate" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">提起阶段：</td>
				<td  class="right">
					<input class="codecode" id="stateCode" name="lcReport.stateCode" class="common" type="text" value="" style="width:20%" ><input name="liftState" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td  class="left">调查机构：</td>
				<td  class="right">
					<input class="codecode" id="surveyCom" name="lcReport.surveyCom" class="common" type="text" value="210026" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="都邦北京分公司">
				</td>
				<td  class="left">发起机构：</td>
				<td  class="right">
					<input class="codecode" id="startCom" name="lcReport.startCom" class="common" type="text" value="210026" style="width:20%"><input name="startComName" class="common" type="text" onchange="clickable()" style="width:68%" value="都邦北京分公司">
				</td>
				<td  class="left">调查原因：</td>
				<td  class="right">
					<input class="codecode" id="surveyReasonCode" name="lcReport.surveyReasonCode" class="common" type="text" value="" style="width:20%"><input name="surveyReason" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td  class="left">本地标志：</td>
				<td  class="right"><input name="localFlag" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td>调查内容</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="surveyContent" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
			<tr>
				<td >备注信息</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="remarkContent" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<hr />
		<table id="SurveyProcess" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">调查过程</td>
			</tr>
			<tr>
				<td  class="left">调查方式：</td>
				<td  class="right">
					<input class="codecode" id="surveyTypeCode" name="lcReport.surveyTypeCode" class="common" type="text" value="" style="width:20%"><input name="surveyType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">调查地点：</td>
				<td  class="right"><input name="SurveyAddress" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">调查日期：</td>
				<td class="right">
					<input name="SurveyDate" id="SurveyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'SurveyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td  class="left">被调查人：</td>
				<td  class="right"><input name="Survey" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">调查员：</td>
				<td  class="right"><input name="Investigator" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type="button" class="cssbutton" name="SurveyAffix" value="调查单证" onclick="showPage()" /></td>
			</tr>
		</table>
		<div style="width:100%" id="Affix" style="display:none">
			<table id="AffixList" class="common" cellpadding="3" cellspacing="0">
				<thead>
					<tr class="tableHead">
						<td width="4%">序号</td>
						<td width="20%">单证类型</td>
						<td width="20%">单证名称</td>
						<td width="13%">原件标志</td>
						<td width="13%">张数</td>
						<td width="30%">备注信息</td>
					</tr>
				</thead>
				<tbody>
					<tr class="content">
						<td>1</td>
						<td>11111111</td>
						<td>1111111</td>
						<td>1111111</td>
						<td>11111111</td>
						<td>1111111</td>
					</tr>
				</tbody>
			</table>
			<table id="RegisterInfor" class="common" cellpadding="1" cellspacing="1" >
				<tr>
					<td  class="left">单证名称：</td>
					<td  class="right">
						<input class="codecode" id="affixNameCode" name="lcReport.affixNameCode" class="common" type="text" value="" style="width:20%"><input name="affixName" class="common" type="text" onchange="clickable()" style="width:68%" value="">
					</td>
					<td  class="common"> </td>
					<td  class="common"> </td>
					<td  class="common"> </td>
					<td  class="common"> </td>
				</tr>
			</table>
			<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td>
						<input type="button" class="cssbutton" name = "confButton" value="确  认" onclick="">
						<input type="button" class="cssbutton" name = "cancelButton" value="取  消" onclick="">
					</td>
				</tr>
			</table>
		</div>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td  class="left">调查过程附件管理</td>
				<td>
					<input type="button" class="cssbutton" name="uploadAnnex" value="上传附件" onclick="" />
					<input type="button" class="cssbutton" name="delAnnex" value="删除附件" onclick="" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td colspan="6">调查过程录入(包括符号最多900汉字)</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="accidentDesc" cols="" rows="4" style="width:98%"></textarea><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td colspan="6">备注信息(包括符号最多450汉字)</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="remarks" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="saveButton" value="保  存" onclick="" />
					<input type="button" class="cssbutton" name="queryButton" value="查询过程" onclick="self.location.href='${ctx}/claim/surveymanage/SurveyInfoQuery.jsp'" />
				</td>
				
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">查勘费用录入</td>
			</tr>
			<tr>
				<td  class="left">费用类型：</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">费用金额：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td  class="left">发生时间：</td>
				<td class="right">
					<input name="HappenDate" id="HappenDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'HappenDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td  class="left">领款人：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">领款方式：</td>
				<td  class="right">
					<input class="codecode" id="receTypeCode" name="lcReport.receTypeCode" class="common" type="text" value="" style="width:20%"><input name="receType" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td  class="left">费用总计：</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td colspan="6">备注(包括符号最多450汉字)</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="remarks" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="saveButton" value="保  存" onclick="" />
					<input type="button" class="cssbutton" name="queryFee" value="查询费用" onclick="self.location.href='${ctx}/claim/surveymanage/SurveyFeeQuery.jsp'" />
				</td>
			</tr>
		</table>
		<hr />
		<table id="SurveyResult" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">调查结论录入</td>
			</tr>
			<tr>
				<td colspan="6">调查结论(包括符号最多900汉字)</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="SurveyResult" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="sureButton" value="确  认" onclick="" />
					<input type="button" class="cssbutton" name="returnButton" value="返  回" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
