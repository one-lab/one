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
    
    <title>�᰸��Ϣ��ѯ</title>
    
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
		<table id="ClaimInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><jsp:include page="../commonpage/ClaimInfoQuery.jsp" /></td>
			</tr>
		</table>
		<hr />
		<table id="EndCaseInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�᰸��Ϣ</td>
			</tr>
			<tr>
				<td class="left">ʵ���⸶��</td>
				<td class="right"><input name="CompMount" class="common" type="text" onChange="clickable()"></td>
				<td class="left">�᰸�ˣ�</td>
				<td class="right"><input name="EndcasePeo" class="common" type="text" onChange="clickable()"></td>
				<td class="left">�᰸���ڣ�</td>
				<td class="right"><input name="EndcaseDate" class="common" type="text" onChange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">ʵ����־��</td>
				<td  class="right"><input name="PaidFlag" class="common" type="text" onChange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type="button" class="cssbutton" name="RegisterConf" value="��֤������Ϣ" onclick="" />
					<input type="button" class="cssbutton" name="returnButton" value="��  ��" onclick="javascript:history.back();" />
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
