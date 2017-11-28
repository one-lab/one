package org.springframework.data.jpa.repository.support;

import org.springframework.data.jpa.repository.query.OneDataJpaQueryLookupStrategy;

import org.springframework.data.jpa.provider.PersistenceProvider;
import org.springframework.data.jpa.provider.QueryExtractor;
import org.springframework.data.repository.query.EvaluationContextProvider;
import org.springframework.data.repository.query.QueryLookupStrategy;

import javax.persistence.EntityManager;

/**
 * @author Chunliang.Han on 2017/11/28.
 */
public class OneDataJpaRepositoryFactory extends JpaRepositoryFactory {

  private final EntityManager entityManager;
  private final QueryExtractor extractor;

  /**
   * Creates a new {@link JpaRepositoryFactory}.
   *
   * @param entityManager must not be {@literal null}
   */
  public OneDataJpaRepositoryFactory(EntityManager entityManager) {
    super(entityManager);
    this.entityManager = entityManager;
    this.extractor = PersistenceProvider.fromEntityManager(entityManager);
  }

  @Override
  protected QueryLookupStrategy getQueryLookupStrategy(QueryLookupStrategy.Key key, EvaluationContextProvider evaluationContextProvider) {
    return OneDataJpaQueryLookupStrategy.create(entityManager, key, extractor, evaluationContextProvider);
  }
}
