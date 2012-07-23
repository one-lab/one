<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户组管理</title>
<%@include file="/common/taglibs.jsp" %>
<link href="${ctx}/css/standard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="script" src="${ctx}/js/jquery-1.6.4.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/page.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/group.js"></script>
<script language="JavaScript" type="text/javascript">

</script>
</head>
<body>

<table  align="center" width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="top">
    <form id="queryfm" method="post"> 
    <table width="98%" border="0" cellspacing="0" cellpadding="0">
     	<tr>
        <td height="29">
        	<table width="100%" height="29" border="0" cellpadding="0" cellspacing="0" background="${ctx}/images/bg_listtop.gif">
          		<tr>
            		<td width="34"><img src="${ctx}/images/img_listtopleft.gif" width="34" height="29"></td>
            		<td width="5%" nowrap class="size1">当前位置:权限管理-用户组管理 </td>
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
				    <td colspan="20" align="center" class="size3"> 用户组管理</td>
				  </tr>
                  <tr>
                    <td width="25%" align="center" class="size4">用户组名称：</td>
                    <td width="30%" class="size4-1"><input name="group.name" type="text" class="input2" value="${groupName}"></td>
                    <td width="25%" align="center" class="size4"></td>
                    <td class="size4"></td>
                  </tr>   
                  <tr>
                    <td  width="25%" align="right" class="size4">&nbsp;</td>
                    <td  width="30%" class="size4-1"><input id="query" name="Submit23" type="submit" class="btn1" value="查  询" > </td>
                    <td  width="25%" align="center" class="size4">&nbsp;<input id="prepareAdd" name="Submit22" type="button" class="btn1" value="增  加" ></td>
                    <td class="size4"></td>
                  </tr>
               </table>
               </td> 
               </tr>
            <tr>
            	<td>&nbsp;</td>
            	
            </tr>
              <tr id="div2">
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="table3">
                  <tr>
                    <td width="6%" class="td1">序号</td>
                    <td width="15%" class="td1">用户组名称</td>
                    <td width="25%" class="td1">描述</td>
                    <td width="17%" class="td1">创建日期</td>
                    <td width="17%" class="td1">修改日期 </td>
                    <td width="20%" class="td1">操作</td>
                  </tr>
              <c:forEach var="group" items="${groups}" varStatus="status">
                  <tr>
                    <td class="td5">${status.index + 1}</td>
                    	<td class="td5"><a href="#" onclick="prepareUpdata('${group.groupID}');">${group.name }</a></td>
                    <td class="td5">${!empty group.des ? group.des : '暂无描述'}</td>
                    <td class="td5">${!empty group.createTime ? group.createTime : ' '}&nbsp;</td>
                    <td class="td5">${!empty group.operateTime ? group.createTime : ' '}&nbsp;</td>
                    <td style="text-align: center;" class="td5">&nbsp;
                    	<c:if test="${group.name!='默认用户组'}">
               			 	<input type="button" onclick="prepareUpdata('${group.groupID}');" value="修改" class="btn1" />
              			 	<input type="button" onclick="deleteGroup('${group.groupID}');" value="删除" class="btn1" />
           			 	</c:if>
           			 </td>
                  </tr>
      			</c:forEach>
                </table></td>
              </tr>
              
              
              <tr id="div4" >
                <td height="30">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td  height="30" valign="top">每页
                      <input type="hidden" name="pageNo" id="pageNo" value="${pageNo}" /> 
                      <input name="pageSize" type="hidden"  class="input1" value="${pageSize}" disabled="disabled">${pageSize}&nbsp;条记录&nbsp;&nbsp;&nbsp;
                      <s:if test="page.currentPageNo!=1">
                      <a href="javascript:currPage('1');" id="first">首页</a> 
                      <a href="javascript:currPage('<s:property value="page.currentPageNo-1"/>');" id="prev">上一页</a>
                       </s:if> <s:if test="page.currentPageNo!=page.totalPageCount">
                      <a href="javascript:currPage('<s:property value="page.currentPageNo+1"/>');" id="next">下一页</a> 
                      <a href="javascript:currPage('<s:property value="page.totalPageCount"/>');" id="end">末页</a> </s:if> &nbsp;&nbsp;&nbsp;共：${page.totalPageCount}页 &nbsp;第${pageNo} 页
                    </td>
                  </tr>
                </table></td>
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
    </table>
      </form>
    </td>
  </tr>
</table>

</body>
</html>

