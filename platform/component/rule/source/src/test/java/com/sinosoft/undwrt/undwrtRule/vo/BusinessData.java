package com.sinosoft.undwrt.undwrtRule.vo;

/**
 * <p>Title: 数据类的父类</p>
 * <p>Description:核保业务数据类的父类,主要进行业务属性描述，公共方法声明</p>
 * <p>Copyright: Copyright (c) 2013/5</p>
 * <p>Company: sinoSoft</p>
 * @version 1.0
 */

public class BusinessData {
    String classCode = ""; 		// 险类
    String riskCode = "0000"; 	// 险种
    String riskKind = ""; 		// 险别

    public String getClassCode() {
        return classCode;
    }
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }
    public String getRiskCode() {
        return riskCode;
    }
    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }
    public String getRiskKind() {
        return riskKind;
    }
    public void setRiskKind(String riskKind) {
        this.riskKind = riskKind;
    }
}