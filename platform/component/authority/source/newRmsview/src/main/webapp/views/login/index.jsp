<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://mvc.one.sinosoft.com/tags/pipe" prefix="mvcpipe"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE jsp PUBLIC "-//W3C//DTD Xjsp 1.0 Transitional//EN" "http://www.w3.org/TR/xjsp1/DTD/xjsp1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xjsp">
<head>
<meta http-equiv="Content-Type" content="text/jsp; charset=utf-8" />
<title>无标题文档</title>
<link href="${ctx}/css/sinosoft.base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/sinosoft.layout.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/sinosoft.accordion.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="${ctx}/js/jquery-1.7.1.js"></script>
<script language="javascript" src="${ctx}/js/sinosoft.layout.js"></script>
<script language="javascript" src="${ctx}/js/sinosoft.accordion.js"></script>
<script type="text/javascript">
$(function(){
	<!--layout控件-->
	$("body").layout({
		top:{topHeight:68,topHide:false,topSwitch:false},
		left:{leftWidth:240,leftHide:false,leftSwitch:false}
	});
	<!--accordion控件-->
	$('#leftMenu').accordion({collapsible:true});
	leftBarH();
	$("#nav").find("a").bind("click",dMenu);
	$("#hideLeft").bind("click",leftOnOff);
	
	<!--iframe适应宽高-->
	myFrame();
	
	<!--弹性布局-检测窗口-->
	$(window).resize(function(){
		myFrame();
		leftBarH();
	});
});
function dMenu(){	
	var a = $(this);
	var ul = $(this).siblings("ul");
	var url = a.attr("href");
	var myfram = $("#pageContent");
	myfram.attr("src",url);
	if(ul.length > 0){
		ul.show();
		$("#nav").find("a").removeClass("select");
		a.addClass("select");
		a.parent().addClass("select");
		a.siblings("ul").find("a").addClass("sub")
	}else if($(this).hasClass('sub')){
		a.addClass("select");
		return false;
	}else{
		$("#nav").find("ul").hide();
		$("#nav").find("a").removeClass("select");
		a.addClass("select");
	};	
	return false;
};
function leftOnOff(){
	$.layout.leftOnOff();
	if($("#open").length > 0){
		$("#open").remove();
	}else{
		var lOpen = $("<div id='open'></div>");
		$("#layout_left").append(lOpen);
		lOpen
			.css({'width':$("#layout_left").width(),'height':$("#layout_left").height()})
			.bind("click",leftOnOff)
	};
	myFrame();
};
function leftBarH(){
	var barH = $("#layout_left").height() - 16;
	$("#layout_left").children(".left_bar").height(barH);
};
function myFrame(){
	var iframeW = $("#layout_center").width();
	var iframeH = $("#layout_center").height() - 42;
	$("#pageContent").width(iframeW).height(iframeH);
};
function changePass(e){
	var url = $(e).attr("href");	
	$("#pageContent").attr("src",url);
	return false;
};
function quit(){
	
}
</script>
</head>

<body>
<!--head-->
<div id="layout_top">
	<div class="header">
    	<img src="${ctx}/images/system/logo.gif" class="logo"  />
        <p class="user_bar">
        	用户：系统管理员
            <a href="changePass.jsp" class="pass" onclick="return  changePass(this)">修改密码</a>
            <a href="" onclick="quit();" class="quit">重新登录</a>
        </p>
    </div>
</div>

<!--左栏-->
<div id="layout_left">
	<div class="left_bar">
		<a href="javascript:;" class="left_hide" id="hideLeft">
        	<span>点击隐藏左侧菜单</span>
        </a>
        <!--左栏菜单-->
        <div id="leftMenu">
        	<h3><b class="ac_name">权限管理</b></h3>
            <div>
               <ul class="nav" id="nav">
					<c:forEach items="${menus}" var="menu" varStatus="status">
						<li><a href="<c:out value='${menu.url}'/>"><span><c:out value="${menu.name}" /></span></a>
							<ul>
								<c:forEach items="${menu.children}" var="children" varStatus="s">
									<li><a href="<c:out value='${children.url}'/>"><span><c:out value="${children.name}" /></span></a></li>
								</c:forEach>
							</ul>
						</li>
					</c:forEach>
              </ul>
            </div>        	
        </div>
	</div>
</div>

<!--内容-->
<div id="layout_center">
	<!--面包屑-->
	<div class="crumbs" id="crumbs">
    	权限管理 <span>角色管理</span>
    </div>
    <!--页面url-->
    <iframe id="pageContent" frameborder="0"></iframe>
</div>
</body>
</html>
