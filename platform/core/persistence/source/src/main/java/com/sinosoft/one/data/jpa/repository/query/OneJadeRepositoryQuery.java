package com.sinosoft.one.data.jpa.repository.query;

import com.sinosoft.one.data.jade.context.JadeInvocationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.QueryMethod;
import org.springframework.data.repository.query.RepositoryQuery;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-8-10
 * Time: 上午10:05
 * To change this template use File | Settings | File Templates.
 */
public class OneJadeRepositoryQuery implements RepositoryQuery {
    private static final Logger LOG = LoggerFactory.getLogger(OneJadeRepositoryQuery.class);
    private OneJadeQueryMethod oneJadeQueryMethod;
    private EntityManager em;
    private String sql;
    private JadeInvocationHandler handler;




    public void setHandler(JadeInvocationHandler handler) {
        this.handler = handler;
    }

    public OneJadeRepositoryQuery(OneJadeQueryMethod oneJadeQueryMethod, EntityManager em, String sql) {
        this.oneJadeQueryMethod = oneJadeQueryMethod;
        this.em = em;
        this.sql = sql;
    }

    public Object execute(Object[] parameters) {
        try {
            return handler.invoke(new Object(), oneJadeQueryMethod.getMethod(), parameters);
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public QueryMethod getQueryMethod() {
        return null;
    }

    public static RepositoryQuery fromSQLAnnotation(OneJadeQueryMethod queryMethod, EntityManager em) {
        LOG.debug("Looking up query for method {}", queryMethod.getName());

        String sql = queryMethod.getAnnotatedSQL();

        return sql == null ? null : new OneJadeRepositoryQuery(queryMethod, em, sql);
    }
}
