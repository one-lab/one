<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglibs.jsp" %>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/file.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/dhtmlxtree.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/standard.css"/>
<script type="text/javascript" language="script" src = '${ctx }/js/jquery-1.6.4.js'></script>
<script type="text/javascript" language="script" src = '${ctx }/js/role.js'></script>
<table style="width: 490px;" 
	class="table3">
	<tr>
		<td class="td1" style="width: 25px;">&nbsp;</td>
		<td class="td1" style="">机构代码</td>
		<td class="td1" style="">机构名称</td>
		<td class="td1" style="">指派操作人</td>
		<td class="td1" style="">指派操作时间</td>
	</tr>
	<c:forEach var="roleDesignateInfo" items="${roleDesignateInfos}"
		varStatus="status">
		<tr>
			<td style="width:25px;" class="td5"><input type="checkbox" checked="checked" name="DesNateComCode" value="${roleDesignateInfo.company.comCode}"/></td>
			<td style="width:62px;" class="td5">${roleDesignateInfo.company.comCode}</td>
			<td style="width:150px;" class="td5">${roleDesignateInfo.company.comEName}</td>
			<td style="width:76px;" class="td5">${roleDesignateInfo.createUser} </td>
			<td style=""  class="td5">${roleDesignateInfo.createTime}</td>
		</tr>
	</c:forEach>
	</table>


