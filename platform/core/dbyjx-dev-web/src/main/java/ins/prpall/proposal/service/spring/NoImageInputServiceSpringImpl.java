package ins.prpall.proposal.service.spring;

import ins.common.util.FinalCollection;
import ins.common.util.PropertyBeanUtils;
import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.common.SerialNoUtil;
import ins.platform.model.PrpDuser;
import ins.platform.vo.QueryCodeVo;
import ins.product.model.PDLMRisk;
import ins.product.model.PDLMRiskApp;
import ins.prpall.proposal.model.LCBnf;
import ins.prpall.proposal.model.LCGrpAppnt;
import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.model.LCGrpRepInfo;
import ins.prpall.proposal.model.LCGrpRepInfoDetail;
import ins.prpall.proposal.model.LCInsured;
import ins.prpall.proposal.model.LCRepInfo;
import ins.prpall.proposal.model.LDGrp;
import ins.prpall.proposal.service.facade.NoImageInputService;
import ins.prpall.proposal.vo.LCGrpPolVo;
import ins.prpall.proposal.vo.LcGrpContGroupVo;
import ins.prpall.proposal.vo.NoImageInputInitVo;
import ins.prpall.report.model.LCGrpAppReport;
import ins.prpall.report.model.LCGrpContReport;
import ins.prpall.report.model.LCGrpPol;
import ins.prpall.report.model.LCGrpPolReport;
import ins.prpall.report.model.LCRepInfoReport;
import ins.prpall.report.model.LCRepInfoReportDetail;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.beanutils.PropertyUtils;
/**
 * 
 * @title NoImageInputServiceSpringImpl
 * @description 无影像录入Service层实现类
 * @author xu_xinling
 * @version 
 * @create date 2012-8-6
 * @copyright (c) 
 *
 */
