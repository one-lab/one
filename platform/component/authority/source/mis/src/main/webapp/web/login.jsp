<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>中华联合电子商务</title> 
<%@include file="/common/taglibs.jsp" %>
<link href="${ctx}/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="script" src="${ctx}/js/jquery-1.6.4.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/login.js"></script>
<script type="text/javascript">
if(window.parent != window){
	window.parent.location.href = window.location.href;	
}
</script>
</head>
<body>
<form id="userForm" method="post">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="99" background="${ctx}/images/bg_logontop.gif">&nbsp;</td>
  </tr>
  <tr>
    <td align="center" valign="top"><table width="588" height="322" border="0" cellpadding="0" cellspacing="0" background="${ctx}/images/bg_logonmain.gif">
      <tr>
        <td align="right" valign="bottom">
        <table bgcolor="" width="380" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="14%" height="32">用户名：</td>
            <td ><input id="userCode" name="employe.userCode" type="text" class="input1" onblur="checkUser();" value="${employe.userCode }" />
            </td>
            <td ><label id="userCodeError"><s:fielderror fieldName="error"></s:fielderror></label>  </td>
          </tr>
          <tr>
            <td height="32">密　码：</td>
            <td ><input id="password" name="employe.password" type="password" class="input1" onblur="checkUser();" value="${employe.password }" />
                
            </td>
            <td width="25%"><label  id="passwordError"> </label></td>
          </tr>
          <tr>
            <td height="32">机　构：</td>
            <td><select name="company.comCode" class="input1" id="select">
            <option value="0">--请选择机构--</option>
            </select></td>
             <td></td>
          </tr>
          <tr>
            <td height="45">&nbsp;</td>
            <td><input name="Submit" type="button" class="btn1" onclick="login()" value="登  录" />
             <input name="Submit2" type="reset" class="btn1" value="重  置" />
             <a href="#"></a></td>
          	 <td></td>
          </tr>
        
        </table>
        </td>
     
        </tr>
    </table></td>
  </tr>
  <tr>
    <td height="195"><table width="100%" border="0" cellpadding="0" cellspacing="0" background="${ctx}/images/bg_logonbottom.gif">
      <tr>
        <td>&nbsp;</td>
        <td width="259" align="right"><img src="${ctx}/images/img_logonwelcome.gif" width="259" height="195" /></td>
      </tr>
      
    </table></td>
  </tr>
</table>
</form>
</body>
</html>