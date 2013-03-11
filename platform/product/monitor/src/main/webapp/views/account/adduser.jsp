<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>新建用户</title>
<link href="${ctx}/static/css/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/css/sinosoft.message.css" rel="stylesheet" type="text/css" />
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
</script>
</head>

<body>
<%@include file="/WEB-INF/layouts/menu.jsp"%>
<div id="layout_center">
	<div class="main">
    	<div class="add_monitor user_manager">
       	  <h2 class="title2"><strong class="right"><a href="userManager.html">返回用户列表</a></strong><b>创建新用户　</b>
          </h2>
          <form action="${ctx}/account/user/save" method="post">
          <table width="100%" border="0" cellspacing="0" cellpadding="0" class="add_monitor_box add_form">
              <input type="hidden" name="id" value="${user.id }"/>
              <tr>
                <td colspan="2" class="group_name">基本信息</td>
              </tr>
              <tr>
                <td width="25%">姓名<span class="mandatory">*</span></td>
                <td><input name="name" value="${user.name }" type="text" class="formtext" /></td>
              </tr>
              <tr>
                <td>手机号<span class="mandatory">*</span></td>
                <td><input name="phone" type="text" class="formtext" value="${user.phone }"/></td>
              </tr>
              <tr>
                <td>邮箱<span class="mandatory">*</span></td>
                <td><input name="email" type="text" class="formtext" value="${user.email }" /></td>
              </tr>
              <tr>
                <td colspan="2" class="group_name">账户信息</td>
              </tr>
              <tr>
                <td>用户名<span class="mandatory">*</span></td>
                <td><input name="loginName" type="text" class="formtext" value="${user.loginName }" /></td>
              </tr>
              <tr>
                <td>密码<span class="mandatory">*</span></td>
                <td><input name="password" type="password" class="formtext" value="${user.password }"/></td>
              </tr>
              <tr>
                <td>状态<span class="mandatory">*</span></td>
                <td><input name="status" type="radio" value="1" ${user.status eq "1"  ? "checked='checked'" : ''} />
                <label for="status">正常</label>
                　			<input type="radio" name="status" value="0"  ${user.status eq "0"  ? "checked='checked'" : ''} />
                <label for="status">锁定</label></td>
                
              </tr>
              <tr>
                <td class="group_name">&nbsp;</td>
                <td class="group_name">
                	<input type="submit" class="buttons" value="确定添加" />　
                    <input type="reset" class="buttons" value="重 置" />　
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
