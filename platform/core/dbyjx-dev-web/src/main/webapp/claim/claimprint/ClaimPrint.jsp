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
    
	    <title>�ⰸ��ӡ</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>
	</head>
<body>
	<form name="fm" method="post" onKeyPress="KeyDown()">
	<div style="width:100%">
		<table id="ClaimInfoQuery" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�������ѯ����(������Ҫһ������������ѡ���ⰸ״̬��������������������)��</td>
			</tr>
			<tr>
				<td class="left">�ⰸ�ţ�</td>
				<td class="right"><input name="ClaimNum" class="common" type="text" onChange="clickable()"></td>
				<td class="left">�ⰸ״̬��</td>
				<td class="right">
					<input class="codecode" id="claimStateCode" name="lcReport.claimStateCode" class="common" type="text" value="" style="width:20%" ><input name="claimState" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">��ͬ�ţ�</td>
				<td class="right"><input name="ContNum" class="common" type="text" onChange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">�����˱��룺</td>
				<td class="right"><input name="AppntCode" class="common" type="text" onChange="clickable()"></td>
			
				<td class="left">������������</td>
				<td class="right"><input name="AppntName" class="common" type="text" onChange="clickable()"></td>
				<td  class="left">�¹����ڣ�</td>
				<td class="right">
					<input name="AccidDate" id="AccidDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'AccidDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
			<tr>
				<td  class="left">�������ڣ�</td>
				<td class="right">
					<input name="AppDate" id="AppDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'AppDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td  class="left">�������ڣ�</td>
				<td class="right">
					<input name="RegisterDate" id="RegisterDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'RegisterDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td  class="left">�᰸���ڣ�</td>
				<td class="right">
					<input name="EndDate" id="EndDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'EndDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
			<tr>
				<td class="left">�����ⰸ�ţ�</td>
				<td class="right"><input name="UnitClaimNum" class="common" type="text" onChange="clickable()"></td>
				<td class="left">���屣���ţ�</td>
				<td class="right"><input name="UnitAppNum" class="common" type="text" onChange="clickable()"></td>
				<td class="common"> </td>
				<td class="common"> </td>
			</tr>
		</table>
		<table id="ClaimQuery" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "queryButton" value="��  ѯ" onClick="" />
				</td>
			</tr>
		</table>
		<table id="ClaimTab" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�ⰸ�б�</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="6%">���</td>
					<td width="15%">�ⰸ��</td>
					<td width="15%">״̬</td>
					<td width="15%">�����˱���</td>
					<td width="15%">����������</td>
					<td width="10%">�Ա�</td>
					<td width="15%">��������</td>
				</tr>
			</thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="��  ҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="β  ҳ"></td>
			</tr>
		</table>
		<hr />
		<table id="ClaimInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "ClaimQuery" value="�ⰸ��ѯ" onClick="self.location.href='${ctx}/claim/claimoperate/endcase/EndCaseInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name = "printButton" value="�ⰸ��ӡ" onClick="self.location.href='${ctx}/claim/claimprint/ClaimAffixPrint.jsp'" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>