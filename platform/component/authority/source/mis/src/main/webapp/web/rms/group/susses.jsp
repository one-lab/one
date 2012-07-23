<%@ page language="java" contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/taglibs.jsp" %>
<link href="${ctx}/css/standard.css" rel="stylesheet" type="text/css">
<script language="javascript" > 
function getmessage() {
    //document.getElementById("message").innerHTML = 5;
    var s = document.getElementById("message").innerHTML;
    if (s > 1) {
        document.getElementById("message").innerHTML = s - 1;
        setTimeout(getmessage, 1000);
    }else {
	   	window.location.href = contextRootPath+ "/rms/group/queryGroup.do";
    };
    //alert(s);
};
</script> 
</head>
<body onload="getmessage()">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
    	<td align="center" valign="top">
    		<table width="98%" border="0" cellspacing="0" cellpadding="0">
    			<tr>	
    				<td>
    				<table width="100%" height="29" border="0" cellpadding="0" cellspacing="0" background="${ctx}/images/bg_listtop.gif">
    					<tr>	
    						<td width="34"><img src="${ctx}/images/img_listtopleft.gif" width="34" height="29"></td>
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
    					  			<td align="left">
    					  				<table style="height: 300px ;"  width="100%" class="size3">
											<tr>
												<td align="center" height="20px;">   
													<div style="padding-top:25px;">
    					  								<span style=" font-size:30px;">操作成功</span>
    					  								<span  style=" font-size: 17px;"  id="message">5</span>
    					  								<span style=" font-size: 17px;" >秒后自动跳转…</span>
    					  							</div>
    					  						</td>
											</tr>			
    					  					<tr>
    					  						<td align="center"  height="50px" > 
    					  							<div style="padding-top: 0;">
    					  								
    					  							</div>
    					  						</td>
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
    	</td>
    </tr>			
</table>
</body>
</html>


