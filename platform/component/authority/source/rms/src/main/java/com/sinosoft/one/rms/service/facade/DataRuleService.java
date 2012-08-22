package com.sinosoft.one.rms.service.facade;

import java.util.List;


import com.sinosoft.one.rms.model.BusPower;
import com.sinosoft.one.rms.model.DataRule;

public interface DataRuleService {
	
	/**
	 * 增加数据权限记录
	 * @param dataRuleID
	 * @param userCode
	 * @param taskID
	 * @param dataRuleParam
	 */
	public void addBusPower(String powerId,String dataRuleID,String taskID,String dataRuleParam);
	
	
	/**
	 * 查询所有数据规则（非权限记录）
	 * @return
	 */
	public List<DataRule> findAllDataRule();
	
	/**
	 * 查询数据权限
	 * @param busPowerID
	 * @return
	 */
	public List<BusPower> findBusPowerByTaskID(String userCode,String taskId);
	
	/**
	 * 查询人员下的数据权限
	 * @param userCode
	 * @return
	 */
	public List<BusPower> findBusPowerByUserCode(String userCode);
}
