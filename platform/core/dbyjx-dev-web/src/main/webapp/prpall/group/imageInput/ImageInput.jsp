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
    
    <title>Ӱ��¼��</title>
    
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
		Ӱ����Ϣ
		<br><br><br><br>
		<hr>
		<table id=PraPallInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">Ͷ������Ϣ</td>
			</tr>
			<tr>
				<td class="left">Ͷ�������룺</td>
				<td class="right"><input name="GrpContNo" class="common" type="text"></td>
				<td class="left">�ʱ����ţ�</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"></td>				
				<td class="left">Ͷ�����ڣ�</td>
				<td class="right">
					<input name="InputDate" id="InputDate" class="common" type="text"  style="width: 73%" value='2012-04-28'><img src="${ctx}/images/bgMarkMustInput.jpg" >
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onClick="WdatePicker({el:'InputDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
			<tr>
				<td class="left">������Ч���ڣ�</td>
				<td class="right">
					<input name="Cvalidate" id="Cvalidate" class="common" type="text"  style="width: 73%" value='2012-04-28'><img src="${ctx}/images/bgMarkMustInput.jpg" >
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onClick="WdatePicker({el:'Cvalidate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="left">����ԭ�����ţ�</td>
				<td class="right"><input name="OldGrpContNo" class="common" type="text" ></td>
				<td class="left">���������</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="������ֹ�˾"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td class="left">���۷�ʽ��</td>
				<td class="right"><input name="SaleType" class="common" type="text" ><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">Э����ţ�</td>
				<td class="right"><input name="ContractNo" class="common" type="text" ></td>				
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr><br>
		<table id=PraPallInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">ҵ��Ա���룺</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:90%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">ҵ��Ա������</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>				
				<td class="left">����������</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="������ֹ�˾"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>				
			</tr>
			<tr>
				<td class="left">�����ֲ���</td>
				<td class="right"><input name="SaleType" class="common" type="text" ></td>
				<td class="left">��ҵ��Ա,�빴ѡ��</td>
				<td><input type="checkbox" name="checkbox" value="checkbox" /></td>			
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<table id=ContImpartInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6" ><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">����ҵ��Ա��Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">���</td>
					<td width="19%">ҵ��Ա����</td>
					<td width="19%">ҵ��Ա����</td>
					<td width="19%">��������</td>
					<td width="19%">�����ֲ�</td>
					<td width="19%">Ӷ�����</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>a</td>
					<td>a</td>
					<td>a</td>
					<td>a</td>
					<td>a</td>
				</tr>
			</tbody>
		</table>
		<hr><br>
		<table id=companyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../report/reportInput/CompanyInfo.jsp" /> </td>
			</tr>
		</table>
		<table id=ContImpartInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6" ><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">Ͷ������֪��</td>
				</tr>
				<tr class="tableHead">
					<td width="10%">���</td>
					<td width="20%">��֪���</td>
					<td width="20%">��֪���ݱ��</td>
					<td width="25%">��֪����</td>
					<td width="25%">¼����Ϣ</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>SA</td>
					<td>3234</td>
					<td>��֪��������</td>
					<td>¼����ϸ��Ϣ���ݵ�</td>
				</tr>
			</tbody>
			<tr>
				<td colspan="6" >ͬҵ����״��</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5"></textarea></td>
			</tr>
			<tr>
				<td colspan="6" >�����������</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5"></textarea></td>
			</tr>
			<tr>
				<td colspan="6" >��������ʷ</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5"></textarea></td>
			</tr>
			<tr>
				<td colspan="6" >����������������Ҫ��</td>
			</tr>
			<tr>
				<td colspan="6"><textarea name="" cols="100%" rows="5"></textarea></td>
			</tr>
			<tr>
				<td colspan="6">
					<input type="button" class="cssButton" name = "SubmitButton" value="��  ��" onClick="" >
					<input type="button" class="cssButton" name = "UpdateButton" value="��  ��" onClick="" >
				</td>
			</tr>
		</table>
	</div>
	<div style="width:100%">
		<table id="GrpPolInfor" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">   ���屣��������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">���</td>
					<td width="15%">���ֱ���</td>
					<td width="32%">��������</td>
					<td width="15%">����</td>
					<td width="15%">����</td>
					<td width="15%">������</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" value="" name="Radios"/></td>
					<td>1</td>
					<td>0601</td>
					<td>���������˺�ҽ�Ʊ���(0601)</td>
					<td>0</td>
					<td>0</td>
					<td>0.15</td>
				</tr>
			</tbody>
		</table>		
	</div>
	<div style="width:100%">
		<table id="RiskInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">������Ϣ</td>
			</tr>
			<tr>
				<td class="left">���ֱ��룺</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="������ֹ�˾"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">���ձ��룺</td>
				<td class="right"><input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','{comCode:21102}');"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="������ֹ�˾"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>				
				<td class="left">�����ʣ�0-1����</td>
				<td class="right"><input name="RiskCode" class="common" type="text" onchange="clickable()" /></td>
			</tr>
		</table>
		<table id="RiskRateInfor" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">���ַ�����Ϣ��0��1֮���С����</td>
				</tr>
				<tr class="tableHead">
					<td width="10%">���</td>
					<td width="12%">�����ѱ���</td>
					<td width="13%">���˼�Ч����</td>
					<td width="13%">����Ч����</td>
					<td width="13%">���˷��ñ���</td>
					<td width="13%">�Ŷӷ��ñ���</td>
					<td width="13%">�������ñ���</td>
					<td width="13%">ǰ�߹̶����÷�̯����</td>					
				</tr>
			</thead>	
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>0.4</td>
					<td>0.4</td>
					<td>1</td>
					<td>0.4</td>
					<td>0.4</td>
					<td>0.4</td>
					<td>0.4</td>
				</tr>
			</tbody>
		</table>
		<table id="ButtonInfor1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="90%" align="right"><input type="button" class="cssbutton" name = "AddRisk" value="�������" onclick=""></td>
				<td width="10%" align="left"><input type="button" class="cssbutton" name = "DelRisk" value="ɾ������" onclick=""></td>
			</tr>
		</table>
		<hr>
		<div id="divInfo1" style="display:''">
			<table id="ButtonInfor2" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td colspan="6">
						<input type="button" class="cssbutton" name = "AddPlan" value="���ϼƻ�����" onclick="location.href='../report/reportInput/EnsurePlan.jsp'">
						<input type="button" class="cssbutton" name = "InsuredInfo" value="����������Ϣ" onclick="location.href='../report/reportInput/InsuredListImport.jsp'">
						<input type="button" class="cssbutton" name = "BussinessNote" value="ҵ����Ϣ������" onclick="location.href='../noImageInput/StatementInput.jsp'">
						<input type="button" class="cssbutton" name = "JoinSet" value="��������" onclick="">
					</td>
				</tr>
			</table>
		</div>
		<div id="divInfo2" style="display:''">
			<table id="ButtonInfor2" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td colspan="6">
						<input type="button" class="cssbutton" name = "AddPlan" value="������Ϣ" onclick="">
						<input type="button" class="cssbutton" name = "AddPlan" value="���ϼƻ�����" onclick="location.href='../report/reportInput/EnsurePlan.jsp'">
						<input type="button" class="cssbutton" name = "InsuredInfo" value="����������Ϣ" onclick="location.href='../report/reportInput/InsuredListImport.jsp'">
						<input type="button" class="cssbutton" name = "BussinessNote" value="ҵ����Ϣ������" onclick="location.href='../noImageInput/StatementInput.jsp'">
						<input type="button" class="cssbutton" name = "JoinSet" value="���ڸ�������" onclick="location.href='../noImageInput/InstallmentSetting.jsp'">
					</td>
				</tr>
			</table>
		</div>
		<hr>
		<table id="ButtonInfor3" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="50%" align="right"><input type="button" class="cssbutton" name = "ReturnBack" value="��  ��" onclick="javascript:history.go(-1);"></td>
				<td width="10%" align="left"><input type="button" class="cssbutton" name = "AddComplete" value="¼�����" onclick=""></td>
				<td width="10%" align="left"><input type="button" class="cssbutton" name = "QueryNotepad" value="���±��鿴����0����" onclick=""></td>
				<td width="10%" align="left"><input type="button" class="cssbutton" name = "QueryIssue" value="�����������ѯ" onclick=""></td>
				<td width="10%" align="left"><input type="button" class="cssbutton" name = "AddIssue" value="���������¼��" onclick="location.href='../noImageInput/ProblemFileInput.jsp'"></td>
				<td width="10%" align="left"><input type="button" class="cssbutton" name = "QueryImageScan" value="Ӱ�����ѯ" onclick=""></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
