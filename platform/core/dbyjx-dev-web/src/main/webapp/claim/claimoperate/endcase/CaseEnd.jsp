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
    
	    <title>�����᰸</title>
	    
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
		<table id="ClaimInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�ⰸ��ϸ��Ϣ</td>
			</tr>
			<tr>
				<td  class="left">�ְ��ţ�</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td class="left">�ⰸ״̬��</td>
				<td class="right">
					<input class="codecode" id="claimStateCode" name="lcReport.claimStateCode" class="common" type="text" value="" style="width:20%" ><input name="claimState" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">�⸶���ۣ�</td>
				<td  class="right">
					<input class="codecode" id="resultCode" name="lcReport.resultCode" class="common" type="text" value="" style="width:20%"><input name="result" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td  class="left">����Ա��</td>
				<td  class="right">
					<input name="Relationship" class="common" type="text" onchange="clickable()">
				</td>
				<td  class="left">�᰸���ڣ�</td>
				<td  class="right">
					<input name="RgtantName" class="common" type="text" onchange="clickable()">
				</td>
				<td  class="left">ʵ����־��</td>
				<td  class="right">
					<input name="RgtantTel" class="common" type="text" onchange="clickable()">
				</td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="PolQuery" value="�᰸����" onclick="" />
					<input type="button" class="cssbutton" name="${ctx}/imageQuery" value="�ⰸ��ѯ" onClick="self.location.href='${ctx}/claim/claimoperate/endcase/EndCaseInfoQuery.jsp'" />
					<input type="button" class="cssbutton" name="PastClaimQuery" value="Ӱ���ѯ" onclick="" />
				</td>
			</tr>
		</table>
		<table id="EndCaseAffixPrint" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�᰸��֤��ӡ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="24%">�����˱���</td>
					<td width="20%">����������</td>
					<td width="15%">�Ա�</td>
					<td width="20%">��������</td>
					<td width="15%">VIP��־</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>0211035120</td>
					<td>��</td>
					<td>��</td>
					<td>1986-03-01</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">ʵ����ȡ���б�</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="24%">ʵ����ȡ������</td>
					<td width="20%">ʵ����ȡ���Ա�</td>
					<td width="15%">ʵ����ȡ��֤������</td>
					<td width="20%">ʵ����ȡ��֤������</td>
					<td width="15%">ʵ����ȡ����ϵ�绰</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>��</td>
					<td>��</td>
					<td>����</td>
					<td>16461345221</td>
					<td>13614541154</td>
				</tr>
			</tbody>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">��֤���룺</td>
				<td class="right">
					<input class="codecode" id="affixCode" name="lcReport.affixCode" class="common" type="text" value="" style="width:20%" ><input name="affixCode" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="common"><input type="button" class="cssbutton" name="PolQuery" value="��ӡ��֤" onclick="" /></td>
				<td class="common"> </td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="SureButton" value="�᰸ȷ��" onclick="" />
					<input type="button" class="cssbutton" name="returnButton" value="��  ��" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>