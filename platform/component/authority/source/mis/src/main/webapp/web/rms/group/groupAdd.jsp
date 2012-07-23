<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>中华联合电子商务-用户组管理</title>
<%@include file="/common/taglibs.jsp" %>
<link href="${ctx}/css/standard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="script" src="${ctx}/js/jquery-1.6.4.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/page.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/group.js"></script>

</head>
<body>
<form id="savefm"  method="post"  >
<table align="center" width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top"><table width="98%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="29"><table width="100%" height="29" border="0" cellpadding="0" cellspacing="0" background="${ctx}/images/bg_listtop.gif">
          <tr>
            <td width="34"><img src="${ctx}/images/img_listtopleft.gif" width="34" height="29"></td>
            <td width="5%" nowrap class="size1">当前位置:权限管理-用户组管理 </td>
            <td><img src="${ctx}/images/img_linetop.gif" width="12" height="29"></td>
            <td align="right"><img src="${ctx}/images/img_listtopright.gif" width="34" height="29"></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td>
     
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table1">
          <tr>
            <td width="3" background="${ctx}/images/bg_listleft.gif"></td>
            <td align="center" valign="top"><table width="97%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="15">&nbsp;</td>
              </tr>
              <tr>
                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="18%" align="center" class="size4">用户组名称：</td>
                    <td width="30%" class="size4-1">
                   	<input id="groupID" name="group.groupID" type="hidden" class="input2" value="${group.groupID}">
                    <input id="groupname" name="group.name" type="text" class="input2" value=""></td>
                    <td width="18%" align="right" class="size4"> 用户组描述:</td>
                    <td class="size4-1"><input id="groupdes" name="group.des" type="text" class="input2" value="${group.des}"></td>
                  </tr>   
                  <tr>
                    <td align="right" class="size4">&nbsp;</td>
                    <td class="size4-1"></td>
                    <td align="right" class="size4">&nbsp;</td>
                    <td align="right" class="size4-1"></td>
                  </tr>
               </table></td>
              </tr>
              
              <tr id="div1">
                <td height="10">&nbsp;</td>
              </tr>
              
              <tr id="div2">
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="table3">
                  <tr>
                  	<td width="5%"  class="td5">&nbsp;</td>
                    <td width="15%" class="td1">角色名称</td>
                    <td width="20%" class="td1">描述</td>
                    <td width="17%" class="td1">创建日期</td>
                    <td width="17%" class="td1">修改日期 </td>
                  
                  </tr>
              <c:forEach var="roleDesignate" items="${roleDesignates}" varStatus="status">
                  <tr>
                  
                  	<td class="td5"><input type="checkbox" name="roleIDs" value="${roleDesignate.role.roleID}"></td>
                    <td class="td5"><a href="#">${roleDesignate.role.name }</a></td>
                    <td class="td5">${roleDesignate.role.des}</td>
                    <td class="td5">${roleDesignate.role.createTime }</td>
                    <td class="td5">${roleDesignate.role.operateTime } </td>
                   
                  </tr>
      			</c:forEach>
                </table></td>
              </tr>
              <tr id="div3">
                <td height="10">&nbsp;</td>
              </tr>
              <tr id="div4" >
                <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                    <td width="50%" class="size4-1" ><input style="margin-left: 300px;" name="Submit23" type="button" class="btn1" value="保 存"  onclick="saveGroup();"  ></td>
                    <td width="50%" class="size4-1"><input style="margin-left: 100px;" name="Submit23" type="button" class="btn1" onclick="redirect();" value="返 回" ></td>
                  </tr>
                </table></td>
              </tr>
              
            </table></td>
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
 </form>
</body>
</html>
