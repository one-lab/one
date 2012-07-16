package net.paoding.rose.testcases.controllers;

import net.paoding.rose.testcases.AbstractControllerTest;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * test web package
 * User: ChengQi
 * Date: 6/26/12
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class WebPackageTest extends AbstractControllerTest {

    public void testPost1REST() throws ServletException, IOException {
        assertEquals("POST1", invoke("/webtest", "POST", ""));
    }
}
