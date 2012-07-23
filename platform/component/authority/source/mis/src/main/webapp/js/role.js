function findRoles(Code) {
	var upperComCode=ctree.getParentId(Code);
	if(upperComCode!='0'){
		upperComCode=upperComCode.split("-")[1];
	}
//	upperComCode=strSpli(upperComCode);
	var comCode=Code.split("-")[1];
	$("#roles").html();
	$("#comCode").html();
	$.ajax({
		type: "POST",
		cache:false,
		async:true,
		url : contextRootPath + "/rms/role/querydesignate.do?comCode="+ comCode+"&upperComCode="+upperComCode,
		success : function(data) {
			$("#roles").html(data);
			$("#comCode").val("" + comCode + "");
		}
	});
};
function roleDesignate() {
	var comCode = "";
	comCode = $("#comCode").val();
	var arr=$('input[name="roleIDs"]');
	var roleIDs=""; 
	for(i=0;i<arr.length;i++){
		if (arr[i].checked) {
			roleIDs += arr[i].value + ",";
		}
	}
	roleIDs=roleIDs.substring(0,roleIDs.length-1);
	if (confirm("确定保存?")) {
		$("#roles").css("display","none");
		$("#roleDesinaeSaveImg").css("display","block");
		$.ajax({
			cache:false,
			async:true,
			type:"POST",
			data:{"roleIDs":roleIDs,"comCode":comCode},
			url : contextRootPath + "/rms/role/designate.do",
			success : function(data) {
				alert("操作成功");
				$("#roles").css("display","block");
				$("#roleDesinaeSaveImg").css("display","none");
			}
		});
//		$("#roldesignfm").attr("action",contextRootPath + "/rms/role/designate.do").submit();
	} else {
		return false;
	}
};
//指派页面跳转到角色查看
function queryRoleInfo(roleID) {
	$.ajax({
		cache:false,
		async:true,
		type:"POST",
		data:{"role.roleID":roleID},
		url : contextRootPath + "/rms/role/queryRoleInfo.do",
		success : function(data) {
			$("#Dialog_car").html(data);
			showDiv();
		}
	});
};
//查询页面跳转到角色查看
function prepareUpdata(roleID){
    $("#rolefm").attr("action",contextRootPath+"/rms/role/prepareUpdata.do?role.roleID="+roleID).submit();

};

/*弹出层代码*/
function showDiv() {
		var theHeight = $(document).height();
		var theWidth = $(document).width() / 2;
		var dialogHeight = $("#Dialog_car").height() / 12;
		var dialogWidth = $("#Dialog_car").width() / 2;
		$("#shadow").css("height", theHeight).show();
		$("#Dialog_car").css({'top':theHeight / 10 - dialogHeight,'left':theWidth - dialogWidth}).show();
		$(".text_aa").find("select").hide();
};
//取消并关闭弹出层代码
function cancelDialog(){
	$('#shadow').hide();
    $('#Dialog_car').hide();
}

function updatarole(){
//	var comcode ='';
//	var box=document.getElementsByName("comCode");
//    var country = box.length;
//    for(var i=0;i<country;i++){   
//        if(box[i].checked){   
//        	comcode+=box[i].value+","; 
//        }
//    }
//    comcode=comcode.substr(0,comcode.length-1);
//	alert(comcode);
	var roleComCode=$("#roleComCode").val();
	var loginComCode=$("#loginComCode").val();
	if (roleComCode != loginComCode) {
		alert("不能修改该角色 ");
		return false;
	}
	var arr=document.getElementsByName("DesNateComCode");
	var comCode=""; 
	for(i=0;i<arr.length;i++){
		if (arr[i].checked) {
			comCode += arr[i].value + ",";
		}
	}
	comCode=comCode.substring(0,comCode.length-1);
    var rolename = $("#rolename").val();
    var roledes=$("#roledes").val();
    if(rolename.length>128){
		alert("角色名称长度不能大于128");
		return false;
	}
    rolename=rolename.replace(/\s/g,"");
	if (rolename == null || rolename == "") {
		alert("角色名称不能为空 ");
		return false;
	}
	if(roledes.length>500){
		alert("角色描述长度不能大于500");
		return false;
	}
	var s = "";
	s = tree.getAllCheckedBranches();
	if (s == null || s == "") {
		alert("权限不能为空 ");
		return false;
	} else {
		if (confirm("确定保存?")) {
				$("#updatafm").attr("action",contextRootPath+ "/rms/role/updateRole.do?taskIds="+s+"&comCode="+comCode).submit();
		}else{
			return false;					
		}
	}
};
/**
 * 角色增加SAVA方法
 */
function saveRole(){
	var rolename = $("#rolename").val();
	var roledes=$("#roledes").val();
	rolename=rolename.replace(/\s/g,"");
	if (rolename == null || rolename == "") {
		alert("角色名称不能为空 ");
		return false;
	}
	if(rolename.length>128){
		alert("用户组长度不能大于128");
		return false;
	}
	if(roledes.length>500){
		alert("角色描述长度不能大于500");
		return false;
	}
	var s = "";
	s = tree.getAllChecked();
	if (s == null || s == "") {
		alert("权限不能为空 ");
		return false;
	} else {
		if (confirm("确定保存?")) {
				$("#savefm").attr("action",contextRootPath+ "/rms/role/saveRole.do?taskIds="+ s + "").submit();
		}else{
			return false;					
		};
	};
}

function redirect(type) {
	window.location.href =contextRootPath+ "/rms/role/queryRole.do";
}


//删除 
function deleteRole(roleID){
	if(confirm("确定删除")){
    	$("#rolefm").attr("action",contextRootPath+"/rms/role/deleteRole.do?role.roleID="+roleID).submit();
	}
};

