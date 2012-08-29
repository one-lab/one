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
    
    <title>投保单初审录入</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">	ctx = "${ctx}";</script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/proposalPre/ProposalPreApply.js"></script>	
	<script type="text/javascript">
	/*
	*页面初始化时选判断保存按钮是否可用
	*/
    $(function(){
    	saveButtonIsAble();
    });
	</script>
</head>
  <body>
    <form id="proposalPreForm" name="fm" method="post">
	<div style = "width:100%">
		<table id="proposalAppInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">投保信息</td>
			</tr>
			<tr>
				<td class="left">投保单号：</td>                                                           
				<td class="right"><input id="grpContNo" name="GrpContNo" value='<s:property value="lcGrpCont.grpContNo" />' class="common"  readonly="readonly" type="text" /></td>
				<td class="left">管理机构：
				<input type="hidden" id ="upperComCode" value='2110000000'/>  </td>
				<td class="right"><input id="comCode" name="comCode" class="codecode" type="text" ondblclick="queryCode('comCode','comName','PrpDcompany','comCode:comCode|upperComCode:upperComCode')" value='<s:property value="lcGrpCont.manageCom"/> ' readonly="readonly" style="width:20%"><input id="comName" name="comName" class="common" type="text" value=''  style="width:68%"></td>
				<td class="left">初审日期：</td>
				<td class="right"><input name="StartDate" id="FirstApplyDate" class="common"  value='<s:property value="lcGrpCont.firstTrialDate" />'  readonly="readonly" type="text" ></td>
			</tr>
		</table>
		<hr>
		
		<table id="GrpComInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     投保单位信息</td>
			</tr>
			<tr>
			 	<td  class="left">投保单位全称：</td>
				<td  class="right"><input id="GrpName" name="name" value='<s:property value="lcGrpCont.grpName"/>' class="common" type="text"><img src="${ctx}/images/bgMarkMustInput.jpg"></td>
				<td  class="left">主揽业务员编码：</td>
				<td class="right"><input id="MainAgentCode" name="comCode" class="codecode" value='<s:property value="lcGrpCont.handlerName"/>' type="text" ondblclick="queryCode('MainAgentCode','MainAgentName','PDLDcode1','codeType:MainAgent')" style="width:20%" ><input id="MainAgentName" name="MainAgentName" class="common" type="text" onchange="clickable()" style="width:68%"></td>
			    <td  class="left">呈报号：</td>
				<td  class="right"><input id="reportNo" name="ReportNo" class="common" type="text" value='<s:property value="lcGrpCont.reportNo"/>'></td>
			</tr>
			<tr>
				<td  class="left">销售方式：</td>
				<td class="right"><input id="codeType" name="SaleType" value='<s:property value="lcGrpCont.grpSellType"/>' class="codecode" type="text" ondblclick="queryCode('codeType','codeName','PDLDcode1','codeType:SaleType')"   style="width:20%"><input id="codeName" name="saleName" class="common" type="text" value=""  onchange="clickable()" style="width:68%"></td>
				<td  class="left">保费合计：</td>
				<td  class="right"><input id="prem" name="Prem" class="common" value='<s:property value="lcGrpCont.prem"/>' type="text"><img src="${ctx}/images/bgMarkMustInput.jpg"></td>
				<td  class="left">预打保单标记：</td>
				<td class="right"><input id="IsPrintFlagType" name="IsPrintFlag" class="codecode" type="text" ondblclick="queryCode('IsPrintFlagType','IsPrintFlagName','PDLDcode1','codeType:PrePrintFlag')" value= '<s:property value="lcGrpCont.previewPrintFlag"/>'  style="width:20%"><input id="IsPrintFlagName" name="comName" class="common" type="text"  onchange="clickable()" style="width:68%"></td>
			</tr>
			<tr>
				<td  class="left">协议录入标志：</td>
				<td class="right"><input id="AgreementFlagType" name="AgreementFlag" class="codecode" type="text"  ondblclick="queryCode('AgreementFlagType','AgreementFlagName','PDLDcode1','codeType:AgreementFlag')"  style="width:20%"><input id="AgreementFlagName" name="AgreementFlagName" class="common" type="text"  onchange="clickable()" style="width:68%"></td>
			</tr>
			
		</table>
		
		<br><br>
		<table id="ButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="10%" align='left'><input type = "button" class="cssbutton" id="reportView" name="ReportView" value="呈报件查看" onclick="findReportInfo()"></td>
				<td width="15%" align='left'><input  type = "button" class="cssbutton" id="showNotepad" name="NoteView" value="记事本查看（共1条）" onclick="findNoteInfo()"></td>
				<td width="35%" align='right'><input type = "button" id="save" class="cssbutton" name="save" value="保  存" onclick="saveProposalInfo()"></td>
				<td width="5%"><input type = "button" class="cssbutton" name="Update" value="修  改" onclick="editProposalInfo()"></td>
				<td width="5%"><input type = "button" class="cssbutton" name="Confirm" value="初审确认" onclick="proposalPreConfirm()"></td>
				<td width="30%"><input type = "button" class="cssbutton" name="ReturnBack" value="返  回" onclick="javascript:history.go(-1);"></td>
			</tr>
		</table>
	</div>
	<%--隐藏域客户号 --%>
	 <input id="CustomerNo" name="appno" value='<s:property value="lcGrpCont.appntNo"/>' type="hidden">
	 <%--隐藏域记事本录入位置标记 --%>
	 <input type="hidden" id="inputLocation" value="01">
	 <!-- 当mark为0时说明用户点击的是申请按钮，为1时说明用户点击的是查看按钮 -->
	 <input type="hidden" id="mark" value=<s:property value="mark"/>>
	
	</form>
	<!-- 保存查询条件，初审确认后查询信息重新回写 -->
	<form id="fmTem" name="fmTem"  method="post" ">
	<input id="comCode" name="lcGrpCont.manageCom" value='<s:property value="#session.lcGrpContInfo.manageCom"/>'  type="hidden">
	<input id="GrpContNo" name="lcGrpCont.grpContNo" value='<s:property value="#session.lcGrpContInfo.grpContNo" />' type="hidden">
	<input id="repApplyDate" name="lcGrpCont.firstTrialDate" value='<s:property value="#session.lcGrpContInfo.firstTrialDate" />'  type="hidden">
	<input id="grpName" name="lcGrpCont.grpName" value='<s:property value="#session.lcGrpContInfo.grpName" />'  type="hidden">
	<input id="MainAgentName" name="lcGrpCont.handlerName" value='<s:property value="#session.lcGrpContInfo.handlerName" />'  type="hidden">
	</form>
  </body>
</html>
