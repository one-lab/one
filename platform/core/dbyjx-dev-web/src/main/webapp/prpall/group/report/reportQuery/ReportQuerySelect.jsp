<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�ʱ���ѯ</title>
    
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
	<script src="${ctx}/prpall/group/report/reportQuery/ReportQuerySelect.js"></script>
	
   <script type="text/javascript">
   function ReportQueryDetail(){
	  
	   	for(i=0;i<document.fm.radioRepNo.length;i++){
		 if(document.fm.radioRepNo[i].checked)
       		window.location="${ctx}/prpall/group/report/reportQuery/ReportQueryDetail.jsp?repNo="+document.fm.radioRepNo[i].value;
        }
   }
   </script>

  </head>
  <body>
    <form name="fm" method="post" >
	<div style = "width:100%">
		<table id="ReportComAppInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�ʱ������ѯ</td>
			</tr>
			<tr> 
				<td class="left">���������</td>
				<td class="right">
				<input type="hidden" id ="upperComCode" value='2110200000'/> 
				<input id="comCode" name="comCode" class="codecode" type="text" onchange="clickable()" value='<s:property value="#session.prpDcompany.comCode"/>' style="width:20%" ondblclick="queryCode('comCode','comName','PrpDcompany','comCode:comCode|upperComCode:upperComCode')" ><input id="comName" name="comName" class="common" type="text" value='<s:property value="#session.prpDcompany.comCName"/>' onchange="clickable()" style="width:68%"><img src="${ctx}/images/bgMarkMustInput.jpg" ></td>
				<td class="left">�������ڣ�</td>
				<td class="right">
					<input name="ApplyDate" id="applyDate" class="common" type="text"  style="width: 73%" value='2012-7-25'>
					<img style='cursor: hand' align="middle" src="${ctx}/images/bgcalendar.gif"  onClick="WdatePicker({el:'ApplyDate',startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#{%y-10}-%M-%d',maxDate:'#{%y+10}-%M-%d',alwaysUseStartDate:true})">
				</td>
			</tr>
			<tr>
				<td class="left">�ʱ�����ţ�</td>
				<td class="right"><input id="repNo" name="RepApplyNo" class="common" value="S211020120000" type="text" ></td>
				<td class="left">��λ���ƣ�</td>
				<td class="right"><input id="grpName" name="GrpName" class="common" value="�п���" type="text" ></td>
			</tr>
		</table>
		<table id="QueryApplyInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6"><input type = "button" class="cssbutton" name="QueryButton" value="��  ѯ" onClick="selectReportResult()" ></td>
			</tr>
		</table>
		<table id="PublicInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">�ʱ���������</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">���</td>
					<td width="11%">�ʱ������</td>
					<td width="11%">�������</td>
					<td width="15%">��λ����</td>
					<td width="11%">������</td>
					<td width="11%">�����</td>
					<td width="11%">�ʱ�����</td>
					<td width="11%">�ʱ���״̬</td>
					<td width="11%">��������</td>
				</tr>
			</thead>
			<tbody id="content">
		    </tbody>
		</table>
		<table id="PageInfo1" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="45%" align='right'><input type = "button" class="cssbutton" value="��  ҳ" onclick="location.href='ReportAuditDeal.jsp'"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="5%"><input type = "button" class="cssbutton" value="��һҳ"></td>
				<td width="45%"><input type = "button" class="cssbutton" value="β  ҳ"></td>
			</tr>
		</table>
		
		<table  id="ReportViewInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td width="10%"><input type = "button"  name="RepQueryButton" class="cssbutton" value="�ʱ����鿴" onclick="ReportQueryDetail()"></td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
