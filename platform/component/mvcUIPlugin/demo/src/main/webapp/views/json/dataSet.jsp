<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://mvc.one.sinosoft.com/tags/pipe" prefix="mvcpipe"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>权限管理-功能菜单管理</title>
<link type="text/css" rel="stylesheet" href="${ctx}/css/sinosoft.base.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/css/sinosoft.tree.css" />
<script type="text/javascript" src="${ctx}/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${ctx}/js/sinosoft.tree.js"></script>
<script type="text/javascript" src="${ctx}/js/sinosoft.mouseoutclick.js"></script>
<script type="text/javascript">
$(function(){
	$("#sel_2").children().remove();
//	var url ="${ctx}/staffing/userpower/user/"+"${number}";
//	$obj = $(document.getElementById('window1_iframe').contentWindow.document);
	$li = $("#treeOne").find("li");
	$("#treeOne").jstree({
		"themes" : {
			"dots" : false,
			"icons" : false
		},
		"json_data":{
			"ajax":{
				"url":"${ctx}/staffing/user/"+"${number}"
			}
		},
		"plugins":["themes","json_data","ui"]
	}).bind("open_node.jstree",function(e,data){
		var theId = $(this).find(".jstree-open");
		var thisId = data.rslt.obj.attr("id");
		theId.each(function(){
			var okId = $(this).attr("id");
			if(okId != thisId){
				$("#treeOne").jstree("close_node","#" + okId);
			};
		});
	}).bind("select_node.jstree",function(e,data){
		$TASK=data.rslt.obj;

		if($("#sel_2").html() != "" || $("#sel_1").html() != ""){
			$("#sel_1").html("");
			$("#sel_2").html("");
			$(".code_box").html("");
		}
//		var $temValOne = $("<option id='op_1'>财产保险公司北京分公司</option>");
//		var $temValTwo = $("<option id='op_2'>财产保险公司山东分公司</option>");
//		var $temValThree = $("<option id='op_3'>财产保险公司上海分公司</option>");
//		var $temValFour = $("<option id='op_4'>财产保险公司深圳分公司</option>");
		if($TASK.parents("li").length != 0){
			var taskId = $TASK.attr("id");
				$("#taskId").val($TASK.attr("id"));
			var userPowerId = $TASK.parents("li").attr("id");
				$("#userPowerId").val($TASK.parents("li").attr("id"));
			
			$.ajax({
				url : "${ctx}/staffing/ruleAll/"+taskId+"/"+userPowerId,
				type : "get",
				success : function(data){
					var optionSel_2 = "";
					var optionSel_1 = "";
					for(var i=0;i<data.length;i++){
//						alert(data[i].dataRuleParam.length);
						if(data[i].dataRuleParam.length == 0){
							optionSel_2 = optionSel_2 +"<option id='"+data[i].dataRuleID+"'>"+data[i].rule+"</option>";
						}else{
							optionSel_1 = optionSel_1 +"<option id='"+data[i].dataRuleID+"'>"+data[i].rule+"</option>";
							var temValP = $("<p id='p_"+data[i].dataRuleID+"'>"+data[i].rule+"cc/read.php?tid=53766773424&_fp=4,文字数据.com/categroy/ux3724&_fp=4,文字数据.com/categroy/ux</p>");
							var temValText = $("<input id='te_"+data[i].dataRuleID+"' type='text' class='code_text' value='"+data[i].dataRuleParam+"' />");
							$(".code_box").append(temValP).append(temValText);
						}
					};
					$("#sel_2").append($(optionSel_2));
					$("#sel_1").append($(optionSel_1));
				},
				error : function(){
					alert("失败！！");
				}
			});
		}
//		var $temVal = $(option);
//		$("#sel_2").append($temValOne).append($temValTwo).append($temValThree).append($temValFour);
		
	});
	$("#sel_2").find("option").live("dblclick", toLeftMove);
	$("#sel_1").find("option").live("dblclick", toRightMove);
	
});
function toLeftMove() {
	var ops = $("#sel_2").children();
	ops.each(function(){
		if($(this).attr("selected")) {
			var thisId = $(this).attr("id");
			var rootText = $(this).text();
			$("#sel_1").append($(this));
			var temValP = $("<p id='p_"+thisId+"'>"+rootText+"cc/read.php?tid=53766773424&_fp=4,文字数据.com/categroy/ux3724&_fp=4,文字数据.com/categroy/ux</p>");
			var temValText = $("<input id='te_"+thisId+"' type='text' class='code_text' value='请输入参数' />");
			$(".code_box").append(temValP).append(temValText);
		}
	});

}

function toRightMove() {
	var ops = $("#sel_1").children();
	ops.each(function(){
		if($(this).attr("selected")) {
			var thisId = $(this).attr("id");
			$("#sel_2").append($(this));
			$("#p_"+thisId).remove();
			$("#te_"+thisId).remove();
		}
	});	
};
</script>
</head>

<body>
<input type="hidden" id="taskId" />
<input type="hidden" id="userPowerId" />
<div class="data_list">
    <div class="title2"><b><span>姓名：${name} 编号：${number}</span>数据设置</b></div>
    <div id="treeOne" class="tree_view f_left" style="height:439px"></div>
    <div class="data_right f_left">
    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>
                <select id="sel_1" class="datas" multiple="multiple">
                </select>
            </td>
            <td class="data_cen">
            	<a href="javascript:;" class="a_left" onclick="toLeftMove();"></a>
                <a href="javascript:;" class="right a_right" onclick="toRightMove();"></a>
            </td>
            <td>
            	<select id="sel_2" multiple="multiple" class="datas">
                    <option id="op_1">测试一</option>
                    <option id="op_2">测试二</option>
                    <option id="op_3">测试三</option>
                    <option id="op_4">测试四</option>
                </select>
            </td>
          </tr>
        </table>
        <div class="code_box" style="margin-bottom:10px;">
        	
        </div>
    </div>
</div>
</body>
</html>
