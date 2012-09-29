package com.sinosoft.one.rms.client.annotation;

import com.sinosoft.one.rms.client.EnvContext;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * rms client annotation aspect
 * User: ChengQi
 * Date: 3/22/12
 * Time: 11:08 AM
 */
@Aspect
@Component
public class RmsAnnotationAspect {


    @Around("execution(* com.sinosoft.*..*.*(..))&&@annotation(DataAuthority)")
    Object register(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method m = signature.getMethod();
        if( Proxy.isProxyClass(pjp.getThis().getClass())) {
            m = pjp.getTarget().getClass().getMethod(m.getName(), m.getParameterTypes());
        }
        DataAuthority dataAuthority = m.getAnnotation(DataAuthority.class);
        EnvContext.setDataAuthorityTaskId(dataAuthority.value());
        EnvContext.setHqlModelClassName(dataAuthority.hqlMod());
        EnvContext.setTableAlias(dataAuthority.tabAlias());
        return pjp.proceed();
    }
}
