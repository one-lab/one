<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/common/taglibs.jsp" %>
<%@ page import="java.util.*"%>

<html>
<head>
<base target="_self">
<title>��ѡ��</title>
<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/common/js/jquery-1.7.1.js"></script>
<script language='javascript'> 
	//ҳ�����ʱ���Զ���ѯ
    function loadPage(){
    	var url = "${ctx}/platform/queryCode.do";
    	var parentWindow = window.dialogArguments;
    	var obj = parentWindow.obj;
    
    	//����ҳ���ֵ��������ҳ��
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
	//�����ı����ֵ
    function setFieldValue(){
		if($("#codeselect option:selected").val() == null){
			alert("��û��ѡ��һ���ѡ��");
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
			//Ϊ�˺�����Ҫִ�и�ҳ�淽�����callback����
			window.close();
			try {
				if(typeof(eval(parentWindow.sonCallbackFather))=="function"){
	        		parentWindow.sonCallbackFather(selfId,relationId);
	        	}
	        }catch(e){
	      
	        }
		}
    }
    //ȡ���ı����ֵ
    function cancelFieldValue(){
    	var selfId = $("#selfId").val();
		var relationId = $("#relationId").val();
		var parentWindow = window.dialogArguments;
		parentWindow.document.getElementById(selfId).value = '';
		parentWindow.document.getElementById(relationId).value = '';
		window.close();
    }
    //��ҳ
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
    //��һҳ
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
    //��һҳ
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
    //ĩҳ
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
    //ѡ������һҳ
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
    		alert("�������ҳ�������⣬���������롣");
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
      <td width=50% align="center"><input class="cssbutton" type="button" name="SelectIt" value="ȷ  ��"
        onclick='setFieldValue()'></td>
      <td width=50% align="center"><input name="CancelIt" class="cssbutton" type="button" value="ȡ  ��"
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
      ������<input type="text" style="width:20px;backgroundColor:#E8E8E8" id='count' readonly="readonly"/>&nbsp;&nbsp;ÿҳ<input type="text" id='resultCount' style="width:20px"/>��
      </td>
      </tr>
    <tr>
      <td colspan="2" align="center">
     <a onclick="fistPage();">��ҳ</a>&nbsp;<a onclick="upPage();">��ҳ</a>&nbsp;<a onclick="nextPage();">��ҳ</a>&nbsp;<a onclick="lastPage()">ĩҳ</a>&nbsp;&nbsp;��<input type="text" id='somePage' style="width:20px"/>ҳ
      <input type="button" value="go" onclick="changePage();">
      </td>
    </tr>
  </table>

</body>
</html>
