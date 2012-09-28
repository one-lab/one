<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/common/taglibs.jsp" %>
<%@ page import="java.util.*"%>

<html>
<head>
<base target="_self">
<title>请选择</title>
<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
<script language='javascript'> 
	//页面加载时，自动查询
    function loadPage(){
    	var url = "${ctx}/platform/queryCode.do";
    	var parentWindow = window.dialogArguments;
    	var obj = parentWindow.obj;
    
    	//将父页面的值保存在子页面
    	$("#selfId").val(obj.selfId);
    	$("#relationId").val(obj.relationId);
    	$("#methodType").val(obj.methodType);
    	$("#paramsByJSON").val(obj.paramsByJSON);
    	function callback(obj){
    		$("#codeselect").html("");
			var optionStr = "";
			for(var i = 0 ; i < obj.data.length ; i++){
				optionStr += "<option value = '"+obj.data[i].codeValue+"'>"+obj.data[i].codeValue+"--"+obj.data[i].codeLabel+"</option>"; 

			}
			$("#codeselect").html(optionStr);
			$("#count").val(obj.totalRecords);
			$("#pageSize").val(obj.recordsReturned);
			$("#pageNo").val(1);
			$("#resultCount").val(obj.recordsReturned);
			lastPageNum = Math.ceil(Number($("#count").val())/Number($("#resultCount").val()));
    	}
    	var params = {
    		selfId : obj.selfId,
    		relationId : obj.relationId,
    		methodType : obj.methodType,
    		params : obj.paramsByJSON
    	};
    	jQuery.post(url,params,callback,'json');
    }
	//设置文本框的值
    function setFieldValue(){
		if($("#codeselect option:selected").val() == null){
			alert("你没有选择一项，请选择！");
		}else{
	    	var value = $("#codeselect option:selected").val();
	    	var label = $("#codeselect option:selected").text();
			var str = new String(label);
			var array = str.split('--');
			
			var selfId = $("#selfId").val();
			var relationId = $("#relationId").val();
	
			var parentWindow = window.dialogArguments;
			parentWindow.document.getElementById(selfId).value = value;
			parentWindow.document.getElementById(relationId).value = array[1];
			//为了后续想要执行父页面方法提出callback方法
			window.close();
			try {
				if(typeof(eval(parentWindow.sonCallbackFather))=="function"){
	        		parentWindow.sonCallbackFather(selfId,relationId);
	        	}
	        }catch(e){
	      
	        }
		}
    }
    //取消文本框的值
    function cancelFieldValue(){
    	var selfId = $("#selfId").val();
		var relationId = $("#relationId").val();
		var parentWindow = window.dialogArguments;
		parentWindow.document.getElementById(selfId).value = '';
		parentWindow.document.getElementById(relationId).value = '';
		window.close();
    }
    //首页
    function fistPage(){
    	var url = "${ctx}/platform/queryCode.do";
    	var params = {
       		selfId :$("#selfId").val(),
       		relationId : $("#relationId").val(),
       		methodType : $("#methodType").val(),
       		params : $("#paramsByJSON").val(),
       		pageNo : 1,
       		pageSize : $("#resultCount").val()
       	};
    	function callback(obj){
    		$("#codeselect").html("");
			var optionStr = "";
			for(var i = 0 ; i < obj.data.length ; i++){
				optionStr += "<option value = '"+obj.data[i].codeValue+"'>"+obj.data[i].codeValue+"--"+obj.data[i].codeLabel+"</option>"; 
			}
			$("#codeselect").html(optionStr);
			$("#count").val(obj.totalRecords);
			$("#pageNo").val(1);
			$("#pageSize").val($("#resultCount").val());
    	}
    	jQuery.post(url,params,callback,'json');
    }
    //上一页
    function upPage(){
    	var url = "${ctx}/platform/queryCode.do";
    	var params = {
   			selfId :$("#selfId").val(),
       		relationId : $("#relationId").val(),
       		methodType : $("#methodType").val(),
       		params : $("#paramsByJSON").val(),
       		pageNo : (Number($("#pageNo").val()) == 1) ? 1 :  Number($("#pageNo").val())-1,
       		pageSize : $("#resultCount").val()
       	};
    	function callback(obj){
    		$("#codeselect").html("");
			var optionStr = "";
			for(var i = 0 ; i < obj.data.length ; i++){
				optionStr += "<option value = '"+obj.data[i].codeValue+"'>"+obj.data[i].codeValue+"--"+obj.data[i].codeLabel+"</option>"; 
			}
			$("#codeselect").html(optionStr);
			$("#count").val(obj.totalRecords);
			$("#pageNo").val((Number($("#pageNo").val()) == 1) ? 1 : Number($("#pageNo").val())-1);
			$("#pageSize").val($("#resultCount").val());
    	}
    	jQuery.post(url,params,callback,'json');
    }
    //下一页
    function nextPage(){
    	var url = "${ctx}/platform/queryCode.do";
    	var params = {
			selfId :$("#selfId").val(),
       		relationId : $("#relationId").val(),
       		methodType : $("#methodType").val(),
       		params : $("#paramsByJSON").val(),
       		pageNo : (Number($("#pageNo").val()) == lastPageNum ) ? lastPageNum : Number($("#pageNo").val())+1,
       		pageSize : $("#resultCount").val()
       	};
    	function callback(obj){
    		$("#codeselect").html("");
			var optionStr = "";
			for(var i = 0 ; i < obj.data.length ; i++){
				optionStr += "<option value = '"+obj.data[i].codeValue+"'>"+obj.data[i].codeValue+"--"+obj.data[i].codeLabel+"</option>"; 
			}
			$("#codeselect").html(optionStr);
			$("#count").val(obj.totalRecords);
			$("#pageNo").val((Number($("#pageNo").val()) == lastPageNum ) ? lastPageNum : Number($("#pageNo").val())+1);
			$("#pageSize").val($("#resultCount").val());
    	}
		if(Number($("#pageNo").val()) != Math.ceil(Number($("#count").val())/Number($("#resultCount").val())) ){
			jQuery.post(url,params,callback,'json');
    	}
    }
    //末页
    function lastPage(){
    	var url = "${ctx}/platform/queryCode.do";
    	var params = {
			selfId :$("#selfId").val(),
       		relationId : $("#relationId").val(),
       		methodType : $("#methodType").val(),
       		params : $("#paramsByJSON").val(),
       		pageNo : Math.ceil(Number($("#count").val())/Number($("#resultCount").val())),
       		pageSize : $("#resultCount").val()
       	};
    	function callback(obj){
    		$("#codeselect").html("");
			var optionStr = "";
			for(var i = 0 ; i < obj.data.length ; i++){
				optionStr += "<option value = '"+obj.data[i].codeValue+"'>"+obj.data[i].codeValue+"--"+obj.data[i].codeLabel+"</option>"; 
			}
			$("#codeselect").html(optionStr);
			$("#count").val(obj.totalRecords);
			$("#pageNo").val(Math.ceil(Number($("#count").val())/Number($("#resultCount").val())));
			$("#pageSize").val($("#resultCount").val());
    	}
    	
    	jQuery.post(url,params,callback,'json');
    }
    //选择其中一页
    function changePage(){
    	var url = "${ctx}/platform/queryCode.do";
    	var params = {
			selfId :$("#selfId").val(),
       		relationId : $("#relationId").val(),
       		methodType : $("#methodType").val(),
       		params : $("#paramsByJSON").val(),
       		pageNo : $("#somePage").val(),
       		pageSize : $("#resultCount").val()
       	};
    	function callback(obj){
    		$("#codeselect").html("");
			var optionStr = "";
			for(var i = 0 ; i < obj.data.length ; i++){
				optionStr += "<option value = '"+obj.data[i].codeValue+"'>"+obj.data[i].codeValue+"--"+obj.data[i].codeLabel+"</option>"; 
			}
			$("#codeselect").html(optionStr);
			$("#count").val(obj.totalRecords);
			$("#pageNo").val($("#somePage").val());
			$("#pageSize").val($("#resultCount").val());
    	}
    	if($("#somePage").val() <= 0 || $("#somePage").val() > lastPageNum){
    		alert("您输入的页数有问题，请重新输入。");
    	}else{
    		jQuery.post(url,params,callback,'json');
    	}
    }
