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
    
	    <title>���������Ϣ�鿴</title>
	    
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
	<div style="width:100%">
		<table id="SurveyFeeList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">���ⰸ�����е�������б�</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="15%">�ⰸ��</td>
					<td width="15%">�������</td>
					<td width="12%">�������</td>
					<td width="10%">��������</td>
					<td width="12%">����ʱ��</td>
					<td width="10%">���ý��</td>
					<td width="10%">�����</td>
					<td width="10%">������</td>
				</tr>
			</thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="5%" align='right'><input type = "button" class="cssbutton" value="��  ҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="85%"><input type = "button" class="cssbutton" value="β  ҳ"></td>
			</tr>
		</table>
		<table id="SurveyFeeInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�鿴���������ϸ��Ϣ</td>
			</tr>
			<tr>
				<td  class="left">�ⰸ�ţ�</td>
				<td  class="right"><input name="claimNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">������ţ�</td>
				<td  class="right">
					<input name="surveyNum" class="common" type="text" onchange="clickable()">
				</td>
				<td  class="left">���������</td>
				<td  class="right">
					<input class="codecode" id="surveyCom" name="lcReport.surveyCom" class="common" type="text" value="210026" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="������ֹ�˾">
				</td>
			</tr>
			<tr>
				<td  class="left">�������ͣ�</td>
				<td  class="right">
					<input class="codecode" id="feeTypeCode" name="lcReport.feeTypeCode" class="common" type="text" value="" style="width:20%"><input name="feeType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">���ý�</td>
				<td  class="right"><input name="FeeMount" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">����ʱ�䣺</td>
				<td  class="right">
					<input name="HappDate" id="HappDate" class="common" type="text" onchange="clickable()" />
				</td>
			</tr>
			<tr>
				<td  class="left">����ˣ�</td>
				<td  class="right"><input name="payee" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">��ʽ��</td>
				<td  class="right">
					<input class="codecode" id="receTypeCode" name="lcReport.receTypeCode" class="common" type="text" value="" style="width:20%"><input name="receType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<table id="RemarksContent" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td colspan="6">��ע </td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="remarkContent" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type="button" class="cssbutton" name="returnButton" value="��  ��" onclick="javascript:history.back();" /></td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>