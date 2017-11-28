package org.springframework.data.jpa.repository.config;

import org.springframework.data.jpa.repository.support.OneDataJpaRepositoryFactoryBean;

/**
 * @author Chunliang.Han on 2017/11/28.
 */
public class OneDataJpaRepositoryConfigExtension extends JpaRepositoryConfigExtension {
  public String getRepositoryFactoryClassName() {
    return OneDataJpaRepositoryFactoryBean.class.getName();
  }
}
