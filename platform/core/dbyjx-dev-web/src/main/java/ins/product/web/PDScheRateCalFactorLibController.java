package ins.product.web;

import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import ins.framework.web.Struts2Action;
import ins.product.model.PDScheRateCalFactorLib;
import ins.product.service.facade.PDScheRateCalFactorLibService;
import net.sf.json.processors.JsDateJsonValueProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Path("/product")
public class PDScheRateCalFactorLibController {
	private static final long serialVersionUID = 1L;
	private PDScheRateCalFactorLibService pdScheRateCalFactorLibService;
	@Autowired
	public void setPdScheRateCalFactorLibService(
			PDScheRateCalFactorLibService pdScheRateCalFactorLibService) {
		this.pdScheRateCalFactorLibService = pdScheRateCalFactorLibService;
	}
	/**
	 * 查询费率表要素库得到所有的费率要素
	 * @return
	 */
	public Reply findScheRateCalFactor(){
		List<PDScheRateCalFactorLib> factors = pdScheRateCalFactorLibService.findScheRateCalFactor();
		/** 属性要素代码  属性要素名称  属性要素属性  属性要素数据类型 */
		String[] fieldParams = new String[]{"factorCode","factorName","factorType","factorDataType"};
		//this.getRequest().setAttribute("factors", factors);
		return Replys.with(factors).as(Json.class).includes(fieldParams);
	}
	
}
