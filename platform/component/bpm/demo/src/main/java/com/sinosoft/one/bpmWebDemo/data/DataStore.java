package com.sinosoft.one.bpmWebDemo.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.sinosoft.one.bpmWebDemo.domain.Combo;

public class DataStore {
	public static HashMap<String, Combo> dataStore = new HashMap<String, Combo>();

	public static synchronized void store(Combo c) throws Exception {
		// Assert.assertNotNull(c);
		System.out.println("stroe combo:" + c.getComboCode());
		if (dataStore.containsKey(c.getComboCode())) {
			throw new Exception("combo has existed");
		} else {
			dataStore.put(c.getComboCode(), c);
		}
	}

	public static ArrayList<Combo> getCombos() {
		ArrayList<Combo> results = new ArrayList<Combo>();
		Set<String> key = dataStore.keySet();
		for (Iterator<String> it = key.iterator(); it.hasNext();) {
			results.add(dataStore.get(it.next()));
		}

		return results;
	}
}
