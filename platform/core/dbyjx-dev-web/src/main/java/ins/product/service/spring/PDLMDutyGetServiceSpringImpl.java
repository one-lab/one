package ins.product.service.spring;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;

import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.model.PrpDuser;
import ins.product.model.PDLMDutyGet;
import ins.product.service.facade.PDLMDutyGetService;

public class PDLMDutyGetServiceSpringImpl extends GenericDaoHibernate<PDLMDutyGet, String> implements PDLMDutyGetService {
	/**
	 * @title saveRiskDutyGet
	 * @description 保存一条险种给付责任定义
	 * @author 朱超
	 * @param pdLmDutyGet
	 * @return
	 */
	@Override
	public PDLMDutyGet saveRiskDutyGet(PDLMDutyGet pdLmDutyGet) {
		//pdLmDutyGet.setOperator(((PrpDuser)ActionContext.getContext().getSession().get("user")).getUserCode());
		pdLmDutyGet.setOperator("114000038");
		pdLmDutyGet.setMakeDate(new Date());
		pdLmDutyGet.setMakeTime(DateUtil.getTime());
		pdLmDutyGet.setModifyDate(new Date());
		pdLmDutyGet.setModifyTime(DateUtil.getTime());
		this.save(pdLmDutyGet);
		return pdLmDutyGet;
	}
	/**
	 * @title deleteRiskDutyGet
	 * @description 删除一条险种给付责任定义
	 * @author 朱超
	 * @param getDutyCode
	 * @return
	 */
	@Override
	public String deleteRiskDutyGet(String getDutyCode) {
		try{			
			this.deleteByPK(getDutyCode);
		}catch(Exception e){
			return e.getMessage();
		}
		return "记录"+getDutyCode+"已经删除";
	}
	
}
