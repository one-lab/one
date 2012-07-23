<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglibs.jsp" %>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/file.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/menu.css"/>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmltree.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmlcommon.js"></script>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/standard.css"/>
<script type="text/javascript" language="script" src = '${ctx }/js/jquery-1.6.4.js'></script>

<div style="float:left;margin-left:10px;width:200px;">
                       <div style="width:100%">
                       	
                       	<table >
                   		  <tr>
                 			 <td>
                				<select multiple="multiple" id="leftSelect" style="width: 100px;height: 200px;">
                					<c:forEach items="${busPowers}" var="busPower">
                              			<c:if test="${busPower.dataRule.dataRuleID != null}">
                          	    			<option value="${busPower.dataRule.dataRuleID}">${busPower.dataRule.rule}</option>
                             			</c:if>
                             		</c:forEach>
                             	</select>
                             </td>
                             <td>
                             	<input id="move2Right" type="button" value="→删除 →" class="btn1"><br>
								<input id="move2Left" type="button" value="←添加 ←" class="btn1"><br>
                            </td>
                            <td>
                              <select multiple="multiple" id="rightSelect" style="width: 100px;height: 200px;">
                              		<c:forEach items="${dataRules}" var="dataRule">
                          	    				 <option value="${dataRule.dataRuleID}">${dataRule.rule}</option>
                             			</c:forEach>
                              </select>
                            </td>
                           </tr>
                          </table>
                          </div>
                          <div style="margin-top:10px;width:100%" id="dataRuleParam">
                          		<c:forEach items="${busPowers}" var="busPower">
                              				<div id="${busPower.dataRule.dataRuleID}"> ${busPower.dataRule.rule}参数：<input id="${busPower.dataRule.dataRuleID}" name='dataRuleParam' type='text' value='${busPower.dataRuleParam}'><br> </div>
                             	</c:forEach>
                          </div>
                          <div>
                          	
                          </div>
</div>
<script type="text/javascript">

var leftSelect = document.getElementById("leftSelect");
var rightSelect = document.getElementById("rightSelect");
//右移
document.getElementById("move2Right").onclick = function(){
	var optionArr = leftSelect.options;
	for(var x = 0; x < optionArr.length; x++){
		if(optionArr[x].selected){
			var node=document.getElementById(""+optionArr[x].value+"");
			document.getElementById("dataRuleParam").removeChild(node);
			rightSelect.appendChild(optionArr[x--]);
		}
	}
}
//左移
document.getElementById("move2Left").onclick = function(){
	var optionArr = rightSelect.options;
	for(var x = 0; x < optionArr.length; x++){
		if(optionArr[x].selected){
			document.getElementById("dataRuleParam").innerHTML += " <div id='"+optionArr[x].value+"'> "+optionArr[x].firstChild.nodeValue+"参数：<input id='"+optionArr[x].value+"' name='dataRuleParam' type='text' value=''><br> </div>";
			leftSelect.appendChild(optionArr[x--]);
		}
	}
}
function saveBusPower(){
	var node=btree.getAllChildless();
	var taskid=$("#selectBusPowerTaskid").val();
	alert(taskid);
	$("#busPowerTaskid").val("");
//	taskid=	btree.getAllChecked();
	var userCode=document.getElementById("selectUserCode").value;
	var comCode=document.getElementById("comCode").value;
	if(!node.length>0){
		alert("你没有权限");
		return false;
	}
	if(taskid==null||taskid==""){
		alert("功能权限不能为空");
		return false;
	}
	var optionArr=document.getElementById("leftSelect").options;
	if(optionArr.length==0){
		alert("规则不能为空");
		return false;
	}
	var dataRule=[];
	for(var x = 0; x < optionArr.length; x++){
		var id=optionArr[x].value
		var dataRuleParam;
		dataRuleParam=$('input[id="'+optionArr[x].value+'"][name="dataRuleParam"]').val();
		var chr=optionArr[x].value+"-"+dataRuleParam;
		dataRule.push(chr);
	}
	$.ajax({
		url: contextRootPath+ "/rms/employeesConfig/saveBusPower.do?comCode="+comCode+"&employe.userCode="+userCode+"&taskID="+taskid+"&dataRule="+dataRule,
		success : function(data){
			alert("保存成功");
		}
	});
}
</script>