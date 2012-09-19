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
    
    <title>人工核保申请</title>
    
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
	<script type="text/javascript">
	     ctx = "${ctx}";
    </script>
    <script src="${ctx}/prpall/group/artificalUW/js/ArtificalUWApply.js"></script>
	
	<script type="text/javascript">
		$(function(){
			var temp = '${msg}';
			if(temp == "success"){
				alert("核保订正成功!");
			}
			initPersonWorkPool();//初始化个人工作池
			
		});
	</script>
  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="scanQueryInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     请输入查询条件</td>
			</tr>
			<tr> 
				<td class="left">投保单号：</td>
				<td class="right"><input id="grpContNo" name="grpContNo" class="common" type="text"></td>
				<td class="left">投保单位全称：</td>
				<td class="right"><input id="grpName" name="grpName" class="common" type="text"></td>
				<td class="left">管理机构：</td>
				<td class="right">
					<input type="hidden" id="upperComCode" value='2110000000' />
					<input id="manageCom" name="manageCom" class="codecode" type="text" value='<s:property value="#session.prpDcompany.comCode"/>' onchange="clickable()" style="width:20%" ondblclick="queryCode('manageCom','comName','PrpDcompany','comCode:manageCom|upperComCode:upperComCode')"><input id="comName" name="comName" class="common" type="text" onchange="clickable()" style="width:68%" value='<s:property value="#session.prpDcompany.comCName"/>'><img src="${ctx}/images/bgMarkMustInput.jpg" >
				</td>
				
			</tr>
		</table>
		<table id="QueryScanInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="QueryButton" value="查  询" onclick="findProposalGrpContInfo()">
				</td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     共享工作池</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="12%">投保单号</td>
					<td width="20%">投保单位全称</td>
					<td width="12%">核保师</td>
					<td width="12%">管理机构</td>
					<td width="12%">复核日期</td>
					<td width="12%">初审日期</td>
					<td width="12%">状态</td>
				</tr>
			</thead>
			<tbody id="content">
			
			</tbody>
			</table>
			<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick="location.href='ReportAuditDeal.jsp'"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
				</tr>
			</table>
			
		<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="ApplyButton" value="核保件查看" onclick="UWFileCheck()"/>
					<input type = "button" class="cssbutton" name="ApplyButton" value="申  请" onclick="applyProposal()"/>
				</td>
			</tr>
		</table>
			<table id="scanApplycInfo" class="common" cellpadding="3" cellspacing="0">
				<thead>
					<tr>
						<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     待核保投保单</td>
					</tr>
					
					<tr class="tableHead">
						<td width="3%">&nbsp;</td>
						<td width="5%">序号</td>
						<td width="18%">投保单号</td>
						<td width="20%">投保单位全称</td>
						<td width="18%">管理机构</td>
						<td width="18%">复核日期</td>
						<td width="18%">初审日期</td>
					</tr>
				</thead>
				<tbody id="privateContent">
				
				</tbody>
			</table>
		
		<table id="PageInfo2" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick="location.href='ReportAuditDeal.jsp'"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
			</tr>
		</table>
		<table id="ArtificalUWStart" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type = "button" class="cssbutton" name="Start" value="开始核保" onclick="artificalUWStart()">
				</td>
			</tr>
		</table>
		<table id="scanApplycInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">     预打保单催缴信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="12%">投保单号</td>
					<td width="12%">集体合同号</td>
					<td width="12%">投保单位全称</td>
					<td width="20%">管理机构</td>
					<td width="12%">业务员编码</td>
					<td width="12%">应缴保费</td>
					<td width="12%">核保日期</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="CheckRadio" type="radio" value="" /></td>
					<td>1</td>
					<td>G86012012005</td>
					<td>P12153623236256</td>
					<td>北京乐逍遥保健品有限公司</td>
					<td>860121</td>
					<td>A35655</td>
					<td>58</td>
					<td>2012-05-18</td>
				</tr>
			</tbody>
			<table id="PageInfo2" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" onclick="location.href='ReportAuditDeal.jsp'"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
				</tr>
			</table>
			
		</table>	
	</div>
	</form>
  </body>
</html>