</script>
</head>
<body class="interface" onload="loadPage();" style="BORDER: #3D72D7 1px solid">

  <input type="hidden" id="selfId"/>
  <input type="hidden" id="relationId"/>
  <input type="hidden" id="methodType"/>
  <input type="hidden" id="paramsByJSON"/>
  <input type="hidden" id="pageNo"/>
  <input type="hidden" id="pageSize"/>
  <table class="common" cellpadding="2" cellspacing="0" align="center" style="display:" id="resultTab" >
    <tr>
      <td width=50% align="center"><input class="cssbutton" type="button" name="SelectIt" value="确  定"
        onclick='setFieldValue()'></td>
      <td width=50% align="center"><input name="CancelIt" class="cssbutton" type="button" value="取  消"
        onclick='cancelFieldValue()'></td>
    </tr>
    <tr>
      <td colspan=2 align="center">
      <select id="codeselect" name=codeselect class="one" size=20 style="width:100%" ondblclick="setFieldValue()">
      </select>
      </td>
    </tr>
      <tr>
      <td colspan="2" align="center">
      总条数<input type="text" style="width:20px;backgroundColor:#E8E8E8" id='count' readonly="readonly"/>&nbsp;&nbsp;每页<input type="text" id='resultCount' style="width:20px"/>条
      </td>
      </tr>
    <tr>
      <td colspan="2" align="center">
     <a onclick="fistPage();">首页</a>&nbsp;<a onclick="upPage();">上页</a>&nbsp;<a onclick="nextPage();">下页</a>&nbsp;<a onclick="lastPage()">末页</a>&nbsp;&nbsp;到<input type="text" id='somePage' style="width:20px"/>页
      <input type="button" value="go" onclick="changePage();">
      </td>
    </tr>
  </table>

</body>
</html>
