<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/global/ui/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link type="text/css" rel="stylesheet" href="${ctx }/global/css/mis_basic.css">
</head>
<body style="border-top: 1px solid #a1a29c;">
	<div id="page" align="center">
		<a href="#" id="tdFirst" name="tdFirst" onClick="goFirst();return false;">首页</a>
		<a href="#" id="tdPrevious" name="tdPrevious" onClick="goNext(this,-1);return false;">上页</a>
		<a href="#" id="tdNext" name="tdNext" onClick="goNext(this,1);return false;">下页</a>
		<a href="#" id="tdEnd" name="tdEnd" onClick="goEnd();return false;">尾页</a>
		<span style="width:5px;"></span>
		<span id="spselect">
			${!empty param.totalPage?"跳转至":""}
			<c:if test="${!empty param.totalPage}">
				<select id='allPage' name='allPage' onchange='javascript:goSearch(this.selectedIndex + 1)'>
					<c:forEach  begin="1" end="${param.totalPage}" step="1" varStatus="status">
				 		<option value="${status.index}" ${status.index == param.pageNo?"selected":""}>${status.index}</option>
					</c:forEach>
				</select>
			</c:if>
		</span>
		<span id="spinfo"></span>
		<span>&nbsp;&nbsp;每页显示
			<select id="pageSize" name="pageSize" onchange="goSearchByPageSize();">
				<option value="10">10</option>
				<option value="20" selected>20</option>
				<option value="50">50</option>
			</select>条
		</span>
	</div>
</body>
<script type="text/javascript">
	var frmSearch = window.parent.frames[0];
	var search = window.parent.frames[2];
	var pageSize = 0;
	var pageNo = 0;
	var totalCount = 0;
	var totalPage = 0;
	if("${param.pageSize}" != ""){
		pageNo = ${empty param.pageNo ? 0 : param.pageNo};
		pageSize = ${empty param.pageSize ? 0 : param.pageSize};
		totalCount = ${empty param.totalCount ? 0 : param.totalCount};
		totalPage = ${empty param.totalPage ? 0 : param.totalPage};
	}
	//设定本页的按钮显示
	function setPageAndButton(){
		if(totalPage > 1 && pageNo == 1){
			//有多页，当前显示第一页
			buttonDisabled(true, true, false, false);
		}else if(totalPage > 1 && pageNo == totalPage){
			//有多页，当前显示最后一页
			buttonDisabled(false, false, true, true);
		}else if(totalPage > 1 && pageNo > 1 && pageNo < totalPage){
			//有多页，当前显示既不是第一页，也不是最后一页
			buttonDisabled(false, false, false, false);
		}else{
			//其他
			buttonDisabled(true, true, true, true);
		}
	}
	
	function buttonDisabled(x1, x2, x3, x4){
		showDisabled("tdFirst",x1);
		showDisabled("tdPrevious",x2);
		showDisabled("tdNext",x3);
		showDisabled("tdEnd",x4);
	}
	
	function showDisabled(id,disabled){
		var obj = document.getElementById(id);
		if(disabled){
			obj.style.color = "gray";
			obj.onclick = null;
		}else{
			obj.style.color = "";
		}
	}
	
	function goFirst(){
		if(!document.all('tdFirst').disabled){
			goSearch(1);
		}
	}
	
	function goNext(tda,x){
		if(!tda.disabled){
			goSearch(Number(pageNo) + Number(x));
		}
	}
	
	function goEnd(){
		if(!document.all('tdEnd').disabled){
			goSearch(totalPage);
		}
	}
	
	function goSearchByPageSize(){
		pageNo = 1;
		goSearch(pageNo);
	}
	
	function goSearch(x) {
		frmSearch.document.getElementById("pageNo").value = x;
		frmSearch.document.getElementById("pageSize").value = document.getElementById("pageSize").value;
		frmSearch.document.getElementById("frmInput").submit();
		buttonDisabled(true, true, true, true);
	}

	//查询条数显示
	function createText(){
		if(pageNo == null || pageNo == "") {
			return;
		}
		var span = document.getElementById("spinfo");
		var sinfo = "&nbsp;&nbsp;共" + totalCount +"条&nbsp;&nbsp;第" + pageNo + "/" + totalPage + "页";
		span.innerHTML = sinfo;
	}
	
	function setPageSize() {
		var obj = document.getElementById("pageSize");
		if(pageSize == 10) {
			obj.selectedIndex = 0;
		} else if(pageSize == 50) {
			obj.selectedIndex = 2;
		} else {
			obj.selectedIndex = 1;
		}
	}
	setPageAndButton();
	createText();
	setPageSize();
</script>
</html>
