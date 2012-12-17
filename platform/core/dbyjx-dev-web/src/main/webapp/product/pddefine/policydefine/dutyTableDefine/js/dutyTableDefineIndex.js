//点击缴费定义，通过riskcode和dutycode得到下面的要素。展示在“算法可用基本要素”
function defineDutyPay(){
	$.ajax({
	   type: "POST",
	   url: ctx + "/product/findFactorByRiskAndDuty",
	   data : {"riskCode":""+$("#dutyPayRiskCode").val(),"dutyCode":""+$("#dutyPayDutyCode").val()},
	   dataType : "json",
	   success: function(data){
		   var showContentString = "";
		   for(var i = 0 ; i < data.length ; i++){
			   showContentString += "<tr class='content'><td><input name='' value='' type='radio'/></td><td>"
			   	+data[i].factorOrder+"</td><td>"
			   	+data[i].calFactorType+"</td><td>"
			   	+data[i].factorName+"</td><td>"
			   	+data[i]["id.calFactor"]+"</td><td><input class='common' type='text' id=''></td><td>"
			   	+data[i].factorNoti+"</td><input type='hidden' value='"+data[i].calSQL+"'/>";
		   }
	   		$("#factorList").html(showContentString);
	   }
	});
}

//