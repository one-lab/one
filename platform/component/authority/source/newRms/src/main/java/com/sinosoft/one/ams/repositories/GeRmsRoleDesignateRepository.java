package com.sinosoft.one.ams.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.RoleDesignate;
import com.sinosoft.one.ams.model.RoleDesignateId;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsRoleDesignateRepository  extends PagingAndSortingRepository<RoleDesignate, RoleDesignateId>{

	//根据机构ID查询角色ID
	@SQL("select roleid from GE_RMS_ROLE_DESIGNATE where comCode in (?1,'*')")
	List<String> findRoleIdByComCode(String comCode);
	
	//根据机构ID,分页查询角色指派
	@SQL("select * from GE_RMS_ROLE_DESIGNATE where comCode= ?1")
	Page<RoleDesignate> findRoleDesignateByComCode(String comCode,Pageable pageable);
	
	//根据机构ID，取得角色指派集合
	@Query("from RoleDesignate where id.comCode= ?1")
	List<RoleDesignate> findRoleDesignateByComCodeQuery(String comCode);
	
	//根绝机构ID和角色Id删除记录
	@SQL("delete from GE_RMS_ROLE_DESIGNATE where comCode = ?1 and roleId = ?2")
	void delete(String comCode,String roleId);
	
	//根据角色ID查询指派，判断类型
	@SQL("select count(*) from GE_rms_Role_designate where roleid= ?1 or comCode='*'")
	int findRoleDesignateByRoleId(String roleId);
}
