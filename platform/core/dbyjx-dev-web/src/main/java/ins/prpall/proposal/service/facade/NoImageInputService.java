package ins.prpall.proposal.service.facade;

import ins.framework.common.Page;
import ins.platform.vo.QueryCodeVo;
import ins.prpall.proposal.model.LCBnf;
import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.model.LCInsured;
import ins.prpall.proposal.model.LCRepInfo;
import ins.prpall.proposal.model.LDGrp;
import ins.prpall.proposal.vo.LCGrpPolVo;
import ins.prpall.proposal.vo.LcGrpContGroupVo;
import ins.prpall.proposal.vo.NoImageInputInitVo;
import ins.prpall.report.model.LCGrpPol;

import java.util.List;
import java.util.Map;
/**
 * 
 * @title NoImageInputService
 * @description 无影像录入Service接口层
 * @author xu_xinling
 * @version 
 * @create date 2012-8-6
 * @copyright (c) 
 *
 */
public interface NoImageInputService {
	
	/**
	 * 
	 * @title findGrpContInfo
	 * @description 根据条件查询[投保单]信息
	 * @author xu_xinling
	 * @create date 2012-8-6
	 * @param lcGrpCont 集体投保单对象
	 * @param pageNo 当前页
	 * @param pageSize 每页条数
	 * @return 投保单信息结果集
	 */
	Page findGrpContInfo(LCGrpCont lcGrpCont, int pageNo, int pageSize);
	/**
	 * 
	 * @title findCustomerInfoByCondition
	 * @description 通过多条件查询客户信息
	 * @author xu_xinling
	 * @create date 2012-8-13
	 * @param ldGrp
	 * @return
	 */
	Page findCustomerInfoByCondition(LDGrp ldGrp, int pageNo, int pageSize);
	
	/**
	 * 
	 * @title findClertInfoByCustomerNo
	 * @description 根据客户号查询单位信息
	 * @author xu_xinling
	 * @create date 2012-8-13
	 * @param ldGrp
	 * @param grpContNoHidden
	 * @return
	 */
	LDGrp findClertInfoByCustomerNo(String customerNO);
	
	/**
	 * 
	 * @title findClertInfoByName
	 * @description 通过单位名称查询单位信息
	 * @author xu_xinling
	 * @create date 2012-8-24
	 * @param grpName
	 * @return
	 */
	LDGrp findClertInfoByName(String grpName);
	/**
	 * 
	 * @title findGrpContDetailInfo
	 * @description 根据投保单号查询该保单详细信息
	 * @author xu_xinling
	 * @create date 2012-8-6
	 * @param lcGrpCont 集体投保单对象
	 * @return 一条集体投保单信息
	 */
	LcGrpContGroupVo findGrpContDetailInfo(LCGrpCont lcGrpCont);
	
	/**
	 * 
	 * @title saveGrpBaseInfo
	 * @description 保存页面信息，包括：集体保单信息，呈报团体客户信息，呈报团单投保人信息，投保告知单信息
	 * @author xu_xinling
	 * @create date 2012-8-8
	 * @param lcGrpContGroupVo
	 * @return 组合类（部分表中的部分信息，用于保存险种信息的。）
	 */
	LcGrpContGroupVo saveGrpBaseInfo(LcGrpContGroupVo lcGrpContGroupVo);
	
	/**
	 * 
	 * @title findSubRiskIsOr
	 * @description 判断是否附加险
	 * @author xu_xinling
	 * @create date 2012-8-21
	 * @param lcGrpPol
	 * @return
	 */
	String findSubRiskIsOr(LCGrpPol lcGrpPol);
	/**
	 * 
	 * @title findMRiskBySRisk
	 * @description 通过附加险查询主险
	 * @author xu_xinling
	 * @create date 2012-8-21
	 * @param lcGrpPol
	 * @return
	 */
	List<QueryCodeVo> findMRiskBySRisk(LCGrpPol lcGrpPol,LCGrpCont lcGrpCont);
	/**
	 * 
	 * @title findLcGrpContByGrpContNO
	 * @description 通过保单合同号查询保单信息
	 * @author xu_xinling
	 * @create date 2012-8-24
	 * @param grpContNo
	 * @return
	 */
	LCGrpCont findLcGrpContByGrpContNO(String grpContNo);
	/**
	 * 
	 * @title saveGrpRiskInfo
	 * @description 保存信息
	 * @author xu_xinling
	 * @create date 2012-8-16
	 * @param lcGrpPol
	 * @param lcGrpPolVoList
	 */
	Boolean saveGrpRiskInfo(String grpContNo,LCGrpPol lcGrpPol,List<LCGrpPolVo>  lcGrpPolVoList);
	
	/**
	 * 
	 * @title findGrpRiskInfoByGrpContNo
	 * @description 通过保单合同号查询集体险种信息
	 * @author xu_xinling
	 * @create date 2012-8-16
	 * @param grpContNo
	 * @return
	 */
	List<LCGrpPolVo> findGrpRiskInfoByGrpContNo(String grpContNo);
	/**
	 * 
	 * @title modifyGrpInfoByGrpContNo
	 * @description 通过保单合同号修改集体保单状态
	 * @author xu_xinling
	 * @create date 2012-8-16
	 * @param grpContNo 保单合同号
	 * @param stateFlag 状态标记
	 * @return
	 */
	LCGrpCont  updateGrpInfoByGrpContNo(String grpContNo,String stateFlag);
	/**
	 * 
	 * @title deleteGrpInfoByGrpContNo
	 * @description 通过集体保单险种号码删除险种信息
	 * @author xu_xinling
	 * @create date 2012-8-17
	 * @return
	 */
	LCGrpPol deleteGrpInfoByGrpContNo(LCGrpPol lcGrpPol);
	
	/**
	 *告知单、受益人、被保险人信息保存
	 *@param lcInsured 被保险人信息
	 *@param lcRepInfoList 告知单信息List
	 *@param lcBnfList 受益人信息List
	 *@author 于文龙
	 */
	Map<String,Object> saveAllInfo(LCInsured lcInsured,List<LCRepInfo> lcRepInfoList,List<LCBnf> lcBnfList);
	
	/**
	 * 查询被保险人信息
	 * @param lcInsured 被保险人信息表
	 * @author 
	 */
	Page findInsuredInfo(LCInsured lcInsured);
}
