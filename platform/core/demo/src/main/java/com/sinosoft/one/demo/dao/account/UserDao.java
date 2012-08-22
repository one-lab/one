package com.sinosoft.one.demo.dao.account;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.demo.model.account.User;

/**
 * 用户对象的Dao interface.
 * 
 * @author calvin
 */
public interface UserDao extends PagingAndSortingRepository<User, Long> {

	User findByLoginName(String loginName);
}
