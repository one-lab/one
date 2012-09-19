package com.sinosoft.one.data.strategy;

import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;

import java.util.Properties;

/**
 * User: Morgan
 * Date: 12-9-13
 * Time: 下午4:15
 */
public class IgnorePrefixReverseEngineeringStrategy extends DelegatingReverseEngineeringStrategy {

	private static int _NUMBER;

	public IgnorePrefixReverseEngineeringStrategy(ReverseEngineeringStrategy delegate) {
		super(delegate);

		String num = IgnorePrefixSystemProp._NUMBER_PROPS;
		if(num != null) {
			_NUMBER = Integer.valueOf(num).intValue();
		} else {
			System.out.println("can not get _NUMBER_PROPS property!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
//		_NUMBER = Integer.valueOf(System.getProperty("_NUMBER_PROPS")).intValue();
	}

	public String tableToClassName(TableIdentifier tableIdentifier) {
		String delegateResult = super.tableToClassName(tableIdentifier);
		//t_aa_bb first_index = 1
		//delegateResult = TAaBb index = first_infex-1;
		int _index = 0;
		String tableName = tableIdentifier.getName();
		int tempNum = _NUMBER;
		while (tempNum-- > 0) {
			int tempIndex = tableName.indexOf('_');

			if(tempIndex < 0)
				break;
			_index += tempIndex;
			tableName = tableName.substring(tempIndex + 1);
		}

		int index = delegateResult.lastIndexOf('.');

		String packageName = delegateResult.substring(0, index + 1);
		String className = delegateResult.substring(index + 1);
		if(_index > 0){
			className = className.substring(_index);
		} else {
			className = className.substring(className.lastIndexOf('_')+1);
		}

		String fullClassName = packageName + className;

		return fullClassName;
	}

	public static void main (String[] args) {

		System.out.println("args" + args);
		if(args != null && args.length > 0){
			int num = Integer.valueOf(args[0]).intValue();
			System.out.println("args" + num);
//			System.setProperty("_NUMBER_PROPS",args[0]);
		}

		String[] talbeNames = {"T_CODE_GENDER","T_CODE_GROUP","C_USER","C_ROLE",
				"T_CHECK_BOOLEAN","T_T_T_USER","T_CODE_GROUP",
				"T_dA_Bd_Cdd_Ddadf"};
		for (int i=0;i< talbeNames.length;i++) {
			test(talbeNames[i]);
		}
	}

	private static void test(String tableName) {
		int _index = 0;
		String delegateResult = tableName.replaceAll("_","");
		//String tableName = tableIdentifier.getName();
		int tempNum = _NUMBER;
		while (tempNum-- > 0) {
			int tempIndex = tableName.indexOf('_');

			if(tempIndex < 0)
				break;
			_index += tempIndex;
			tableName = tableName.substring(tempIndex + 1);
		}
		System.out.println("--------------------------_NUMBER+"+_NUMBER+" _index:"+_index);



		String className = delegateResult;
		if(_index > 0){
			className = className.substring(_index);
		} else {
			className = className.substring(className.lastIndexOf('_')+1);
		}
		System.out.println("---------------------------className:"+className);
	}

}
