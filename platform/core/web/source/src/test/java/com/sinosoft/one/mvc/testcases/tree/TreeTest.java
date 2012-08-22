package com.sinosoft.one.mvc.testcases.tree;

import java.io.IOException;

import javax.servlet.ServletException;

import com.sinosoft.one.mvc.testcases.AbstractControllerTest;

public class TreeTest extends AbstractControllerTest {

    public void testGet2() throws ServletException, IOException {
        request.setMethod("GET");
        System.out.println(invoke("/mvc-info/tree"));
    }

}
