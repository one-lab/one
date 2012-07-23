$(function(){
	//$("#userCode").focus();
})

function logout(){
	$("#logoutfm").attr("action", contextRootPath + "/rms/login/logout.do").submit();
};
function checkUser(){
	var userCode = $("#userCode").val();
	var password = $("#password").val();
	if(userCode!=""&&password!=""){
		$("#select").empty();
		$("#userCodeError").text("");
		$("#passwordError").text("");
		options =  "<option value='0'>--请选择机构--</option>";
		$.getJSON(contextRootPath+"/rms/login/checkUser.do?employe.userCode="
				+userCode+"&employe.password="+password,
				function(data){
					if(data!=null){
						if(data.userCode!=null){
							$("#userCodeError").text(data.userCode);
							$('#select').html(options);
						}
						if(data.password!=null){
							$("#passwordError").text(data.password);
							$('#select').html(options);
						}
						if( typeof data==='object'&& typeof data.length==='number'){
						  $.each(data,function(index,obj){
							  options +=  "<option value='"+obj.comCode+"'>"+obj.comName+"</option>";
						  })
						  $('#select').html(options);
						}	
					}else{
					  $('#select').html(options);
					}
				}); 
	}
}

function login(){
	var comCode=$("#select").val();
	var userCode = $("#userCode").val();
	var password = $("#password").val();
	var userCodeError=$("#userCodeError").text();
	var passwordError=$("#passwordError").text();
	if(userCode==null||userCode==""){
		alert("用户名不能为空");
		return false;
	}
	if(userCodeError!=""){
		return false;
	}
	if( password==null||password==""){
		alert("密码不能为空");
		return false;
	}
	if(passwordError!=""){
		return false;
	}
	if(comCode=="0"){
		alert("请选择登陆机构");
		return false;
	}
	if(comCode!=null){
		$("#userForm").attr("action",contextRootPath+"/rms/login/subMitUserInfo.do").submit();
	}
	
	
}