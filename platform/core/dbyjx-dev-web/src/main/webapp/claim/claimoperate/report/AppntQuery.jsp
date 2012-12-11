<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
    	<base href="<%=basePath%>">
    	<base target="_self">
	    <title>客户信息查询</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript">ctx = "${ctx}";</script>
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>
		<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
		<script type="text/javascript" src="${ctx}/claim/claimoperate/report/js/AppntQuery.js"></script>
		
	</head>
<body>
	<form id="appntQueryFm" name="fm" method="post">
	<div style="width:100%">
		<table id="QueryCondt" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">查询条件(请至少输入一项查询条件)</td>
			</tr>
			<tr>
				<td class="left">客户号码：</td>
				<td class="right"><input id="insuredNo" name="lcInsured.id.insuredNo" class="common" type="text" value="${lcInsured.id.insuredNo }"></td>
				<td class="left">出险人姓名：</td>
				<td class="right"><input id="name" name="lcInsured.name" class="common" type="text" value="${lcInsured.name }"></td>
				<td class="left">出险人性别</td>
				<td class="right">
					<input class="codecode" id="sex" name="lcInsured.sex" class="common" type="text" ondblclick="queryCode('sex','sexName','PDLDcode1','codeType:Sex')" style="width:20%" value="${lcInsured.sex }"><input id="sexName" name="sexName" class="common" type="text" style="width:68%" value="">
				</td>
			</tr>
			<tr>
				<td class="left">出生日期：</td>
				<td class="right">
					<input id="birthday" class="common" name="lcInsured.birthday" type="text" style="width: 73%" value='<s:date name="lcInsured.birthday" format="yyyy-MM-dd"/>'/>
					<img style='cursor: hand' align="middle" src="${ctx}/images/bgcalendar.gif" onclick="WdatePicker({el:'birthday',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="left">证件类型：</td>
				<td class="right">
					<input class="codecode" id="idType" name="lcInsured.idType" class="common" type="text" ondblclick="queryCode('idType','idTypeName','PDLDcode1','codeType:IDType')" style="width:20%" value="${lcInsured.idType }"><input id="idTypeName" name="idTypeName" class="common" type="text" style="width:68%" value="">
				</td>
				<td  class="left">证件号码：</td>
				<td  class="right"><input id="idNo" name="lcInsured.idNo" class="common" type="text" value="${lcInsured.idNo }"></td>
			</tr>
			<tr>
				<td class="left">保单号：</td>
				<td  class="right"><input id="contNo" name="lcInsured.id.contNo" class="common" type="text" value="${lcInsured.id.contNo }"></td>
			</tr>
		</table>
		<table  id="RiskInfor" class="common" cellpadding="3" cellspacing="1">
			<tr>
				<td>
					<input type="button" class="cssbutton" name = "AppntSelect" value="查  询" onClick="queryLCInsuredByCondition();" />
					<input type="button" class="cssbutton" name = "returnButton" value="返  回" onClick="findLCInsuredByContNoInsuredNo();" />
				</td>
			</tr>
		</table>
		<table id="CustomInfoList" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="7"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">客户信息</td>
			</tr>
		</table>
		<table id="appntInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr class="tableHead">
					<td width="2%">&nbsp;</td>
					<td width="4%">序号</td>
					<td width="15%">客户号码</td>
					<td width="10%">出险人姓名</td>
					<td width="8%">性别</td>
					<td width="10%">出生日期</td>
					<td width="10%">证件类型</td>
					<td width="20%">证件号码</td>
				</tr>
			</thead>
			<tbody id="llSubReportContent">
				<s:iterator value="lcInsuredPage.result" var="lcInsured" status="index">
					  <tr class="content">
						<td><input type='radio' name='radio' value='<s:property value="#lcInsured.id.contNo" />,<s:property value="#lcInsured.id.insuredNo" />' /></td>
						<td><s:property value="#index.count"/></td>
						<td><s:property value="#lcInsured.id.insuredNo"/></td>
						<td>
							<s:if test="#lcInsured.name!=null"><s:property value="#lcInsured.name" /></s:if>
							<s:else>&nbsp;</s:else>
						</td>
						<td>
							<s:if test="#lcInsured.sex==0">女</s:if>
							<s:elseif test="#lcInsured.sex==1">男</s:elseif>
							<s:else>不详</s:else>
						</td>
						<td>
							<s:if test="#lcInsured.birthday!=null"><s:date name="#lcInsured.birthday" format="yyyy-MM-dd"/></s:if>
							<s:else>&nbsp;</s:else>							
						</td>
						<td>
							<s:if test="#lcInsured.idType==0">身份证</s:if>
							<s:elseif test="#lcInsured.idType==1">护照</s:elseif>
							<s:elseif test="#lcInsured.idType==2">军官证</s:elseif>
							<s:elseif test="#lcInsured.idType==3">驾照</s:elseif>
							<s:elseif test="#lcInsured.idType==4">出生证明</s:elseif>
							<s:elseif test="#lcInsured.idType==5">户口簿</s:elseif>
							<s:elseif test="#lcInsured.idType==8">其他</s:elseif>
							<s:elseif test="#lcInsured.idType==9">数据转换证件</s:elseif>
							<s:else>&nbsp;</s:else>
						</td>
						<td>
							<s:if test="#lcInsured.idNo!=null"><s:property value="#lcInsured.idNo"/></s:if>
							<s:else>&nbsp;</s:else>
						</td>
					  </tr>	
			  	</s:iterator>
          	</tbody>
		</table>
		<table id="PageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>