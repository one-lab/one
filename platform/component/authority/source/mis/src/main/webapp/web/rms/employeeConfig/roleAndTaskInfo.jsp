<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglibs.jsp" %>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/file.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/dhtmlxtree.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/standard.css"/>
<script type="text/javascript" language="script" src = '${ctx }/js/jquery-1.6.4.js'></script>
			
           		<table style="float: left; width:150px; margin-top:10px;border:0px solid green;"   >
           			<tr>
           				<td style="height: 100px;margin-top: 0px;">
           					<div style="margin-top: 0px;" >
           	  		   		<c:forEach var="role" items="${roles}" varStatus="status">
           	  		   		<div style="float: top; width:150px; margin-top: 1px;" align="left">
           	  		   			<input name="roleID" type="checkbox"  disabled="disabled" checked="checked"  onclick="roleIdChange();" value="${role.roleID}"/> 
								<label>${role.name}</label>
           	 		   			<input id="${status.index + 1}"  name="roleID"  type="hidden" value="${role.roleID}">
           	 			 		<input  type="hidden" value="${status.index + 1}">
           	 				</div>
           	 				</c:forEach>
           	 				</div>
           	 			</td>
           	 		</tr>
           	 	</table>
           	 	<table align="left" style="float: left;  margin-top:10px;border:0px solid green; "   >		
					<tr>
           	 			<td id="loadTaskTree">
           	 				<table>
								<tr>
									<td >
	 									<div id="taskTree" >
	 									</div>
									</td>
								</tr>
							</table>
           	 			</td>
           	 		</tr>
           		</table>
           	
<script type="text/javascript">
	var comCode=$("#comCode").val();
	var userCode=$("#selectUserCode").val();
	var roleid="";
    <c:forEach var="role" items="${roles}" varStatus="statu">
    	roleid+=$("#"+${statu.index + 1}).val()+",";
	</c:forEach>
		roleid=roleid.substring(0,roleid.length-1);
	 	var ttree=new dhtmlXTreeObject("taskTree","100%","100%",0);
      	ttree.setImagePath("${ctx}/images/dxTree/");
      	ttree.enableTreeImages(0);
      	ttree.enableCheckBoxes(1);
      	//tree.enableThreeStateCheckboxes(true);//false to disable
      	ttree.loadXML("${ctx}/rms/employeesConfig/taskTree.do?roleID="+roleid+"&employe.userCode="+userCode+"&comCode="+comCode,function(){
      		 ttree.enableThreeStateCheckboxes(true);
      	});
</script>