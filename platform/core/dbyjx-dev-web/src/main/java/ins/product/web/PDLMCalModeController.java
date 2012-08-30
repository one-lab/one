package ins.product.web;

import java.util.ArrayList;
import java.util.List;

import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Text;
import org.apache.commons.beanutils.BeanUtils;

import ins.framework.web.Struts2Action;
import ins.product.model.PDLMCalMode;
import ins.product.service.facade.PDLMCalModeService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/product")
public class PDLMCalModeController {
	private static final long serialVersionUID = 1L;
	
	private PDLMCalModeService pdlmCalModeService;
    @Autowired
	public void setPdlmCalModeService(PDLMCalModeService pdlmCalModeService) {
		this.pdlmCalModeService = pdlmCalModeService;
	}
	/**
	 * @title saveCalMode
	 * @description 保存一条保费计算公式
	 * @author 朱超
	 * @return 返回当前保存的对象
	 */
	public Reply saveCalMode(@Param("pdlmCalMode")PDLMCalMode pdlmCalMode){
        PDLMCalMode	pdlmCalModeTemp = pdlmCalModeService.saveCalMode(pdlmCalMode);
		List<PDLMCalMode> list = new ArrayList<PDLMCalMode>();
		list.add(pdlmCalModeTemp);
		String[] showField = new String[]{"calCode","riskCode","type","calSQL","remark"};
		return Replys.with(list).as(Json.class).includes(showField);
	}
	/**
	 * @title updateCalMode
	 * @description 修改一条保费计算公式
	 * @author 朱超
	 * @return  返回修改后的对象
	 */
	public Reply updateCalMode(@Param("pdlmCalMode")PDLMCalMode pdlmCalMode){
	    PDLMCalMode	pdlmCalModeTemp = pdlmCalModeService.updateCalMode(pdlmCalMode);
		List<PDLMCalMode> list = new ArrayList<PDLMCalMode>();
		list.add(pdlmCalModeTemp);
		String[] showField = new String[]{"calCode","riskCode","type","calSQL","remark"};
		return Replys.with(list).as(Json.class).includes(showField);
	}
	/**
	 * @title deleteCalMode
	 * @description 删除一条保费计算公式
	 * @author 朱超
	 * @return  返回删除后的结果
	 */
	public Reply deleteCalMode(@Param("calCode")String calCode){
		String flag = pdlmCalModeService.deleteCalMode(calCode);
        return Replys.with(flag).as(Text.class);

	}
}
