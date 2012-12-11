<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
</head>
<body >
<form id="fmpage" method="post"> 
         <div align="right">
                                  满足条件的记录为${page.totalCount} 条　
                                  第${page.currentPageNo}页/共${page.totalPageCount} 页　
             <c:choose>
                 <c:when test="${page == null || page.currentPageNo <= 1}">
                     <font color="#808080">首页</font>
                 </c:when>
                 <c:otherwise>
                     <a href="javascript:goCurrPage(1)"><u>首页</u></a>
                 </c:otherwise>
             </c:choose>

             <c:choose>
                 <c:when test="${null==page||page.currentPageNo<=1}">
                     <font color="#808080">前页</font>
                 </c:when>
                 <c:otherwise>
                     <a href="javascript:goCurrPage(${page.currentPageNo-1})"><u>前页</u></a>
                 </c:otherwise>
             </c:choose>

             <c:choose>
                 <c:when test="${null!=page&&page.currentPageNo < page.totalPageCount}">
                     <a href="javascript:goCurrPage(${page.currentPageNo+1})"><u>后页</u></a>
                 </c:when>
                 <c:otherwise>
                     <font color="#808080">后页</font>
                 </c:otherwise>
             </c:choose>

             <c:choose>
                 <c:when test="${null!=page&&page.currentPageNo != page.totalPageCount&&page.totalPageCount>0}">
                     <a href="javascript:goCurrPage(${page.totalPageCount})"><u>尾页</u></a>
                 </c:when>
                 <c:otherwise>
                     <font color="#808080">尾页</font>
                 </c:otherwise>
             </c:choose>

                                                  跳到<input type="text" id="changepage" name="changepage" size="2" class="common" style="width:3%"
                               maxlength="8" >页<a href='javascript:void(0)' onclick='return justPageExist($("#changepage").val(),${page.totalPageCount});goCurrPage($("#changepage").val());'>
                             <img src="${ctx}/images/bgGo.gif" width="20" height="15" border="0" align="middle"/></a>
                </div>
</form>
</body>
<script type="text/javascript">
function goCurrPage(page) {
	document.getElementById("pageNo").value = page;
	document.forms[0].submit();
}

//判断输入页码是否有效
function justPageExist(inputPage,totalPage){
	if(inputPage >totalPage || inputPage <= 0){
		alert("您输入的页码【"+inputPage+"】不存在，请重新输入！");
		$("#changepage").val("");
		return false;
	}
	return true;
}
</script>
</html>
