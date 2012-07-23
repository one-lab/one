//当前SESSION的判断
function checkUserInfo(sid){
	var sessionid=$("#sessionid").val();
}
function g(o){
	return document.getElementById(o);
};  

function HoverLi(n){  
//如果有N个标签,就将i<=N;  
	for(var i=1;i<=2;i++){g('tb_'+i).className='normaltab';g('tbc_0'+i).className='undis';}
	g('tbc_0'+n).className='dis';g('tb_'+n).className='hovertab';  
	var id=g('tbc_0'+n).id;
	$("#selectdivid").val(id);
}
function tHoverLi(n){  
	for(var i=1;i<=2;i++){g('ttb_'+i).className='normaltab';g('ttbc_0'+i).className='undis';}
	g('ttbc_0'+n).className='dis';g('ttb_'+n).className='hovertab';
	//发个请求加载页面
	var busPowerFlag=$("#busPowerFlag").val();
	if(busPowerFlag=='1'){
		findBusPower();
	}
}

/**
 * 点击机构节点获取机构代码值
 * @param Code
 * @returns
 */
function eitdPower(Code){
	var comCode=strSpli(Code);
	var comName=tree.getItemText(Code);
	$("#comCode").val(""+comCode+"");
	$("#editComCode").text("你所操作的机构是  ："+comCode+": "+comName+"");
	var userCode=$("#userCode").val();
	var userName=$("#userName").val();
	HoverLi(1);
	$.ajax({
		type: "POST",
		cache:false,
		async:true,
		url: contextRootPath+ "/rms/employeesConfig/findIntroduced.do?comCode="+comCode+"&employe.userCode="+userCode+"&employe.userName="+userName+ "&next=" + Math.random(),
		success : function(data){
			$("#findIntroduced").html(data);
			findNoIntroduced();
			reSelect();
		}
	});
};

/**
 * 查询已引入人员
 */
function findIntroduced(){
	var comCode=$("#comCode").val();
	var userCode=$("#userCode").val();
	var userName=$("#userName").val();
	$("#findIntroduced").html();
	if(comCode==null||comCode==""){
		alert("请选择机构后进行操作");
	}else{
		//双击机构查询引入人员
		$.ajax({
			type:"POST",
			cache:false,
			async:true,
			data:{"employe.userName":userName},
			url: contextRootPath+ "/rms/employeesConfig/findIntroduced.do?comCode="+comCode+"&employe.userCode="+userCode+ "&next=" + Math.random(),
			success : function(data){
				$("#findIntroduced").html(data);
			}
		});
	}
};
/**
 * 查询未引入人员用于引入
 */
function findNoIntroduced(){
	var comCode=$("#comCode").val();
	var userCode=$("#noIntroduserCode").val();
	var userName=$("#noIntroduserName").val();
	$("#findNoIntroduced").html();
	if(comCode==null||comCode==""){
		alert("请选择机构后进行操作");
	}else{
		$.ajax({
			type:"POST",
			cache:false,
			async:true,
			data:{"employe.userName":userName},
			url: contextRootPath+ "/rms/employeesConfig/findNoIntroduced.do?comCode="+comCode+"&employe.userCode="+userCode+ "&next=" + Math.random(),
			success : function(data){
				$("#findNoIntroduced").html(data);
			}
		});
	}
};
/**
@description 查询人员的分页操作
@param       page当前页号
*/
function currPage(page) {
	var divid=$("#selectdivid").val();
	var comCode=$("#comCode").val();
	var userCode=$("#userCode").val();
	var userName=$("#userName").val();
	var DotDoid=$("#"+divid+" .table4 tr").eq(2).find("td").eq(0).attr("id");
		$.ajax({
			type:"POST",
			cache:false,
			async:true,
			data:{"employe.userName":userName},
			url: contextRootPath+ "/rms/employeesConfig/"+DotDoid+".do?comCode="+comCode+"&employe.userCode="+userCode+"&pageNo="+page+ "&next=" + Math.random(),
			success : function(data){
				$("#"+DotDoid).html(data);
			}
		});
};
/**
 * 点击选择人员后开始进行人员信息编辑 获得用户组信息页面
 * @param userCode
 * @returns
 */
function editIntroduced(userCode){
	document.getElementById('findUser').style.display="none";
	document.getElementById('taskConfig').style.display="";
	$("#groupInfo").html("");
	$("#groupInfo_roleInfo").html("");
	var comCode=$("#comCode").val();
	$("#selectUserCode").val(""+userCode+"");
	$.ajax({
		cache:false,
		type: "POST",
		async:true,
		url: contextRootPath+ "/rms/employeesConfig/findGroupByUser.do?comCode="+comCode+"&employe.userCode="+userCode+ "&next=" + Math.random(),
		success : function(data){
			 $("#groupInfo").html(data);
			 //同时加载殊绝权限页面
			 findBusPower();
		}
	});
}

