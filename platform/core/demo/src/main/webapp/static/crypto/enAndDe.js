(function ($) {	
	jQuery.extend({
		packageAjax :function(opts){
			var temFun = function(){};
			var defaults = {
				type: "",
				url: "",
				dataType:"text",
				data: {},
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
	        key = mvc.crypto.hex.decode(strKey);
			//进行加密
			if(defaults.isEncryption) {
                var encryptoAttrNames = (defaults.data.crypto_attributies_names && defaults.data.crypto_attributies_names != "") ? defaults.data.crypto_attributies_names.split(",") : "";
                this.encryptoObject(defaults.data, encryptoAttrNames);
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
			
		},
        escapeCharacter : function(content) {
            var result = "";
            var specialCharacters = "^$.*+?=!:|/()[]{}\\";
            for(var i= 0, len=content.length; i<len; i++) {
                var aChar = content.charAt(i);
                if(specialCharacters.indexOf(aChar) != -1) {
                    result = result.concat("\\");
                }
                result = result.concat(aChar);
            }
            return result;
        },
        encryptoObject : function(obj, attrArray) {
            if(attrArray && attrArray.length > 0) {
                for(var i = 0, len = attrArray.length; i<len; i++) {
                    var attr = attrArray[i];
                    if(attr.indexOf(".") == -1) {
                        var attrValue = obj[attr];
                        obj[attr] = this.encrypto(attrValue);
                    } else {
                        var attrs = attr.split(".");
                        var firstAttrValue = obj[attrs[0]];
                        if(typeof firstAttrValue == "object" && !(firstAttrValue instanceof Array)) {
                            var tempAttrArray = [];
                            tempAttrArray.push(attr.substring(attr.indexOf(".") + 1));
                            this.encryptoObject(firstAttrValue, tempAttrArray)
                        } else if(typeof firstAttrValue == "object" && (firstAttrValue instanceof Array)) {
                            this.encryptoObjectArray(firstAttrValue,  attr.substring(attr.indexOf(".") + 1));
                        } else {
                            obj[attrs[0]] = this.encrypto(firstAttrValue);
                        }
                    }
                }
            } else {
                for(var key in obj) {
                    var value = obj[key];
                    if(typeof value == "object" && (value instanceof Array) ) {
                        this.encryptoObjectArray(value);
                    } else if(typeof value == "object" && !(value instanceof Array)) {
                        this.encryptoObject(value);
                    } else {
                        obj[key] = this.encrypto(value);
                    }
                }
            }
        },
        encryptoObjectArray : function(objArray, attr) {
            if(objArray && objArray.length > 0) {
                var len = objArray.length;
                for(var i=0; i<len; i++) {
                    var obj = objArray[i];
                    if(typeof obj == "object" && !(obj instanceof Array)) {
                        if(attr && attr != "") {
                            var tempAttrArray = [];
                            tempAttrArray.push(attr);
                            this.encryptoObject(obj, tempAttrArray);
                        } else {
                            this.encryptoObject(obj);
                        }
                    } else if(typeof obj == "object" && (obj instanceof Array)) {
                        this.encryptoObjectArray(obj, attr);
                    } else {
                        objArray[i] = this.encrypto(obj);
                    }
                }
            }
        },
        encrypto : function(value) {
            var tempValue = value + "";
            var data64 = Base64.encode(tempValue );
            var buffer = mvc.crypto.ascii.toInts(data64);
            mvc.crypto.xxtea.encryptInPlace(buffer, key);
            return  mvc.crypto.base64Ints.encode(buffer);
        }
    });
})(jQuery);
