<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>������޸��׽���</title>
    
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
			<td>�������ѯͶ���������� </td>
		</tr>
		<tr>
			<td class="left">Ͷ������</td>
			<td class="right"><INPUT name="PolicyNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">���۷�ʽ</td>
			<td  class="right"><INPUT name="PolicyNo" class="common" type="text" onchange="clickable()"></td>
			<td  class="left">�������</td>
			<td  class="right"><INPUT name="PolicyNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td class="left">ҵ��Ա����</td>
			<td class="right"><INPUT name="PolicyNo" class="common" type="text" onchange="clickable()"></td>
			<td class="left">������·�����</td>
			<td class="right"><INPUT name="Startdate" id="Startdate" class="common" type="text" onchange="clickable()" style="width:73%"
    	  value='2012-04-28'>
				<img style='cursor:hand' align="absmiddle" src="common/images/bgcalendar.gif" onClick="TogglePopupCalendarWindow('document.fm.Startdate', '1997', '2014')"></td>
			<td class="left">Ͷ����λȫ��</td>
			<td class="right"><INPUT name="PolicyNo" class="common" type="text" onchange="clickable()"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" class="button" name = "queryButton" value="��ѯ" onClick="" ></td>
		</tr>
		<tr>
			<td>��������</td>
		</tr>
		<tr>
			<td colspan="6"><table width="800" border="1">
					<tr>
						<th scope="col">&nbsp;</th>
						<th scope="col">���</th>
						<th scope="col">Ͷ������</th>
						<th scope="col">���۷�ʽ</th>
						<th scope="col">Ͷ����λȫ��</th>
						<th scope="col">������·�����</th>
					</tr>
					<tr>
						<td><label>
							<input type="radio" name="radiobutton" value="radiobutton" />
							</label></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td colspan="6"><input type="button" class="button" name = "queryButton" value="��ҳ" onClick="" >
				<input type="button" class="button" name = "queryButton" value="��һҳ" onClick="" >
				<input type="button" class="button" name = "queryButton" value="��һҳ" onClick="" >
				<input type="button" class="button" name = "queryButton" value="βҳ" onClick="" ></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" class="button" name = "queryButton" value="����" onClick="parent.document.getElementById('fraInterface').src ='group/problemFileModi/ProblemFileModify.jsp'" ></td>
		</tr>
		<tr>
			<td>Ͷ������Ϣ</td>
		</tr>
	</table>
</form>
  </body>
</html>
