<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglibs.jsp" %>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/file.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/dhtmlxtree.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/standard.css"/>
<script type="text/javascript" language="script" src = '${ctx }/js/jquery-1.6.4.js'></script>
<script>
</script>
   	<c:forEach var="group" items="${groups}" varStatus="status" >
       <table style="margin-top:10px; width:200px; border:0px solid green;" class="table4">
           <tr>
           	<c:if test="${group.des=='false'}">
           	  <td width="30%" style="margin-top: 0px">
           	  	<input name="groupID" type="checkbox" value="${group.groupID}" onclick="groupIdChange()"/>${group.name}
           	  </td>
           	</c:if>
           	<c:if test="${group.des=='true'}">
           	  <td width="30%" style="margin-top: 0px">
           	  	<input name="groupID" type="checkbox" checked="checked" value="${group.groupID}" onclick="groupIdChange()"/>${group.name}
           	  	<input  type="hidden" value="${group.groupID}"/>
           	  </td>
           	</c:if>
           </tr>
       </table>
    </c:forEach> 
 <script type="text/javascript">
           		$(function(){
           		 var sss="${userPower.userPowerID}";
           		$("#userPowerId").val(sss);
           			var groupid='';
           			<c:forEach var="group" items="${groups}" varStatus="status" >
           		 		<c:if test="${group.des=='true'}">
           		 		 groupid+="${group.groupID}"+",";
           		 		</c:if>
           			 </c:forEach>
           			 groupid=groupid.substring(0,groupid.length-1);
           			 var comCode='';
           			comCode=$("#comCode").val();
					$.ajax({
						type: "POST",
						cache:false,
						async:true,
       					url: contextRootPath+ "/rms/employeesConfig/loadGroupInfo.do?groupID="+groupid+"&comCode="+comCode,
       					success : function(data){
       						$("#groupInfo_roleInfo").html(data);
       					}
       				});
           		});
</script>	


