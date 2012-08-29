//点击缴费定义，通过riskcode和dutycode得到下面的要素。展示在“算法可用基本要素”
function defineDutyPay(){
	$.ajax({
	   type: "POST",
	   url: contextRootPath + "/product/findFactorByRiskAndDuty.do",
	   data : {"riskCode":""+$("#dutyPayRiskCode").val(),"dutyCode":""+$("#dutyPayDutyCode").val()},
	   dataType : "json",
	   success: function(obj){
		   var showContentString = "";
		   for(var i = 0 ; i < obj.data.length ; i++){
			   showContentString += "<tr class='content'><td><input name='' value='' type='radio'/></td><td>"
			   	+obj.data[i].factorOrder+"</td><td>"
			   	+obj.data[i].calFactorType+"</td><td>"
			   	+obj.data[i].factorName+"</td><td>"
			   	+obj.data[i]["id.calFactor"]+"</td><td><input class='common' type='text' id=''></td><td>"
			   	+obj.data[i].factorNoti+"</td><input type='hidden' value='"+obj.data[i].calSQL+"'/>";
		   }
	   		$("#factorList").html(showContentString);
	   }
	});
}

//