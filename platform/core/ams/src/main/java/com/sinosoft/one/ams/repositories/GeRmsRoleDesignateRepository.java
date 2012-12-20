package com.sinosoft.one.ams.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.Group;
import com.sinosoft.one.ams.model.RoleDesignate;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsRoleDesignateRepository  extends PagingAndSortingRepository<RoleDesignate, String>{

	@SQL("select roleid from GE_RMS_ROLE_DESIGNATE where comCode= ?1")
	List<String> findRoleIdByComCode(String comCode);
}
