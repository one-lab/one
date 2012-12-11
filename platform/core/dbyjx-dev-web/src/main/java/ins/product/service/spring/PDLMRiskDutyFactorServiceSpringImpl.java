package ins.product.service.spring;

import com.sinosoft.one.mvc.web.Invocation;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.model.PrpDuser;
import ins.platform.vo.QueryCodeVo;
import ins.product.model.PDLMRiskDutyFactor;
import ins.product.model.PDLMRiskDutyFactorId;
import ins.product.model.PDScheRateCalFactorLib;
import ins.product.service.facade.PDLMRiskDutyFactorService;
import ins.product.service.facade.PDScheRateCalFactorLibService;
import ins.product.vo.ToRiskDutyFactorVo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
/**
 * 
 * @title PDLMRiskDutyFactorServiceSpringImpl
 * @description 专门针对表PDLMRiskDutyFactor进行操作的service类
 * @author 朱超
 * @version 1.0
 * @copyright (c) SINOSOFT
 *
 */
public class PDLMRiskDutyFactorServiceSpringImpl extends
		GenericDaoHibernate<PDLMRiskDutyFactor, PDLMRiskDutyFactorId> implements
		PDLMRiskDutyFactorService {
	private PDScheRateCalFactorLibService pdScheRateCalFactorLibService;
	public PDScheRateCalFactorLibService getPdScheRateCalFactorLibService() {
		return pdScheRateCalFactorLibService;
	}
	public void setPdScheRateCalFactorLibService(
			PDScheRateCalFactorLibService pdScheRateCalFactorLibService) {
		this.pdScheRateCalFactorLibService = pdScheRateCalFactorLibService;
	}
	
	/**
	 * 增加险种责任要素记录(组合要素)，返回值为保存的记录，因为页面需要用到这些记录
	 * @param pdLmRiskDutyFactorList
	 * @return
	 */
	@Override
	public List<PDLMRiskDutyFactor> addRiskDutyFactor(
			List<PDLMRiskDutyFactor> pdLmRiskDutyFactorList, Invocation invocation) {
		//构造calSql字段内容。如果是组合要素那么保持两个要素的id
		StringBuffer calSql = new StringBuffer();
		StringBuffer calName = new StringBuffer();
		for(int i = 0 ; i < pdLmRiskDutyFactorList.size() ; i++){
			calSql.append(pdLmRiskDutyFactorList.get(i).getId().getCalFactor());
			calSql.append(";");
		}
		calSql.deleteCharAt(calSql.length()-1);
		for(int i = 0 ; i < pdLmRiskDutyFactorList.size() ; i++){
			PDLMRiskDutyFactor temp = pdLmRiskDutyFactorList.get(i);
			PDScheRateCalFactorLib factor = pdScheRateCalFactorLibService.findScheRateCalFactorByFactorCode(temp.getId().getCalFactor());
			//FactorDataType--1:字符;2:整形;3:数值  | CalFactorType--1 直接值  2 算法计算结果值
			temp.setCalFactorType("1".equals(factor.getFactorDataType()) ? "2" : "1");
			temp.setFactorName(factor.getFactorName());
			temp.setChooseFlag("0");
			temp.setFactorOrder(factor.getStandbyflag3());
			//TODO 保存缴费编码和给付编码
			temp.setMakeDate(new Date());
			temp.setMakeTime(DateUtil.getTime());
			temp.setModifyDate(new Date());
			temp.setModifyTime(DateUtil.getTime());
			PrpDuser user = (PrpDuser)invocation.getRequest().getSession().getAttribute("user");
			temp.setOperator(user.getUserCode());
			temp.setCalSQL(calSql.toString());
			temp.setDhtmlType(factor.getDhtmlType());
			temp.setComFactorCode(calSql.toString());
			//方便后面取名字
			calName.append("("+factor.getFactorName()+")");
		}
		for(int i = 0 ; i < pdLmRiskDutyFactorList.size() ; i++){
			PDLMRiskDutyFactor temp = pdLmRiskDutyFactorList.get(i);
			temp.setComFactorName(calName.toString());
		}
		this.saveAll(pdLmRiskDutyFactorList);
		return pdLmRiskDutyFactorList;
	}
	
	/**
	 * 根据riskCode和dutyCode得到险种责任要素
	 * @param riskCode
	 * @param dutyCode
	 * @return
	 */
	@Override
	public List<PDLMRiskDutyFactor> findFactorByRiskAndDuty(String riskCode,
			String dutyCode) {
		QueryRule qr = QueryRule.getInstance();
		qr.addEqual("id.riskCode", riskCode);
		qr.addEqual("id.dutyCode", dutyCode);
		qr.addAscOrder("factorOrder");
		//factor.id.riskCode , factor.id.dutyCode,factor.id.calFactor,factor.factorName,
		
		List<PDLMRiskDutyFactor> resultFactor = this.find(qr);
		
		return resultFactor;
	}
	/**
	 * 增加险种责任要素记录(单要素)，返回值为保存的记录，因为页面需要用到这些记录
	 * @param pdLMRiskDutyFactor
	 * @return
	 */
	@Override
	public PDLMRiskDutyFactor addRiskDutyFactor(
			PDLMRiskDutyFactor pdLMRiskDutyFactor, Invocation invocation) {
		PDLMRiskDutyFactor temp = pdLMRiskDutyFactor;
		PDScheRateCalFactorLib factor = pdScheRateCalFactorLibService.findScheRateCalFactorByFactorCode(temp.getId().getCalFactor());
		//FactorDataType--1:字符;2:整形;3:数值  | CalFactorType--1 直接值  2 算法计算结果值
		temp.setCalFactorType("1".equals(factor.getFactorDataType()) ? "2" : "1");
		temp.setFactorName(factor.getFactorName());
		temp.setChooseFlag("0");
		temp.setFactorOrder(factor.getStandbyflag3());
		//TODO 保存缴费编码和给付编码
		temp.setMakeDate(new Date());
		temp.setMakeTime(DateUtil.getTime());
		temp.setModifyDate(new Date());
		temp.setModifyTime(DateUtil.getTime());
		PrpDuser user = (PrpDuser)invocation.getRequest().getSession().getAttribute("user");
		temp.setOperator(user.getUserCode());
		temp.setCalSQL(factor.getFactorCode());
		temp.setComFactorCode(factor.getFactorCode());
		temp.setComFactorName(factor.getFactorName());
		temp.setDhtmlType(factor.getDhtmlType());
		this.save(temp);
		return temp;
	}
	/**
	 * @title findFactorDistinct
	 * @description 根据险种和责任查询要素，并且使用distinct去重
	 * @author 朱超
	 * @param riskCode 险种编码
	 * @param dutyCode 责任编码
	 * @return 通用vo类
	 */
	@Override
	public List<QueryCodeVo> findFactorDistinct(String riskCode, String dutyCode) {
		String hql = "select distinct factor.calSQL, factor.comFactorName" +
			" from PDLMRiskDutyFactor factor where factor.id.riskCode = ? and factor.id.dutyCode = ? ";
		List<Object[]> list = this.findByHql(hql, riskCode,dutyCode);
		List<QueryCodeVo> queryCodeList = new ArrayList<QueryCodeVo>();
		for(Object[] temp : list){
			QueryCodeVo qcv = new QueryCodeVo();
			qcv.setCodeValue((String)temp[0]);
			qcv.setCodeLabel((String)temp[1]);
			queryCodeList.add(qcv);
		}
		return queryCodeList;
	}
	/**
	 * @title findByFactorCodes
	 * @description 通过主键ToRiskDutyFactorVo的list集合里面含有risk,duty,factor得到PDLMRiskDutyFactor
	 * @author 朱超
	 * @param factorCodes
	 * @return
	 */
	@Override
	public List<PDLMRiskDutyFactor> findByFactorCodes(
			List<ToRiskDutyFactorVo> toRiskDutyFactorVos) {
//		List<String>
		for(ToRiskDutyFactorVo vo : toRiskDutyFactorVos){
			
		}
		return null;
	}
	
}
