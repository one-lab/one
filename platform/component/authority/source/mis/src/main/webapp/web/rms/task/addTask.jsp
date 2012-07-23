<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglibs.jsp" %>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/file.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/dhtmlxtree.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/standard.css"/>
<script type="text/javascript" language="script" src = '${ctx }/js/jquery-1.6.4.js'></script>
<script type="text/javascript" language="script" src = '${ctx }/js/role.js'></script>
<form id="addtaskfm" method="post"> 
<table style="background-color:#f5f5f5; border :1px solid Silver; width: 650px;"  border="0" cellspacing="0" cellpadding="0"  >
	<tr>
		<td valign="top" align="center" colspan="3" style="border-top-color: #b7c4d4;padding-left: 10px;font-weight: bold;">功能信息</td>
	</tr>
	
	<tr style=" height: 30px;">
		<td style="width: 270px;" ><label style="float: left; width: 80px;">功能id  :</label><input id=""   style="width: 150px;" name="task.taskID" value=""/> </td>
		<td style="width: 270px;" ><label style="float: left;width: 80px;">功能名称 :</label><input id="" style="width: 150px;" name="task.name" value=""/></td>
		<td></td>
	</tr>
	
	<tr style="height: 30px;">
		<td colspan="3"><label style="float: left;width: 80px;">菜单名称:</label><input style="width: 150px;" name="task.menuName" value=""/> </td>
	</tr >
	
	<tr style="height: 30px;">
		<td colspan="2"><label style="float: left; width: 80px;">菜单链接:</label><input style="width: 300px;" name="task.menuURL" value=""/> </td>
	</tr>
	
	<tr style="height: 30px;">
		<td colspan="2"><label style="float: left; width: 80px;">描述:</label><input style="width: 300px;" name="task.des" value="" /></td>
	</tr>
	<tr style="height: 30px;">
		<td style="" ><label style="float: left; width: 80px;">父功能id  :</label>
		<input id="parentId" disabled="disabled" style="width: 150px;" value=""/> 
		<input id="prtId" type="hidden" name="parentId" value="" >
		</td>
		<td style="" ><label style="float: left;width: 80px;">父功能名称 :</label>
		<input id="parentName"  disabled="disabled" style="width: 150px;"  value=""/>
		<input id="prtName" type="hidden" name="task.parent.name" value="" >
		</td>
		<td><a type="button" class="btn1" onclick="selectParent();" >点击选择父功能</a></td>
	</tr>
	<tr>
		<td colspan="2" align="left">
			<input style="margin-left: 80px;" type="button" class="btn1" onclick="saveTask();" value="确定"/>
		</td>
	</tr>
</table>
</form>
