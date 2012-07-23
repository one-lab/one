
	function findTasks(Code) {
		$("#editTree").html("");
		var upperComCode=ctree.getParentId(Code);
		if(upperComCode!='0'){
			upperComCode=upperComCode.split("-")[1];
		}
//		upperComCode=strSpli(upperComCode);
		var comCode=Code.split("-")[1];
		$("#editTree").html("<div id='taskTree' style='width: 300px; height: 540px;border :1px solid Silver;background-color:#f5f5f5;margin-top:0px; overflow: auto;'>" +
				"<div id='taskTreeLoadImg'><img  src='/mis/images/loading.gif'>正在加载.....</div>" +
				"</div>");
		var tree = new dhtmlXTreeObject("taskTree", "100%", "100%", 0);
		tree.setImagePath("/mis/images/dxTree/");
		tree.enableTreeImages(0);
		tree.enableCheckBoxes(1);
		//tree.showItemCheckbox(1);
		//tree.setXMLAutoLoadingBehaviour("id");
		tree.loadXML(""+contextRootPath+"/rms/taskAuth/taskTree.do?taskAuthComCode="+comCode+"&upperComCode="+upperComCode+"",function(){
			$("#taskTreeLoadImg").css("display","none");
			tree.enableThreeStateCheckboxes(true);//false to disable
		});
		Ttree=tree;
		SelectComCode=comCode;
	};
	
	function taskAuth() {
		var taskIds="";
		if(typeof(Ttree)==  'undefined'){
			alert("请选择机构操作");
			return false;
		}
		taskIds=Ttree.getAllCheckedBranches();
			if (confirm("确定保存?")) {
				$("#editTree").css("display","none");
				$("#taskAuthSaveImg").css("display","block");
				$.ajax({
					cache:false,
					async:true,
					type:"POST",
					url : contextRootPath + "/rms/taskAuth/taskAuth.do?taskIds="+taskIds+"&authComCode="+SelectComCode,
					success : function(data) {
						alert("操作成功");
						$("#editTree").css("display","block");
						$("#taskAuthSaveImg").css("display","none");
					}
				});
			}else{
				return false;					
			}
	};
	/**
	 * 截取机构ID字符
	 * @param comCode
	 * @returns
	 */
	function strSpli(comCode){
		var code=comCode.split("-");
		return code[1];
	}