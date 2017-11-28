package org.springframework.data.jpa.repository.query;

import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.query.QueryMethod;

import java.lang.reflect.Method;

/**
 * @author Chunliang.Han on 2017/11/28.
 */
public class OneDataQueryMethod extends QueryMethod {

  /**
   * Creates a new {@link QueryMethod} from the given parameters. Looks up the correct query to use
   * for following invocations of the method given.
   *
   * @param method   must not be {@literal null}.
   * @param metadata must not be {@literal null}.
   * @param factory  must not be {@literal null}.
   */
  public OneDataQueryMethod(Method method,
                            RepositoryMetadata metadata,
                            ProjectionFactory factory) {
    super(method, metadata, factory);
  }

  @Override
  public Class<?> getDomainClass() {
    return super.getDomainClass();
  }
}
