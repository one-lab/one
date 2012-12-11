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
    
    <title>人工核保处理</title>
    
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
    <script type="text/javascript" src="${ctx}/prpall/group/artificalUW/js/ArtificalUWDeal.js"></script>
  </head>
  <body>
  	<div style = "width:100%">
  		<table id=companyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr> 
				<td><jsp:include page="./UWFileQuery.jsp" /> </td>
			</tr>
		</table>
  	</div>
    <form id="fmSaveUWResult" name="fm" method="post">
		<div style = "width:100%">
			<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">整单核保结论</td>
				</tr>
				<tr>
					<td class="left">核保结论</td>
					<td  class="right">
						<input id="artificalResultCode" name="lcGrpCont.uwFlag" class="codecode" type="text" onchange="clickable()" ondblclick="queryCode('artificalResultCode','artificalResultContext','PDLDcode1','codeType:UWFlag')" style="width:20%"><input id="artificalResultContext" name="artificalResultContext" class="common" type="text" onchange="clickable()" style="width:68%">
					</td>
					<td class="common"></td>
					<td class="common"></td>
					<td class="common"></td>
					<td class="common"></td>
				</tr>
				<tr>
					<td colspan="6" >核保意见（500字以内，回车符占一个汉字）<input id="grpContNo" name="lcGrpCont.grpContNo" class="common" type="hidden" value="${artificalUWDealVo.grpContNo }"></td>
				</tr>
				<tr>
					<td colspan="4"><textarea id="artificalIdea" name="lcGrpCont.remark" cols="100%" rows="5"></textarea></td>
				</tr>
			</table>
			<table id="ApplyButtonInfo" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td colspan="6">
						<input id="artificalUWSubmit" type = "button" class="cssbutton" name="artificalUWSubmit" value="团体投保单整单确认" onclick="saveArtificalUWResultAndIdea()">
						<input type = "button" class="cssbutton" name="ApplyButton" value="记事本查看（共0条）" onclick="">
						<input type = "button" class="cssbutton" name="ApplyButton" value="返  回" onclick="javascript:history.go(-1);">
					</td>
				</tr>
			</table>
		</div>
	</form>
  </body>
</html>
