package org.springframework.data.jpa.repository.support;

import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;

/**
 * @author Chunliang.Han on 2017/11/28.
 */
public class OneDataJpaRepositoryFactoryBean extends JpaRepositoryFactoryBean {

  /**
   * Creates a new {@link JpaRepositoryFactoryBean} for the given repository interface.
   *
   * @param repositoryInterface must not be {@literal null}.
   */
  public OneDataJpaRepositoryFactoryBean(Class repositoryInterface) {
    super(repositoryInterface);
  }

  protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
    return new OneDataJpaRepositoryFactory(entityManager);
  }
}
