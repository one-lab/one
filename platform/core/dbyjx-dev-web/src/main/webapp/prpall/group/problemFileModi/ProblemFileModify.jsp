<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>������޸�</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/Standard.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<TABLE id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
		<TR>
			<TD colspan="6"><table width="800" border="1">
					<tr>
						<th scope="col">&nbsp;</th>
						<th scope="col">���</th>
						<th scope="col">���ֱ���</th>
						<th scope="col">��������</th>
						<th scope="col">�����ڼ�</th>
						<th scope="col">�α�����</th>
						<th scope="col">����</th>
						<th scope="col">����/�����ϼ�</th>
						<th scope="col">������</th>
					</tr>
					<tr>
						<td><label>
							<input type="radio" name="radiobutton" value="radiobutton" />
							</label></td>
						<td>1</td>
						<td>2334234</td>
						<td>��������ݿ���</td>
						<td>&nbsp;</td>
						<td>22</td>
						<td>32423</td>
						<td>2342342</td>
						<td>0.2</td>
					</tr>
				</table></TD>
		</TR>
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
				<input type="button" class="button" name = "queryButton2" value="���ڸ�������" onclick="" />
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
				<input type="button" class="button" name = "queryButton2" value="Ӱ����鿴" onclick="" />
				<input type="button" class="button" name = "queryButton2" value="����" onclick="" />
			</td>
		</tr>
	</TABLE>
</form>
  </body>
</html>
