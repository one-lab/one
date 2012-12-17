package com.sinosoft.ebusiness.test.rule.domain;

import com.sinosoft.ebusiness.order.model.ProKind;
import com.sinosoft.ebusiness.order.model.ProOrder;

public class KindInputBOM {
	private ProOrder po;

	public boolean isContains(String kindCode) {
		boolean contains = false;
		for (ProKind kind : po.getProKinds()) {
			if (kind.getKindCode().equals(kindCode)) {
				contains = true;
				break;
			}
		}
		return contains;
	}

	public void setPo(ProOrder po) {
		this.po = po;
	}

}