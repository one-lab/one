/*!
 * tips
 * levone
 * Mail:zuoliwen@sinosoft.com.cn
 * Date: 2012-07-03
 */
(function ($) {
	 $.fn.extend({
		menu: function(opts){
			var defaults = {
				dataType  : "" ,     //后台传送过来的数据类型
				url       : "" ,        //ajax请求的路径
				type      : "get" ,     //ajax请求的方式
				loadText  : "加载中,请稍候…",  //加载提示
				error	  : "error",    //这个先不管，要往里边传值该怎么传？
				width     : 110,
				eventType : "click",    //mousemove/click
				animation : "toggle"   //toggle/slideToggle/fadeToggle
				
/*				silder    : false,
				silPostion: {
					top   : "auto",
					left  : "auto",
					right : "auto",
					bottom: "auto"
				}	*/			
				
			};
			var defaults = $.extend(defaults,opts);
		/*	if(defaults.silder){
				var silder = $.extend(defaults.silPostion,opts);
				var silT = silder.top;
				var silL = silder.left;
				var silR = silder.right;
				var silB = silder.bottom;
			};*/
			var _menu = $(this);
			var $menuHtml = $('<div class="ui_menu"></div>');
			var $itemHtml = $('<div class="sub_menu"><div class="sub_inner"></div></div>');
			var $load = $('<div class="loading">' + defaults.loadText + '</div>');
			var canClose = true;
			var level = 1;
			var menuWarp = _menu.attr("id") + "_box";
			var $menuBox = $('<div id="'+menuWarp+'"></div>');
			$("body").append($menuBox)
			/*var $switch = $('<div class="side_switch"><div class="side_cion"></div></div>');*/
		/*	if(defaults.silder){
				var silder = $.extend(defaults.silPostion,opts);
				var silT = silder.top;
				var silL = silder.left;
				var silR = silder.right;
				var silB = silder.bottom;
				$menuHtml = $('<div class="side_menu"></div>');
			};*/
			
			
			$.ajax({
				url: defaults.url,
            	dataType: defaults.dataType,
            	type: defaults.type,
				async:false,
				processData: false,
				beforeSend : function(){loading()},
				success: function(data){
							$load.hide();							
							if(defaults.dataType == "xml") {
								analyseXML(data);
							} else if(defaults.dataType == "json") {
								analyseJson(data);	
							} else if(defaults.dataType == "html"){
								analyseHtml(data);	
							};							
							$menuHtml.children("div:not(.side_inner)").bind(defaults.eventType,openMenu);														
							$("div.sub_inner > div.sub")
								.bind("click",selected)
								.bind(defaults.eventType,openMenu)								
								.bind({
									mouseover:function(){$(this).addClass("hover")},
									mouseout:function(){$(this).removeClass("hover")}
							});
							/*if(defaults.silder){
								$switch.bind("click",sildswitch)
							};*/
						},
				error: function (XMLHttpRequest,errorThrown) {
					alert("数据加载出错！" + errorThrown);
				},
				
			});	
			//ajax调用结束
			
			//loading动画
			function loading(){
				_menu.append($menuHtml);
				$menuHtml.append($load);
			}
			
			//打开菜单
			var hideId;
			function openMenu(){
				if(!canClose){
					canClose = true;
					return false;
				}
				if(!$(this).is(":animated"))
				var subId = $(this).attr("id") + "_sub";
				var subOffset = $(this).offset();
				var showIndex = $(this).parent().parent().attr("level");
				var menuZindex = parseInt(showIndex) + 10;
				$(document).bind("click",bodyClick);						
				if($(this).hasClass("has_sub")){
					hideId = $(this).attr("id");
					$("div.sub_menu,div.menu_shadow").hide();
					var menus = $("#" + subId).css({"left":subOffset.left,"top":subOffset.top + $(this).height()});
					menuOffset($(this),menus);
					if(defaults.animation == "fadeToggle"){
						menus.fadeOut("fast",function(){shadow(menus)});
					}else if(defaults.animation == "slideToggle"){
						menus.slideDown("fast",function(){shadow(menus)});
					}else{						
						menus.show();
						shadow(menus);
					};
					return false;
				}else{
					var menuId = $(this).attr("id");					
					$("div.sub_menu:not(:hidden)").each(function(){
						if($(this).attr("level") > showIndex){
							$(this).hide().next("div.menu_shadow").hide();
						};
					});
					if($("a > span.has_sub",$(this)).length > 0){
						var menus = $("#" + subId).css({"left":subOffset.left + $(this).width() + 4,"top":subOffset.top -2,"z-index":menuZindex});
						menuOffset($(this),menus);
						if(defaults.animation == "fadeToggle"){
							menus.fadeOut("fast",function(){shadow(menus,menuZindex)});
						}else if(defaults.animation == "slideToggle"){
							menus.slideDown("fast",function(){shadow(menus,menuZindex)});
						}else{					
							menus.show();
							shadow(menus,menuZindex);
						};
					};
					if($(this).parent().hasClass("ui_menu")){
						$("body > div.sub_menu,body > div.menu_shadow").hide();
					}
					return false
				};
			};
			//判断浏览器边界
			function menuOffset(p,m){
				var mW = m.width();
				var mH = m.height();
				var pL = p.offset().left;
				var pT = p.offset().top;
				var pW = p.width();
				var pH = p.height();
				var wW = $(window).width();
				var wH = $(window).height();
				var wL = $(window).scrollLeft();
				var wT = $(window).scrollTop();
				var r = pL + pW + mW > wW + wL;
				var b = pT + pH + mH > wH + wT;
				if(r && b){
					m.css({"left":pL - mW,"top":pT + pH - mH});
				}else if(r){
					m.css({"left":pL - mW});
				}else if(b){
					m.css({"top":pT + pH - mH});
				}
			}
			
			//选中状态
			function selected(){
				if($(this).find("span.has_sub").length > 0){
					canClose = false;
					return false;
				}
				if($(this).hasClass('selected')){
					$(this).removeClass("selected");
				}else{
					$(this)
					.addClass("selected")
					//.siblings().removeClass("selected");
				};	
						
			}
			//菜单之外点击关闭
			function bodyClick(e){
				$("div.sub_menu,div.menu_shadow",$menuBox).hide();
				$("div.menu_shadow").hide();
				$("div.ui_menu > div.selected").removeClass("selected");
				$(document).unbind("click",bodyClick);
				return false
			};
			
			//阴影
			function shadow(shdw,zind){
				var isShadow = shdw.next();				
				if(isShadow.is("div.menu_shadow")){
					isShadow.show();
				}else{
					var $shadow = $('<div class="menu_shadow"></div>');	
					var x = shdw.offset().left + 2;
					var y = shdw.offset().top + 2;
					var h = shdw.height() + 2;	
					$shadow.css({"width":parseInt(defaults.width) + 2,"height":h,"left":x,"top":y,"z-index":zind - 1});
					shdw.after($shadow);
				};
			};
			
			//sildmenu定位
			/*function silPostion(menu){
				menu.css({"left":silL,"right":silR,"top":silT,"bottom":silB})
			};*/
			//sildmenu开关
			/*function sildswitch(){
				$(this).next()
					.animate({width:"0"},function(){$(this).hide()})
			};*/			
			
			//解析xml方法
			function analyseXML(data) {
				if(defaults.silder){
					var $inner = $('<div class="side_inner"></div>');
					var $subMenu = $('<div class="sub_menu"><div class="sub_inner"></div></div>');
					$subMenu.width(defaults.width)
					$inner.append($subMenu)
					$menuHtml.append($switch).append($inner);
				}
				$(data).find("MenuItems > MenuItem").each(function(){
					var $menuCode = $('<div><a href="#"><span></span></a></div>');
					if($(this).attr("href") != undefined) {
						$menuCode = $("<div><a href='"+$(this).attr("href")+"'><span></span></a></div>");
					}					
					var $strongCode = $('<strong><b class="sub_icon"></b></strong>');									

					//首先判断他有没有子菜单
					if($(this).children().length > 0) {
						$menuCode.addClass("has_sub");						
						$menuCode.children("a").append($strongCode);
					};	
					if($(this).attr("icon") != undefined) {
						$("span", $menuCode).append("<img src='"+ $(this).attr("icon") +"' />");
					}
					if($(this).attr("callback")){
						$menuCode.attr("onclick",$(this).attr("callback"));
					};
					$("span", $menuCode).append($(this).attr("text"));
					$menuCode.attr("id", $(this).attr("id"));
					$menuHtml.append($menuCode);
				
					if($(this).children().length > 0) {
						xmlLoopItem($(this));
					}
				});
				_menu.prepend($menuHtml);
			}
			//xml递归循环调用
			function xmlLoopItem(menuItem){
				//第一遍是把该级菜单全部加在出来
				$itemHtml = $('<div class="sub_menu"><div class="sub_inner"></div></div>');
				//alert(menuItem.children().length);
				menuItem.children().each(function(){
					if($(this).get(0).tagName == "group"){
						$(".sub_inner", $itemHtml).append("<div class='menu_part'><span></span></div>");
					} else {
						var $itemCode = $('<div class="sub"><a href="#"></a></div>');
						if($(this).attr("href") != undefined) {
							$itemCode = $("<div class='sub'><a href='"+ $(this).attr("href") +"'></a></div>");	
						}
						var $itemSub = $('<span class="has_sub"></span>');
						//首先判断是否有子菜单
						if($(this).children().length > 0){
							$itemCode.children("a").append($itemSub);
						}
						if($(this).attr("icon") != undefined){
							$("a", $itemCode).css("background-image","url("+ $(this).attr("icon") +")");	
						}
						if($(this).attr("callback")){
							$itemCode.attr("onclick",$(this).attr("callback"));
						};
						if($(this).attr("selected")){
							$itemCode.addClass("selected");
						};
						$("a", $itemCode).append($(this).attr("text"));
						$itemCode.attr("id", $(this).attr("id"));
						$(".sub_inner", $itemHtml).append($itemCode);
						var subId = menuItem.attr("id") + "_sub"
						$itemHtml.attr({"id":subId,"level":level}).width(defaults.width);
					}
					
				});
				$menuBox.append($itemHtml);
				//第二遍是递归循环把该级菜单底下的子菜单全部加在出来
				menuItem.children().each(function(){
					if($(this).children().length > 0) {
						level++;
						xmlLoopItem($(this));	
					}
				});
				
			}
			
			
			
			//解析json方法
			function analyseJson(data) {
				for(var i = 0; i < data.MenuItems.length; i++){
					//先判断是否有子菜单
					var $menuCode = $('<div><a href="#"><span></span></a></div>');
					if(data.MenuItems[i].href != undefined) { 
						$menuCode = $("<div><a href='"+ data.MenuItems[i].href +"'><span></span></a></div>");
					}
					if(data.MenuItems[i].callback){
						$menuCode.attr("onclick",data.MenuItems[i].callback);
					};
					var $strongCode = $('<strong><b class="sub_icon"></b></strong>');
					if(data.MenuItems[i].MenuItems != undefined) {
						$menuCode.addClass("has_sub");						
						$menuCode.children("a").append($strongCode);	
					}
					if(data.MenuItems[i].icon != undefined){
						$("span", $menuCode).append("<img src='"+ data.MenuItems[i].icon +"' />");
					}
					$("span", $menuCode).append(data.MenuItems[i].text);
					$menuCode.attr("id", data.MenuItems[i].id);
					$menuHtml.append($menuCode);
					jsonLoopItem(data.MenuItems[i]);
				}
				
				_menu.prepend($menuHtml);
			}
			//json子菜单循环
			function jsonLoopItem(menuItem){
				//第一遍是把该级菜单全部加在出来
				if( menuItem.MenuItems != undefined) {
					$itemHtml = $('<div class="sub_menu"><div class="sub_inner"></div></div>');
					for(var i = 0; i < menuItem.MenuItems.length; i++) {
						var $itemCode = $('<div class="sub"><a href="#"></a></div>');
						if(menuItem.MenuItems[i].href != undefined) { 
							$itemCode = $("<div class='sub'><a href='"+ menuItem.MenuItems[i].href +"'></a></div>");
						}
						if(menuItem.MenuItems[i].selected == "true"){
							$itemCode.addClass("selected");
						}
						if(menuItem.MenuItems[i].callback){
							$itemCode.attr("onclick",menuItem.MenuItems[i].callback)
						};
						var $itemSub = $('<span class="has_sub"></span>');
						if(menuItem.MenuItems[i].MenuItems != undefined) {
							$itemCode.children("a").append($itemSub);
						}
						if(menuItem.MenuItems[i].icon != undefined) {
							$("a", $itemCode).css("background-image","url("+ menuItem.MenuItems[i].icon +")");
						};						
						$("a", $itemCode).append(menuItem.MenuItems[i].text);
						$itemCode.attr("id", menuItem.MenuItems[i].id);
						$(".sub_inner", $itemHtml).append($itemCode);
						if(menuItem.MenuItems[i].group == "true") {
							$(".sub_inner", $itemHtml).append("<div class='menu_part'><span></span></div>");	
						}
						var subId = menuItem.id + "_sub"
						$itemHtml.attr({"id":subId,"level":level}).width(defaults.width);
					}
					$menuBox.append($itemHtml);
					for(var i = 0; i < menuItem.MenuItems.length; i++) {
						if(menuItem.MenuItems[i].MenuItems != undefined) {
							level++;
							jsonLoopItem(menuItem.MenuItems[i]);	
						}
					}
				}
			}

				
			//解析html方法
			function analyseHtml(data) {				
				$(data).children().each(function(){
					var $menuCode = $('<div><a href="#"><span></span></a></div>');
					if($("a",this).attr("href") != undefined) {
						$menuCode = $("<div><a href='"+ $("a",this).attr("href") +"'><span></span></a></div>");	
					}
					var $strongCode = $('<strong><b class="sub_icon"></b></strong>');
					if( $(this).children("ul").length > 0 ) {
						$menuCode.addClass("has_sub");						
						$menuCode.children("a").append($strongCode);
					}
					if($(this).children("img").length > 0) {
						$("span", $menuCode).append("<img src='"+ $("img", this).attr("src") +"' />");								
					} 
					$menuCode.attr("id", $(this).attr("id"));
					$("span", $menuCode).append($("a", this).html());
					$menuHtml.append($menuCode);	
				});
				_menu.prepend($menuHtml);
				$(data).children().each(function(){
					var ul = $(this).children("ul");
					if( $(this).children("ul").length > 0 ) {
						htmlLoopItem(ul);
					}	
				});
			}
			//html子菜单循环
			function htmlLoopItem(itemHtml){
				//首先判断有子菜单吗
				$itemHtml = $('<div class="sub_menu"><div class="sub_inner"></div></div>');
				$itemHtml.width(defaults.width)
				$(itemHtml).children().each(function(){			
					if($(this).get(0).tagName == "LI") {
						var $itemCode = $('<div class="sub"><a href="#"></a></div>');
						if($("a",this).attr("href") != undefined) {
							$itemCode = $("<div class='sub'><a href='"+ $("a", this).attr("href") +"'></a></div>");	
						}
						var $itemSub = $('<span class="has_sub"></span>');
						//先判断是否有子菜单
						if($(this).children("ul").length > 0) {
							//alert($(this).attr("id"));
							$itemCode.children("a").append($itemSub);
						}
						if($(this).children("img").length > 0) {
							$("a", $itemCode).css("background-image","url("+ $("img", this).attr("src") +")");
						}
						if($(this).attr("callback")){
							$itemCode.attr("onclick",$(this).attr("callback"));
						};
						if($(this).attr("selected")){
							$itemCode.addClass("selected");
						};
						$itemCode.attr("id", $(this).attr("id"));
						$("a", $itemCode).append($("a", this).html());
						$(".sub_inner", $itemHtml).append($itemCode);
					} else {
						$(".sub_inner", $itemHtml).append("<div class='menu_part'><span></span></div>");	
					}
					var subId = $(itemHtml).parent().attr("id") + "_sub";
					$itemHtml.attr({"id":subId,"level":level}).width(defaults.width);					
				});
				$menuBox.append($itemHtml);
				$(itemHtml).children().each(function(){
					var ul = $(this).children("ul");
					if( $(this).children("ul").length > 0 ) {
						level++;
						htmlLoopItem(ul);
					}	
				});
			};
			var tempId = "";
			
		return { 
			 addcallback:function(fun){
				var id;
				var subId;
				var itemFn;			 	  
				if($.isFunction(fun)){
					if(tempId == "") {
						id = $("div.ui_menu > div",_menu);
						id.bind("click",fun);						
						subId = $menuBox.find("div.sub");
						subId.bind("click",fun);
					} else {
						id = $("#" + tempId);
						id.bind("click",fun);
						tempId = "";
					}
				}else{
					alert("回调参数不能为空！")
				};
			 }, 
			 id : function(id) {
				tempId = id;				
			 	return this;
			 }
		};
		}					
	});
})(jQuery);

