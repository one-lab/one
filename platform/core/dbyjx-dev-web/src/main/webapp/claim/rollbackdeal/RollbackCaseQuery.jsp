<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
    	<base href="<%=basePath%>"/>
    
	    <title>���˰�����ѯ</title>
	    
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
		<meta http-equiv="expires" content="0"/>    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
		<meta http-equiv="description" content="This is my page"/>
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>

	</head>
<body>
	<form name="fm" method="post" onKeyPress="KeyDown()">
	<div style="width:100%">
		<table id="QueryCondition" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>�������ѯ����</td>
			</tr>
			<tr>
				<td class="left">�ⰸ�ţ�</td>
				<td class="right"><input name="ClaimNum" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">������������</td>
				<td class="right"><input name=" AppntName" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">�������ڣ�</td>
				<td class="right">
					<input name="AppDate" id="AppDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'AppDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
			<tr>
				<td class="left">������֤�����ͣ�</td>
				<td class="right">
					<input class="codecode" id="appntIDCode" name="lcReport.appntIDCode" class="common" type="text" value="01" style="width:20%" ><input name="appntIDType" class="common" type="text" onchange="clickable()" style="width:68%" value="���֤">
				</td>
				<td class="left">������֤�����룺</td>
				<td class="right"><input name="AppntIDNo" class="common" type="text" onChange="clickable()"/></td>
				<td class="common">  </td>
				<td class="common"> </td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type="button" class="cssbutton" name="queryButton" value="��  ѯ" onClick=""/></td>
			</tr>
		</table>
		<br/>
		<table id="ClaimInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>�ⰸ��Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%"> </td>
					<td width="4%">���</td>
					<td width="15%">�ⰸ��</td>
					<td width="15%">����������</td>
					<td width="10%">������֤������</td>
					<td width="20%">������֤������</td>
					<td width="15%">��������</td>
					<td width="15%">�᰸����</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value=""/></td>
					<td>1</td>
					<td><a href="javascript:void(0)" onclick="self.location.href='${ctx}/claim/rollbackdeal/RollbackCaseDeal.jsp'">S86012012018</a></td>
					<td>��</td>
					<td>���֤</td>
					<td>130701582447634863322</td>
					<td>2012-05-01</td>
					<td>2012-05-15</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align="right"><input type="button" class="cssbutton" value="��  ҳ"/></td>
				<td width="5%"><input type="button" class="cssbutton" value="��һҳ"/></td>
				<td width="5%"><input type="button" class="cssbutton" value="��һҳ"/></td>
				<td width="45%"><input type="button" class="cssbutton" value="β  ҳ"/></td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>