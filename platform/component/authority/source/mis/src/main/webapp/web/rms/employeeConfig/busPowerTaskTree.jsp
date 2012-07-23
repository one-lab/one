<%@ page language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglibs.jsp" %>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/file.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/menu.css"/>
<link rel = "stylesheet" type = "text/css" href = "${ctx }/css/standard.css"/>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmltree.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/dhtmlcommon.js"></script>
<script type="text/javascript" language="script" src = '${ctx }/js/jquery-1.6.4.js'></script>
<script type="text/javascript" language="script" src = '${ctx }/js/employee2.js'></script>
<div >
			<div id="btaskTree" style="float:left;width:156px;height:400px;overflow: auto;" >
			</div>
			<input id="selectBusPowerTaskid"  value=""/>
</div>
<script>
	 var userCode=$("#selectUserCode").val();
	 var comCode=$("#comCode").val();
	 //功能树 
	 var btree=new dhtmlXTreeObject("btaskTree","100%","100%",0);
	 btree.setImagePath("${ctx}/images/dxTree/");
	 btree.enableTreeImages(0);
//	 btree.enableRadioButtons(true);
	 btree.setOnClickHandler(findBusPowerInfo);
	 btree.loadXML("${ctx}/rms/employeesConfig/busPowertaskTree.do?employe.userCode="+userCode+"&comCode="+comCode);
	
// function ThreeState(){
	// btree.enableThreeStateCheckboxes(true);
	 //}; 
</script> 