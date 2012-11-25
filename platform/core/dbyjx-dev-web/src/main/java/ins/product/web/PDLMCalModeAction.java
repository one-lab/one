package ins.product.web;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.commons.beanutils.BeanUtils;

import ins.framework.web.Struts2Action;
import ins.product.model.PDLMCalMode;
import ins.product.service.facade.PDLMCalModeService;

public class PDLMCalModeAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	
	private PDLMCalMode pdlmCalMode = pdlmCalModeService.saveCalMode(pdlmCalMode);
	private PDLMCalModeService pdlmCalModeService;


    public PDLMCalMode getPdlmCalMode() {
		return pdlmCalMode;
	}
	public void setPdlmCalMode(PDLMCalMode pdlmCalMode) {
		this.pdlmCalMode = pdlmCalMode;
	}
	public PDLMCalModeService getPdlmCalModeService() {
		return pdlmCalModeService;
	}
	public void setPdlmCalModeService(PDLMCalModeService pdlmCalModeService) {
		this.pdlmCalModeService = pdlmCalModeService;
	}
	/**
	 * @title saveCalMode
	 * @description 保存一条保费计算公式
	 * @author 朱超
	 * @return 返回当前保存的对象
	 */
	public String saveCalMode(){
		pdlmCalMode = pdlmCalModeService.saveCalMode(pdlmCalMode);
		List<PDLMCalMode> list = new ArrayList<PDLMCalMode>();
		list.add(pdlmCalMode);
		String[] showField = new String[]{"calCode","riskCode","type","calSQL","remark"};
		this.writeJSONData(list, showField);
		return NONE;
	}
	/**
	 * @title updateCalMode
	 * @description 修改一条保费计算公式
	 * @author 朱超
	 * @return  返回修改后的对象
	 */
	public String updateCalMode(){
		pdlmCalMode = pdlmCalModeService.updateCalMode(pdlmCalMode);
		List<PDLMCalMode> list = new ArrayList<PDLMCalMode>();
		list.add(pdlmCalMode);
		String[] showField = new String[]{"calCode","riskCode","type","calSQL","remark"};
		this.writeJSONData(list, showField);
		return "";
	}
	/**
	 * @title deleteCalMode
	 * @description 删除一条保费计算公式
	 * @author 朱超
	 * @return  返回删除后的结果
     * @param calCode
	 */
	public String deleteCalMode(String calCode){
		String flag = pdlmCalModeService.deleteCalMode(calCode);
		this.renderText(flag);
		return "";
	}
}
