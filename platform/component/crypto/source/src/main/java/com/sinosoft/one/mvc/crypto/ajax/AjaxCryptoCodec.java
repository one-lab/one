package com.sinosoft.one.mvc.crypto.ajax;

import com.sinosoft.one.mvc.crypto.CryptoCodec;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-12
 * Time: 下午4:40
 * To change this template use File | Settings | File Templates.
 */
public final class AjaxCryptoCodec{
    private static Log log = LogFactory.getLog(CryptoCodec.class);

    public static Converter encode(HttpServletRequest request,List<String> cryptoAttributes,Object obj) throws Throwable {
        String attributeValue;
        String cryptoAttributeValue;
        String cryptoAttributesString = "";
        String key= (String) request.getSession().getAttribute("crypto_key_attr_name");
        for(String cryptoAttribute:cryptoAttributes){
            try {
                //得到相应属性的属性值
                attributeValue= BeanUtils.getProperty(obj, cryptoAttribute);
                //对相应属性的属性值进行加密
                cryptoAttributeValue= CryptoCodec.encode(key, attributeValue);
                //对象中存放加密后的属性值
                BeanUtils.setProperty(obj,cryptoAttribute,cryptoAttributeValue);
                cryptoAttributesString=cryptoAttributesString+cryptoAttribute+",";
            } catch (IllegalAccessException e) {
                log.error(e.getMessage());
                throw e;
            } catch (InvocationTargetException e) {
                log.error(e.getMessage());
                throw e.getTargetException();
            } catch (NoSuchMethodException e) {
                log.error(e.getMessage());
                throw e;
            }
        }
        cryptoAttributesString=cryptoAttributesString.substring(0,cryptoAttributesString.length()-1);
        return new Converter(request,cryptoAttributesString,obj);
    }

    public  static Converter encode(HttpServletRequest request,String cryptoAttributeString,Object obj) throws Throwable {
        List<String> cryptoAttributes=new ArrayList<String>();
        String[] attributes=cryptoAttributeString.split(",");
        for(String cryptoAttr:attributes){
            cryptoAttributes.add(cryptoAttr);
        }
        return encode(request,cryptoAttributes,obj);
    }

    public  static Converter encode(HttpServletRequest request,String[] cryptoAttributeStringArray,Object obj) throws Throwable {
        List<String> cryptoAttributes=new ArrayList<String>();
        for(String cryptoAttr:cryptoAttributeStringArray){
            cryptoAttributes.add(cryptoAttr);
        }
        return encode(request,cryptoAttributes,obj);
    }
/*/////////////////////////////////////////////////////////////////

    public static Converter encode(HttpServletRequest request,List<String> cryptoAttributes,List<String> attributeValues) throws Throwable {
        String attributeValue;
        String cryptoAttributeValue;
        String cryptoAttributesString = null;
        String key= (String) request.getAttribute("crypto_key_attr_name");
        for(int i=0;i<cryptoAttributes.size();i++){
            //对相应属性的属性值进行加密
            cryptoAttributeValue= CryptoCodec.encode(key, cryptoAttributes.get(i));
            //存放加密后的属性值
            cryptoAttributes.set(i,cryptoAttributeValue);
        }


        cryptoAttributesString=cryptoAttributesString.substring(0,cryptoAttributesString.length()-2);
        return new Converter(request,cryptoAttributesString,obj);
    }

    public  static Converter encode(HttpServletRequest request,String cryptoAttribute) throws Throwable {
        List<String> cryptoAttributes=new ArrayList<String>();
        String[] attributes=cryptoAttribute.split(",");
        for(String cryptoAttr:attributes){
            cryptoAttributes.add(cryptoAttr);
        }
        return encode(request,cryptoAttributes);
    }

    public  static Converter encode(HttpServletRequest request,String[] cryptoAttribute) throws Throwable {
        List<String> cryptoAttributes=new ArrayList<String>();
        for(String cryptoAttr:cryptoAttribute){
            cryptoAttributes.add(cryptoAttr);
        }
        return encode(request,cryptoAttributes);
    }*/
}
