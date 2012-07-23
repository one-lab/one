<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%@include file="/common/taglibs.jsp" %>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/dhtmlxtree.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/standard.css"/>
<script type="text/javascript" src = '${ctx }/js/jquery-1.6.4.js'></script>
<script type="text/javascript" src = '${ctx }/js/dhtmlcommon.js'></script>
<script type="text/javascript" src = '${ctx }/js/dhtmltree.js'></script>
<script type="text/javascript" src = '${ctx }/js/dhtmlxtree_li.js'></script>
<script type="text/javascript" src = '${ctx }/js/dhtmlxtree_xw.js'></script>
<script type="text/javascript" src = "${ctx }/js/employee2.js"></script>
<script> 
$(function(){
	$("#comCode").val("");
	$("#selectdivid").val("tbc_01");
});
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
            		<td width="5%" nowrap class="size1">当前位置:权限管理-人员配置</td>
            		<td><img src="${ctx}/images/img_linetop.gif" width="12" height="29"></td>
            		<td align="right"><img src="${ctx}/images/img_listtopright.gif" width="34" height="29"></td>
          		</tr>
        	</table>
        </td>
      	</tr>
      
      <tr>
        <td >
        	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table1">
          <tr>
            <td width="3" background="${ctx}/images/bg_listleft.gif"></td>
            <td align="center" valign="top">
				<form id="updatafm" method="post">
		           <table width="100%" class="table1" border="0" cellpadding="0" cellspacing="0" >
		              <tr>
		                  <td colspan="4"  class="size3">
		                  		<table align="left" >
		                  			<tr>
		                  				<td align="left">
		                     				<label style="margin-left: 20px;" >机构列表</label>
		                     				
		                     				<label style="margin-left: 500px;" >人员配置</label>
		                     			</td>
		                     		</tr>
		                     	</table>
		                  </td>
		              </tr>
		              <tr>
		              	  <td class="table3" style="background-color:#f5f5f5;">
								<table  style="height: 600px; margin-top: 0;float: left;" >
									<tr>
										<td width="0"></td>
										<td valign="top" id="abc">
										<div id="DcomTree"
											style="border :1px solid Silver; background-color:#f5f5f5;width: 284px; height: 540px; margin-top: 0px; overflow: auto;"
											align="left" >
											<div id="ComTreeLoadImg" ><img  src="${ctx}/images/loading.gif">正在加载.....</div>
											</div>
										</td>
									</tr>
								</table>
								 <table align="left" style="height: 600px; margin-top: 0;float: left;" >
								 <tr>
								 <td>
								<input id="comCode" type="hidden" value="" />
								<table align="left" width="100%" border="0"  style="height: 580px; margin-top: 0;">
									<tr>
										<td align="left">
										<div id="findUser" align="left" class="w936" style=" height: 580px;margin-top: 0;">
										<div id="tb_" class="tb_" align="center" style="margin-top: 0;">
										<input id="selectdivid" name="divid" type="hidden" value="" />
										<ul>
											<li id="tb_1" class="hovertab" onclick="x:HoverLi(1);">已引入人员</li>
											<li id="tb_2" class="normaltab" onclick="i:HoverLi(2);">未引入人员</li>
											<li style="margin-left: 50px; width: 250px;"><label
												style="width: 200px;" id="editComCode"> </label></li>
										</ul>
										</div>
										<div class="ctt" align="left">
										<div class="dis" id="tbc_01">
										<table style="width: 100%;"  border="0" class="table">
											<tr>
												<td>用户代码:&nbsp;&nbsp;&nbsp;&nbsp;<input id="userCode"
													name="employe.userCode" /></td>
												<td>用户名:&nbsp;&nbsp;&nbsp;&nbsp;<input id="userName"
													name="employe.userName" /></td>
											</tr>
											<tr>
												<td colspan="2"><input style="margin-left: 200px;"
													class="btn1" type="button" onclick="findIntroduced();"
													value="查询" /></td>
											</tr>
											
										</table>
											<div>
												<div  id="findIntroduced" ></div>
											</div>
										</div>
										<div class="undis" id="tbc_02">
										<table style="width: 100%;"  border="0" class="table">
											<tr>
												<td>用户代码:&nbsp;&nbsp;&nbsp;&nbsp;<input
													id="noIntroduserCode" name="employe.userCode" /></td>
												<td>用户名:&nbsp;&nbsp;&nbsp;&nbsp;<input
													id="noIntroduserName" name="employe.userName" /></td>
											</tr>
											<tr>
												<td colspan="2"><input style="margin-left: 200px;"
													class="btn1" type="button" onclick="findNoIntroduced();"
													value="查询" /></td>
											</tr>
											<tr>
												<td colspan="2" id="findNoIntroduced"></td>
											</tr>
										</table>
										</div>
										</div>
										</div>
										</td>
										<td align="left">
										<div id="taskConfig" class="w936" style="display: none;  height: 580px;margin-top: 0;">
										<div id="ttb_" class="tb_" align="center" style="margin-top: 0;">
										<ul>
											<li id="ttb_1" class="hovertab" onclick="x:tHoverLi(1);">
											功能配置</li>
											<li id="ttb_2" class="normaltab" onclick="i:tHoverLi(2);" style="">规则配置</li>
											<li style="margin-left: 50px; width: 150px;"><label
												style="width: 100px;" id="editComCode"></label></li>
										</ul>
										</div>
										<div><input type="hidden" id="busPowerFlag" value="1">
										<label style="margin-left: 100px">你所操作的员工</label>
										<input id="userPowerId" type="hidden" value="" />
										<input id="selectUserCode" disabled="disabled" value="" />
										<input style="margin-left: 100px;" class="btn1" type="button"onclick="reSelect();" value="重新选择" /></div>
										<div class="ctt" align="left">
										<div class="dis" id="ttbc_01">
										<table style="width: 100%;" class="table" border="0">
											<tr>
												<td align="center" colspan="2">
												<div class="table3">
												<table width="100%;">
													<tr >
														<td align="left" style="width: 230px;border-top-color: #b7c4d4;padding-left: 10px;font-weight: bold;padding-top: 2px;" >用户组</td>
														<td align="left" style="border-top-color: #b7c4d4;padding-left: 10px;font-weight: bold;padding-top: 2px;" >角色</td>
														<td align="left" style="border-top-color: #b7c4d4;padding-left: 10px;font-weight: bold;padding-top: 2px;" >功能权限</td>
													</tr>
												</table>
												</div>
												</td>
											</tr>
											<tr>
												<td style="width: 230px">
												<div id="groupInfo"
													style="width: 230px; height: 400px; overflow: auto;"
													class="table3"></div>
												</td>
												<td style="width: 500px">
												<div id="groupInfo_roleInfo"
													style="height: 400px; width: 408px; overflow: auto;"
													class="table3"></div>
												</td>
											</tr>
											<tr>
												<td colspan="2"><input id="updataUserTask"
													style="margin-left: 100px;" class="btn1" type="button"
													onclick="updataUserInfo();" value="确定" /></td>
											</tr>
										</table>
										</div>
										<div class="undis" id="ttbc_02">
										<table style="width: 100%;" class="table" border="0">
											<tr>
												<td colspan="2">
												<table>
													<tr>
														<td><input type="button" value="保存" class="btn1"
															onclick="saveBusPower();"><br>
														</td>
													</tr>
												</table>
												</td>
											</tr>
											<tr>
												<td>
												<div id="busPowertaskTree"
													style="width: 180px; height: 400px; overflow: auto;"
													class="table3"></div>
												</td>
												<td>
												<div id="busPowerInfo"
													style="width: 458px; height: 400px; overflow: auto;"
													class="table3"></div>
												</td>
												<td></td>
											</tr>
										</table>
										</div>
										</div>
										</div>
										</td>
									</tr>
								</table>
								</td>
								</tr>
								</table>
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
<script> 

var tree = new dhtmlXTreeObject("DcomTree", "100%", "100%", 0);
tree.setImagePath("${ctx}/images/dxTree/");
tree.setChildCalcMode("Child");
tree.setXMLAutoLoadingBehaviour("id");
tree.setXMLAutoLoading("${ctx}/rms/employeesConfig/treeComCode.do");
tree.setOnClickHandler(eitdPower);
tree.loadXML("${ctx}/rms/employeesConfig/treeComCode.do",function(){
		$("#ComTreeLoadImg").css("display","none");
});
</script>