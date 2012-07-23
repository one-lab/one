package com.sinosoft.ebusiness.rms.client.arch4;

import java.util.List;

import ins.framework.dao.GenericDaoHibernate;
import ins.framework.utils.StringUtils;

import com.sinosoft.ebusiness.rms.client.EnvContext;
//import com.sinosoft.ebusiness.rms.client.cxf.BusPower;
//import com.sinosoft.ebusiness.rms.client.model.LoginInfoDTO;


/**
 * rms GenericDaoHibernate
 * basic is arch4 GenericDaoHibernate; fill rms control task in it
 * User: ChengQi
 * Date: 3/22/12
 * Time: 11:07 AM
 */
public class RmsGenericDaoHibernate <T extends java.io.Serializable, PK extends java.io.Serializable>  {
	
//	ins.framework.common.QueryRule  EditqueryRule(ins.framework.common.QueryRule queryRule){
//     	LoginInfoDTO loginInfoDTO=EnvContext.getLoginInfo();
//		if (loginInfoDTO != null) {
//			String taskID=EnvContext.getDataAuthorityTaskId();
//			List<BusPower> busPowers = loginInfoDTO.getBusPowers();
//			for (BusPower busPower : busPowers) {
//				if (busPower.getTask().getTaskID().toString().equals(taskID)) {
//					if (StringUtils.isNotBlank(busPower.getDataRule().getRule())) {
//						queryRule.addSql(busPower.getDataRule().getRule());
//						System.out.println(busPower.getDataRule().getRule());
//					}
//				}
//			}
//		}
//		return queryRule;
//	}
	
	public java.util.List<T> find(ins.framework.common.QueryRule queryRule){
        if(EnvContext.getDataAuthorityTaskId()!=null){
//        	EditqueryRule(queryRule);
        }
//        return super.find(queryRule);
        return null;
    }


	public ins.framework.common.Page find(ins.framework.common.QueryRule queryRule, int pageNo, int pageSize){
        if(EnvContext.getDataAuthorityTaskId()!=null){
//        	EditqueryRule(queryRule);
        }
//        return super.find(queryRule,pageNo,pageSize);
        return null;
    }
    
    
}
