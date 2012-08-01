/**
 * 
 */
package com.sinosoft.one.demo.dao.account;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.demo.model.account.UserInfo;

/**
 * @author seline
 *
 */
public interface UserInfoDao extends PagingAndSortingRepository<UserInfo,Long> {
	public UserInfo findByUserId(long userId);

}
