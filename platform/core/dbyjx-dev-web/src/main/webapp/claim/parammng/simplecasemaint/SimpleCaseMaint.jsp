<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
    	<base href="<%=basePath%>"/>
    
	    <title>���װ�����׼ά��</title>
	    
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
		<meta http-equiv="expires" content="0"/>    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
		<meta http-equiv="description" content="This is my page"/>
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css"/>
		<script src="${ctx}/common/calender/WdatePicker.js"></script>

	</head>
<body>
	<form name="fm" method="post" onKeyPress="KeyDown()">
	<div style="width:100%">
		<table id="SimpleCaseQuery" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle"" colspan="6">
					<img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>���װ�����׼��ѯ<input type="button" class="cssbutton" name="queryButton" value="��  ѯ" onClick=""/>
				</td>
				
			</tr>
			<tr>
				<td class="left">�������룺</td>
				<td class="right"><input name="ComCode" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">�������ƣ�</td>
				<td class="right"><input name="ComName" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="10"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>���װ�����׼�б�</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="15%">��������</td>
					<td width="15%">��������</td>
					<td width="10%">�ϼ�����</td>
					<td width="10%">��С���</td>
					<td width="10%">�����</td>
					<td width="10%">��������</td>
					<td width="10%">��������</td>
					<td width="10%">����Ա</td>
				</tr>
			</thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="5%" align="right"><input type="button" class="cssbutton" value="��  ҳ"/></td>
				<td width="5%"><input type="button" class="cssbutton" value="��һҳ"/></td>
				<td width="5%"><input type="button" class="cssbutton" value="��һҳ"/></td>
				<td width="85%"><input type="button" class="cssbutton" value="β  ҳ"/></td>
			</tr>
		</table>
		<hr />
		
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>���װ�����׼</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="AddButton" value="��  ��" onClick=""/>
					<input type="button" class="cssbutton" name="ModifyButton" value="��  ��" onClick=""/>
					<input type="button" class="cssbutton" name="DelButton" value="ɾ  ��" onClick=""/>
					<input type="button" class="cssbutton" name="ResetButton" value="��  ��" onClick=""/>
				</td>
			</tr>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">�������ƣ�</td>
				<td class="right">
					<input class="codecode" id="comCode" name="lcReport.comCode" class="common" type="text" value="2000000122" style="width:20%"><input name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="������ֹ�˾"><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				<td class="left">�ϼ�������</td>
				<td class="right"><input name="SuperCom" class="common" type="text" onChange="clickable()"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">��С��</td>
				<td class="right"><input name="MinMount" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">����</td>
				<td class="right"><input name="MaxMount" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>	
				<td class="left">�������ڣ�</td>
				<td class="right">
					<input name="EnableDate" id="EnableDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'EnableDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="left">�������ڣ�</td>
				<td class="right">
					<input name="EndDate" id="EndDate" class="common" type="text" onchange="clickable()" style="width: 73%" value='' />
					<img style='cursor: hand' align="absmiddle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'EndDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="left">����Ա��</td>
				<td class="right"><input name="Operator" class="common" type="text" onChange="clickable()"/></td>
			</tr>
			<tr>
				<td class="left">������ڣ�</td>
				<td class="right"><input name="InDate" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">���ʱ�䣺</td>
				<td class="right"><input name="InTime" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>	
				<td class="left">���һ���޸����ڣ�</td>
				<td class="right"><input name="LastModifyDate" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">���һ���޸�ʱ�䣺</td>
				<td class="right"><input name="LastModifyTime" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr />
	</div>
	</form>
</body>
</html>