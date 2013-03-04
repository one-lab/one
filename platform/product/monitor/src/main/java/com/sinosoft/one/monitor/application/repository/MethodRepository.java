package com.sinosoft.one.monitor.application.repository;
// Generated 2013-2-27 18:41:37 by One Data Tools 1.0.0

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.application.model.Method;
import com.sinosoft.one.mvc.web.annotation.Param;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MethodRepository extends PagingAndSortingRepository<Method, String> {

    Method findByMethodName(String methodName);

    @SQL("select * from GE_MONITOR_METHOD a where a.ID in (select b.METHOD_ID from GE_MONITOR_URL_METHOD b right join GE_MONITOR_URL c on b.URL_ID=?1)")
    List<Method> selectMethodsOfUrlById(@Param("urlId") String urlId);

    /*@SQL("update GE_MONITOR_METHOD set CLASS_NAME=:className,METHOD_NAME=:methodName,DESCRIPTION=:description,MODIFIER_ID=:modifierId,MODIFY_TIME=sysdate where id=:methodId")
    void updateMethod(@Param("methodId") String methodId,@Param("className") String className, @Param("methodName") String methodName, @Param("description") String description, @Param("modifierId") String modifierId, @Param("modifyTime") Date modifyTime);*/

    @SQL("update GE_MONITOR_METHOD set CLASS_NAME=?2,METHOD_NAME=?3,DESCRIPTION=?4,MODIFIER_ID=?5,MODIFY_TIME=sysdate where id=?1")
    void updateMethod(@Param("methodId") String methodId,@Param("className") String className, @Param("methodName") String methodName, @Param("description") String description, @Param("modifierId") String modifierId);

    @SQL("delete GE_MONITOR_URL_METHOD a where a.URL_ID=?1 and a.METHOD_ID=?2")
    void deleteUrlAndMethod(String urlId, String methodId);

    @SQL("delete GE_MONITOR_URL_METHOD a where a.URL_ID=?1 and a.METHOD_ID in (?2)")
    void batchDeleteUrlAndMethod(String urlId, String[] methodIds);

    @SQL("delete GE_MONITOR_METHOD a where a.ID in (?1)")
    void batchDeleteMethod(String[] methodIds);
}

