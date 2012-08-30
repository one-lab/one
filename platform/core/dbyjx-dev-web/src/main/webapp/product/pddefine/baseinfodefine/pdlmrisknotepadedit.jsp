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
    <title>记事本</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script>
	//添加记事本信息
	function saveNotepad(){
		var url =contextRootPath + "/product/savaNotepad";
		var params ={
			"lcNotepad.content" : $("#notepadContent").val(),
			"lcNotepad.id.bussinessNo" : $("#bussinessNo").val()
		};
		//将添加的记事本信息显示到页面
		function CallBackNotepad(obj){
			var notepadConString = $("#notepadCont").html();
			var s = "<tr><td>1</td><td>"+obj.lcNotepad[0].operator+"</td><td>"+obj.lcNotepad[0].content+"</td></tr>";
			$("#notepadCont").html(notepadConString+s);
		}
		jQuery.post(url,params,CallBackNotepad, "json");
	}
	</script>
  </head>
  <body>
    <form name="fm" method="post">
	<div style = "width:70%">
		<input type="hidden" id="bussinessNo" name="lcNotepad.id.bussinessNo" value='${pdLMRisk.riskCode}' >
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="formtitle" ><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">记事本信息录入</td>
			</tr>
			<tr>
				<td align="left">记事本内容</td>
			</tr>
			<tr>
				<td class="formtitle" colspan="8"><textarea id="notepadContent" name="" cols="" rows="4" ></textarea></td>
			</tr>
			<tr>
				<td align="left" >
					<input type = "button" class="cssbutton" name="Button" value="添  加" onclick="saveNotepad();">
				</td>
			</tr>
		</table>
		</div>
		</form>
		<div style = "width:98%">
		<table class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="3"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已录入的记事本信息</td>
				</tr>
				<tr class="tableHead">
					<td width="10%">序号</td>
					<td width="30%">填写人</td>
					<td width="60%">记事本内容</td>
				</tr>
			</thead>
			<tbody id="notepadCont">
			</tbody>
		</table>
	</div>
	
  </body>
</html>
