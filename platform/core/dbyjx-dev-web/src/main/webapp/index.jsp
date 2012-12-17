<%--
****************************************************************************
* DESC       ：用户登录页面
* AUTHOR     ：lixiang
* CREATEDATE ：2004-03-23
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html:html>
<head>
	<title>都邦意健险系统</title>
	<%--  -------------------页面样式-------------------------------  --%>
   	<link rel="stylesheet" type="text/css" href="${ctx }/common/css/Standard.css">
   	<%--  -------------------标准JS-------------------------------  --%>
  	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
	<script language="JavaScript">
		var browser=navigator.appName;
		if(browser!="Microsoft Internet Explorer")
		{
			   // alert("请使用ie浏览器登录此系统，页面将关闭"); 
	        	//window.location="about:blank";
	        	//window.close();
		}
 		<%-- -------modify by wangli add start 20050421---------- --%>
		function verifyLogin()
		{
		   if($("#userCode").val()=="")
		   { alert("用户名不能为空，请重新输入");  return false;	}
		   if($("#password").val()=="")
		   { alert("密码不能为空，请重新输入");   return false; }
		   if($("#comCode").val()=="")
		   { alert("请选择登录机构。\n如果下拉列表中没有选项，也许是您没有引入任何机构，请与系统管理员联系。");  return false; }
       	   return true;
   		}
   		//function isUser()
		//{
	    //  var loginMessage = document.fm.loginMessage.value;
	   //   if(loginMessage!="")
	   //   { alert(loginMessage);  document.fm.loginMessage.value = ""; } <%-- 清空loginMessage 隐藏域 --%>
   		// }
	    <%-- -------modify by wangli add end 20050421---------- --%>
	    <%-- ---------------新理赔权限登录选择岗位机构 start -------------- --%>
	      
    	var oldUserCode = "";
    	var oldPassWord = "";
    	function reloadComCodeList()
    	{
    		
    		var url = "${ctx}/userPower/loadCompany";
			var params = {
				"userCode":$("#userCode").val()
			};
			jQuery.post(url,params,callback,'json');
			function callback(datas){
				$("#comCode").html("");
				var optionStr = "";
				for(var i = 0, len = datas.length ; i < len ; i++){
                    var data = datas[i];
					optionStr += "<option value = '"+data.comCode+"'>"+ data.comCode+"--"+ data.comCName+"</option>";
				}
				$("#comCode").html(optionStr);
			}
    	}   
    	                         
    <%-- ---------------新理赔权限登录选择岗位机构 end-------------- --%>
	</script>
</head>

<body bgcolor="0074A4" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<%
	//User userDto1 = (User)session.getAttribute("userDto");
	//String loginMessage = "";
	//if(userDto1!=null)
	//{   loginMessage = userDto1.getLoginMessage(); }
	//if(loginMessage==null)
	//{   loginMessage = "";  }
%>
<form name="fm" action="${ctx}/userPower/login" method="post" onsubmit="return verifyLogin();">
	<BR>
	<input name="systemCode" type="hidden" class="common" value="claim">
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
		<tr> 
			<td align="center">
				<table width="601" border="0" cellspacing="0" cellpadding="0">
					<tr> 
						<td><img src="${ctx}/images/ImgLogonTop.gif" width="601" height="20"></td>
					</tr>
					<tr> 
						<td><img src="${ctx}/images/ImgViasLogonLogo.gif" width="601" height="201"></td>
					</tr>
		  		</table>
		  		
		    	<table width="601" height="235" border="0" cellpadding="0" cellspacing="0">
		      		<tr> 
		       			<td width="3" rowspan="2" background="${ctx}/images/BgLogonLeft.gif"></td>
		        		<td width="212" rowspan="2" align="center" valign="bottom" bgcolor="#FFFFFF"><img src="images/ImgLogonBig.gif" width="160" height="214"></td>
		        		<td height="40" align="center" valign="top" bgcolor="#FFFFFF"><img src="${ctx}/images/ImgClaimflowLogo.gif" width="322" height="26"></td>
		        		<td width="3" rowspan="2" background="${ctx}/images/BgLogonRight.gif"></td>
		      		</tr>
		      		<tr> 
		        		<td align="center" valign="top" bgcolor="#FFFFFF">
		        			<table width="85%" border="0" cellspacing="0" cellpadding="5">
					            <tr align="center"> 
					              <td height="30" colspan="2"><img src="${ctx}/images/ImgClaimflowLogo2.gif" width="123" height="19"></td>
					            </tr>
					            <tr> 
					              <td width="20%" height="30"><img src="${ctx}/images/ImgUser.gif" width="47" height="15"></td>
					              <td width="80%"> <input id="userCode" name="prpDuser.userCode" type="text" class="logon" maxlength="9" onblur="reloadComCodeList();"></td>
					            </tr>
					            <tr> 
					              <td height="30"><img src="${ctx}/images/ImgPassword.gif" width="47" height="15"></td>
					              <td><input id="password" name="prpDuser.password" type="password" class="logon" maxlength="10" ></td>
					            </tr> 
					            <tr> 
					              <td height="30"><img src="${ctx}/images/logon-comcode.gif" width="47" height="15"></td>
					              <td><select id="comCode" name="prpDcompany.comCode" class="logon" style="width:228px" ></select></td>
					            </tr>
					            <tr align="right"> 
					              <td height="15" colspan="2"><input type="image" src="${ctx}/images/BtnClaimflowEnter.gif" width="32" height="31" border="0"></td>
					            </tr>
					            <tr> 
					              <td height="15" colspan="2">&nbsp;</td>
					            </tr>
					            <tr align="right"> 
					              <td colspan="2">&nbsp; </td>
					            </tr>
		          			</table>
		       			</td>
		      		</tr>
		    	</table>
			  	<table width="601" border="0" cellspacing="0" cellpadding="0">
		     		<tr> 
			       		<td width="3" background="${ctx}/images/BgLogonLeft.gif"></td>
			       		<td height="25" align="center" bgcolor="B58F3D"><font color="#FFFFFF">技术支持中科软科技股份有限公司</font></td>
			       		<td width="3" background="${ctx}/images/BgLogonRight.gif"></td>
			     	</tr>
			   </table>
			</td>
		</tr>
	</table>
</form>
</body>
</html:html>
