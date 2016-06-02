package com.sinosoft.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext-test.xml" })
@TransactionConfiguration
public class OneToOneTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testOne(){
        Customer customer = new Customer();
        customer.setCustomerCode("1");

        CustomerIIdv customerIIdv = new CustomerIIdv();
        customerIIdv.setCustomerCode("1");
        customer.setCustomerIIdv(customerIIdv);
        customerIIdv.setCustomer(customer);

        CustomerUnit customerUnit = new CustomerUnit();
        customerUnit.setCustomerCode("1");
        customer.setCustomerUnit(customerUnit);
        customerUnit.setCustomer(customer);
       // customer.set
        customerService.save(customer);

    }
}
