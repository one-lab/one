<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/global/ui/taglibs.jsp"%>

<html>
<head>
<link type="text/css" rel="stylesheet" href="${ctx}/global/css/mis_basic.css">
<link type="text/css" rel="stylesheet" href="${ctx}/global/js/validate/css/validate.css" />
<script type="text/javascript" src="${ctx}/global/js/validate/talent-validate-all-min.js" charset="utf-8"></script>

<script language="javascript" type="text/javascript"
	src="${ctx}/global/js/jquery-1.6.2.min.js"></script>
<script src="${ctx}/global/js/My97DatePicker/WdatePicker.js"></script>
<!-- 
<script language="javascript" type="text/javascript"
	src="${ctx}/response/response.js"></script>   -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>套餐审核一</title>
</head>
<body  onload="pageValidate();">
<div id="header_titleDIV">
	<div class="header_title_c">
		<div class="header_title">
			套餐审核一
		</div>
	</div>
	<div class="header_title_gap1"></div>
</div>
<div class="table_content">
	<div style="clear: both;"></div>
<form action="${ctx}/combo/verifyCombo1.do" method="post"
	id="responseUpdate">
<table class="table_style" align="center" width="98%">
	<tr>
		<td class="td_head td_head_center"  width="10%"  nowrap>套餐序号</td>
		<td class="td_body" width="15%" ><input name="combo.no" id="title"
			value="<s:property value="combo.no"/>" /></td>
	</tr>
	<tr>
		<td class="td_head td_head_center"  width="10%"  nowrap>套餐代码</td>
		<td class="td_body" width="15%"  ><input name="combo.comboCode" id="url"
			value="<s:property value="combo.comboCode"/>" /></td>
	</tr>
	<tr>
		<td class="td_head td_head_center"  width="10%"  nowrap>套餐中的一个险别代码</td>
		<td class="td_body" width="15%" ><input name="combo.kind.kindCode" id="threshold"
			value="<s:property value="combo.kind.kindCode"/>" /></td>
	</tr>
	<tr>
		<td class="td_head td_head_center"  width="10%"  nowrap>套餐中的一个险别代码</td>
		<td class="td_body" width="15%" ><input name="combo.kind.kindName" id="threshold"
			value="<s:property value="combo.kind.kindName"/>" /></td>
	</tr>
	 
	 
	<tr height="60px;">
					<td colspan="8" align="right">
						<table>
							<tr>
								
								<td  class="btnBigOnFocus" onclick="submitUpdate();" nowrap>通过</td>
							</tr>
						</table>
					</td>
				</tr>
	
</table>


</form>
</div>
<script type="text/javascript">

function pageValidate(){
	tt.vf.req.addName("geMonitorResponse.title","geMonitorResponse.url","geMonitorResponse.threshold","geMonitorResponse.status",
			"geMonitorResponse.startDate","geMonitorResponse.endDate");
	tt.vf.num.add("geMonitorResponse.threshold");
	new tt.NRV().set(0, '++').add("geMonitorResponse.threshold");
}

	function submitUpdate() {
		
		if(tt.validate()){
			$("#responseUpdate").submit();
		}
	}
</script>
</body>
</html>
