package ins.product.service.facade;

import ins.product.model.PDLMRiskDutyFactor;

import java.util.List;

public interface PDLMDutyParamsService {

	List<PDLMRiskDutyFactor> findDutyParams(String dutyCode);

}
