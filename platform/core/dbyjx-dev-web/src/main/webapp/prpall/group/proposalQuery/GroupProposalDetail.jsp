<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>����Ͷ������ϸ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/Standard.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
		<tr>
			<td>Ͷ������֪��</td>
		</tr>
		<tr>
			<td colspan="6"><table width="1000" border="1">
					<tr>
						<th scope="col">���</th>
						<th scope="col">��֪���</th>
						<th scope="col">��֪���ݱ��</th>
						<th scope="col">��֪����</th>
						<th scope="col">¼����Ϣ</th>
					</tr>
					<tr>
						<td><label></label></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td>���屣��������Ϣ</td>
		</tr>
		<tr>
			<td colspan="6"><table width="1000" border="1">
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
			<td>���ַ�����Ϣ��0��1֮���С����</td>
		</tr>
		<tr>
			<td colspan="6"><table width="1000" border="1">
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
						<td >1</td>
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
			<td><hr />
			</td>
		</tr>
		<tr>
			<td colspan="6"><input type="button" class="button" name = "queryButton" value="������Ϣ" onClick="" >
				<input type="button" class="button" name = "queryButton" value="�㼶����" onClick="" >
				<input type="button" class="button" name = "queryButton" value="���ϼƻ�����" onClick="" >
				<input type="button" class="button" name = "queryButton" value="����������Ϣ" onClick="" >
				<input type="button" class="button" name = "queryButton" value="�ʱ�����ѯ" onClick="" >
				<input type="button" class="button" name = "queryButton" value="ҵ��Ա��Ϣ������" onClick="" >
				<input type="button" class="button" name = "queryButton" value="���ڸ�������" onClick="" >
			</td>
		</tr>
		<tr>
			<td><hr />
			</td>
		</tr>
		<tr>
			<td colspan="6"><input type="button" class="button" name = "queryButton" value="�����������ѯ" onClick="" >
				<input type="button" class="button" name = "queryButton" value="����" onClick="" >
				<input type="button" class="button" name = "queryButton" value="���±��鿴����0����" onClick="" >
			</td>
		</tr>
	</table>
</form>
  </body>
</html>
