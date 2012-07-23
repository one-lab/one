<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>信息管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/common/taglibs.jsp" %>
<link href="${ctx}/css/dtree.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="script" src="${ctx}/js/jquery-1.6.4.js"></script>
<script type="text/javascript" language="javascript">
var task= [];
<c:forEach  items="${session.geRmsTasks }" var="task">
  //task.push({'id':${task.taskID},'parentId':${empty task.parent.taskID ? '0' : task.parent.taskID},'menuName':'${task.menuName}','menuURL':'${task.menuURL}'});    
   // d.add(${task.taskID},${empty task.parent.taskID ? '0' : task.parent.taskID},'${task.menuName}','${task.menuURL}','','main');
</c:forEach>
if(window.parent != window){
	window.parent.location.href = window.location.href;	
}
</script>
</head>
<FRAMESET id="frm1" name="frm1" border="0" frameBorder="0" frameSpacing="0" rows=85,100%">
		
        <FRAME name="header" noResize scrolling="no" src="${ctx}/common/header.jsp"></FRAME>
        <frameset cols="181,100%" name="main2" id = "main2" border="0" frameBorder="0" frameSpacing="0"  noresize="noresize">
        <frameset rows="36,*" border="0" frameBorder="0" frameSpacing="0"  noresize="noresize">
         <frame name="titlename" target="main" src="${ctx }/web/systitle.jsp" scrolling="no"  noresize="noresize" />
         <frame name="right" target="main" src="${ctx }/web/menu.jsp" scrolling="yes" noresize="noresize" />
        </frameset>
        <frame name="main" src="${ctx }/web/welcome.jsp" scrolling="auto"></frame>
        </frameset>
        <NOFRAMES>
            <p id="p1">
                此 HTML 框架集显示多个 Web 页。若要查看此框架集，请使用支持 HTML 4.0 及更高版本的 Web 浏览器。
            </p>
        </NOFRAMES>
    </FRAMESET>
</html>