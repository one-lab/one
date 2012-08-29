package ins.product.service.facade;

import ins.product.model.PDBaseField;

import java.util.List;

public interface PDBaseFieldService {
	public List<PDBaseField> findField(String tableCode);
}
