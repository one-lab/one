<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/global/ui/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<link type="text/css" rel="stylesheet" href="${ctx}/global/css/mis_basic.css">
	<title>电子商务管理系统-测试响应查询</title>
	<script src="${ctx}/global/js/My97DatePicker/WdatePicker.js"></script>
	<script src="${ctx}/global/js/jquery-1.6.2.min.js"></script>
</head>
<body topmargin="0" leftmargin="0">
	<div class="select_header_top_bg">
		<div class="select_header_top_left1"></div>
		<div class="select_header_top_left2"></div>
		<div class="select_header_top_title">
			<div class="select_header_top_title_content" style="width:180px;">套餐发布</div>
		</div>
		<div class="select_header_top_right1"></div>
		<div class="select_header_top_right2"></div>
	</div>
	<div class="table_content">
		<form id="frmInput" name="frmInput" action="${ctx}/combo/getDeployCombos.do" method="get" target="fraSearchList">
			<table class="table_style" align="center" width="98%">
			<tr>
					<td class="td_head td_head_center" width="120" nowrap>
						xxx：   
					</td>
					<td class="td_body">
						 
					</td>
					<td class="td_head td_head_center" width="120" nowrap>
						xxxx：
					</td>
					<td class="td_body">
						 
					</td>
				</tr>
			
				
				<tr height="60px;">
					<td colspan="4" align="right">
						<table>
							<tr>
								<td nowrap>
									<input type="hidden" name="pageNo" id="pageNo" value="1">
									<input type="hidden" name="pageSize" id="pageSize" value="20">
								</td>
								<td class="btnBigOnFocus"   nowrap><input type="submit" value="查询待发布套餐"></td>
								<td class="btnBigOnFocus" align="right" onclick="javascript:$('form')[0].reset();" nowrap>清空</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	
	  <script type="text/javascript">
	function doSearch(){
		window.parent.fraToolbar.document.getElementById("idStr").value = "";
		window.parent.fraToolbar.document.getElementById("count").value = "";
		document.getElementById("pageNo").value = 1;
		document.getElementById("frmInput").submit();
	}
</script>
	
</body>
</html>
