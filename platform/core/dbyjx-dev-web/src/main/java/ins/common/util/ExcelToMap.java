package ins.common.util;

import ins.common.model.ExcelMapperTable;
import ins.common.model.ExcelMapperTableId;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 将一个excel表格导出一个List<Map<Serializable>>对象： 其中List<List>表示多个工作表格
 * List<Map>表示一个工作表格里面的所有内容
 * 
 * @author Administrator
 * 
 */
public class ExcelToMap extends GenericDaoHibernate<ExcelMapperTable, ExcelMapperTableId> {

	// 每一个Map就是一行数据，然后将所有的Map放在list里面
	public List<Object> excelToMap(File inputFile, String marker)
			throws Exception {
		File file = inputFile;

		// 得到一个工作簿
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook wbs = new HSSFWorkbook(fis);
		//用来存储数据的list
		List<Map<String, Object>> excelList = new ArrayList<Map<String, Object>>();
		// 用来装标题的list
		List<String> listTitle = new ArrayList<String>();
		// 得到一个工作区
		HSSFSheet childSheet = wbs.getSheetAt(0);
		// 得到标题行
		HSSFRow rowTitle = childSheet.getRow(0);
		// 得到与数据库数据库表和excel表的对应关系	
		QueryRule rule = QueryRule.getInstance();
		rule.addEqual("id.marker", marker);
		System.out.println(rule.toString());
		List<ExcelMapperTable> list = this.find(rule);
		//获得实例类名称
		String className=list.get(0).getClassName();
		// 构建标题的list
		for (int t = 0; t < rowTitle.getLastCellNum(); t++) {
			HSSFCell cellTitle = rowTitle.getCell(t);
			String title = cellTitle.getStringCellValue();
			// 将title转换为数据库中的字段field
			for (int j = 0; j < list.size(); j++) {
				if (title.equals(list.get(j).getId().getExcelvalue())) {
					listTitle.add(list.get(j).getId().getFiledvalue());
					System.out.println(list.get(j).getId().getFiledvalue());
					break;
				}
			}
		}
		// 遍历每行的内容
		for (int j = 1; j <= childSheet.getLastRowNum(); j++) {
			HSSFRow row = childSheet.getRow(j);
			Map<String, Object> rowMap = new HashMap<String, Object>();
			if (null != row) {
				for (int k = 1; k < row.getLastCellNum(); k++) {
					HSSFCell cell = row.getCell(k);
					String key = listTitle.get(k-1);
					Object value = null;
					if (null != cell) {
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_NUMERIC: // 数字
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								// 如果是date类型则 ，获取该cell的date值
								value = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
							} else { // 纯数字
								value = String.valueOf(cell.getNumericCellValue());
							}
							break;
						case HSSFCell.CELL_TYPE_STRING: // 字符串
							value = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
							value = cell.getBooleanCellValue();
							break;
						case HSSFCell.CELL_TYPE_FORMULA: // 公式
							value = cell.getCellFormula();
							break;
						case HSSFCell.CELL_TYPE_BLANK: // 空值
							value = "";
							break;
						case HSSFCell.CELL_TYPE_ERROR: // 故障
							value = "ERROR";
							break;
						default:
							value = cell.getBooleanCellValue();
							break;
						}
					} else {
						value = null;
					}
					rowMap.put(key, value);
				}
			}
			excelList.add(rowMap);
			System.out.println(excelList.toString());
		}
		List<Object> dataList=mapToPOJO(excelList,className);
		System.out.println(dataList.toString());
		return dataList;
	}

	private List<Object> mapToPOJO(List<Map<String, Object>> excelList,	String className) throws Exception  {
		//标志位，标志对象中是否有引用类型
		boolean flag = false;
		List<Object> listPOJO = new ArrayList<Object>();
		//通过className加载到内存
		Class<?> objClass = Class.forName(className);
		//实例化类
		Object obj = objClass.newInstance();
		//遍历List中的一个Map，查看Map中是否含有"id",如果有认为是含有联合主键
		Map<String,Object> temp = excelList.get(0);
		Set<String> key = temp.keySet();
		for (Iterator<String> it = key.iterator() ; it.hasNext() ; ) {
			String s = (String) it.next();
			if(s.indexOf("id.")>=0){
				flag = true;
				break;
			}
	    }
		if(flag){
			for(int i = 0 ; i < excelList.size() ; i++){
				//得到实例化类的所有字段
				Field[] fields = objClass.getDeclaredFields();
				//将类中的ID类实例化
				for(Field field : fields){
					if("id".equals(field.getName())){
						Class<?> tempClass = field.getType();
						Object idObj = tempClass.newInstance();
						Set<String> tempSet=excelList.get(i).keySet();
						Map<String ,Object> tempMap=new HashMap<String,Object>();
						List<String> strList=new ArrayList<String>();
						//遍历tempSet，把含有id的字段去掉id，封装成Map
						for(Iterator<String> tempIt=tempSet.iterator();tempIt.hasNext();){
							String str=tempIt.next();
							if(str.indexOf("id.")>=0){
								tempMap.put(str.substring(3),excelList.get(i).get(str));
								strList.add(str);
							}
						}
						//去掉带id的字段
						for(int n=0;n<strList.size();n++){
							excelList.get(i).remove(strList.get(n));
						}
						BeanUtils.populate(idObj, tempMap);
						//将id的实例化类放在list中
						excelList.get(i).put("id", idObj);
						break;
					}
				}
				BeanUtils.populate(obj, excelList.get(i));
				listPOJO.add(obj);
			}
		}else{
			for(int i = 0 ; i < excelList.size() ; i++){
				BeanUtils.populate(obj, excelList.get(i));
				listPOJO.add(obj);
			}
		}
		return listPOJO;
	}	
}
