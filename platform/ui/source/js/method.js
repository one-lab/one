/*!
 * method
 * levone
 * Mail:zuoliwen@sinosoft.com.cn
 * Date: 2012-06-28 14:40:21
 */
$(function(){
	if($("form").size() > 0){
		$("form").bind("submit",function(){
			var $putInp = $('<input type="hidden" name="_method" value="put" />');
			var $deleteInp = $('<input type="hidden" name="_method" value="delete" />');
			if($(this).attr("method") == "put"){
				$(this)
					.attr("method","post")
					.append($putInp);
			}else if($(this).attr("method") == "delete"){
				$(this)
					.attr("method","post")
					.append($deleteInp);
			};
		})
	}
})