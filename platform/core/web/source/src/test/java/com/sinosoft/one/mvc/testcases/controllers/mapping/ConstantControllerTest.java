package com.sinosoft.one.mvc.testcases.controllers.mapping;

import java.io.IOException;

import javax.servlet.ServletException;

import com.sinosoft.one.mvc.mock.controllers.mapping.ConstantController;
import com.sinosoft.one.mvc.testcases.AbstractControllerTest;

/**
 * @see ConstantController
 *
 * 
 */
public class ConstantControllerTest extends AbstractControllerTest {

    public void test1() throws ServletException, IOException {
        assertEquals("xx:mn/show", invoke("/mapping/constant/mn/show"));
    }

    /**
     * 曾经出现/mn2被导入到/mn/show的路径中，使得404
     * 
     * @throws ServletException
     * @throws IOException
     */
    public void test2() throws ServletException, IOException {
        assertEquals("mn2", invoke("/mapping/constant/mn2"));
    }

}
