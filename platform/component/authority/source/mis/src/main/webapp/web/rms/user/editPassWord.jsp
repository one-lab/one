<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改密码</title>
<%@include file="/common/taglibs.jsp" %>
<link href="${ctx}/css/standard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="script" src="${ctx}/js/jquery-1.6.4.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/page.js"></script>
<script type="text/javascript">

function reppassword(){
	var newpassword=$("#newpassword").val();
	var renewpassword = $("#renewpassword").val();
	if(renewpassword!=newpassword){
		$("#repasswordMassege").text("密码不一致 !");
		return false;
	}else{
		$("#repasswordMassege").text(" ");
		return true;
	}
}
</script>
</head>
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" align="center">
  <tr>
    <td align="center" valign="top">
    <form id="fm" method="post" action="${ctx }/rms/employConfig/updatePassword.do"> 
    <table width="98%" border="0" cellspacing="0" cellpadding="0">
     	<tr>
        <td height="29">
        	<table width="100%" height="29" border="0" cellpadding="0" cellspacing="0" background="${ctx}/images/bg_listtop.gif">
          		<tr>
            		<td width="34"><img src="${ctx}/images/img_listtopleft.gif" width="34" height="29"></td>
            		<td width="5%" nowrap class="size1">当前位置:修改密码 </td>
            		<td><img src="${ctx}/images/img_linetop.gif" width="12" height="29"></td>
            		<td align="right"><img src="${ctx}/images/img_listtopright.gif" width="34" height="29"></td>
          		</tr>
        	</table>
        </td>
      	</tr>
      
      <tr>
        <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table1" align="center">
          <tr>
            <td width="3" background="${ctx}/images/bg_listleft.gif"></td>
            <td align="center" valign="top">
            
            
            <table width="97%" border="0" cellspacing="0" cellpadding="0">
              <tr>
              	
               <td>
                 <table width="100%" border="0" cellspacing="0" cellpadding="0" >
                  <tr>
				    <td colspan="20" align="center" class="size3"> 修改密码</td>
				  </tr>
                  <tr>
                    <td width="25%" align="center" class="size4">员工编号：<input id="userCode" name="userCode" type="hidden"   class="input2" value="${employe.userCode}"> </td>
                    <td width="30%" class="size4-1"><input  name="Code" type="text" disabled="disabled" class="input2" value="${employe.userCode}"> </td>
                    <td width="25%" align="center" class="size4"></td>
                    <td class="size4"></td>
                  </tr> 
                  <tr>
                    <td width="25%" align="center" class="size4">原密码：</td>
                    <td width="30%" class="size4-1"><input id="oldPassword" name="oldPassword" type="password" class="input2" ></td>
                    <td width="25%" align="left" class="size4"><label id="passwordMassege"><s:fielderror><s:param>passwordmasg</s:param></s:fielderror></label> </td>
                    <td class="size4"></td>
                  </tr>   
                  <tr>
                    <td width="25%" align="center" class="size4">设置新密码：</td>
                    <td width="30%" class="size4-1"><input id="newpassword" name="newpassword" type="password" class="input2" value="${confirPassword}"></td>
                    <td width="25%" align="center" class="size4"></td>
                    <td class="size4"></td>
                  </tr>
				  <tr>
                    <td width="25%" align="center" class="size4">确认新密码：</td>
                    <td width="30%" class="size4-1"><input id="renewpassword" name="confirPassword" type="password" class="input2"  onkeyup="return reppassword();" value="${confirPassword}"></td>
                    <td width="25%" align="left" class="size4"><label id="repasswordMassege"></label></td>
                    <td class="size4"></td>
                  </tr>    
                  <tr>
                    <td width="25%" align="right" class="size4">&nbsp;</td>
                    <td width="30%" class="size4-1"><input id="confir" name="Submit23" type="submit" class="btn1"  value="确  定" onclick="return reppassword();" > </td>
                    <td width="25%" align="left" class="size4"></td>
                    <td class="size4"></td>
                  </tr>
               </table>
               </td> 
               </tr>
            <tr>
            	<td>&nbsp;</td>
            	
            </tr>
              
            </table>
            
            
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
            <td align="left"><img src="${ctx}/images/img_listbottomleft.gif" width="13" height="25"></td>
            <td align="right"><img src="${ctx}/images/img_listbottomright.gif" width="13" height="25"></td>
          </tr>
        </table>
        </td>
      </tr>
    </table>
      </form>
    </td>
  </tr>
</table>

</body>
</html>

