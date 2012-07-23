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
   $(function(){
	   /*        var operate = $("#operateType").attr("value");
       if(operate == "edit"){
           $("input[name='role.roleId']").attr("readonly","true");
       }else{
           $("input[name='role.roleId']").removeAttr("readonly");
       }*/
 
    
		// 取消
	$("#back").click(
		function() {
			$("#fm").attr("action",contextRootPath + "/rms/role/back.do").submit();
		});
	});

</script>
</head>

<body>
<table width="98%" height="100%" border="0" cellpadding="0" cellspacing="0" align="center">
   <tr>
     <td height="29">
       <table width="100%" height="29" border="0" cellpadding="0" cellspacing="0" background="${ctx}/images/bg_listtop.gif">
          <tr>
           <td width="34"><img src="${ctx}/images/img_listtopleft.gif" width="34" height="29"></td>
           <td width="5%" nowrap class="size1"> 首页->>&nbsp;组织管理->>&nbsp;角色管理</td>
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
				<form id="savefm" method="post">
				   <input name="operateType" id="operateType" type="hidden" value="${operateType.value}" />
		           <table width="100%" class="table1" border="0" cellpadding="0" cellspacing="0" >
		              <tr>
		                  <td colspan="4" style="text-align: center;" class="size3">
		                      ${operateType.text}角色
		                  </td>
		              </tr>
		              <tr>
		                  <td  style="text-align: right; width: 161px;" class="size4">角色名称</td>
		                  <td style="text-align: left; " class="size4-1">
		                  <input id="roleID" name="role.roleID" type="hidden" class="input2" value="${role.roleID}">
		                    <input id="rolename" type="text" name="role.name" value="${role.name}"  size="20" class="input2"/>
		                  </td>
		                  <td colspan="1"style="text-align: right; " class="size4-1"></td>
		              </tr>
		              <tr>
                          <td style="text-align: right; width: 161px;" class="size5">角色描述</td>
                          <td style="text-align: left; width:600px" class="size5-1" colspan="3">
                            <textarea id="roledes" name="role.des" cols="70" rows="5">${role.des}</textarea>
                          </td>
                      </tr>
		              <tr><td colspan="3"><hr/></td></tr>
		              <tr><td colspan="3" align="left" class="size3"><label style="margin-left: 450px;">权限列表</label></td></tr>

					<tr>
						<td colspan="3" align="left" class="size4" >
							<div style="margin-left: 430px;"id="taskTree"   style=" width:500px;"  >
							</div>
						</td>
					</tr>
					<tr>
						<td class="size4-1" width="10%" ></td>
                   		  <td class="size4-1" width="30%" align="center"><input  id="save" onclick="saveRole();" name="Submit23" type="button" class="btn1" value="确 定" ></td>
                    	 <td class="size4-1" width="60%" align="center"> <input   name="Submit23" type="button" class="btn1" onclick="redirect();" value="返 回" > </td>
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
 var tree=new dhtmlXTreeObject("taskTree","100%","100%",0);
 tree.setImagePath("${ctx}/images/dxTree/");
 tree.enableTreeImages(0);
 tree.enableCheckBoxes(1);
 //tree.enableThreeStateCheckboxes(true);//false to disable
 //tree.setOnCheckHandler(onclick);
//setTimeout(function(){
	//tree.enableThreeStateCheckboxes(true);
//}, 1000);
 tree.loadXML("${ctx}/rms/role/taskTree.do?role.roleID=${role.roleID}",function(){
	 tree.enableThreeStateCheckboxes(true);
 });
</script>