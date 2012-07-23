<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglibs.jsp" %>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/file.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/dhtmlxtree.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/standard.css"/>
<script type="text/javascript" language="script" src = '${ctx }/js/jquery-1.6.4.js'></script>
<script type="text/javascript" language="script" src = '${ctx }/js/role.js'></script>
<form id="updataTaskfm" method="post"> 
<table style="background-color:#f5f5f5; border :1px solid Silver; width: 650px;"  border="0" cellspacing="0" cellpadding="0"  >
	<tr style=" height: 30px;">
		<td style="width: 270px;" ><label style="float: left; width: 80px;">功能id  :</label>
		 <input style="width: 150px;"  disabled="disabled" value="<s:property value="task.taskID"></s:property> "/> 
		 <input id="taskID" style="width: 150px;" name="task.taskID" type="hidden" value="<s:property value="task.taskID"></s:property>"/> 
		 </td>
		<td style="width: 270px;" ><label style="float: left;width: 80px;">功能名称 :</label><input style="width: 150px;" name="task.name"  value="<s:property value="task.name"></s:property>"/></td>
		<td></td>
	</tr>
	
	<tr style="height: 30px;">
		<td colspan="3"><label style="float: left;width: 80px;">菜单名称:</label><input style="width: 300px;" name="task.menuName" value="<s:property value="task.menuName"></s:property>"/> </td>
	</tr >
	
	<tr style="height: 30px;">
		<td colspan="3"><label style="float: left; width: 80px;">菜单链接:</label><input style="width: 300px;" name="task.menuURL" value="<s:property value="task.menuURL"></s:property>"/> </td>
	</tr>
	
	<tr style="height: 30px;">
		<td colspan="3"><label style="float: left; width: 80px;">描述:</label><input style="width: 300px;"  name="task.des" value="<s:property value="task.des"></s:property>"/>
		<label style="width: 80px;  ">状态:</label>
		<select  style=" width: 60px; height:18px;" id="select" name="task.isValidate">
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
		<td style="" ><label style="float: left; width: 80px;">父功能id  :</label>
			<input disabled="disabled" style="width: 150px;" value="<s:property value="task.parent.taskID"></s:property>"/>  
			<input id="parentId" name="parentId" type="hidden" style="width: 150px;" value="<s:property value="task.parent.taskID"></s:property>"/>  
		</td>
		<td style="" ><label style="float: left;width: 80px;">父功能名称 :</label><input id="parentName"   disabled="disabled" style="width: 150px;" value="<s:property value="task.parent.name"></s:property>"/></td>
	</tr>
	<tr>
		<td colspan="2" align="left">
		<input style="margin-left: 80px;" type="button" class="btn1" onclick="updataTask();" value="确定"/>
		</td>
	</tr>
</table>
</form>
