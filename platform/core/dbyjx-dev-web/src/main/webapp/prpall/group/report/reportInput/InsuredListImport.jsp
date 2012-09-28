<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>被保险人清单导入</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="${ctx}/common/css/Standard.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript">
	ctx = "${ctx}";
</script>
<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
<script src="${ctx}/common/calender/WdatePicker.js"></script>
<script type="text/javascript">
	function findInsuredInfo() {
		if($("#manageCom").val()==""){
			alert("请输入管理机构");
			return;
		}
		var findUrl = ctx + "/prpall/findInsuredInfo.do";
		var params = {
			"lcInsured.grpContNo":$("#grpContNo").val(),
			"lcInsured.name":$("#name").val(),
			"lcInsured.manageCom":$("#manageCom").val(),
			"lcInsured.idNo":$("#idNo").val(),
			"lcInsured.birthday":$("#birthday").val()
		};
		function insuredInfoCallBack(obj) {
			$("#content").html("");
			var contentString="";
			var xuhao = 1 ;
			for(var i = 0 ; i < obj.data.length; i++){
				contentString += "<tr class='content' name='aa'>";
				var date = new Date();
				date.setTime(obj.data[i].birthday.time);
				var dateStr = date.getUTCFullYear()+"-"+(date.getUTCMonth()+1)+"-"+(date.getUTCDate()+1);
				contentString += "<td ><input name='checkRadio' type='radio' value="+obj.data[i].repNo+" />"+
				"<td>"+xuhao+"</td>"+
				"<td>"+obj.data[i].name+"</td>"+
				"<td>"+obj.data[i].sex+"</td>"+
				"<td>"+dateStr+"</td>"+
				"<td>"+obj.data[i].idType+"</td>"+
				"<td>"+obj.data[i].idNo+"</td>"+
				"<td>"+"暂时空着"+"</td>"+
				"<td>"+obj.data[i].contPlanCode+"</td>"+
				"<td>"+obj.data[i].executeCom+"</td>";
				xuhao++;
				contentString +="</tr>";
			}
			$("#content").html(contentString);
		}
		jQuery.post(findUrl, params, insuredInfoCallBack, "json");
	}
</script>
</head>

<body>
<form name="fm" method="post" onkeypress="KeyDown()">
<div style="width: 100%">
<table id="ReportCompanyInfo" class="common" cellpadding="3"
	cellspacing="0">
	<tr>
		<td class="formtitle" colspan="6"><img
			src="${ctx}/images/bgformtitle.gif" style="cursor: hand;">
		请输入被保险人查询条件</td>
	</tr>
	<tr>
		<td class="left">集体投保单号码：</td>
		<td class="right"><input id="grpContNo" name="grpContNo" class="common"
			type="text" onchange="clickable()"></td>
		<td class="left">管理机构：</td>
		<td class="right"><input type="hidden" id="upperComCode"
			value='2110000000' /> <input class="codecode" id="manageCom"
			name="manageCom" class="common" type="text"
			value="" style="width: 20%"
			ondblclick="queryCode('manageCom','comName','PrpDcompany','comCode:manageCom|upperComCode:upperComCode');"><input
			id="comName" name="comName" class="common" type="text"
			style="width: 68%" value=""><img
			src="${ctx}/images/bgMarkMustInput.jpg"></td>
		<td class="left">被保险人姓名：</td>
		<td class="right"><input id="name" name="name" class="common" type="text"
			onchange="clickable()"></td>
	</tr>
	<tr>
		<td class="left">证件号码：</td>
		<td class="right"><input id="idNo" name="idNo" class="common" type="text"
			onchange="clickable()"></td>
		<td class="left">层级编码：</td>
		<td class="right"><input name="PlanNo" class="common" type="text"
			onchange="clickable()"></td>
		<td class="left">出生日期：</td>
		<td class="right"><input name="birthday" id="birthday"
			class="common" type="text" onchange="clickable()" style="width: 73%"
			value=''> <img style='cursor: hand' align="middle"
			src="${ctx}/images/bgcalendar.gif"
			onClick="WdatePicker({el:'birthday',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
		</td>
	</tr>
