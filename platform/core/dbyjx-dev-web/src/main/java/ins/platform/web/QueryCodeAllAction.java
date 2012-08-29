package ins.platform.web;

import ins.claim.report.service.facade.LLHospitalService;
import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;
import ins.framework.web.Struts2Action;
import ins.platform.service.facade.PdLdCodeService;
import ins.platform.service.facade.PrpDcompanyService;
import ins.platform.service.facade.UserPowerService;
import ins.platform.vo.QueryCodeVo;
import ins.product.service.facade.PDLMRiskDutyFactorService;
import ins.product.service.facade.PDLMRiskRelaService;
import ins.product.service.facade.PdLmRiskService;
import ins.prpall.proposal.service.facade.NoImageInputService;
import ins.prpall.report.service.facade.LCContPlanRiskReportService;
import ins.prpall.report.service.facade.LCGrpPolReportService;
import ins.prpall.report.service.facade.PDLMDutyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
/**
 * 所有双击域都进到这里
 * @author Administrator
 *
 */
public class QueryCodeAllAction extends Struts2Action {

	private static final long serialVersionUID = 1L;
	//调用的方法类型
	private String methodType;
	//仅对pdLdCode有效
	private String codeType;
	//参数
	private String params;
	//各种service类
	private PrpDcompanyService prpDcompanyService;
	private UserPowerService userPowerService; 
	private PdLdCodeService pdLdCodeService;
	private PdLmRiskService pdLmRiskService;
	private PDLMRiskRelaService pdLmRiskRelaService;
	private LLHospitalService llHospitalService;
	private LCContPlanRiskReportService lcContPlanRiskReportService;
	private LCGrpPolReportService lcGrpPolReportService;
	private PDLMDutyService pdLmDutyService;
	private PDLMRiskDutyFactorService pdLmRiskDutyFactorService;
	public String getMethodType() {
		return methodType;
	}
	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public PrpDcompanyService getPrpDcompanyService() {
		return prpDcompanyService;
	}
	public void setPrpDcompanyService(PrpDcompanyService prpDcompanyService) {
		this.prpDcompanyService = prpDcompanyService;
	}
	public UserPowerService getUserPowerService() {
		return userPowerService;
	}
	public void setUserPowerService(UserPowerService userPowerService) {
		this.userPowerService = userPowerService;
	}
	public PdLdCodeService getPdLdCodeService() {
		return pdLdCodeService;
	}
	public void setPdLdCodeService(PdLdCodeService pdLdCodeService) {
		this.pdLdCodeService = pdLdCodeService;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public PdLmRiskService getPdLmRiskService() {
		return pdLmRiskService;
	}
	public void setPdLmRiskService(PdLmRiskService pdLmRiskService) {
		this.pdLmRiskService = pdLmRiskService;
	}
	public PDLMRiskRelaService getPdLmRiskRelaService() {
		return pdLmRiskRelaService;
	}
	public void setPdLmRiskRelaService(PDLMRiskRelaService pdLmRiskRelaService) {
		this.pdLmRiskRelaService = pdLmRiskRelaService;
	}
	public LCContPlanRiskReportService getLcContPlanRiskReportService() {
		return lcContPlanRiskReportService;
	}
	public void setLcContPlanRiskReportService(
			LCContPlanRiskReportService lcContPlanRiskReportService) {
		this.lcContPlanRiskReportService = lcContPlanRiskReportService;
	}
	public LCGrpPolReportService getLcGrpPolReportService() {
		return lcGrpPolReportService;
	}
	public void setLcGrpPolReportService(LCGrpPolReportService lcGrpPolReportService) {
		this.lcGrpPolReportService = lcGrpPolReportService;
	}
	public PDLMDutyService getPdLmDutyService() {
		return pdLmDutyService;
	}
	public void setPdLmDutyService(PDLMDutyService pdLmDutyService) {
		this.pdLmDutyService = pdLmDutyService;
	}
	public PDLMRiskDutyFactorService getPdLmRiskDutyFactorService() {
		return pdLmRiskDutyFactorService;
	}
	public void setPdLmRiskDutyFactorService(
			PDLMRiskDutyFactorService pdLmRiskDutyFactorService) {
		this.pdLmRiskDutyFactorService = pdLmRiskDutyFactorService;
	}
	public LLHospitalService getLlHospitalService() {
		return llHospitalService;
	}
	public void setLlHospitalService(LLHospitalService llHospitalService) {
		this.llHospitalService = llHospitalService;
	}
	//
	public String queryCode(){
		if(methodType == null){
			
		}
		else {
			//params的数据样式：{codeType:bussinessFlag|codeType:bussinessFlag}
			//根据需求的不一样，我们把参数分为两种，一个是map，一种是HqlQueryRule
			Map<String,Object> paramsMap = new HashMap<String, Object>();
			HqlQueryRule hqlQueryRule = new HqlQueryRule();
			//解析参数params，首先根据|分割，然后通过：分割，最后形成键值对
			if(null != params && !"".equals(params.trim())){				
				String paramsTemp = params.replaceAll("_", ".");
				String[] fieldArray = StringUtils.split(paramsTemp, "|");
				for(int i = 0 ; i < fieldArray.length ; i++){
					String[] fieldArrayTemp = StringUtils.split(fieldArray[i],":");
					String key = fieldArrayTemp[0].trim();
					String value = fieldArrayTemp.length==1 ? "" : fieldArrayTemp[1].trim();
					paramsMap.put(key, value);
					hqlQueryRule.addEqual(key, value+"%");
				}
			}
			if (pageNo == 0) {
				pageNo = 1;
			}
			if (pageSize == 0) {
				pageSize = 20;
			}
			//查询当前机构下的所有子机构
			if("PrpDcompany".equals(methodType)){
				Page page = prpDcompanyService.findByPage(pageNo,pageSize,paramsMap);
				writeJSONData(page, new String[]{"codeValue","codeLabel"});
			}
			//查询用户
			else if("PrpDuser".equals(methodType)){
				Page page = userPowerService.findByPage(pageNo,pageSize);
				writeJSONData(page, new String[]{"codeValue","codeLabel"});
			}
			//查询险种
			else if("findRisk".equals(methodType)){
				Page page = pdLmRiskService.findByPage(pageNo,pageSize,hqlQueryRule);
				writeJSONData(page, new String[]{"codeValue","codeLabel"});
			}
			//查询附加险
			else if("findRelationRisk".equals(methodType)){
				Page page = pdLmRiskRelaService.findRelaRisk(pageNo,pageSize,hqlQueryRule);
				writeJSONData(page, new String[]{"codeValue","codeLabel"});
			}
			//查询出险人治疗医院
			else if("findHospital".equals(methodType)){
				Page page = llHospitalService.findHospital(pageNo,pageSize);
				writeJSONData(page, new String[]{"codeValue","codeLabel"});
			}
			//根据附加险编码查询主险
			else if("findMainRisk".equals(methodType)){
				Page page = pdLmRiskRelaService.findMainRisk(pageNo,pageSize,paramsMap);
				writeJSONData(page, new String[]{"codeValue","codeLabel"});
			}
			//根据呈报号查询该呈报下面的险种
			else if("LCContPlanRiskReport".equals(methodType)){
				Page page = lcContPlanRiskReportService.findByRepNo(pageNo,pageSize,paramsMap);
				writeJSONData(page, new String[]{"codeValue","codeLabel"});
			}
			//通过呈报号查询险种
			else if("findRiskByReport".equals(methodType)){
				Page page = lcGrpPolReportService.findRiskByReport(pageNo,pageSize,paramsMap);
				writeJSONData(page, new String[]{"codeValue","codeLabel"});
			}
			//通过险种查询责任
			else if("findDutyByRisk".equals(methodType)){
				Page page = pdLmDutyService.findDutyByRisk(pageNo,pageSize,paramsMap);
				writeJSONData(page, new String[]{"codeValue","codeLabel"});
			}
			//根据险种和责任查询要素，并且去重
			else if("pdlmRiskDutyFactor".equals(methodType)){
				String riskCode = (String)paramsMap.get("riskCode");
				String dutyCode = (String)paramsMap.get("dutyCode");
				List<QueryCodeVo> queryCodes = pdLmRiskDutyFactorService.findFactorDistinct(riskCode, dutyCode);
				this.writeJSONData(queryCodes, new String[]{"codeValue","codeLabel"});
			}
			//其他统一调用pdLdCode查询
			else{
				Page page = pdLdCodeService.findByCode(pageNo,pageSize,paramsMap);
				writeJSONData(page, new String[]{"codeValue","codeLabel"});
			}
		}
		return NONE;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
