<html>
    <head>
        <title>Untitled Document</title>
        <%@include file="/common/taglibs.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <Script type="text/javascript" Language="JavaScript">
   function setFramesWidth(srcObj)
    {
      if (srcObj.src.indexOf("btn_expand.gif")>0)
         {
           top.main2.cols="17,*";
           srcObj.src=contextRootPath+"/images/btn_hide.gif";
           srcObj.width="17";
           srcObj.height="36";
 
                       
         }
      else
         {
           top.main2.cols="181,*";
           srcObj.src=contextRootPath+"/images/btn_expand.gif";
           srcObj.width="181";
           srcObj.height="36";
 
         }
    }
</Script>

    </head>

    <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
        <img src="${ctx}/images/btn_expand.gif" width="181" height="36" border="0"
            onClick=" JavaScript:setFramesWidth(this);" style="cursor: hand">
    </body>
</html>