package com.sinosoft.ebusiness.rms.client;

import ins.framework.common.Page;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ChengQi
 * Date: 3/22/12
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TestService {
    
    List findUser();
    
    Page findUser(int pageNo, int pageSize);
    
    Page find(int pageNo,int pageSize);
}
