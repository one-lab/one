package net.paoding.rose.mock.web;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Post;

/**
 * test web controller
 * User: ChengQi
 * Date: 6/26/12
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/webtest")
public class WebController {

    @Post
    public String post1() {
        return "POST1";
    }

}
