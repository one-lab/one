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
    
	    <title>ҽԺ��Ϣά��</title>
	    
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
		<table id="RecomHosInfoQuery" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>�Ƽ�ҽԺ��Ϣ��ѯ<input type="button" class="cssbutton" name="queryButton" value="��  ѯ" onClick=""/></td>
			</tr>
			<tr>
				<td class="left">ҽԺ���룺</td>
				<td class="right"><input name="HosCode" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">ҽԺ���ƣ�</td>
				<td class="right"><input name="HosName" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">ҽԺ�ȼ���</td>
				<td class="right"><input name="HosClass" class="common" type="text" onChange="clickable()"/></td>
			</tr>
			<tr>
				<td class="left">�����־��</td>
				<td class="right"><input name="PointFlag" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">ҽԺ״̬��</td>
				<td class="right"><input name="HosState" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">���������</td>
				<td class="right"><input name="MngCom" class="common" type="text" onChange="clickable()"/></td>
			</tr>
			<tr>
				<td class="left">ҽԺ��ַ��</td>
				<td class="right" colspan="3"><input name="HosAddress" class="common" type="text" onChange="clickable()"/></td>
			</tr>
			<tr>
				<td class="left">ʡ��</td>
				<td class="right">
					<input class="codecode" id="provinceCode" name="lcReport.provinceCode" class="common" type="text" value="" style="width:20%"><input name="province" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">�У�</td>
				<td class="right">
					<input class="codecode" id="cityCode" name="lcReport.cityCode" class="common" type="text" value="" style="width:20%"><input name="city" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">��/�أ�</td>
				<td class="right">
					<input class="codecode" id="countyCode" name="lcReport.countyCode" class="common" type="text" value="" style="width:20%"><input name="county" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td class="left">�ֵ���</td>
				<td class="right" colspan="3"><input name="Street" class="common" type="text" onChange="clickable()"/></td>
			</tr>
		</table>
		<hr />
		<table id="RecomHosInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="11"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>�Ƽ�ҽԺ�б�</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">���</td>
					<td width="8%">ҽԺ����</td>
					<td width="12%">ҽԺ����</td>
					<td width="8%">ҽԺ�ȼ�</td>
					<td width="6%">�����־</td>
					<td width="10%">�������</td>
					<td width="12%">��ϵ�绰</td>
					<td width="15%">ҽԺ��ַ</td>
					<td width="8%">�ۺϿ��˵÷�</td>
					<td width="10%">�м��������ʱ�־</td>
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>�Ƽ�ҽԺ��Ϣ</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="AddButton" value="��  ��" onClick=""/>
					<input type="button" class="cssbutton" name="ModifyButton" value="��  ��" onClick=""/>
					<input type="button" class="cssbutton" name="DelButton" value="ɾ  ��" onClick=""/>
					<input type="button" class="cssbutton" name="ResetButton" value="��  ��" onClick=""/>
					<input type="button" class="cssbutton" name="HosAssess" value="ҽԺ����" onClick="self.location.href='${ctx}/claim/parammng/hospitalinfomaint/PointHospAssess.jsp'"/>
				</td>
			</tr>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">ҽԺ���룺</td>
				<td class="right"><input name="HosCode" class="common" type="text" onChange="clickable()"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">ҽԺ���ƣ�</td>
				<td class="right"><input name="HosName" class="common" type="text" onChange="clickable()"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">ҽԺ�ȼ���</td>
				<td class="right">
					<input class="codecode" id="hospitalCode" name="lcReport.hospitalCode" class="common" type="text" value="" style="width:20%"><input name="hospitalClass" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td class="left">�����־��</td>
				<td class="right">
					<input class="codecode" id="pointCode" name="lcReport.pointCode" class="common" type="text" value="" style="width:20%"><input name="pointFlag" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">�м��������ʱ�־��</td>
				<td class="right">
					<input class="codecode" id="appraCode" name="lcReport.appraCode" class="common" type="text" value="" style="width:20%"><input name="appraFlag" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">ҽԺ״̬��</td>
				<td class="right">
					<input class="codecode" id="hosCode" name="lcReport.hosCode" class="common" type="text" value="" style="width:20%"><input name="hosState" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">��ϵ�绰��</td>
				<td class="right"><input name="ConnTel" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">���ţ�</td>
				<td class="right"><input name="AreaCode" class="common" type="text" onChange="clickable()"/>-</td>
				<td class="left">�绰���룺</td>
				<td class="right"><input name="Tel" class="common" type="text" onChange="clickable()"/>-</td>
				<td class="left">�ֻ��ţ�</td>
				<td class="right"><input name="ExtensionNum" class="common" type="text" onChange="clickable()"/></td>
			</tr>
			<tr>
				<td class="left">ҽԺ��ַ��</td>
				<td class="right" colspan="3"><input name="HosAddress" class="common" type="text" onChange="clickable()"/></td>
			</tr>
			<tr>
				<td class="left">ʡ��</td>
				<td class="right">
					<input class="codecode" id="provinceCode" name="lcReport.provinceCode" class="common" type="text" value="" style="width:20%"><input name="province" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">�У�</td>
				<td class="right">
					<input class="codecode" id="cityCode" name="lcReport.cityCode" class="common" type="text" value="" style="width:20%"><input name="city" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">��/�أ�</td>
				<td class="right">
					<input class="codecode" id="countyCode" name="lcReport.countyCode" class="common" type="text" value="" style="width:20%"><input name="county" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td class="left">�ֵ���</td>
				<td class="right" colspan="3"><input name="Street" class="common" type="text" onChange="clickable()"/></td>
			</tr>
		</table>
		<hr />
	</div>
	</form>
</body>
</html>