package com.sinosoft.ams.user_group.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.ams.user_group.model.User;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface UserDao extends PagingAndSortingRepository<User, String>{
	
	@SQL("select * from GE_RMS_EMPLOYE where username=?1")
	User findByUsername(String userName);
	
	@SQL("select * from GE_RMS_EMPLOYE where userCode = ?1")
	User findByUserCode(String userCode);
	
	@SQL("select * from GE_RMS_EMPLOYE")
	Page<User> findAll(Pageable pageable);
	
	@SQL("select * from GE_RMS_EMPLOYE where userCode like ?1")
	Page<User> searchByUserCode(String userCode,Pageable pageable);
	
	@SQL("select * from GE_RMS_EMPLOYE where comCode like ?1")
	Page<User> searchByComCode(String comCode,Pageable pageable);

	@SQL("select * from GE_RMS_EMPLOYE where comCode = ?1 and userCode = ?2")
	Page<User> searchByComCodeUserCode(String comCode,String userCode,Pageable pageable);
	
	@SQL("select * from GE_RMS_EMPLOYE where username like ?1")
	Page<User> searchByUserName(String userName,Pageable pageable);
	
	@SQL("select * from GE_RMS_EMPLOYE where username like ?1 and userCode like ?2")
	Page<User> searchByNameCode(String userName,String userCode,Pageable pageable);
}
