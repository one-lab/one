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
    
    <title>������ϸ��ѯ</title>
    
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
	<div style = "width:100%">
		<table id="GrpContInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     �����ͬ��Ϣ</td>
			</tr>
			<tr> 
				<td class="left">�����ͬ���룺</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">Ͷ�������룺</td>
				<td class="right"><input name="PrtNo" class="common" type="text" readonly></td>
				<td class="left">���������</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			</tr>
			<tr> 
				<td class="left">����������</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" value="1" readonly><input name="comName" class="common" type="text" value="�й�" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">�ʱ����ţ�</td>
				<td class="right"><input name="ReportNo" class="common" type="text" readonly></td>
				<td class="left">����Э����ţ�</td>
				<td class="right"><input name="ServiceNo" class="common" type="text" readonly></td>
			</tr>
			<tr>
				<td class="left">Ͷ���������ڣ�</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" value='2012-04-28' readonly>
				</td>
				<td class="left">������Ч���ڣ�</td>
				<td class="right">
					<input name="CvaliDate" id="Cvalidate" class="common" type="text" onchange="clickable()" value='2012-04-28' readonly>
				</td>
				<td class="left">ǩ�����ڣ�</td>
				<td class="right">
					<input name="SignDate" id="Cvalidate" class="common" type="text" onchange="clickable()" value='2012-04-28' readonly>
				</td>	
			</tr>
			<tr> 
				<td class="left">����ԭ�����ţ�</td>
				<td class="right"><input name="ReportNo" class="common" type="text" readonly></td>
				<td class="left">֧�ֱ�ȫ���ڽ��㣺</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">���ڽ���ʱ�䣺</td>
				<td class="right"><input name="SettleDate" class="common" type="text" readonly></td>
			</tr>
			<tr> 
				<td class="left">������ӡ��ʽ��</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">VIP��ǣ�</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">�Ƿ�ͳ��������</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			</tr>
			<tr> 
				<td class="left">����ҵ��Ա��</td>
				<td class="right"><input name="ReportNo" class="common" type="text" readonly></td>
				<td class="left">����ҵ��Ա������</td>
				<td class="right"><input name="SettleDate" class="common" type="text" readonly></td>
				<td class="left">����������</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			</tr>			
		</table>
	</div>
	<div style = "width:100%">
		<table id="GrpContInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     Ͷ����λ����</td>
			</tr>
			<tr>
				<td class="left">VIP�ͻ���</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">Ͷ����λ�ͻ����룺</td>
				<td class="right"><input name="GrpName" class="common" type="text" ></td>
				<td class="left">Ͷ����λ���ƣ�</td>
				<td class="right"><input name="BussType" class="common" type="text" ></td>
				<td class="left">��֯�������룺</td>
				<td class="right"><input name="GroupNo" class="common" type="text" ></td>				
			</tr>
			<tr>
				<td class="left">��λ���ʣ�</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">��ҵ���</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">��λ��������</td>
				<td class="right"><input name="RegistNo" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">˰��Ǽ�֤�ţ�</td>
				<td class="right"><input name="InCome" class="common" type="text" ></td>
				<td class="left">�ʲ��ܶ��Ԫ����</td>
				<td class="right"><input name="InCome" class="common" type="text" ></td>
				<td class="left">�ɷ��ڼ䣺</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			</tr>
			<tr>
				<td class="left">��ϵ��ַ��</td>
				<td class="right" colspan="3"><input name="AdressNo" class="common" type="text" ><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">�������룺</td>
				<td class="right"><input name="ZipCode" class="common" type="text" ><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td class="left">��ϵ���� ��</td>
				<td class="right"><input name="Telephone1" class="common" type="text" ></td>
				<td class="left">��ϵ�ˣ�</td>
				<td class="right"><input name="Department" class="common" type="text" ></td>
				<td class="left">��ϵ��ְλ��</td>
				<td class="right"><input name="Department" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">���ţ�</td>
				<td class="right"><input name="Name" class="common" type="text" ></td>
				<td class="left">�̶��绰��</td>
				<td class="right"><input name="Sex" class="common" type="text" ></td>
				<td class="left">�ֻ��ţ�</td>
				<td class="right"><input name="Telephone2" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">�ƶ��绰��</td>
				<td class="right"><input name="Telephone3" class="common" type="text" ></td>
				<td class="left">E-MAIL��</td>
				<td class="right"><input name="E-Mail" class="common" type="text" ></td>
				<td class="left">���棺</td>
				<td class="right"><input name="E-Mail" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">��������������</td>
				<td class="right"><input name="LegalPerson" class="common" type="text" ></td>
				<td class="left">����������������</td>
				<td class="right"><input name="IDType" class="common" type="text" ></td>
				<td class="left">Ͷ���ʣ�</td>
				<td class="right"><input name="IDNo" class="common" type="text" ></td>
			</tr>
			<tr>
				<td class="left">�Ѳμӹ����ͳ�</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">�籣�Ǽ�֤�ţ�</td>
				<td class="right"><input name="RegistNo" class="common" type="text" ></td>
				<td class="left">�ɷѷ�ʽ��</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
			</tr>
			<tr>
				<td class="left">�������У�</td>
				<td class="right">
					<input name="comCode" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left" colspan="">�˺� ��</td>
				<td class="right" colspan="3"><input name="MainInsuredCount" class="common" type="text" ></td>
			</tr>
		</table>
		<table id="ReportCompanyInfo" class="common" cellpadding="3" cellspacing="0">
				<thead>
					<tr>
						<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">  ���屣����Ϣ</td>
					</tr>
					<tr class="tableHead">
						<td width="3%">&nbsp;</td>
						<td width="7%">���</td>
						<td width="10%">���ֱ���</td>
						<td width="15%">��������</td>
						<td width="13%">��������</td>
						<td width="13%">���ѽ��</td>
						<td width="13%">�ɷ�����</td>
						<td width="13%">��������</td>
						<td width="13%">����״̬</td>
					</tr>
				</thead>

				<tbody>
					<tr class="content">
						<td ><input name="checkRadio" type="radio" value="" /></td>
						<td >1</td>
						<td >4500</td>
						<td >�������������˺�����</td>
						<td >860301</td>
						<td >1300</td>
						<td >1��</td>
						<td >1��</td>
						<td >����ǩ��</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td width="30%" align='right'><input type = "button" class="cssbutton" name="Query" value="���Ѳ�ѯ" onclick=""></td>
					<td width="6%" align='right'><input type = "button" class="cssbutton" name="Query" value="��ȫ��ѯ" onclick=""></td>
					<td width="8%" align='right'><input type = "button" class="cssbutton" name="Query" value="������ϸ��ѯ" onclick=""></td>
					<td width="4%" align='right'><input type = "button" class="cssbutton" name="Query" value="ɨ�����ѯ" onclick=""></td>
					<td width="14%" align='right'><input type = "button" class="cssbutton" name="Query" value="�����¸��˱�����ѯ" onclick=""></td>
					<td width="8%" align='right'><input type = "button" class="cssbutton" name="Query" value="����������ѯ" onclick=""></td>
					<td width="30%" align='left'><input type = "button" class="cssbutton" name="Query" value="��  ��" onclick="javascript:history.go(-1);"></td>
				</tr>
			</table>
	</div>
	</form>
  </body>
</html>
