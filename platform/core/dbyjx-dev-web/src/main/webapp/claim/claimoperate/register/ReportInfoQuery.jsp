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
    
	    <title>�ʱ���Ϣ�鿴</title>
	    
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
		<table id="ReportInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">���ⰸ�µĳʱ���Ϣ�б�</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="15%">������</td>
					<td width="15%">�ʱ����</td>
					<td width="14%">�ʱ�����</td>
					<td width="15%">����������</td>
					<td width="10%">����׶�</td>
					<td width="15%">�ʱ�����</td>
					<td width="10%">�ʱ�״̬</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>S86012012018</td>
					<td>L5214</td>
					<td>1</td>
					<td>��</td>
					<td>01</td>
					<td>2012-05-01</td>
					<td>���</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="5%"><input type = "button" class="cssbutton" value="��  ҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="85%"><input type = "button" class="cssbutton" value="β  ҳ"></td>
			</tr>
		</table>
		<br />
		<table id="ReportInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">ѡ�гʱ��ľ�����Ϣ</td>
			</tr>
			<tr>
				<td  class="left">�ⰸ�ţ�</td>
				<td  class="right"><input name="ClaimNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">������Ӧ�ı����ţ�</td>
				<td  class="right"><input name="ReportNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�ʱ���ţ�</td>
				<td  class="right"><input name="ReportNum" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">�ʱ�������</td>
				<td  class="right"><input name="ReportTimes" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">������������</td>
				<td  class="right"><input name="AppntName" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">����׶Σ�</td>
				<td  class="right"><input name="LiftStage" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">�ʱ��ˣ�</td>
				<td  class="right"><input name="Reporter" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�ʱ�������</td>
				<td  class="right"><input name="ReportCom" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�ʱ����ڣ�</td>
				<td  class="right"><input name="ReportDate" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">�н���Ա�û�����</td>
				<td  class="right"><input name="AgentName" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�ʱ�״̬��</td>
				<td  class="right"><input name="ReportState" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<table id="ReportContent" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td colspan="4">�ʱ�����</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="accidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
			<tr>
				<td colspan="4">�ʱ��������</td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="accidentDesc" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="returnButton" value="��  ��" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>