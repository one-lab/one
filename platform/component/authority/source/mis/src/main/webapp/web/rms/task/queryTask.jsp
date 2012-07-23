<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>功能授权</title>
<%@include file="/common/taglibs.jsp" %>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/file.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/dhtmlxtree.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/standard.css"/>
<script type="text/javascript" language="script" src = '${ctx }/js/jquery-1.6.4.js'></script>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmltree.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmltree_json.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmlcommon.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmlxtree_xw.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmlxtree_start.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmlxtree_li.js"></script>
<script type="text/javascript" language="script" src = '${ctx }/js/task.js'></script>
</head>
<body>

<table align="center" width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top">
    <table width="98%" border="0" cellspacing="0" cellpadding="0">
     	<tr>
        <td height="29">    <input id="savesuccess" name="Submit23" type="hidden""  value="${addRolesuccess }" >  
        	<table width="100%" height="29" border="0" cellpadding="0" cellspacing="0" background="${ctx}/images/bg_listtop.gif">
          		<tr>
            		<td width="34"><img src="${ctx}/images/img_listtopleft.gif" width="34" height="29"></td>
            		<td width="5%" nowrap class="size1">当前位置:权限管理-功能管理</td>
            		<td><img src="${ctx}/images/img_linetop.gif" width="12" height="29"></td>
            		<td align="right"><img src="${ctx}/images/img_listtopright.gif" width="34" height="29"></td>
          		</tr>
        	</table> 
        </td>
      	</tr>
      
      <tr>
        <td>
        <form id="fm" method="post">
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table1">
          <tr>
            <td width="3" background="${ctx}/images/bg_listleft.gif"></td>
            <td align="center" valign="top">
            <table width="97%" border="0" cellspacing="0" cellpadding="0">
              <tr>
               <td>
                 <table width="100%" border="0" cellspacing="0" cellpadding="0" >
                  <tr>
				    <td colspan="20" align="center" class="size3"> 功能授权</td>
				  </tr>
               	 </table>
               </td> 
               </tr>
              <tr id="div4" >
                <td >
              	<table  width="100%" border="0" cellspacing="0" cellpadding="0" >
                  <tr>
				    <td   valign="top"style="width: 200px;"> 
					 <table  border="0" cellspacing="0" cellpadding="0"  style="height: 550px; width: 200px;"  >
                  		<tr>
				   		 <td valign="top"  align="left" style="padding-left: 10px;border-top-width: 1px;border-top-color: #b7c4d4;padding-left: 10px;font-weight: bold;"> 
						 	功能列表
						 </td>
				 	 	</tr>
				 	 	<tr>
				 	 	 <td >
				 	 	 	<table>
				 	 		   <tr>
				 	 		   	<td >
				 	 			<div align="left" id="taskTree" style="width: 200px;border :1px solid Silver; background-color:#f5f5f5;height: 540px; margin-top:0px; overflow: auto;">
	       							<div id="taskTreeLoadImg" ><img  src="${ctx}/images/loading.gif">正在加载.....</div>
	       						</div>
	       						</td>
	       					   </tr>
	       					</table>
				 	 	 </td>
				 	 	</tr>
               		 </table>
					</td>
					
				    <td valign="top" align="left"> 
					 <table  style="margin-left:10px; " border="0" cellspacing="0" cellpadding="0"   >
                  		 <tr>
                  		 	<td>
								<input type="button" class="btn1" onclick="prepAdd();" value="新建功能"/>
                  		 	</td>
                  		 </tr>
                  		 <tr>
				   		 	
				 	 	 </tr>
				 	 	<tr>
				 	 	 <td>
				 	 		<table >
				 	 		   <tr>
				 	 		   <td valign="top" style="width: 650px;">
				 	 		   		<div id="taskInfo" style="float:left;width: 600px;">
	       								 
	       							</div>
	       							<div  id="edditTask" style=" float:left;margin-top:50px; width: 600px; height: 315px;;">
	       								 
	       							</div>
                                </td>
                                <td valign="top">
                                	<div id="selectParent" style="float:left;margin-top:0px;margin-left:30px;height:245px; width: 200px;border-top-color: #b7c4d4;border :1px solid Silver;overflow: auto;display: none; ">
	       								<div  id="selectParentLoadImg" ><img  src="${ctx}/images/loading.gif">正在加载.....</div>
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
              	</td>
              </tr>
            </table>
            </td>
            <td width="3" background="${ctx}/images/bg_listright.gif"></td>
          </tr>
        </table>
        </form>
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
