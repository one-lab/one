package com.sinosoft.one.ams.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.UserGroup;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsUserGroupRepository extends PagingAndSortingRepository<UserGroup, String>{
	
}
