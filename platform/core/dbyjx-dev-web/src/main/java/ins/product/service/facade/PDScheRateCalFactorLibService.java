package ins.product.service.facade;

import ins.product.model.PDScheRateCalFactorLib;

import java.util.List;

public interface PDScheRateCalFactorLibService {
	/**
	 * service 方法查询费率表要素
	 * @return
	 */
	List<PDScheRateCalFactorLib> findScheRateCalFactor();
	/**
	 * 通过主键factorCode得到要素信息
	 * @param FactorCode
	 * @return
	 */
	PDScheRateCalFactorLib findScheRateCalFactorByFactorCode(String factorCode);

}
