package ins.platform.common;

import ins.common.model.LDMaxNo;
import ins.common.model.LDMaxNoId;
import ins.common.model.LDUtiKey;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.framework.exception.BusinessException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * 作用：自动生成流水号，需要事前配置好LDUtiKey对象
 * @author Administrator
 *
 */
public class SerialNoUtil extends GenericDaoHibernate<LDMaxNo, LDMaxNoId> {
	
	/**
	 * 自动产生流水号
	 * @param tableName 表名
	 * @param comCode 机构编码
	 * @param fieldName 表中的字段名
	 * @return
	 */
	public String serialNo(String tableName,String comCode,String fieldName) throws BusinessException{
		String serialNo = "";
		List<LDUtiKey> uks = this.findByHql("from LDUtiKey uk where uk.id.tableName = ? and uk.id.fieldName = ? ", tableName.toUpperCase(),fieldName.toUpperCase());
		LDUtiKey ldUtiKey = null ;
		if(uks == null){
			throw  new BusinessException() ;
		}else {
			ldUtiKey = uks.get(0);
		}
		
		//构建查询条件，得到一个LDMaxNo，如果没有，那么新建一个
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("id.tableName", tableName);
		queryRule.addEqual("id.fieldName", fieldName);
		Date nowDate = new Date();
		DateFormat df = new SimpleDateFormat("yyyy");
		String tempYY = df.format(nowDate);
		queryRule.addEqual("id.yearno", tempYY);
		queryRule.addEqual("id.groupNo", comCode);
		LDMaxNo ldMaxNo = this.findUnique(queryRule);
		if(null == ldMaxNo){
			ldMaxNo = new LDMaxNo();
			LDMaxNoId mnid = new LDMaxNoId();
			mnid.setFieldName(fieldName);
			mnid.setGroupNo(comCode);
			mnid.setTableName(tableName);
			mnid.setYearno(tempYY);
			ldMaxNo.setMaxNo("0");
			ldMaxNo.setId(mnid);
			//先使用ldMaxNo，然后更新ldMaxNo，并且将MaxNo加1
			serialNo = findSerial(ldMaxNo, ldUtiKey.getComcodelength(), ldUtiKey.getHeadId(), ldUtiKey.getColLength().intValue());
			ldMaxNo.setMaxNo(String.valueOf(Integer.parseInt(ldMaxNo.getMaxNo())+1));
			this.save(ldMaxNo);	
		}else{				
			serialNo = findSerial(ldMaxNo, ldUtiKey.getComcodelength(), ldUtiKey.getHeadId(),ldUtiKey.getColLength().intValue() );
			ldMaxNo.setMaxNo(String.valueOf(Integer.parseInt(ldMaxNo.getMaxNo())+1));
			this.update(ldMaxNo);
		}

		return serialNo;
	}
	
	//public void 
	
	
	/**
	 * 生成流水号--->如果首字母为空，那么不显示
	 * @param ldMaxNo
	 * @param comCodeLength
	 * @param headId
	 * @param colLength
	 * @return
	 */
	//s+机构编码+yyyy+流水号
	public String findSerial(LDMaxNo ldMaxNo,long comCodeLength,String headId,int colLength){
		String comCodeTemp = ldMaxNo.getId().getGroupNo().substring(0, (int)comCodeLength);
		//不满足colLength的加0，count_0表示应该加上多少个零
		String count_0= "";
		//serialNumber表示流水号
		String serialNumber = "";
		if(ldMaxNo.getMaxNo().length()<colLength){
			for(int i = 0 ; i < colLength-ldMaxNo.getMaxNo().length() ; i++){
				count_0 = count_0 + "0";
			}
			serialNumber = count_0 + ldMaxNo.getMaxNo();
		}
		if(null == headId || "".equals(headId.trim())){
			return comCodeTemp+ldMaxNo.getId().getYearno()+serialNumber;
		}else{			
			return headId+comCodeTemp+ldMaxNo.getId().getYearno()+serialNumber;
		}
	}
	
}