</table>
<table id="QueryInfo" class="common" cellpadding="3" cellspacing="0">
	<tr>
		<td><input type="button" name="QueryButton" class="cssbutton"
			value="查  询" onclick="findInsuredInfo()"></td>
	</tr>
</table>
<table id="InsuredInfo" class="common" cellpadding="3" cellspacing="1">
	<thead>
		<tr>
			<td class="formtitle" colspan="6"><img
				src="${ctx}/images/bgformtitle.gif" style="cursor: hand;">被保险人信息</td>
		</tr>
		<tr class="tableHead">
			<td width="3%">&nbsp;</td>
			<td width="7%">序号</td>
			<td width="10%">姓名</td>
			<td width="10%">性别</td>
			<td width="15%">出生日期</td>
			<td width="10%">证件类型</td>
			<td width="15%">证件号码</td>
			<td width="10%">保费（元）</td>
			<td width="10%">保障计划编码</td>
			<td width="10%">服务机构</td>
		</tr>
	</thead>
	<tbody id="content">
		<tr class="content">
			<td><input name="checkRadio" type="radio" value="" /></td>
			<td>1</td>
			<td>张三</td>
			<td>男</td>
			<td>1988-10-01</td>
			<td>1</td>
			<td>2121215461854656</td>
			<td>200</td>
			<td>DFSFS</td>
			<td>860101</td>
		</tr>
	</tbody>
</table>
<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
	<tr>
		<td width="45%" align='right'><input type="button"
			class="cssbutton" value="首  页"></td>
		<td width="5%"><input type="button" class="cssbutton" value="上一页"></td>
		<td width="5%"><input type="button" class="cssbutton" value="下一页"></td>
		<td width="45%"><input type="button" class="cssbutton"
			value="尾  页"></td>
	</tr>
</table>
<hr>
</div>
<div id="Button1Info" style="display: ''">
<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
	<tr>
		<td width="43%" align='right'><input type="button"
			class="cssbutton" name="ReturnBack" value="返  回"
			onclick="javascript:history.go(-1);"></td>
		<td width="8%"><input type="button" class="cssbutton"
			name="ImportInsured" value="添加被保险人"
			onclick="location.href='${ctx}/prpall/group/noImageInput/NoListAdd.jsp'"></td>
		<td width="49%"><input type="button" class="cssbutton"
			name="DelInsured" value="导入被保险人清单"
			onclick="window.open('${ctx}/prpall/group/report/reportInput/InsuredListImportInput.jsp', 'newwindow', 'width=400, height=150, top=150, left=250, toolbar=no, menubar=no, scrollbars=no,resizable=no,location=no, status=yes')"></td>
	</tr>
</table>
</div>
<div id="Button2Info" style="display: ''">
<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
	<tr>
		<td width="20%" align='right'><input type="button"
			class="cssbutton" name="ReturnBack" value="返  回"
			onclick="javascript:history.go(-1);"></td>
		<td width="10%"><input type="button" class="cssbutton"
			name="ImportInsured" value="添加被保险人"
			onclick="location.href='../../noImageInput/NoListAdd.jsp'"></td>
		<td width="12%"><input type="button" class="cssbutton"
			name="DelInsured" value="导入被保险人清单"
			onclick="location.href='../reportInput/ListImportError.jsp'"></td>
		<td width="12%" align='right'><input type="button"
			class="cssbutton" name="ReturnBack" value="删除所有被保险人"
			onclick="javascript:history.go(-1);"></td>
		<td width="12%"><input type="button" class="cssbutton"
			name="ImportInsured" value="删除被保险人"
			onclick="location.href='../reportInput/ListImportError.jsp'"></td>
		<td width="12%"><input type="button" class="cssbutton"
			name="DelInsured" value="查看被保险人信息" onclick=""></td>
		<td width="22%"><input type="button" class="cssbutton"
			name="DelInsured" value="呈报被保人信息下载" onclick=""></td>
	</tr>
</table>
</div>
</form>
</body>
</html>
