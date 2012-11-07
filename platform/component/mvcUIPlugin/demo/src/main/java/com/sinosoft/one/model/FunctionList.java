package com.sinosoft.one.model;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-9-24
 * Time: 下午3:33
 * To change this template use File | Settings | File Templates.
 */
public class FunctionList extends IdEntity {
    private String branchOfficeName;
    private String shopName;

    public FunctionList() {
    }

    public FunctionList(String branchOfficeName, String shopName) {
        this.branchOfficeName = branchOfficeName;
        this.shopName = shopName;
    }

    public String getBranchOfficeName() {
        return branchOfficeName;
    }

    public void setBranchOfficeName(String branchOfficeName) {
        this.branchOfficeName = branchOfficeName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
