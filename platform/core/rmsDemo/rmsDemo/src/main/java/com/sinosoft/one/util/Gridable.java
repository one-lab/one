package com.sinosoft.one.rmsdemo.uiUtils;

import com.sun.deploy.net.HttpResponse;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-10-11
 * Time: 下午9:11
 * To change this template use File | Settings | File Templates.
 */
public  class Gridable  implements UIable {

    public final Render getRender() {
        return new GridRender();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
