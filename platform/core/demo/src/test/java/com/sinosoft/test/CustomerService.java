package com.sinosoft.test;

import ins.framework.dao.GenericDaoHibernate;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: ChengQi
 * Date: 13-4-16
 * Time: AM10:55
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class CustomerService extends GenericDaoHibernate<Customer,String> {


    public void save(Customer customer){
          super.save(customer);
    }
}
