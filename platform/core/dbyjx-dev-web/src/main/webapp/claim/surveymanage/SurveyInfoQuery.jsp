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
    
	    <title>���������Ϣ�鿴</title>
	    
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
		<table id="SurveyList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">���ⰸ�����е��������ϸ�б�</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="14%">�������</td>
					<td width="15%">��������</td>
					<td width="10%">���鷽ʽ</td>
					<td width="15%">����ص�</td>
					<td width="10%">��������</td>
					<td width="10%">�������</td>
					<td width="10%">��һ������</td>
					<td width="10%">������</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input type="radio" name="Redio" value="" /></td>
					<td>1</td>
					<td>0211035120</td>
					<td>2010-10-20</td>
					<td>01</td>
					<td>����</td>
					<td>������</td>
					<td>862100</td>
					<td>LP�������</td>
					<td>������</td>
				</tr>
			</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="5%" align='right'><input type = "button" class="cssbutton" value="��  ҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="85%"><input type = "button" class="cssbutton" value="β  ҳ"></td>
			</tr>
		</table>
		
		<table id="SurveyInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">���������ϸ��Ϣ</td>
			</tr>
			<tr>
				<td  class="left">�ⰸ�ţ�</td>
				<td  class="right"><input name="ClaimNum" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">������ţ�</td>
				<td  class="right">
					<input name="surveyNum" class="common" type="text" onchange="clickable()">
				</td>
				<td  class="left">������ţ�</td>
				<td  class="right">
					<input name="ProcessNum" class="common" type="text" onchange="clickable()">
				</td>
			</tr>
			<tr>
				<td  class="left">���鷽ʽ��</td>
				<td  class="right">
					<input class="codecode" id="surveyTypeCode" name="lcReport.surveyTypeCode" class="common" type="text" value="" style="width:20%"><input name="surveyType" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td  class="left">����ص㣺</td>
				<td  class="right"><input name="surveyAddress" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�������ڣ�</td>
				<td  class="right">
					<input name="SurveyDate" id="SurveyDate" class="common" type="text" onchange="clickable()" />
				</td>
			</tr>
			<tr>
				<td  class="left">��һ�����ˣ�</td>
				<td  class="right"><input name="FirstSurvey" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">�������ˣ�</td>
				<td  class="right"><input name="surveyPeople" class="common" type="text" onchange="clickable()"></td>
				<td  class="common"> </td>
				<td  class="common"> </td>
			</tr>
		</table>
		<table id="SurveyProcess" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td >�������</td>
			</tr>
			<tr>
				<td><textarea name="SurveyProcess" cols="" rows="4" style="width:98%"></textarea><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td >��ע </td>
			</tr>
			<tr>
				<td><textarea name="remarkContent" cols="" rows="4" style="width:100%"></textarea></td>
			</tr>
		</table>
		<hr />
		<table id="SurveyAffixList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">������̵�֤��Ϣ�б�</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">���</td>
					<td width="20%">��֤���</td>
					<td width="20%">��֤����</td>
					<td width="26%">ԭ������</td>
					<td width="10%">����</td>
					<td width="20%">��ע��Ϣ</td>
				</tr>
			</thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td><input type="button" class="cssbutton" name="returnButton" value="��  ��" onclick="javascript:history.back();" /></td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>