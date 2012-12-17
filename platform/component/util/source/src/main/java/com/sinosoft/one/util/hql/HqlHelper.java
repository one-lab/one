package com.sinosoft.one.util.hql;

import java.util.ArrayList;
import java.util.List;


public class HqlHelper {
	// pageNum 与 pageSize 只是在计算 firstResult 与 maxResults 用到。
	// 而 firstResult 与 maxResults 只是在分页查询中才用到
	private int pageNum; //表示第几页
	private int pageSize; //页面大小

	private int firstResult; //当前页第一条记录数
	private int maxResults;
	
	public HqlHelper() {
		
	}
	
	public HqlHelper(int pageNum, int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;

		this.firstResult = (pageNum - 1) * pageSize;
		this.maxResults = pageSize;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		this.firstResult = (pageNum - 1) * pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.maxResults = pageSize;
	}
	
	public HqlHelper setFirstResult(int firstResult) {
		this.firstResult = firstResult;
		return this;
	}

	public HqlHelper setMaxResults(int maxResults) {
		this.maxResults = maxResults;
		return this;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public int getMaxResults() {
		return maxResults;
	}
	
	private String fromClause; // Form子句
	private String whereClause = ""; // Where子句
	private String orderByClause = ""; // OrderBy子句

	private List<Object> parameters = new ArrayList<Object>();

	/**
	 * 会生成From子句
	 * 
	 * @param clazz
	 */
	public HqlHelper(Class<?> clazz) {
		fromClause = "FROM " + clazz.getSimpleName() + " o";
	}

	/**
	 * 会生成From子句
	 * 
	 * @param clazz
	 * @param alias
	 *            别名
	 */
	public HqlHelper(Class<?> clazz, String alias) {
		fromClause = "FROM " + clazz.getSimpleName() + " " + alias;
	}
	
	public HqlHelper( int pageNum, int pageSize, Class<?> clazz, String alias) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;

		this.firstResult = (pageNum - 1) * pageSize;
		this.maxResults = pageSize;
		fromClause = "FROM " + clazz.getSimpleName() + " " + alias;
	}

	/**
	 * 添加一个Where子句中的过滤条件表达式（拼接Where子句）
	 * 
	 * @param condition
	 * @param params
	 */
	public HqlHelper addWhereCondition(String condition, Object... params) {
		// 　拼接Where子句
		if (whereClause.length() == 0) {
			whereClause = " WHERE " + condition;
		} else {
			whereClause += " AND " + condition;
		}

		// 保存参数列表
		if (params != null && params.length > 0) {
			for (Object param : params) {
				parameters.add(param);
			}
		}

		return this;
	}

	/**
	 * 如果第1个参数值为true，就添加一个Where子句中的过滤条件表达式（拼接Where子句）
	 * 
	 * @param condition
	 * @param params
	 */
	public HqlHelper addWhereCondition(boolean append, String condition, Object... params) {
		if (append) {
			addWhereCondition(condition, params);
		}

		return this;
	}

	/**
	 * 添加一个OrderBy子句中的参与排序的属性（拼接OrderBy子句）
	 * 
	 * @param propertyName
	 * @param asc
	 */
	public HqlHelper addOrderByProperty(String propertyName, boolean asc) {
		if (orderByClause.length() == 0) {
			orderByClause = " ORDER BY " + propertyName + (asc ? " ASC" : " DESC");
		} else {
			orderByClause += ", " + propertyName + (asc ? " ASC" : " DESC");
		}

		return this;
	}

	/**
	 * 如果第1个参数值为true，就 添加一个OrderBy子句中的参与排序的属性（拼接OrderBy子句）
	 * 
	 * @param propertyName
	 * @param asc
	 */
	public HqlHelper addOrderByProperty(boolean append, String propertyName, boolean asc) {
		if (append) {
			addOrderByProperty(propertyName, asc);
		}

		return this;
	}

	/**
	 * 获取查询数据列表的HQL语句
	 * 
	 * @return
	 */
	public String getQueryListHql() {
		System.out.println(fromClause + whereClause + orderByClause);
		return fromClause + whereClause + orderByClause;
	}

	/**
	 * 获取查询总记录数的HQL语句
	 * 
	 * @return
	 */
	public String getQueryCountHql() {
		return "SELECT COUNT(*) " + fromClause + whereClause;
	}

	/**
	 * 获取参数列表
	 * 
	 * @return
	 */
	public List<Object> getParameters() {
		return parameters;
	}
	
}
