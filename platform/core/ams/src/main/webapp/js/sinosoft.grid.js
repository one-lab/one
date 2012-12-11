/*!
 * grid
 * levone
 * Mail:zuoliwen@sinosoft.com.cn
 * Date: 2012-07-03
 */
 //问题：：：：：：：对了，MB的忘了传个图片试试，下次传个图片试试，列的高度可能不够啊！！！！！！！！
 //现在就是start和end的问题了！！！！！！！！！！！！（把这两个弄明白！！！！！用的地方很多很多）
(function ($) {
	 $.fn.extend({
		Grid: function(opts){
			var defaults = {
				url       : "grid.json" ,  
				dataType  : "json" ,        
				height    : "auto" ,     
				width     : "auto",
				loadText  : "数据加载中…",
				colums    : "", //我擦~~~，这个colums是什么意思？？？？？？？？？
				rowNum    : "auto",  //代表每页显示多少条数据
				rowList   : [10, 20, 30],
				number    : true,     //代表是否有序号
				multiselect: true,    //代表是否多选
				sorts     : false,	  //表示列的排序，包含升序和降序	
				colDisplay: true,     //每一列点击那个小三角，出现的那个列显示
				draggable : true,
				sequence  : true,     //这个是什么意思？？？？？
				pages     : {
					pager    : true ,  //
					renew    : false , //
					paging   : true ,  //这个的意思就是点一下向右跳转的，点一下向左跳转的那东西有没有
					goPage   : true ,  //指的是select选择跳转
					info     : true    //
				},
				callback : {
					beforeDelData : function(gridNode){},
					afterDelData: function(gridNode){return false;}
				}
			};			
			var defaults = $.extend(defaults,opts);		
			var g = $(this);  //g代表引用该控件的div
			var $gBox = $('<div class="grid_box"></div>');
			//$gHeader里边包含$gHeadBox和$needle,其中$needle是列拖动的那个小竖条
			var $gHeader = $('<div class="grid_head"></div>');
			var $gHeadBox = $('<div class="head_box"></div>');
			//$gHeadColumn是每一列的字段名称div
			var $gHeadColumn = $('<div class="gird_head_column"></div>');
			//列拖拽的那道小竖线
			var $needle = $('<div class="needle"></div>');
			//放table的div
			var $gView = $('<div class="grid_view"></div>');
			var $load = $('<div class="loading"><span>' + defaults.loadText + '</span></div>');
//问题：：：下面这个变量是干什么的？？
//我觉的就是盛放所有列名的，错了，不是这样的，是放每一列的宽度，字段剧中还是靠左，字体的颜色。			
			var colAttributes = {};
			colAttributes.widths = [];
			colAttributes.aligns = [];
			colAttributes.colors = [];
//问题：：：我操！下边这几个变量又是干什么的？？？？？？？			
			var widths = [],aligns = [],colors = [],allCh = [],hids = [];
			var $checkBox = $('<input type="checkbox" value="" name="all_sec" class="chex" />');
			var $gNumber = '';
			//end代表每页显示多少条数据，即rowNum，但是为什么rowNum一超过20就会出现问题呢？？ 表格最右侧会有一块空白显示
			//adaptive是没有定义宽度的列的初始化宽度
//问题：：：：：str代表起始那个意思，具体还得好好分析分析！！！！！！！！！
			var adaptive = 0,str = 0,end = defaults.rowNum,pB = 1;
			//pageUnclick是那个向左向右按钮不能点击
			//total代表一共有多少条数据
			//ps代表一共有多少页
			var onOff,
				pageUnclik,
				disb = true,
				oW,
				nW,
				tI,
				rows,
				total,
				pFirst,
				pPrev,
				pNext,
				pLast,
				pNub,
				pB = 1,
				pSel,
				ps,
				_stop;
			var _move=false;
			var _x;
//_data是用来存放ajax接收过来的数据的。
			var _data;
			//g代表$(this)		
			g.append($gBox);
//下边这个$gBox之所以有宽度，只是因为他添加到了g中，而g是html页面中写好的div，宽度自适应，所以，你懂的
			var $gW = $gBox.width();
			//auto的作用是计算在调用控件的时候给没有width的列的宽度设置计算出来的默认宽度
			autoWidth(); 
			
			createGridHead();
			//生成grid header（第三遍看这里了，这一次要彻底弄懂所有的东西！！！！！）
			//在这个方法中会给colAttributes进行初始化赋值
			function createGridHead(){
			//col是defaults.colums，是你调用控件的时候，传入的所有的列头的信息
				var col = defaults.colums;
				//是否添加checkbox
				if(defaults.multiselect) {
					$gHeadColumn.addClass("multiple").append($checkBox);
					$gHeader.append($gHeadColumn);
				};
				//是否添加序号列
				if(defaults.number){
					//$gNumber是序号的列的div	
					$gNumber = $('<div class="gird_head_column number"><span class="number">序号</span></div>');
					$gHeader.append($gNumber);
				};
				for(var i = 0; i < col.length; i++){
//sorts代表？？？？？colDisplay代表？？？？？？？？
//sorts表示列的排序，包含升序和降序, colDisplay每一列点击那个小三角，出现的那个列显示
//排序或者列显示只要有一个在每一列的列头就加入<div class="grid_menu"></div>
					if(!defaults.sorts && !defaults.colDisplay) {
						$gHeadColumn = $('<div class="gird_head_column cols col_' + i +'"></div>');
					}else{
						$gHeadColumn = $('<div class="gird_head_column cols col_' + i +'"><div class="grid_menu"></div></div>');
					};					
					$gHeadColumn.append("<span>"+ col[i].text +"</span>");
					if(col[i].id){
						$gHeadColumn.attr("id", col[i].id);
					}else{
						alert("id不能为空");
						return false;
					};
					if(col[i].name){
						$gHeadColumn.attr("name",col[i].name);				
					}else{
						alert("name不能为空");
						return false;
					};
					if(col[i].index){ 
						$gHeadColumn.attr("index",col[i].index);
					};
//下面是给列添加width属性，如果调用控件的时候没给列附加width属性，那么就用上边计算出来的默认的列的宽度
					if(col[i].width){
						$gHeadColumn.css({"width":col[i].width});
//colAttributes.widths，ColAttributes是个对象，是每一列列头的属性的集合，widths是个数组，所有列的宽度的汇总
						colAttributes.widths.push(col[i].width);
					}else{
						$gHeadColumn.css({"width":adaptive});
						colAttributes.widths.push(adaptive);
					};
//这里是给列赋值align属性，让列中的文字内容居中，居左，还是居右对齐，如果调用控件的时候没有赋值，默认居左				
					if(col[i].align){
						colAttributes.aligns.push(col[i].align);
					}else{
						colAttributes.aligns.push("left");
					};
//问题：：：：这个color好像不是颜色，添加这个属性的地方注意下！！！！！！！！！！！！！！
//问题：：：：colors:inherit是什么意思，我操！！！！！！
//我懂了，这个color:inherit表示文字的颜色继承父标签的文字的颜色					
					if(col[i].color){
						colAttributes.colors.push(col[i].color);
					}else{
						colAttributes.colors.push("inherit");
					};
//问题：：：defaults.pages.goPage和defaults.pages.paging分别是什么意思？？？？？？？？
					if(defaults.pages.goPage || defaults.pages.paging){
						formatHids(i);
					};
					$gHeader.append($gHeadColumn);
//$gHeadColumn.children("div")找的div是<div class="grid_menu"></div>
//我操，我终于明白为什么鼠标移上去它会显示隐藏的div但是fireBug没有显示了，他是用css控制的
//因为你鼠标移上去的时候，会有hover这个class，然后上边的css是没有在hover底下找
//而下边他又写的css是在hover下，然后就出来了，可能在css文件中的改变他反应慢吧，开始的时候他不显示的，所以
//我就纳闷为什么fireBUG他不显示，但是页面上显示了				
					$gHeadColumn
						.bind({"mouseover":changeNeedle,"mouseout":unHover})
						.children("div").bind("click", colMenuOpt);
					if(defaults.sequence){
						$gHeadColumn.bind("click", colSequence);
					}
					if(defaults.draggable){
						$gHeadColumn.bind("mousedown",moveThead);
					};
				};
				$gHeader.append($needle);
				$gBox.append($gHeader);			
				if(defaults.sorts || defaults.colDisplay){
					greatMenu();
					$needle.bind("mousedown", dragCol);
				};
				$("div.gird_head_column",$gHeader).wrapAll($gHeadBox);
			};
//这个formatHids的作用就是new一个HideInfo对象，然后把这个对象放到hids数组中
//有几列（除checkbox和序号列），基本就会放入几个对象，除非那个goPage和那个paging都为false			
			function formatHids(i){
				var obj = new HideInfo('col_' + i, false);
				hids.push(obj);
			};
			function HideInfo(name,isHide){
				this.name = name;
				this.isHide = isHide;
				this.getInfo = function(){
					return this.name + ": " + this.isHide;
				};
			};
			//menu操作
			function colMenuOpt(e){
				var $gM = $gBox.children('div.grid_head_menu');
				$('div.grid_head_menu', $gBox).hide();
//问题：：：：$.browser.msie这个好像不起作用。。。				
				if($.browser.msie && ($.browser.version == "7.0")){
					$('div.grid_head_menu:last',$gBox).css('border-width','0')
				}
				var offset = $(this).offset();
				var nH = $(this).height();
				var pHead = $(this).parent();
				//总宽度 - 这个div的左边距 < 有grid_head_menu这个class的div
				var sm = $gW - offset.left < $gM.width();
//一旦列的右边的那个小三角被点击，里头那个div就会加入select这个class，所以当你点击别的列头的时候
//他会首先找到同辈的列头，然后如果有select就给丫儿删了				
				pHead
					.siblings().removeClass('select')
					.children('div.grid_menu').removeClass('clk');
				$(this).addClass('clk');
				pHead.addClass('select');
				if(sm){
					$gM.css({'left':offset.left - $gM.width() - 5,'top':nH}).show();
//问题：：：：：：我去，onOff这个是干嘛的啊，什么意思？？？？？？？？？？					
					onOff = false;
				}else{
					$gM.css({'left':offset.left - 5,'top':nH}).show();
					onOff = true;
				};
				$(document).bind("click",bodyClick);
				e.stopPropagation();
				var part = $('div.grid_head_menu > ul > li.parting',$gBox);
				//part.unbind('mouseover',subMopt);
				part.bind('mouseover',{part:part,onOff:onOff},subMopt);
			};
			
			
			$gHeader.width($gW);

			if(defaults.height != 'auto'){
				$gView.height(defaults.height - $gHeader.height() - 1);
			};
			if(defaults.width == 'auto'){
				$gBox.width($gW);
			}else{
				$gBox.width(defaults.width);
			};
			
			$gBox.append($gView);
			if(_data){
				loading();
				initGrid(_data,str,end,colAttributes);
				_stop = _data.rows.length;
			}else{
				createData();
			}
			$checkBox.bind("click",allClick);
			$gView.scroll(function(){
				var sL = $gView.scrollLeft();
				$gHeader.css('margin-left',-sL);
			});
			if(defaults.pager){
				greadPage();
			}
			$gView.width($gW).height($gView.height());
			//ajax加载数据
			function createData(){
				var url = defaults.url;
				var dataType = defaults.dataType;
				var type = defaults.type;
				$.ajax({
					url: url,
					dataType : dataType,
					type : type,
					data:"pageNo=1" + "&rowNum=" + defaults.rowNum,
					async : false,
					processData : false,
					beforeSend : function(){loading()},
					error : function (XMLHttpRequest,errorThrown) {
						alert("数据加载出错！" + errorThrown);
					},
					success: function(data){
						initGrid(data, str, end, colAttributes);
						_data = data;
						_stop = _data.rows.length;
					}
				});
			};
			
			function initGrid(data, startParam, endParam, colParams) {
				readJson(data, startParam, endParam, colParams);
				$load.hide();
				$('tr',$gView).hover(function(){
					$(this).addClass('hover');
				},function(){
					$(this).removeClass('hover');
				});
				$('tr',$gView).bind('click',trClick);
			};
			
			//问题：：：他这个表格的每一列的宽度是什么时候赋值的？？？我怎么木有发现啊？？？？？			
			//读取json数据(data, str, end, colAttributes)
			function readJson(data, startParam, endParam, colParams){
				var gTable = '<table border="0" cellspacing="0" cellpadding="0">';		
				rows = data.rows; //表格所有的数据赋值给rows			
				total = data.total; //total代表总共有多少条数据
				var colLen = defaults.colums.length; //一共有多少列			
				var allW = 0; //表格的总体的宽度
				gTable = gTable + '<tr class="th_rows">';
				if(defaults.multiselect) {
					gTable = gTable + '<td style="width:22px">&nbsp;</td>';
					allW += 22;
				};
				if(defaults.number) {
					gTable = gTable + '<td style="width:30px">&nbsp;</td>';
					allW += 30;
				};
				for(i = 0; i < colLen; i++){
//下面这个colParams哪里给赋值的？？？？？？？在createHeader的时候赋值的，看的时候你丫儿又没注意！
					gTable  = gTable + '<td col="col_' + i + '" style="width:' + colParams.widths[i] + 'px">&nbsp;</td>';
					allW += Math.abs(colParams.widths[i]);
				};
				gTable  = gTable + '</tr>';
				//下面这个if的意思是如果数据的条数小于规定的每页显示多少条
				if(rows.length < endParam){
					endParam = rows.length;
					pageUnclik = true;
				};
				for(j = startParam; j < endParam; j++){
					var cell = rows[j].cell;
					gTable = gTable + '<tr id="row_' + rows[j].id + '">';
					allCh.push(false);
					if(defaults.multiselect){
						gTable  = gTable + '<td class="multiple"><input name="g_check" type="checkbox" value="" /></td>';				
					};
					if(defaults.number){
						//jjjjjjj
						var tempIndex = j + 1 + str;
						gTable = gTable + '<td class="number"><span title="' + tempIndex + '">' + tempIndex + '</span></td>' ;
					};
					for(i = 0; i < colLen; i++){
						var text = cell[i];
						gTable  = gTable + '<td col="col_' + i + '" style="text-align:' + colParams.aligns[i] + ';color:' + colParams.colors[i] + '"><span title="' + text + '">' + text + '</span></td>';
					};
					gTable  = gTable + '</tr>';
				};
				gTable  = gTable + '</table>';
				$gView.append(gTable);
				$('tr:odd',$gView).addClass('odd');
				$('table',$gView).width(allW);
			};
			
			function isAllSelected(){
				for(var i = 0, len = allCh.length; i < len; i++){
					if(allCh[i] == false){
						return false
					};
				};
				return true;
			};
			
			//这块一定要弄懂了，删除数据之后的重新加载就靠它了！！！！！！！（不能这么说，这么说不对）
			function greadPage(){
				var $gPage = $('<div class="grid_page"><div class="grid_page_box"></div></div>');
				var $pBox = $('div.grid_page_box',$gPage);
				var $p = $('<div class="prick"></div>');
				ps = Math.ceil(_data.total/defaults.rowNum);
				if(defaults.pages.goPage) {
					var goTo = '<div class="grid_entry"><select name="grid_pages">';
					for(i = 1; i < ps + 1; i++){
						goTo = goTo + '<option>' + i + '</option>';
					};
					goTo = goTo + '</select></div>';
					$pBox.append(goTo,'<div class="prick"></div>');
					pSel = $('select', $pBox);
					pSel.bind('change', {b:'select'}, jampPage);
				};
				if(defaults.pages.paging){
					var $pagings = $('<span><b class="grid_page_fist unclick"></b></span><span><b class="grid_page_prev unclick"></b></span><div class="prick"></div><div class="grid_note"><input name="" type="text" class="page_nub" value="1" />页 共 '+ ps +' 页</div><div class="prick"></div><span><b class="grid_page_next"></b></span><span><b class="grid_page_last"></b></span><div class="prick"></div>');
					pFirst = $('b.grid_page_fist',$pagings); //跳转到表格的第一页
					pPrev = $('b.grid_page_prev',$pagings); //跳转到表格的上一页
					pNub = $('input.page_nub',$pagings);  //页面输入框
					pNext = $('b.grid_page_next', $pagings); //跳转到表格的下一页
					pLast = $('b.grid_page_last', $pagings); //跳转到表格的最后一页
					//pageUnclick是用来判断向左，向右那个按钮是否可以点击的
//问题：：：但是这里为什么只有右边的按钮的处理，没有左边按钮的处理，不对呀！！！！！！！！！！！！！					
					if(pageUnclik){
						pNext.addClass('unclick');
						pLast.addClass('unclick');
					};
					$pBox.append($pagings);
					pFirst.bind("click",{b:'first'},pageFn);
					pPrev.bind("click",{b:'prev'},pageFn);
					pNext.bind("click",{b:'next'},pageFn);
					pLast.bind("click",{b:'last'},pageFn);
//问题：：：：输入框那个方式好像不能完成页面的跳转，我记得以前是可以的？？？？？？？？？？？？？？					
					pNub.bind('keyup',{b:'nub'},jampPage); 
				};
				if(defaults.pages.renew){
					var $refresh = $('<span title="刷新"><b class="grid_refresh"></b></span>');
					$pBox.append($refresh,$p);
					$refresh.bind('click',pageRefresh);
				};
				if(defaults.pages.info){
					var $info = $('<div class="grid_info">每页显示 '+ defaults.rowNum +' 条数据 - 共 '+ total +' 条数据</div>');
					$pBox.append($info);
				};
				$gBox.append($gPage);
			};
			
			function jampPage(e){			
				//如果用bind绑定的时候传参数b，那么取值的时候是e.data.b
				//$(this)为select或者是nub
				//unclick代表不能点击，其实只是对跳至第一页，最后一页，上一页，下一页有效，
				//有unclikc表示不能点击该按钮
				var path = e.data.b,
					old = pB,
					on = 'unclick',
					un = !$(this).hasClass(on), //如果有unclick则un=false，如果没有unclick则un=true
					//lHas表示pLast是否有unclick这个class
					lHas = pLast.hasClass(on), 
					//fHas表示pFirst是否有unclick这个class
					fHas = pFirst.hasClass(on);
				if(path == 'nub'){			
					if(e.keyCode == 13){
						var tempNum = pNub.val();
						var ok = tempNum >= 1 && tempNum <= ps;
						if(ok){
							pB = tempNum;
						};
						str = (pB - 1) * defaults.rowNum;
						end = pB * defaults.rowNum;
						if(ok){
							if(tempNum == 1){
								if(!fHas){
									pFirst.addClass(on);
									pPrev.addClass(on);
								};
								if(lHas){
									pNext.removeClass(on);
									pLast.removeClass(on);
								};
							}else if(tempNum == ps){
								if(end > _stop)
								end = _stop;
								if(!lHas){
									pNext.addClass(on);
									pLast.addClass(on);
								};
								if(fHas){
									pFirst.removeClass(on);
									pPrev.removeClass(on);
								};
							}else{
								 if(lHas || fHas){
									pNext.removeClass(on);
									pLast.removeClass(on);
									pFirst.removeClass(on);
									pPrev.removeClass(on);
								};
							};
						}
						$(this).blur();
					}else{
						return false;
					};					
				}else if(path == 'select'){
				//pB代表你选择的select的值				
					pB = $(this).val();
					if(pB == 1){
						if(!fHas){
							pFirst.addClass(on);
							pPrev.addClass(on);
						};
						if(lHas){
							pNext.removeClass(on);
							pLast.removeClass(on);
						};
					}else if(pB == ps){
						//进入这个if表示当前select选择的是最后一页
						if(end > _stop)
							end = _stop;
						if(!lHas){
							pNext.addClass(on);
							pLast.addClass(on);
						};
						if(fHas){
							pFirst.removeClass(on);
							pPrev.removeClass(on);
						};
					}else{
						 if(lHas || fHas){
							pNext.removeClass(on);
							pLast.removeClass(on);
							pFirst.removeClass(on);
							pPrev.removeClass(on);
						};
					};
					str = (pB - 1) * defaults.rowNum;
					end = pB * defaults.rowNum;
					if(end > _stop)
					end = _stop;
				};
				rePage();
			};
			function pageFn(e){
				var path = e.data.b,
					on = 'unclick',
					un = !$(this).hasClass(on),
					lHas = pLast.hasClass(on),
					fHas = pFirst.hasClass(on);
				if(path == 'first' && un){
					if(!fHas){
						pFirst.addClass(on);
						pPrev.addClass(on);
						pNext.removeClass(on);
						pLast.removeClass(on);
					};
					pB = 1;
					str = 0;
					end = defaults.rowNum;
				}else if(path == 'prev' && un){
					if(lHas){
						pNext.removeClass(on);
						pLast.removeClass(on);
					};
					pB --;
					if(pB <= 1){
						pB = 1;
						pFirst.addClass(on);
						pPrev.addClass(on);
					};
					str = (pB - 1) * defaults.rowNum;
					end = pB * defaults.rowNum;
				}else if(path == 'next' && un){
					if(!lHas){
						pFirst.removeClass(on);
						pPrev.removeClass(on);
					};
					pB ++;
					if(pB >= ps){
						pB = ps;
						pNext.addClass(on);
						pLast.addClass(on);
					};
					str = (pB - 1) * defaults.rowNum;					
					end = pB * defaults.rowNum;
					if(end > _stop)
						end = _stop;
				}else if(path == 'last' && un){
					if(!lHas){
						pNext.addClass(on);
						pLast.addClass(on);
						pFirst.removeClass(on);
						pPrev.removeClass(on);
					};
					pB = ps;
					str = (pB - 1) * defaults.rowNum;
					end = _stop;				
				}else{
					return false;
				};
				
				rePage();
			};
			function rePage(){
				$.ajax({
					url: defaults.url,
					dataType: "json",
					type: "POST",
					data:"pageNo="+pB + "&rowNum=" + defaults.rowNum + "&pB=" +pB,
					async:false,
					processData: false,
					beforeSend : function(){
						
					},
					error: function (XMLHttpRequest, errorThrown) {
						alert("数据加载出错！" + errorThrown);
					},
					success: function(myData){
						_data = myData;
						if(_data.total < pB * defaults.rowNum) {
							//进入if表示数据的总条数 < 当前页数*每页的数据条数
							end = _data.total;
						} else {
							end = pB * defaults.rowNum;
						}
					}
				});
				$('table', $gView).remove();
				loading();
				if(hids.length > 0){
					hideCol();
				}else{
					initGrid(_data, str, end, colAttributes);
				};				
				if(defaults.pages.paging)
				pNub.val(pB);
				if(defaults.pages.goPage)
				pSel.val(pB);
			};
			function hideCol(){
				var oldTabW = $gView.width();			
				var dataTemp = {};
				var dataRows = _data.rows;				
				dataTemp.rows = [];
				var colAttributesTemp = {};
				colAttributesTemp.widths = [];
				colAttributesTemp.aligns = [];
				colAttributesTemp.colors = [];
				for(var i=0, k=0; i < dataRows.length; i++, k++){
					var rowData = dataRows[i];
					var rowCells = rowData.cell;
					var rowCellsTemp = [];
					for(var j = 0, len = hids.length; j<len; j++){
						var ok = hids[j];
						var index = ok.name.substring(ok.name.indexOf("_") + 1);
						rowCellsTemp.push(rowCells[index]);
						if(k == 0){
							colAttributesTemp.widths[j] = colAttributes.widths[index];
							colAttributesTemp.aligns[j] = colAttributes.aligns[index];
							colAttributesTemp.colors[j] = colAttributes.colors[index];
						};
					};
					dataTemp.rows[k] = {};
       				dataTemp.rows[k].cell = rowCellsTemp;
				};
				initGrid(_data,0,end - str,colAttributesTemp);
				var tr = $("table > tbody > tr",$gView);
				var hideWidth = 0,tdW = 0;
				tr.each(function(j){
					for(i = 0; i < hids.length; i++){
						var the = i;
						if(defaults.multiselect){
							the = the + 1;
						};
						if(defaults.number){
							the = the + 1;
						};
						var hides = hids[i].isHide;
						var index = hids[i].index;
						var td;
						if(hides){
							td = $("td",$(this)).eq(the);
							tdW = td.width();
							td.hide();							
						};
						if(j == 0){
							hideWidth = hideWidth + tdW;
						};
					};				
				});
				var newTabW = $gHeader.width();
				$('table',$gView).width(newTabW);
			};
			function pageRefresh(){
				var sM = $('div.grid_head_menu > div.grid_head_menu',$gBox).find('label');
				formatHead();				
				$('table',$gView).remove();
				loading();
				if(defaults.pages.goPage || defaults.pages.paging){
					var col = defaults.colums;
					hids = [];
					for(var i = 0; i < col.length; i++) {
//把所有的列名对象放入hids对象中						
						formatHids(i);
					};
				};
//你知道你为什么看不懂吗？？？？因为你没看一个方法的时候都忘了这个方法是干什么的，
//你还得重新回去看，然后才能知道这是干什么的，如果你能记住的话，就不是这样的了				
//问题：：：：这个initGrid是干什么的啊？？？？？？？？？？？我刚刚看过，他妈的就忘了				
				initGrid(_data, 0, end-str, colAttributes);
				sM.each(function(){
					if(!$(this).hasClass('chected')){
						$(this).addClass('chected');
					};
				});				
			};
			function formatHead(){
				var cols = $('div.cols',$gHeader);
				var hidTh = $('div.cols:hidden',$gHeader);
				for(i = 0; i < cols.length; i++){
					var wid = colAttributes.widths[i];
					cols.eq(i).width(wid);
				};
				if(hidTh.length > 0){
					hidTh.show();
				};
				if($checkBox.attr("checked")){
					$checkBox.attr("checked", false);
				};
			};
			function trClick(){
				if(defaults.multiselect){
					var cInpt = $("td:first > input",$(this));
					var theI = $(this).index() - 1;
					if($(this).hasClass('select')){
						$(this).removeClass('select');
						cInpt.attr("checked",false);
						allCh[theI] = false;
					}else{
						$(this).addClass('select');
						cInpt.attr("checked",true);
						allCh[theI] = true;
					};
					if(isAllSelected()){
						$checkBox.attr("checked",true);
					}else{
						$checkBox.attr("checked",false);
					};
				}else{
					if($(this).hasClass('select')){
						$(this).removeClass('select');
					}else{
						$(this).siblings().removeClass('select');
						$(this).addClass('select');
					};
				};
			};
			function allCheckedChange(isChecked){
				for(var i = 0, len = allCh.length; i < len; i++){
					allCh[i] = isChecked;
				};
			};
			function allClick(){
				var trs = $("table tr",$gView);
				var cInpt = $("table td input[name=g_check]",$gView);
				if($(this).attr("checked")=="checked"){
					cInpt.attr("checked",true);
					trs.addClass('select');
					allCheckedChange(true);
				}else{
					cInpt.attr("checked",false);
					trs.removeClass('select');
					allCheckedChange(false);
				}
			};

			//加载动画
			function loading(){
				if($('div.loading',$gView).length > 0){
					$load.show();
				}else{
					if(defaults.height){
						$load.css("padding-top",defaults.height/2 - 20)
					}
					$gView.append($load);
				};			
			}
			
			//排序
			function colSequence(){
				var isAsc;
				var sorts = [];
				var way = $(this).children("span");
				var ways = $(this).siblings().find("span");
				var listData = $('table > tbody > tr:not(:first)',$gView);
				var tdIndex = $(this).index();
				listData.each(function(i){
					var colsText = $(this).children('td').eq(tdIndex).text();
					var obj = new sortInfo(i,colsText);
					sorts.push(obj);
				});
				//alert(listData.eq(2).html())
				
				ways.removeClass();
				if(way.hasClass('up')){
					way.removeClass('up').addClass('down');
				}else{
					way.removeClass('down').addClass('up');
				};
				if(way.hasClass('down')){
					isAsc = true;
				}else{
					isAsc = false;
				};
				sortFn(sorts,isAsc);
				var sortedTrs = "";
				$('table > tbody > tr:not(:first)',$gView).remove();
				listData.removeClass("odd");
				for(var i=0,len=sorts.length; i<len; i++){
					var j = i + 1 & 1;
					var index = sorts[i].index;
					if(defaults.number){
						$('td.number',listData.get(index))
							.attr("title",i + 1)
							.children('span').text(i + 1);
					};
					if(j == 0){
						listData.eq(index).addClass("odd");
					}
					sortedTrs = sortedTrs + listData.get(index).outerHTML;
				};
				listData.remove();
				$('table > tbody',$gView).append(sortedTrs);
					
			};
			//快速排序
			function sortFn(arr,isAsc){
				return quickSort(arr,0,arr.length-1);
				function quickSort(arr,l,r){           
					if(l<r){        
						var mid=arr[parseInt((l+r)/2)].text,i=l-1,j=r+1;        
						while(true){
							if(isAsc){
								while(arr[++i].text < mid);
								while(arr[--j].text > mid);
							}else{
								while(arr[++i].text > mid);
								while(arr[--j].text < mid);
							}
							if(i>=j)break;
							var temp=arr[i];
							arr[i]=arr[j];
							arr[j]=temp;
						}      
						quickSort(arr,l,i-1);
						quickSort(arr,j+1,r);
					}
					return arr;
				};
			};
			
			//siblings找的是同辈的元素，挺好用的，用到它好几次了。
			function changeNeedle(){
				$(this)
					.addClass('hover')
					.siblings().removeClass('th_change');
				var offset = $(this).offset();
				var mL = parseInt($gHeader.css("margin-left"));
				var x = offset.left - g.offset().left + $(this).width() + Math.abs(mL) - 5;
				var y = offset.top - g.offset().top - 1;
				$needle.css({'left':x,'top':y});
				$(this).addClass('th_change');
			};
			function unHover(){
				$(this).removeClass('hover')
			};
			//列排序
			function moveThead(e){
				var $T = $(this);
				$T.siblings(".cols").addClass("can");
				$T.removeClass("can next");
				$T.nextAll().addClass("next");
				var oldL = $(this).offset().left;
				var oldT = $(this).offset().top;
				var $Tt = $('<div class="g_indicator no">' + $T.text() + '</div>');
				var $P = $('<div class="g_pointer"></div>');
				$gBox.append($Tt,$P);
				_move = true;
				_x = $T.offset().left;
				$(document).mousemove(function(e){
					var $e = $(e.target);
					var has = $e.hasClass("can");
					var par = $e.parent().hasClass("can");
					var nex = $e.hasClass("next");
					var pne = $e.parent().hasClass("next");
					var l,t;
					if(_move){
						x = e.clientX;
						y = e.clientY + 20;
						$Tt.css({"left":x,"top":y});
						if(nex || pne){
							$Tt.removeClass("no");
							if(nex){
								l = $e.offset().left +  $e.width() - g.offset().left - 8;
								t = $e.height();
							}else{
								l = $e.parent().offset().left +  $e.parent().width() - g.offset().left - 8;
								t = $e.parent().height();
							};
							$P.css({"left":l,"top":t});
						}else if(has || par){
							$Tt.removeClass("no");
							if(has){
								l = $e.offset().left - g.offset().left - 8;
								t = $e.height();
							}else{
								l = $e.parent().offset().left - g.offset().left - 8;
								t = $e.parent().height();
							}							
							$P.css({"left":l,"top":t});
						}else{
							$Tt.addClass("no");
							$P.attr("style","")
						};
					};
					return false;
				}).mouseup(function(e){
					_move=false;
					$(document).unbind('mousemove mouseup');
					if($Tt.hasClass("no")){
						$Tt.animate({top:oldT,left:oldL,opacity:0},400).queue(function(){
							$Tt.remove();
							$P.remove();
						});
					}else{
						var point = $(e.target);
						var oCol = $T.index();
						var nex = point.hasClass("next") || point.parent().hasClass("next");
						var bOra = true;
						$Tt.remove();
						$P.remove();
						if(point.parent().is(".cols")){
							point = point.parent();
						};
						var nCol = point.index();
						if(nex){
							$T.insertAfter(point);
							bOra = false;
						}else{
							$T.insertBefore(point);
						};
						$T.siblings().removeClass("can next");
						formatCol(oCol,nCol,bOra);
						if(hids.length > 0){
							if(defaults.multiselect){
								oCol = oCol - 1;
								nCol = nCol - 1;
							};
							if(defaults.number){
								oCol = oCol - 1;
								nCol = nCol - 1;
							};
							var temp = hids[oCol];
							hids.splice(oCol,1);
							hids.splice(nCol,0,temp);			
						};
					}
				});
				return false;
			};
			//打印obj
			function testObj(arr){
				var result = "";
				for(var i=0;i<arr.length;i++){
					result += arr[i].getInfo() + ", ";
				}
				return result;
			};
			
			function sortInfo(index,text){
				this.index = index;
				this.text = text;
				this.getInfo = function(){
					return this.index + ": " + this.text;
				}
			}
			//排td位置
			function formatCol(oCol,nCol,bOra){
				var $t = $('table > tbody > tr',$gView);
				$t.each(function(){
					var oT = $(this).children("td");
					if(bOra){
						oT.eq(oCol).insertBefore(oT.eq(nCol));
					}else{
						oT.eq(oCol).insertAfter(oT.eq(nCol));
					};
				});
			}
			
			//生成menu
			function greatMenu(){
				var gMb = '<div class="grid_head_menu"><ul>';
				if(defaults.sorts){
					gMb += '<li><div><span class="up"></span>升序排序</div></li><li><div><span class="down"></span>降序排序</div></li>';
				};
				if(defaults.colDisplay){
					gMb += '<li class="parting"><div><b class="parent"></b><span class="veiw"></span>列显示</div></li></ul>';
					gMb += '<div class="grid_head_menu"><ul>'
					for(i = 0;i < defaults.colums.length; i++){
						var text = defaults.colums[i].j;
						gMb += '<li><div><label class="chected">' + text + '</label></div></li>'
					};
					gMb += '</div>'
				};
				gMb += '</div>';
				$gBox.prepend(gMb);
				$('div.grid_head_menu > ul > li > div:not(.grid_head_menu)',$gBox)
					.bind('mouseover',function(){$(this).addClass('hover')})
					.bind('mouseout',function(){$(this).removeClass('hover')});
			};
			
			//子菜单事件
			function subMopt(e){
				if($.browser.msie&&($.browser.version == "7.0")){
					$('div.grid_head_menu:last',$gBox).css('border-width','1px')
				};
				var part = e.data.part;
				var onOff = e.data.onOff;
				var sM = $('div.grid_head_menu > div.grid_head_menu',$gBox);
					if(onOff){
						sM.css({'top':part.position().top,'left':part.position().left + 126}).show();
					}else{
						sM.css({'top':part.position().top,'left':-128}).show();
					};
					$('li',sM).unbind('click');
					$('li',sM).bind('click',subClick);
					return false;
			};
			//子菜单点击
			function subClick(e){
				e.stopPropagation();
				var check = $('div > label',$(this));
				var index = $(this).index();
				var head = $("div.col_" + index,$gHeader);
				var hI = head.index();
				var bw = $("div.gird_head_column[col]:visible",$gHeader).length;
				var tb = $("table",$gView);
				var tr = $("table > tbody > tr",$gView);
				var ul = check.parents('ul');
				var oI = hI;				
				if(defaults.multiselect){
					oI = oI - 1;
				};
				if(defaults.number){
					oI = oI - 1;
				};
				var obj = hids[oI];
				if(check.hasClass('chected')){
					if(disb){
						var tw = tb.width() - head.width();
						check.removeClass('chected');
						head.hide();
						tb.width(tw - bw);
						tr.each(function(){
							$("td",$(this)).eq(hI).hide();
						});
						obj.isHide=true;			
					}
				}else{
					var tw = tb.width() + head.width();
					check.addClass('chected')
					$('label.disabled',ul).removeClass('disabled');
					head.show();
					tb.width(tw);
					tr.each(function(){
						$("td",$(this)).eq(hI).show();
					});
					disb = true;
					obj.isHide=false;
				};
				var cl = $("label.chected",ul).length;
				if(cl == 1){
					var last = $('label.chected',ul);
					last.addClass('disabled');
					disb = false;					
				};	
			}
			
			//菜单之外点击关闭
			function bodyClick(e){
				var $gM = $('div.grid_head_menu',$gBox);
				var pHead = $('div.select',$gHeader);
				pHead
					.removeClass('select')
					.children('div.grid_menu').removeClass('clk');
				$gM.hide();
				if($.browser.msie&&($.browser.version == "7.0")){
					$gM.last().css('border-width','0')
				};
				$(document).unbind("click",bodyClick);
				return false
			};
			//列拖拽
			function dragCol(e){
				//dddddddddddddd
				$('div.grid_head_menu',$gBox).hide();
				var $c = $("div.th_change",$gHeader);
				var mL = parseInt($gHeader.css("margin-left"));
				var oldW = $c.width();
				var index = $c.index();
				var colL = $c.position().left;
				var colW = $c.width();
				var $rL = $('<div class="ruler left"></div>');
				var $rR = $('<div class="ruler right"></div>');
				var x,y,p;
				if($('div.ruler',$gView).length > 0){
					$rL = $('div.left',$gBox);
					$rR = $('div.right',$gBox);
					$rL.show().css("left",colL + mL - 1);
					$rR.show().css("left",colL + colW + mL);
				}else{
					$rL.css("left",colL - 1);
					$rR.css("left",colL + colW);
					$gView.append($rL,$rR);
				};
				//$gBox.css("position","relative");
				_move = true;
				_x = $c.offset().left;
				p = _x - colL;
				$(document).mousemove(function(e){
					if(_move){
						x = e.pageX - p + mL;//移动时根据鼠标位置计算控件左上角的绝对位置
						if(x >= colL + mL + 20){
							$rR.css("left",x);
						};
					};
					return false;
				}).mouseup(function(e){
					_move=false;
					$(document).unbind('mousemove mouseup');
					$rL.hide();
					$rR.hide();
					//$gBox.css("position","static");
					if(e.pageX - _x > 20){
						$c.width(e.pageX - _x);
					}else{
						$c.width(20);
					};
					oW = oldW;
					nW = $c.width();
					tI = index;
					formatWidth(oldW,nW,index);
					if(defaults.multiselect)
					tI = index - 1;
					if(defaults.number)
					tI = index - 1;
					colAttributes.widths.splice(tI - 1,1,nW);
				});
				return false;
			};
			
			//改变td宽度
			function formatWidth(oldW,newW,i){
				var $f = $('table > tbody > tr:first > td',$gView);
				var tW = $('table',$gView).width();
				var z = tW + (newW - oldW);
				var n = tW - (oldW - newW);
				$f.eq(i).width(newW);
				if(newW > oldW){
					$('table',$gView).width(z);
					$gHeader.width(z);
				}else{
					$('table',$gView).width(n);
					$gHeader.width(n);
				};
				if($checkBox.attr("checked")){
					$checkBox.attr("checked",false)
				};
			};
			//计算滚动条(一般是不会出现滚动条的)
			function scrollWidth(){			
				if(end == "auto"){
					var url = defaults.url;
					var dataType = defaults.dataType;
					$.ajax({
						url: url,
						dataType: dataType,
						async:false,
						success: function(data){
							end = data.rows.length;
							_data = data;
							_stop = end;
						}
					});
				};
				if(defaults.height < end * 21){
					return true;
				}else{
					return false;
				};
			}
			//算header中td宽度
			function autoWidth(){
				var col = defaults.colums; //sb了，这个不是空的，他是在调用该控件的时候传过来的值。。。所有的列名
				var check = defaults.multiselect; //判断是否需要checkbox
				var num = defaults.number;  //是否需要序列号
				var allW = 0;
				//下面这个if是给allW赋值
				if(defaults.width){
					if(defaults.width == 'auto'){
						allW = $gW;
					}else{
						allW = defaults.width;
					};					
				}else{
					allW = $gW;
				};		
				var j = 0,b = 0;//b的作用是记录共有表格共有多少列，包含序号列和checkbox，如果有的话
				var hasWidth = 0;
				for(i = 0; i < col.length; i++){
					if(col[i].width){
						hasWidth = parseInt(hasWidth) + parseInt(col[i].width);
					}else{						
						j++; //如果没有给列定义宽度，那么j++
					};
					b++; //每循环一次b加1
				};
				if(check){
					allW = allW - 22;
					b++;
				};
				if(num){
					allW = allW - 30;
					b++;
				};
				if(defaults.height == 'auto'){
//问题：：：他这个计算值的时候还有减去b？？？好像是因为每一个列右侧都有1px的间距，所以要减去，要不就宽了。
//因为总宽度是固定的，而你的不减去这列多出来的1px，最后就会出现问题
					adaptive = Math.abs((allW - b - hasWidth) / j);
				}else{
					if(scrollWidth()){
						//这个17是为滚动条留出来的----
						adaptive = Math.abs((allW - b - hasWidth - 17) / j);
					}else{
						adaptive = Math.abs((allW - b - hasWidth) / j);
					};				
				};
				
			}
			
			
			
			//这块一定要弄懂了，删除数据之后的重新加载就靠它了！！！！！！！（不能这么说，这么说不对）
			function reGreadPage() {
				var $gPage = $('<div class="grid_page"><div class="grid_page_box"></div></div>');
				var $pBox = $('div.grid_page_box',$gPage);
				var $p = $('<div class="prick"></div>');
				if(defaults.pages.goPage) {
					var goTo = '<div class="grid_entry"><select name="grid_pages">';
					for(i = 1; i < ps + 1; i++){
						goTo = goTo + '<option>' + i + '</option>';
					};
					goTo = goTo + '</select></div>';
					$pBox.append(goTo,'<div class="prick"></div>');
					pSel = $('select', $pBox);
					$($pBox).find("select").val(pB);
					pSel.bind('change', {b:'select'}, jampPage);
				};
				if(defaults.pages.paging){
					var $pagings = $('<span><b class="grid_page_fist"></b></span><span><b class="grid_page_prev"></b></span><div class="prick"></div><div class="grid_note"><input name="" type="text" class="page_nub" value="1" />页 共 '+ ps +' 页</div><div class="prick"></div><span><b class="grid_page_next"></b></span><span><b class="grid_page_last"></b></span><div class="prick"></div>');
					pFirst = $('b.grid_page_fist',$pagings); //跳转到表格的第一页
					pPrev = $('b.grid_page_prev',$pagings); //跳转到表格的上一页
					pNub = $('input.page_nub',$pagings);  //页面输入框
					pNext = $('b.grid_page_next', $pagings); //跳转到表格的下一页
					pLast = $('b.grid_page_last', $pagings); //跳转到表格的最后一页					
					$pBox.append($pagings);
					pNub.val(pB);
					pFirst.bind("click",{b:'first'},pageFn);
					pPrev.bind("click",{b:'prev'},pageFn);
					pNext.bind("click",{b:'next'},pageFn);
					pLast.bind("click",{b:'last'},pageFn);
//问题：：：：输入框那个方式好像不能完成页面的跳转，我记得以前是可以的？？？？？？？？？？？？？？					
					pNub.bind('keyup',{b:'nub'},jampPage); 
				};
				if(defaults.pages.renew){
					var $refresh = $('<span title="刷新"><b class="grid_refresh"></b></span>');
					$pBox.append($refresh,$p);
					$refresh.bind('click',pageRefresh);
				};
				if(defaults.pages.info){
					var $info = $('<div class="grid_info">每页显示 '+ defaults.rowNum +' 条数据 - 共 '+ total +' 条数据</div>');
					$pBox.append($info);
				};
				$gBox.append($gPage);
			};
			
			
			
			
			//一个是刷新数据，一个是删除数据
			jQuery.extend({
				grid : {
					delGridData : function(delUrl, theThis) {
						//删除数据之前先调用beforeDelData，然后再删除
						defaults.callback.beforeDelData(theThis);
						//得到该节点的id
						var trId = $(theThis).parents("tr").attr("id");
						var idArray = trId.split("row_");
						$.ajax({
							url: delUrl,
							dataType: "text",
							type: "GET",
							data:"dataId=" + idArray[1],
							beforeSend : function(){
							},
							error: function (XMLHttpRequest, errorThrown) {
								alert("数据加载出错！" + errorThrown);
							},
							success: function(myData){
								if(myData == "success") {
									alert("删除成功！");
									//调用afterDelData函数
									if(!defaults.callback.afterDelData()){
										//做一次查询，把接删除后的数据结果返回
										//首先判断当前页是否还有数据，如果没有，则传的是上一页的页码，如果有的话，则传的是这页的页码
										if($(".grid_view").find("tr").length > 6) {
											//说明还在当前页
											$.ajax({
												type: "GET",
												url: defaults.url,
												dataType: "json",
												data:"test=" + pB + "&rowNum=" + defaults.rowNum,
												success: function(loadData) {
													$('table',$gView).remove();
													var dataEnd = (pB-1)*defaults.rowNum + loadData.rows.length;
													initGrid(loadData, 0, dataEnd, colAttributes);
												},
												error:function(XMLHttpRequest, errorThrown) {
													alert("数据加载出错！" + errorThrown);
												}
											});
										} else {
											//传入的页码是上一页
											$.ajax({
												type: "GET",
												url: defaults.url,
												dataType: "json",
												data:"test=" + pB + 2 + "&rowNum=" + defaults.rowNum,
												success: function(loadData) {
													var on = "unclick";
													if(pB != 1) {
														pB = pB - 1;
													}
													str = (pB - 1) * defaults.rowNum;
													ps = Math.ceil(loadData.total/defaults.rowNum);
													total = loadData.total;
													$(".grid_page").remove();
													reGreadPage();
													if((ps == pB && ps == 1) || ps == 0) {
														pNext.removeClass(on);
														pLast.removeClass(on);
														pFirst.removeClass(on);
														pPrev.removeClass(on);
														pNext.addClass(on);
														pLast.addClass(on);
														pFirst.addClass(on);
														pPrev.addClass(on);
													} else if(ps == pB) {
														pNext.removeClass(on);
														pLast.removeClass(on);
														pFirst.removeClass(on);
														pPrev.removeClass(on);
														pNext.addClass(on);
														pLast.addClass(on);
													} else if(pB == 1) {
														pNext.removeClass(on);
														pLast.removeClass(on);
														pFirst.removeClass(on);
														pPrev.removeClass(on);
														pFirst.addClass(on);
														pPrev.addClass(on);		
													}
													$('table',$gView).remove();
													var dataEnd = (pB-2)*defaults.rowNum + loadData.rows.length;
													initGrid(loadData, 0, dataEnd, colAttributes);
												},
												error:function(XMLHttpRequest, errorThrown) {
													alert("数据加载出错！" + errorThrown);
												}
											});
											
										}
										
									} else {
										alert("删除失败！");
									}
								}
							}
						});
					}
				}
			});
			
			
			
			
			
		}
	});
})(jQuery);