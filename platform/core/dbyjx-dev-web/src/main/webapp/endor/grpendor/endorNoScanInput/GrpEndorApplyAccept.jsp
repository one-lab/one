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
    
    <title>���屣ȫ��������</title>
    
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
		<table id="EndorAcceptInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ��ȫ������Ϣ</td>
			</tr>
			<tr> 
				<td class="left">��ȫ����ţ�</td>
				<td class="right"><input name="EndorAcceptNo" class="common" type="text" readonly></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr> 
				<td class="left">���屣���ţ�</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" readonly></td>
				<td class="left">����״̬��</td>
				<td class="right"><input name="GrpName" class="common" type="text" readonly></td>
				<td class="left">������������</td>
				<td class="right"><input name="State" class="common" type="text" value="���" readonly></td>
			</tr>
			<tr>
				<td class="left">���뷽ʽ��</td>
				<td class="right">
					<input name="ApplyType" class="codecode" type="text" onchange="clickable()" style="width:20%" readonly><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" readonly>
				</td>
				<td class="left">�������ڣ�</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='2012-04-28' readonly>
				</td>
				<td class="common"></td>
				<td class="common"></td>		
			</tr>
		</table>
		<table id="endorItemInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     �ŵ���ϸ��Ϣ</td>
			</tr>
			<tr> 
				<td class="left">���屣���ţ�</td>
				<td class="right"><input name="GrpContNo" class="common" type="text" value="P2012321352" readonly></td>
				<td class="left">Ͷ����λ��</td>
				<td class="right"><input name="GrpName" class="common" type="text" value="��ʯ��" readonly></td>
				<td class="left">��Ч���ڣ�</td>
				<td class="right"><input name="State" class="common" type="text" value="2012-07-23" readonly></td>
			</tr>
			<tr>
				<td class="left">Ͷ��������</td>
				<td class="right"><input name="State" class="common" type="text" value="20" readonly></td>
				<td class="left">��ϵ�ˣ�</td>
				<td class="right"><input name="State" class="common" type="text" value="����" readonly></td>
				<td class="left">ҵ��Ա��</td>
				<td class="right"><input name="State" class="common" type="text" value="Ц��" readonly></td>		
			</tr>
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="������ϸ��ѯ"  onclick="location.href='./GrpContDetailView.jsp'">
					<input type = "button" class="cssbutton" name="ReturnBack" value="�����嵥��ѯ"  onclick="location.href='./InsuredListView.jsp'">
				</td>
			</tr>
		</table>
		<table id="grpContInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     ��ȫ��Ŀ��Ϣ</td>
			</tr>
			<tr> 
				<td class="left">�������ͣ�</td>
				<td class="right">
					<input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" >
				</td>
				<td class="left">�������ڣ�</td>
				<td class="right">
					<input name="ApplyDate" id="ApplyDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='2012-04-28'>
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="left">����Ա��</td>
				<td class="right"><input name="State" class="common" type="text" value="��һ" readonly></td>
			</tr>
			<tr> 
				<td class="left">����ԭ��</td>
				<td class="right">
					<input name="ApplyReason" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" >
				</td>
				<td class="left">��Ч���ڣ�</td>
				<td class="right"><input name="Cvalidate" class="common" type="text" value="2012-07-23" readonly></td>
			</tr>			
		</table>
		<table id="ButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="AddEndorItem" value="��ӱ�ȫ��Ŀ" onclick="">
				</td>
			</tr>
		</table>
		<br>
		<table id="endorItemListInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="7%">���</td>
					<td width="18%">��������</td>
					<td width="18%">��������</td>
					<td width="18%">��Ч����</td>
					<td width="18%">����ԭ��</td>
					<td width="18%">����״̬</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td ><input name="checkRadio" type="radio" value="" /></td>
					<td>1</td>
					<td ><a href="javascript:void(0)" onclick="location.href='./ChangeInsuredInfoInput.jsp'">BB-�������˻�����Ϣ���</a></td>
					<td >2012-05-01</td>
					<td >2012-05-01</td>
					<td >�ͻ�����</td>
					<td >����¼��</td>
				</tr>
				<tr class="content">
					<td ><input name="checkRadio" type="radio" value="" /></td>
					<td>2</td>
					<td ><a href="javascript:void(0)" onclick="location.href='./EndorNIDetailInput.jsp'">NI-���ӱ�������</a></td>
					<td >2012-05-01</td>
					<td >2012-05-01</td>
					<td >�ͻ�����</td>
					<td >����¼��</td>
				</tr>				
			</tbody>
		</table>
		<table>
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Confirm" value="��ȫ��Ŀ��ϸ" onclick="">
					<input type = "button" class="cssbutton" name="ReturnBack" value="��ȫ��Ŀ����" onclick="">
				</td>				
			</tr>
		</table>
		<br><br>
	</div>
	<div style = "width:100%" >
		<table id="endorItemInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     �ո��ѷ�ʽ��Ϣ</td>
			</tr>
			<tr> 
				<td class="left">�ո��ѷ�ʽ��</td>
				<td class="right">
					<input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" >
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">���˷���ȡ�ˣ�</td>
				<td class="right">����</td>
				<td class="left">���֤�ţ�</td>
				<td class="right">42154613131455</td>
				<td class="common"></td>
				<td class="common"></td>	
			</tr>
			<tr> 
				<td class="left">�Ƿ�ǿ���˹��˱���</td>
				<td class="right">
					<input name="EndorItem" class="codecode" type="text" onchange="clickable()" style="width:20%" ><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" >
				</td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>			
		</table>
	</div>
	<div style = "width:100%">
		<table>
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="ApplyConfirm" value="����ȷ��" onclick="">
					<input type = "button" class="cssbutton" name="ReturnBack" value="��  ��" onclick="javascript:history.go(-1);">
				</td>				
			</tr>
		</table>		
	</div>
	</form>
  </body>
</html>
