package com.sinosoft.undwrt.undwrtRule.vo;

import java.util.HashMap;
import java.util.Map;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.sinosoft.one.rule.domain.InputBOM;
//import com.sinosoft.undwrt.pub.InternationalizationUtil;
import com.sinosoft.undwrt.undwrtRule.service.UndwrtRuleRiskKind;

/**
 * <p>
 * Title: 业务数据
 * </p>
 * <p>
 * Description:根据投保单号得到业务数据
 * </p>
 * <p>
 * Copyright: Copyright (c) 2013/5
 * </p>
 * <p>
 * Company: sinoSoft
 * </p>
 */

public class BusinessProposalData extends BusinessData implements InputBOM {

    //private Logger logger = LoggerFactory.getLogger(BusinessProposalData.class);

    private boolean result = true; // 审核结果

    private String strResultMessage; // 核保不通过的原因

    private boolean rulesCheckFlag = false; // 是否走规则表

    private String useYears;

    private String carKind;

    private String useNature;

    /**
     * 新增设备
     */
    private double carDevice;

    private double limitAmount;

    private Map<String, UndwrtRuleRiskKind> riskKind = new HashMap<String, UndwrtRuleRiskKind>();

    public void addRiskKind(String kindCode, UndwrtRuleRiskKind undwrtRiskKind) {
        riskKind.put(kindCode, undwrtRiskKind);
    }

    public UndwrtRuleRiskKind getRiskKind(String kindCode) {
        return riskKind.get(kindCode);
    }

    public boolean containsRiskKind(String kindCode) {
        System.out.println("正在进行规则校验，请稍等...");
        System.out.println("rules================================="+kindCode);
        this.rulesCheckFlag = true; // true表示已经进行了规则校验
        boolean flag = getRiskKind(kindCode) != null;
        //logger.info("kindCode is {},flag is {}", kindCode, flag);
        return flag;
    }

    public double getKindAmount(String kindCode) {
        double amount = this.getRiskKind(kindCode).getAmount();
        //logger.info("kindCode is {},amount is {}", kindCode, amount);
        return amount;
    }

    /**
     * 判断是否包含某险别
     *
     * @param kindCode
     * @return
     */
    public boolean hasKind(String kindCode) {
        return this.riskKind.containsKey(kindCode);
    }

    /**
     * 匹配车龄
     *
     * @param carAge
     * @return
     */
    public boolean matchAge(String useYears) {
        //InternationalizationUtil internal = new InternationalizationUtil();
        boolean hasCarAge = false;
		/*System.out.println(internal.getText("undwrt.service.task.business")
				+ "==" + this.useYears);
		System.out
				.println(internal.getText("undwrt.service.task.configuration")
						+ "==" + useYears);*/
        if (Integer.parseInt(this.useYears) > Integer.parseInt(useYears)) {
            hasCarAge = true;
        }
        return hasCarAge;
    }

    /**
     * 设置action返回结果
     */
    public void resultIsFalse(String strMessage) {
        this.strResultMessage = strMessage;
        this.result = false;
    }

    /**
     * 返回结果
     *
     * @return
     */
    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean isRulesCheckFlag() {
        return rulesCheckFlag;
    }

    public void setRulesCheckFlag(boolean rulesCheckFlag) {
        this.rulesCheckFlag = rulesCheckFlag;
    }

    public String getStrResultMessage() {
        return strResultMessage;
    }

    public void setStrResultMessage(String strResultMessage) {
        this.strResultMessage = strResultMessage;
    }

    public String getUseYears() {
        return useYears;
    }

    public void setUseYears(String useYears) {
        this.useYears = useYears;
    }

    public String getCarKind() {
        return carKind;
    }

    public void setCarKind(String carKind) {
        this.carKind = carKind;
    }

    public String getUseNature() {
        return useNature;
    }

    public void setUseNature(String useNature) {
        this.useNature = useNature;
    }

    public double getCarDevice() {
        return carDevice;
    }

    public void setCarDevice(double carDevice) {
        this.carDevice = carDevice;
    }

    public double getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(double limitAmount) {
        this.limitAmount = limitAmount;
    }
}