<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>创建新的邮件动作</title>
<link href="${ctx}/static/css/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/css/sinosoft.message.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/css/bussiness.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="${ctx}/static/js/jquery-1.7.1.js"></script>
<script language="javascript" src="${ctx}/static/js/sinosoft.layout.js"></script>
<script language="javascript" src="${ctx}/static/js/sinosoft.message.js"></script>
<script type="text/javascript">
$(function(){
	$("body").layout({
		top:{topHeight:100},
		bottom:{bottomHeight:30}
	});
	$("#myDesk").height($("#layout_center").height());
	$("#nav").delegate('li', 'mouseover mouseout', navHover);
	$("#nav,#menu").delegate('li', 'click', navClick);
});
function navHover(){
	$(this).toggleClass("hover")
}
$(this).ready(function(){
        $("input[@type=radio][name=mailFormat][@value=1]").attr("checked",true);
});
function navClick(){
	$(this).addClass("seleck").siblings().removeClass("seleck");
	if($(this).hasClass('has_sub')){
		var subMav = $(this).children("ul.add_sub_menu");
		var isAdd = false;
		if($(this).parent().attr("id") == "menu"){
			isAdd = true;
		};
		subMav.slideDown('fast',function(){
			$(document).bind('click',{dom:subMav,add:isAdd},hideNav);
			return false;
		});		
	};
}
function hideNav(e){
	var subMenu = e.data.dom;
	var isAdd = e.data.add;
	subMenu.slideUp('fast',function(){
		if(isAdd){
			subMenu.parent().removeClass('seleck');
		};
	});	
	$(document).unbind();
}
function save(){
	msgSuccess("系统消息", "操作成功，监视器已保存！");
}
function rowsTogle(){
	var rows = $("#threshold tr.hideRows");
	if(rows.eq(0).is(':hidden')){
		rows.show();
	}else{
		rows.hide();
	};
	return false;
}
</script>
</head>

<body>
<%@include file="/WEB-INF/layouts/menu.jsp"%>
<div id="layout_center">
	<div class="main">
    	<div class="add_monitor">
       	  <h2 class="title-mail"><b>创建动作: 发送EMAIL 　</b></h2>
          <form action="${ctx}/action/email/save" method="post" id="emailForm">
          <table width="100%" border="0" cellspacing="0" cellpadding="0" class="add_monitor_box2 add_form threshold" id="threshold">
              <input type="hidden" name="id" value="${mail.id}">
              <tr>
                <td width="20%">显示名<span class="mandatory">*</span></td>
                <td colspan="2"><input type="text" class="formtext" size="45" name="name" value="${mail.name}"/></td>
              </tr>
              <tr>
                <td width="20%">发件人地址<span class="mandatory">*</span></td>
                <td colspan="2"><input type="text" class="formtext" size="45" name="fromAddress" value="${mail.fromAddress }"/></td>
              </tr>
              <tr>
                <td width="20%">收件人地址<span class="mandatory">*</span></td>
                <td colspan="2"><input type="text" class="formtext" size="45" name="toAddress" value="${mail.toAddress}"/></td>
              </tr>
               <tr>
                <td width="20%">主题<span class="mandatory">*</span></td>
                <td colspan="2"><input type="text" class="formtext" size="45"  value="${mail.subject }" name="subject"/></td>
              </tr>
               <tr>
                <td width="20%">消息<span class="mandatory">*</span></td>
                <td colspan="2"><textarea class="formtext"   style="height:150px; width:270px" name="content">${mail.content}</textarea></td>
              </tr>
               <tr>
                <td width="20%">经由</td>
                <td colspan="2"><input type="radio" value="1" name="mailFormat"/>&nbsp;&nbsp;&nbsp;纯文本&nbsp;&nbsp;&nbsp;<input type="radio"  value="2"  name="mailFormat"/>&nbsp;&nbsp;&nbsp;HTML<input type="radio" name="mailFormat" checked="checked" value="3"/>&nbsp;&nbsp;&nbsp;两者</td>
              </tr>
                    <tr>
                <td > <label for="senior">添加告警消息</label></td><td><input class="checkbox1" name="senior" type="checkbox" value="" class="m_b"  id="senior" /></td>
                <td colspan="2"></td>
              </tr>
              <tr>
                <td > <label for="senior">在选择的小时内执行动作</label></td><td><input class="checkbox1" name="senior" type="checkbox" value="" class="m_b"  onclick="rowsTogle()" id="senior" /></td>
                <td colspan="2"></td>
              </tr>
               <tr  class="hideRows">
                <td width="20%">选择时间窗口<span class="mandatory">*</span></td>
                <td colspan="2"><select name="select2" class="diySelect" style="font-family:Arial, Helvetica, sans-serif;width:130px">
                  <option selected="selected">--选择工作时间--</option>
                </select>&nbsp;&nbsp;<a class="message-time" href="#">添加新的工作时间</a></td>
              </tr>
              <tr>
                <td class="group_name">&nbsp;</td>
                <td colspan="2" class="group_name">
                	<input type="submit" class="buttons" value="创建动作" />　
                    <input type="reset" class="buttons" value="恢复缺省值" />　
                    <input type="button" class="buttons" value="取 消" onclick="window.history.back()" />
                </td>
              </tr>
            </table>
            </form>
        </div>
    </div>
</div>
<div id="layout_bottom">
	<p class="footer">Copyright &copy; 2013 Sinosoft Co.,Lt</p>
</div>
</body>
</html>
