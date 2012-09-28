package ins.prpall.proposal.service.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.common.SerialNoUtil;
import ins.platform.model.PrpDcompany;
import ins.prpall.proposal.model.LCCont;
import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.model.LCGrpServInfo;
import ins.prpall.proposal.model.LCPol;
import ins.prpall.proposal.service.facade.SignService;
import ins.prpall.report.model.LCGrpPol;


public class SignServiceSpringImpl extends
GenericDaoHibernate<LCGrpCont, String>  implements SignService {
	private FinalCollection finalCollection;
	private SerialNoUtil serialNoUtil;
	public FinalCollection getFinalCollection() {
		return finalCollection;
	}
	public void setFinalCollection(FinalCollection finalCollection) {
		this.finalCollection = finalCollection;
	}
	public SerialNoUtil getSerialNoUtil() {
		return serialNoUtil;
	}
	public void setSerialNoUtil(SerialNoUtil serialNoUtil) {
		this.serialNoUtil = serialNoUtil;
	}
	
	/**查询待签单的投报单
	 * @param LCGrpCont
	 * @author 郭占红
	 */
	public Page findProposalSignInfo(LCGrpCont lcGrpCont, int pageNo,
			int pageSize) {
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		QueryRule findRule = QueryRule.getInstance();
		if(null!=lcGrpCont.getGrpContNo() && !"".equals(lcGrpCont.getGrpContNo().trim())){
			findRule.addEqual("grpContNo",lcGrpCont.getGrpContNo().trim());
		}
		if(null!=lcGrpCont.getManageCom() && !"".equals(lcGrpCont.getManageCom().trim())){
			findRule.addEqual("manageCom",lcGrpCont.getManageCom().trim());
		}
		if(null!=lcGrpCont.getAppntNo() && !"".equals(lcGrpCont.getAppntNo() .trim())){
			findRule.addEqual("appntNo",lcGrpCont.getAppntNo().trim());
		}
		if(null!=lcGrpCont.getGrpName()&& !"".equals(lcGrpCont.getGrpName().trim())){
			findRule.addEqual("grpName",lcGrpCont.getGrpName().trim());
		}
		if(null!=lcGrpCont.getAgentCode()&& !"".equals(lcGrpCont.getAgentCode().trim())){
			findRule.addEqual("agentCode",lcGrpCont.getAgentCode().trim());
		}
		findRule.addEqual("state",finalCollection.CONT_STATE8);
		Page page = this.find(findRule, pageNo, pageSize);
		return page;
		
	}
	/**
	 * 根据集体合同号去个人保单表表里查询相关数据
	 * @param lcGrpCont lcCont
	 * @author 郭占红
	 */
	public List<LCCont> findLCContInfoByGrpContNo(LCGrpCont lcGrpCont){
		List<LCCont> findResult=new ArrayList<LCCont>();
		StringBuffer findReportHql = new StringBuffer();
		if (lcGrpCont.getProposalGrpContNo() != null && !"".equals(lcGrpCont.getProposalGrpContNo())){ 
			findReportHql.append("from LCCont lcCont where lcCont.grpContNo='"+lcGrpCont.getProposalGrpContNo()+"'");
		}
		findResult =this.findByHql(findReportHql.toString(), null);
		if(findResult==null || findResult.size()<=0){
			findResult=null;
		}
	    return findResult;
		
	}
	/**
	 * 根据集体合同号去个人险种表里查询相关数据
	 * @param lcGrpCont lcPol 
	 * @author 郭占红
	 */
	public List<LCPol> findLCPolInfoByGrpContNo(LCGrpCont lcGrpCont){
		List<LCPol> findResult=new ArrayList<LCPol>();
		StringBuffer findReportHql = new StringBuffer();
		if (lcGrpCont.getProposalGrpContNo() != null && !"".equals(lcGrpCont.getProposalGrpContNo() )){ 
			findReportHql.append("from LCPol lcPol where lcPol.grpContNo='"+lcGrpCont.getProposalGrpContNo() +"'");
		}
		findResult =this.findByHql(findReportHql.toString(), null);
		if(findResult==null || findResult.size()<=0){
			findResult=null;
		}
	    return findResult;
		
	}
	/**
	 * 根据集体合同号去集体险种表表里查询相关数据
	 * @param lcGrpCont lcGrpPol
	 * @author 郭占红
	 */
	public List<LCGrpPol> findLCGrpPolInfoByGrpContNo(LCGrpCont lcGrpCont){
		List<LCGrpPol> findResult=new ArrayList<LCGrpPol>();
		StringBuffer findReportHql = new StringBuffer();
		if (lcGrpCont.getProposalGrpContNo() != null && !"".equals(lcGrpCont.getProposalGrpContNo())){ 
			findReportHql.append("from LCGrpPol lcGrpPol where lcGrpPol.grpContNo='"+lcGrpCont.getProposalGrpContNo()+"'");
		}
		findResult =this.findByHql(findReportHql.toString(), null);
		if(findResult==null || findResult.size()<=0){
			findResult=null;
		}
	    return findResult;
		
	}
	
	/**
	 * 根据投报号修改相应的state状态为00(签单功能)
	 * @param LCGrpCont
	 * @author 郭占红
	 */
	public boolean saveSignInfo(LCGrpCont lcGrpCont) {
		List infoList=new ArrayList();
		//更新集体保单表里的state状态以及相关数据
       LCGrpCont lcGrp=this.get(lcGrpCont.getProposalGrpContNo());
		lcGrp.setSignDate(new Date());
		lcGrp.setSignTime(DateUtil.getTime());
		lcGrp.setModifyDate(new Date());
		lcGrp.setModifyTime(DateUtil.getTime());
		lcGrp.setSignCom(lcGrpCont.getManageCom());
		lcGrp.setState(finalCollection.CONT_STATE0);
		this.update(lcGrp);
		this.flush();
		this.evict(lcGrp);
		
		//更新个人保单表
		infoList=findLCContInfoByGrpContNo(lcGrp);
		if(infoList!=null){
			LCCont lcCont=new LCCont();
			Iterator li=infoList.iterator();
			while(li.hasNext()){
				lcCont=(LCCont) li.next();
				lcCont.setSignCom(lcGrp.getManageCom());
				lcCont.setSignDate(new Date());
				lcCont.setSignTime(DateUtil.getTime());
				lcCont.setModifyDate(new Date());
				lcCont.setModifyTime(DateUtil.getTime());
				lcCont.setState(finalCollection.CONT_STATE0);
				this.update(lcCont);
				this.flush();
				this.evict(lcCont);
			}
		}
		//更新个人险种表
		infoList=findLCPolInfoByGrpContNo(lcGrp);
		if(infoList!=null){
			LCPol lcPol=new LCPol();
			Iterator li=infoList.iterator();
			while(li.hasNext()){
				lcPol=(LCPol) li.next();
				lcPol.setSignCom(lcGrp.getManageCom());
				lcPol.setSignDate(new Date());
				lcPol.setSignTime(DateUtil.getTime());
				lcPol.setModifyDate(new Date());
				lcPol.setModifyTime(DateUtil.getTime());
				lcPol.setPolState(finalCollection.CONT_STATE0);
				this.update(lcPol);
				this.flush();
				this.evict(lcPol);
			}
		}
		//更新集体险种表
		infoList=findLCGrpPolInfoByGrpContNo(lcGrp);
		if(infoList!=null){
			LCGrpPol lcGrpPol=new LCGrpPol();
			Iterator li=infoList.iterator();
			while(li.hasNext()){
				lcGrpPol=(LCGrpPol) li.next();
				lcGrpPol.setModifyDate(new Date());
				lcGrpPol.setModifyTime(DateUtil.getTime());
				lcGrpPol.setState(finalCollection.CONT_STATE0);
				this.update(lcGrpPol);
				this.flush();
				this.evict(lcGrpPol);
			}
		}
		//String newGrpContNo=obtainGrpContNo();
		//setGrpContNos(newGrpContNo,lcGrp);
		return true;	
		
	}
	/**
	 * 自动生成P打头的集体合同号
	 * @param lcgrpcont
	 * @author 郭占红
	 */
	public String obtainGrpContNo(){
		ActionContext ac = ActionContext.getContext();
		//得到当前机构代码
    	PrpDcompany company=(PrpDcompany) ac.getSession().get("prpDcompany");
    	String comCode=company.getComCode();
    	String grpContNo=serialNoUtil.serialNo("LCGRPCONT",comCode, "GRPCONTNO");
    	return grpContNo;
	}
	/**
	 *签单成功后把集体保单表、个人保单表、个人险种表、集体险种表中的集体合同号改为自动生成的以P打头的流水号
	 *@param grpContNo
	 *@author 郭占红
	 */
	public void setGrpContNos(String newGrpContNo,LCGrpCont lcGrpCont){
		List infoList=new ArrayList();
		//更新LCCont
		infoList=findLCContInfoByGrpContNo(lcGrpCont);
		if(infoList!=null){
			LCCont lcCont=new LCCont();
			Iterator li=infoList.iterator();
			while(li.hasNext()){
				lcCont=(LCCont) li.next();
				lcCont.setGrpContNo(newGrpContNo);
				this.update(lcCont);
				this.flush();
				this.evict(lcCont);
			}
		}
		//更新LCPol
		infoList=findLCPolInfoByGrpContNo(lcGrpCont);
		if(infoList!=null){
			LCPol lcPol=new LCPol();
			Iterator li=infoList.iterator();
			while(li.hasNext()){
				lcPol=(LCPol) li.next();
				lcPol.setGrpContNo(newGrpContNo);
				this.update(lcPol);
				this.flush();
				this.evict(lcPol);
			}
		}
		//更新LCGrpPol
		infoList=findLCGrpPolInfoByGrpContNo(lcGrpCont);
		if(infoList!=null){
			LCGrpPol lcGrpPol=new LCGrpPol();
			Iterator li=infoList.iterator();
			while(li.hasNext()){
				lcGrpPol=(LCGrpPol) li.next();
				lcGrpPol.setGrpContNo(newGrpContNo);
				this.update(lcGrpPol);
				this.flush();
				this.evict(lcGrpPol);
			}
		}
		
	//更新lcGrpCont表
	 LCGrpCont lcGrp=this.get(lcGrpCont.getGrpContNo());
	 lcGrp.setGrpContNo(newGrpContNo);
	 this.update(lcGrp);
	 this.flush();
	this.evict(lcGrp);

   }
}