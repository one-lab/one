package com.sinosoft.one.rms.client;

/**
 * 数据权限规则接口，所有数据规则的groovy文件必须实现此接口
 * User: ChengQi
 * Date: 8/13/12
 * Time: 3:57 PM
 */
public interface DataRuleScript {
	/**
	 * 创建规则SQL 
	 * @param param 查询的参数 如不需要则传入NULL 
	 * @param loginComCode 必传参数 登陆机构代码
	 * @param comPanyTableName 项目对应的的机构表 表名
	 * @param tableAlias 自定义SQL时 主查询的表别名（select * from tablename tableAlias where tableAlias.column ）
	 * @return
	 */
	public String creatSQL(String sqlOrHql,String param,String loginComCode,String comPanyTableName,String comCodeColumnName,String upperColumnName,String tableAlias);
	
	/**
	 * 创建规则SQL 无别名时调用
	 * @param param 查询的参数 如不需要则传入NULL 
	 * @param loginComCode 必传参数 登陆机构代码
	 * @param comPanyTableName 项目对应的的机构表 表名
	 * @return
	 */
	public String creatSQL(String sqlOrHql,String param,String loginComCode,String comPanyTableName,String comCodeColumnName,String upperColumnName);
	
	
	/**
	 * 创建规则SQL
	 * @param param
	 * @param loginComCode
	 * @param comPanyModelName HQL查询时 需要传入的机构MODEL类名
	 * @param tableAlias 
	 * @return
	 */
	public String creatHQL(String sqlOrHql,String param,String loginComCode,String ModelName,String comPanyTableName,String comCodeColumnName,String tableAlias);
	
	/**
	 * 创建规则SQL 无别名时调用
	 * @param param 查询的参数 如不需要则传入NULL 
	 * @param loginComCode 必传参数 登陆机构代码
	 * @param comPanyModelName HQL查询时 需要传入的机构MODEL类名
	 * @return
	 */
	public String creatHQL(String sqlOrHql,String param,String loginComCode,String ModelName,String comPanyTableName,String comCodeColumnName);
	
}
