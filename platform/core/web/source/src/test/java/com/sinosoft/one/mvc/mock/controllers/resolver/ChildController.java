package com.sinosoft.one.mvc.mock.controllers.resolver;

import com.sinosoft.one.mvc.mock.resolvers.Interface;

public class ChildController extends Base {

    public String intf(Interface intf) {
        return intf.get();
    }
}
