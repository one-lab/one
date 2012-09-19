package ins.product.web;

import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import ins.framework.web.Struts2Action;
import ins.product.model.PDLMRiskDutyFactor;
import ins.product.service.facade.PDLMDutyParamsService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
@Path("/product")
public class PDLMDutyParamsController {

	private static final long serialVersionUID = 1L;
	private PDLMDutyParamsService pdLmDutyParamsService;
	@Autowired
	public void setPdLmDutyParamsService(PDLMDutyParamsService pdLmDutyParamsService) {
		this.pdLmDutyParamsService = pdLmDutyParamsService;
	}

	public Reply findDutyParams(@Param("dutyCode") String dutyCode){
		List<PDLMRiskDutyFactor> pdLmRiskDutyFactorList = pdLmDutyParamsService.findDutyParams(dutyCode);
		return Replys.with(pdLmRiskDutyFactorList).as(Json.class).includes("factorName","factorNoti","id.calFactor");
	}
}
