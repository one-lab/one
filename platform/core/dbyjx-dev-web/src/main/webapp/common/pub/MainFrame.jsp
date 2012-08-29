<%--
****************************************************************************
* DESC       ：车险理赔框架页面
* AUTHOR     ：weishixin
* CREATEDATE ：2004-03-02 
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html:html xhtml="true" locale="true">
    <head>
      <title>都邦意健险系统</title>
      <script language="javascript">
        
      </script>
      <html:base/>
    </head>
  <frameset rows="82,0,0,*" frameborder="no" border="1" framespacing="0">
    <frame name="fraTitle"  scrolling="no" noresize src="../pub/Title.jsp" >
    <frame name="fraCalculate"  scrolling="yes" noresize src="about:blank">
    <frame name="fraSubmit"  scrolling="yes" noresize src="about:blank" >
    <frameset name="fraSet" cols="180,*" frameborder="no" border="1" framespacing="0" rows="*">
        <!--  
	  <frame id="fraMenu" name="fraMenu" scrolling="auto" noresize marginwidth=0 marginheight=0 src="/claim/common/pub/LeftMenu.jsp">
      -->
     
      <frame id="leftFrame" name="leftFrame" scrolling="auto" src="../pub/Tree.jsp" >
      
      <frameset name="fraRight" rows="100%,0%,0%" frameborder="no" border="1" framespacing="0" rows="*">
        <!--modify by weishixin modify 20050227 start-->
        <!--reason:Unix要求大小写一致-->
        <frame id="fraInterface" name="fraInterface" scrolling="auto" src="../pub/Welcome.jsp">
        <!--modify by weishixin modify 20050227 end-->
        <frame id="fraNext" name="fraNext" scrolling="auto" src="about:blank">
        <frame id="fraCode" name="fraCode" scrolling="auto" noresize src=" ">
      </frameset>
    </frameset>
  </frameset>

  <noframes>
    <body bgcolor="#c1c1c1" text="#000000">
    </body>
  </noframes>

</html:html>