/**
 *用户组选择框改变后执行方法（由用户组带动 角色信息-功能信息的刷新）
 */
function groupIdChange(){
	var groups=$("input[type=checkbox][name=groupID]:checked");
	var groupIDs=new Array();
	$.each(groups,function(index,obj){
		groupIDs.push(obj.value);
	});
	 var comCode='';
		comCode=$("#comCode").val();
	$.ajax({
		type: "POST",
		cache:false,
		async:true,
		url: contextRootPath+ "/rms/employeesConfig/loadGroupInfo.do?groupID="+groupIDs+"&comCode="+comCode+ "&next=" + Math.random(),
		success : function(data){
				$("#groupInfo_roleInfo").html();
				$("#groupInfo_roleInfo").html(data);
		}
	});
};

/**
 * 角色选择框改变后执行方法（由角色刷新功能树）（角色的多选框在可用情况下调用）
 */
function roleIdChange(){
	var roles=$("input[type=checkbox][name=roleID]:checked");
	var roleIDs=new Array();
	$.each(roles,function(index,obj){
		roleIDs.push(obj.value);
	});
	var comCode=$("#comCode").val();
	var userCode=$("#selectUserCode").val();
	$("#taskTree").html("");
	var ttree=new dhtmlXTreeObject("taskTree","100%","100%",0);
  	ttree.setImagePath(""+contextRootPath+"/images/dxTree/");
  	ttree.enableTreeImages(0);
  	ttree.enableCheckBoxes(1);
  	//tree.enableThreeStateCheckboxes(true);//false to disable
  	ttree.loadXML(""+contextRootPath+"/rms/employeesConfig/taskTree.do?roleID="+roleid+"&employe.userCode="+userCode+"&comCode="+comCode,function(){
  		 ttree.enableThreeStateCheckboxes(true);
  	});
	
}
/**
 * 更新用户信息
 */
function updataUserInfo(){
	var groups=$("input[type=checkbox][name=groupID]:checked");
	var groupIDs=new Array();
	$.each(groups,function(index,obj){
		groupIDs.push(obj.value);
	});
	var uncheckedTaskids=ttree.getAllUnchecked();
	var comCode=$("#comCode").val();
	var userCode=$("#selectUserCode").val();
	if(confirm("确定保存?")){
		$.ajax({
			type: "POST",
			cache:false,
			async:true,
			url: contextRootPath+ "/rms/employeesConfig/saveUserPower.do?employe.userCode="+userCode+"&comCode="+comCode+"&groupID="+groupIDs+"&taskID="+uncheckedTaskids+ "&next=" + Math.random(),
			success : function(data){
				document.getElementById('findUser').style.display="";
				document.getElementById('taskConfig').style.display="none";
				findIntroduced();
				findNoIntroduced();
				HoverLi(1);
				$("#groupInfo").html("");
				$("#groupInfo_roleInfo").html("");
				$("#busPowertaskTree").html("");
				$("#busPowerInfo").html("");
			}
		});
	}
};

/**
 * 删除人员
 */
function deleteIntroduced(userCode){
	var comCode = $("#comCode").val();
	if (confirm("确定删除?")) {
		$.ajax({
			type: "POST",
			cache:false,
			async:true,
			url : contextRootPath+ "/rms/employeesConfig/deleteUserPower.do?employe.userCode="+ userCode + "&comCode=" + comCode+ "&next=" + Math.random(),
			success : function(data) {
				findIntroduced();
				findNoIntroduced();
			}
		});
	}
}
/**
 * 查询数据权限信息
 */
function findBusPowerInfo(taskId){
	$("#selectBusPowerTaskid").val(""+taskId+"");
	var userCode=$("#selectUserCode").val();
	$("#busPowerInfo").html("");
	$.ajax({
		type: "POST",
		cache:false,
		async:true,
		url: contextRootPath+ "/rms/employeesConfig/findBusPowerInfo.do?taskID="+taskId+"&employe.userCode="+userCode+ "&next=" + Math.random(),
		success : function(data){
			$("#busPowerInfo").html(data);
		}
	});
};

/**
 * 获取数据权限的功能树
 */
function findBusPower(){
	$("#busPowertaskTree").html("");
	$("#busPowerFlag").val(""+2+"");
	$.ajax({
		type: "POST",
		cache:false,
		async:true,
		url: contextRootPath+ "/web/rms/employeeConfig/busPowerTaskTree.jsp",
		success : function(data){
			$("#busPowertaskTree").html(data);
		}
	});
};

/**
 * 重新选择
 */
function reSelect(){
	document.getElementById('findUser').style.display="";
	document.getElementById('taskConfig').style.display="none";
	$("#busPowerFlag").val(""+1+"");
}

/**
 * 截取机构ID字符
 * @param comCode
 * @returns
 */
function strSpli(comCode){
	var code=comCode.split("-");
	return code[1];
}