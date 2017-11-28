package org.springframework.data.jpa.repository.config;

import org.springframework.data.repository.config.RepositoryBeanDefinitionRegistrarSupport;
import org.springframework.data.repository.config.RepositoryConfigurationExtension;

import java.lang.annotation.Annotation;

/**
 * @author Chunliang.Han on 2017/11/28.
 */
public class OneDataJpaRepositoriesRegistrar extends RepositoryBeanDefinitionRegistrarSupport {

  @Override
  protected Class<? extends Annotation> getAnnotation() {
    return EnableOneDataJpaRepositories.class;
  }

  @Override
  protected RepositoryConfigurationExtension getExtension() {
    return new OneDataJpaRepositoryConfigExtension();
  }
}
