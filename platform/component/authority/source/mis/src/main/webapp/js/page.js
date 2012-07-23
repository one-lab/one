/*
 ****************************************************************************
 * DESC       ：分页脚本
 * MODIFYLIST ：  Name       Date            Reason/Contents
 *          ------------------------------------------------------
 */

/**
 @author      
 @description 分页判断
 @param       page当前页号
 @return      无
 */

function currPage(page) {
	document.getElementById("pageNo").value = page;
	document.forms[0].submit();
}

/**
 @author      
 @description 前一页
 @param       page当前页号
 @return      无
 */
function PrePage(page) {
	currPage(page - 1);
}

/**
 @author      
 @description 后一页
 @param       page当前页号
 @return      无
 */

function NextPage(page) {
	currPage(page - (-1));
}

/**
 @author      
 @description 跳到任意页
 @param       无
 @return      无
 */

function ChangePage() {
	var page = document.getElementById("pageNo").value;
	if (isNaN(page)) {
		page = 1;
	}
	currPage(page);
}

function checkMaxNo(obj) {
	if (document.getElementById("totalPageCount").value > 0)
		checkInteger(obj, 1, document.getElementById("totalPageCount").value);
	else
		checkInteger(obj, 0, document.getElementById("totalPageCount").value);
}
