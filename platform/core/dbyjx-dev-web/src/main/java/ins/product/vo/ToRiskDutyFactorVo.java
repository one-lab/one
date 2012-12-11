package ins.product.vo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ToRiskDutyFactorVo {
	private String riskCode;
	private String dutyCode;
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getDutyCode() {
		return dutyCode;
	}
	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}
	private String calFactor;
	private String calFactorValue;
	public String getCalFactor() {
		return calFactor;
	}
	public void setCalFactor(String calFactor) {
		this.calFactor = calFactor;
	}
	public String getCalFactorValue() {
		return calFactorValue;
	}
	public void setCalFactorValue(String calFactorValue) {
		this.calFactorValue = calFactorValue;
	}
	public ToRiskDutyFactorVo(){}
	public ToRiskDutyFactorVo(String riskCode, String dutyCode,
			String calFactor, String calFactorValue) {
		super();
		this.riskCode = riskCode;
		this.dutyCode = dutyCode;
		this.calFactor = calFactor;
		this.calFactorValue = calFactorValue;
	}
	
	public Map<String,List<ToRiskDutyFactorVo>> getFactorListByDuty(List<ToRiskDutyFactorVo> vos){
		Map<String,List<ToRiskDutyFactorVo>> factorsByDutyMap = new HashMap<String, List<ToRiskDutyFactorVo>>();
		for(Iterator<ToRiskDutyFactorVo> it = vos.iterator(); it.hasNext();){
			ToRiskDutyFactorVo tempVo = it.next();
			
		}
		return null;
	}
	
}
