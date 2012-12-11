package ins.product.web;

import ins.framework.web.Struts2Action;
import ins.product.model.PDScheRateCalFactorLib;
import ins.product.service.facade.PDScheRateCalFactorLibService;

import java.util.List;

public class PDScheRateCalFactorLibAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	private PDScheRateCalFactorLibService pdScheRateCalFactorLibService;
	
	public PDScheRateCalFactorLibService getPdScheRateCalFactorLibService() {
		return pdScheRateCalFactorLibService;
	}

	public void setPdScheRateCalFactorLibService(
			PDScheRateCalFactorLibService pdScheRateCalFactorLibService) {
		this.pdScheRateCalFactorLibService = pdScheRateCalFactorLibService;
	}
	/**
	 * 查询费率表要素库得到所有的费率要素
	 * @return
	 */
	public String findScheRateCalFactor(){
		List<PDScheRateCalFactorLib> factors = pdScheRateCalFactorLibService.findScheRateCalFactor();
		/** 属性要素代码  属性要素名称  属性要素属性  属性要素数据类型 */
		String[] fieldParams = new String[]{"factorCode","factorName","factorType","factorDataType"};
		this.writeJSONData(factors, fieldParams);
		//this.getRequest().setAttribute("factors", factors);
		return NONE;
	}
	
}
