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
		<table id="ContractInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">��ͬ��Ϣ����</td>
			</tr>
			<tr>
				<td  class="left">�����ţ�</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">Ͷ�������룺</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">���������</td>
				<td  class="right">
					<input class="codecode" id="serviceComCode" name="lcReport.serviceComCode" class="common" type="text" value="" style="width:20%" ><input name="serviceCom" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td class="left">����������</td>
				<td class="right">
					<input class="codecode" id="saleChnlCode" name="lcReport.saleChnlCode" class="common" type="text" value="" style="width:20%"><input name="saleChnl" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">����ͨ���룺</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�ͻ�ǩ�����ڣ�</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">ҵ��Ա���룺</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">ҵ��Ա���</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">���������</td>
				<td  class="right">
					<input class="codecode" id="agentCode" name="lcReport.agentCode" class="common" type="text" value="" style="width:20%" ><input name="agentCom" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td  class="left">��������״̬��</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">ǩ��������</td>
				<td  class="right">
					<input class="codecode" id="signbillCode" name="lcReport.signbillCode" class="common" type="text" value="" style="width:20%" ><input name="signbillCom" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">ǩ�����ڣ�</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">���ۻ�����</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">������ӡ���ڣ�</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�ص����ڣ�</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
			</tr>
		</table>
		<table id="AppntInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">Ͷ������Ϣ����</td>
			</tr>
			<tr>
				<td  class="left">������</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�Ա�</td>
				<td class="right">
					<input class="codecode" id="sexCode" name="lcReport.sexCode" class="common" type="text" value="01" style="width:20%" ><input name="sex" class="common" type="text" onchange="clickable()" style="width:68%" value="��">
				</td>
				<td  class="left">�������ڣ�</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">�ͻ��ţ�</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">֤�����ͣ�</td>
				<td class="right">
					<input class="codecode" id="IDCode" name="lcReport.IDCode" class="common" type="text" value="01" style="width:20%" ><input name="IDType" class="common" type="text" onchange="clickable()" style="width:68%" value="���֤">
				</td>
				<td  class="left">֤�����룺</td>
				<td  class="right"><input name="RegisterNo" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">ְҵ�ȼ���</td>
				<td class="right">
					<input class="codecode" id="occupCode" name="lcReport.occupCode" class="common" type="text" value="01" style="width:20%" ><input name="occupLevel" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">������</td>
				<td class="right">
					<input class="codecode" id="nationCode" name="lcReport.nationCode" class="common" type="text" value="01" style="width:20%" ><input name="nation" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">�ͻ�����</td>
				<td class="right">
					<input class="codecode" id="customerCode" name="lcReport.customerCode" class="common" type="text" value="01" style="width:20%" ><input name="customerGrade" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
		</table>
		<table id="AppntInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="9"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">��������Ϣ����</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">���</td>
					<td width="10%">����������</td>
					<td width="15%">�ͻ���</td>
					<td width="10%">�Ա�</td>
					<td width="10%">֤������</td>
					<td width="20%">֤������</td>
					<td width="10%">����</td>
					<td width="10%">ְҵ�ȼ�</td>
					<td width="11%">��������</td>
				</tr>
		    </thead>
		    <tbody>
				<tr class="content">
					<td>1</td>
					<td>����</td>
					<td>1641344124</td>
					<td>��</td>
					<td>����</td>
					<td>8621462100</td>
					<td></td>
					<td>һ��</td>
					<td>1986-12-20</td>
				</tr>
			</tbody>
		</table>
		<table id="AppntInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="18"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">����������Ϣ</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="3%">���</td>
					<td width="6%">����������</td>
					<td width="6%">���ֱ���</td>
					<td width="8%">��������</td>
					<td width="6%">��������</td>
					<td width="5%">����״̬</td>
					<td width="8%">����</td>
					<td width="6%">��Ч����</td>
					<td width="6%">����ֹ��</td>
					<td width="6%">�ɷ�ֹ��</td>
					<td width="5%">������ʽ</td>
					<td width="6%">���Ѷ�Ӧ��</td>
					<td width="5%">��������</td>
					<td width="6%">�����ܶ�</td>
					<td width="6%">��������</td>
					<td width="5%">�����ӷ�</td>
					<td width="5%">ְҵ�ӷ�</td>
				</tr>
		    </thead>
		    <tbody>
				<tr class="content">
					<td><input type="radio" name="Redio1" value="" /></td>
					<td>1</td>
					<td>����</td>
					<td>0717</td>
					<td>������������</td>
					<td>86</td>
					<td>�б�</td>
					<td>0</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>1</td>
					<td>300</td>
					<td>300</td>
					<td>0</td>
					<td>0</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="18"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">����Լ��</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="Button" value="������ϸ��ѯ" onClick="" />
					<input type="button" class="cssbutton" name="Button" value="Ӱ�����ϲ�ѯ" onclick="" />
					<input type="button" class="cssbutton" name="Button" value="����������ѯ" onclick="" />
					<input type="button" class="cssbutton" name="Button" value="����״̬��ѯ" onclick="" />
					<input type="button" class="cssbutton" name="Button" value="�ݽ��Ѳ�ѯ" onclick="" />
					<input type="button" class="cssbutton" name="Button" value="�����˲�ѯ" onclick="" />
					
				</td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="18"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">��ȫ��</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="Button" value="���մ�����ѯ" onclick="" />
					<input type="button" class="cssbutton" name="Button" value="��ȫ���Ĳ�ѯ" onclick="" />
					<input type="button" class="cssbutton" name="Button" value="������ӡ��ѯ" onclick="" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="Button" value="������Ϣ��ѯ" onClick="" />
					<input type="button" class="cssbutton" name="Button" value="�潻/����ѯ" onclick="" />
				</td>
			</tr>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="18"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�ͻ�����</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="Button" value="Ͷ�����ѳб�������ѯ" onClick="" />
					<input type="button" class="cssbutton" name="Button" value="Ͷ����δ�б�������ѯ" onclick="" />
					<input type="button" class="cssbutton" name="Button" value="�������ѳб�������ѯ" onclick="" />
					<input type="button" class="cssbutton" name="Button" value="������δ�б�������ѯ" onclick="" />
				</td>
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