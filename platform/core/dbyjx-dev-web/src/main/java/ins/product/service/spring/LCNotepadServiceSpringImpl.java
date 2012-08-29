package ins.product.service.spring;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.common.SerialNoUtil;
import ins.platform.model.PrpDcompany;
import ins.platform.model.PrpDuser;
import ins.product.service.facade.LCNotepadService;
import ins.prpall.proposal.model.LCNotepad;

public class LCNotepadServiceSpringImpl extends GenericDaoHibernate<LCNotepad, String> implements LCNotepadService {
	private SerialNoUtil serialNoUtil;
	
	public SerialNoUtil getSerialNoUtil() {
		return serialNoUtil;
	}

	public void setSerialNoUtil(SerialNoUtil serialNoUtil) {
		this.serialNoUtil = serialNoUtil;
	}

	@Override
	public LCNotepad savaNotepad(LCNotepad lcNotepad) {
		ActionContext ac = ActionContext.getContext();
		PrpDuser user = (PrpDuser) ac.getSession().get("user");
		PrpDcompany prpDcompany = (PrpDcompany) ac.getSession().get("prpDcompany");
		int serialNo;
		String hql = "select max(cast( lcNotepad.id.serialNo as int)) as serialNo from LCNotepad lcNotepad where lcNotepad.id.bussinessNo = ?";
		List<Integer> list = (List<Integer>) this.findByHql(hql, lcNotepad.getId().getBussinessNo());
		if(null == list.get(0)){
			serialNo = 1;
		}else{
			serialNo = Integer.parseInt(String.valueOf(list.get(0))) + 1;
		}
		String operator = user.getUserCode();
		lcNotepad.getId().setSerialNo(serialNo);
		lcNotepad.setMakeDate(new Date());
		lcNotepad.setMakeTime(DateUtil.getTime());
		lcNotepad.setModifyDate(new Date());
		lcNotepad.setModifyTime(DateUtil.getTime());
		lcNotepad.setOperator(operator);
		lcNotepad.setInputLocation("基础信息定义");
		this.save(lcNotepad);
		return lcNotepad;
	}

}
