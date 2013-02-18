package com.sinosoft.one.test.rule.domain;

import com.sinosoft.one.rule.domain.InputBOM;
import com.sinosoft.one.test.rule.model.ProVehicle;

public class ProPosalInputBOM implements InputBOM {
	private boolean isProPosal;
	private String cityCode;
	private String areaCode;
	private ProVehicle proVehicle;

	public boolean isProPosal() {
		return isProPosal;
	}

	public void setProPosal(boolean isProPosal) {
		this.isProPosal = isProPosal;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public ProVehicle getProVehicle() {
		return proVehicle;
	}

	public void setProVehicle(ProVehicle proVehicle) {
		this.proVehicle = proVehicle;
	}

}
