package com.sinosoft.one.data.jpa.repository.support;

import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;

import javax.persistence.metamodel.SingularAttribute;
import java.io.Serializable;

/**
 * User: Chunliang.Han
 * Time: 12-9-4[下午7:18]
 */
public class OneJadeEntityInformation<T, ID extends Serializable> extends JpaEntityInformationSupport<T, ID> {
    public OneJadeEntityInformation(Class<T> domainClass) {

        super(domainClass);
    }
    public SingularAttribute getIdAttribute() {
        return null;
    }

    public Serializable getId(Object entity) {
        return null;
    }

    public Class getIdType() {
        return null;
    }
}
