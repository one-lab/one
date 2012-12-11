package ins.product.service.facade;

import ins.product.model.PDLDRiskPrint;

public interface PDLDRiskPrintService {
	/**
	 * @title saveRiskPrint
	 * @description 保存一个险种打印
	 * @author 党泽
	 * @param pdldRiskPrint
	 * @return
	 */
	PDLDRiskPrint saveRiskPrint(PDLDRiskPrint pdldRiskPrint);
	/**
	 * @title deleteRiskPrint
	 * @description 删除一个险种打印
	 * @author 党泽
	 * @param pdldRiskPrint
	 * @return
	 */
	PDLDRiskPrint deleteRiskPrint(PDLDRiskPrint pdldRiskPrint);
	/**
	 * @title updateRiskPrint
	 * @description 更新一个险种打印
	 * @author 党泽
	 * @param pdlmRiskPrint
	 * @return
	 */
	PDLDRiskPrint updateRiskPrint(PDLDRiskPrint pdldRiskPrint);
}
