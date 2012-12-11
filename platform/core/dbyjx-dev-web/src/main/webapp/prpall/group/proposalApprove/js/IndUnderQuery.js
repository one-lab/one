//合并操作
function mergeCustomerNo(){
	var url=contextRootPath+"/prpall/mergeCustomerNo.do";
	//被保人客户号
	var customerNo="";
	if(null==$('input:radio[name="ldPersonRadio"]:checked').val()
			   ||undefined==$('input:radio[name="ldPersonRadio"]:checked').val()){
			   alert("请选择一条原客户信息！");
			   return false;
			}
	customerNo= $('input:radio[name="ldPersonRadio"]:checked').val();
	
	//合同号
	var contNo="";
	if(null==$('input:radio[name="lcContRadio"]:checked').val()
			   ||undefined==$('input:radio[name="lcContRadio"]:checked').val()){
			   alert("请选择一条重复客户信息！");
			   return false;
			}
	contNo= $('input:radio[name="lcContRadio"]:checked').val();
	
	var param={
		"ldPerson.customerNo":customerNo,
		"lcCont.contNo":contNo
	};
	function mergeCallBack(obj){
		
	}
	jQuery.post(url,param,mergeCallBack,"json");
}

//第二个单选按钮事件
function radioButton(){
	$('input:radio[name="lcContRadio"]').each(function(){
		if(null==$('input:radio[name="ldPersonRadio"]:checked').val()
				   ||undefined==$('input:radio[name="ldPersonRadio"]:checked').val()){
			alert("请选择一条原客户信息！");
			this.checked=false;
			 return false;
		}else{
			this.checked=true;
			$("#oldNo").val($('input:radio[name="ldPersonRadio"]:checked').val());
		}
	});	
}