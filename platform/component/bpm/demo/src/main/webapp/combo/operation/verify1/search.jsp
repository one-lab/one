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
		<td class="td_head" nowrap>套餐代码</td>
		<td class="td_head" nowrap>套餐包含的一个险别代码</td>
		<td class="td_head" nowrap>套餐包含的一个险别名称</td>
		<td class="td_head" nowrap>操作</td>
	</tr>
	<s:iterator value="page.result" var="model" status="stu"  >
		<tr id="tr_${stu.index}">
		 
			<td class="td_body_center" nowrap>
				<input type="checkbox" name="checkChild" id="check${stu.index}" onclick="checkSingleRow();transferComboCode('${stu.index}');" value="${stu.index}">
			</td>
			<td class="td_body_center" nowrap id="comboCode${stu.index}">${model.comboCode}</td>
			<td class="td_body_center" nowrap>${model.kind.kindCode}</td>
			<td class="td_body_center" nowrap>${model.kind.kindName}</td>
		</tr>
	</s:iterator>
	</table>
	<input type="hidden" name="comboToProcess" id="comboToProcess">
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
function transferComboCode(index){
	var a=$("#comboCode"+index).html();
	$("#comboToProcess").val(a);
	
}
</script>
<script type="text/javascript">
window.parent.frames[3].document.location.href = "${ctx}/global/inc/page.jsp?pageNo=${page.currentPageNo}&pageSize=${page.pageSize}&totalCount=${page.totalCount}&totalPage=${page.totalPageCount}";
</script>
<script type="text/javascript" src="${ctx}/global/js/checkRows.js"></script>
</html>
