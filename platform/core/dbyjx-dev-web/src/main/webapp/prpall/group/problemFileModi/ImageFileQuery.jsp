<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Ӱ�����ѯ</title>
    
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
			<TD colspan="4"><hr />
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p></td>
		</TR>
		<TR>
			<TD colspan="4"><hr /></td>
		</TR>
		<TR>
			<TD class="left">Ͷ������</TD>
			<TD class="right">4176736471623746</TD>
			<TD class="left">Ӱ�����</TD>
			<TD class="right"><INPUT name="InsuredName" class="common" type="text" onchange="clickable()"></TD>
		</TR>
		<TR>
			<TD colspan="2"><input type="button" class="button" name = "queryButton" value="��ѯ" onClick="" >
			</TD>
		</TR>
		<TR>
			<TD colspan="4"><hr /></td>
		</TR>
		<TR>
			<TD>Ӱ��������Ϣ</td>
		</TR>
		<tr>
			<td colspan="4"><table width="1000" border="1">
					<tr>
						<th width="51" scope="col"></th>
						<th width="65" scope="col">���</th>
						<th width="159" scope="col">��֤��</th>
						<th width="167" scope="col">Ӱ�����</th>
						<th width="130" scope="col">Ӱ������</th>
						<th width="130" scope="col">ɨ�����κ�</th>
						<th width="130" scope="col">ҳ��</th>
						<th width="130" scope="col">ɨ��ʱ��</th>
					</tr>
					<tr>
						<td><input name="" type="radio" value="" /></td>
						<td>1</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<TR>
			<TD colspan="2"><input type="button" class="button" name = "queryButton" value="��ҳ" onClick="" >
				<input type="button" class="button" name = "queryButton" value="��һҳ" onClick="" >
				<input type="button" class="button" name = "queryButton" value="��һҳ" onClick="" >
				<input type="button" class="button" name = "queryButton" value="βҳ" onClick="" >
			</TD>
		</TR>
	</TABLE>
</form>
  </body>
</html>
