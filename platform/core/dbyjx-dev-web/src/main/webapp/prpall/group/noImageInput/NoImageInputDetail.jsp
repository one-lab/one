<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>无影像录入</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/InputCode.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/noImageInput/js/NoImageInputDetail.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/noImageInput/js/ClientQuery.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/proposalPre/ProposalPreApply.js"></script>	
	<script type="text/javascript" src="${ctx }/prpall/group/artificalUW/js/ProblemFileInput.js"></script>
	<script type="text/javascript" src="${ctx }/prpall/group/artificalUW/js/UWFileQuery.js"></script>
	
	<script type="text/javascript">
	var ctx='${ctx}';
	</script>
  </head>
  
  <body>
    <form id="lcGrpGroupForm" name="lcGrpGroupForm" method="post" >
	<div style="width:100%">
		<%--隐藏域 --%>
		<%--客户名称 --%>
		<input type="hidden" id="customerNoHidden" name="customerNoHidden" value="<s:property value='lcGrpContGroupVo.lcGrpCont.appntNo' />"></input>
		<%--地址类型 --%>
		<input type="hidden" id="addressNoHidden" name="addressNoHidden" value=""></input>
		
		<%--集体投保单号码 --%>
		<input type="hidden" id="proposalGrpContNoHidden" name="" value=""></input>
		<table id=PraPallInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">  投保单信息</td>
				
			</tr>
			<tr>
				<td class="left">投保单号码：</td>
				<td class="right"><input id="grpContNo" name="lcGrpContGroupVo.lcGrpCont.grpContNo" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpCont.grpContNo' />"></td>
				<td class="left">呈报件号：</td>
				<td class="right"><input id="reportNo" name="lcGrpContGroupVo.lcGrpCont.reportNo" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpCont.reportNo' />"></td>				
				<td class="left">投保日期：</td>
				<td class="right">
					<input name="lcGrpContGroupVo.lcGrpCont.firstTrialDate" id="firstTrialDate" class="common" type="text"  style="width: 73%" value='<s:date name="lcGrpContGroupVo.lcGrpCont.firstTrialDate" format="yyyy-MM-dd"/>'><img src="${ctx}/images/bgMarkMustInput.jpg" >
					<img style='cursor: hand' align="middle" src="${ctx}/images/bgcalendar.gif" onClick="WdatePicker({el:'firstTrialDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
			<tr>
				<td class="left">保单生效日期：</td>
				<td class="right">
					<input name="lcGrpContGroupVo.lcGrpCont.cvaliDate" id="cvaliDate" class="common" type="text"  style="width: 73%" value='<s:date name="lcGrpContGroupVo.lcGrpCont.cvaliDate" format="yyyy-MM-dd"/>'><img src="${ctx}/images/bgMarkMustInput.jpg" >
					<img style='cursor: hand' align="middle" src="${ctx}/images/bgcalendar.gif" onClick="WdatePicker({el:'cvaliDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
				<td class="left">续保原保单号：</td>
				<td class="right"><input name="lcGrpContGroupVo.lcGrpCont.cregistNo" class="common" type="text"  value='<s:property value="lcGrpContGroupVo.lcGrpCont.cregistNo" />'></td>
				<td class="left">管理机构：</td>
				<td class="right">
				<input type="hidden" id="upperComCode" value='<s:property value="#session.prpDcompany.comCode"/>' />
					<input id="comCode" name="lcGrpContGroupVo.lcGrpCont.manageCom" class="codecode" type="text" 
					ondblclick="queryCode('comCode','comName','PrpDcompany','comCode:comCode|upperComCode:upperComCode')" style="width:20%" 
					value='<s:property value="#session.prpDcompany.comCode"/>'><input id='comName' name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value="<s:property value='' />"> <img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td class="left">销售方式：</td>
				<td class="right"><input id="grpSellType" name="lcGrpContGroupVo.lcGrpCont.grpSellType" class="codecode" type="text" onchange="clickable()" ondblclick="queryCode('grpSellType','grpSellName','PDLDcode1','codeType:SaleType')" value="<s:property value='lcGrpContGroupVo.lcGrpCont.grpSellType' />" style="width:20%">
				<input id="grpSellName" name="grpSellName" class="common" type="text" value="" onchange="clickable()" style="width:68%"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">协议书号：</td>
				<td class="right"><input id="conferNo" name="lcGrpContGroupVo.lcGrpCont.conferNo" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpCont.conferNo' />"></td>				
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<hr><br>
		<%-- 
		<table id=PraPallInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">业务员编码：</td>
				<td class="right"><input name="comCode" class="codecode" type="text" ondblclick="queryCode('MainAgentCode','MainAgentName','PDLDcode1','codeType:MainAgent')" value="<s:property value='' />" style="width:20%"><input name="comName" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpCont.cvaliDate' />" style="width:68%"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">业务员姓名：</td>
				<td class="right"><input name="RepApplyNo" class="common" type="text"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>				
				<td class="left">所属机构：</td>
				<td class="right"><input name="comCode" class="codecode" type="text" onchange="clickable()" value="" style="width:20%"><input name="comName" class="common" type="text" value="" onchange="clickable()" style="width:68%"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>			
			</tr>
			<tr>
				<td class="left">所属分部：</td>
				<td class="right"><input name="SaleType" class="common" type="text" ></td>
				<td class="left">多业务员,请勾选：</td>
				<td><input type="checkbox" name="checkbox" value="checkbox" /></td>			
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<table id=ContImpartInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6" ><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">其他业务员信息</td>
				</tr>
				<tr class="tableHead">
					<td width="5%">序号</td>
					<td width="19%">业务员代码</td>
					<td width="19%">业务员姓名</td>
					<td width="19%">所属机构</td>
					<td width="19%">所属分布</td>
					<td width="19%">佣金比例</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>a</td>
					<td>a</td>
					<td>a</td>
					<td>a</td>
					<td>a</td>
				</tr>
			</tbody>
		</table>
		--%>
		<hr><br>
		<table id="CompanyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="4" >
				<img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">
				投保单位资料（客户号
				<input type="button" id="selectInfoByCustomerNo" class="cssbutton" value="查  询" >）（首次投保单位无需填写客户号）</td>
			</tr>
			<tr>
				<td class="left">VIP客户：</td>
				<td class="right"><input class="codecode" id="vipValue" name="lcGrpContGroupVo.ldGrp.vipValue" class="common" type="text"  style="width:20%" ondblclick="queryCode('vipValue','vipFlag','PDLDcode1','codeType:VipFlag')" value="<s:property value='lcGrpContGroupVo.ldGrp.vipValue' />" /><input id="vipFlag" name="vipFlag" class="common" type="text"   style="width:68%" value=""></td>
				<td class="left"></td>
				<td class="right"></td>
				<td class="left"></td>
				<td class="right"></td>
			</tr>
			<tr>
				<td class="left">投保单位名称：</td>
				<td class="right" colspan="3"><input id="grpName"  name="lcGrpContGroupVo.ldGrp.grpName" class="common" type="text" value="<s:property value='lcGrpContGroupVo.ldGrp.grpName' />"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">行业类别：</td>
				<td class="right"><input class="codecode" id="businessType" name="lcGrpContGroupVo.ldGrp.businessType" class="common" type="text" value="<s:property value='lcGrpContGroupVo.ldGrp.businessType' />" style="width:20%" ondblclick="queryCode('businessType','businessName','PDLDcode1','codeType:OccupationType')" ><input id="businessName" name="businessName" class="common" type="text"   style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>

			</tr>
			<tr>
				<td class="left">组织机构代码：</td>
				<td class="right"><input id="organizationNo"  name="lcGrpContGroupVo.ldGrp.organizationNo" class="common" type="text" value="<s:property value='lcGrpContGroupVo.ldGrp.organizationNo' />"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">资产总额（万元）：</td>
				<td class="right"><input  id="asset" name="lcGrpContGroupVo.ldGrp.asset" class="common" type="text" value="<s:property value='lcGrpContGroupVo.ldGrp.asset' />"></td>
				<td class="left">税务登记证号：</td>
				<td class="right"><input id="taxRegistNo"  name="lcGrpContGroupVo.ldGrp.taxRegistNo" class="common" type="text" value="<s:property value='lcGrpContGroupVo.ldGrp.taxRegistNo' />"></td>
			</tr>
			<tr>
				<td class="left">年总收入（万元）：</td>
				<td class="right"><input  id="yearGrossIncome" name="lcGrpContGroupVo.ldGrp.yearGrossIncome" class="common" type="text" value="<s:property value='lcGrpContGroupVo.ldGrp.yearGrossIncome' />"></td>
				<td class="left">单位性质：</td>
				<td class="right"><input class="codecode" id="grpNature" name="lcGrpContGroupVo.ldGrp.grpNature" class="common" type="text" value="<s:property value='lcGrpContGroupVo.ldGrp.grpNature' />"style="width:20%" ondblclick="queryCode('grpNature','grpNatureName','PDLDcode1','codeType:GrpNature')"><input id="grpNatureName" name="grpNatureName" class="common" type="text"   style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">成立日期：</td>
				<td class="right">
					<input id="foundDate"  name="lcGrpContGroupVo.ldGrp.foundDate" class="common" type="text"  style="width:73%" value="<s:date name="lcGrpContGroupVo.ldGrp.foundDate" format="yyyy-MM-dd"/>">
					<img style='cursor:hand' align="middle" src="${ctx}/images/bgcalendar.gif" onClick="WdatePicker({el:'foundDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"></td>
			</tr>
			<tr>
				<td class="left">经营区域：</td>
				<td class="right"><input class="codecode" id="operateArea"  name="lcGrpContGroupVo.ldGrp.operateArea" class="common" type="text" value="<s:property value='lcGrpContGroupVo.ldGrp.operateArea' />"style="width:20%" ondblclick="queryCode('operateArea','operateAreaName','PDLDcode1','codeType:OperateArea')"><input id="operateAreaName" name="operateAreaName" class="common" type="text"   style="width:68%" value=""></td>
				<td class="left">主营业务：</td>
				<td class="right"><input id="mainBussiness"  name="lcGrpContGroupVo.ldGrp.mainBussiness" class="common" type="text" value="<s:property value='lcGrpContGroupVo.ldGrp.mainBussiness' />"></td>
				<td class="left">单位总人数：</td>
				<td class="right"><input class="codecode" id="grpPeoples"  name="lcGrpContGroupVo.ldGrp.grpPeoples" class="common" type="text" value="<s:property value='lcGrpContGroupVo.ldGrp.grpPeoples' />" style="width:20%" ondblclick="queryCode('grpPeoples','grpPeoplesRange','PDLDcode1','codeType:GrpPeoples')" ><input id="grpPeoplesRange" name="grpPeoplesRange" class="common" type="text"   style="width:68%" value=""></td>
			</tr>
			<tr>
				<td class="left">是否已参加社会统筹：</td>
				<td class="right"><input class="codecode" id="societyStat"  name="lcGrpContGroupVo.lcGrpAppnt.societyStat" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpAppnt.societyStat' />" style="width:20%" ondblclick="queryCode('societyStat','societyStatFlag','PDLDcode1','codeType:SocietyStat')"><input id="societyStatFlag" name="societyStatFlag" class="common" type="text"   style="width:68%" value="">
				<img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">社保登记证号：</td>
				<td class="right"><input id="societyRegistNo"  name="lcGrpContGroupVo.lcGrpAppnt.societyRegistNo" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpAppnt.societyRegistNo' />"></td>
				<td class="left"></td>
				<td class="right"></td>				
			</tr>
			<tr>
				<td class="left">联系地址：</td>
				<td class="right" colspan="3"><input id="postalAddress"  name="lcGrpContGroupVo.lcGrpAppnt.postalAddress" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpAppnt.postalAddress' />"><input id="addressNo"  name="" class="common" type="hidden" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">联系邮编：</td>
				<td class="right"><input id="zipCode"  name="lcGrpContGroupVo.lcGrpAppnt.zipCode" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpAppnt.zipCode' />"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td class="left">联系电话：</td>
				<td class="right"><input id="phone"  name="lcGrpContGroupVo.lcGrpAppnt.phone" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpAppnt.phone' />"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">联系部门：</td>
				<td class="right"><input id="department"  name="lcGrpContGroupVo.lcGrpAppnt.department" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpAppnt.department' />"></td>
				<td class="left"></td>
				<td class="right"></td>
			</tr>
			<tr>
				<td class="left">联系人：</td>
				<td class="right"><input name="lcGrpContGroupVo.lcGrpAppnt.name1" class="common" type="text" id="name1" value="<s:property value='lcGrpContGroupVo.lcGrpAppnt.name1' />"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">联系人性别：</td>
				<td class="right"><input class="codecode" id="sex1" name="lcGrpContGroupVo.lcGrpAppnt.sex1" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpAppnt.sex1' />" style="width:20%" ondblclick="queryCode('sex1','SexType','PDLDcode1','codeType:Sex')"><input id="SexType" name="SexType" class="common" type="text"   style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">联系人电话：</td>
				<td class="right"><input name="lcGrpContGroupVo.lcGrpAppnt.telphone1" class="common" type="text" id="telphone1" value="<s:property value='lcGrpContGroupVo.lcGrpAppnt.telphone1' />"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td class="left">手机：</td>
				<td class="right"><input name="lcGrpContGroupVo.lcGrpAppnt.phone1" class="common" type="text" id="phone1" value="<s:property value='lcGrpContGroupVo.lcGrpAppnt.phone1' />"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">E-MAIL：</td>
				<td class="right"><input name="lcGrpContGroupVo.lcGrpAppnt.email" class="common" type="text" id="email" value="<s:property value='lcGrpContGroupVo.lcGrpAppnt.email' />"></td>
				<td class="left"></td>
				<td class="right"></td>
			</tr>
			<tr>
				<td class="left">单位法人：</td>
				<td class="right"><input id="corporation"  name="lcGrpContGroupVo.lcGrpCont.corporation" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpCont.corporation' />"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">法人证件类型：</td>
				<td class="right"><input id="corporationIDType" name="lcGrpContGroupVo.lcGrpCont.corporationIDType" class="codecode" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpCont.corporationIDType' />" style="width:20%" ondblclick="queryCode('corporationIDType','corporationIDTypeName','PDLDcode1','codeType:IDType')"><input id="corporationIDTypeName" name="corporationIDTypeName" class="common" type="text"   style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">法人证件号：</td>
				<td class="right"><input id="corporationIDNo" name="lcGrpContGroupVo.lcGrpCont.corporationIDNo" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpCont.corporationIDNo' />"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td class="left">法人有效日期：</td>
				<td class="right"><input id="corporationsDate" name="lcGrpContGroupVo.lcGrpCont.corporationsDate" class="common" type="text"  style="width:73%"
    	  			value='<s:date name="lcGrpContGroupVo.lcGrpCont.corporationsDate" format="yyyy-MM-dd"/>'>
					<img style='cursor:hand' align="middle" src="${ctx}/images/bgcalendar.gif" onClick="WdatePicker({el:'corporationsDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left"></td>
				<td class="right"></td>
				<td class="left"></td>
				<td class="right"></td>
			</tr>
			<tr>
				<td class="left">投保单位人数：</td>
				<td class="right"><input id="grpPeople" name="lcGrpContGroupVo.lcGrpCont.grpPeoples" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpCont.grpPeoples' />"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">主被保险人数：</td>
				<td class="right"><input id="mainInsurePersonNumber" name="lcGrpContGroupVo.lcGrpCont.mainInsurePersonNumber" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpCont.mainInsurePersonNumber' />"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">连带被保险人数：</td>
				<td class="right"><input id="relatedInsurePersonNumber" name="lcGrpContGroupVo.lcGrpCont.relatedInsurePersonNumber" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpCont.relatedInsurePersonNumber' />"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td class="left">投保率：</td>
				<td class="right"><input id="rate" name="lcGrpContGroupVo.lcGrpCont.rate" class="common" type="text" value="<s:property value='lcGrpContGroupVo.lcGrpCont.rate' />"></td>
				<td class="left"></td>
				<td class="right"></td>
				<td class="left"></td>
				<td class="right"></td>
			</tr>
		</table>
		<table id=ContImpartInfo" class="common" cellpadding="3" cellspacing="0">
	<thead>
		<tr>
			<td class="formtitle" colspan="6"><img
				src="${ctx}/images/bgformtitle.gif" style="cursor: hand;">
			投保单告知书</td>
		</tr>
		<tr class="tableHead">
			<td width="5%">序号</td>
			<td width="10%">告知版别</td>
			<td width="10%">告知内容编号</td>
			<td width="30%">告知内容</td>
			<td width="40%">录入信息</td>
			<td width="5%">&nbsp;</td>
		</tr>
	</thead>
	<tbody id="PremInfoBody">
	 
		<s:if test="lcGrpContGroupVo.lcRepInfoList.size > 0">
			<c:forEach items="${lcGrpContGroupVo.lcRepInfoList}" var="temp" varStatus="s" >	
			<tr class="content" id="prem${s.index+1}">		
			<td width="5%">${s.index+1} </td>
			<td width="10%"><input type='text' id="ver${s.index+1}"
				name='lcGrpContGroupVo.lcRepInfoList[${s.index}].id.impartVer' maxlength='5' size='5'
				value="${temp.id.impartVer}" /><img src='${ctx}/images/bgMarkMustInput.jpg'></td>
			<td width="10%"><input type='text' id="code${s.index+1}"
				name='lcGrpContGroupVo.lcRepInfoList[${s.index}].id.impartCode' maxlength='4' size='4'
				value="${temp.id.impartCode}" /><img src='${ctx}/images/bgMarkMustInput.jpg'></td>
			<td width="30%"><input type='text' id="detail${s.index+1}"
				name='lcGrpContGroupVo.lcRepInfoList[${s.index}].impartDetailContent' size='50' value="${temp.impartDetailContent}" /><img
				src='${ctx}/images/bgMarkMustInput.jpg'></td>
			<td width="40%"><input type='text' id="mes${s.index+1}"
				name='lcGrpContGroupVo.lcRepInfoList[${s.index}].message' size='50' value="${temp.message}" /></td>
			<td width="5%"><input type='button' value='-' onclick="removePremInfo('prem${s.index+1}');"/></td>
			</tr>
			</c:forEach>
			</s:if>
			<s:else>
			<tr class="content" id="prem0">		
			<td width="5%">1 <input id='serial1' type="hidden" 
				name="lcGrpContGroupVo.lcRepInfoList[0].id.subSerialNo" value="0" /></td>
			<td width="10%"><input type='text' id="ver1"
				name='lcGrpContGroupVo.lcRepInfoList[0].id.impartVer' maxlength='5' size='5'
				value="${temp.id.impartVer}" /><img src='${ctx}/images/bgMarkMustInput.jpg'></td>
			<td width="10%"><input type='text' id="code1"
				name='lcGrpContGroupVo.lcRepInfoList[0].id.impartCode' maxlength='4' size='4'
				value="${temp.id.impartCode}" /><img src='${ctx}/images/bgMarkMustInput.jpg'></td>
			<td width="30%"><input type='text' id="detail1"
				name='lcGrpContGroupVo.lcRepInfoList[0].impartDetailContent' size='50' value="${temp.impartDetailContent}" /><img
				src='${ctx}/images/bgMarkMustInput.jpg'></td>
			<td width="40%"><input type='text' id="mes1"
				name='lcGrpContGroupVo.lcRepInfoList[0].message' size='50' value="${temp.message}" /></td>
			<td width="5%"><input type='button' value='-' onclick="removePremInfo('prem${s.index+1}');"/></td>
			</tr>
			</s:else>
			
	
	</tbody>
	<tr>
		<td><input type="button" value="+" onclick="addPremInfo()" /></td>
	</tr>
	<tr>
		<td colspan="6">同业竞争状况</td>
	</tr>
	<tr>
		<td colspan="6"><textarea id="competitionStatus"
			name="lcGrpContGroupVo.lcGrpRepInfoDetail.competitionStatus" cols="100%" rows="5" ><s:property value='lcGrpContGroupVo.lcGrpRepInfoDetail.competitionStatus' /> 必填项。</textarea></td>
	</tr>
	<tr>
		<td colspan="6">被保险人情况</td>
	</tr>
	<tr>
		<td colspan="6"><textarea id="insurStatus"
			name="lcGrpContGroupVo.lcGrpRepInfoDetail.insurStatus" cols="100%" rows="5"><s:property value='lcGrpContGroupVo.lcGrpRepInfoDetail.insurStatus' /></textarea></td>
	</tr>
	<tr>
		<td colspan="6">既往理赔史</td>
	</tr>
	<tr>
		<td colspan="6"><textarea id="clmHistory"
			name="lcGrpContGroupVo.lcGrpRepInfoDetail.clmHistory" cols="100%" rows="5"><s:property value='lcGrpContGroupVo.lcGrpRepInfoDetail.clmHistory' /></textarea></td>
	</tr>
	<tr>
		<td colspan="6">保单相关情况及服务要求</td>
	</tr>
	<tr>
		<td colspan="6"><textarea id="conStatusAndServ"
			name="lcGrpContGroupVo.lcGrpRepInfoDetail.conStatusAndServ" cols="100%" rows="5"><s:property value='lcGrpContGroupVo.lcGrpRepInfoDetail.conStatusAndServ' /></textarea></td>
	</tr>
			<tr>
				<td colspan="6">
					<input id="saveGrpBaseInfoId" type="button" class="cssButton" name ="SubmitButton" value="保  存" onClick="saveGrpBaseInfo();" >
					<!-- <input type="button" class="cssButton" name = "UpdateButton" value="修  改" onClick="saveGrpBaseInfo();" >  -->
				</td>
			</tr>
		</table>
	</div>
	<div style="width:100%">
		<table id="GrpPolInfor" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">   集体保单险种信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="5%">险种编码</td>
					<td width="42%">险种名称</td>
					<td width="15%">保费</td>
					<td width="15%">保额</td>
					<td width="15%">费用率</td>
				</tr>
			</thead>
			<tbody id="lcGrpProInfo">
				<s:if test="lcGrpContGroupVo.lcGrpPolList.size>0">
					<c:forEach items="${lcGrpContGroupVo.lcGrpPolList}" var="ls" varStatus="s" >
						<tr  class="content">
							<td><input  name='riskRadio' type='radio' value="${ls.grpPolNo }"></td>
						    <td>${s.index+1}</td>
							<td><input class="checkRiskCode" style="border:none" readonly="readonly"  name="lcGrpPolVoList[${s.index}].riskCode" type="text" value="${ls.riskCode}"/></td>
							<td><input style="border:none" readonly="readonly"  name="lcGrpPolVoList[${s.index}].riskName" type="text" value="${ls.riskName}"/></td>
							<td><input style="border:none" readonly="readonly"  name="lcGrpPolVoList[${s.index}].prem" type="text" value="${ls.prem}"/></td>
							<td><input style="border:none" readonly="readonly"  name="lcGrpPolVoList[${s.index}].amnt" type="text" value="${ls.amnt}"/></td>
							<td><input style="border:none" readonly="readonly"  name="lcGrpPolVoList[${s.index}].floatRate" type="text" value="${ls.floatRate}"/></td>
						</tr>
					</c:forEach>
				</s:if>
			</tbody>
		</table>		
	</div>
	<div style="width:100%">
		<table id="RiskInfor" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">   险种信息</td>
			</tr>
			<tr>
		<td width="17%" class="left">险种编码：</td>
		<td width="33%" class="right"><input id="riskCode"
			class="codecode" name="lcGrpPol.riskCode" type="text" style="width: 20%"
			value=""
			ondblclick="queryCode('riskCode','riskName','findRisk','');findSubRiskIsOr();" /><input
			id="riskName" name="RiskName" class="common" type="text"
			style="width: 68%" value="" /></td>
		<td id="mainRiskNameTD" style="display:none" width="17%" class="left">主险编码：</td>
		<td id="mainRiskValueTD" style="display:none" width="33%"
			class="right"><input id="mainRiskCode" class="codecode"
			name="lcGrpPol.mainRiskCode" class="common" type="text" style="width: 20%"
			value=""
			ondblclick="queryCode('mainRiskCode','mainRiskName','findMainRisk','subRiskCode:riskCode|grpContNo:grpContNo')" />
			<input id="mainRiskName" name="RiskName" class="common" type="text"
			style="width: 68%" value="" /></td>
		<td width="18%" class="left">费用率（0-1）：</td>
		<td width="32%" class="right"><input id="floatRate" name=""
			class="common" type="text" /></td>
	</tr>
		</table>
		<table id="RiskRateInfor" class="common" cellpadding="3" cellspacing="0" style="display:none">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     险种费率信息（0至1之间的小数）</td>
				</tr>
				<tr class="tableHead">
					<td width="10%">序号</td>
					<td width="12%">手续费比例</td>
					<td width="13%">个人绩效比例</td>
					<td width="13%">管理绩效比例</td>
					<td width="13%">个人费用比例</td>
					<td width="13%">团队费用比例</td>
					<td width="13%">机构费用比例</td>
					<td width="13%">前线固定费用分摊比例</td>					
				</tr>
			</thead>	
			<tbody>
				<tr class="content">
					<td>1</td>
					<td>0.4</td>
					<td>0.4</td>
					<td>1</td>
					<td>0.4</td>
					<td>0.4</td>
					<td>0.4</td>
					<td>0.4</td>
				</tr>
			</tbody>
		</table>
		<table id="ButtonInfor1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="90%" align="right"><input type="button" class="cssbutton" name = "AddRisk" value="添加险种" onclick="saveGrpRiskInfo();"></td>
				<td width="10%" align="left"><input  type="button" class="cssbutton" name = "DelRisk" value="删除险种" onclick="deleGrpRiskInfo()"></td>
			</tr>
		</table>
		<hr>
		<div id="divInfo1" style="display:''">
			<table id="ButtonInfor2" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td colspan="6">
						<input type="button" class="cssbutton" name = "AddPlan" value="保障计划定制" onclick="location.href='../report/reportInput/EnsurePlan.jsp'">
						<input type="button" class="cssbutton" name = "InsuredInfo" value="被保险人信息" onclick="location.href='../report/reportInput/InsuredListImport.jsp'">
						<input type="button" class="cssbutton" name = "BussinessNote" value="业务信息报告书" onclick="serviceInfoReport()">
						<input type="button" class="cssbutton" name = "JoinSet" value="联保设置" onclick="">
					</td>
				</tr>
			</table>
		</div>
		<div id="divInfo2" style="display:''">
			<table id="ButtonInfor2" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td colspan="6">
						<input type="button" class="cssbutton" name = "AddPlan" value="险种信息" onclick="location.href='${ctx}/prpall/group/report/reportInput/EnsurePlan.jsp'">
						<input type="button" class="cssbutton" name = "AddPlan" value="保障计划定制" onclick="location.href='../report/reportInput/EnsurePlan.jsp'">
						<input type="button" class="cssbutton" name = "InsuredInfo" value="被保险人信息" onclick="location.href='../report/reportInput/InsuredListImport.jsp'">
						<input type="button" class="cssbutton" name = "BussinessNote" value="业务信息报告书" onclick="location.href='../noImageInput/StatementInput.jsp'">
						<input type="button" class="cssbutton" name = "JoinSet" value="分期付款设置" onclick="location.href='../noImageInput/InstallmentSetting.jsp'">
					</td>
				</tr>
			</table>
		</div>
		<hr>
		<table id="ButtonInfor3" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="50%" align="right"><input type="button" class="cssbutton" name = "ReturnBack" value="返  回" onclick="javascript:history.go(-1);"></td>
				<td width="10%" align="left"><input id="writeFinish" type="button" class="cssbutton" name = "AddComplete" value="录入完毕" onclick="writeFinishByState()"></td>
				<input type="hidden" id="inputLocation" value="02">
				<!-- 其中value是finalCollection中结点的对应值 :02表示无影像录入位置-->
				<td width="10%" align="left"><input type="button" class="cssbutton" name = "QueryNotepad" value="记事本查看（共0条）" onclick="findNoteInfo()"></td>
				<td width="10%" align="left"><input type="button" class="cssbutton" name = "QueryIssue" value="团体问题件查询" onclick="findGrpIssueFile()"></td>
				<td width="10%" align="left"><input type="button" class="cssbutton" name = "AddIssue" value="团体问题件录入" onclick="issueInput();"></td>
				<td width="10%" align="left"><input type="button" class="cssbutton" name = "QueryImageScan" value="影像件查询" onclick=""></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
