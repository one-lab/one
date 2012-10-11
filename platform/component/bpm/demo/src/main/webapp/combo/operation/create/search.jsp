<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/global/ui/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="${ctx}/global/css/mis_basic.css" rel="stylesheet" type="text/css">
	<script src="${ctx}/global/js/My97DatePicker/WdatePicker.js"></script>
	<script src="${ctx}/global/js/jquery-1.6.2.min.js"></script>
</head>
<body topmargin="2" leftmargin="2">
	<table width="100%" class="table_Show" id="data_table">
	<tr>
		<td class="td_head" width="30" nowrap><input type="checkbox" onclick="checkAll(this)"></td>
		<td class="td_head" nowrap id="idNum">序号</td>
		<td class="td_head" nowrap>url名称</td>
		<td class="td_head" nowrap>url地址</td>
		<td class="td_head" nowrap>阀值(毫秒)</td>
		<td class="td_head" nowrap>开始日期</td>
		<td class="td_head" nowrap>结束日期</td>
		<td class="td_head" nowrap>监控状态</td>
		<td class="td_head" nowrap>最高值(毫秒)</td>
		<td class="td_head" nowrap>平均值(毫秒)</td>
		<td class="td_head" nowrap>请求次数</td>
		<td class="td_head" nowrap>超过阀值次数</td>
	</tr>
	<s:iterator value="page.result" var="model" status="stu"  >
		<tr id="tr_${stu.index}">
			<td class="td_body_center" nowrap>
				<input type="checkbox" name="checkChild" id="check${stu.index}" onclick="checkSingleRow();" value="${model.serialNo}">
			</td>
			<td class="td_body_center" nowrap>${stu.index+1+page.pageSize*(page.currentPageNo-1)}</td>
			<td class="td_body_center" nowrap>${model.title}</td>
			<td class="td_body_center" nowrap>${model.url}</td>
			<td class="td_body_center" nowrap>${model.threshold}</td>
			<td class="td_body_center" nowrap><s:date name="#model.startDate" format="yyyy-MM-dd HH:mm:ss" /></td>
			<td class="td_body_center" nowrap><s:date name="#model.endDate" format="yyyy-MM-dd HH:mm:ss" /></td>
			<td class="td_body_center" nowrap><c:if test="${model.status!=1}">已关闭</c:if>
			<c:if test="${model.status==1}">已开启</c:if>
			</td>
			<td class="td_body_center" nowrap>${model.highestvalue}</td>
			<td class="td_body_center" nowrap>${model.averagevalue}</td>
			<td class="td_body_center" nowrap>${model.requestcount}</td>
			<td class="td_body_center" nowrap>${model.overcount}</td>
		</tr>
	</s:iterator>
	</table>
</body>
<script type="text/javascript">
function editAndSave(index){
	var button=$("#button_"+index);
	if(button.attr("buttonVal")=="0"){
		//$("input[name$='_"+index+"']").removeAttr("readonly");
		button.val("保存").attr("buttonVal","1");
	}else{
		//$("input[name$='_"+index+"']").attr("readonly");
		button.val("编辑").attr("buttonVal","0");
	}
	
}
</script>
<script type="text/javascript">
window.parent.frames[3].document.location.href = "${ctx}/global/inc/page.jsp?pageNo=${page.currentPageNo}&pageSize=${page.pageSize}&totalCount=${page.totalCount}&totalPage=${page.totalPageCount}";
</script>
<script type="text/javascript" src="${ctx}/global/js/checkRows.js"></script>
</html>
