<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<frameset id="fraTop" rows="100,*,60" border="0" frameborder="no" framespacing="0">
	<frame name="fraSearchForm" src="${ctx}/product/pddefine/baseinfodefine/pdbasequery_frmSearch.jsp" frameborder="0" scrolling="no" noresize></frame>
	<frame name="fraSearchList" src="${ctx}/common/pub/emptyTable.jsp" scrolling="auto" noresize id="fraSearchList"></frame>
	<frame id="frapage" name="frapage" src="${ctx}/common/pub/page.jsp" frameborder="0" scrolling="no" noresize></frame>
</frameset>