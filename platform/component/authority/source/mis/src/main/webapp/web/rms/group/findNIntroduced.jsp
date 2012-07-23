<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglibs.jsp" %>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/dhtmlxtree.css"/>
<script type="text/javascript" language="script" src = '${ctx }/js/jquery-1.6.4.js'>
</script>
<div align="left" style="" >
	<table style="width: 100%;" border="0">
		<tr>
			<td>用户代码:<input id="NintrUserCode"
				name="employe.userCode" /></td>
			<td>用户名:<input id="NintrUserName"
			name="employe.userName" /></td>
			<td colspan="2"><input style="margin-left: 20px;" class="btn1"
			type="button" onclick="findNIntroduced();" value="查询" /></td>
		</tr>

	</table>
<table  style="width: 380px;" border="0" cellpadding="0" cellspacing="0" class="table3" >
		<tr >
			<td style="width:25px;" class="td1" >&nbsp;</td>
			<td style="width:62px;"  class="td1"  >用户代码</td>
			<td style="width:62px;"  class="td1"   >用户名</td>
			<td style="width:62px;"  class="td1"  >&nbsp;</td>
		</tr>
	<c:forEach var="employe" items="${employes}"
		varStatus="status">
			<tr>
				<td style="width: 25px;" class="td5"  >${status.index + 1}</td>
				<td style="width: 62px;" class="td5"   >${employe.userCode}</td>
				<td style="width: 62px;" class="td5"   > ${employe.userName} </td>
				<td style="width: 62px;"  class="td5"  >
				<input  type="button" class="btn1" onclick="addGroupUser('${employe.userCode}');" value="引入"/>
				</td>
			</tr>
	</c:forEach>
		<tr>
			<td colspan="4" width="100%"  >
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td  height="30" valign="top">每页
                      <input type="hidden" name="NIntrpageNo" id="NIntrpageNo" value="${pageNo}" /> 
                      <input name="pageSize" type="hidden"  class="input1" value="${pageSize}" disabled="disabled">${pageSize}&nbsp;条记录&nbsp;&nbsp;&nbsp;
                      <s:if test="page.currentPageNo!=1">
                      <a href="javascript:NIntrcurrPage('1');" id="first">首页</a> 
                      <a href="javascript:NIntrcurrPage('<s:property value="page.currentPageNo-1"/>');" id="prev">上一页</a>
                       </s:if> <s:if test="page.currentPageNo!=page.totalPageCount">
                      <a href="javascript:NIntrcurrPage('<s:property value="page.currentPageNo+1"/>');" id="next">下一页</a> 
                      <a href="javascript:NIntrcurrPage('<s:property value="page.totalPageCount"/>');" id="end">末页</a> </s:if> &nbsp;&nbsp;&nbsp;共：${page.totalPageCount}页 &nbsp;第${pageNo} 页
                    </td>
                  </tr>
   			</table>
   			</td>
    </tr>
</table>
</div>    