package com.sinosoft.one.ams.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.ams.model.Group;
import com.sinosoft.one.data.jade.annotation.SQL;

public interface GeRmsGroupRepository extends PagingAndSortingRepository<Group, String>{
	
	@SQL("select * from GE_RMS_GROUP where name like ?1")
	Page<Group> findGroupByName(String name,Pageable pageable);
	
	@SQL("select * from GE_RMS_GROUP where groupId = ?1")
	Group findGroupByGroupId(String groupId);
	
	@SQL("select * from GE_RMS_GROUP where isvalidate = '1'")
	Page<Group> findAllGroup(Pageable pageable);
	
	@SQL("update GE_RMS_GROUP set isvalidate='0' where groupid = ?1")
	void updateIsvalidateByGroupId(String groupId);
	
	@SQL("update GE_RMS_GROUP set name = ?1 ,des = ?2 where groupId = ?3")
	void updateGroup(String name,String des,String groupId);
	
	@SQL("insert into GE_RMS_GROUP values(?1,?2,?3,?4,'1','',?5,?6,'','')")
	void insertGroup(String groupId,String name,String des,String comcode,Date createTime,String createUser);
	

	
	
	//----------------------------------------//
	@SQL("select * from GE_RMS_GROUP where comCode = ?1")
	Page<Group> findGroup(String comCode ,Pageable pageable);
	
	@SQL("select * from GE_RMS_GROUP where comCode = ?1 and name like ?2")
	Page<Group> findGroupByName(String comCode ,String name,Pageable pageable);
	
	@SQL("select groupid from GE_RMS_GROUP where name =?1 and comcode=?2 ")
	String findGroupIdbyName(String name,String comCode);
	

	
}
