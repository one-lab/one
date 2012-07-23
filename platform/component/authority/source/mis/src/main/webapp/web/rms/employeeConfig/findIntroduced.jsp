<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglibs.jsp" %>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/dhtmlxtree.css"/>
<script type="text/javascript" language="script" src = '${ctx }/js/jquery-1.6.4.js'>
</script>
<div align="left" style="" >
              		
<table  style="width: 650px; " class="table3" >
		<tr >
			<td style="width:25px;" class="td5" >&nbsp;</td>
			<td style="width:62px;"  class="td5"  >用户代码</td>
			<td style="width:62px;"  class="td5"   >用户名</td>
			<td style="width:300px"  class="td5"  >&nbsp;</td>
		</tr>
	<c:forEach var="employe" items="${employes}"
		varStatus="status">
		
		<tr>
			<td style="width: 10%" class="td5"  >${status.index + 1}</td>
			<td style="width: 25%" class="td5"    >${employe.userCode}</td>
			<td style="width: 30%" class="td5"   ><a href="#" onclick="editIntroduced('${employe.userCode}')">${employe.userName}</a></td>
			<td style="width: 35%"  class="td5"  >
			<c:if test="${querytype=='findIntroduced'}">
				<c:if test="${employe.userCode==loginInfo.employe.userCode} ">
				</c:if>
				<c:if test="${employe.userCode!=loginInfo.employe.userCode}">
					<input id="editemployee" type="button" class="btn1" onclick="editIntroduced('${employe.userCode}');" value="编辑"/>
					<input id="deleteemployee" type="button" class="btn1" onclick="deleteIntroduced('${employe.userCode}');" value="删除"/>
				</c:if>
			</c:if>
			<c:if test="${querytype=='findNoIntroduced'}">
			<input  type="button" class="btn1" onclick="editIntroduced('${employe.userCode}');" value="引入"/>
			</c:if>
			</td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="4" width="100%"  >
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
   			</table>
   			</td>
    </tr>
</table>
</div>    