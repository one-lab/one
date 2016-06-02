package com.sinosoft.test;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ChengQi
 * Date: 13-4-16
 * Time: AM10:44
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    private String customerCode;

    private String name;

    private CustomerIIdv customerIIdv;

    private CustomerUnit customerUnit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "CUSTOMERCODE")
    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    /**
     * 属性PRPDCUSTOMERIDV的getter方法
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer")
    public CustomerIIdv getCustomerIIdv() {
        return this.customerIIdv;
    }

    /**
     * 属性PRPDCUSTOMERIDV的setter方法
     */
    public void setCustomerIIdv(CustomerIIdv customerIIdv) {
        this.customerIIdv = customerIIdv;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer")
    public CustomerUnit getCustomerUnit() {
        return customerUnit;
    }

    public void setCustomerUnit(CustomerUnit customerUnit) {
        this.customerUnit = customerUnit;
    }
}
