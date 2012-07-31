package com.sinosoft.platform.platformDemo.utils;

import org.hibernate.ejb.HibernatePersistence;

import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceProviderResolver;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-7-30
 * Time: 下午9:12
 * To change this template use File | Settings | File Templates.
 */
public class OnePersistenceProviderResolver implements PersistenceProviderResolver {
    private List<PersistenceProvider> providers = new ArrayList();
    public List<PersistenceProvider> getPersistenceProviders() {
        providers.add(new HibernatePersistence());
        return providers;
    }

    public void clearCachedProviders() {

    }
}
