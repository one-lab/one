<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>������޸Ĵ���</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="common/js/SimpleCalendar.js"></script>	
  </head>
  
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
		<tr>
			<td colspan="6"><p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<hr /></td>
		</tr>
		<tr>
			<td>Ͷ������Ϣ</td>
		</tr>
		<tr>
			<td class="left">Ͷ�������룺</td>
			<td class="right">346781263476823647</td>
			<td  class="left">�ʱ�����</td>
			<td  class="right">3548263784657</td>
			<td class="left">Ͷ������</td>
			<td class="right"><INPUT name="Startdate" class="common" type="text" onchange="clickable()" style="width:73%"
    	  value='2012-04-28'>
				<img style='cursor:hand' align="absmiddle" src="common/images/bgcalendar.gif" onClick="TogglePopupCalendarWindow('document.fm.Startdate', '1997', '2014')"></td>
		</tr>
		<tr>
			<td class="left">������Ч����</td>
			<td class="right"><INPUT name="Startdate" class="common" type="text" onchange="clickable()" style="width:73%"
    	  value='2012-04-28'>
				<img style='cursor:hand' align="absmiddle" src="common/images/bgcalendar.gif" onClick="TogglePopupCalendarWindow('document.fm.Startdate', '1997', '2014')"></td>
			<td  class="left">����ԭ������</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">�������</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td class="left">���۷�ʽ</td>
			<td class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></td>
			<td class="left">Э�����</td>
			<td class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td colspan="6"><hr /></td>
		</tr>
		<tr>
			<td class="left">ҵ��Ա����</td>
			<td class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></td>
			<td class="left">ҵ��Ա����</td>
			<td class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></td>
			<td class="left">��������</td>
			<td class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">�����ֲ�</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">��ҵ��Ա���빴ѡ</td>
			<td  class="right"><input name="" type="checkbox" value="" /></td>
		</tr>
		<tr>
			<td colspan="6"><hr /></td>
		</tr>
		<tr>
			<td colspan="6"> Ͷ����λ���ϣ��ͻ���
				<input name="" type="text" />
				<input name="" type="button" value="��ѯ" />
				�����״�Ͷ����λ������д�ͻ��ţ� </td>
		</tr>
		<tr>
			<td class="left">VIP�ͻ�</td>
			<td class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">Ͷ����λȫ��</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">��ҵ���</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">��֯��������</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">�ʲ���ģ����Ԫ��</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">˰��Ǽ�֤��</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">�������루��Ԫ����</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">��λ����</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td class="left">��������</td>
			<td class="right"><INPUT name="Startdate" class="common" type="text" onchange="clickable()" style="width:73%"
    	  value='2012-04-28'>
				<img style='cursor:hand' align="absmiddle" src="common/images/bgcalendar.gif" onClick="TogglePopupCalendarWindow('document.fm.Startdate', '1997', '2014')"></td>
		</tr>
		<tr>
			<td  class="left">��Ӫ����</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">��Ӫҵ��</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">��λ������</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">�Ƿ�μ����ͳ��</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">�籣�Ǽ�֤��</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">��ϵ��ַ</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">��ϵ�ʱ�</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">��ϵ�绰</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">��ϵ����</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">��ϵ������</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">��ϵ���Ա�</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">��ϵ�˵绰</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">�ֻ�</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">E-MAIL</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">��λ����</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">����֤������</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">����֤����</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td class="left">������Ч���ڣ�</td>
			<td class="right"><INPUT name="Startdate" class="common" type="text" onchange="clickable()" style="width:73%"
    	  value='2012-04-28'>
				<img style='cursor:hand' align="absmiddle" src="common/images/bgcalendar.gif" onClick=			    "TogglePopupCalendarWindow('document.fm.Startdate', '1997', '2014')"></td>
		</tr>
		<tr>
			<td  class="left">Ͷ����λ����</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">������������</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">��������������</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">����</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">���ѽ��㷽ʽ</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">�ɷѷ�ʽ</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">��������</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">�˺�</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">Ͷ����</td>
			<td  class="right">1</td>
		</tr>
		<tr>
			<td colspan="6">�������ѷ�ʽ&nbsp;&nbsp;
				<input name="" type="checkbox" value="" />
				Ͷ����λȫ���</td>
		</tr>
		<tr>
			<td  class="left">��λ������%����</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td  class="left">�ض�Լ�����룺</td>
			<td  class="right"><INPUT name="RegistNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td >�ض�Լ�����ݣ�</td>
		</tr>
		<tr>
			<td colspan="6"><textarea name="" cols="" rows="4"></textarea></td>
		</tr>
		<tr>
			<td>Ͷ������֪��</td>
		</tr>
		<tr>
			<td colspan="6"><table width="1000" border="1">
					<tr>
						<th width="36" scope="col">���</th>
						<th width="196" scope="col">��֪���</th>
						<th width="258" scope="col">��֪���ݱ��</th>
						<th width="258" scope="col">��֪����</th>
						<th width="218" scope="col">¼����Ϣ</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td><input type="button" class="button" name = "queryButton" value="����/�޸�" onClick="" >
			</td>
		</tr>
		<tr>
			<td>���屣��������Ϣ</td>
		</tr>
		<tr>
			<td colspan="6"><table width="1000" border="1">
					<tr>
						<th width="32" scope="col">&nbsp;</th>
						<th width="72" scope="col">���</th>
						<th width="183" scope="col">���ֱ���</th>
						<th width="185" scope="col">��������</th>
						<th width="142" scope="col">�����ڼ�</th>
						<th width="157" scope="col">�α�����</th>
						<th width="158" scope="col">����</th>
						<th width="157" scope="col">����/�����ϼ�</th>
						<th width="158" scope="col">������</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td>������Ϣ</td>
		</tr>
		<tr>
			<td class="left">���ֱ��룺</td>
			<td class="right"><input name="RegistNo2" class="common" type="text" onchange="clickable()" /></td>
		</tr>
		<tr>
			<td colspan="6">���ַ�����Ϣ(0��1֮���С����</td>
		</tr>
		<tr>
			<td colspan="6"><table width="1200" border="1">
					<tr>
						<th scope="col">���</th>
						<th scope="col">�����ѱ���</th>
						<th scope="col">���˼�Ч����</th>
						<th scope="col">����Ч����</th>
						<th scope="col">���˷��ñ���</th>
						<th scope="col">�Ŷӷ��ñ���</th>
						<th scope="col">�������ñ���</th>
						<th scope="col">ǰ�߹̶����÷�̯����</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td colspan="6"><input type="button" class="button" name = "queryButton2" value="�������" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="ɾ������" onclick="" />
			</td>
		</tr>
		<tr>
			<td colspan="6"><hr /></td>
		</tr>
		<tr>
			<td colspan="6"><input type="button" class="button" name = "queryButton2" value="������Ϣ" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="�㼶����" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="���ϼƻ�����" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="����������Ϣ" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="ҵ����Ϣ������" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="��������" onclick="" />
			</td>
		</tr>
		<tr>
			<td colspan="6"><hr /></td>
		</tr>
		<tr>
			<td colspan="6">
				
				<input type="button" class="button" name = "queryButton2" value="���±��鿴����0����" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="����������޸�ȷ��" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="����������ظ�" onclick="parent.document.getElementById('fraInterface').src ='group/problemFileModi/ProblemFileReply.jsp'" />
				<input type="button" class="button" name = "queryButton2" value="Ӱ�����ѯ" onclick="parent.document.getElementById('fraInterface').src ='group/problemFileModi/ImageFileQuery.jsp'" />
				<input type="button" class="button" name = "queryButton2" value="����" onclick="" />
			</td>
		</tr>
	</table>
</form>
  </body>
</html>
