package ins.product.service.spring;

import java.util.List;

import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.product.model.PDScheRateCalFactorLib;
import ins.product.service.facade.PDScheRateCalFactorLibService;

public class PDScheRateCalFactorLibServiceSpringImpl extends GenericDaoHibernate<PDScheRateCalFactorLib, String> implements PDScheRateCalFactorLibService {
	/**
	 * service 方法查询费率表要素
	 * @return
	 */
	@Override
	public List<PDScheRateCalFactorLib> findScheRateCalFactor() {
		QueryRule qr = QueryRule.getInstance();
		qr.addAscOrder("standbyflag3");
		List<PDScheRateCalFactorLib> factors = this.find(qr);
		return factors;
	}
	/**
	 * 通过主键factorCode得到要素信息
	 * @param FactorCode
	 * @return
	 */
	@Override
	public PDScheRateCalFactorLib findScheRateCalFactorByFactorCode(
			String factorCode) {
		return this.get(factorCode);
	}

}
