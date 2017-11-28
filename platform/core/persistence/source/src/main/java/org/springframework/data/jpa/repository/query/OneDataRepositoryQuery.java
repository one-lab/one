package org.springframework.data.jpa.repository.query;

import com.sinosoft.one.data.jade.context.JadeInvocationHandler;

import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.query.QueryMethod;
import org.springframework.data.repository.query.RepositoryQuery;

import java.lang.reflect.Method;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA. User: carvin Date: 12-8-10 Time: 上午10:05 To change this template use
 * File | Settings | File Templates.
 */
public class OneDataRepositoryQuery implements RepositoryQuery {

  private Method method;
  private JadeInvocationHandler handler;
  private OneDataQueryMethod queryMethod;

  public OneDataRepositoryQuery(Method method,
                                RepositoryMetadata metadata,
                                ProjectionFactory factory,
                                EntityManager em) {
    this.method = method;
    this.queryMethod = new OneDataQueryMethod(method, metadata, factory);
    this.handler = new JadeInvocationHandler(method, em);
  }

  public Object execute(Object[] parameters) {
    try {
      return handler.invoke(new Object(), method, parameters);
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
  }

  public QueryMethod getQueryMethod() {
    return queryMethod;
  }
}
