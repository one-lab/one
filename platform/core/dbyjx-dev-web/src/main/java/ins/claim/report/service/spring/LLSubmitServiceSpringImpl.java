package ins.claim.report.service.spring;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import ins.claim.manage.model.LLSubmitApply;
import ins.claim.report.service.facade.LLSubmitService;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.common.SerialNoUtil;
import ins.platform.model.PrpDuser;

public class LLSubmitServiceSpringImpl extends GenericDaoHibernate<LLSubmitApply, String> implements LLSubmitService {
	private SerialNoUtil serialNoUtil;
	
	
	public SerialNoUtil getSerialNoUtil() {
		return serialNoUtil;
	}


	public void setSerialNoUtil(SerialNoUtil serialNoUtil) {
		this.serialNoUtil = serialNoUtil;
	}


	/**
	 * 发起呈报申请
	 * @param llSubmitApply
	 * @author hesiqi
	 */
	public void saveSubmitApply(LLSubmitApply llSubmitApply) {
		ActionContext ac = ActionContext.getContext();
		PrpDuser user = (PrpDuser) ac.getSession().get("user");
		String comCode = (String) ac.getSession().get("comCode");
		//呈报序号
		String subNo = serialNoUtil.serialNo("LLSUBMITAPPLY", comCode, "SUBNO");
		llSubmitApply.getId().setSubNo(subNo);
		//呈报次数
		String subCount = null;
		String sql = "select max(cast( subCount as int)) as subCount from llsubmitapply where clmNo=? and subNo=?";
		List<Integer> list = this.findBySql(sql, llSubmitApply.getId().getClmNo(),llSubmitApply.getId().getSubNo());
		if(list.get(0) == null){
			subCount = 1 + "";
		}else{
			subCount = Integer.parseInt(String.valueOf(list.get(0))) + 1 + "";
		}
		llSubmitApply.getId().setSubCount(subCount);
		llSubmitApply.setInitPhase("10");
		llSubmitApply.setSubPer(user.getUserCode());
		llSubmitApply.setSubDate(new Date());
		llSubmitApply.setSubState("0");
		llSubmitApply.setOperator(user.getUserCode());
		llSubmitApply.setMakeDate(new Date());
		llSubmitApply.setMakeTime(DateUtil.getTime());
		llSubmitApply.setModifyDate(new Date());
		llSubmitApply.setModifyTime(DateUtil.getTime());
		this.save(llSubmitApply);
	}

}
