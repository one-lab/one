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
    
    <title>记事本信息录入及查看</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="common/js/SimpleCalendar.js"></script>
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="${ctx}/prpall/group/proposalPre/ProposalPreApply.js"></script>	
   
  </head>
  
  <body>
    <form id="fm" name="fm" method="post" ">
	
		<table id="NoteMessageInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
		
				<td class="left">投保单号 ：</td>
				<td class="right"><input type="text" id="grpContNo" name="lcNotepad.id.bussinessNo" value="${bussinessNo}" class="common"  readonly="readonly"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
				<td class="common"></td>
			</tr>
		</table>
		<table id="NotepadInfo" class="common" cellpadding="3" cellspacing="0">
		   <thead>
				<tr>
					<td class="formtitle" colspan="6"><img src="images/bgformtitle.gif" style="cursor:hand;">     记事本信息</td>
				</tr>
				<tr class="tableHead">
					<td width="3%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="44%">记事本内容</td>
					<td width="12%">录入位置</td>
					<td width="12%">操作员</td>
					<td width="12%">录入日期</td>
					<td width="12%">录入时间</td>
				</tr>
			</thead>
		
			<tbody id = "noteInfo">
			  <c:if test="${noteInfoResult !=null }">
			 	<c:forEach items="${noteInfoResult}" var="note" varStatus="s">
				  <tr class="content">
				    <td><input name="radioRepNo" type="radio" value="${note.id.bussinessNo}"/></td>
				    <td>${note.id.serialNo }</td>
				    <td>${note.content}</td>
				    <td>${note.inputLocation}</td>
					<td>${note.operator}</td>
					<td>${note.modifyDate}</td>
			    	<td>${note.modifyTime}</td>
				  </tr>
			     </c:forEach>
		      </c:if> 
		     
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
		<table id="NotepadContent" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6" >记事本内容（500字以内，回车符占一个字节）</td>
			</tr>
			<tr>
				<td colspan="6"><textarea id="content" name="lcNotepad.content" cols="100%" rows="5"></textarea></td>
			</tr>
		</table>
		<table  id="ButtonInfo" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td colspan="6">
					<input type="button"  name="NewAdd" class="cssbutton" value="新  增" onclick="savaNoteInfo()">
					<input type="button"  name="ReturnBack" class="cssbutton" value="返  回" onclick="window.close();">
				</td>
			</tr>
		</table>
	    <!-- 当前录入位置标志 -->
		<input type="hidden" id="flag" name="lcNotepad.inputLocation" value="${inputLocation }">
	</form>
	
	
  </body>
</html>
