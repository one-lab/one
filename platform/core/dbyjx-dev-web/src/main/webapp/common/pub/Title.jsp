<%--
****************************************************************************
* DESC       ：车险理赔TITLE页面
* AUTHOR     ：lixiang
* CREATEDATE ：2004-03-23
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="javax.servlet.http.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>

<%
      //User user = (User)session.getAttribute("user");
      //String userName = user.getUserCode();
%>

<html:html>
    <head>
        <app:css />
    <link rel="stylesheet" type="text/css" href="../css/Standard.css">

   <script language="JavaScript" type="text/javascript" src="${ctx}/common/js/leftMenu.js"></script>
    </head>

  <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="60%" background="${ctx}/images/BgVisaTop.gif"><img src="${ctx}/images/Logo.gif"><img src="${ctx}/images/ImgClaimFlowSystem.gif"></td>
    <td width="15%" background="${ctx}/images/BgVisaTop.gif" class=common align=right> <span id="spanUserName"><img src="${ctx}/images/ImgIcon_1.gif" align="middle" > <%=111%></span></td>
    <td width="15%" background="${ctx}/images/BgVisaTop.gif" class=common align=right> <span id="spanUserName"><img src="${ctx}/images/ImgIcon_1.gif" align="middle" > </span><span id="spanProjectName">当前项目</span> </td>
    <td width="10%" background="${ctx}/images/BgVisaTop.gif" class=common align=center> <span id="spanUserName"><img src="${ctx}/images/ImgIcon_1.gif" align="middle" > </span>
    <span id="spanDate"><%=new SimpleDateFormat("yyyy年MM月dd日").format(new Date())%></span>
    </td>
  </tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="18%" align=center background="${ctx}/images/bgTitle2.gif"><img src="${ctx}/images/cpClaimTitleHidden.gif" align="middle" onclick="menuSwitch(this)"  style="CURSOR:hand"></td>
    <td width="52%" background="${ctx}/images/bgTitle2.gif" class=white><img src="${ctx}/images/ImgPlace.gif" align="middle"><span id="command"></span></td>
    <td width=30% class=common height=26 align=center background="${ctx}/images/bgTitle2.gif"></td>
  </tr>
</table>
</body>
</html:html>
