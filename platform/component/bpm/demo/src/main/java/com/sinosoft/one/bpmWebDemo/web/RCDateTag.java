package com.sinosoft.one.bpmWebDemo.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


public class RCDateTag extends TagSupport {
	
	private String name;
	
	private String formate;

	@Override
	public int doStartTag() throws JspException {
		Date date = (Date)pageContext.getAttribute(name);
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR) - 1911;
		
		
		 SimpleDateFormat sdf = new SimpleDateFormat(formate);
		 String outputDate = sdf.format(date);
		 outputDate = year + outputDate.substring(4);
		//String data = year
		try {
			this.pageContext.getOut().print(outputDate);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.SKIP_BODY;  
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormate() {
		return formate;
	}

	public void setFormate(String formate) {
		this.formate = formate;
	}
	
	
}
