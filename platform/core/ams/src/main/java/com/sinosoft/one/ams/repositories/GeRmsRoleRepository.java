package com.sinosoft.one.ams.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.GeRmsRole;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsRoleRepository extends PagingAndSortingRepository<GeRmsRole, String> {

	@SQL("select * from GE_RMS_ROLE where roleId = ?1")
	GeRmsRole findRoleById(String roleId);
	
	@SQL("select * from GE_RMS_ROLE where name like ?1")
	Page<GeRmsRole> findRoleByName(String name, Pageable pageable);
	
	@SQL("select * from GE_RMS_ROLE where roleId in(select roleId from GE_RMS_GROUPROLE where groupId = ?1)")
	List<GeRmsRole> findRoleByGroupId(String groupId);

	@SQL("select * from GE_RMS_ROLE where roleId in (select roleid from GE_RMS_ROLE_DESIGNATE where comCode= ?1 or comCode='*')")
	Page<GeRmsRole> findRole(String comCode,Pageable pageable);
	
	@SQL("select * from GE_RMS_ROLE where roleId in (select roleid from GE_RMS_ROLE_DESIGNATE where comCode= ?1 or comCode='*') and name like ?2")
	Page<GeRmsRole> findRoleByName(String comCode,String name,Pageable pageable);
	
	@SQL("select comCode from GE_RMS_ROLE_DESIGNATE where roleId = ?1")
	List<String> findRoleTypById(String roleId);
}
