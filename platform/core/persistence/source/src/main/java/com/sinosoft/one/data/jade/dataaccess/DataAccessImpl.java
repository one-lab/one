/*
 * Copyright 2009-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License i distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sinosoft.one.data.jade.dataaccess;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.KeyHolder;

import javax.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author 王志亮 [qieqie.wang@gmail.com]
 * @author 廖涵 [in355hz@gmail.com]
 */
public class DataAccessImpl implements DataAccess {

    private final EntityManager em;
    public DataAccessImpl(EntityManager em) {
        this.em = em;
    }

    //修改成em的方法
    public<T> List<T> select(final String sql,final  Object[] args,final  RowMapper rowMapper) {
        Session session = em.unwrap(Session.class);
        final List<T> results = new ArrayList<T>();
		session.doWork(new Work() {
			public void execute(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = null;
				if (args != null) {
				    for (int i = 0; i < args.length; i++) {
				        Object arg = args[i];
				        if (arg instanceof SqlParameterValue) {
				            SqlParameterValue paramValue = (SqlParameterValue) arg;
				            StatementCreatorUtils.setParameterValue(ps, i + 1, paramValue,
				                    paramValue.getValue());
				        } else {
				            StatementCreatorUtils.setParameterValue(ps, i + 1,
				                    SqlTypeValue.TYPE_UNKNOWN, arg);
				        }
				    }
				}
				int rowNum = 0;
				rs = ps.executeQuery();
				while (rs.next()) {
					results.add((T) rowMapper.mapRow(rs, rowNum++)) ;
				}
			}
		});
        return results;
    }

    //修改成em的方法
    public int update(final String sql, final Object[] args, KeyHolder generatedKeyHolder) {
    	 final boolean returnKeys = generatedKeyHolder != null;
    	 Session session = (Session) em.getDelegate();
    	 final List<Integer> results = new ArrayList<Integer>(1);
    	 Work work = new Work() {
  			public void execute(Connection con) throws SQLException {
  				PreparedStatement ps = con.prepareStatement(sql);
  				 if (returnKeys) {
                      ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                  } else {
                      ps = con.prepareStatement(sql);
                  }
  				if (args != null) {
  				    for (int i = 0; i < args.length; i++) {
  				        Object arg = args[i];
  				        if (arg instanceof SqlParameterValue) {
  				            SqlParameterValue paramValue = (SqlParameterValue) arg;
  				            StatementCreatorUtils.setParameterValue(ps, i + 1, paramValue,
  				                    paramValue.getValue());
  				        } else {
  				            StatementCreatorUtils.setParameterValue(ps, i + 1,
  				                    SqlTypeValue.TYPE_UNKNOWN, arg);
  				        }
  				    }
  				}
  				results.add(ps.executeUpdate());
  			}
  		};
  		session.doWork(work);
  		Integer r = results.get(0);
    	return (r==null) ? -1:r ;
    }
    // TODO: 批量处理
    public int[] batchUpdate(String sql, List<Object[]> argsList) {
        int[] updated = new int[argsList.size()];
        int i = 0;
        for (Object[] args : argsList) {
            updated[i++] = update(sql, args, null);
        }
        return updated;
    }

