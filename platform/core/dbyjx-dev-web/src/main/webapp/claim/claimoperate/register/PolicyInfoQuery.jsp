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
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style="width:100%">
		<table id="GroupConInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�����ͬ��Ϣ</td>
			</tr>
			<tr>
				<td class="left">�����ͬ���룺</td>
				<td class="right"><input name="GroupContNo" class="common" type="text" onchange="clickable()"></td>
				<td class="left">Ͷ�����ţ�</td>
				<td class="right"><input name="AppNo" class="common" type="text" onchange="clickable()"></td>
				<td class="left">���������</td>
				<td class="right">
					<input class="codecode" id="manageCom" name="lcReport.manageCom" class="common" type="text" value="2000000122" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="������ֹ�˾">
				</td>
			</tr>
			<tr>
				<td class="left">����������</td>
				<td class="right">
					<input class="codecode" id="saleChnlCode" name="lcReport.saleChnlCode" class="common" type="text" value="" style="width:20%"><input name="saleChnl" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">�ʱ�����ţ�</td>
				<td class="right"><input name="ReportAppNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">����Э����ţ�</td>
				<td  class="right"><input name="ServProtNo" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">Ͷ���������ڣ�</td>
				<td class="right"><input name="AppAppDate" class="common" type="text" onchange="clickable()"></td>
				<td class="left">������Ч���ڣ�</td>
				<td class="right"><input name="PolValiDate" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">ǩ�����ڣ�</td>
				<td  class="right"><input name="SignDate" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">����ԭ�����ţ�</td>
				<td class="right"><input name="RnewNo" class="common" type="text" onchange="clickable()"></td>
				<td class="left">֧�ֱ�ȫ���ڽ��㣺</td>
				<td class="right">
					<input class="codecode" id="edorRegBalaCode" name="lcReport.edorRegBalaCode" class="common" type="text" value="" style="width:20%"><input name="edorRegBala" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">���ڽ���ʱ�䣺</td>
				<td  class="right"><input name="RegBalaDate" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td class="left">������ӡ��ʽ��</td>
				<td class="right">
					<input class="codecode" id="polPrintCode" name="lcReport.polPrintCode" class="common" type="text" value="" style="width:20%"><input name="polPrintType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">VIP��ǣ�</td>
				<td class="right">
					<input class="codecode" id="VIPCode" name="lcReport.VIPCode" class="common" type="text" value="2000000122" style="width:20%"><input name="VIPFlag" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">�Ƿ�ͳ��������</td>
				<td  class="right">
					<input class="codecode" id="YNUniAppCode" name="lcReport.YNUniAppCode" class="common" type="text" value="01" style="width:20%"><input name="YNUniApp" class="common" type="text" onchange="clickable()" style="width:68%" value="��">
				</td>
			</tr>
			<tr>
				<td class="left">����ҵ��Ա��</td>
				<td class="right"><input name="MainBusiMan" class="common" type="text" onchange="clickable()"></td>
				<td class="left">����ҵ��Ա������</td>
				<td class="right"><input name="MainBusiManName" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">����������</td>
				<td  class="right">
					<input class="codecode" id="belongComCode" name="lcReport.belongComCode" class="common" type="text" value="2000000122" style="width:20%"><input name="belongCom" class="common" type="text" onchange="clickable()" style="width:68%" value="������ֹ�˾">
				</td>
			</tr>
		</table>
		<table id="AppUnitInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">Ͷ����λ����</td>
			</tr>
			<tr>
				<td  class="left">VIP�ͻ���</td>
				<td  class="right">
					<input class="codecode" id="VIPCustCode" name="lcReport.VIPCustCode" class="common" type="text" value="" style="width:20%"><input name="VIPCust" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td  class="left">Ͷ����λ�ͻ����룺</td>
				<td  class="right"><input name="AppComNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">Ͷ����λȫ�ƣ�</td>
				<td  class="right"><input name="AppComName" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">��֯�������룺</td>
				<td  class="right"><input name="OrgCode" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">��λ���ʣ�</td>
				<td  class="right">
					<input class="codecode" id="comNatureCode" name="lcReport.comNatureCode" class="common" type="text" value="01" style="width:20%"><input name="comNature" class="common" type="text" onchange="clickable()" style="width:68%" value="������ҵ">
				</td>
				<td  class="left">��ҵ���</td>
				<td  class="right">
					<input class="codecode" id="indsCatgCode" name="lcReport.indsCatgCode" class="common" type="text" value="" style="width:20%"><input name="indsCatg" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">��λ��������</td>
				<td  class="right"><input name="ComTotalNum" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">˰��Ǽ�֤�ţ�</td>
				<td  class="right"><input name="TaxNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�ʲ��ܶ�(��Ԫ)��</td>
				<td  class="right"><input name="TotalAsset" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�����ڼ䣺</td>
				<td  class="right">
					<input class="codecode" id="payIntvCode" name="lcReport.payIntvCode" class="common" type="text" value="" style="width:20%"><input name="payIntv" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td  class="left">��ϵ��ַ��</td>
				<td  class="right"><input name="ContAddr" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�������룺</td>
				<td  class="right"><input name="PostalCode" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
			<tr>
				<td  class="left">��ϵ���ţ�</td>
				<td  class="right"><input name="ContDepart" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">��ϵ�ˣ�</td>
				<td  class="right"><input name="ContPeo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">��ϵ��ְλ��</td>
				<td  class="right"><input name="ContPeoPos" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">���ţ�</td>
				<td  class="right"><input name="AreaCode" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�̶��绰��</td>
				<td  class="right"><input name="FixedTel" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�ֻ��ţ�</td>
				<td  class="right"><input name="ExtenNum" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">�ƶ��绰��</td>
				<td  class="right"><input name="MobieTel" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">E-MAIL��</td>
				<td  class="right"><input name="E-MAIL" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">���棺</td>
				<td  class="right"><input name="Fax" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">��������������</td>
				<td  class="right"><input name="MainAppntMount" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">����������������</td>
				<td  class="right"><input name="JoinAppntMount" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">Ͷ���ʣ�</td>
				<td  class="right"><input name="AppRate" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">�Ѳμӹ��籣ͳ�</td>
				<td  class="right">
					<input class="codecode" id="partedSociPlanCode" name="lcReport.partedSociPlanCode" class="common" type="text" value="01" style="width:20%"><input name="partedSociPlan" class="common" type="text" onchange="clickable()" style="width:68%" value="��">
				</td>
				<td  class="left">�籣�Ǽ�֤�ţ�</td>
				<td  class="right"><input name="SSNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�ɷѷ�ʽ��</td>
				<td  class="right">
					<input class="codecode" id="payCode" name="lcReport.payCode" class="common" type="text" value="" style="width:20%"><input name="payType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td  class="left">�������У�</td>
				<td  class="right">
					<input class="codecode" id="openBankCode" name="lcReport.openBankCode" class="common" type="text" value="" style="width:20%"><input name="openBank" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">�ʺţ�</td>
				<td  class="right"><input name="AccNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
	</div>
	<div style="width:100%">
		<table id="GroupAppInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">���屣����Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="15%">���ֱ���</td>
					<td width="20%">��������</td>
					<td width="15%">��������</td>
					<td width="11%">���ѽ��</td>
					<td width="11%">�ɷ�����</td>
					<td width="11%">��������</td>
					<td width="11%">����״̬</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>0601</td>
					<td>���������˺�ҽ�Ʊ���(0601)</td>
					<td>����֧��˾</td>
					<td>5000</td>
					<td>1��</td>
					<td>1��</td>
					<td>����ǩ��</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="30%" align='right'><input type="button" class="cssbutton" name="PayQuery" value="�ɷѲ�ѯ" onclick=""></td>
				<td width="5%"><input type="button" class="cssbutton" name="EdorQuery" value="��ȫ��ѯ" onclick=""></td>
				<td width="5%"><input type="button" class="cssbutton" name="AppInfoQuery" value="������ϸ��ѯ" onclick=""></td>
				<td width="5%"><input type="button" class="cssbutton" name="ScanQuery" value="ɨ�����ѯ" onclick=""></td>
				<td width="5%"><input type="button" class="cssbutton" name="PeopOfUnitQuery" value="�����¸��˱�����ѯ" onclick=""></td>
				<td width="5%"><input type="button" class="cssbutton" name="OperHistQuery" value="����������ѯ" onclick=""></td>
				<td width="30%"><input type="button" class="cssbutton" name="returnButton" value="��  ��" onclick="javascript:history.back();"/></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
