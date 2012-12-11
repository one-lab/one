package ins.product.service.spring;

import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.product.model.PDLMCalMode;
import ins.product.model.PDLMRiskDutyFactor;
import ins.product.model.PDLMRiskDutyRate;
import ins.product.model.PDLMRiskDutyRateValue;
import ins.product.service.facade.CreateMoneyService;
import ins.product.service.facade.PDLMRiskDutyFactorService;
import ins.product.service.facade.PDLMRiskDutyRateService;
import ins.product.service.facade.PDLMRiskDutyRateValueService;
import ins.product.vo.PDLMRiskDutyFactorValueVo;
import ins.product.vo.ToRiskDutyFactorVo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressWarnings("unchecked")
public class CreateMoneyServiceSpringImpl extends GenericDaoHibernate<PDLMCalMode, String> implements CreateMoneyService {
	
	private PDLMRiskDutyRateService pdlmRiskDutyRateService;
	private PDLMRiskDutyRateValueService pdlmRiskDutyRateValueService;
	private PDLMRiskDutyFactorService pdLmRiskDutyFactorService;
	
	public PDLMRiskDutyRateService getPdlmRiskDutyRateService() {
		return pdlmRiskDutyRateService;
	}

	public void setPdlmRiskDutyRateService(
			PDLMRiskDutyRateService pdlmRiskDutyRateService) {
		this.pdlmRiskDutyRateService = pdlmRiskDutyRateService;
	}

	public PDLMRiskDutyRateValueService getPdlmRiskDutyRateValueService() {
		return pdlmRiskDutyRateValueService;
	}

	public void setPdlmRiskDutyRateValueService(
			PDLMRiskDutyRateValueService pdlmRiskDutyRateValueService) {
		this.pdlmRiskDutyRateValueService = pdlmRiskDutyRateValueService;
	}

	public PDLMRiskDutyFactorService getPdLmRiskDutyFactorService() {
		return pdLmRiskDutyFactorService;
	}

	public void setPdLmRiskDutyFactorService(
			PDLMRiskDutyFactorService pdLmRiskDutyFactorService) {
		this.pdLmRiskDutyFactorService = pdLmRiskDutyFactorService;
	}

