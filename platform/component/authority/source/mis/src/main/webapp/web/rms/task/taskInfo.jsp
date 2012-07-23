<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglibs.jsp" %>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/file.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/dhtmlxtree.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/standard.css"/>
<script type="text/javascript" language="script" src = '${ctx }/js/jquery-1.6.4.js'></script>
<script type="text/javascript" language="script" src = '${ctx }/js/role.js'></script>
<form id="taskfm" method="post"> 
<table style="background-color:#f5f5f5; border :1px solid Silver;width: 650px;;"  border="0" cellspacing="0" cellpadding="0"  >
	<tr>
		<td valign="top" align="center" colspan="3" style="border-top-color: #b7c4d4;padding-left: 10px;font-weight: bold;">功能信息</td>
	</tr>
	<tr style=" height: 30px;">
		<td style="width: 270px;" ><label style="float: left; width: 80px;">功能id  :</label> <div  style="width:150px;height:18px;float:left; border :1px solid Silver;"><s:property value="task.taskID"></s:property></div> </td>
		<td style="width: 270px;" ><label style="float: left;width: 80px;">功能名称 :</label><div style="width:150px; height:18px;float:left; border :1px solid Silver;"><s:property value="task.name"></s:property></div></td>
		<td align="left"></td>
	</tr>
	
	<tr style="height: 30px;">
		<td colspan="3"><label style="float: left;width: 80px;">菜单名称:</label><div style="width:150px; height:18px;float:left;  border :1px solid Silver;"><s:property value="task.menuName"></s:property></div></td>
	</tr >
	
	<tr style="height: 30px;">
		<td colspan="3"><label style="float: left; width: 80px;">菜单链接:</label><div style="width:300px;height:18px; float:left;border :1px solid Silver;"><s:property value="task.menuURL"></s:property></div></td>
	</tr>
	
	<tr style="height: 30px;">
		<td colspan="3"><label style="float: left; width: 80px;">描述:</label><div style="width:300px;height:18px; float:left;border :1px solid Silver;"><s:property value="task.des"></s:property></div>
		<label style="width: 80px;  ">状态:</label>
		<select  disabled="disabled" style=" width: 60px; height:18px;" id="select" name="task.isValidate">
		<s:if test='"1".equals(task.isValidate)'>
			<option value="1" selected="selected">使用中</option>
			<option value="0">不使用</option>
		</s:if>
		<s:if test='!"1".equals(task.isValidate)'>
			<option value="1" >使用</option>
			<option value="0" selected="selected">不使用</option>
		</s:if>
		</select>  
		</td>
	</tr>
	<tr style="height: 30px;">
		<td style="width: 270px;" ><label style="float: left; width: 80px;">父功能id  :</label> <div  style="width:150px;height:18px;float:left; border :1px solid Silver;"><s:property value="task.parent.taskID"></s:property></div> </td>
		<td style="width: 270px;" ><label style="float: left;width: 80px;">父功能名称 :</label><div style="width:150px;height:18px;float:left; border :1px solid Silver;"><s:property value="task.parent.name"></s:property></div></td>
		<td></td>
	</tr>
	<tr>
		<td colspan="3" align="left"><input style="margin-left: 80px;" type="button" class="btn1" onclick="prepUpdata('<s:property value="task.taskID"></s:property>')" value="修改"/>
						
		</td>
	</tr>
</table>
</form>
