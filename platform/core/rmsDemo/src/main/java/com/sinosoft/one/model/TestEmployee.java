package com.sinosoft.one.model;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-24
 * Time: 下午5:39
 * To change this template use File | Settings | File Templates.
 */
public class TestEmployee {
    private Long id;
    private BigDecimal employeeNo;
    private String name;
    private String company;
    private String organization;
    private String operation;

    public TestEmployee(){}

    public TestEmployee(Long id, BigDecimal employeeNo, String name, String company, String organization, String operation) {
        this.id = id;
        this.employeeNo=employeeNo;
        this.name = name;
        this.company = company;
        this.organization = organization;
        this.operation = operation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(BigDecimal employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
