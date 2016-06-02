package com.sinosoft.one.mvc.web;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.lang.reflect.Method;

public class LocaleChangeInterceptor extends  ControllerInterceptorAdapter{

    public LocaleChangeInterceptor (){
       super.setPriority(10001);
    }

    /**
     * Default name of the locale specification parameter: "locale".
     */
    public static final String DEFAULT_PARAM_NAME = "locale";

    private String paramName = DEFAULT_PARAM_NAME;


    /**
     * Set the name of the parameter that contains a locale specification
     * in a locale change request. Default is "locale".
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    /**
     * Return the name of the parameter that contains a locale specification
     * in a locale change request.
     */
    public String getParamName() {
        return this.paramName;
    }

    @Override
    protected boolean isForAction(Method actionMethod, Class<?> controllerClazz) {
        return true;
    }

    @Override
    public Object before(Invocation inv) throws Exception {
        String newLocale = inv.getRequest().getParameter(this.paramName);
        if (newLocale != null) {
            LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(inv.getRequest());
            if (localeResolver == null) {
                throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
            }
            try {
                //set new local
                localeResolver.setLocale(inv.getRequest(), inv.getResponse(), StringUtils.parseLocaleString(newLocale));

            }
            //if localResolver is default ,it's not support setLocale
            catch (UnsupportedOperationException e) {
                //
            }
        }
        // Proceed in any case.
        return true;
    }
}
