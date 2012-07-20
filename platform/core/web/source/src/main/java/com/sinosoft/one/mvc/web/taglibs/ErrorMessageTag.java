package com.sinosoft.one.mvc.web.taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.validation.ConstraintViolation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.InvocationUtils;
/**
 * jsp页面的<code><errorMessage /></code>标签
 * @author Morgan
 *
 */
public class ErrorMessageTag extends TagSupport{

	private static final long serialVersionUID = 8479034058653691234L;
	
	private static Log logger = LogFactory.getLog(ErrorMessageTag.class);

	private String property  ;
	
	private String type ;
	
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int doStartTag() throws JspException {
		Invocation invocation = InvocationUtils.getCurrentThreadInvocation();
		
		if(invocation != null){
			@SuppressWarnings("unchecked")
			ConstraintViolation<Object> cv = (ConstraintViolation<Object>) 
					invocation.getModel(this.property+"ErrorMsg");
			if(cv != null){
				JspWriter out = pageContext.getOut();
				
				if (logger.isDebugEnabled()) {
	                logger.debug("getErrorMessage: " + property + "=" + cv);
	            }
				try {
					if(type == null){
						out.print("错误的值:" + cv.getInvalidValue() + "  " + cv.getMessage());
					} else if(type.equalsIgnoreCase("propertyPath")){
						out.print(cv.getPropertyPath());
					} else if(type.equalsIgnoreCase("message")){
						out.print(cv.getMessage());
					} else if(type.equalsIgnoreCase("invalidValue")){
						out.print(cv.getInvalidValue());
					}
				} catch (IOException e) {
					logger.error(e);
				}
				
			}
		}
		return super.doStartTag();
	}
	
	
	
	
	

}
