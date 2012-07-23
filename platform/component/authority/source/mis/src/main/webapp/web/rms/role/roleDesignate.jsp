<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>角色管理</title>
<%@include file="/common/taglibs.jsp" %>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/file.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/dhtmlxtree.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/standard.css"/>
<style type="text/css">
	.shadow{position:absolute;width:100%;height:100%;left:0;top:0; margin:auto; text-align:center; opacity: .30;filter:Alpha(Opacity=30);background:#000;display:none;z-index:999999999;}
	.aialog{ margin-top:-18px; width:98%;height:100%; display: none;}
	.aialog_box{float: left; border:#a7b4ce 2px solid; left:0;top:0;width:100%;height:100%;}
</style>
<script type="text/javascript" language="script" src = '${ctx }/js/jquery-1.6.4.js'></script>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmltree.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmlcommon.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmlxtree_xw.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmlxtree_start.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmlxtree_li.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/role.js"></script>
</head>
<body>
<div class="shadow" id="shadow" style="display: none;position: absolute;z-index: 100;"></div>

  <!-- =================================以下是弹出层start============================= -->
              <div class="aialog" id="Dialog_car" style="display: none;position: absolute;z-index:101;">
             </div>
             <!-- ==============================弹出层end================================ --> 
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" align="center">
  <tr>
    <td align="center" valign="top">
    <table width="98%" border="0" cellspacing="0" cellpadding="0">
    
     	<tr>
        <td height="29">    
        	<table width="100%" height="29" border="0" cellpadding="0" cellspacing="0" background="${ctx}/images/bg_listtop.gif">
          		<tr>
            		<td width="34"><img src="${ctx}/images/img_listtopleft.gif" width="34" height="29"></td>
            		<td width="5%" nowrap class="size1">当前位置:权限管理-角色管理-角色指派 </td>
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
            <table width="97%" border="0" cellspacing="0" cellpadding="0">
              <tr>
               <td>
                 <table width="100%" border="0" cellspacing="0" cellpadding="0" >
                  <tr>
				    <td colspan="20" align="center" class="size3"> 角色指派</td>
				  </tr>
               	 </table>
               </td> 
               </tr>
              <tr id="div4" >
                <td height="30">
              	<table width="100%" border="0" cellspacing="0" cellpadding="0" >
                  <tr>
				    <td colspan="20" align="center" > 
					 <table width="100%" border="0" cellspacing="0" cellpadding="0"  style=" width: 300px;  " >
                  		<tr>
				   		 <td colspan="20" style="padding-left:0px;background-color:#f5f5f5;" >机构列表 </td>
				 	 	</tr>
				 	 	<tr>
				 	 	 <td >
				 	 	 	<table>
				 	 		   <tr>
				 	 		   	<td >
				 	 			<div align="left" id="DcomTree" style="width: 300px;border :1px solid Silver; background-color:#f5f5f5;height: 545px; margin-top:0px; overflow: auto;">
	       							<div id="ComTreeLoadImg" ><img  src="${ctx}/images/loading.gif">正在加载.....</div>
	       						</div>
	       						</td>
	       					   </tr>
	       					</table>
				 	 	 </td>
				 	 	</tr>
				 	 	<tr>
				 	 	</tr>
               		 </table>
					</td>
					
				    <td colspan="20" align="center"> 
					 <table width="100%" border="0" cellspacing="0" cellpadding="0"  style=" width: 500px;  margin-left:100 px;" >
                  		<tr>
				   		 <td colspan="20" style="padding-left:0px;background-color:#f5f5f5;" > 角色列表</td>
				 	 	</tr>
				 	 	<tr>
				 	 	 <td style="border :1px solid Silver; background-color:#f5f5f5;" >
				 	 	 <table style="width: 500px;" >
				 	 	 <tr>
				 	 	 	<td width="8%"  class="td1">&nbsp;</td>
							<td width="35%" class="td1">角色名称</td>
							<td width="20%" class="td1">指派日期</td>
							<td width="10%" class="td1">指派人</td>
						</tr>
						</table>
				 	 		   <div id="roles" style="width: 500px;border :0px solid Silver;height: 419px; margin-top:0px; overflow: auto;">
				 	 		   </div>
				 	 		   <div id="roleDesinaeSaveImg" style="display:none; width: 500px;border :0px solid Silver;height: 419px; margin-top:0px; overflow: auto;">
				 	 		  		<img  src="${ctx}/images/loading.gif">正在处理.....
				 	 		   </div>
				 	 	 </td>
				 	 	</tr>
				 	 	
				 	 	<tr>
				 	 		<td>
				 	 		<table width="100%" border="0" cellspacing="0" cellpadding="0"  style="height: 100px;margin-left:0px; " >
								<tr>
				   		 			<td colspan="20" ></td>
				 	 			</tr>
								<tr>
				 	 		   		<td>
				 	 		   			<table border="0">
				 	 		   				<tr>
				 	 		   				<td>
				 	 							<div  style="height:80px;border :px solid Silver;margin-top:0px; overflow: auto;">
	       										<input id="save" name="Submit23" type="button" class="btn1" value="保 存" onclick="roleDesignate();" >
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
              </tr>
            </table>
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
//指派页面机构树
var ctree = new dhtmlXTreeObject("DcomTree", "100%", "100%", 0);
ctree.setImagePath("${ctx}/images/dxTree/");
ctree.setChildCalcMode("Child");
ctree.setXMLAutoLoadingBehaviour("id");
ctree.setXMLAutoLoading("${ctx}/rms/role/treeComCode.do");
ctree.setOnClickHandler(findRoles);
ctree.loadXML("${ctx}/rms/role/treeComCode.do",function(){
	$("#ComTreeLoadImg").css("display","none");
});


</script>
