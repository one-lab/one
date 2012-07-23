package com.sinosoft.ebusiness.rms.client;

import com.sinosoft.ebusiness.rms.client.annotation.DataAuthority;
import com.sinosoft.ebusiness.rms.client.annotation.RmsAnnotationAspect;
import com.sinosoft.ebusiness.rms.client.arch4.RmsGenericDaoHibernate;

import ins.framework.common.QueryRule;
import org.springframework.stereotype.Component;

import javax.management.Query;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ChengQi
 * Date: 3/22/12
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class AnnotationTestService extends RmsGenericDaoHibernate implements TestService{


    @Override
    @DataAuthority(value = "task1")
    public List findUser() {
        QueryRule queryRule = QueryRule.getInstance();
        return super.find(queryRule);
    }
}
