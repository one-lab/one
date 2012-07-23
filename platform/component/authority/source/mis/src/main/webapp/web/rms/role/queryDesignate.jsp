<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglibs.jsp" %>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/file.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/dhtmlxtree.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/standard.css"/>
<script type="text/javascript" language="script" src = '${ctx }/js/jquery-1.6.4.js'></script>
<script type="text/javascript" language="script" src = '${ctx }/js/role.js'></script>
<form id="roldesignfm" method="post">
<table style="width: 500px;" 
	>
	<s:iterator value="roleDesignates" >
		<tr>
			<s:if test="flag">
					<td width="8%" class="td5">
						<input type="checkbox"  checked="checked"  name="roleIDs" value="<s:property value="role.roleID"/>"/>
					</td>
			</s:if>	
			<s:else>
					<td width="8%" class="td5">
						<input type="checkbox" name="roleIDs" value="<s:property value="role.roleID"/>"/>
					</td>
			</s:else>	
			<td width="35%" class="td5"><a href="#"
				onclick="queryRoleInfo('<s:property value="role.roleID"/>')"><s:property value="role.name"/></a></td>
			<td width="20%" class="td5"><s:property value="createTime"/></td>
			<td width="10%" class="td5"><s:property value="operateUser"/></td>
		</tr>
	</s:iterator>
	</table>
	<div><input type="hidden" id="comCode" name="comCode"value=""/></div>
</form>
<script> 

$('input[type="checkbox"][name="roleIDs"][value="${roleDesignate.role.roleID}"]').attr('checked',true);

</script>


