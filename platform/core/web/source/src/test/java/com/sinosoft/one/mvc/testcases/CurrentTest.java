package com.sinosoft.one.mvc.testcases;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;

import com.sinosoft.one.mvc.web.InvocationUtils;

public class CurrentTest extends AbstractControllerTest {

    public void test() throws ServletException, IOException {
        request.addParameter("testThread", Thread.currentThread().getName());
        assertEquals("ok", invoke("/current"));
        assertNull(InvocationUtils.getCurrentThreadRequest());
        assertNull(InvocationUtils.getCurrentThreadInvocation());
    }

    public  static void main(String args[]){
       System.out.println(new BigDecimal(2).multiply(new BigDecimal(1)).toString());
    }

}
