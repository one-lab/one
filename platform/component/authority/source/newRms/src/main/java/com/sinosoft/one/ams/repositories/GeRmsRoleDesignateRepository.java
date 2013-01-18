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

	@SQL("select roleid from GE_RMS_ROLE_DESIGNATE where comCode in (?1,'*')")
	List<String> findRoleIdByComCode(String comCode);
	
	@SQL("select * from GE_RMS_ROLE_DESIGNATE where comCode= ?1")
	Page<RoleDesignate> findRoleDesignateByComCode(String comCode,Pageable pageable);
	
	@Query("from RoleDesignate where id.comCode= ?1")
	List<RoleDesignate> findRoleDesignateByComCodeQuery(String comCode);
}
