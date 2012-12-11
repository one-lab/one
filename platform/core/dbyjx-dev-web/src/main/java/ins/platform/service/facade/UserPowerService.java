package ins.platform.service.facade;

import java.util.List;

import net.sf.json.JSONObject;

import ins.framework.common.Page;
import ins.platform.model.PrpDcompany;
import ins.platform.model.PrpDuser;

public interface UserPowerService {
	/**
	 * 登陆调用此方法
	 * @param prpDuser 页面传递进来的userCode和password
	 * @return
	 */
	PrpDuser login(PrpDuser prpDuser);
	/**
	 * 自动加载当前用户的机构
	 * @param userCode 用户编号
	 * @return
	 */
	List<PrpDcompany> loadCompany(String userCode);
	/**
	 * 拉取菜单列表
	 * @param userCode  用户编号
	 * @param comCode  机构代码
	 * @param string  systemCode系统代码
	 * @param string2  语言选择，暂时只是中文
	 * @return
	 */
	JSONObject showTree(String userCode, String comCode, String string,
			String string2);
	
	/**
	 * 根据comCode机构编号查询出机构的信息
	 * @param comCode
	 * @return
	 */
	PrpDcompany findCompanyByComCode(String comCode);
	/**
	 * 双击带出人员
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page findByPage(int pageNo, int pageSize);

}
