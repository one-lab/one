package com.sinosoft.test;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: ChengQi
 * Date: 13-4-16
 * Time: AM11:51
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "CUSTOMERUNIT")
public class CustomerUnit {

    private Customer customer;

    private String customerCode;

    /**
     * 属性客户代码的getter方法
     */
    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "customer"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "CUSTOMERCODE")
    public String getCustomerCode() {
        return this.customerCode;
    }

    /**
     * 属性客户代码的setter方法
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    /**
     * 属性PRPDCUSTOMER的getter方法
     */
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * 属性PRPDCUSTOMER的setter方法
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
