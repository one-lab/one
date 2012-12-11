package ins.prpall.proposal.service.spring;

import ins.common.util.FinalCollection;
import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.common.SerialNoUtil;
import ins.platform.model.PrpDcompany;
import ins.platform.model.PrpDuser;
import ins.product.model.PDLDcode1;
import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.model.LCGrpServInfo;
import ins.prpall.proposal.model.LCNotepad;
import ins.prpall.proposal.model.LDGrp;
import ins.prpall.proposal.service.facade.ProposalPreService;
import ins.prpall.report.vo.ReportInfoVo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

public class ProposalPreServiceSpringImpl extends
GenericDaoHibernate<LCGrpCont, String>  implements ProposalPreService {
	private SerialNoUtil serialNoUtil;
	private FinalCollection finalCollection;

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

	
	/**根据投保单号、管理机构、初审日期、投保单位、主营业务员查询投保单信息
	 * @param lcGrpContReport
	 * @author 郭占红
	 */
	
	public Page findProsalPreInfo(QueryRule findRiskRule, int pageNo,
			int pageSize) {
		
		Page page = this.find(findRiskRule, pageNo, pageSize);
		return page;
	}

	/**据客户号查询相关呈报件 
	 * @param lcReport
	 * @param LCReportAudit
	 * @author 郭占红
	 */
	
	public Page findReportInfo(String appno, int pageNo, int pageSize) {
		List<ReportInfoVo> findResult=new ArrayList<ReportInfoVo>();
		
		String findReportHql="";
		if (appno != null && !"".equals(appno.trim())){ 
			 findReportHql="select new ins.prpall.report.vo.ReportInfoVo(max(t2.id.serialNo),t1.repNo, t1.name,t1.manageCom,t1.repOperator,t1.repApplyDate,t2.result,t2.repAuditIdea) from LCReport t1,LCReportAudit t2 where  t1.repNo=t2.id.repNo and  t1.appNo='"+appno+"' and t2.repAuditIdea !=null " +
							"group by t1.serialNo,t1.repNo,t1.name,t1.manageCom,t1.repOperator,t1.repApplyDate,t2.result,t2.repAuditIdea";
	    }
		
		Page page=this.findByHql(findReportHql, pageNo, pageSize, null);
	    return page;
     }

	/**据集体合同号查询投保单
	 * @param grpContNo
	 * @author 郭占红
	 */
	//TODO 郭占红--优化查询方法
	public LCGrpCont findProsalPreInfoByGrpContNo(String grpContNo) {
		return this.get(grpContNo);
	}

	/**根据业务号查看记事本内容 
	 * @param lcNotepad
	 * @author 郭占红
	 */
	public Page findNoteInfo( LCNotepad lcNotepad ,int pageNo,int pageSize ) {
		
		if(pageNo == 0){
		   pageNo = 1; 
		}
		if(pageSize == 0){
			pageSize = FinalCollection.PAGE_SIZE;
		}
		QueryRule findRule = QueryRule.getInstance();
		if(null!=lcNotepad.getId().getBussinessNo() && !"".equals(lcNotepad.getId().getBussinessNo().trim())){
			findRule.addEqual("id.bussinessNo",lcNotepad.getId().getBussinessNo());
		}else{
			findRule.addEqual("id.bussinessNo","");//如果不加else，则会显示出全部记事本信息
		}
		if(null!=lcNotepad.getInputLocation() && !"".equals(lcNotepad.getInputLocation().trim())){
			findRule.addEqual("inputLocation",lcNotepad.getInputLocation().trim());
		}else{
			findRule.addEqual("inputLocation","");
		}
		findRule.addAscOrder("id.serialNo");
		Page page = this.find(LCNotepad.class,findRule, pageNo, pageSize);
	    
		//把每一条记事本信息的录入位置的code编码变成codeName形式
		List<LCNotepad> findResult=(List<LCNotepad>)page.getResult();
		Iterator lt=findResult.iterator();
		LCNotepad note=new LCNotepad();
		while(lt.hasNext()){
			note=(LCNotepad) lt.next();
			note.setInputLocation(getCodeNameByCode(note.getInputLocation(),"InputLocation"));
		}
		return page;
		
		
		
	}
	/**
	 * 根据code查找codeName
	 * @param PD_LDCODE1
	 * @author 郭占红
	 */
	public String getCodeNameByCode(String code,String codeType){
		
		QueryRule qr = QueryRule.getInstance();
		qr.addEqual("id.codeType", codeType);
		qr.addEqual("id.code", code);
		PDLDcode1 pdld = this.findUnique(PDLDcode1.class,qr );
		if(pdld !=null){
			return pdld.getCodeName().trim();
		}
		return "";
		}
	
	/**
	 * 自动生成集体投保单号
	 * @param lcgrpcont
	 * @author 郭占红
	 */
	public String obtainProposalGrpContNo(){
		ActionContext ac = ActionContext.getContext();
		//得到当前机构代码
    	PrpDcompany company=(PrpDcompany) ac.getSession().get("prpDcompany");
    	String comCode=company.getComCode();
    	String proposalGrpContNo=serialNoUtil.serialNo("LCGRPCONT",comCode, "PROPOSALGRPCONTNO");
    	return proposalGrpContNo;
	}



	/**保存记事本内容
	 * @param lcNotepad
	 * @author 郭占红
	 */
	public LCNotepad savaNoteInfo(LCNotepad lcNotepad) {
		ActionContext ac = ActionContext.getContext();
		//得到当前操作员
    	PrpDuser user=(PrpDuser) ac.getSession().get("user");
    	String operator=user.getUserName();
    	
    	//得到业务号
    	String bussinessNo= lcNotepad.getId().getBussinessNo().trim();
    	//录入位置
    	String inputlocation=lcNotepad.getInputLocation().trim();
    	//录入和入机日期时间（当前日期时间）
    	Date modifyDate=null;
    	Date makeDate=null;
    	String makeTime =null;
    	String modifyTime=null;
		try {
			modifyDate = DateUtil.getDate();
			modifyTime=DateUtil.getTime();
			makeDate=DateUtil.getDate();
			makeTime=DateUtil.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int serialNo=obtainSerialNoByBusinessNo(bussinessNo)+1;
		lcNotepad.getId().setSerialNo(serialNo);
		lcNotepad.getId().setBussinessNo(bussinessNo);
       	lcNotepad.setOperator(operator);
    	lcNotepad.setInputLocation(inputlocation);
    	lcNotepad.setModifyDate(modifyDate);
    	lcNotepad.setModifyTime(modifyTime);
    	lcNotepad.setMakeDate(makeDate);
    	lcNotepad.setMakeTime(makeTime);
     	this.save(lcNotepad);
     	this.flush();
     	this.evict(lcNotepad);
     	lcNotepad.setInputLocation(this.getCodeNameByCode(lcNotepad.getInputLocation(), "InputLocation"));
    	return lcNotepad;
    	
    }
	/**
	 * 根据投保单号查询同一条股保单中serialNo的最大值，目的是确定lcNotepad中的serialNo的值
	 * @param lcNotepad
	 * @businessNo
	 * @author 郭占红
	 */
	public int obtainSerialNoByBusinessNo(String bussinessNo){
		HqlQueryRule hqlqr = new HqlQueryRule();
		String findReportHql ="select max(id.serialNo)  from LCNotepad where id.bussinessNo=?";
		
		System.out.println(hqlqr.getHql());
		List<Object> ob=(List<Object>) this.findByHql(findReportHql, bussinessNo);
		if(null==ob.get(0)){
			return 0;
		}
		return (Integer) ob.get(0);
		 
			
	}
	
	/**根据序列号查询记事本信息
	 * @param lcNotepad
	 * @author 郭占红
	 */
	
	public List<LCNotepad> findNoteBySerialNo(String serialNo){
		List<LCNotepad> findResult=new ArrayList<LCNotepad>();
		StringBuffer findReportHql = new StringBuffer();
		if (serialNo != null && !"".equals(serialNo.trim())){ 
			findReportHql.append("from LCNotepad lcNotepad where lcNotepad.serialNo ='"+serialNo+"'");
		}
		findResult =this.findByHql(findReportHql.toString(), null);
		if(findResult==null || findResult.size()<=0){
			findResult=null;
		}
	    return findResult;
		
	}
	 /**保存投保单初审信息
  	 * @param  lcGrpCont
  	 * @author 郭占红
  	 */
    public boolean saveProposalInfo(LCGrpCont lcGrpCont){
    	ActionContext ac = ActionContext.getContext();
    	//得到当前操作员
    	PrpDuser user=(PrpDuser) ac.getSession().get("user");
    	String operator=user.getUserName();
    	String manageCom=lcGrpCont.getManageCom().trim();
    	String grpContNo=lcGrpCont.getGrpContNo().trim();
    	String grpSellType=lcGrpCont.getGrpSellType().trim();
    	String previewPrintFlag=lcGrpCont.getPreviewPrintFlag().trim();
    	String handlerName=lcGrpCont.getHandlerName().trim();
    	Date modifyDate=null;
    	Date makeDate=null;
    	String makeTime =null;
    	String modifyTime=null;
		try {
			modifyDate = DateUtil.getDate();
			modifyTime=DateUtil.getTime();
			makeDate=DateUtil.getDate();
			makeTime=DateUtil.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lcGrpCont.setGrpContNo(grpContNo);
		lcGrpCont.setProposalGrpContNo(grpContNo);
		lcGrpCont.setManageCom(manageCom);
		lcGrpCont.setPreviewPrintFlag(previewPrintFlag);
		lcGrpCont.setHandlerName(handlerName);
		lcGrpCont.setOperator(operator);
		lcGrpCont.setState("01");
		lcGrpCont.setModifyDate(modifyDate);
		lcGrpCont.setModifyTime(modifyTime);
		lcGrpCont.setMakeDate(makeDate);
		lcGrpCont.setMakeTime(makeTime);
		
		
		lcGrpCont.setGrpSellType(grpSellType);
	    this.save(lcGrpCont);
	    
	    return findProposalInfoByGrpContNo(grpContNo);
    }
	
    /**判断投保单号（集体合同号）是否存在
  	 * @param  lcGrpCont
  	 * @author 郭占红
  	 */
    public boolean findProposalInfoByGrpContNo(String grpContNo){
    	QueryRule qr = QueryRule.getInstance();
		qr.addEqual("grpContNo", grpContNo);
		LCGrpCont lcGrpCont =this.findUnique(qr);
		
		if(lcGrpCont==null ){
			return false;
		}
	    return true;
    	
    }

    /**根据集体合同号更新投保单初审信息
     * @param  lcGrpCont
 	  * @author 郭占红	
     */
	public boolean updateProposalInfo(LCGrpCont lcGrpCont) {
		LCGrpCont lcGrp=findProsalPreInfoByGrpContNo(lcGrpCont.getGrpContNo());
		
		lcGrp.setManageCom(lcGrpCont.getManageCom().trim());
		lcGrp.setFirstTrialDate(lcGrpCont.getFirstTrialDate());
		lcGrp.setAppntNo(lcGrpCont.getAppntNo().trim());
		lcGrp.setGrpName(lcGrpCont.getGrpName().trim());
		lcGrp.setHandlerName(lcGrpCont.getHandlerName().trim());
		lcGrp.setGrpSellType(lcGrpCont.getGrpSellType().trim());
		lcGrp.setPrem(lcGrpCont.getPrem());
		lcGrp.setReportNo(lcGrpCont.getReportNo().trim());
		lcGrp.setPreviewPrintFlag(lcGrpCont.getPreviewPrintFlag().trim());
		lcGrp.setModifyDate(new Date());
		lcGrp.setModifyTime(DateUtil.getTime());
		
		try{
		this.update(lcGrp);
		return true;
		}catch(Exception e){
		return false;
		}
		
	}

	/**
     * 
     * @title saveLcGrpServInfo
     * @description 保存团单服务信息
     * @author 郭占红
     * @param lcGrpServInfo
     * @return
     */
	public boolean saveLcGrpServInfo(LCGrpServInfo lcGrpServInfo) {
		//如果要保存的那条信息已经存在就进行更新操作，不存在就进行保存操作
         List<LCGrpServInfo> lcGrpServInfoList=	 findLcGrpServInfoByGrpContNo(lcGrpServInfo.getId().getGrpContNo(),lcGrpServInfo.getId().getServKind(),lcGrpServInfo.getId().getServDetail());    
		if(lcGrpServInfoList!=null){
			updateLcGrpServInfo(lcGrpServInfo);
			return true;
		}
			Date modifyDate=null;
	    	Date makeDate=null;
	    	String makeTime =null;
	    	String modifyTime=null;
			try {
				modifyDate = DateUtil.getDate();
				modifyTime=DateUtil.getTime();
				makeDate=DateUtil.getDate();
				makeTime=DateUtil.getTime();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			lcGrpServInfo.setProposalGrpContNo(lcGrpServInfo.getId().getGrpContNo());
			lcGrpServInfo.setPrtNo(lcGrpServInfo.getId().getGrpContNo());
			lcGrpServInfo.getId().setServDetail(lcGrpServInfo.getId().getServDetail().trim());
			lcGrpServInfo.setModifyDate(modifyDate);
			lcGrpServInfo.setModifyTime(modifyTime);
			lcGrpServInfo.setMakeDate(makeDate);
			lcGrpServInfo.setMakeTime(makeTime);
		this.save(lcGrpServInfo);
		return true;
	}

	/**
     * @title updateLcGrpServInfo
     * @description 更新团单服务信息
     * @author 郭占红
     * @param lcGrpServInfo
     * @return
     */
	public boolean updateLcGrpServInfo(LCGrpServInfo lcGrpServInfo) {
		List<LCGrpServInfo> result=findLcGrpServInfoByGrpContNo(lcGrpServInfo.getId().getGrpContNo(),lcGrpServInfo.getId().getServKind(),lcGrpServInfo.getId().getServDetail());
		LCGrpServInfo lcGrpServ=null;
		if(result!=null && result.size()>0){
			lcGrpServ=(LCGrpServInfo )result.iterator().next();
		}
		Date modifyDate=null;
    	String modifyTime=null;
		try {
			modifyDate = DateUtil.getDate();
			modifyTime=DateUtil.getTime();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lcGrpServ.setProposalGrpContNo(lcGrpServInfo.getId().getGrpContNo());
		lcGrpServ.setPrtNo(lcGrpServInfo.getId().getGrpContNo());
		lcGrpServ.setModifyDate(modifyDate);
		lcGrpServ.setModifyTime(modifyTime);
		
		try{
			this.update(lcGrpServ);
			return true;
			}catch(Exception e){
			return false;
			}
			
		
	}
	/**
     * @title findLcGrpServInfo
     * @description 判断指定集体合同号的团单服务信息是否存在
     * @author 郭占红
     * @param lcGrpServInfo
     * @return
     */
	public List<LCGrpServInfo> findLcGrpServInfoByGrpContNo(String grpContNo,String servKind,String servDetail){
		List<LCGrpServInfo> findResult=new ArrayList<LCGrpServInfo>();
		StringBuffer findReportHql = new StringBuffer();
		if (grpContNo != null && !"".equals(grpContNo.trim())&& servKind !=null && !"".equals(servKind.trim()) && servDetail!=null && !"".equals(grpContNo.trim())){ 
			findReportHql.append("from LCGrpServInfo lcGrpServInfo where lcGrpServInfo.id.grpContNo ='"+grpContNo+"' and lcGrpServInfo.id.servKind ='"+servKind+"' and lcGrpServInfo.id.servDetail ='"+servDetail+"'");
		}
		findResult =this.findByHql(findReportHql.toString(), null);
		if(findResult==null || findResult.size()<=0){
			findResult=null;
		}
	    return findResult;
		
	}

	 /**根据投保单位名称查询客户号
     * @param  ldGrp
     * @author 郭占红
     */
	public String findCustomerNoByGrpName(String grpName) {
		QueryRule qr = QueryRule.getInstance();
		qr.addEqual("grpName", grpName);
		LDGrp ldGrpResult = this.findUnique(LDGrp.class,qr );
		if(ldGrpResult !=null){
			return ldGrpResult.getCustomerNo().trim();
		}
		return null;
	}
	 /**
	 * 初审确认
	 * @param lcgrpcont
	 * @author 郭占红
	 */

	@Override
	public boolean proposalPreConfirm(LCGrpCont lcGrpCont) {
		LCGrpCont lcGrp=findProsalPreInfoByGrpContNo(lcGrpCont.getGrpContNo());
		
		
		lcGrp.setFirstTrialDate(new Date());
		lcGrp.setFirstTrialTime(DateUtil.getTime());
		lcGrp.setModifyDate(new Date());
		lcGrp.setModifyTime(DateUtil.getTime());
		System.out.println(finalCollection.CONT_STATE2);
		lcGrp.setState(finalCollection.CONT_STATE2);
		try{
			this.update(lcGrp);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	
	
}
		
		
		
		
		
		
		
		
		