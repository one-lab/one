<%@ page language="java" contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>中华联合电子商务-角色管理</title>
<%@include file="/common/taglibs.jsp" %>
<link href="${ctx}/css/standard.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" language="script" src="${ctx}/js/jquery-1.6.4.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmltree.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmlcommon.js"></script>
</head>
<body>
<table width="80%"  border="0" cellpadding="0" cellspacing="0" align="center">
   <tr>
     <td height="29">
       <table width="100%" height="29" border="0" cellpadding="0" cellspacing="0" background="${ctx}/images/bg_listtop.gif">
          <tr>
           <td width="34"><img src="${ctx}/images/img_listtopleft.gif" width="34" height="29"></td>
           <td width="5%" nowrap class="size1"> 首页->>&nbsp;组织管理->>&nbsp;组成员信息</td>
           <td><img src="${ctx}/images/img_linetop.gif" width="12" height="29"></td>
           <td align="right"><img src="${ctx}/images/img_listtopright.gif" width="34" height="29"></td>
         </tr>
      </table>
     </td>
   </tr>
   <tr>
      <td>
      <form id="userInfofm" method="post">
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table1">
          <tr>
            <td width="3" background="${ctx}/images/bg_listleft.gif"></td>
            <td align="center" valign="top">
				
		           <table width="98%" class="table1" border="0" cellpadding="0" cellspacing="0" >
		              <tr>
		                  <td colspan="4" style="text-align: center;" class="size3">
		                     
		                  </td>
		              </tr>
		              <tr>
		                  <td  class="size4-1">
		                  	<table width="100%">
		                  		<tr>
		                  			<td width="50%">
		                  			用户代码:<input id="userCode" name="userCode" disabled="disabled" value="${employee.userCode}"/>
		                  			</td>
		                  			<td width="50%">
		                  			 用户名称<input id="userName" name="userName" disabled="disabled" value="${employee.userName}"/>
		                  					<input id="comCode" name="comCode" type="hidden" value="${employee.company.comCode}"/>
		                  			</td>
		                  			<td  class="size4-1"><input  type="button" style="margin-left: 100px;" class="btn1" onclick="redirectToGroup('${group.groupID}');" value="返 回" ></td>
		                  		</tr>
		                  	</table>
		                  </td>
		              </tr>
					  <tr>
						<td align="left" class="size3" >所在用户组：
							
						</td>
					  </tr>
					  <tr>
					  	<td  align="left">
					  	<table class="table3" style="margin-left: 100px;width: 400px">
									<tr>
										<td class="td5" style="width: 50%">用户组名称</td>
										<td class="td5"style="width: 50">机构</td>
									</tr>
									<c:forEach var="group" items="${groups}">
									<tr>
										<td class="td5" style="width: 50%">${group.name}</td>
										<td class="td5" style="width: 50%">${group.comCode}</td>
									</tr>
								</c:forEach>
						</table>
					  	</td>
					  </tr>
					  <tr>
						<td align="left" class="size3" >角色：
						</td>
					  </tr>
						<tr>
						<td align="left"  >
							<table class="table3" style="margin-left: 100px;width: 400px">
									<tr>
										<td class="td5" style="width: 25%">角色名称名称</td>
										<td class="td5" style="width: 50%">机构</td>
									</tr>
									<c:forEach var="role" items="${roles}">
									<tr>
										<td class="td5" style="width: 50%">${role.name}</td>
										<td class="td5" style="width: 50%">${role.comCode}</td>
									</tr>
								</c:forEach>
							</table>
						</td>
						</tr>
					<tr>
						<td align="left" class="size3" >功能权限：
							
						</td>
					</tr>
					<tr>
	                 	 <td align="left" class="size4">
							<div align="left" style="margin-left: 100px;"id="userTaskTree">
							</div>	                 	 
						</td>
                   	</tr>
                   	<tr>
                   		
		         	</tr>
		          </table>
           </td>
           <td width="3" background="${ctx}/images/bg_listright.gif"></td>
        </tr>
      </table>
      </form>
    </td>
  </tr>
   <tr>
     <td height="25">
      <table width="100%" height="25" border="0" cellpadding="0" cellspacing="0" background="${ctx}/images/bg_listbottom.gif">
        <tr>
          <td align="left"><img src="${ctx}/images/img_listbottomleft.gif" width="13" height="25" /></td>
          <td align="right"><img src="${ctx}/images/img_listbottomright.gif" width="13" height="25" /></td>
        </tr>
      </table>
     </td>
  </tr>
</table>
</body>
</html>
<script>
 var userCode=$("#userCode").val();
 var comCode=$("#comCode").val();
 var utree=new dhtmlXTreeObject("userTaskTree","100%","100%",0);
 utree.setImagePath("${ctx}/images/dxTree/");
 utree.enableTreeImages(0);
 utree.loadXML("${ctx}/rms/group/userTaskTree.do?userCode="+userCode+"&comCode="+comCode);
 
 function redirectToGroup(groupid){
	 $("#userInfofm").attr("action",contextRootPath + "/rms/group/preparUpdata.do?group.groupID="+groupid).submit();
 }
</script>