(function(a){a.fn.extend({tips:function(b){var h={type:"toolTip",content:"",title:"",width:"auto",maxwidth:200,maxHeight:"auto",pointer:true,tipPostion:"top",hideTime:1000,autoHide:true,closeBtn:false,eventType:"mouseover",winTipSite:"leftTop"};var h=a.extend(h,b);if(h.type=="toolTip"){var j=a('<div class="tips"><div class="skin skin_0"><div class="skin_line"><div class="tips_cont"><div class="tips_padding" id="tipsText">Undfind</div></div><div class="pointer"></div></div></div></div>');l(j);j.hover(function(){a(this).show()},function(){a(this).hide()});a(this).each(function(){var q="";if(a(this).attr("title")){q=a(this).attr("title");a(this).removeAttr("title").attr("tip",q)}else{if(a(this).attr("alt")){q=a(this).attr("alt");a(this).removeAttr("alt").attr("tip",q)}}});a(this).mouseover(function(s){var q=a(this).attr("tip");var r=a(this);if(q){a("#tipsText").text("").text(q);j.show();if(h.maxwidth!="auto"){a("#tipsText").css({width:"auto","white-space":"nowrap"});if(a("#tipsText").width()>h.maxwidth){a("#tipsText").css("white-space","normal").width(h.maxwidth)}}e(r,j,s);p(j,r,s)}if(h.width!="auto"){a("#tipsText").width(h.width)}}).mouseout(function(){j.hide()})}else{if(h.type=="customTip"){var m=h.content;var i=a('<div class="tips"><div class="skin_1"><div class="skin_line bottom_left"><div class="tips_cont"><div class="tips_padding" id="customText">Undfind</div></div><div class="pointer"></div></div></div></div>');if(h.closeBtn){var n=a('<div class="close"></div>');var k=a(this);a("div.skin_line",i).append(n);n.click(function(){i.hide()})}if(h.title){var g=a('<div class="tips_title">'+h.title+"</div>");a("div.skin_line",i).prepend(g)}l(i);if(h.width){i.width(h.width)}a("div.tips_padding",i).html(m);var f=h.eventType;k.bind(f,function(q){if(jQuery.isFunction(m)){a("div.tips_padding",i).html(m)}i.show();e(k,i,q);p(i,k,q)})}else{if(h.type=="windowTip"){var c=a('<div class="tips"><div class="skin_1 tip_window"><div class="skin_line bottom_left"><div class="tips_cont"><div class="tips_padding">未定义</div></div></div></div></div>');var k=a(this);if(h.title){var g=a('<div class="tips_title">'+h.title+"</div>");a("div.skin_line",c).prepend(g)}if(h.closeBtn){var n=a('<div class="close"></div>');a("div.tips_title",c).prepend(n);n.click(function(){c.hide()})}if(h.wight){c.width(h.wight)}l(c);a("div.tips_padding",c).html(h.content);var o=function(q){k.unbind("click",o);d(c);c.fadeIn().delay(h.hideTime).fadeOut(function(){k.bind("click",o)});q.stopPropagation()};k.bind("click",o)}}}function l(q){a("body").append(q)}function e(s,q,v){var u=s.offset().top+s.height()+9;var t=v.pageX-15;if(h.pointer==false){a("div.pointer",j).hide()}else{var r=a("div.skin_line",j);if(h.tipPostion=="bottom"){r.addClass("top_left")}else{if(h.tipPostion=="top"){u=Math.abs(s.offset().top-q.height()-9);r.addClass("bottom_left")}else{if(h.tipPostion=="right"){u=Math.abs(s.offset().top+s.height()/2-15);t=Math.abs(s.offset().left+s.width()+10);r.addClass("left_top")}else{if(h.tipPostion=="left"){u=Math.abs(s.offset().top+s.height()/2-16);t=Math.abs(s.offset().left-q.width());r.addClass("right_top")}}}}}q.css({left:t,top:u})}function d(t){var v=a(window).scrollLeft();var u=a(window).scrollTop();var r=u+a(window).height()-t.height();var s=v+a(window).width()-t.width();var w=u+a(window).height()/2-t.height()/2;var q=v+a(window).width()/2-t.width()/2;if(h.winTipSite=="leftBottom"){u=r}else{if(h.winTipSite=="rightTop"){v=s}else{if(h.winTipSite=="rightBottom"){v=s;u=r}else{if(h.winTipSite=="center"){v=q;u=w}}}}a(window).scroll(function(){v=a(window).scrollLeft();u=a(window).scrollTop();r=u+a(window).height()-t.height();s=v+a(window).width()-t.width();w=u+a(window).height()/2-t.height()/2;q=v+a(window).width()/2-t.width()/2;if(!t.is(":hidden")){if(h.winTipSite=="leftBottom"){u=r}else{if(h.winTipSite=="rightTop"){v=s}else{if(h.winTipSite=="rightBottom"){v=s;u=r}else{if(h.winTipSite=="center"){v=q;u=w}}}}t.animate({top:u,left:v},{duration:600,queue:false})}});t.css({left:v,top:u})}function p(C,u,K){var M=a("div.skin_line",C);var N=C.height()+10;var G=C.width()+10;var s=C.css("left");var E=C.css("top");var J=u.width()+12;var q=u.height();var A=u.offset().left;var w=u.offset().top;var H=a(window).width();var O=a(window).height();var v=a(window).scrollLeft();var F=a(window).scrollTop();var L=O+F<w+q+N;var B=w-F<N;var I=G<J;var D=H+v<A+J+G;var z=M.attr("class");if(!M.attr("oldClass")){M.attr("oldClass",z)}if(L&&D){M.removeClass().addClass("skin_line bottom_right");E=w-N;s=A-G+J;C.css({left:s,top:E})}else{if(L&&I){M.removeClass().addClass("skin_line bottom_left");E=w-N;if(h.type=="toolTip"){s=A+J/2}else{if(h.type=="customTip"){s=A+G/6}}C.css({left:s,top:E})}else{if(B&&I){M.removeClass().addClass("skin_line top_left");if(h.type=="toolTip"){E=w+q+8;s=A+J/2}else{if(h.type=="customTip"){E=w+q+12;s=A+G/6}}C.css({left:s,top:E})}else{if(B&&D){M.removeClass().addClass("skin_line top_right");if(h.type=="toolTip"){E=w+q+8;s=A-G+J/2}else{if(h.type=="customTip"){E=w+q+8;s=A+J-G}}C.css({left:s,top:E})}else{if(L){M.removeClass().addClass("skin_line bottom_left");E=w-N;C.css({left:s,top:E})}else{if(B){M.removeClass().addClass("skin_line top_left");E=w+q+8;C.css({left:s,top:E})}else{if(I){M.removeClass().addClass("skin_line left_top");s=A+J;E=w+q/6;C.css({left:s,top:E})}else{if(D){M.removeClass().addClass("skin_line right_top");s=A-G;E=w+q/6;C.css({left:s,top:E})}else{M.removeClass().addClass(M.attr("oldClass"))}}}}}}}}}}})})(jQuery);
