<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp" %>
<html>
<head>
  <title>update password</title>
  <!-- ҳ����ʽ  -->
  <link rel="stylesheet" type="text/css" href="${ctx}/common/css/Standard.css">
  <script language=Javascript>
    function mySubmit()
    {
    	if(fm.userCode.value == "")
    	{
    		alert('�û����Ų���Ϊ��!');fm.userCode.focus();return false;
    	}
    	if(fm.newPassword.value == fm.oldPassword.value){
     	 	alert("�����벻����ԭ����һ��");
     	 	fm.newPassword.value= "";
          fm.retypeNewPassword.value = "";
     	 	return;
     	 }
     	 if(fm.newPassword.value.length<6 ||fm.newPassword.value.length>20){
     	 	alert("�����볤�ȱ������6-20λ֮��");
     	 	fm.newPassword.value= "";
          fm.retypeNewPassword.value = "";
     	 	return;
     	 }
     	 var regu=/^(([a-z]+[0-9]+)|([0-9]+[a-z]+))[a-z0-9]*$/i; //���������ĸ�����ֻ�ϵ�,���ܴ����ֻ���ĸ
   	 var re = new RegExp(regu);   
   	 if (re.test( fm.newPassword.value)==false) {   
     		alert("�������������ĸ�����ֻ�����");
     		fm.newPassword.value= "";
          fm.retypeNewPassword.value = "";
     		return;
   	 }   
       
      if(fm.newPassword.value == fm.retypeNewPassword.value)
      {
        fm.submit(); //�ύ
      }
      else
      {
        alert("������У���������������������");
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
      		�û������޸�
      	</td>
    </tr>
    <tr>
        <td class="title" style = "width:50%">�û����ţ�</td>
        <td class="input" style = "width:50%">
          <input name='userCode' class=common maxlength="10">
        </td>
    </tr>
        <!------modidfy by ������Ŀ�� ��ΰ  20060518  begin----------->   
    <tr>
        <td class="title">ԭ����:</td>
        <td class="input"><input class=common type="password" name='oldPassword' maxlength="10"></td>
    </tr>
    <tr>
        <td class="title">������:</td>
        <td class="input"><input class=common type="password" name='newPassword' maxlength="10"></td>
    </tr>
    <tr>
        <td class="title">�ظ�������:</td>
        <td class="input"><input class=common type="password" name='retypeNewPassword' maxlength="10"></td>
    </tr>
      <!------modidfy by ������Ŀ�� ��ΰ  20060518  end----------->
    <tr align=center>
      <td>
        <input class="button" type="button" alt=" ȷ �� " value="ȷ ��" onclick="mySubmit()">
        <!--
        <img class=button style="align:center" alt="����" src='/prpall/common/images/butSave.gif' onclick="mySubmit()">
        -->
      </td>
      <td>
        <input class="button" type="button" alt=" �� д " value="�� д" onclick="myReset()">
        <!--
        <img class=button style="align:center" alt="��д" src='/prpall/common/images/butReset.gif' onclick="myReset()">
        -->
      </td>
    </tr>
  </table>
</form>
</body>
</html>
