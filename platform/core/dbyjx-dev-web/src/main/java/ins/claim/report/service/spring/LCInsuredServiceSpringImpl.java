package ins.claim.report.service.spring;

import ins.claim.report.service.facade.LCInsuredService;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.prpall.proposal.model.LCInsured;

public class LCInsuredServiceSpringImpl extends GenericDaoHibernate<LCInsured, String> implements LCInsuredService {

	/**
	 *根据页面录入条件查询lcInsured表 
	 * @param lCInsured
	 * @param pageNo
	 * @param pageSize
	 * @author hesiqi
	 */
	@Override
	public Page findLCInsuredByCondition(LCInsured lcInsured, int pageNo,
			int pageSize) {
		QueryRule findLCInsured = QueryRule.getInstance();
		if(lcInsured.getId().getContNo() != null && !"".equals(lcInsured.getId().getContNo().trim())){
			findLCInsured.addEqual("id.contNo", lcInsured.getId().getContNo());
		}
		if(lcInsured.getId().getInsuredNo() != null && !"".equals(lcInsured.getId().getInsuredNo().trim())){
			findLCInsured.addEqual("id.insuredNo", lcInsured.getId().getInsuredNo());
		}
		if(lcInsured.getName() != null && !"".equals(lcInsured.getName().trim())){
			findLCInsured.addLike("name", lcInsured.getName()+"%");
		}
		if(lcInsured.getSex() != null && !"".equals(lcInsured.getSex().trim())){
			findLCInsured.addEqual("sex", lcInsured.getSex());
		}
		if(lcInsured.getBirthday() != null){
			findLCInsured.addEqual("birthday", lcInsured.getBirthday());
		}
		if(lcInsured.getIdType() != null && !"".equals(lcInsured.getIdType().trim())){
			findLCInsured.addEqual("idType", lcInsured.getIdType());
		}
		if(lcInsured.getIdNo() != null && !"".equals(lcInsured.getIdNo().trim())){
			findLCInsured.addEqual("idNo", lcInsured.getIdNo());
		}
		return this.find(LCInsured.class,findLCInsured, pageNo, pageSize);
	}
	
	/**
	 * 根据合同号和客户号查一条
	 * @param ciStr
	 * @return
	 * @author hesiqi
	 */
	@Override
	public LCInsured findLCInsuredByContNoInsuredNo(String ciStr) {
		String[] strAry = ciStr.split(",");
		QueryRule findLcInsuredRule = QueryRule.getInstance();
		findLcInsuredRule.addEqual("id.contNo", strAry[0]);
		findLcInsuredRule.addEqual("id.insuredNo", strAry[1]);
		return this.findUnique(LCInsured.class, findLcInsuredRule);
	}
	
}
