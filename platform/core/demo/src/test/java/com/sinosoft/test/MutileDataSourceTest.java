package com.sinosoft.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinosoft.one.data.adapter.MultiJdbcProxyDataSource;
import com.sinosoft.one.demo.dao.account.UserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext-test2.xml" })
public class MutileDataSourceTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Map<String,Object> map = new HashMap<String,Object>();

    @Before
    public void init(){
        //MultiJdbcProxyDataSource.RouterFlag.set("dataSource1");
       int i=0;
       while(i++<100000){
           map.put(String.valueOf(i),new BigDecimal(i));

       }

    }

    //@Autowired
    //private UserDao userDao;

    @Test
    public void findBySingelDataSource() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        StringBuilder str = new StringBuilder();
        long begin =  System.currentTimeMillis();
        mapper.writeValueAsString(map);
        long end = System.currentTimeMillis();
        System.out.println("jackson consume:"+(end-begin));


        begin =  System.currentTimeMillis();
        new JSONObject(map).writeJSONString(str);
        end = System.currentTimeMillis();
        System.out.println("fast json consume:"+(end-begin));

//        System.out.println("---------22222222--------"+MultiJdbcProxyDataSource.RouterFlag.get());
//        Assert.assertEquals(6,userDao.count());
//        MultiJdbcProxyDataSource.RouterFlag.set("dataSource2");

//        Assert.assertEquals(7,userDao.count());

    }

}
