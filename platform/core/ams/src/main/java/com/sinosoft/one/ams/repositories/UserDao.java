package com.sinosoft.one.ams.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.Employe;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface UserDao extends PagingAndSortingRepository<Employe, String>{
	
	@SQL("select * from GE_RMS_EMPLOYE where username=?1")
	Employe findByUsername(String userName);
	
	@SQL("select * from GE_RMS_EMPLOYE where userCode = ?1")
	Employe findByUserCode(String userCode);
	
	//根据userCode查询User
	@SQL("select * from GE_RMS_EMPLOYE where userCode like ?1")
	Page<Employe> searchUserByUserCode(String userCode,Pageable pageable);
	
	//根据comCode查询User
	@SQL("select * from GE_RMS_EMPLOYE where comCode like ?1")
	Page<Employe> searchUserByComCode(String comCode,Pageable pageable);

	@SQL("select * from GE_RMS_EMPLOYE where comCode = ?1 and userCode = ?2")
	Page<Employe> searchUserByComCodeUserCode(String comCode,String userCode,Pageable pageable);
	
	//根据用户名进行模糊查询
	@SQL("select * from GE_RMS_EMPLOYE where username like ?1 and usercode in (select userCode from GE_RMS_USERGROUP where groupId = ?2)")
	Page<Employe> searchUserByUserName(String userName,String groupId ,Pageable pageable);
	
	//根据用户名和用户ID进行模糊查询
	@SQL("select * from GE_RMS_EMPLOYE where username like ?1 and userCode like ?2 and usercode in (select userCode from GE_RMS_USERGROUP where groupId = ?3)")
	Page<Employe> searchUserByNameCode(String userName,String userCode,String groupId,Pageable pageable);
	
	//-------------hening
	
	//根据userCode查询User，模糊查询
	@SQL("select * from GE_RMS_EMPLOYE where userCode like ?1")
	Page<Employe> findUserByUserCode(String userCode,Pageable pageable);

	//根据comCode查询User，模糊查询
	@SQL("select * from GE_RMS_EMPLOYE where comCode like ?1")
	Page<Employe> findUserByComCode(String comCode,Pageable pageable);
	
	//根据机构ID和用户ID查询用户，模糊查询
	@SQL("select * from GE_RMS_EMPLOYE where comCode like ?1 and userCode like ?2")
	Page<Employe> findUserByComCodeUserCode(String comCode,String userCode,Pageable pageable);
	
	//根据用户ID查询机构ID
	@SQL("select comcode from GE_RMS_EMPLOYE where userCode = ?1")
	String findComCodeByUserCode(String userCode);
}
