package org.springframework.data.jpa.repository.support;

import org.springframework.data.repository.core.support.OneDataTransactionalRepositoryFactoryBeanSupport;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.util.Assert;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Chunliang.Han on 2017/11/28.
 */
public class OneDataJpaRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable>
    extends OneDataTransactionalRepositoryFactoryBeanSupport<T, S, ID> {

  private EntityManager entityManager;

  /**
   * Creates a new {@link JpaRepositoryFactoryBean} for the given repository interface.
   *
   * @param repositoryInterface must not be {@literal null}.
   */
  public OneDataJpaRepositoryFactoryBean(Class repositoryInterface) {
    super(repositoryInterface);
  }

  /**
   * The {@link EntityManager} to be used.
   *
   * @param entityManager the entityManager to set
   */
  @PersistenceContext
  public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  /*
   * (non-Javadoc)
   * @see org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport#setMappingContext(org.springframework.data.mapping.context.MappingContext)
   */
  @Override
  public void setMappingContext(MappingContext<?, ?> mappingContext) {
    super.setMappingContext(mappingContext);
  }

  /*
   * (non-Javadoc)
   *
   * @see org.springframework.data.repository.support.
   * TransactionalRepositoryFactoryBeanSupport#doCreateRepositoryFactory()
   */
  @Override
  protected RepositoryFactorySupport doCreateRepositoryFactory() {
    return createRepositoryFactory(entityManager);
  }

  /**
   * todo one-data modify
   * Returns a {@link RepositoryFactorySupport}.
   *
   * @param entityManager
   * @return
   */
  protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
    return new OneDataJpaRepositoryFactory(entityManager);
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
   */
  @Override
  public void afterPropertiesSet() {

    Assert.notNull(entityManager, "EntityManager must not be null!");
    super.afterPropertiesSet();
  }
}
