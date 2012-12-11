<%@ page contentType="text/html; charset=GBK" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
	<link rel="STYLESHEET" type="text/css" href="../css/dhtmlxtree.css">
	<script  src="${ctx}/common/js/dhtmlxcommon.js"></script>
	<script  src="${ctx}/common/js/dhtmlxtree.js"></script>
	<script  src="${ctx}/common/js/dhtmlxtree_json.js"></script>
    <link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
    <script type="text/javascript">
	    
	    function showTree(){
	    	var url = "${ctx}/userPower/showTree";
	    	var params={};
	    	function callback(obj){
	    		tree = new dhtmlXTreeObject("treeboxbox_tree", "100%", "100%", 0);
		    	tree.setSkin('dhx_skyblue');
		    	tree.setImagePath("${ctx}/common/imgs/csh_bluebooks/");
		    	tree.setDataMode("json");
		    	tree.loadJSONObject(obj);
			    tree.setOnClickHandler(TestOnClick);
	    	}
	    	jQuery.post(url,params,callback,"json");
	    }
	    function TestOnClick(id){
	        var url = (tree.getUserData(id, "url"));
	        if(url == '"null"' || url == ""){
	        	
	        }else{	  
	        	parent.fraInterface.location.href="../../"+url;
	        }
	    }
    </script>
    
</head>
<body bgcolor="EFF1FE" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="showTree();">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td > 
    	<table width="180" height="100%" border="0" cellpadding="0" cellspacing="0">
        	<tr>
          		<td width="180" height="100%" class="menu">
          		<div id="treeboxbox_tree"></div>
          		</td>
        	</tr>
      	</table>
    </td>
  </tr>
</table>
</body>
</html>