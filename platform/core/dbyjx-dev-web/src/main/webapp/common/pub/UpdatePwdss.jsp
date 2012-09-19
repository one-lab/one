<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp" %>
<html>
<head>
  <title>update password</title>
  <!-- 页面样式  -->
  <link rel="stylesheet" type="text/css" href="${ctx}/common/css/Standard.css">
  <script language=Javascript>
    function mySubmit()
    {
    	if(fm.userCode.value == "")
    	{
    		alert('用户工号不能为空!');fm.userCode.focus();return false;
    	}
    	if(fm.newPassword.value == fm.oldPassword.value){
     	 	alert("新密码不能与原密码一样");
     	 	fm.newPassword.value= "";
          fm.retypeNewPassword.value = "";
     	 	return;
     	 }
     	 if(fm.newPassword.value.length<6 ||fm.newPassword.value.length>20){
     	 	alert("新密码长度必须介于6-20位之间");
     	 	fm.newPassword.value= "";
          fm.retypeNewPassword.value = "";
     	 	return;
     	 }
     	 var regu=/^(([a-z]+[0-9]+)|([0-9]+[a-z]+))[a-z0-9]*$/i; //密码必须字母和数字混合的,不能纯数字或纯字母
   	 var re = new RegExp(regu);   
   	 if (re.test( fm.newPassword.value)==false) {   
     		alert("新密码必须由字母和数字混合组成");
     		fm.newPassword.value= "";
          fm.retypeNewPassword.value = "";
     		return;
   	 }   
       
      if(fm.newPassword.value == fm.retypeNewPassword.value)
      {
        fm.submit(); //提交
      }
      else
      {
        alert("新密码校验错误，请重新输入新密码");
        fm.newPassword.value       = "";
        fm.retypeNewPassword.value = "";
      }
    }
    function myReset()
    {
        fm.reset();
    }
  </script>
</head>
<body class="interface">
<form action="/prpall/common/pub/UIUpdatePwdSave.jsp" method=post name=fm>
  <table class=three align="center" style = "width:400">
  	<tr>
      	<td class=formtitle colspan="2">
      		用户密码修改
      	</td>
    </tr>
    <tr>
        <td class="title" style = "width:50%">用户工号：</td>
        <td class="input" style = "width:50%">
          <input name='userCode' class=common maxlength="10">
        </td>
    </tr>
        <!------modidfy by 都邦项目组 刘伟  20060518  begin----------->   
    <tr>
        <td class="title">原密码:</td>
        <td class="input"><input class=common type="password" name='oldPassword' maxlength="10"></td>
    </tr>
    <tr>
        <td class="title">新密码:</td>
        <td class="input"><input class=common type="password" name='newPassword' maxlength="10"></td>
    </tr>
    <tr>
        <td class="title">重复新密码:</td>
        <td class="input"><input class=common type="password" name='retypeNewPassword' maxlength="10"></td>
    </tr>
      <!------modidfy by 都邦项目组 刘伟  20060518  end----------->
    <tr align=center>
      <td>
        <input class="button" type="button" alt=" 确 定 " value="确 定" onclick="mySubmit()">
        <!--
        <img class=button style="align:center" alt="保存" src='/prpall/common/images/butSave.gif' onclick="mySubmit()">
        -->
      </td>
      <td>
        <input class="button" type="button" alt=" 重 写 " value="重 写" onclick="myReset()">
        <!--
        <img class=button style="align:center" alt="重写" src='/prpall/common/images/butReset.gif' onclick="myReset()">
        -->
      </td>
    </tr>
  </table>
</form>
</body>
</html>
