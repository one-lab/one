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
    
	    <title>������ѯ</title>
	    
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
		<table id="ClaimQuery" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>�ⰸ��ѯ</td>
			</tr>
			<tr>
				<td class="left">�ⰸ�׶Σ�</td>
				<td class="right">
					<input class="codecode" id="claimStageCode" name="lcReport.claimStageCode" class="common" type="text" value="" style="width:20%" ><input name="claimStage" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">�ⰸ�ţ�</td>
				<td class="right"><input name="ClaimNum" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">����Ա���룺</td>
				<td class="right"><input name="OperCode" class="common" type="text" onChange="clickable()"/></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type="button" class="cssbutton" name="queryButton" value="��  ѯ" onClick=""/></td>
			</tr>
		</table>
		<table id="ClaimInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>�ⰸ�б�</td>
				</tr>
				<tr class="tableHead">
					<td width="2%"></td>
					<td width="4%">���</td>
					<td width="20%">�ⰸ��</td>
					<td width="17%">����������</td>
					<td width="20%">��������</td>
					<td width="20%">��ǰ����Ա����</td>
					<td width="17%">��ǰ����Ա����</td>
				</tr>
			</thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align="right"><input type="button" class="cssbutton" value="��  ҳ"/></td>
				<td width="5%"><input type="button" class="cssbutton" value="��һҳ"/></td>
				<td width="5%"><input type="button" class="cssbutton" value="��һҳ"/></td>
				<td width="45%"><input type="button" class="cssbutton" value="β  ҳ"/></td>
			</tr>
		</table>
		<table id="OldInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">ԭ����Ա��</td>
				<td class="right"><input name="OldOperator" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">ָ������Ա��</td>
				<td class="right">
					<input class="codecode" id="appointOperCode" name="lcReport.appointOperCode" class="common" type="text" value="" style="width:20%" ><input name="appointOper" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type="button" class="cssbutton" name="AppointButton" value="ָ��ȷ��" onClick=""/></td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>