package com.sinosoft.one.demo.utils;

import org.apache.commons.lang.StringUtils;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class RCDateTag  extends TagSupport  {

    private static final int R_C_START_YEAR = 1911;

    private String name;

    private String format;

    private Date value;


    @Override
    public int doStartTag() throws JspException {
        try {
            if (value != null) {
                print(value);
                return SKIP_BODY;
            }

            // struts2的迭代过程默认为top
            if(StringUtils.isBlank(name)){
                 name = "top";
            }
            if(name!=null){
                Object obj = this.pageContext.findAttribute(name);
                if(obj!=null&&obj instanceof Date)
                    print((Date)obj);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    void print(Date date) throws IOException {
        String dataPrint = changeDateToString(date);
        String rcyear = getRCYear(date);
        pageContext.getOut().print(format(rcyear, dataPrint));
    }


    String format(String rcyear, String dataPrint){
        int yearPlace = format.lastIndexOf("y")+1;
        return rcyear + dataPrint.substring(yearPlace);
    }

    String changeDateToString(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    String getRCYear(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int rcyear = calendar.get(Calendar.YEAR)-R_C_START_YEAR;
        return String.valueOf(rcyear);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }


    public void setValue(Date value_) {
        this.value = value_;
    }


}
