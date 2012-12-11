<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>投保单位资料信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>

  </head>
	<div style="width:100%">
		<table id="CompanyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="4" ><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">投保单位资料（客户号<input id="customerNo" name="ldGrp.customerNo" class="common" type="text" style="width:20%"><input type="button" class="cssbutton" value="查  询" onclick="selectInfoByCustomerNo()">）（首次投保单位无需填写客户号）</td>
			</tr>
			<tr>
				<td class="left">VIP客户：</td>
				<td class="right"><input class="codecode" id="vipValue" name="ldGrp.vipValue" class="common" type="text" value="1" style="width:20%" ondblclick="queryCode('vipValue','vipFlag','PDLDcode1','codeType:VipFlag')" /><input id="vipFlag" name="vipFlag" class="common" type="text"   style="width:68%" value="是"></td>
				<td class="left"></td>
				<td class="right"></td>
				<td class="left"></td>
				<td class="right"></td>
			</tr>
			<tr>
				<td class="left">投保单位名称：</td>
				<td class="right" colspan="3"><input id="grpName"  name="ldGrp.grpName" class="common" type="text" value="中科软"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">行业类别：</td>
				<td class="right"><input class="codecode" id="businessType" name="ldGrp.businessType" class="common" type="text" value="3" style="width:20%" ondblclick="queryCode('businessType','businessName','PDLDcode1','codeType:OccupationType')" ><input id="businessName" name="businessName" class="common" type="text"   style="width:68%" value="电子产业"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>

			</tr>
			<tr>
				<td class="left">组织机构代码：</td>
				<td class="right"><input id="organizationNo"  name="ldGrp.organizationNo" class="common" type="text" value="S10001"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">资产总额（万元）：</td>
				<td class="right"><input  id="asset" name="ldGrp.asset" class="common" type="text" value="100"></td>
				<td class="left">税务登记证号：</td>
				<td class="right"><input id="taxRegistNo"  name="ldGrp.taxRegistNo" class="common" type="text" value="110"></td>
			</tr>
			<tr>
				<td class="left">年总收入（万元）：</td>
				<td class="right"><input  id="yearGrossIncome" name="ldGrp.yearGrossIncome" class="common" type="text" value="20"></td>
				<td class="left">单位性质：</td>
				<td class="right"><input class="codecode" id="grpNature" name="ldGrp.grpNature" class="common" type="text" value="1"style="width:20%" ondblclick="queryCode('grpNature','grpNatureName','PDLDcode1','codeType:GrpNature')"><input id="grpNatureName" class="common" type="text"   style="width:68%" value="国企"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">成立日期：</td>
				<td class="right">
					<input id="foundDate"  name="ldGrp.foundDate" class="common" type="text"  style="width:73%" value="2012-07-24">
					<img style='cursor:hand' align="middle" src="${ctx}/images/bgcalendar.gif" onClick="WdatePicker({el:'foundDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"></td>
			</tr>
			<tr>
				<td class="left">经营区域：</td>
				<td class="right"><input class="codecode" id="operateArea"  name="ldGrp.operateArea" class="common" type="text" value="1"style="width:20%" ondblclick="queryCode('operateArea','operateAreaName','PDLDcode1','codeType:OperateArea')"><input id="operateAreaName" name="operateAreaName" class="common" type="text"   style="width:68%" value="全国"></td>
				<td class="left">主营业务：</td>
				<td class="right"><input id="mainBussiness"  name="ldGrp.mainBussiness" class="common" type="text" value="软件"></td>
				<td class="left">单位总人数：</td>
				<td class="right"><input class="codecode" id="grpPeoples"  name="ldGrp.grpPeoples" class="common" type="text" value="1" style="width:20%" ondblclick="queryCode('grpPeoples','grpPeoplesRange','PDLDcode1','codeType:GrpPeoples')" ><input id="grpPeoplesRange" name="grpPeoplesRange" class="common" type="text"   style="width:68%" value="50-300"></td>
			</tr>
			<tr>
				<td class="left">是否已参加社会统筹：</td>
				<td class="right"><input class="codecode" id="societyStat"  name="lcGrpAppReport.societyStat" class="common" type="text" value="1" style="width:20%" ondblclick="queryCode('societyStat','societyStatFlag','PDLDcode1','codeType:IsFlag')"><input id="societyStatFlag" name="societyStatFlag" class="common" type="text"   style="width:68%" value="是">
				<img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">社保登记证号：</td>
				<td class="right"><input id="societyRegistNo"  name="lcGrpAppReport.societyRegistNo" class="common" type="text" value="10002"></td>
				<td class="left">地址号码：</td>
				<td class="right"><input id="addressNo" name="lcGrpAppReport.addressNo" value="1"/></td>				
			</tr>
			<tr>
				<td class="left">联系地址：</td>
				<td class="right" colspan="3"><input id="postalAddress"  name="lcGrpAppReport.postalAddress" class="common" type="text" value="北京"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">联系邮编：</td>
				<td class="right"><input id="zipCode"  name="lcGrpAppReport.zipCode" class="common" type="text" value="100010"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td class="left">联系电话：</td>
				<td class="right"><input id="phone"  name="lcGrpAppReport.phone" class="common" type="text" value="1234667890"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">--联系部门：</td>
				<td class="right"><input id="department"  name="lcGrpAppReport.department" class="common" type="text" value="产品 事业部"></td>
				<td class="left"></td>
				<td class="right"></td>
			</tr>
			<tr>
				<td class="left">--联系人：</td>
				<td class="right"><input name="lcGrpAppReport.people" class="common" type="text" id="name1" value="yuwenlong"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">--联系人性别：</td>
				<td class="right"><input class="codecode" id="sex1" name="lcGrpAppReport.peopleSex" class="common" type="text" value="1" style="width:20%" ondblclick="queryCode('sex1','SexType','PDLDcode1','codeType:Sex')"><input id="SexType" name="SexType" class="common" type="text"   style="width:68%" value=""><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">--联系人电话：</td>
				<td class="right"><input name="lcGrpAppReport.peopleTel" class="common" type="text" id="telphone1" value="1234567899"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td class="left">--手机：</td>
				<td class="right"><input name="lcGrpAppReport.peoplePhone" class="common" type="text" id="phone1" value="12356989"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">--E-MAIL：</td>
				<td class="right"><input name="lcGrpAppReport.email" class="common" type="text" id="email" value="445545456"></td>
				<td class="left"></td>
				<td class="right"></td>
			</tr>
			<tr>
				<td class="left">单位法人：</td>
				<td class="right"><input id="corporation"  name="lcGrpContReport.corporation" class="common" type="text" value="long"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">--法人证件类型：</td>
				<td class="right"><input id="corporationIDType" name="lcGrpContReport.corporationIDType" class="codecode" type="text" value="1" style="width:20%" ondblclick="queryCode('corporationIDType','corporationIDTypeName','PDLDcode1','codeType:IDType')"><input id="corporationIDTypeName" name="corporationIDTypeName" class="common" type="text"   style="width:68%" value="身份证"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">--法人证件号：</td>
				<td class="right"><input id="corporationIDNo" name="lcGrpContReport.corporationIDNo" class="common" type="text" value="5215456687"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td class="left">--法人有效日期：</td>
				<td class="right"><input id="corporationsDate" name="lcGrpContReport.corporationsDate" class="common" type="text"  style="width:73%"
    	  			value='2012-07-24'>
					<img style='cursor:hand' align="middle" src="${ctx}/images/bgcalendar.gif" onClick="WdatePicker({el:'corporationsDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left"></td>
				<td class="right"></td>
				<td class="left"></td>
				<td class="right"></td>
			</tr>
			<tr>
				<td class="left">--投保单位人数：</td>
				<td class="right"><input id="grpPeople" name="lcGrpContReport.grpPeoples" class="common" type="text" value="20"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">--主被保险人数：</td>
				<td class="right"><input id="mainInsurePersonNumber" name="lcGrpContReport.mainInsurePersonNumber" class="common" type="text" value="20"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">--连带被保险人数：</td>
				<td class="right"><input id="relatedInsurePersonNumber" name="lcGrpContReport.relatedInsurePersonNumber" class="common" type="text" value="1"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
			</tr>
			<tr>
				<td class="left">--投保率：</td>
				<td class="right"><input id="rate" name="lcGrpContReport.rate" class="common" type="text" value="20"></td>
				<td class="left"></td>
				<td class="right"></td>
				<td class="left"></td>
				<td class="right"></td>
			</tr>
		</table>
	</div>
  </body>
</html>