	/**
	 * @title createPremium(保费计算公式)
	 * @description 通过算法公式和传递进来的要素值得到保费
	 * @author 朱超
	 * @param pdlmCalModes 算法公式集合
	 * @param pdlmRiskDutyFactorValueVos 要素值集合
	 * @return 保费,如果出现内部错误返回：-1
	 */
	@Override
	public BigDecimal createPremium(List<PDLMCalMode> pdlmCalModes,
			List<PDLMRiskDutyFactorValueVo> pdlmRiskDutyFactorValueVos) {
		BigDecimal countPremium = new BigDecimal(0);
		/**
		 * 1.遍历list<vo>得到与某一个算法公式相切合的Map<String,List<PDLMRiskDutyFactorValueVo>> factorValuesByCalModes
		 */
		Map<String,List<PDLMRiskDutyFactorValueVo>> factorValuesByCalModes = new HashMap<String, List<PDLMRiskDutyFactorValueVo>>();
		for(PDLMCalMode pdlmCalMode : pdlmCalModes){
			List<PDLMRiskDutyFactorValueVo> vos = new ArrayList<PDLMRiskDutyFactorValueVo>();
			for(PDLMRiskDutyFactorValueVo pdlmRiskDutyFactorValueVo :pdlmRiskDutyFactorValueVos){
				if(pdlmCalMode.getCalCode().equals(pdlmRiskDutyFactorValueVo.getCalCode())){
					vos.add(pdlmRiskDutyFactorValueVo);
				}
			}
			factorValuesByCalModes.put(pdlmCalMode.getCalCode(), vos);
		}
		/**
		 * 2.计算每个算法公式对应的保费
		 */
		for(PDLMCalMode pdlmCalMode : pdlmCalModes){
			//factorValueByCalCode:当前公式中对应的要素值集合
			List<PDLMRiskDutyFactorValueVo> factorValueByCalCode = factorValuesByCalModes.get(pdlmCalMode.getCalCode());
			//factorValueMap:存放要素(单要素和组合要素)和费率的map<单要素/组合要素,费率/直接值>
			Map<String,BigDecimal> factorValueMap = new HashMap<String, BigDecimal>();
			/**
			 * 2.1.3遍历factorValueByCalCode，将组合要素整合在map<calSql,组合要素的集合>中--assemblageMap
			 */
			Map<String,List<PDLMRiskDutyFactorValueVo>> assemblageMap = new HashMap<String, List<PDLMRiskDutyFactorValueVo>>();
			for(PDLMRiskDutyFactorValueVo vo : factorValueByCalCode){
				if(vo.getCalSQL().indexOf(";") > 0){
					String[] assemblageTemp = vo.getCalSQL().split(";");
					List<PDLMRiskDutyFactorValueVo> assemblageList = new ArrayList<PDLMRiskDutyFactorValueVo>();
					for(String keyTemp : assemblageTemp){
						for(PDLMRiskDutyFactorValueVo temp : factorValueByCalCode){
							if(keyTemp.equals(temp.getCalFactor()) && vo.getCalSQL().equals(temp.getCalSQL())){
								assemblageList.add(temp);
							}
						}
					}
					assemblageMap.put(vo.getCalSQL(), assemblageList);
				}
			}
			/**
			 * 2.1通过factorValueByCalCode得到要素对应的费率
			 */
			for(PDLMRiskDutyFactorValueVo vo : factorValueByCalCode){
				/**
				 * 2.1.1判断是否是组合要素
				 */
				//是组合要素
				if(vo.getCalSQL().indexOf(";") > 0 && null == factorValueMap.get(vo.getCalSQL())){
					List<PDLMRiskDutyFactorValueVo> vos = assemblageMap.get(vo.getCalSQL());
					List<PDLMRiskDutyRate> pdlmRiskDutyRates = pdlmRiskDutyRateService.findSomeByFactorValueVo(vos);
					PDLMRiskDutyRateValue pdlmRiskDutyRateValue = pdlmRiskDutyRateValueService.findFactorValueByList(pdlmRiskDutyRates);
					factorValueMap.put(vo.getCalSQL(), pdlmRiskDutyRateValue.getFactorValue());
				}
				//不是组合要素
				else{
					/**
					 * 2.1.2判断是否是直接值：1 直接值      2 算法计算结果值
					 */
					if("2".equals(vo.getCalFactorType()) && null == factorValueMap.get(vo.getCalSQL())){
						PDLMRiskDutyRate pdlmRiskDutyRate = pdlmRiskDutyRateService.findOnlyOne(vo);
						PDLMRiskDutyRateValue pdlmRiskDutyRateValue = pdlmRiskDutyRateValueService.findOnlyOne(pdlmRiskDutyRate);
						factorValueMap.put(vo.getCalSQL(), pdlmRiskDutyRateValue.getFactorValue());
					}
					else if("1".equals(vo.getCalFactorType())){
						factorValueMap.put(vo.getCalSQL(), new BigDecimal(vo.getCalFactorValue()));
					}
				}
			}
			//匹配公式里面的值
			String[] caoZuoShu = pdlmCalMode.getCalSQL().split("[+,-,*,//]+");
			String tempString = pdlmCalMode.getCalSQL();
			//amt*age;sex*number+xiaofei
			for(String temp : caoZuoShu){
				tempString = tempString.replaceFirst(temp, factorValueMap.get(temp).toString());
			}
			String hql = "select "+tempString+" from LDSysVar ldSysVar where ldSysVar.sysVar='onerow' ";
			List<Object> preTemp = this.findByHql(hql, null);
			BigDecimal pre = new BigDecimal((Double)preTemp.get(0));
			countPremium = countPremium.add(pre);
		}
		return countPremium;
	}
	
	/**
	 * @title createPDLMRiskDutyFactorVoList
	 * @description 通过ToRiskDutyFactorVo的集合得到PDLMRiskDutyFactorValueVo的集合
	 * @author 朱超
	 * @param toRiskDutyFactorVos：ToRiskDutyFactorVo的集合
	 * @return
	 */
	@Override
	public List<PDLMRiskDutyFactorValueVo> createPDLMRiskDutyFactorVoList(
			List<ToRiskDutyFactorVo> toRiskDutyFactorVos) {
		List<PDLMRiskDutyFactor> pdlmRiskDutyFactors = pdLmRiskDutyFactorService.findByFactorCodes(toRiskDutyFactorVos);
		return null;
	}

}
