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
    
    <title>检验规则库</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:70%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			
			<tr>
				<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">检验规则详细信息</td>
			</tr>
			<tr>
				<td class="left">规则编号</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>
				<td class="left">规则名称</td>
				<td class="right"><input name="GrpName" class="common" type="text"></td>				
			</tr>
			<tr>
				<td class="left">类别</td>
				<td class="right"><input name="comCode" class="codecode" type="text" onchange="clickable()" ></td>
			</tr>
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="QueryButton" value="查 询" onclick="location.href='baseinfofieldview.jsp'">
				</td>
			</tr>
		</table>
		</div>
		<div style = "width:100%">
		<table id="scanApplycInfo" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="4"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">校验规则查询结果</td>
				</tr>		
				<tr class="tableHead">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="18%">规则编号</td>
					<td width="18%">规则名称</td>
					<td width="18%">类别</td>
					<td width="18%">规则算法</td>
					<td width="18%">备注</td>
				</tr>
			</thead>
			<tbody>
				<tr class="content">
					<td><input name="" type="radio" value="" /></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
			<table id="PageInfo2" class="common" cellpadding="3" cellspacing="0">
				<tr>
					<td width="45%" align='right'><input type = "button" class="cssbutton" value="首  页" ></td>
					<td width="5%"><input type = "button" class="cssbutton" value="上一页"></td>
					<td width="5%"><input type = "button" class="cssbutton" value="下一页"></td>
					<td width="45%"><input type = "button" class="cssbutton" value="尾  页"></td>
				</tr>
				<tr>
				<td align="right" colspan="4">
					<input type = "button" class="cssbutton" name="SaveButton" value="新 增" onclick="location.href='pdCheckRuleLibAdd.jsp'">
					<input type = "button" class="cssbutton" name="EditButton" value="修 改" onclick="">
					<input type = "button" class="cssbutton" name="DeleteButton" value="删 除" onclick="">
				</td>
			</tr>
			</table>
		</table>	
	</div>
	</form>
  </body>
</html>
