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
    	
	    <title>出险人基本信息列表</title>
	    
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
		<script src="${ctx}/common/calender/WdatePicker.js"></script>

	</head>

	<div id="appntInfofrm" style="width:100%">
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
			<%-- <tbody id="content">
				<s:iterator value="lcInsuredPage.result" var="lcInsured" status="index">
					  <tr class="content">
						<td><input type='radio' name='radioGrpNo' value='<s:property value="#lcInsured.id.contNo" />,<s:property value="#lcInsured.id.insuredNo" />' /></td>
						<td><s:property value="#index.count"/></td>
						<td><s:property value="#lcInsured.id.insuredNo"/></td>
						<td><s:property value="#lcInsured.name" /></td>
						<td>
							<s:if test="#lcInsured.sex==0">女</s:if>
							<s:elseif test="#lcInsured.sex==1">男</s:elseif>
							<s:else>不详</s:else>
						</td>
						<td><s:date name="#lcInsured.birthday" format="yyyy-MM-dd"/></td>
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
						<td><s:property value="#lcInsured.idNo"/></td>
					  </tr>	
			  	</s:iterator>
          	</tbody>--%>
          	<tbody id="llSubReportContent">
				<s:if test="#request.llSubReportList!=null">
					<s:iterator value="#request.llSubReportList" var="temp" status="index">
					 	<tr class="content" >
						 	<td><input name='radioRptNo' type='radio' value="<s:property value='#temp.subRptNo'/>"/></td>
							<td><s:property value="#index.count"/></td>
							<td><s:property value="#temp.id.customerNo"/></td>
							<td><s:property value="#temp.customerName"/></td>
							<td><s:property value="#temp.sexValue"/></td>
							<td><s:date name="#temp.custBirthday" format="yyyy-MM-dd"/></td>
							<td><s:property value="#temp.idTypeValue"/></td>
							<td><s:property value="#temp.idNo"/></td>
						</tr>
					</s:iterator>
					</s:if>
				</tbody>
          	
		</table>
	</div>
</html>