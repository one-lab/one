package com.sinosoft.one.test.rule.domain;

import com.sinosoft.one.test.rule.model.ProKind;
import com.sinosoft.one.test.rule.model.ProOrder;

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