    private PreparedStatementCreator getPreparedStatementCreator(//
            final String sql, final Object[] args, final boolean returnKeys) {
        PreparedStatementCreator creator = new PreparedStatementCreator() {

            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql);
                if (returnKeys) {
                    ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                } else {
                    ps = con.prepareStatement(sql);
                }

                if (args != null) {
                    for (int i = 0; i < args.length; i++) {
                        Object arg = args[i];
                        if (arg instanceof SqlParameterValue) {
                            SqlParameterValue paramValue = (SqlParameterValue) arg;
                            StatementCreatorUtils.setParameterValue(ps, i + 1, paramValue,
                                    paramValue.getValue());
                        } else {
                            StatementCreatorUtils.setParameterValue(ps, i + 1,
                                    SqlTypeValue.TYPE_UNKNOWN, arg);
                        }
                    }
                }
                return ps;
            }
        };
        return creator;
    }

    //    //TODO: 实现批量更新
    //    @Override
    //    public int[] batchUpdate(String sql, StatementMetaData modifier,
    //            List<Map<String, Object>> parametersList) {
    //        // 以com.xiaonei.in.dao为试点测试真正的批量插入、更新，不支持返回可能的自增主键
    //        // 2010-10-20
    //        //        if (modifier.getDefinition().getDAOClazz().getName().startsWith("com.xiaonei.in.dao")) {
    //        //return batchUpdate2(sql, modifier, parametersList);
    //        //        } else {
    //        return batchUpdate1(sql, modifier, parametersList);
    //        //        }
    //    }

    //    private int[] batchUpdate1(String sql, StatementMetaData modifier,
    //            List<Map<String, Object>> parametersList) {
    //        int[] updated = new int[parametersList.size()];
    //        for (int i = 0; i < updated.length; i++) {
    //            Map<String, Object> parameters = parametersList.get(i);
    //            SQLThreadLocal.set(SQLType.WRITE, sql, modifier, parameters);
    //            updated[i] = update(sql, modifier, parameters);
    //            SQLThreadLocal.remove();
    //        }
    //        return updated;
    //    }

    //    private int[] batchUpdate2(String sql, Modifier modifier,
    //            List<Map<String, Object>> parametersList) {
    //        if (parametersList.size() == 0) {
    //            return new int[0];
    //        }
    //        // sql --> args[]
    //        HashMap<String, List<Object[]>> batches = new HashMap<String, List<Object[]>>();
    //        // sql --> named args
    //        HashMap<String, List<Map<String, Object>>> batches2 = new HashMap<String, List<Map<String, Object>>>();
    //        // sql --> [2,3,6,9] positions of parametersList
    //        Map<String, List<Integer>> positions = new HashMap<String, List<Integer>>();
    //
    //        for (int i = 0; i < parametersList.size(); i++) {
    //            SQLInterpreterResult ir = interpret(sql, modifier, parametersList.get(i));
    //            List<Object[]> args = batches.get(ir.getSQL());
    //            List<Integer> position = positions.get(ir.getSQL());
    //            List<Map<String, Object>> maplist = batches2.get(ir.getSQL());
    //            if (args == null) {
    //                args = new LinkedList<Object[]>();
    //                batches.put(ir.getSQL(), args);
    //                position = new LinkedList<Integer>();
    //                positions.put(ir.getSQL(), position);
    //                maplist = new LinkedList<Map<String, Object>>();
    //                batches2.put(ir.getSQL(), maplist);
    //            }
    //            position.add(i);
    //            args.add(ir.getParameters());
    //            maplist.add(parametersList.get(i));
    //        }
    //        if (batches.size() == 1) {
    //            SQLThreadLocal.set(SQLType.WRITE, sql, modifier, parametersList);
    //            int[] updated = jdbc.batchUpdate(modifier, batches.keySet().iterator().next(), batches
    //                    .values().iterator().next());
    //            SQLThreadLocal.remove();
    //            return updated;
    //        }
    //        int[] batchUpdated = new int[parametersList.size()];
    //        for (Map.Entry<String, List<Object[]>> batch : batches.entrySet()) {
    //            String batchSQL = batch.getKey();
    //            List<Object[]> values = batch.getValue();
    //            List<Map<String, Object>> map = batches2.get(batchSQL);
    //            SQLThreadLocal.set(SQLType.WRITE, sql, modifier, map);
    //            int[] updated = jdbc.batchUpdate(modifier, batchSQL, values);
    //            SQLThreadLocal.remove();
    //            List<Integer> position = positions.get(batchSQL);
    //            int i = 0;
    //            for (Integer p : position) {
    //                batchUpdated[p] = updated[i++];
    //            }
    //        }
    //        return batchUpdated;
    //
    //    }

    //    protected InterpreterOutput interpret(String jadeSQL, StatementMetaData modifier,
    //            Map<String, Object> parametersAsMap) {
    //
    //        //
    //        StatementRuntimeImpl result = null;
    //        // 
    //        for (Interpreter interpreter : interpreters) {
    //            String sql = (result == null) ? jadeSQL : result.getSQL();
    //            Object[] parameters = (result == null) ? null : result.getParameters();
    //            InterpreterOutput t = interpreter.interpret(dataSource, sql, modifier, parametersAsMap,
    //                    parameters);
    //            if (t != null) {
    //                if (result == null) {
    //                    result = new StatementRuntimeImpl();
    //                }
    //                if (t.getSQL() != null) {
    //                    result.setSQL(t.getSQL());
    //                }
    //                if (t.getParameters() != null) {
    //                    result.setParameters(t.getParameters());
    //                }
    //                if (t.getClientInfo() != null) {
    //                    result.setClientInfo(t.getClientInfo());
    //                }
    //            }
    //        }
    //        // path、catalog、node
    //        Method daoMethod = modifier.getMethod();
    //        Class<?> daoClass = daoMethod.getClass();
    //        DAO dao = daoClass.getAnnotation(DAO.class);
    //
    //        result.setClientInfo(RoutingConnection.PATH, daoClass.getName());
    //
    //        // catalog
    //        if (result.getClientInfo(RoutingConnection.CATALOG) == null) {
    //            if (dao.catalog() != null && dao.catalog().length() > 0) {
    //                result.setClientInfo(RoutingConnection.CATALOG, dao.catalog());
    //            }
    //        }
    //
    //        // node
    //        if (result.getClientInfo(RoutingConnection.NODE) == null) {
    //            UseMaster useMaster = daoMethod.getAnnotation(UseMaster.class);
    //            if (useMaster != null) {
    //                if (useMaster.value()) {
    //                    result.setClientInfo(RoutingConnection.NODE, "master");
    //                } else {
    //                    result.setClientInfo(RoutingConnection.NODE, "slave");
    //                }
    //            }
    //        }
    //        //
    //        return result;
    //    }

}
