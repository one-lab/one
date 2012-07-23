$(function(){
// 添加跳转
	$("#prepareAdd").click(function(){
		$("#queryfm").attr("action",contextRootPath+"/rms/group/prepareAddGroup.do").submit();
	});

// 查询
	$("#query").click(function() {
		$("#queryfm").attr("action", contextRootPath + "/rms/group/queryGroup.do").submit();
	})
});
//增加 
function saveGroup(){
	var groupname=$("#groupname").val();
	var groupdes=$("#groupdes").val();
	if(groupname.length>128){
		alert("用户组长度不能大于128");
		return false;
	}
	groupname=groupname.replace(/\s/g,"");
	if(groupname==null||groupname==""){
		alert("用户组名称不能为空 ");
		return false;
	}
	if(groupdes.length>500){
		alert("用户组描述长度不能大于500");
		return false;
	}
	if($("input:checked").length == 0){
		alert("角色不能为空 ");
		return false;
	}
	if(confirm("确定保存?")){
		$("#savefm").attr("action",contextRootPath+"/rms/group/saveGroup.do").submit();
	}else{
		return false;
	}
}
/**
 * 保存更新操作
 * @returns {Boolean}
 */
function updataGroup(){
	var groupname=$("#groupname").val();
	var groupdes=$("#groupdes").val();
	if(groupname.length>128){
		alert("用户组长度不能大于128");
		return false;
	}
	groupname=groupname.replace(/\s/g,"");
	if(groupname==null||groupname==""){
		alert("用户组名称不能为空 ");
		return false;
	}
	if(groupdes.length>500){
		alert("用户组描述长度不能大于500");
		return false;
	}
	if($("input:checked").length == 0){
		alert("角色不能为空 ");
		return false;
	}
	if(confirm("确定保存?")){
		$('input[type="checkbox"][name="roleIDs"]').removeAttr("disabled");
		$("#groupname").removeAttr("disabled");
		$("#updatafm").attr("action",contextRootPath+"/rms/group/updataGroup.do").submit();
	}else{
		return false;
	}
};
/**
 * 更新用户组页面跳转
 * @param groupID
 */
function prepareUpdata(groupID) {
	$("#queryfm").attr("action",contextRootPath + "/rms/group/preparUpdata.do?group.groupID="+groupID).submit();
};
/**
 * 查询组成员
 */
function findGroupUser(){
	var groupid=$("#groupID").val();
	var comCode=$("#groupComCode").val()
	var div4ShowType=$("#div4ShowType").val()
	var userCode="";
	var userName="";
	if(div4ShowType=="0"){
		$("#div4").html();
		$.ajax({
			type : "POST",
			cache : false,
			async : true,
			url : contextRootPath
					+ "/rms/group/findGroupUser.do?group.groupID=" + groupid
					+ "&group.comCode=" + comCode+"&employee.userCode="+userCode+"&employee.userName="+userName,
			success : function(data) {
				$("#div4").html(data);
			}
		});
		$("#div4ShowType").val("1")
	}
	if(div4ShowType=="1"){
		$("#div4").hide();
		$("#div4ShowType").val("2")
	}
	if(div4ShowType=="2"){
		$("#div4").show();
		$("#div4ShowType").val("1")
	}
};
/**
 * 点击查询按钮查组未引入组的成员
 */
function findNIntroduced(){
	var groupid=$("#groupID").val();
	var comCode=$("#groupComCode").val();
	var userCode=$("#NintrUserCode").val();
	var userName=$("#NintrUserName").val();
	if(!userCode){
		userCode='';
	};
	if(!userName){
		userName='';
	};
	$.ajax({
		type : "POST",
		cache : false,
		async : true,
		url : contextRootPath+ "/rms/group/findNIntroduced.do?group.groupID=" + groupid
				+ "&group.comCode=" + comCode+"&employee.userCode="+userCode+"&employee.userName="+userName,
		success : function(data) {
			$("#div5").html(data);
		}
	});
};

/**
 * 点击查询按钮查组成员
 */
function findIntroduced(){
	var groupid=$("#groupID").val();
	var comCode=$("#groupComCode").val();
	var userCode=$("#intrUserCode").val();
	var userName=$("#intrUserName").val();
	$.ajax({
		type : "POST",
		cache : false,
		async : true,
		url : contextRootPath+ "/rms/group/findGroupUser.do?group.groupID=" + groupid
				+ "&group.comCode=" + comCode+"&employee.userCode="+userCode+"&employee.userName="+userName,
		success : function(data) {
			$("#div4").html();
			$("#div4").html(data);
		}
	});
};
/**
 * 删除组成员
 * @param userCode
 */	
function deleteGroupUser(userCode){
	var pageNO=$("#pageNo").val();
	var groupid=$("#groupID").val();
	$.ajax({
		type: "POST",
		cache:false,
		async:true,
		url:contextRootPath+ "/rms/group/deleteGroupUser.do?userCode="+userCode+"&group.groupID="+groupid,
		success : function(data) {
			currPage(pageNO);
		}
	});
}
/**
@author      
@description 分页操作 查询组成员
@param       page当前页号
@return      无
*/

function currPage(page) {
	$("#div4").html();
	var groupid=$("#groupID").val();
	document.getElementById("pageNo").value = page;
	$.ajax({
		cache:false,
		async:true,
		url:contextRootPath+ "/rms/group/findGroupUser.do?group.groupID="+groupid+"&pageNo="+page,
		success : function(data) {
			$("#div4").html(data);
		}
	});
};

/**
@author      
@description 分页操作 查询未加入组成员
@param       page当前页号
@return      无
*/
function NIntrcurrPage(page){
	var groupid=$("#groupID").val();
	var comCode=$("#groupComCode").val();
	var userCode=$("#NintrUserCode").val();
	var userName=$("#NintrUserName").val();
	document.getElementById("pageNo").value = page;
	$.ajax({
		cache:false,
		async:true,
		url : contextRootPath+ "/rms/group/findNIntroduced.do?group.groupID=" + groupid
		+ "&group.comCode=" + comCode+"&employee.userCode="+userCode+"&employee.userName="+userName+"&pageNo="+page,
		success : function(data) {
			$("#div5").html();
			$("#div5").html(data);
		}
	});
}

function addGroupUser(usercode){
	var groupid=$("#groupID").val();
	var comCode=$("#groupComCode").val();
	$.ajax({
		cache:false,
		async:true,
		url : contextRootPath+ "/rms/group/addGroupUser.do?group.groupID=" + groupid
		+ "&group.comCode=" + comCode+"&employee.userCode="+usercode,
		success : function(data) {
			findIntroduced();
			findNIntroduced();
			
		}
	});
};
//删除 
function deleteGroup(groupID){
	var flag = confirm( '确定删除? ');
	if(!flag) return;
	var groupName = "${groupName}";
   $("#queryfm").attr("action",contextRootPath+"/rms/group/deleteGroup.do?group.groupID="+groupID).submit();
}
function redirect(){
  	 window.location.href=contextRootPath+"/rms/group/queryGroup.do";
}

/**
 * 查询组成员详细信息
 * @param userCode
 */
function findGroupUserInfo(userCode){
	$("#updatafm").attr("action",contextRootPath + "/rms/group/findGroupUserInfo.do?userCode="+userCode).submit();
};


