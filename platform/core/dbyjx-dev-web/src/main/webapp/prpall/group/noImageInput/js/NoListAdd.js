
//添加告知信息
	var num=0;
	function addPublicInfo(){
		$("#PublicInfoBody").val();
		var content="";
		content+="<tr class='content' id='info"+num+"'>"+
		"<td>"+num+"</td>"+
		"<td><input type='text' size='5'  maxlength='5' name='lcRepInfoList["+num+"].id.impartVer'/><img src='images/bgMarkMustInput.jpg' ></td>"+
		"<td><input type='text' size='4' maxlength='4' name='lcRepInfoList["+num+"].id.impartCode'/><img src='images/bgMarkMustInput.jpg' ></td>"+
		"<td><input type='text' name='lcRepInfoList["+num+"].impartDetailContent' size='60'/><img src='images/bgMarkMustInput.jpg' ></td>"+
		"<td><input type='text' name='lcRepInfoList["+num+"].message' size='60'/></td>"+
		"<td><input type='button' value='-'  onclick='removePublicInfo(info"+num+")'/>";
		content+="</tr>";
		num++;
		$("#PublicInfoBody").append(content);
	}
	//删除告知信息
	function removePublicInfo(p){
		$(p).remove();
	}
	//添加受益人信息
	var bnfNum=0;
	function addApplycInfo(){
		$("#scanApplycInfoBody").val();
		var content="";
		content+="<tr class='content' id='bnf"+bnfNum+"'>"+
		"<td>"+bnfNum+"</td>"+
		"<td><input type='text' class='codecode' id='bnfType"+bnfNum+"' name='lcBnfList["+bnfNum+"].id.bnfType' style='width:20%' ondblclick=queryCode('bnfType"+bnfNum+"','bnfTypeName"+bnfNum+"','PDLDcode1','codeType:BnfType') /><input id='bnfTypeName"+bnfNum+"' name='bnfTypeName' class='common' type='text' style='width:50%' value=''/><img src='images/bgMarkMustInput.jpg' ></td>"+
		"<td><input type='text' name='lcBnfList["+bnfNum+"].name' size='15'/><img src='images/bgMarkMustInput.jpg' ></td>"+
		"<td><input type='text' class='codecode' id='sex"+bnfNum+"' name='lcBnfList["+bnfNum+"].sex' style='width:20%' ondblclick=queryCode('sex"+bnfNum+"','sexName"+bnfNum+"','PDLDcode1','codeType:Sex') /><input id='sexName"+bnfNum+"' name='sexName' class='common' type='text' style='width:40%' value=''/><img src='images/bgMarkMustInput.jpg' ></td>"+
		"<td><input type='text' class='codecode' id='idType"+bnfNum+"' name='lcBnfList["+bnfNum+"].idType' style='width:20%' ondblclick=queryCode('idType"+bnfNum+"','idTypeName"+bnfNum+"','PDLDcode1','codeType:CorporationIDType') /><input id='idTypeName"+bnfNum+"' name='idTypeName' class='common' type='text' style='width:50%' value=''/><img src='images/bgMarkMustInput.jpg' ></td>"+
		"<td><input type='text' name='lcBnfList["+bnfNum+"].idNo' size='15'/><img src='images/bgMarkMustInput.jpg' ></td>"+
		"<td><input type='text' name='lcBnfList["+bnfNum+"].relationToInsured' size='15'/><img src='images/bgMarkMustInput.jpg' ></td>"+
		"<td><input type='text' name='lcBnfList["+bnfNum+"].id.bnfGrade' size='15'/><img src='images/bgMarkMustInput.jpg' ></td>"+
		"<td><input type='text' name='lcBnfList["+bnfNum+"].bnfLot' size='12'/><img src='images/bgMarkMustInput.jpg' ></td>"+
		"<td><input type='button' value='-'  onclick='removePublicInfo(bnf"+bnfNum+")'/>";
		content+="</tr>";
		bnfNum++;
		$("#scanApplycInfoBody").append(content);
	}
	//删除受益人信息
	function removeApplyInfo(p){
		$(p).remove();
	}
	//保存信息
	function saveInfo(){
		$.ajax({
			type : "POST",
			url : ctx + "/prpall/saveAllInfo.do",
			data : $("#bnfForm").serialize(),
			dataType :"json",
			success : function(obj){
				alert("ok");
				alert(obj);
				$("#remark").val(obj.lcInsured[0].remark);
				$("#insuredPeoples").val(obj.lcInsured[0].insuredPeoples);
				$("#occupationCode").val(obj.lcInsured[0].occupationCode);
				$("#occupationType").val(obj.lcInsured[0].occupationType);
				//告知单信息
				var lcRepInfoContent="";
				$("#PublicInfoBody").html(lcRepInfoContent);
				for(var i=0;i<obj.lcRepInfoList.length;i++){
					lcRepInfoContent+="<tr class='content' id=''>"+
					"<td>"+i+"</td>"+
					"<td>"+obj.lcRepInfoList[i].id.impartVer+"</td>"+
					"<td>"+obj.lcRepInfoList[i].id.impartCode+"</td>"+
					"<td>"+obj.lcRepInfoList[i].impartDetailContent+"</td>"+
					"<td>"+obj.lcRepInfoList[i].message+"</td>"+
					"<td>&nbsp;&nbsp;</td>";
					lcRepInfoContent+="</tr>";
				}
				$("#PublicInfoBody").html(lcRepInfoContent);
				//受益人信息
				var lcBnfContent="";
				$("#scanApplycInfoBody").html(lcBnfContent);
				for(var k=0;k<obj.lcBnfList.length;k++){
					lcBnfContent+="<tr class='content' id=''>"+
					"<td>"+k+"</td>"+
					"<td>"+obj.lcBnfList[k].id.bnfType+"</td>"+
					"<td>"+obj.lcBnfList[k].name+"</td>"+
					"<td>"+obj.lcBnfList[k].sex+"</td>"+
					"<td>"+obj.lcBnfList[k].idType+"</td>"+
					"<td>"+obj.lcBnfList[k].idNo+"</td>"+
					"<td>"+obj.lcBnfList[k].relationToInsured+"</td>"+
					"<td>"+obj.lcBnfList[k].id.bnfGrade+"</td>"+
					"<td>"+obj.lcBnfList[k].bnfLot+"</td>"+
					"<td>&nbsp;&nbsp;&nbsp;</td>";
					lcBnfContent+="</tr>";
				}
				$("#scanApplycInfoBody").html(lcBnfContent);
				alert("保存成功!");
			}
	});
	}