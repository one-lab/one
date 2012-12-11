package ins.claim.report.service.spring;

import ins.claim.manage.model.LLHospitalInfo;
import ins.claim.report.service.facade.LLHospitalService;
import ins.framework.common.HqlQueryRule;
import ins.framework.common.Page;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.SerialNoUtil;

public class LLHospitalServiceSpringImpl extends
		GenericDaoHibernate<LLHospitalInfo, String> implements LLHospitalService {
	private SerialNoUtil serialNoUtil;

	public SerialNoUtil getSerialNoUtil() {
		return serialNoUtil;
	}

	public void setSerialNoUtil(SerialNoUtil serialNoUtil) {
		this.serialNoUtil = serialNoUtil;
	}

	/**
	 * 查询医院编码和名称
	 * @param LLHospitalInfo
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @author zhangkai
	 */
	@Override
	public Page findHospital(int pageNo, int pageSize) {
		Page page = null;
		
		page = this.findByHql("select new ins.platform.vo.QueryCodeVo(llHospitalInfo.hospitalCode , llHospitalInfo.hospitalName) from LLHospitalInfo llHospitalInfo " ,pageNo, pageSize, null);
		
		return page;
	}
}
