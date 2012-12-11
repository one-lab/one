package ins.product.web;

import ins.framework.web.Struts2Action;
import ins.product.model.PDLDRiskPrint;
import ins.product.service.facade.PDLDRiskPrintService;

public class PDLDRiskPrintAction extends Struts2Action{
		private static final long serialVersionUID = 1L;
		private PDLDRiskPrint pdldRiskPrint;
		private PDLDRiskPrintService pdldRiskPrintService;
		/**
		 * @title saveRiskPrint
		 * @description 保存一个险种打印
		 * @author 党泽
		 * @return
		 */
		public String saveRiskPrint(){
			pdldRiskPrint = pdldRiskPrintService.saveRiskPrint(pdldRiskPrint);
			//this.writeJSONData(list, args);
			return NONE;
		}
		/**
		 * @title deletRiskPrint
		 * @description 删除一个险种打印
		 * @author 党泽
		 * @return
		 */
		public String deleteRiskPrint(){
			pdldRiskPrint = pdldRiskPrintService.deleteRiskPrint(pdldRiskPrint);
			return NONE;
		}
		/**
		 * @title updateRiskPrint
		 * @description 更新一个险种打印
		 * @author 党泽
		 * @return
		 */
		public String updateRiskPrint(){
			pdldRiskPrint = pdldRiskPrintService.updateRiskPrint(pdldRiskPrint);
			return NONE;
		}
		public PDLDRiskPrint getPdldRiskPrint() {
			return pdldRiskPrint;
		}
		public void setPdldRiskPrint(PDLDRiskPrint pdldRiskPrint) {
			this.pdldRiskPrint = pdldRiskPrint;
		}
		public PDLDRiskPrintService getPdldRiskPrintService() {
			return pdldRiskPrintService;
		}
		public void setPdldRiskPrintService(PDLDRiskPrintService pdldRiskPrintService) {
			this.pdldRiskPrintService = pdldRiskPrintService;
		}
}
