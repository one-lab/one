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
    
    <title>Ͷ������ѯ��������</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript">ctx="${ctx}"</script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     �������ѯ����</td>
			</tr>
			<tr> 
				<td class="left">Ͷ�����ţ�</td>
				<td class="right"><input name="ManageCom" class="common" type="text"></td>
				<td class="left">���������</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="������ֹ�˾"></td>
				<td class="left">ҵ��Ա���룺</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="����"></td>
			</tr>
			<tr>
				<td class="left">Ͷ����λ���ƣ�</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<br>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type = "button" class="cssbutton" name="QueryButton" value="��  ѯ" onclick=""></td>
			</tr>
		</table>
		<br>
		<div id="ListInfo" style="width:65%">
			<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
				<thead>
					<tr>
						<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     Ͷ������Ϣ</td>
					</tr>
					<tr class="tableHead">
						<td width="3%">&nbsp;</td>
						<td width="5%">���</td>
						<td width="31%">Ͷ������</td>
						<td width="31%">Ͷ����λ����</td>
						<td width="30%">ҵ��Ա����</td>
					</tr>
				</thead>
				<tbody>
					<tr class="content">
						<td><input name="CheckRadio" type="radio" value="" /></td>
						<td>1</td>
						<td>G86012012005</td>
						<td>����չ�˾�����ֹ�˾</td>
						<td>22341231</td>
					</tr>
				</tbody>
			</table>
			<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="��  ҳ" onclick="location.href='ReportAuditDeal.jsp'"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="β  ҳ"></td>
				</tr>
			</table>
		</div>
		<br>
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="ApplyButton" value="״̬��ѯ" onclick="location.href='./StateQuery.jsp'">
					<input type = "button" class="cssbutton" name="ApplyButton" value="����Ͷ������ϸ" onclick="location.href='../imageInput/ImageInput.jsp'">
					<input type = "button" class="cssbutton" name="ApplyButton" value="����ɨ�����ѯ" onclick="">
					<input type = "button" class="cssbutton" name="ApplyButton" value="�����ѳб�������ѯ" onclick="">
					<input type = "button" class="cssbutton" name="ApplyButton" value="����δ�б�������ѯ" onclick="location.href='./GroupNoPrpallProposalQuery.jsp'">
				</td>
			</tr>
			<tr>
				<td><input type = "button" class="cssbutton" name="ApplyButton" value="����������ѯ" onclick="location.href='OperationRecordQuery.jsp'"></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
