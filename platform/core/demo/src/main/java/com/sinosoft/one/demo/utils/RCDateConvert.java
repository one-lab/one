package com.sinosoft.one.demo.utils;

import com.opensymphony.xwork2.conversion.impl.DateConverter;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Member;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class RCDateConvert extends DateConverter {


    @Override
    public Object convertValue(Map<String, Object> context, Object target, Member member, String propertyName, Object value, Class toType) {
        Date result = null;

        if (value instanceof String && value != null && ((String) value).length() > 0) {
            if (java.sql.Time.class == toType||java.sql.Timestamp.class == toType||java.util.Date.class == toType) {
                value = convertToFullYear((String) value);

            }
        }
        return super.convertValue(context,target,member,propertyName,value,toType);
    }


    String convertToFullYear(String value){

       String sa = value;
       if(sa.contains("-")){
           sa = rcConvert(sa,"-");
       }
       else if(sa.contains("/")){
           sa = rcConvert(sa,"/");
       }
       else if(sa.contains("年")){
           sa = rcConvert(sa, "年");
       }

       return sa;

    }

     String rcConvert(String sa,String separtor){
        if(!sa.contains(separtor))
            return sa;
        String b = StringUtils.substringBefore(sa,separtor);
        System.out.println(b);
        if(b.length()<4){
            int s = Integer.parseInt(b)+1911;
            String c = StringUtils.substringAfter(sa,b);
            sa = s + c;
        }
        return sa;
    }

    public static void main(String[] args){
        RCDateConvert convert = new RCDateConvert();
        SimpleDateFormat s = new SimpleDateFormat("yyyyMMd");

        System.out.println(convert.convertToFullYear("101年03月05"));
    }


}
