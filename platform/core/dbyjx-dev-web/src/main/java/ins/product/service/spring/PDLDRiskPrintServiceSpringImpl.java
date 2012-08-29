package ins.product.service.spring;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import ins.platform.model.PrpDuser;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.product.model.PDLDRiskPrint;
import ins.product.service.facade.PDLDRiskPrintService;

public class PDLDRiskPrintServiceSpringImpl extends GenericDaoHibernate<PDLDRiskPrint, String> implements PDLDRiskPrintService{
	/**
	 * @title saveRiskPrint
	 * @description 保存一个险种打印
	 * @author 党泽
	 * @param pdldRiskPrint
	 * @return pdldRiskPrint
	 */
	@Override
	public PDLDRiskPrint saveRiskPrint(PDLDRiskPrint pdldRiskPrint) {
		//pdldRiskPrint.setOperator(((PrpDuser)ActionContext.getContext().getSession().get("user")).getUserCode());
		pdldRiskPrint.setOperator("114000038");
		pdldRiskPrint.setMakeDate(new Date());
		pdldRiskPrint.setMakeTime(DateUtil.getTime());
		pdldRiskPrint.setModifyDate(new Date());
		pdldRiskPrint.setModifyTime(DateUtil.getTime());
		this.save(pdldRiskPrint);
		return pdldRiskPrint;
	}
    
	/**
	 * @title deleteRiskPrint
	 * @description 删除一个险种打印
	 * @author 党泽
	 * @param pdldRiskPrint
	 * @return pdldRiskPrint
	 */
	@Override
	public PDLDRiskPrint deleteRiskPrint(PDLDRiskPrint pdldRiskPrint) {
		this.delete(pdldRiskPrint);
		return pdldRiskPrint;
	}
	
	/**
	 * @title updateRiskPrint
	 * @description 更新一个险种打印
	 * @author 党泽
	 * @param pdldRiskPrint
	 * @return pdldRiskPrint
	 */
	@Override
	public PDLDRiskPrint updateRiskPrint(PDLDRiskPrint pdldRiskPrint) {
		this.update(pdldRiskPrint);
		return pdldRiskPrint;
	}
}
