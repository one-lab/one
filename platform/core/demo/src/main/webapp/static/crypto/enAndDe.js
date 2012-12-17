(function ($) {	
	jQuery.extend({
		packageAjax :function(opts){
			var temFun = function(){};
			var defaults = {
				type: "",
				url: "",
				dataType:"text",
				data: "",
				async:true,
				beforeSend:temFun,
				cache:true,
				complete:temFun,
				contentType:"application/x-www-form-urlencoded",
				//context:"",
				//dataFilter:"",
				success:temFun,
				error: temFun,
				global:true,
				ifModified:false,
				//jsonp:"",
				//jsonpCallback:"",
				//password:"",
				processData:true,
				//scriptCharset:"",
				//traditional:"",
				timeout:"",
				//username:"",
				//xhr:"",
				isEncryption:false,
				isDecryption:false
			};
			defaults = $.extend(defaults,opts);
			var strKey = $("#key").val();
alert("密钥：\n"+strKey);
	        key = mvc.crypto.hex.decode(strKey);
			//进行加密
			if(defaults.isEncryption) {			
	            var jsonString = JSON.stringify(defaults.data);
				var temArray = jsonString.split(",");
				var tem = "";
				for(var i = 0; i < temArray.length; i++){
					tem = temArray[i].split(":");
					var start = 0;
					var stop = 0;
					var content = "";
					if(tem.length > 2) {
						start = tem[2].indexOf('"');
						stop = tem[2].lastIndexOf('"');
						content = tem[2].substring(start+1,stop);
					} else {
						start = tem[1].indexOf('"');
						stop = tem[1].lastIndexOf('"');
						content = tem[1].substring(start+1,stop);
					}
					//获得需要加密的内容
					var data64 = Base64.encode(content);
	                var buffer = mvc.crypto.ascii.toInts(data64);
	                enText = mvc.crypto.xxtea.encryptInPlace(buffer, key);
	                var b64 = mvc.crypto.base64Ints.encode(buffer);
	                var reg=new RegExp(content,"g");
	                jsonString = jsonString.replace(reg, b64);
alert("数据正在加密:\n"+jsonString);
				}
				//defaults.data = jsonString;
				defaults.data = eval("(" + jsonString + ")");
				//alert(defaults.data);
			}
			
			$.ajax({
				type: defaults.type,
				url: defaults.url,
				dataType: defaults.dataType,
				data: defaults.data,
				async: defaults.async,
				beforeSend: defaults.beforeSend,
				cache: defaults.cache,
				complete: defaults.complete,
				contentType: defaults.contentType,
				//context:"",
				//dataFilter:"",
				success: function(data){
					var test = defaults.success;
					//判断是否解密
					if(defaults.isDecryption) {
						var cryParams = data.cryParams;
						//cryParam变成的数组赋值给temArray
						var temArray = cryParams.split(",");
						var enText = "";
						for(var i = 0; i < temArray.length; i++) {
							enText = data[temArray[i]];
							var buffer = mvc.crypto.base64Ints.decode(enText);
							mvc.crypto.xxtea.decryptInPlace(buffer, key);
							var clear64 = mvc.crypto.ascii.fromInts(buffer);
							//clear为解密之后的内容
							var clear = Base64.decode(clear64);
							data[temArray[i]] = clear;
						}
					}
					test(data);
				},
				error: defaults.error,
				global: defaults.global,
				ifModified: defaults.ifModified,
				//jsonp:"",
				//jsonpCallback:"",
				//password:"",
				processData: defaults.processData,
				//scriptCharset:"",
				//traditional:"",
				timeout: defaults.timeout
				//username:"",
				//xhr:"",
			});
			
		}
	});
})(jQuery);
