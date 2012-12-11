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
    <title>集体保单被保人信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
	<script type="text/javascript">ctx = "${ctx}";</script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/QueryCodeAll.js"></script>
	<script type="text/javascript" src="${ctx}/prpall/group/report/js/ReportAdd.js"></script>

  </head>
  <div style="width: 100%">
<table id="UplodeInfor" class="common" cellpadding="3" cellspacing="0">
	<thead>
		<tr>
			<td colspan="7"><input type="button" class="cssbutton"
				name="UpLoad" value="上传附件"
				onclick="uploadFile()" /></td>
		</tr>
		<tr>
			<td colspan="7">上载信息查看</td>
		</tr>
		<tr class="tableHead">
			<td width="8%">序号</td>
			<td width="18%">呈报申请号</td>
			<td width="18%">上载批次号</td>
			<td width="18%">经办人</td>
			<td width="18%">上载日期</td>
			<td width="20%">下载</td>
		</tr>
	<thead>
	<tbody id="fileInfoBody">
		<s:if test="lcReportFileList.size>0">
	<c:forEach items="${lcReportFileList }" var="temp" varStatus="s">
		<tr class="content">
			<td width="3%">&nbsp;</td>
			<td width="10%">${s.index+1 }</td>
			<td width="17%">${temp.repno }</td>
			<td width="17%">${temp.uploadcode }</td>
			<td width="17%">${temp.fileoperator }</td>
			<td width="17%">${temp.uploadDate }</td>
			<td width="17%">${temp.fileName }</td>
		</tr>
		</c:forEach>
		</s:if>
	</tbody>
	<div>
	<table>
		<tr>
			<td width="45%" align='right'><input type="button"
				class="cssbutton" value="首  页"></td>
			<td width="5%"><input type="button" class="cssbutton"
				value="上一页"></td>
			<td width="5%"><input type="button" class="cssbutton"
				value="下一页"></td>
			<td width="45%"><input type="button" class="cssbutton"
				value="尾  页"></td>
		</tr>
	</table>
	</div>
	<tr>
		<td colspan="6"><input type="button" class="cssbutton"
			name="ReportSubmit" value="呈  报" onclick="Submit()" /> <input
			type="button" class="cssbutton" name="ReturnBack" value="返  回"
			onclick="javascript:history.go(-1);" /></td>
	</tr>
</table>
</div>
</html>