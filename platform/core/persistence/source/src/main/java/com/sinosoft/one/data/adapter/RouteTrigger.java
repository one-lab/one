package com.sinosoft.one.data.adapter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteTrigger {

    @Autowired
    private DataSourceRouter dataSourceRouter;


    /*
              事务与set必须是一对一的关联，如果当前没有任何事务,可以随意放置.
              由于事务需要开启连接，而开启连接的时候已经决定了此次的库，所以需要在开启事务之前就开始set。
              但如果是嵌套事务，在在第一个事务之后，第二个事务之前需要set
              如果有事务，需要获取当前事务，并且知道当前事务是否是个新事务，如果是新事务

          */
    public <T> void trigger(T t){
        new MultiJdbcProxyDataSource.ConnectionInfo(dataSourceRouter.router(t)).bindToThread();
    }


}
