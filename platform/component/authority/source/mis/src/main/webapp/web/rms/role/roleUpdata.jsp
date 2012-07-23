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
<script type="text/javascript" language="script" src="${ctx}/js/role.js"></script>
<script language="JavaScript" type="text/javascript">
</script>
</head>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top">
    <table width="98%" border="0" cellspacing="0" cellpadding="0">
     	<tr>
        <td height="29">    <input id="savesuccess" name="Submit23" type="hidden""  value="${addRolesuccess }" >  
        	<table width="100%" height="29" border="0" cellpadding="0" cellspacing="0" background="${ctx}/images/bg_listtop.gif">
          		<tr>
            		<td width="34"><img src="${ctx}/images/img_listtopleft.gif" width="34" height="29"></td>
            		<td width="5%" nowrap class="size1">当前位置:权限管理-角色管理 </td>
            		<td><img src="${ctx}/images/img_linetop.gif" width="12" height="29"></td>
            		<td align="right"><img src="${ctx}/images/img_listtopright.gif" width="34" height="29"></td>
          		</tr>
        	</table>
        </td>
      	</tr>
      
      <tr>
        <td>
        	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table1">
          <tr>
            <td width="3" background="${ctx}/images/bg_listleft.gif"></td>
            <td align="center" valign="top">
				<form id="updatafm" method="post">
		           <table width="100%" class="table1" border="0" cellpadding="0" cellspacing="0" >
		              <tr>
		                  <td colspan="4" style="text-align: center;" class="size3">
		                     	角色信息
		                     	<c:if test="${loginInfo.employe.company.comCode!=role.comCode}">
		                   		 <label>（你对本角色只有使用权）</label>
		                   		</c:if>
		                  </td>
		              </tr>
		              <tr>
		                  <td colspan="1" style="text-align: right; width: 15%" class="size4">角色名称
		                  
		                  </td>
		                  <td colspan="1"style="text-align: left; " class="size4-1">
		                  <input id="roleID" name="role.roleID" type="hidden" class="input2" value="${role.roleID}">
		                   	<input id="roleComCode" type="hidden" name="role.comCode"  class="input2" value="${role.comCode}">
		                   	<input id="loginComCode" type="hidden" name="loginComCode"  class="input2" value="${loginInfo.employe.company.comCode}">
		                   	<c:if test="${loginInfo.employe.company.comCode!=role.comCode}">
		                    	<input id="rolename" disabled="disabled" type="text" name="role.name" value="${role.name}" maxlength="128" size="20" class="input2"/>
		                   	</c:if>
		                   	<c:if test="${loginInfo.employe.company.comCode==role.comCode}">
		                    	<input id="rolename"  type="text" name="role.name" value="${role.name}" maxlength="128" size="20" class="input2"/>
		                   	</c:if>
		                  </td>
		                  <td colspan="1" style="text-align:left: ; " class="size4">
		                  	
		                  </td>
		              </tr>
		              <tr>
                          <td style="text-align: right; width:200px" class="size5">角色描述</td>
                          <td style="text-align: left; width:600px" class="size5-1" colspan="3">
                           	<c:if test="${loginInfo.employe.company.comCode!=role.comCode}">
                           		<textarea disabled="disabled" id="roledes" name="role.des" cols="70" rows="5">${role.des}</textarea>
                        	</c:if>
                        	<c:if test="${loginInfo.employe.company.comCode==role.comCode}">
                           		<textarea  id="roledes" name="role.des" cols="70" rows="5">${role.des}</textarea>
                        	</c:if>
                          </td>
                      </tr>
		              <tr><td colspan="3" style="text-align:center;">
		              		<table width="100%">
		              			<tr class="size3"> 
		              				<td width="50%" >该角色在本机构可见权限列表</td>
		              				<td width="50%" >该角色指派到下级的机构列表</td>
		              			</tr>
		              		</table>
		              	  </td>
		           	  </tr>

					<tr>
						<td colspan="3" class="size4">
						<table>
						<tr>
						<td style="" class="size4" width="30%" align="center">
							<table style="margin-left:100px;height:300px; width: 300px; border :1px solid Silver;" border="0" align="center"  >
								<tr>
								<td >
									<div style=" height:300px; width: 300px;">
									<table align="left">
										<tr>
										<td >
											<div id="taskTree" align="left" style=" height:290px; width: 300px; overflow: auto;">
											</div>
										</td>
										</tr>
									</table>
									</div>
								</td>
								</tr>
							</table>
						</td>
						<td class="size4" height="500px" style="text-align: center; width: 100px;" >
						</td>
						<td  class="size4" align="center">
							<table style="height:300px; width: 500px;  border :1px solid Silver;" border="0" align="center" >
								<tr>
								<td>
									<div style=" width: 500px;height: 300px;overflow:auto;">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="table4" >
											<tr>
													<td class="td1" style="width: 25px;">&nbsp;</td>
													<td class="td1" style="width: 62px;">机构代码</td>
													<td class="td1" style="width: 150px;">机构名称</td>
													<td class="td1" style="width: 76px;">指派操作人</td>
													<td class="td1" style="">指派操作时间</td>
												</tr>
											 <s:if test="roleDesignateInfos.size==0">
												<tr>
																	<td class="td5" colspan="5">暂时没有机构的指派 </td>
												</tr>
											</s:if>	
													<c:forEach var="roleDesignateInfo"
																items="${roleDesignateInfos}" varStatus="status">
																<tr>
																	<td style="width: 25px;" class="td5"><input
																		type="checkbox" checked="checked"
																		name="DesNateComCode"
																		value="${roleDesignateInfo.company.comCode}" /></td>
																	<td style="width: 62px;" class="td5">${roleDesignateInfo.company.comCode}</td>
																	<td style="width: 150px;" class="td5">${roleDesignateInfo.company.comEName}</td>
																	<td style="width: 76px;" class="td5">${roleDesignateInfo.createUser}
																	</td>
																	<td style="" class="td5">${roleDesignateInfo.createTime}</td>
																</tr>
													 </c:forEach>
									</table>
									</div>
								</td>
								</tr>
							</table>
						</td>
						</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td class="size4-1" width="10%" ></td>
                   		<td class="size4-1" width="30%" align="center">
                   			<c:if test="${loginInfo.employe.company.comCode==role.comCode}">
								<input id="save" name="Submit23" type="button" class="btn1" onclick="updatarole();" value="保 存" >
							</c:if>
                   		</td>
                    	<td class="size4-1" width="60%" align="center"> 
                    		<input id="redireType" type="hidden" value="" />
                    		<input  name="Submit23" type="button" class="btn1" onclick="redirect();" value="返 回" > 
                    	</td>
		             </tr>
		          </table>
				</form>
           </td>
           <td width="3" background="${ctx}/images/bg_listright.gif"></td>
        </tr>
      </table>
        </td>
      </tr>
      <tr>
        <td height="25"><table width="100%" height="25" border="0" cellpadding="0" cellspacing="0" background="${ctx}/images/bg_listbottom.gif">
          <tr>
            <td align="left"><img src="${ctx}/images/img_listbottomleft.gif" width="13" height="25"></td>
            <td align="right"><img src="${ctx}/images/img_listbottomright.gif" width="13" height="25"></td>
            </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>

</body>
</html>
<script > 
 var tree=new dhtmlXTreeObject("taskTree","100%","100%",0);
 tree.setImagePath("${ctx}/images/dxTree/");
 tree.enableTreeImages(0);
<c:if test="${loginInfo.employe.company.comCode==role.comCode}">
tree.enableCheckBoxes(1);
</c:if>
 tree.enableThreeStateCheckboxes(true);//false to disable
 tree.loadXML("${ctx}/rms/role/taskTree.do?role.roleID=${role.roleID}");
</script>