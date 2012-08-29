/**
 * @ create_date 2012-8-9
 * @ author long
 * @ version 1.0
 */
package ins.prpall.proposal.service.spring;

import ins.common.util.FinalCollection;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.common.SerialNoUtil;
import ins.platform.model.PrpDuser;
import ins.product.model.PDLMRisk;
import ins.prpall.proposal.model.LCCont;
import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.model.LCRepInfo;
import ins.prpall.proposal.model.LDPerson;
import ins.prpall.proposal.service.facade.ProposalApproveService;
import ins.prpall.proposal.vo.GrpRiskVo;
import ins.prpall.report.model.LCGrpPol;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

/**
 *
 * @title ProposalApproveServiceSpringImpl
 * @description 投保单复核ServiceSpringImpl
 * @author 于文龙 
 * @create date 2012-8-9
 * @copyright (c) SINOSOFT
 */
@SuppressWarnings("unchecked")
public class ProposalApproveServiceSpringImpl extends
GenericDaoHibernate<LCGrpCont, String> implements ProposalApproveService {

	private SerialNoUtil serialNoUtil;

	public SerialNoUtil getSerialNoUtil() {
		return serialNoUtil;
	}

	public void setSerialNoUtil(SerialNoUtil serialNoUtil) {
		this.serialNoUtil = serialNoUtil;
	}
	/**
	 * @title 
	 * @description 投保单信息查询
	 * @param lcGrpCont
	 * @author 于文龙
	 */
	@Override
	public List<LCGrpCont> findGrpContInfo(LCGrpCont lcGrpCont,int pageNo,int pageSize) {
		QueryRule queryRule=QueryRule.getInstance();
		queryRule.addIsNull("approveCode");
		queryRule.addEqual("state", "04");
		//投保单号
		if(null!=lcGrpCont.getGrpContNo() && !"".equals(lcGrpCont.getGrpContNo())){
			queryRule.addEqual("grpContNo", lcGrpCont.getGrpContNo().trim());
		}
		//销售类型
		if(null!=lcGrpCont.getGrpSellType() && !"".equals(lcGrpCont.getGrpSellType())){
			queryRule.addEqual("grpSellType", lcGrpCont.getGrpSellType().trim());
		}
		//管理机构
		if(null!=lcGrpCont.getManageCom() && !"".equals(lcGrpCont.getManageCom())){
			queryRule.addEqual("manageCom", lcGrpCont.getManageCom().trim());
		}
		//业务员
		if(null!=lcGrpCont.getAgentCode() && !"".equals(lcGrpCont.getAgentCode())){
			queryRule.addEqual("agentCode", lcGrpCont.getAgentCode().trim());
		}
		//投保单位全称
		if(null!=lcGrpCont.getGrpName() && !"".equals(lcGrpCont.getGrpName())){
			queryRule.addEqual("grpName", lcGrpCont.getGrpName().trim());
		}
		//扫描标记暂无
//		if(null!=lcGrpCont.getManageCom() && !"".equals(lcGrpCont.getManageCom())){
//			hql+=" and l.manageCom='"+lcGrpCont.getManageCom()+"'";
//		}
		List<LCGrpCont> lcGrpContList=this.find(queryRule);
		return lcGrpContList;
	}

	/**
	 * @title 弃用
	 * @description 集体投保单审核申请
	 * @param lcGrpCont
	 * @author 于文龙
	 */
	@Override
	public Page applyLcGrpCont(LCGrpCont lcGrpCont,int pageNo,int pageSize) {
		if(null!=lcGrpCont.getGrpContNo() && !"".equals(lcGrpCont.getGrpContNo())){
			ActionContext ac=ActionContext.getContext();
			PrpDuser user =(PrpDuser)ac.getSession().get("user");
			LCGrpCont lcGrpContTemp =this.findUnique("grpContNo", lcGrpCont.getGrpContNo());
			lcGrpContTemp.setApproveCode(user.getUserCode());
			lcGrpContTemp.setApproveFlag("0");
			this.update(lcGrpContTemp);
			return this.findByHql("from LCGrpCont l where l.approveCode='"+lcGrpContTemp.getApproveCode()+"'", pageNo, pageSize, null);
		}else{
		return null;
		}
	}

	/**
	 * @description 对已申请投保单进行审核查询
	 * @param lcGrpCont
	 * @author 于文龙
	 */
	@Override
	public Map<String, Object> auditLcGrpCont(LCGrpCont lcGrpCont) {
		if(null!=lcGrpCont.getGrpContNo() && !"".equals(lcGrpCont.getGrpContNo())){
			//根据集体合同号查询告知单表
			List<LCRepInfo> lcRepInfoList=this.findByHql("from LCRepInfo l where l.id.grpContNo='"+lcGrpCont.getGrpContNo()+"'", null);
			
			//根据集体合同号查询集体险种表
			List<LCGrpPol> lcGrpPolList=this.findByHql("from LCGrpPol l where l.grpContNo='"+lcGrpCont.getGrpContNo()+"'", null);
			
			List<GrpRiskVo> grpRiskVoList=new ArrayList<GrpRiskVo>();
			for(int i=0;i<lcGrpPolList.size();i++){
				GrpRiskVo gv=new GrpRiskVo();
				gv.setRiskCode(lcGrpPolList.get(i).getRiskCode());
				gv.setAmnt(lcGrpPolList.get(i).getAmnt());
				gv.setPrem(lcGrpPolList.get(i).getPrem());
				gv.setRiskName(findRiskNameByCode(lcGrpPolList.get(i).getRiskCode()));
				grpRiskVoList.add(gv);
			}
			//申请操作
			if(null!=lcGrpCont.getGrpContNo() && !"".equals(lcGrpCont.getGrpContNo())){
				ActionContext ac=ActionContext.getContext();
				PrpDuser user =(PrpDuser)ac.getSession().get("user");
				LCGrpCont lcGrpContTemp =this.findUnique("grpContNo", lcGrpCont.getGrpContNo());
				lcGrpContTemp.setApproveCode(user.getUserCode());
				lcGrpContTemp.setApproveFlag("0");
				lcGrpContTemp.setState(FinalCollection.CONT_STATE5);
				lcGrpContTemp.setModifyDate(new Date());
				lcGrpContTemp.setModifyTime(DateUtil.getTime());
				this.update(lcGrpContTemp);
			}
			Map<String , Object> map=new HashMap<String,Object>();
			map.put("lcRepInfoList", lcRepInfoList);
			map.put("grpRiskVoList",grpRiskVoList);
			return map;
		}else{
			return null;
		}
	}
/**
 * 
 * @title 
 * @description 根据险种号查询险种名称
 * @param code
 * @return
 * @author 于文龙
 */
	public String findRiskNameByCode(String code){
		QueryRule queryRule=QueryRule.getInstance();
		if(null!=code&&!"".equals(code)){
		queryRule.addEqual("riskCode", code);
		PDLMRisk pdlmRisk= this.findUnique(PDLMRisk.class, queryRule);
		System.out.print(pdlmRisk.getRiskName());
		return pdlmRisk.getRiskName();
		}else{
			return "";
		}
	}

	/**
	 * @description 审核完毕
	 * @param lcGrpCont
	 * @author 于文龙
	 */
	@Override
	public LCGrpCont finishAudit(LCGrpCont lcGrpCont) {
		ActionContext ac=ActionContext.getContext();
		PrpDuser user=(PrpDuser)ac.getSession().get("user");
		//判断不为空
		if(null!=lcGrpCont && null!=lcGrpCont.getGrpContNo() && !"".equals(lcGrpCont.getGrpGroupNo())){
			try{
			LCGrpCont lcGrpContTemp =this.findUnique("grpContNo", lcGrpCont.getGrpContNo());
			//06代表待人工核保
			lcGrpContTemp.setState(FinalCollection.CONT_STATE6);
			//1代表复核完毕
			lcGrpContTemp.setApproveFlag("1");
			lcGrpContTemp.setApproveCode(user.getUserCode());
			lcGrpContTemp.setApproveDate(DateUtil.getDate());
			lcGrpContTemp.setApproveTime(DateUtil.getTime());
			lcGrpContTemp.setModifyDate(DateUtil.getDate());
			lcGrpContTemp.setModifyTime(DateUtil.getTime());
			this.update(lcGrpContTemp);
			return lcGrpContTemp;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}else{
		return null;
		}
	}

	/**
	 * @title findLcContAndInsured
	 * @description 已承保保单查询
	 * @param lcGrpCont
	 * @param pageNo
	 * @param pageSize
	 * @author 于文龙
	 */
	@Override
	public Map<String, Object> findLcContAndInsured(LCGrpCont lcGrpCont,
			int pageNo, int pageSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		
		//投保单号
		if(null!=lcGrpCont&&null!=lcGrpCont.getGrpContNo()&&!"".equals(lcGrpCont.getGrpContNo())){
			//原客户信息
		String oldHql=" select a from LDPerson a,LCCont b where b.insuredNo <> a.customerNo  and b.insuredName = a.name"+
		" and b.insuredSex = a.sex and b.insuredBirthday = a.birthday and b.insuredIDType = a.idType "+
		"and b.insuredIDNo = a.idNo and b.grpContNo=?";
		List<LDPerson> ldPersonList=this.findByHql(oldHql, lcGrpCont.getGrpContNo());
		
		//重复信息
		String repeatHql="select distinct b.contNo,b.insuredNo,b.insuredName,b.insuredSex,b.insuredBirthday,b.insuredIDType,b.insuredIDNo,b.amnt from LDPerson a,LCCont b where b.insuredNo <> a.customerNo  "
			+" and b.insuredName = a.name   and b.insuredSex = a.sex   and b.insuredBirthday = a.birthday  "+
		" and b.insuredIDType = a.idType   and b.insuredIDNo = a.idNo   and b.grpContNo=?";
		System.out.println(repeatHql);
			List<Object> repeatInfoList=this.findByHql(repeatHql, lcGrpCont.getGrpContNo());
			
			map.put("ldPersonList",ldPersonList);
			map.put("repeatInfoList", repeatInfoList);
			return map;
		}
		return null;
	}

	/**
	 * @title initialLcGrpContAudit
	 * @description 初始化方法
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @author 于文龙
	 */
	@Override
	public Page initialLcGrpContAudit(int pageNo, int pageSize) {
		ActionContext ac=ActionContext.getContext();
		PrpDuser user=(PrpDuser)ac.getSession().get("user");
		if(null!=user){
			String hql="from LCGrpCont l where l.state='05' and l.approveFlag='0' and l.approveCode='"+user.getUserCode().trim()+"'";
			return this.findByHql(hql, pageNo, pageSize, null);
		}
		return null;
	}

	/**
	 * @title mergeCustomerNo
	 * @description 合并客户号
	 * @param lcInsured
	 * @param lcCont
	 * @param pageNo
	 * @param pageSize
	 * @author 于文龙
	 */
	@Override
	public Map<String, Object> mergeCustomerNo(LDPerson ldPerson,LCCont lcCont, int pageNo, int pageSize) {
		//删除个人客户表的信息
		LDPerson oldLDPerson=null;
		if(null!=ldPerson.getCustomerNo()&&!"".equals(ldPerson.getCustomerNo())){
			//获得原客户信息信息
			QueryRule oldRule=QueryRule.getInstance();
			oldRule.addEqual("customerNo", ldPerson.getCustomerNo());
			oldLDPerson=this.findUnique(LDPerson.class, oldRule);
			this.flush();
			//删除原信息
			this.delete(ldPerson);
			String customerNo=serialNoUtil.serialNo("LDPERSON","", "CUSTOMERNO");
		}
		return null;
	}
	
	
	
	
}
