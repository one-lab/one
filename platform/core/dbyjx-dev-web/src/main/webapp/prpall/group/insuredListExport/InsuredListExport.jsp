<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�������嵥����</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="common/css/Standard.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<table id="ContractInfo" class="common" cellpadding="3" cellspacing="0">
		<tr>
			<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     �����뱣������</td>
		</tr>
		<tr>
			<td  class="left">��������</td>
			<td  class="right"><input name="RegistNo" class="common" type="text""><img src="images/bgMarkMustInput.jpg" ></td>
			<td  class="right"><input type="button" class="cssbutton" name = "queryButton" value="ȷ  ��" onClick="" ></td>
			<td  class="common"></td>
			<td  class="common"></td>
			<td  class="common"></td>
		</tr>
		<tr>
			<td  class="left">��Ч����������</td>
			<td  class="right"><input name="RegistNo" class="common" type="text""></td>
			<td  class="right"><input type="button" class="cssbutton" name = "queryButton" value="�����嵥" onClick="" ></td>
			<td  class="common"></td>
			<td  class="common"></td>
			<td  class="common"></td>
		</tr>
		<tr>
			<td  class="left">��Ч����������</td>
			<td  class="right"><input name="RegistNo" class="common" type="text""></td>
			<td  class="right"><input type="button" class="cssbutton" name = "queryButton" value="�����嵥" onClick="" ></td>
			<td  class="common"></td>
			<td  class="common"></td>
			<td  class="common"></td>
		</tr>
	</table>
	<table id="UseInfo" class="common" cellpadding="3" cellspacing="0">
		<tr>
			<td class="formtitle"><img src="images/bgformtitle.gif" style="cursor:hand;">     ʹ�÷���</td>
		</tr>
		<tr>
			<td colspan="2"><ul>
					<li>1��¼�롰�������롱�������ȷ������ť��</li>
					<li>2������Ч����������������ʾ����ǰ��������Ч��������������������0ʱ���Ե���������嵥��������Excel�嵥</li>
					<li>3������Ч����������������ʾ����ǰ��������������������������0ʱ���Ե���������嵥��������Excel�嵥</li>
					<li>4���������嵥��Ϣ��һճ�����������˵���ģ�桱�У���ע�⵼��Sheet��ѡ��</li>
				</ul></td>
		</tr>
	</table>
</form>
  </body>
</html>
