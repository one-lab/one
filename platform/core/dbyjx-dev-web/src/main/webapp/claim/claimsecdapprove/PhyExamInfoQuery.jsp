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
    
	    <title>�����Ϣ��ѯ</title>
	    
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
		<table id="PhyExamAppnt" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�������˱���</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="45%">������ͬ��</td>
					<td width="45%">��ӡ��ˮ��</td>
				</tr>
		    </thead>
		</table>
		<hr />
		<table id="PhyExamInfo" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td  class="left">���ҽԺ��</td>
				<td  class="right"><input name="PhyExamHos" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">���ҽʦ��</td>
				<td  class="right"><input name="PhyExamDoct" class="common" type="text" onchange="clickable()"></td>
			</tr>
			<tr>
				<td  class="left">���ʱ�䣺</td>
				<td  class="right"><input name="PhyExamDate" class="common" type="text" onchange="clickable()"></td>
				<td  class="left">����ʱ�䣺</td>
				<td  class="right"><input name="PhyExamSecDate" class="common" type="text" onchange="clickable()"></td>
			</tr>
		</table>
		<table id="PhyExamList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�����Ŀ</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">���</td>
					<td width="32%">�����Ŀ����</td>
					<td width="32%">�����Ŀ����</td>
					<td width="32%">��ע</td>
				</tr>
		    </thead>
		</table>
		<table id="DiseaseResult" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�������</td>
				</tr>
				<tr class="tableHead">
					<td width="4%">���</td>
					<td width="32%">����֢״</td>
					<td width="32%">��������</td>
					<td width="32%">ICD����</td>
				</tr>
		    </thead>
		</table>
		<table id="PhyExamResult" class="common" cellpadding="3" cellspacing="1">
			<thead>
				<tr>
					<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�����</td>
				</tr>
				<tr>
					<td><textarea name="PhyExamResult" cols="" rows="4" style="width:100%"></textarea></td>
				</tr>
			</thead>
		</table>
		<hr />
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