public class NoImageInputServiceSpringImpl extends GenericDaoHibernate<LCGrpCont, String>
		implements NoImageInputService {
	private SerialNoUtil serialNoUtil;

	public SerialNoUtil getSerialNoUtil() {
		return serialNoUtil;
	}

	public void setSerialNoUtil(SerialNoUtil serialNoUtil) {
		this.serialNoUtil = serialNoUtil;
	}
	/**
	 * 告知单、受益人、被保险人信息保存
	 * @param lcInsured
	 * @param lcRepInfoList
	 * @param lcBnfList
	 * @author 于文龙
	 */
	@Override
	public Map<String, Object> saveAllInfo(LCInsured lcInsured,
			List<LCRepInfo> lcRepInfoList, List<LCBnf> lcBnfList) {
	/*	// lcInsured信息整理
		try {
		lcInsured.setOccupationCode(lcInsured.getOccupationCode().trim());
		lcInsured.setOccupationType(lcInsured.getOccupationType().trim());
		lcInsured.setPrtNo(lcInsured.getGrpContNo());
		lcInsured.setExecuteCom(lcInsured.getManageCom());
		lcInsured.setMakeTime(DateUtil.getTime());
		lcInsured.setMakeDate(DateUtil.getDate());
		lcInsured.setModifyDate(DateUtil.getDate());
		lcInsured.setModifyTime(DateUtil.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//被保人客户号自动取得
		String insuredCode=serialNoUtil.serialNo("LCINSURED",lcInsured.getManageCom(),"INSUREDCODE");
		//新建ID类
		LCInsuredId lcInsuredId=new LCInsuredId();
		lcInsuredId.setContNo(lcInsured.getGrpContNo());
		lcInsuredId.setInsuredNo(insuredCode);
		lcInsured.setId(lcInsuredId);
		lcInsured.setAppntNo(insuredCode);
		
		//告知单信息整理
		List<LCRepInfo> lcRepInfoListTemp=new ArrayList<LCRepInfo>();
		for(int i=0;i<lcRepInfoList.size();i++){
			if(null!=lcRepInfoList.get(i)){
				lcRepInfoListTemp.add((LCRepInfo)lcRepInfoList.get(i));			
			}
		}
		try{
		if(null!=lcRepInfoListTemp){
			for(int j=0;j<lcRepInfoListTemp.size();j++){
				lcRepInfoListTemp.get(j).getId().setGrpContNo(lcInsured.getGrpContNo());
				lcRepInfoListTemp.get(j).getId().setProposalContNo(lcInsured.getGrpContNo());
				lcRepInfoListTemp.get(j).setContNo(lcInsured.getGrpContNo());
				//流水号
				// 流水号取得
				int number = 1;
				if (null != lcRepInfoList.get(0).getId().getGrpContNo()
						&& null != lcRepInfoList.get(0).getId().getImpartCode()
						&& null != lcRepInfoList.get(0).getId().getImpartVer()
						&& null != lcRepInfoList.get(0).getId().getProposalContNo()&&null==lcRepInfoList.get(0).getId().getSubSerialNo()) {
					List<LCRepInfo> tempList = this
							.findByHql(
									"from LCRepInfo lcRepInfo where lcRepInfo.id.grpContNo='"
											+ lcRepInfoList.get(0).getId()
													.getGrpContNo()
											+ "' and lcRepInfo.id.proposalContNo='"
											+ lcRepInfoList.get(0).getId()
													.getProposalContNo()
											+ "' and lcRepInfo.id.impartCode='"
											+ lcRepInfoList.get(0).getId()
													.getImpartCode()
											+ "' and lcRepInfo.id.impartVer='"
											+ lcRepInfoList.get(0).getId()
													.getImpartVer() + "'", null);
					if(tempList!=null){
						for(int k=0;k<tempList.size();k++){
							if(number<=Integer.parseInt(tempList.get(k).getId().getSubSerialNo())){
								number=Integer.parseInt(tempList.get(k).getId().getSubSerialNo())+1;
							}
						}
					}
				}
				lcRepInfoListTemp.get(j).getId().setSubSerialNo(String.valueOf(number));
				lcRepInfoListTemp.get(j).setPrtNo(lcInsured.getGrpContNo());
				//客户号和类型
				lcRepInfoListTemp.get(j).setCustomerNo(insuredCode);
				lcRepInfoListTemp.get(j).setCustomerNoType("1");
				
				lcRepInfoListTemp.get(j).setOperator(lcInsured.getOperator());
				lcRepInfoListTemp.get(j).setMakeDate(DateUtil.getDate());
				lcRepInfoListTemp.get(j).setMakeTime(DateUtil.getTime());
				lcRepInfoListTemp.get(j).setModifyDate(DateUtil.getDate());
				lcRepInfoListTemp.get(j).setModifyTime(DateUtil.getTime());			
			}
		}
		}catch (ParseException e) {
			System.out.println("告知单信息异常");
			e.printStackTrace();
		}
		//受益人信息整合
		List<LCBnf> lcBnfListTemp=new ArrayList<LCBnf>();
		for(int i=0;i<lcBnfList.size();i++){
			if(null!=lcBnfList.get(i)){
				lcBnfListTemp.add(lcBnfList.get(i));			
			}
		}
		try{
			if(null!=lcBnfListTemp){
				for(int n=0;n<lcBnfListTemp.size();n++){
					lcBnfListTemp.get(n).getId().setInsuredNo(lcInsured.getGrpContNo());
					//保单号暂时设为合同号
					lcBnfListTemp.get(n).getId().setPolNo(lcInsured.getGrpContNo());
					//受益人序号自动生成
					BigDecimal bnfNo=(BigDecimal)this.findByHql("select max(lcBnf.id.bnfNo) from LCBnf lcBnf ", null).get(0);
					lcBnfListTemp.get(n).getId().setBnfNo(bnfNo);
					lcBnfListTemp.get(n).setContNo(lcInsured.getGrpContNo());
					lcBnfListTemp.get(n).setOperator(lcInsured.getOperator());
					lcBnfListTemp.get(n).setMakeDate(DateUtil.getDate());
					lcBnfListTemp.get(n).setMakeTime(DateUtil.getTime());
					lcBnfListTemp.get(n).setModifyDate(DateUtil.getDate());
					lcBnfListTemp.get(n).setModifyTime(DateUtil.getTime());	
				}
			}
			
		}catch(Exception e){
			System.out.println("受益人异常");
			e.getStackTrace();
		}
		
		this.save(lcInsured);
		System.out.println("ok");
		this.saveAll(lcBnfListTemp);
		System.out.println("ok");
		this.saveAll(lcRepInfoListTemp);
		System.out.println("ok");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("lcInsured", lcInsured);
		dataMap.put("lcBnfList", lcBnfListTemp);
		dataMap.put("lcRepInfoList", lcRepInfoListTemp);
		return dataMap;*/
		return null;
	}
	/**
	 * 查询被保险人信息
	 * @param lcInsured被保险人信息表
	 */
	@Override
	public Page findInsuredInfo(LCInsured lcInsured) {
		/*HqlQueryRule hqlqr = new HqlQueryRule();
		StringBuffer findLCInsuredHql = new StringBuffer();
		findLCInsuredHql
				.append("from LCInsured lcInsured where lcInsured.manageCom='"
						+ lcInsured.getManageCom() + "'");
		if (!"".equals(lcInsured.getGrpContNo())
				&& lcInsured.getGrpContNo() != null) {
			findLCInsuredHql.append(" and lcInsured.grpContNo='"
					+ lcInsured.getGrpContNo() + "'");
		}
		if (!"".equals(lcInsured.getName()) && lcInsured.getName() != null) {
			findLCInsuredHql.append(" and lcInsured.name='"
					+ lcInsured.getName() + "'");
		}
		if (!"".equals(lcInsured.getIdNo()) && lcInsured.getIdNo() != null) {
			findLCInsuredHql.append(" and lcInsured.idNo='"
					+ lcInsured.getIdNo() + "'");
		}
		if (!"".equals(lcInsured.getBirthday())
				&& lcInsured.getBirthday() != null) {
			hqlqr.addEqual("lcInsured.birthday", lcInsured.getBirthday(),null);
			findLCInsuredHql.append(" and " + hqlqr.getHql());
		}
		//查询信息
		Page page = this.findByHqlNoLimit(findLCInsuredHql.toString(), 1, 2, hqlqr.getValues());
		System.out.println(page.getPageSize());
		return page;*/
		return null;
	}
	/*
	 * 
	 * @title findGrpContInfo
	 * @author xu_xinling
	 * @see ins.prpall.report.service.facade.NoImageInputService#findGrpContInfo(ins.prpall.report.model.LCGrpCont)
	 */
	@Override
	public Page findGrpContInfo(LCGrpCont lcGrpCont, int pageNo, int pageSize) {
		
		ActionContext ac = ActionContext.getContext();
		String currentComCode = (String) ac.getSession().get("comCode");//获得当前管理机构代码
		HqlQueryRule hqlqr=new HqlQueryRule();
		StringBuffer hql=new StringBuffer();
		//TODO 状态 ：应该用常量FinalCollection.PAGE_SIZE
		hql.append("select lcGrpCont from LCGrpCont lcGrpCont where 1=1 and  lcGrpCont.state in('"+FinalCollection.CONT_STATE2+"','"+FinalCollection.CONT_STATE3+"')");
		//集体保单对象不为空时
		if(null!=lcGrpCont){
			//投保单号不为空时
			if(null!=lcGrpCont.getGrpContNo()&&!"".equals(lcGrpCont.getGrpContNo())){
				hql.append(" and lcGrpCont.grpContNo = '"+lcGrpCont.getGrpContNo().trim()+"'");
			}
			//管理机构不为空时 manageCom
			if(null!=lcGrpCont.getManageCom()&&!"".equals(lcGrpCont.getManageCom())){
				hql.append(" and lcGrpCont.manageCom = '"+lcGrpCont.getManageCom().trim()+"'");
			}
			//初审日期不为空时
			if(null!=lcGrpCont.getFirstTrialDate()&&!"".equals(lcGrpCont.getFirstTrialDate())){
				hqlqr.addEqual(" lcGrpCont.firstTrialDate ", lcGrpCont.getFirstTrialDate(), null);
				hql.append(" and " + hqlqr.getHql());
			}
			//投保单位不为空时
			if(null!=lcGrpCont.getGrpName()&&!"".equals(lcGrpCont.getGrpName())){
				hql.append(" and lcGrpCont.grpName like '%"+lcGrpCont.getGrpName().trim()+"%'");
			}
		}
		else{
			hql.append(" and lcGrpCont.manageCom = '"+currentComCode+"'");
		}
		return this.findByHql(hql.toString(), pageNo,
				pageSize, hqlqr.getValues());
	}
	/*
	 * 
	 * @title findGrpContDetailInfo
	 * @author xu_xinling
	 * @see ins.prpall.report.service.facade.NoImageInputService#findGrpContDetailInfo(ins.prpall.report.model.LCGrpCont)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public LcGrpContGroupVo findGrpContDetailInfo(LCGrpCont lcGrpCont) {
		QueryRule queryRule=null;
		//查询集体保单信息
		queryRule=QueryRule.getInstance();
		queryRule.addEqual("grpContNo", lcGrpCont.getGrpContNo());
		lcGrpCont= this.findUnique(queryRule);
		
		LcGrpContGroupVo lcGrpContGroupVo=new LcGrpContGroupVo(); //保单信息封装类
		if(null==lcGrpCont.getAppntNo()){//没有录入保单信息时，即没有客户号，分两种情况：有呈报号和没有呈报号
			if(null!=lcGrpCont.getReportNo()){//有呈报号
				
				//查询LCGepContReport
				queryRule = QueryRule.getInstance();
				queryRule.addEqual("id.repNo", lcGrpCont.getReportNo());
				LCGrpContReport lcGrpContReport = this.findUnique(LCGrpContReport.class, queryRule);
				
				//将呈报集体保单中的部分信息复制到集体保单中。
				lcGrpCont.setAppntNo(lcGrpContReport.getAppntNo());
				lcGrpCont.setCorporation(lcGrpContReport.getCorporation());
				lcGrpCont.setCorporationIDType(lcGrpContReport.getCorporationIDType());
				lcGrpCont.setCorporationIDNo(lcGrpContReport.getCorporationIDNo());
				lcGrpCont.setCorporationsDate(lcGrpContReport.getCorporationsDate());
				lcGrpCont.setGrpPeoples(lcGrpContReport.getGrpPeoples());
				lcGrpCont.setMainInsurePersonNumber(lcGrpContReport.getMainInsurePersonNumber());
				lcGrpCont.setRelatedInsurePersonNumber(lcGrpContReport.getRelatedInsurePersonNumber());
				lcGrpCont.setRate(lcGrpContReport.getRate());
				//初始化集体保单类
				lcGrpContGroupVo.setLcGrpCont(lcGrpCont);
				try {
				//查询呈报单告知信息类,初始化
				List<LCRepInfoReport> lcRepList=this.find(LCRepInfoReport.class, queryRule);
				List<LCGrpRepInfo> lcRepInfoList=new ArrayList<LCGrpRepInfo>();//定义保单告知单类
				LCGrpRepInfo GrpInfoTemp=new LCGrpRepInfo();//临时类（呈报）
				LCRepInfoReport reportInfoTemp=new LCRepInfoReport();//临时类（保单）
				for(int i=0;i<lcRepList.size();i++){
					reportInfoTemp=lcRepList.get(i);
						PropertyBeanUtils.objCopyToObj(GrpInfoTemp,reportInfoTemp);
					//将呈报复制给保单类
					lcRepInfoList.add(GrpInfoTemp);
				}
				lcGrpContGroupVo.setLcRepInfoList(lcRepInfoList);
				//查询出LCGrpAppReport呈报团单投保人类
				LCGrpAppReport lcGrpAppReport = this.findUnique(LCGrpAppReport.class,queryRule);
				LCGrpAppnt lcGrpAppnt=new LCGrpAppnt();
				PropertyUtils.copyProperties(lcGrpAppnt,lcGrpAppReport);
				lcGrpContGroupVo.setLcGrpAppnt(lcGrpAppnt);
				
				//查询出LDGrp团体客户表
				queryRule = QueryRule.getInstance();
				queryRule.addEqual("customerNo", lcGrpAppReport.getCustomerNo());
				LDGrp ldGrp = this.findUnique(LDGrp.class, queryRule);
				lcGrpContGroupVo.setLdGrp(ldGrp);
				
				//查询呈报告知单明细类
				queryRule = QueryRule.getInstance();
				queryRule.addEqual("repNo", lcGrpCont.getReportNo());
				LCRepInfoReportDetail lcRepInfoReportDetail=this.findUnique(LCRepInfoReportDetail.class, queryRule);
				LCGrpRepInfoDetail lcGrpRepInfoDetail=new LCGrpRepInfoDetail();
				PropertyUtils.copyProperties(lcGrpRepInfoDetail,lcRepInfoReportDetail);
				lcGrpContGroupVo.setLcGrpRepInfoDetail(lcGrpRepInfoDetail);
				} catch (IllegalAccessException e) {
					// TODO 徐新玲：异常没有注释,还没有抛出去
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//通过呈报号 查询的集体险种集合类 
				queryRule = QueryRule.getInstance();
				queryRule.addEqual("id.repNo", lcGrpCont.getReportNo());
				List<LCGrpPolReport> polRepList=this.find(LCGrpPolReport.class, queryRule);
				List<LCGrpPolVo> lcGrpPolList =new ArrayList<LCGrpPolVo>();//新封装的集体险种类
				LCGrpPolVo l=new LCGrpPolVo();
				for(LCGrpPolReport ls:polRepList){
					//险种编码
					l.setRiskCode(ls.getRiskCode());
					//险种名称
					queryRule = QueryRule.getInstance();
					queryRule.addEqual("riskCode", ls.getRiskCode());
					PDLMRisk pdLMRisk = this.findUnique(PDLMRisk.class, queryRule);
					l.setRiskName(pdLMRisk.getRiskName());
					//保额
					l.setPrem(ls.getPrem());
					//保费
					l.setAmnt(ls.getAmnt());
					//费用率
					//TODO:费用率不知道
					l.setFloatRate(BigDecimal.valueOf(0.5));
					lcGrpPolList.add(l);
				}
				lcGrpContGroupVo.setLcGrpPolList(lcGrpPolList);
			}else{//没有呈报号时，
				//初始化保单基础类
				lcGrpContGroupVo.setLcGrpCont(lcGrpCont);
			}
		}
		else{//有客户号时
			//初始化保单基础类
			lcGrpContGroupVo.setLcGrpCont(lcGrpCont);
			//通过保单合同号查询 团体客户信息类,初始化
			queryRule=QueryRule.getInstance();
			queryRule.addEqual("customerNo",lcGrpCont.getAppntNo());
			lcGrpContGroupVo.setLdGrp(this.findUnique(LDGrp.class,queryRule));
			//通过保单号查询 团单投保人信息类,初始化
			queryRule=QueryRule.getInstance();
			queryRule.addEqual("grpContNo",lcGrpCont.getGrpContNo());
			lcGrpContGroupVo.setLcGrpAppnt(this.findUnique(LCGrpAppnt.class,queryRule));
			//通过保单号查询告知单明细类
			lcGrpContGroupVo.setLcGrpRepInfoDetail(this.findUnique(LCGrpRepInfoDetail.class,
					queryRule));
			queryRule=QueryRule.getInstance();
			queryRule.addEqual("id.grpContNo",lcGrpCont.getGrpContNo());
			List<LCGrpRepInfo> lcRepInfoList =(List<LCGrpRepInfo>)this.find(LCGrpRepInfo.class,
					queryRule);
			lcGrpContGroupVo.setLcRepInfoList(lcRepInfoList);
		}
		return lcGrpContGroupVo;
	}
	/*
	 * 
	 * @title saveGrpBaseInfo
	 * @author xu_xinling
	 * @see ins.prpall.report.service.facade.NoImageInputService#saveGrpBaseInfo(ins.prpall.report.vo.LcGrpContGroupVo)
	 */
	@Override
	public LcGrpContGroupVo saveGrpBaseInfo(LcGrpContGroupVo lcGrpContGroupVo) {
		//整个保单，都通过客户号来判断是保存信息、还是修改信息。
		QueryRule queryRule=null;
		//获得当前操作员
		ActionContext ac = ActionContext.getContext();
		PrpDuser user = (PrpDuser)ac.getSession().get("user");
		//获得当前管理机构
		String currentComCode=(String)ac.getSession().get("comCode");
		
		//lcGrpContTemp：从前台页面获得的集体保单表单类
		LCGrpCont lcGrpContTemp=lcGrpContGroupVo.getLcGrpCont();
		//ldGrpTemp：从前台页面获得的团体客户表单类
		LDGrp ldGrpTemp=lcGrpContGroupVo.getLdGrp();
		//lcGrpAppntTemp：从前台页面获得的团单投保人表单类
		LCGrpAppnt lcGrpAppntTemp=lcGrpContGroupVo.getLcGrpAppnt();
		//lcRepInfoListTemp：从前台页面获得的告知单表单类
		List<LCGrpRepInfo> lcRepInfoListTemp=lcGrpContGroupVo.getLcRepInfoList();
		//lcGrpRepInfoDetailTemp: 从前台页面获得的告知单明细类
		LCGrpRepInfoDetail lcGrpRepInfoDetailTemp= lcGrpContGroupVo.getLcGrpRepInfoDetail();
		
		//通过保单号查询 集体保单信息类 
		queryRule=QueryRule.getInstance();
		queryRule.addEqual("grpContNo", lcGrpContTemp.getGrpContNo().trim());
		LCGrpCont lcGrpCont = this.findUnique(queryRule);
		//保存页面中的信息
		if(null==lcGrpCont.getAppntNo()||"".equals(lcGrpCont.getAppntNo())){//没有客户号，说明是第1次保存。
			/** 保存集体保单的部分信息--开始 */
			//判断客户信息是否已经存在
			if(null==this.findClertInfoByName(lcGrpCont.getGrpName())){//不存在
				lcGrpCont.setAppntNo(serialNoUtil.serialNo("LDGRP",currentComCode,"CUSTOMERNO"));//自动生成客户号
			}else{//存在：直接从团体客户表里取得
				lcGrpCont.setAppntNo(this.findClertInfoByName(lcGrpCont.getGrpName()).getCustomerNo());
			}
			lcGrpCont.setReportNo(lcGrpContTemp.getReportNo().trim());
			lcGrpCont.setFirstTrialDate(lcGrpContTemp.getFirstTrialDate());
			lcGrpCont.setCvaliDate(lcGrpContTemp.getCvaliDate());
			lcGrpCont.setCregistNo(lcGrpContTemp.getCregistNo().trim());
			lcGrpCont.setManageCom(lcGrpContTemp.getManageCom().trim());
			lcGrpCont.setGrpSellType(lcGrpContTemp.getGrpSellType().trim());
			lcGrpCont.setConferNo(lcGrpContTemp.getConferNo().trim());
			
			lcGrpCont.setCorporation(lcGrpContTemp.getCorporation().trim());
			lcGrpCont.setCorporationIDType(lcGrpContTemp.getCorporationIDType().trim());
			lcGrpCont.setCorporationIDNo(lcGrpContTemp.getCorporationIDNo().trim());
			lcGrpCont.setCorporationsDate(lcGrpContTemp.getCorporationsDate());
			lcGrpCont.setGrpPeoples(lcGrpContTemp.getGrpPeoples());
			lcGrpCont.setMainInsurePersonNumber(lcGrpContTemp.getMainInsurePersonNumber());
			lcGrpCont.setRelatedInsurePersonNumber(lcGrpContTemp.getRelatedInsurePersonNumber());
			lcGrpCont.setRate(lcGrpContTemp.getRate());
			//设置最后一个修改日期
			lcGrpCont.setModifyDate(new Date());
			lcGrpCont.setModifyTime(DateUtil.getTime());
			this.save(lcGrpCont);
			lcGrpContGroupVo.setLcGrpCont(lcGrpCont);
			/** 保存集体保单的部分信息--结束 */
			/**保存团体客户信息--开始*/
			ldGrpTemp.setCustomerNo(lcGrpCont.getAppntNo());//客户号(从集体保单类获得)
			ldGrpTemp.setMakeDate(new Date());//入机时间
			ldGrpTemp.setMakeTime(DateUtil.getTime());
			ldGrpTemp.setModifyDate(new Date());//修改时间
			ldGrpTemp.setModifyTime(DateUtil.getTime());
			ldGrpTemp.setOperator(user.getUserCode());//当前操作员
			this.save(ldGrpTemp);
			lcGrpContGroupVo.setLdGrp(ldGrpTemp);
			/**保存团体客户信息--结束*/
			/**保存团单投保人信息－－开始*/
			lcGrpAppntTemp.setGrpContNo(lcGrpCont.getGrpContNo());//集体合同号
			lcGrpAppntTemp.setCustomerNo(lcGrpCont.getAppntNo());//客户号
			lcGrpAppntTemp.setPrtNo(lcGrpCont.getGrpContNo());//印刷号
			//TODO 徐新玲 地址号码有表时，要加判断。
			lcGrpAppntTemp.setAddressNo(lcGrpCont.getGrpContNo());//地址号码
			lcGrpAppntTemp.setName(lcGrpCont.getGrpName());//单位名称
			lcGrpAppntTemp.setMakeDate(new Date());//入机时间
			lcGrpAppntTemp.setMakeTime(DateUtil.getTime());
			lcGrpAppntTemp.setModifyDate(new Date());//修改时间
			lcGrpAppntTemp.setModifyTime(DateUtil.getTime());
			lcGrpAppntTemp.setOperator(user.getUserCode());//操作员
			this.save(lcGrpAppntTemp);
			lcGrpContGroupVo.setLcGrpAppnt(lcGrpAppntTemp);
			/**保存团单投保人信息－－结束*/
			/**保存明细表信息－－开始*/
			lcGrpRepInfoDetailTemp.setGrpContNo(lcGrpCont.getGrpContNo());//集合合同号
			lcGrpRepInfoDetailTemp.setPrtNo(lcGrpCont.getGrpContNo());//印刷号
			lcGrpRepInfoDetailTemp.setMakeDate(new Date());//入时时间
			lcGrpRepInfoDetailTemp.setMakeTime(DateUtil.getTime());
			lcGrpRepInfoDetailTemp.setModifyDate(new Date());//修改时间
			lcGrpRepInfoDetailTemp.setModifyTime(DateUtil.getTime());
			lcGrpRepInfoDetailTemp.setOperator(user.getUserCode());//操作员
			this.save(lcGrpRepInfoDetailTemp);
			lcGrpContGroupVo.setLcGrpRepInfoDetail(lcGrpRepInfoDetailTemp);
			/**保存明细表信息－－结束*/
			/**保存告知单信息－－开始*/
			if(null!=lcRepInfoListTemp&&lcRepInfoListTemp.size()>0){
				for (int i = 0; i < lcRepInfoListTemp.size(); i++) {
					lcRepInfoListTemp.get(i).getId().setGrpContNo(lcGrpCont.getGrpContNo());// 集体合同号
					lcRepInfoListTemp.get(i).getId().setSubSerialNo(i+1);//内部流水号
					lcRepInfoListTemp.get(i).setPrtNo(lcGrpCont.getGrpContNo());//印刷号码
					lcRepInfoListTemp.get(i).setMakeDate(new Date());//入机时间
					lcRepInfoListTemp.get(i).setMakeTime(DateUtil.getTime());
					lcRepInfoListTemp.get(i).setModifyDate(new Date());//修改时间
					lcRepInfoListTemp.get(i).setModifyTime(DateUtil.getTime());
					lcRepInfoListTemp.get(i).setOperator(user.getUserCode());//操作员
				}
				this.saveAll(lcRepInfoListTemp);
				lcGrpContGroupVo.setLcRepInfoList(lcRepInfoListTemp);
			}
			/**保存告知单信息－－结束*/
		}
		else//修改页面信息
		{//有客户号，修改页面信息。
			/** 修改集体保单的部分信息--开始 */
			//根据[集体保单号]保存[集体保单信息]
			lcGrpCont.setReportNo(lcGrpContTemp.getReportNo().trim());
			lcGrpCont.setFirstTrialDate(lcGrpContTemp.getFirstTrialDate());
			lcGrpCont.setCvaliDate(lcGrpContTemp.getCvaliDate());
			lcGrpCont.setCregistNo(lcGrpContTemp.getCregistNo().trim());
			lcGrpCont.setManageCom(lcGrpContTemp.getManageCom().trim());
			lcGrpCont.setGrpSellType(lcGrpContTemp.getGrpSellType().trim());
			lcGrpCont.setConferNo(lcGrpContTemp.getConferNo().trim());
			//TODO:单位名称问题
			lcGrpCont.setCorporation(lcGrpContTemp.getCorporation().trim());
			lcGrpCont.setCorporationIDType(lcGrpContTemp.getCorporationIDType().trim());
			lcGrpCont.setCorporationIDNo(lcGrpContTemp.getCorporationIDNo().trim());
			lcGrpCont.setCorporationsDate(lcGrpContTemp.getCorporationsDate());
			lcGrpCont.setGrpPeoples(lcGrpContTemp.getGrpPeoples());
			lcGrpCont.setMainInsurePersonNumber(lcGrpContTemp.getMainInsurePersonNumber());
			lcGrpCont.setRelatedInsurePersonNumber(lcGrpContTemp.getRelatedInsurePersonNumber());
			lcGrpCont.setRate(lcGrpContTemp.getRate());
			//设置最后一个修改日期
			lcGrpCont.setModifyDate(new Date());
			lcGrpCont.setModifyTime(DateUtil.getTime());
			this.update(lcGrpCont);
			lcGrpContGroupVo.setLcGrpCont(lcGrpCont);
			/** 修改集体保单的部分信息--结束 */
			/**修改团体客户信息--开始*/
			//通过保单合同号查询 团体客户信息类
			queryRule=QueryRule.getInstance();
			queryRule.addEqual("customerNo",lcGrpCont.getAppntNo());
			LDGrp ldGrp = this.findUnique(LDGrp.class,queryRule);
			
			ldGrp.setGrpName(ldGrpTemp.getGrpName());//投保单位名称
			ldGrp.setBusinessType(ldGrpTemp.getBusinessType());//行业类别
			ldGrp.setOrganizationNo(ldGrpTemp.getOrganizationNo());//组织机构代码
			ldGrp.setAsset(ldGrpTemp.getAsset());//资产总额（万元）
			ldGrp.setTaxRegistNo(ldGrpTemp.getTaxRegistNo());//税务登记证号
			ldGrp.setYearGrossIncome(ldGrpTemp.getYearGrossIncome());//年总收入（万元）
			ldGrp.setGrpNature(ldGrpTemp.getGrpNature());//单位性质
			ldGrp.setFoundDate(ldGrpTemp.getFoundDate());//成立日期
			ldGrp.setOperateArea(ldGrpTemp.getOperateArea());//经营区域
			ldGrp.setMainBussiness(ldGrpTemp.getMainBussiness());//主营业务
			ldGrp.setGrpPeoples(ldGrpTemp.getGrpPeoples());//单位总人数
			ldGrp.setModifyDate(new Date());//修改时间
			ldGrp.setModifyTime(DateUtil.getTime());
			ldGrp.setOperator(user.getUserCode());//当前操作员
			this.update(ldGrp);
			lcGrpContGroupVo.setLdGrp(ldGrp);
			/**修改团体客户信息--结束*/
			/**修改团单投保人信息--开始*/
			//通过保单号查询 团单投保人信息类
			queryRule=QueryRule.getInstance();
			queryRule.addEqual("grpContNo",lcGrpCont.getGrpContNo());
			LCGrpAppnt lcGrpAppnt = this.findUnique(LCGrpAppnt.class,
					queryRule);
			lcGrpAppnt.setSocietyStat(lcGrpAppntTemp.getSocietyStat());//是否已参加社会统筹
			lcGrpAppnt.setSocietyRegistNo(lcGrpAppntTemp.getSocietyRegistNo());//社保登记证号
			lcGrpAppnt.setPostalAddress(lcGrpAppntTemp.getPostalAddress());//联系地址
			lcGrpAppnt.setZipCode(lcGrpAppntTemp.getZipCode());//联系邮编
			lcGrpAppnt.setPhone(lcGrpAppntTemp.getPhone());//联系电话
			lcGrpAppnt.setDepartment(lcGrpAppntTemp.getDepartment());//联系部门
			lcGrpAppnt.setName1(lcGrpAppntTemp.getName1());//联系人
			lcGrpAppnt.setSex1(lcGrpAppntTemp.getSex1());//联系人性别
			lcGrpAppnt.setTelphone1(lcGrpAppntTemp.getTelphone1());//联系人电话
			lcGrpAppnt.setPhone1(lcGrpAppntTemp.getPhone1());//手机
			lcGrpAppnt.setEmail(lcGrpAppntTemp.getEmail());//E-MAIL
			lcGrpAppnt.setModifyDate(new Date());//修改时间
			lcGrpAppnt.setModifyTime(DateUtil.getTime());
			lcGrpAppnt.setOperator(user.getUserCode());//当前操作员
			this.update(lcGrpAppnt);
			lcGrpContGroupVo.setLcGrpAppnt(lcGrpAppnt);
			/**修改团单投保人信息--结束*/
			/**修改告知单信息－－开始*/
			//通过保单号查询投保单告知信息类
			queryRule=QueryRule.getInstance();
			queryRule.addEqual("id.grpContNo",lcGrpCont.getGrpContNo());
			@SuppressWarnings("unchecked")
			List<LCGrpRepInfo> lcRepInfoList =(List<LCGrpRepInfo>)this.find(LCGrpRepInfo.class,
					queryRule);
			if(null!=lcRepInfoListTemp&&lcRepInfoListTemp.size()>0){
				for (int i = 0; i < lcRepInfoListTemp.size(); i++) {
					lcRepInfoListTemp.get(i).getId()
							.setGrpContNo(lcGrpCont.getGrpContNo());// 集体合同号
					lcRepInfoListTemp.get(i).getId()
							.setSubSerialNo(i + 1);// 内部流水号
					lcRepInfoListTemp.get(i).setPrtNo(lcGrpCont.getGrpContNo());// 印刷号码
					lcRepInfoListTemp.get(i).setMakeDate(
							lcGrpCont.getMakeDate());// 入机时间
					lcRepInfoListTemp.get(i).setMakeTime(
							lcGrpCont.getMakeTime());
					lcRepInfoListTemp.get(i).setModifyDate(new Date());// 修改时间
					lcRepInfoListTemp.get(i).setModifyTime(DateUtil.getTime());
					lcRepInfoListTemp.get(i).setOperator(user.getUserCode());// 操作员
				}
				if (null != lcRepInfoList && lcRepInfoList.size() > 0) {
					for (int i = 0; i < lcRepInfoList.size(); i++) {
						this.delete(lcRepInfoList.get(i));
					}
				}
				this.flush();//缓存与数据库同步
				this.saveAll(lcRepInfoListTemp);
				lcGrpContGroupVo.setLcRepInfoList(lcRepInfoListTemp);
			}
			/**修改告知单信息－－结束*/
			/**修改告知单明细信息－－开始*/
			//通过保单号查询告知单明细类
			queryRule=QueryRule.getInstance();
			queryRule.addEqual("grpContNo",lcGrpCont.getGrpContNo());
			LCGrpRepInfoDetail lcGrpRepInfoDetail = this.findUnique(LCGrpRepInfoDetail.class,
					queryRule);
			lcGrpRepInfoDetail.setCompetitionStatus(lcGrpRepInfoDetailTemp.getCompetitionStatus());//同行业竞争状况
			lcGrpRepInfoDetail.setInsurStatus(lcGrpRepInfoDetailTemp.getInsurStatus());//被保险人状况
			lcGrpRepInfoDetail.setClmHistory(lcGrpRepInfoDetailTemp.getClmHistory());//既往理赔史
			lcGrpRepInfoDetail.setConStatusAndServ(lcGrpRepInfoDetailTemp.getConStatusAndServ());//保单相关情况及服务要求
			lcGrpRepInfoDetail.setModifyDate(new Date());//修改时间
			lcGrpRepInfoDetail.setModifyTime(DateUtil.getTime());
			lcGrpRepInfoDetail.setOperator(user.getUserCode());//操作员
			this.save(lcGrpRepInfoDetail);
			lcGrpContGroupVo.setLcGrpRepInfoDetail(lcGrpRepInfoDetail);
			/**修改告知单明细信息－－结束*/
		}
		return lcGrpContGroupVo;
	}
	
	/*
	 * 
	 * @title findCustomerInfoByCondition
	 * @author xu_xinling
	 * @see ins.prpall.report.service.facade.NoImageInputService#findCustomerInfoByCondition(ins.prpall.report.model.LDGrp)
	 */
	@Override
	public Page findCustomerInfoByCondition(LDGrp ldGrp, int pageNo,
			int pageSize) {
		StringBuffer hql=new StringBuffer();
		hql.append("from LDGrp ldGrp where 1=1 ");
		if(null!=ldGrp){
			//客户号不为空
			if(null!=ldGrp.getCustomerNo()&&!"".equals(ldGrp.getCustomerNo())){
				hql.append(" and ldGrp.customerNo ='"+ldGrp.getCustomerNo()+"'");
			}
			//如果单位名称不为空；
			if(null!=ldGrp.getGrpName()&&!"".equals(ldGrp.getGrpName())){
				hql.append(" and ldGrp.grpName like '%"+ldGrp.getGrpName()+"%'");
			}
			//如果单位性质不为空；
			if(null!=ldGrp.getGrpNature()&&!"".equals(ldGrp.getGrpNature())){
				hql.append(" and ldGrp.grpNature like '%"+ldGrp.getGrpNature()+"'%");
			}
		}
		return this.findByHql(hql.toString(), pageNo, pageSize, null);
	}
	
	/*
	 * 
	 * @title findClertInfoByCustomerNo
	 * @author xu_xinling
	 * @see ins.prpall.report.service.facade.NoImageInputService#findClertInfoByCustomerNo(ins.prpall.report.model.LDGrp, java.lang.String)
	 */
	@Override
	public LDGrp findClertInfoByCustomerNo(String customerNo
			) {
		QueryRule queryRule=null;
		//根据客户号,查询客户信息
		queryRule=QueryRule.getInstance();
		queryRule.addEqual("customerNo", customerNo);
		LDGrp newldGrp= this.findUnique(LDGrp.class, queryRule);
		return newldGrp;
	}
	
	/*
	 * 
	 * @title saveGrpRiskInfo
	 * @author xu_xinling
	 * @see ins.prpall.report.service.facade.NoImageInputService#saveGrpRiskInfo(ins.prpall.report.model.LCGrpPol, java.util.List)
	 */
	@Override
	public Boolean saveGrpRiskInfo(String grpContNo,LCGrpPol lcGrpPol,
			List<LCGrpPolVo> lcGrpPolVoList) {
		//获得当前操作员
		ActionContext ac = ActionContext.getContext();
		PrpDuser user = (PrpDuser)ac.getSession().get("user");
		//获得当前管理机构
		String currentComCode=(String)ac.getSession().get("comCode");
		LCGrpPol lcGrpPolTemp=new LCGrpPol();
		
		if(null!=lcGrpPol){
			//通过险种编码查询险种名称
			QueryRule queryRule = QueryRule.getInstance();
			queryRule.addEqual("riskCode", lcGrpPol.getRiskCode());
			PDLMRisk pdlmRisk = this.findUnique(PDLMRisk.class, queryRule);
			
			//险种号自动取得
			//TODO： 自动取得没有成功
			lcGrpPol.setGrpPolNo(serialNoUtil.serialNo("LCGRPPOL",currentComCode,"GRPPOLNO"));
			lcGrpPol.setGrpContNo(grpContNo);
			//TODO:集体投保单险种号码 ？
			lcGrpPol.setGrpProposalNo(pdlmRisk.getRiskCode());
			lcGrpPol.setRiskVersion(pdlmRisk.getRiskVer());
			//主险编码
			
			lcGrpPol.setPrem(new BigDecimal(0));
			lcGrpPol.setAmnt(new BigDecimal(0));
			lcGrpPol.setOperator(user.getUserCode());
			lcGrpPol.setMakeDate(new Date());
			lcGrpPol.setMakeTime(DateUtil.getTime());
			lcGrpPol.setModifyDate(new Date());
			lcGrpPol.setModifyTime(DateUtil.getTime());
			
			this.save(lcGrpPol);
		}
		if(null!=lcGrpPolVoList){
			for(LCGrpPolVo l:lcGrpPolVoList){
				lcGrpPolTemp.setGrpContNo(grpContNo);
				lcGrpPolTemp.setGrpPolNo(serialNoUtil.serialNo("LCGrpPol",currentComCode,"GRPPOLNO"));
				lcGrpPolTemp.setRiskCode(l.getRiskCode());
				
				QueryRule queryRule = QueryRule.getInstance();
				queryRule.addEqual("riskCode", l.getRiskCode());
				PDLMRisk pdlmRisk = this.findUnique(PDLMRisk.class, queryRule);
				
				//TODO:集体投保单险种号码 ？
				lcGrpPolTemp.setGrpProposalNo(pdlmRisk.getRiskCode());
				lcGrpPolTemp.setRiskVersion(pdlmRisk.getRiskVer());
				lcGrpPolTemp.setPrem(l.getPrem());
				lcGrpPolTemp.setAmnt(l.getAmnt());
				lcGrpPolTemp.setOperator(user.getUserCode());
				//TODO:日期问题：
				lcGrpPolTemp.setMakeDate(new Date());
				lcGrpPolTemp.setMakeTime(DateUtil.getTime());
				lcGrpPolTemp.setModifyDate(new Date());
				lcGrpPolTemp.setModifyTime(DateUtil.getTime());
				this.save(lcGrpPolTemp);
			}
		}
		return true;
	}
	/*
	 * 
	 * @title findGrpRiskInfoByGrpContNo
	 * @author xu_xinling
	 * @see ins.prpall.report.service.facade.NoImageInputService#findGrpRiskInfoByGrpContNo(java.lang.String)
	 */
	
	@Override
	public List<LCGrpPolVo> findGrpRiskInfoByGrpContNo(String grpContNo) {
		StringBuffer lcGrpPolByhql=new StringBuffer();
		//查询条件只有保单号
		lcGrpPolByhql.append("select new ins.prpall.proposal.vo.LCGrpPolVo(l.grpPolNo,l.riskCode,p.riskName,l.prem,l.amnt,l.amnt) from LCGrpPol l,PDLMRisk p where l.riskCode=p.riskCode " +
				"and l.grpContNo='"+grpContNo+"'" );
		return (List<LCGrpPolVo>)this.findByHql(lcGrpPolByhql.toString(), null);
	}
	/*
	 * 
	 * @title updateGrpInfoByGrpContNo
	 * @author xu_xinling
	 * @see ins.prpall.report.service.facade.NoImageInputService#updateGrpInfoByGrpContNo(java.lang.String)
	 */
	@Override
	public  LCGrpCont  updateGrpInfoByGrpContNo(String grpContNo,String stateFlag) {
		//查询出投保单信息
		QueryRule queryRule=QueryRule.getInstance();
		queryRule.addEqual("grpContNo", grpContNo);
		LCGrpCont lcGrpCont= this.findUnique(queryRule);
		
		if(stateFlag.equals(FinalCollection.CONT_STATE3)){//保单录入状态。
			lcGrpCont.setState(FinalCollection.CONT_STATE3);
		}
		if(stateFlag.equals(FinalCollection.CONT_STATE4)){//将状态改为待复核状态。
			lcGrpCont.setState(FinalCollection.CONT_STATE4);
		}
		//this.update(lcGrpCont);
		return lcGrpCont;
	}
	/*
	 * 
	 * @title deleteGrpInfoByGrpContNo
	 * @author xu_xinling
	 * @see ins.prpall.report.service.facade.NoImageInputService#deleteGrpInfoByGrpContNo(ins.prpall.report.model.LCGrpPol)
	 */
	@Override
	public LCGrpPol deleteGrpInfoByGrpContNo(LCGrpPol lcGrpPol) {
		this.delete(lcGrpPol);
		return lcGrpPol;
	}
	/*
	 * 
	 * @title findSubRiskIsOr
	 * @author xu_xinling
	 * @see ins.prpall.proposal.service.facade.NoImageInputService#findSubRiskIsOr(ins.prpall.report.model.LCGrpPol)
	 */
	@Override
	public String findSubRiskIsOr(LCGrpPol lcGrpPol) {
		QueryRule queryRule=null;
		String isOrSub="";//是否是险加险
		String subRiskFlag="S";//数据表中附加险标记
		queryRule=QueryRule.getInstance();
		queryRule.addEqual("riskCode", lcGrpPol.getRiskCode());
		queryRule.addEqual("subRiskFlag", subRiskFlag);
		@SuppressWarnings("unchecked")
		List<PDLMRiskApp> list=this.find(PDLMRiskApp.class, queryRule);
		if(null!=list&&list.size()>0){
			isOrSub="Y";
		}
		else{
			isOrSub="N";
		}
		return isOrSub;
	}
	/*
	 * 
	 * @title findMRiskBySRisk
	 * @author xu_xinling
	 * @see ins.prpall.proposal.service.facade.NoImageInputService#findMRiskBySRisk(ins.prpall.report.model.LCGrpPol)
	 */
	@Override
	public List<QueryCodeVo> findMRiskBySRisk(LCGrpPol lcGrpPol,LCGrpCont lcGrpCont) {
		//TODO:徐新玲  险种之间的关系 没有附主关系
		String relaCode="04";//01-主附,02-主主,03-产品组合,	04-附附
		List<String> strList=new ArrayList<String>();//获得险种编码
		List<LCGrpPolVo> lcGrpPolList=this.findGrpRiskInfoByGrpContNo(lcGrpCont.getGrpContNo());//根据保单合同号查询出添加的险种信息
		for(LCGrpPolVo ls:lcGrpPolList){
			strList.add(ls.getRiskCode());
		}
		//查询出附加险　对应该保单已经有的主险；
		//TODO in后面参数：主附险都查出来了。
		StringBuffer lcMainRiskHql = new StringBuffer();
		lcMainRiskHql.append( "select new ins.platform.vo.QueryCodeVo(rr.id.relaRiskCode, r.riskName) " +
				"from PDLMRiskRela rr  ,PDLMRisk r where rr.id.riskCode = r.riskCode and rr.id.relaCode='"+relaCode+"' " +
						"and rr.id.riskCode = '"+lcGrpPol.getRiskCode()+"' and rr.id.relaRiskCode in (?)");
		
		List<QueryCodeVo> relateList=this.findByHql(lcMainRiskHql.toString(), new Object[]{strList});
		return relateList;
	}
	/*
	 * 
	 * @title findLcGrpContByGrpContNO
	 * @author xu_xinling
	 * @see ins.prpall.proposal.service.facade.NoImageInputService#findLcGrpContByGrpContNO(java.lang.String)
	 */
	@Override
	public LCGrpCont findLcGrpContByGrpContNO(String grpContNo) {
		QueryRule queryRule=QueryRule.getInstance();
		queryRule.addEqual("grpContNo", grpContNo);
		return this.findUnique(queryRule);
	}
	/*
	 * 
	 * @title findClertInfoByName
	 * @author xu_xinling
	 * @see ins.prpall.proposal.service.facade.NoImageInputService#findClertInfoByName(java.lang.String)
	 */
	@Override
	public LDGrp findClertInfoByName(String grpName) {
		QueryRule queryRule=QueryRule.getInstance();
		queryRule.addEqual("grpName", grpName);
		return this.findUnique(LDGrp.class, queryRule);
	}
	
}
