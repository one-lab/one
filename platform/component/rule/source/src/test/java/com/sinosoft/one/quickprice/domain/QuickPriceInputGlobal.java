package com.sinosoft.one.quickprice.domain;

import java.io.Serializable;
import java.util.HashMap;

public class QuickPriceInputGlobal implements Serializable {
	private static final long serialVersionUID = 1L;
	private HashMap<String, KindBOM> kinds = new HashMap<String, KindBOM>();
	private double discount;

	public void add(KindBOM kind) {
		kinds.put(kind.getKindCode(), kind);
	}

	public HashMap<String, KindBOM> getKinds() {
		return this.kinds;

	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
