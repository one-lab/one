package com.sinosoft.one.test.rule.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.sinosoft.one.rule.domain.InputBOM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 核保条件
 * @author olingo
 *
 */
public class UndwrtCondition implements Serializable {

    private static final long serialVersionUID = UndwrtCondition.class.hashCode();

    private Logger logger = LoggerFactory.getLogger(UndwrtCondition.class);

	private int carAge;

	private String carType;
	
	private String carNature;
	
	private boolean result=true;


    /**
     * 新增设备
     */
    private double carDevice;


	private Map<String,UndwrtRiskKind> riskKind = new HashMap<String,UndwrtRiskKind>();
	
	private double limitAmount;


    public double getLimitAmount() {
		return limitAmount;
	}

	public void setLimitAmount(double limitAmount) {
		this.limitAmount = limitAmount;
	}

	public void addRiskKind(String kindCode,UndwrtRiskKind undwrtRiskKind){
		riskKind.put(kindCode, undwrtRiskKind);
	}
	
	public UndwrtRiskKind getRiskKind(String kindCode){
		return riskKind.get(kindCode);
	}

    public boolean containsRiskKind(String kindCode){
        boolean flag =  getRiskKind(kindCode)!=null;
        logger.info("kindCode is {},flag is {}",kindCode,flag);
        return flag;
    }

    public double getKindAmount(String kindCode){
        double amount =  this.getRiskKind(kindCode).getAmount();
        logger.info("kindCode is {},amount is {}",kindCode,amount);
        return amount;
    }

	
	public int getCarAge() {
		return carAge;
	}

	public void setCarAge(int carAge) {
		this.carAge = carAge;
	}
	
	public void resultIsFailures() {
		this.result = false;
	}


    /**
     * 使用性质
     * 01--營業車
     * 00--非營業車
     * 10--家用車
     * @return
     */
	public String getCarNature() {
		return carNature;
	}

	public void setCarNature(String carNature) {
		this.carNature = carNature;
	}

    /**
     * 车辆类型
     * 01---特种车
     * 02---货车
     * 03---客车
     * @return
     */
	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	
	/**
	 * 核保结果
	 * @return
	 */
	public boolean getResult() {
		return result;
	}

    /**
     * 判断是否包含某险别
     * @param kindCode
     * @return
     */
    public boolean hasKind(String kindCode){
        return this.riskKind.containsKey(kindCode);
    }


    public double getCarDevice() {
        return carDevice;
    }

    public void setCarDevice(double carDevice) {
        this.carDevice = carDevice;
    }
}
