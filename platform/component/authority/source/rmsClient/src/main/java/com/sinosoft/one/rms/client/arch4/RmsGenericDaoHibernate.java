package com.sinosoft.one.rms.client.arch4;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.hql.QueryTranslator;
import org.hibernate.hql.QueryTranslatorFactory;
import org.hibernate.hql.ast.ASTQueryTranslatorFactory;
import org.hibernate.impl.QueryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.util.Assert;

import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.framework.utils.StringUtils;

import com.sinosoft.one.rms.client.DataRuleStringCreat;
import com.sinosoft.one.rms.client.EnvContext;


/**
 * rms GenericDaoHibernate
 * basic is arch4 GenericDaoHibernate; fill rms control task in it
 * User: ChengQi
 * Date: 3/22/12
 * Time: 11:07 AM
 */
public class RmsGenericDaoHibernate <T extends java.io.Serializable, PK extends java.io.Serializable> extends GenericDaoHibernate<T, PK>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private DataRuleStringCreat dataRuleStringCreat;
	
	public java.util.List<T> find(QueryRule queryRule){
//        if(EnvContext.getDataAuthorityTaskId()!=null){
////        	String rule =dataRuleStringCreat.editSqlQueryRule("");
////        	if(StringUtils.isNotBlank(rule))
////        		queryRule.addSql(rule);
//        	System.out.println(EnvContext.getDataAuthorityTaskId());
//        }
        return super.find(queryRule);
    }

	
	public Page find(QueryRule queryRule, int pageNo, int pageSize){
//        if(EnvContext.getDataAuthorityTaskId()!=null){
//        	String rule =dataRuleStringCreat.editSqlQueryRule("");
//        	if(StringUtils.isNotBlank(rule))
//        		queryRule.addSql(rule);
//        }
        return super.find(queryRule,pageNo,pageSize);
    }

	@SuppressWarnings("hiding")
	public <T> Page find(Class<T> arg0, QueryRule queryRule, int arg2, int arg3 ) {
//		 if(EnvContext.getDataAuthorityTaskId()!=null){
//			 String rule =dataRuleStringCreat.editSqlQueryRule("");
//	        if(StringUtils.isNotBlank(rule))
//	        	queryRule.addSql(rule);
//		 }
		return super.find(arg0, queryRule, arg2, arg3);
	}

	@SuppressWarnings({ "rawtypes", "hiding" })
	public <T> List find(Class<T> entityClass, QueryRule queryRule) {
//		if(EnvContext.getDataAuthorityTaskId()!=null){
//			String rule =dataRuleStringCreat.editSqlQueryRule("");
//        	if(StringUtils.isNotBlank(rule))
//        		queryRule.addSql(rule);
//		}
		return super.find(entityClass, queryRule);
	}
	
	@SuppressWarnings("rawtypes")
	public List findBySql(String sql, Object... values) {
//		sql=sql+" and "+EditqueryRule();
//		if(EnvContext.getDataAuthorityTaskId()!=null){
//			sql=dataRuleStringCreat.editSqlQueryRule(sql);
//		}
		return super.findBySql(sql, values);
	}

	public Page findByHql(String arg0, int arg1, int arg2,Object... arg3) {
//		return realfindByHql(arg0, arg1, arg2, arg3);
		return super.findByHql(arg0, arg1, arg2, arg3);
	}

	@SuppressWarnings("rawtypes")
	public List findByHql(String arg0, Object... arg1) {
//				return realfindByHql(arg0, arg1);
		return super.findByHql(arg0, arg1);
	}

	public Page findByHqlNoLimit(String arg0, int arg1, int arg2,
			Object... arg3) {
//		return realfindByHqlNoLimit(arg0, arg1, arg2, arg3);
		return super.findByHqlNoLimit(arg0, arg1, arg2, arg3);
	}

	@SuppressWarnings("rawtypes")
	public List findTopByHql(String arg0, int arg1, Object... arg2) {
//		return realfindTopByHql(arg0, arg1, arg2);
		return super.findTopByHql(arg0, arg1, arg2);
	}

	public <T> List<T> getAll(Class<T> entityClass) {
//		return loadAll(entityClass);
		return super.getAll(entityClass);
	}
	
	
	//---------------------------------------------------------------------------------------------------//
	String hqlParser(String originalHql){
		SessionFactoryImplementor realsessionFactory = (SessionFactoryImplementor)sessionFactory;
		QueryTranslatorFactory queryTranslatorFactory = realsessionFactory.getSettings().getQueryTranslatorFactory();
		QueryTranslator queryTranslator=queryTranslatorFactory.createQueryTranslator(originalHql, originalHql, Collections.EMPTY_MAP, (SessionFactoryImplementor)getSessionFactory());
		queryTranslator.compile(Collections.EMPTY_MAP, false);
		return  queryTranslator.getSQLString() ; 
		
	}
    
	//修改Arch4 方法List findByHql(String hql, Object[] values)原逻辑
	public List realfindByHql(String hql, final Object[] values){
		Assert.hasText(hql);
	    String newHql = hql;
	    int pos = 0;
	    if (values != null) {
	    	for (int i = 0; i < values.length; i++) {
	    		pos = newHql.indexOf('?', pos);
	    		if (pos == -1) {
	    			break;
	    		}
	    		if (((values[i] instanceof Collection)) && (pos > -1)) {
	    			newHql = newHql.substring(0, pos) + ":queryParam" + i + newHql.substring(pos + 1);
	    		}
	    		pos += 1;
	    	}
	    }
	    String fnHql = newHql;
	    String querySQL = null;
	    querySQL=hqlParser(fnHql);
	    if(EnvContext.getDataAuthorityTaskId()!=null){
	    	querySQL=dataRuleStringCreat.editSqlQueryRule(querySQL);
		}
	    final String queryfnSQL=querySQL;
	    List list = getHibernateTemplate().executeFind(new HibernateCallback() {
	    	public Object doInHibernate(Session session) throws SQLException {
	    		SQLQuery query = session.createSQLQuery(queryfnSQL);
	    		query.addEntity(entityClass);
	    		if ( values != null) {
	    			for (int i = 0; i <  values.length; i++) {
	    				if (( values[i] instanceof Collection))
	    					query.setParameterList("queryParam" + i, (Collection) values[i]);
	    				else {
	    					query.setParameter(i,  values[i]);
	    				}
	    			}
	    		}
	    		return query.list();
	    	}
	    });
	    return list;
	}
	
	//修改Arch4 方法Page findByHqlNoLimit(String hql, int pageNo, int pageSize, Object[] values)原逻辑
	public Page realfindByHqlNoLimit(String hql, int pageNo, int pageSize, final Object[] values){
		Assert.hasText(hql);
		if (pageNo <= 0) {
			pageNo = 1;
		}
	    if (pageSize == 0) {
	    	pageSize = 10;
	    }
	    
	    String newHql = hql;
	    int pos = 0;
	    if (values != null) {
	    	for (int i = 0; i < values.length; i++) {
	    		pos = newHql.indexOf('?', pos);
	    		if (pos == -1) {
	    			break;
	    		}
	    		if (((values[i] instanceof Collection)) && (pos > -1)) {
	    			newHql = newHql.substring(0, pos) + ":queryParam" + i + newHql.substring(pos + 1);
	    		}
	    		pos += 1;
	    	}
	    }
	    String fnHql = newHql;

	    StringBuffer countQueryString = new StringBuffer(fnHql.length() + 20).append(" select count (*) ").append(removeSelect(removeOrders(fnHql)));
	    String querySQL = null;
	    querySQL=hqlParser(countQueryString.toString());
	    if(EnvContext.getDataAuthorityTaskId()!=null){
	    	querySQL=dataRuleStringCreat.editSqlQueryRule(querySQL);
		}
	    final String queryfnSQL=querySQL;
	    List countlist = getHibernateTemplate().executeFind(new HibernateCallback() {
	    	public Object doInHibernate(Session session) throws SQLException {
	    		SQLQuery query = session.createSQLQuery(queryfnSQL);
	    	  	query.addEntity(entityClass);
	    		if ( values != null) {
	    			for (int i = 0; i < values.length; i++) {
	    				if (( values[i] instanceof Collection))
	    					query.setParameterList("queryParam" + i, (Collection)values[i]);
	    				else {
	    					query.setParameter(i, values[i]);
	    				}
	    			}
	    		}
	    		return query.list();
	    	}
	    });
	    long totalCount = ((Long)countlist.get(0)).longValue();
	    if (totalCount < 1L) {
	    	return new Page();
	    }
	    final int realPageSize = pageSize;
	    
	    final int startIndex = Page.getStartOfPage(pageNo, pageSize);
	    querySQL=hqlParser(fnHql);
	    if(EnvContext.getDataAuthorityTaskId()!=null){
	    	querySQL=dataRuleStringCreat.editSqlQueryRule(querySQL);
		}
	    final String orgqueryfnSQL=querySQL;
	    List list = getHibernateTemplate().executeFind(new HibernateCallback() {
	    	public Object doInHibernate(Session session) throws SQLException {
	    		SQLQuery query = session.createSQLQuery(orgqueryfnSQL);
	    		query.addEntity(entityClass);
	    		if ( values != null) {
	    			for (int i = 0; i < values.length; i++) {
	    				if (( values[i] instanceof Collection))
	    					query.setParameterList("queryParam" + i, (Collection)values[i]);
	    				else {
	    					query.setParameter(i,values[i]);
	    				}
	    			}
	    		}
	    		query.setFirstResult( startIndex);
	    		query.setMaxResults(realPageSize);
	    		return query.list();
	    	}
	    });
	    return new Page(startIndex, totalCount, pageSize, list);
	}
	
	//修改Arch4 方法 List findTopByHql(String hql, int top, Object[] values)原逻辑
	List realfindTopByHql(String hql, final int top, final Object[] values) {
		String newHql = hql;
		int pos = 0;
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				pos = newHql.indexOf('?', pos);
				if (pos == -1) {
					break;
				}
				if (((values[i] instanceof Collection)) && (pos > -1)) {
					newHql = newHql.substring(0, pos) + ":queryParam" + i
					+ newHql.substring(pos + 1);
				}

				pos += 1;
			}
		}
		String fnHql = newHql;
		//此处处理parser及规则逻辑
		String querySQL = null;
	    querySQL=hqlParser(fnHql);
	    if(EnvContext.getDataAuthorityTaskId()!=null){
	    	querySQL=dataRuleStringCreat.editSqlQueryRule(querySQL);
		}
	    final String queryfnSQL=querySQL;
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws SQLException {
				SQLQuery query = session.createSQLQuery(queryfnSQL);
	    		query.addEntity(entityClass);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						if ((values[i] instanceof Collection))
							query.setParameterList("queryParam" + i,
									(Collection) values[i]);
						else {
							query.setParameter(i, values[i]);
						}
					}
				}
				query.setFirstResult(0);
				query.setMaxResults(top);
				return query.list();
			}
		});
		return list;
	}
	
	
	//修改Arch4 原逻辑方法 page super.findByHql(arg0, arg1, arg2, arg3)
	Page realfindByHql(String hql, int pageNo, int pageSize, final Object[] values){
		Assert.hasText(hql);
	    if (pageNo <= 0) {
	      pageNo = 1;
	    }
	    if (pageSize <= 0) {
	      pageSize = 10;
	    }

	    String newHql = hql;
	    int pos = 0;
	    if (values != null) {
	    	for (int i = 0; i < values.length; i++) {
	    		pos = newHql.indexOf('?', pos);
	    		if (pos == -1) {
	    			break;
	    		}
	    		if (((values[i] instanceof Collection)) && 
	    				(pos > -1)) {
	    			newHql = newHql.substring(0, pos) + ":queryParam" + i + newHql.substring(pos + 1);
	    		}

	    		pos += 1;
	    	}
	    }
	    String fnHql = newHql;
	    //此处处理parser及规则逻辑
	    String querySQL = null;
	    querySQL=hqlParser(newHql);
	    if(EnvContext.getDataAuthorityTaskId()!=null){
	    	querySQL=dataRuleStringCreat.editSqlQueryRule(querySQL);
		}
	    final String queryfnSQL=querySQL;
	    final int startIndex = Page.getStartOfPage(pageNo, pageSize);

	    if (startIndex < 0) {
	      return new Page();
	    }

	    if ((isOptimizeFind()) && (pageNo > 1)) {
	    	final int realPageSize = pageSize;
	    	List list = getHibernateTemplate().executeFind(new HibernateCallback() {
	          public Object doInHibernate(Session session) throws SQLException {
	            SQLQuery query = session.createSQLQuery(queryfnSQL);
//	            query.addEntity(entityClass);
	            if (values != null) {
	              for (int i = 0; i < values.length; i++) {
	                if ((values[i] instanceof Collection))
	                  query.setParameterList("queryParam" + i, (Collection)values[i]);
	                else {
	                  query.setParameter(i, values[i]);
	                }
	              }
	            }
	            query.setFirstResult(startIndex);
	            query.setMaxResults(realPageSize);
	            return query.list();
	          }
	    	});
	    	return new Page(startIndex, -1L, pageSize, list);
	    }

	    int maxCount = 100;
	    String modifyHql = null;

	    final boolean isIncludeDistinctFlag = isIncludeDistinct(fnHql);
	    if (isIncludeDistinctFlag)
	    	modifyHql = getDistinctCountHql(fnHql) + removeSelect(removeOrders(fnHql));
	    else {
	    	modifyHql = " select 1 " + removeSelect(removeOrders(fnHql));
	    }
	    
	    //此处处理parser及规则逻辑
	    querySQL=hqlParser(modifyHql);
	    if(EnvContext.getDataAuthorityTaskId()!=null){
	    	querySQL=dataRuleStringCreat.editSqlQueryRule(querySQL);
		}
	    final String countquerySQL = querySQL;
	    List countList = getHibernateTemplate().executeFind(new HibernateCallback() {
	    	public Object doInHibernate(Session session) throws SQLException {
	    		SQLQuery query = session.createSQLQuery(countquerySQL);
//	    		query.addEntity(entityClass);
	    		if (values != null) {
	    			for (int i = 0; i < values.length; i++) {
	    				if ((values[i] instanceof Collection))
	    					query.setParameterList("queryParam" + i, (Collection)values[i]);
	    				else {
	    					query.setParameter(i, values[i]);
	    				}
	    			}
	    		}
	    		if (!isIncludeDistinctFlag) {
	    			query.setFirstResult(startIndex);
	    			query.setMaxResults(100 - startIndex);
	    		}
	    		return query.list();
	    	}
	    });
	    long totalCount = 0L;
	    if (isIncludeDistinctFlag) {
	    	totalCount = ((Long)countList.get(0)).longValue();
	      if (totalCount < 1L)
	    	  return new Page();
	    }
	    else   {
	    	if (countList.size() < 1) {
	    		return new Page();
	    	}
	    	totalCount = startIndex + countList.size();
	    }
	    final int realPageSize = pageSize;
	    List list = getHibernateTemplate().executeFind(new HibernateCallback() {
	    	public Object doInHibernate(Session session) throws SQLException {
	    		Query query = session.createSQLQuery( queryfnSQL).addEntity(entityClass);
	    		if (values != null) {
	    			for (int i = 0; i < values.length; i++) {
	    				if ((values[i] instanceof Collection))
	    					query.setParameterList("queryParam" + i, (Collection)values[i]);
	    				else {
	    					query.setParameter(i, values[i]);
	    				}
	    			}
	    		}
	    		query.setFirstResult(startIndex);
	    		query.setMaxResults(realPageSize);
	    		return query.list();
	    	}
	    });
	    return new Page(startIndex, totalCount, pageSize, list);
	}
	
	//修改hibernate原逻辑方法 loadAll(final Class<T> entityClass)
	@SuppressWarnings("hiding")
	public <T> List<T> loadAll(final Class<T> entityClass) throws DataAccessException {
		String HQL="from "+entityClass.getName()+"";
		String querySQL=hqlParser(HQL);
		if(EnvContext.getDataAuthorityTaskId()!=null){
			querySQL=dataRuleStringCreat.editSqlQueryRule(querySQL);
		}
		final String queryfnSQL=querySQL;
		return getHibernateTemplate().executeWithNativeSession(new HibernateCallback<List<T>>() {
			@SuppressWarnings("unchecked")
			public List<T> doInHibernate(Session session) throws HibernateException {
				SQLQuery query = session.createSQLQuery(queryfnSQL);
	    		query.addEntity(entityClass);
				return query.list();
			}
		});
	}
	
	void prepareCriteria(Criteria criteria) {
		if (getHibernateTemplate().isCacheQueries()) {
			criteria.setCacheable(true);
			if (getHibernateTemplate().getQueryCacheRegion() != null) {
				criteria.setCacheRegion(getHibernateTemplate().getQueryCacheRegion());
			}
		}
		if (getHibernateTemplate().getFetchSize() > 0) {
			criteria.setFetchSize(getHibernateTemplate().getFetchSize());
		}
		if (getHibernateTemplate().getMaxResults() > 0) {
			criteria.setMaxResults(getHibernateTemplate().getMaxResults());
		}
		SessionFactoryUtils.applyTransactionTimeout(criteria, getSessionFactory());
	}
	
}
