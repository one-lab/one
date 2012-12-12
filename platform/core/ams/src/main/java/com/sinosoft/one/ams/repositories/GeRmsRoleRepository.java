package com.sinosoft.one.ams.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.Role;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsRoleRepository extends PagingAndSortingRepository<Role, String> {

	@SQL("select * from GE_RMS_ROLE where name like ?1")
	Page<Role> findRoleByName(String name, Pageable pageable);
	
	@SQL("select * from GE_RMS_ROLE where roleId in(select roleId from GE_RMS_GROUPROLE where groupId = ?1)")
	List<Role> findRoleByGroupId(String groupId);

	@SQL("select * from GE_RMS_ROLE where roleId in (select roleid from GE_RMS_ROLE_DESIGNATE where comCode= ?1 or comCode='*')")
	Page<Role> findRole(String comCode,Pageable pageable);
	
	@SQL("select * from GE_RMS_ROLE where roleId in (select roleid from GE_RMS_ROLE_DESIGNATE where comCode= ?1 or comCode='*') and name like ?2")
	Page<Role> findRoleByName(String comCode,String name,Pageable pageable);
	
	@SQL("select comCode from GE_RMS_ROLE_DESIGNATE where roleId = ?1")
	List<String> findRoleTypById(String roleId);
	
	@SQL("delete GE_RMS_ROLETASK t where t.roleID=?1 and t.taskAuthid in (select taskauthid from ge_rms_task_auth a where a.comCode='*' or a.comcode=?2)")
	void deleteRoleTask(String roleId,String comCode);
	
	
}
