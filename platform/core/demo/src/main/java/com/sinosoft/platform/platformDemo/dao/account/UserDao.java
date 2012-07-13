package com.sinosoft.platform.platformDemo.dao.account;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.platform.platformDemo.model.account.User;

/**
 * 用户对象的Dao interface.
 * 
 * @author calvin
 */
public interface UserDao extends PagingAndSortingRepository<User, Long> {

	User findByLoginName(String loginName);
}
