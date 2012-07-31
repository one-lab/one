/*!
 * tips
 * levone
 * Mail:zuoliwen@sinosoft.com.cn
 * Date: 2012-07-03
 */
(function ($) {
	 $.fn.extend({
		Grid: function(opts){
			var defaults = {
				url       : "menuJson.json" ,  
				datatype  : "json" ,        
				height    : "250" ,     
				width     : "auto",  
				colNames  : "", 
				colModel  : "",
				rowNum    : 10,    
				rowList   : [10, 20, 30],
				pager     : $('#pager2'),
				number    : true,
				multiselect: true	
			};
			var defaults = $.extend(defaults,opts);
			var self = this;
			createGridHead();
			function createGridHead() {
				var colNamesLength = defaults.colNames.length;
				var colModelLength = defaults.colModel.length;
				var $gridBox = $('<div class="grid_box"></div>');
				var $gridHeader = $('<div class="grid_head"></div>');
	            var $gridHeadColumn = $('<div class="gird_head_column"></div>');
				var $checkBox = $('<input type="checkbox" value="" name="all_sec" class="chex" />');
			
				if(colNamesLength != colModelLength) {
					alert("colNames的长度应该和数组colModel的长度相同");//这个地方将来可以替换成message	
					return false;
				}
				if(defaults.multiselect == true) {
					$gridHeadColumn.addClass("multiple").append($checkBox);
					$gridHeader.append($gridHeadColumn);	
				}
				if(defaults.number == true) {
					$gridHeader.append('<div class="gird_head_column">序号</div>')	;
				}
				for(var i = 0; i < defaults.colNames.length; i++) {
					$gridHeadColumn = $('<div class="gird_head_column"><div class="grid_menu clk"></div></div>');
					$gridHeadColumn.append("<span>"+ defaults.colNames[i] +"</span>");
					var modelName = defaults.colModel[i];
					if(modelName.id != "undefined") {
						$gridHeadColumn.attr("id", modelName.id);
					} 
					if(modelName.name != "undefined") {
						$gridHeadColumn.attr("name", modelName.name);						
					} 
					if(modelName.index != "index") {
						$gridHeadColumn.attr("index", modelName.index);
					} 
					if(modelName.width != "undefined") {
						$gridHeadColumn.css({"width": modelName.width});	
					}
					$gridHeader.append($gridHeadColumn);
					if((i + 1) < defaults.colNames.length) {
						$gridHeadColumn.bind("mouseover", changeNeedlePosition);
					}
					
				}
				$gridHeader.append('<div class="needle"></div>');
				$gridBox.append($gridHeader);
				self.append($gridBox);	
			};
			
			function changeNeedlePosition() {
				//先取到当前列的位置
				var headPosition = $(this).offset();
				var positionMove = headPosition.left + $(this).width() - 20;
				$(".grid_head .needle").css({left:positionMove})	
			};
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	});
})(jQuery);

