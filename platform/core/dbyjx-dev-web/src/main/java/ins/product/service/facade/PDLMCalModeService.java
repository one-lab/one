package ins.product.service.facade;

import com.sinosoft.one.mvc.web.Invocation;
import ins.product.model.PDLMCalMode;

public interface PDLMCalModeService {
	/**
	 * @title saveCalMode
	 * @description 保存一条保费计算公式
	 * @author 朱超
	 * @param  
	 * @return  返回当前保存的对象
	 */
	PDLMCalMode saveCalMode(PDLMCalMode pdlmCalMode, Invocation invocation);
	/**
	 * @title saveCalMode
	 * @description 修改一条保费计算公式
	 * @author 朱超
	 * @param  
	 * @return  返回当前保存的对象
	 */
	PDLMCalMode updateCalMode(PDLMCalMode pdlmCalMode);
	/**
	 * @title saveCalMode
	 * @description 删除一条保费计算公式
	 * @author 朱超
	 * @param  
	 * @return  返回操作结果
	 */
	String deleteCalMode(String calCode);

}
