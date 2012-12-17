package ins.product.service.spring;

import ins.framework.dao.GenericDaoHibernate;
import ins.product.model.PDBaseField;
import ins.product.model.PDBaseFieldId;
import ins.product.service.facade.PDBaseFieldService;

import java.util.List;

public class PDBaseFieldServiceSpringImpl extends GenericDaoHibernate<PDBaseField, PDBaseFieldId> implements PDBaseFieldService {
	public List<PDBaseField> findField(String tableCode){
		String findRiskFieldHql = "select baseField from PDBaseField baseField where baseField.id.tableCode = ? and baseField.isDisplay = 1 order by baseField.displayOrder ";
		List<PDBaseField> fields = this.findByHql(findRiskFieldHql, tableCode);
		return fields;
	}
}
