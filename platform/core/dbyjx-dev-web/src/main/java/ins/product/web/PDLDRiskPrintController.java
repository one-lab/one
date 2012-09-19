package ins.product.web;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import ins.framework.web.Struts2Action;
import ins.product.model.PDLDRiskPrint;
import ins.product.service.facade.PDLDRiskPrintService;

@Path("/product")
public class PDLDRiskPrintController {
		private static final long serialVersionUID = 1L;
		private PDLDRiskPrint pdldRiskPrint;
		private PDLDRiskPrintService pdldRiskPrintService;
		/**
		 * @title saveRiskPrint
		 * @description 保存一个险种打印
		 * @author 党泽
		 * @return
		 */
		public Reply saveRiskPrint(@Param("pdldRiskPrint") PDLDRiskPrint pdldRiskPrint,
                                   Invocation invocation){
            PDLDRiskPrint pdldRiskPrintTarget = pdldRiskPrintService.saveRiskPrint(pdldRiskPrint);
            invocation.addModel("pdldRiskPrint", pdldRiskPrintTarget);
			//this.writeJSONData(list, args);
			return Replys.simple().success();
		}
		/**
		 * @title deletRiskPrint
		 * @description 删除一个险种打印
		 * @author 党泽
		 * @return
		 */
		public Reply deleteRiskPrint(@Param("pdldRiskPrint") PDLDRiskPrint pdldRiskPrint,
                                     Invocation invocation){
            PDLDRiskPrint pdldRiskPrintTarget = pdldRiskPrintService.deleteRiskPrint(pdldRiskPrint);
            invocation.addModel("pdldRiskPrint", pdldRiskPrintTarget);
            //this.writeJSONData(list, args);
            return Replys.simple().success();
		}
		/**
		 * @title updateRiskPrint
		 * @description 更新一个险种打印
		 * @author 党泽
		 * @return
		 */
		public Reply updateRiskPrint(@Param("pdldRiskPrint") PDLDRiskPrint pdldRiskPrint,
                                     Invocation invocation){
            PDLDRiskPrint pdldRiskPrintTarget = pdldRiskPrintService.updateRiskPrint(pdldRiskPrint);
            invocation.addModel("pdldRiskPrint", pdldRiskPrintTarget);
            //this.writeJSONData(list, args);
            return Replys.simple().success();
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
