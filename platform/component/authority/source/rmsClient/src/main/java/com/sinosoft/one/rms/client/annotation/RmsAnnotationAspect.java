package com.sinosoft.one.rms.client.annotation;

import com.sinosoft.one.rms.client.EnvContext;

import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import ins.framework.cache.CacheManager;
import ins.framework.cache.CacheService;
import ins.framework.common.Page;
import ins.framework.dao.GenericDaoHibernate;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * rms client annotation aspect
 * User: ChengQi
 * Date: 3/22/12
 * Time: 11:08 AM
 */
@Aspect
@Component
public class RmsAnnotationAspect {

	private static CacheService arch4MethodNameCacheManager = CacheManager.getInstance("arch4Method");
	
    @Around("execution(* com.sinosoft.ebusiness..*.*(..))&&@annotation(DataAuthority)")
    Object register(ProceedingJoinPoint pjp) throws Throwable {
    	String key = arch4MethodNameCacheManager.generateCacheKey("arch4Method", "arch4Method");
		Object result = arch4MethodNameCacheManager.getCache(key);
		Set<String> arch4MethodNames ;
		if (result != null) {
			arch4MethodNames=(HashSet<String>)result;
		}else{
			arch4MethodNames=new HashSet<String>();
			arch4MethodNames.add("findUnionBySql");
			arch4MethodNames.add("findUnionByHqls");
			arch4MethodNames.add("findByHqlNoLimit");
			arch4MethodNames.add("getAll");
			arch4MethodNames.add("findUnique");
			arch4MethodNames.add("isOptimizeFind");
			arch4MethodNames.add("findTopByHql");
			arch4MethodNames.add("findByHql");
			arch4MethodNames.add("findBySql");
			arch4MethodNames.add("find");
			for (String string : arch4MethodNames) {
				System.out.println(string);
			}
			arch4MethodNameCacheManager.putCache(key, arch4MethodNames);
		}
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method m = signature.getMethod();
        if( Proxy.isProxyClass(pjp.getThis().getClass())) {
            m = pjp.getTarget().getClass().getMethod(m.getName(), m.getParameterTypes());
        }
        System.out.println(pjp.getTarget().getClass().toString()+"-----------------------"+m.getName());
        DataAuthority dataAuthority = m.getAnnotation(DataAuthority.class);
//        if(m.getName().toString().endsWith("testFindByHqlforList")){
//        	System.out.println("testFindTopByHql+++++++++++++++++++++++++++++");
//        }
        Object object=null;
        String tempDataAuthorityTaskId=null;
        if(dataAuthority!=null){
        	EnvContext.setClassName(pjp.getTarget().getClass().getName());
        	System.out.println(pjp.getTarget().getClass().getName());
        	EnvContext.setDataAuthorityTaskId(dataAuthority.value());
        	EnvContext.setMethodName(m.getName());
        	EnvContext.setTableAlias(dataAuthority.tabAlias());
        	object=pjp.proceed();
        	EnvContext.removeDataAuthorityTaskId();
        	EnvContext.removeTableAlias();
        	EnvContext.removeClassName();
        	EnvContext.removeMethodName();
        }else {
        	if(EnvContext.getDataAuthorityTaskId()!=null){
        		if(pjp.getTarget().getClass().getName().toString().equals(pjp.getTarget().getClass().getName().toString())){
        			for (String methodName : arch4MethodNames) {
						if(methodName.equals(m.getName())){
							return pjp.proceed();
						} 
					}
        			tempDataAuthorityTaskId=EnvContext.getDataAuthorityTaskId();
					object=pjp.proceed();
					EnvContext.setDataAuthorityTaskId(tempDataAuthorityTaskId);
					return object;
        		}else {
        			tempDataAuthorityTaskId=EnvContext.getDataAuthorityTaskId();
					object=pjp.proceed();
					EnvContext.setDataAuthorityTaskId(tempDataAuthorityTaskId);
					return object;
				}
        	}else {
        		return pjp.proceed();
			}
		}
        return object;
    }
}
