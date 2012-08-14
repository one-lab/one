package com.sinosoft.one.rms.service.picc;

import java.util.List;
import java.util.Set;

import com.sinosoft.one.rms.model.Employe;
import com.sinosoft.one.rms.model.Task;

public interface RmsService {

	void addUserPower(String userCode, String comCode, String addType,List<String> excTaskIDs);
	
	public Set<Task> findTaskByUserCodeNoDesinate(String userCode, String comCode);
	
	public void addEmploye(Employe employe);
	
}
