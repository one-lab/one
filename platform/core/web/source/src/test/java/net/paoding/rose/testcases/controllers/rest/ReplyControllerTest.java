package net.paoding.rose.testcases.controllers.rest;

import java.io.IOException;

import javax.servlet.ServletException;

import net.paoding.rose.testcases.AbstractControllerTest;

public class ReplyControllerTest extends AbstractControllerTest {

    public void testGet() throws ServletException, IOException {
        request.setMethod("GET");
        assertEquals("hello reply", invoke("/reply/reply"));
    }

    public void testPost() throws ServletException, IOException {
        request.setMethod("POST");
        assertEquals("{\"id\":\"1\",\"name\":\"carvin\"}", invoke("/reply/reply"));
    }

}
