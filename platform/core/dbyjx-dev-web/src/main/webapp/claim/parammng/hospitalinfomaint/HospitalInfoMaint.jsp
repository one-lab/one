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
    
	    <title>医院信息维护</title>
	    
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
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>推荐医院信息查询<input type="button" class="cssbutton" name="queryButton" value="查  询" onClick=""/></td>
			</tr>
			<tr>
				<td class="left">医院代码：</td>
				<td class="right"><input name="HosCode" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">医院名称：</td>
				<td class="right"><input name="HosName" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">医院等级：</td>
				<td class="right"><input name="HosClass" class="common" type="text" onChange="clickable()"/></td>
			</tr>
			<tr>
				<td class="left">定点标志：</td>
				<td class="right"><input name="PointFlag" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">医院状态：</td>
				<td class="right"><input name="HosState" class="common" type="text" onChange="clickable()"/></td>
				<td class="left">管理机构：</td>
				<td class="right"><input name="MngCom" class="common" type="text" onChange="clickable()"/></td>
			</tr>
			<tr>
				<td class="left">医院地址：</td>
				<td class="right" colspan="3"><input name="HosAddress" class="common" type="text" onChange="clickable()"/></td>
			</tr>
			<tr>
				<td class="left">省：</td>
				<td class="right">
					<input class="codecode" id="provinceCode" name="lcReport.provinceCode" class="common" type="text" value="" style="width:20%"><input name="province" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">市：</td>
				<td class="right">
					<input class="codecode" id="cityCode" name="lcReport.cityCode" class="common" type="text" value="" style="width:20%"><input name="city" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">区/县：</td>
				<td class="right">
					<input class="codecode" id="countyCode" name="lcReport.countyCode" class="common" type="text" value="" style="width:20%"><input name="county" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td class="left">街道：</td>
				<td class="right" colspan="3"><input name="Street" class="common" type="text" onChange="clickable()"/></td>
			</tr>
		</table>
		<hr />
		<table id="RecomHosInfoList" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="11"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>推荐医院列表</td>
				</tr>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="8%">医院代码</td>
					<td width="12%">医院名称</td>
					<td width="8%">医院等级</td>
					<td width="6%">定点标志</td>
					<td width="10%">管理机构</td>
					<td width="12%">联系电话</td>
					<td width="15%">医院地址</td>
					<td width="8%">综合考核得分</td>
					<td width="10%">残疾鉴定资质标志</td>
				</tr>
			</thead>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="5%" align="right"><input type="button" class="cssbutton" value="首  页"/></td>
				<td width="5%"><input type="button" class="cssbutton" value="上一页"/></td>
				<td width="5%"><input type="button" class="cssbutton" value="下一页"/></td>
				<td width="85%"><input type="button" class="cssbutton" value="尾  页"/></td>
			</tr>
		</table>
		<hr />
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;"/>推荐医院信息</td>
			</tr>
			<tr>
				<td>
					<input type="button" class="cssbutton" name="AddButton" value="增  加" onClick=""/>
					<input type="button" class="cssbutton" name="ModifyButton" value="修  改" onClick=""/>
					<input type="button" class="cssbutton" name="DelButton" value="删  除" onClick=""/>
					<input type="button" class="cssbutton" name="ResetButton" value="重  置" onClick=""/>
					<input type="button" class="cssbutton" name="HosAssess" value="医院考核" onClick="self.location.href='${ctx}/claim/parammng/hospitalinfomaint/PointHospAssess.jsp'"/>
				</td>
			</tr>
		</table>
		<table id="BeforeOverViewMain" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="left">医院代码：</td>
				<td class="right"><input name="HosCode" class="common" type="text" onChange="clickable()"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">医院名称：</td>
				<td class="right"><input name="HosName" class="common" type="text" onChange="clickable()"/><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">医院等级：</td>
				<td class="right">
					<input class="codecode" id="hospitalCode" name="lcReport.hospitalCode" class="common" type="text" value="" style="width:20%"><input name="hospitalClass" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td class="left">定点标志：</td>
				<td class="right">
					<input class="codecode" id="pointCode" name="lcReport.pointCode" class="common" type="text" value="" style="width:20%"><input name="pointFlag" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">残疾鉴定资质标志：</td>
				<td class="right">
					<input class="codecode" id="appraCode" name="lcReport.appraCode" class="common" type="text" value="" style="width:20%"><input name="appraFlag" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">医院状态：</td>
				<td class="right">
					<input class="codecode" id="hosCode" name="lcReport.hosCode" class="common" type="text" value="" style="width:20%"><input name="hosState" class="common" type="text" onchange="clickable()" style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
			</tr>
			<tr>
				<td class="left">联系电话：</td>
				<td class="right"><input name="ConnTel" class="common" type="text" onChange="clickable()"/></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
			<tr>
				<td class="left">区号：</td>
				<td class="right"><input name="AreaCode" class="common" type="text" onChange="clickable()"/>-</td>
				<td class="left">电话号码：</td>
				<td class="right"><input name="Tel" class="common" type="text" onChange="clickable()"/>-</td>
				<td class="left">分机号：</td>
				<td class="right"><input name="ExtensionNum" class="common" type="text" onChange="clickable()"/></td>
			</tr>
			<tr>
				<td class="left">医院地址：</td>
				<td class="right" colspan="3"><input name="HosAddress" class="common" type="text" onChange="clickable()"/></td>
			</tr>
			<tr>
				<td class="left">省：</td>
				<td class="right">
					<input class="codecode" id="provinceCode" name="lcReport.provinceCode" class="common" type="text" value="" style="width:20%"><input name="province" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">市：</td>
				<td class="right">
					<input class="codecode" id="cityCode" name="lcReport.cityCode" class="common" type="text" value="" style="width:20%"><input name="city" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
				<td class="left">区/县：</td>
				<td class="right">
					<input class="codecode" id="countyCode" name="lcReport.countyCode" class="common" type="text" value="" style="width:20%"><input name="county" class="common" type="text" onchange="clickable()" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td class="left">街道：</td>
				<td class="right" colspan="3"><input name="Street" class="common" type="text" onChange="clickable()"/></td>
			</tr>
		</table>
		<hr />
	</div>
	</form>
</body>
</html>