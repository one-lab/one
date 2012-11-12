
function decode(key,data) {
    var hexkey = mvc.crypto.hex.decode(key);

    var buffer = mvc.crypto.base64Ints.decode(data);
    mvc.crypto.xxtea.decryptInPlace(buffer, hexkey);
    var clear64 = mvc.crypto.ascii.fromInts(buffer);
    var clear = Base64.decode(clear64);
    return clear;
}


function encode(key,data) {
    var hexkey = mvc.crypto.hex.decode(key);
    var data64 = Base64.encode(data);
    var buffer = mvc.crypto.ascii.toInts(data64);
    enText = mvc.crypto.xxtea.encryptInPlace(buffer, hexkey);
    var b64 = mvc.crypto.base64Ints.encode(buffer);
    return b64;
}

function crypto_form(key,type,formid) {

    var types = type.split("::");
    var _isIncludes = false, _isExcludes = false;
    if(types.length > 1) {
        if("includes" == types[0])_isIncludes = true;
        else if("excludes" == _type) _isExcludes = true;
        var _detail = types[1];
        var _details = _detail.split(",");
    }
    alert(formid);
    //alert(_detail);
    var _form = $("#"+formid);
    var $cloneForm = $("#" + formid).clone();
    //去除submit属性
    $cloneForm.removeAttr("onsubmit");
    var inputs = $cloneForm.find("input");
    //首先判断是否两个属性都为false，即如果都为flase，那么全部加密
    if(!_isExcludes && !_isIncludes) {
        //循环form，找出其中的input和textarea，全部进行加密
        var $temFormEle = $cloneForm.find("input, textarea");
        for(var i = 0; i < $temFormEle.length; i++) {
            var temValue = $temFormEle.eq(i).val();
            $temFormEle.eq(i).val(encode(key, temValue));
        }
    } else if(_isIncludes) {
        for(var l=_details.length,i=0; i<l; i++) {
            var _clear = $cloneForm.find("input[name='"+_details[i]+"']").val();
            if(_clear == undefined) {
                _clear = $cloneForm.find("textarea[name='"+_details[i]+"']").val();
            }
            if(_clear != undefined) {
                $cloneForm.find("input[name='"+_details[i]+"']").val( encode(key,_clear) );
            }
        }
    } else if(_isExcludes) {
        var $temFormEle = $cloneForm.find("input, textarea");
        for(var i = 0; i < $temFormEle.length; i++) {
            var nameVal = $temFormEle.eq(i).attr("name");
            var nameFlag = true;
            for(var j = 0; j < _details.length; j++){
                if(nameVal == _details[j]) {
                    nameFlag = false;
                }
            }
            if(nameFlag) {
                $temFormEle.eq(i).val(encode(key, temValue));
            }
        }
    }

    $("body").append($cloneForm);
    $cloneForm.submit();
    return false;
}