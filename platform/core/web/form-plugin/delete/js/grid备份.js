/*!
 * grid
 * levone
 * Mail:zuoliwen@sinosoft.com.cn
 * Date: 2012-07-03
 */
(function ($) {
	 $.fn.extend({
		Grid: function(opts){
			var defaults = {
				url       : "grid.json" ,  
				dataType  : "json" ,        
				height    : "auto" ,     
				width     : "auto",
				loadText  : "数据加载中…",
				colums    : "",
				rowNum    : "auto",
				rowList   : [10, 20, 30],
				number    : true,
				multiselect: true,
				sorts     : true,
				colDisplay: true,
				draggable : true,
				pages     : {
					pager    : true ,
					renew    : true ,
					paging   : true ,
					goPage   : true ,
					info     : true 
				}
			};
			var defaults = $.extend(defaults,opts);
			var g = $(this);
			var $gBox = $('<div class="grid_box"></div>');
			var $gHeader = $('<div class="grid_head"></div>');
			var $gHeadBox = $('<div class="head_box"></div>');
			var $gHeadColumn = $('<div class="gird_head_column"></div>');
			var $needle = $('<div class="needle"></div>');
			var $gView = $('<div class="grid_view"></div>');
			var $load = $('<div class="loading"><span>' + defaults.loadText + '</span></div>');
			var colAttributes = {};
			colAttributes.widths = [];
			colAttributes.aligns = [];
			colAttributes.colors = [];
			var widths = [],aligns = [],colors = [],allCh = [],hids = [];
			var $checkBox = $('<input type="checkbox" value="" name="all_sec" class="chex" />');
			var $gNumber = '';
			var adaptive = 0,str = 0,end = defaults.rowNum,pB = 1;
			var onOff,disb = true,oW,nW,tI,rows,pFirst,pPrev,pNext,pLast,pNub,pB = 1,pSel,ps,_stop;
			var _move=false;
			var _x;
			
			var _data;
					
			g.append($gBox);
			var $gW = $gBox.width();
			autoWidth();
			createGridHead();
			$gHeader.width($gW);
			$gView.width($gW);
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
				initGrid(_data, str, end ,colAttributes);
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
			
			//ajax加载数据
			function createData(){
				var url = defaults.url;
				var dataType = defaults.dataType;
				var type = defaults.type;
				$.ajax({
					url: url,
					dataType: dataType,
					type: type,
					async:false,
					processData: false,
					beforeSend : function(){loading()},
					error: function (XMLHttpRequest,errorThrown) {
						alert("数据加载出错！" + errorThrown);
					},
					success: function(data){
						initGrid(data, str, end ,colAttributes);
						_data = data;
						_stop = _data.rows.length;
					}
				});
			};
			
			function initGrid(data, startParam, endParam , colParams) {
				readJson(data, startParam, endParam , colParams);
				$load.hide();
				$('tr',$gView).hover(function(){
					$(this).addClass('hover');
				},function(){
					$(this).removeClass('hover');
				});
				$('tr',$gView).bind('click',trClick);
			};
			function isAllSelected(){
				for(var i = 0, len = allCh.length; i < len; i++){
					if(allCh[i] == false){
						return false
					};
				};
				return true;
			};
			function greadPage(){
				var $gPage = $('<div class="grid_page"><div class="grid_page_box"></div></div>');
				var $pBox = $('div.grid_page_box',$gPage)
				var $p = $('<div class="prick"></div>');
				ps = Math.ceil(rows.length/defaults.rowNum);
				if(defaults.pages.goPage){
					var goTo = '<div class="grid_entry"><select name="grid_pages">';
					for(i = 1; i < ps + 1; i++){
						goTo = goTo + '<option>' + i + '</option>';
					};
					goTo = goTo + '</select></div>';
					$pBox.append(goTo,'<div class="prick"></div>');
					pSel = $('select',$pBox);
					pSel.bind('change',{b:'select'},jampPage);
				};
				if(defaults.pages.paging){
					var $pagings = $('<span><b class="grid_page_fist unclick"></b></span><span><b class="grid_page_prev unclick"></b></span><div class="prick"></div><div class="grid_note"><input name="" type="text" class="page_nub" value="1" />页 共 '+ ps +' 页</div><div class="prick"></div><span><b class="grid_page_next"></b></span><span><b class="grid_page_last"></b></span><div class="prick"></div>');
					pFirst = $('b.grid_page_fist',$pagings);
					pPrev = $('b.grid_page_prev',$pagings);
					pNub = $('input.page_nub',$pagings);
					pNext = $('b.grid_page_next',$pagings);
					pLast = $('b.grid_page_last',$pagings);
					$pBox.append($pagings,$p);
					pFirst.bind("click",{b:'first'},pageFn);
					pPrev.bind("click",{b:'prev'},pageFn);
					pNext.bind("click",{b:'next'},pageFn);
					pLast.bind("click",{b:'last'},pageFn);
					pNub.bind('keyup',{b:'nub'},jampPage);
				};	
				if(defaults.pages.renew){
					var $refresh = $('<span title="刷新"><b class="grid_refresh"></b></span>');
					$pBox.append($refresh,$p);
					$refresh.bind('click',pageRefresh);
				};
				if(defaults.pages.info){
					var $info = $('<div class="grid_info">每页显示 '+ defaults.rowNum +' 条数据 - 共 '+ _stop +' 条数据</div>');
					$pBox.append($info);
				};
				$gBox.append($gPage);
			};
			function jampPage(e){
				var path = e.data.b,
					old = pB,
					on = 'unclick',
					un = !$(this).hasClass(on),
					lHas = pLast.hasClass(on),
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
				$('table',$gView).remove();
				loading();
				if(hids.length > 0){
					hideCol();
				}else{
					initGrid(_data, str, end,colAttributes);
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
				for(var i=str, k=0; i < end; i++, k++){
					var rowData = dataRows[i];
					var rowCells = rowData.cell;
					var rowCellsTemp = [];
					for(var j = 0,len = hids.length; j<len; j++){
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
				initGrid(dataTemp, 0, end - str,colAttributesTemp);
				//ddddddddd
				var tr = $("table > tbody > tr",$gView);
				var hideWidth = 0,tdW = 0;
				tr.each(function(j){
					for(i = 0; i < hids.length; i++){
						var hides = hids[i].isHide;
						var index = hids[i].index;
						var td;
						if(hides){
							td = $("td",$(this)).eq(index);
							tdW = td.width();
							td.hide();							
						};
						if(j == 0){
							hideWidth = hideWidth + tdW;
						};
					};				
				});
				var newTabW = oldTabW - hideWidth;
				$('table',$gView).width(newTabW);
			};
			function pageRefresh(){
				formatHead();
				$('table',$gView).remove();
				loading();
				initGrid(_data, str, end,colAttributes);
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
					$checkBox.attr("checked",false)
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
			//读取json数据
			function readJson(data, startParam, endParam , colParams){
				var gTable = '<table border="0" cellspacing="0" cellpadding="0">';		
				rows = data.rows;
				
				var colLen = defaults.colums.length;
				var allW = 0;
				gTable = gTable + '<tr class="th_rows">';
				if(defaults.multiselect){
					gTable  = gTable + '<td style="width:22px">&nbsp;</td>';
					allW += 22;
				};
				if(defaults.number){
					gTable = gTable + '<td style="width:30px">&nbsp;</td>';
					allW += 30;
				};
				for(i = 0; i < colLen; i++){				
					gTable  = gTable + '<td col="col_' + i + '" style="width:' + colParams.widths[i] + 'px">&nbsp;</td>';
					allW += Math.abs(colParams.widths[i]);
				};
				gTable  = gTable + '</tr>';
				for(j = startParam; j < endParam; j++){					
					var cell = rows[j].cell;
					gTable = gTable + '<tr id="row_' + j + '">';
					allCh.push(false);
					if(defaults.multiselect){
						gTable  = gTable + '<td class="multiple"><input name="g_check" type="checkbox" value="" /></td>';				
					};
					if(defaults.number){
						var tempIndex = j + 1 + str;
						gTable = gTable + '<td class="number" title="' + tempIndex + '"><span>' + tempIndex + '</span></td>' ;
					};
					for(i = 0; i < colLen; i++){
						var text = cell[i];
						gTable  = gTable + '<td col="col_' + i + '" title="' + text + '" style="text-align:' + colParams.aligns[i] + ';color:' + colParams.colors[i] + '"><span>' + text + '</span></td>';
					};
					gTable  = gTable + '</tr>';
				};
				gTable  = gTable + '</table>';
				$gView.append(gTable);
				$('tr:odd',$gView).addClass('odd');
				$('table',$gView).width(allW);
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
			//生成theader
			function createGridHead(){
				var col = defaults.colums;
				if(defaults.multiselect){
					$gHeadColumn.addClass("multiple").append($checkBox);
					$gHeader.append($gHeadColumn);
				};
				if(defaults.number){
					$gNumber = $('<div class="gird_head_column number"><span class="number">序号</span></div>');
					$gHeader.append($gNumber);
				};
				for(var i = 0; i < col.length; i++) {
					if(!defaults.sorts && !defaults.colDisplay){
						$gHeadColumn = $('<div class="gird_head_column cols col_' + i +'"></div>');
					}else{
						$gHeadColumn = $('<div class="gird_head_column cols col_' + i +'"><div class="grid_menu"></div></div>');
					};					
					$gHeadColumn.append("<span>"+ col[i].text +"</span>");
					if(col[i].id){
						$gHeadColumn.attr("id",col[i].id);
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
					if(col[i].width){
						$gHeadColumn.css({"width":col[i].width});
						colAttributes.widths.push(col[i].width);
					}else{
						$gHeadColumn.css({"width":adaptive});
						colAttributes.widths.push(adaptive);
					};
					if(col[i].align){
						colAttributes.aligns.push(col[i].align);
					}else{
						colAttributes.aligns.push("left");
					};
					if(col[i].color){
						colAttributes.colors.push(col[i].color);
					}else{
						colAttributes.colors.push("inherit");
					};
					if(defaults.pages.goPage || defaults.pages.paging){
						var _index = i;
						if(defaults.multiselect){
							_index += 1;
						} 
						if(defaults.number){
							_index += 1;
						}
						var obj = new HideInfo('col_' + i,false, _index);
						hids.push(obj);
					};
					$gHeader.append($gHeadColumn);
					$gHeadColumn
						.bind({"mouseover":changeNeedle,"mouseout":unHover})
						.children("div").bind("click",colMenuOpt);
					if(defaults.draggable){
						$gHeadColumn.bind("mousedown",moveThead)
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
							var nColIndex = nCol;
							if(defaults.multiselect){
								oCol = oCol - 1;
								nCol = nCol - 1;
							};
							if(defaults.number){
								oCol = oCol - 1;
								nCol = nCol - 1;
							}
							var temp = hids[oCol];
							temp.index = nColIndex;
							hids.splice(oCol,1);
							hids.splice(nCol,0,temp);
						};
						alert(testObj(hids))
					}
				});
				return false;
			};
			//打印obj
			function testObj(arr) {
				var result = "";
				for(var i=0;i<arr.length;i++){
					result += arr[i].getInfo() + ", ";
				}
				return result;
			};
			function HideInfo(name,isHide,index){
				this.name = name;
				this.isHide = isHide;
				this.index = index;
				this.getInfo = function(){
					return this.name + ": " + this.isHide + ": " + this.index;
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
						var text = defaults.colums[i].text;
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
			//menu操作
			function colMenuOpt(e){
				var $gM = $gBox.children('div.grid_head_menu');
				$('div.grid_head_menu',$gBox).hide();
				if($.browser.msie&&($.browser.version == "7.0")){
					$('div.grid_head_menu:last',$gBox).css('border-width','0')
				}
				var offset = $(this).offset();
				var nH = $(this).height();
				var pHead = $(this).parent();
				var sm = $gW - offset.left < $gM.width();
				pHead
					.siblings().removeClass('select')
					.children('div.grid_menu').removeClass('clk');
				$(this).addClass('clk');
				pHead.addClass('select');
				if(sm){
					$gM.css({'left':offset.left - $gM.width() - 5,'top':nH}).show();
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
				var _index = hI;
				if(defaults.multiselect){
					_index -= 1;
				};
				if(defaults.number){
					_index -= 1;
				};
				if(check.hasClass('chected')){
					//jjjjjjjjjjjjj
					if(disb){
						var tw = tb.width() - head.width();
						check.removeClass('chected');
						head.hide();
						tb.width(tw - bw);
						tr.each(function(){
							$("td",$(this)).eq(hI).hide();
						});						
						var obj = hids[_index];						
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
					var obj = hids[_index];
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
					formatWidth(oldW,$c.width(),index);
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
			//计算滚动条
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
				var col = defaults.colums;
				var check = defaults.multiselect;
				var num = defaults.number;
				var allW = 0;
				if(defaults.width){
					if(defaults.width == 'auto'){
						allW = $gW;
					}else{
						allW = defaults.width;
					};					
				}else{
					allW = $gW;
				};		
				var j = 0,b = 0;
				var hasWidth = 0;
				for(i = 0; i < col.length; i++){
					if(col[i].width){
						hasWidth = parseInt(hasWidth) + parseInt(col[i].width);
					}else{						
						j++;
					};
					b++;
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
					adaptive = Math.abs((allW - b - hasWidth) / j);
				}else{
					if(scrollWidth()){
						adaptive = Math.abs((allW - b - hasWidth - 17) / j);
					}else{
						adaptive = Math.abs((allW - b - hasWidth) / j);
					};				
				};
				
			}
		}
	});
})(jQuery);