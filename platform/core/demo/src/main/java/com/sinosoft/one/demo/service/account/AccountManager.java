package com.sinosoft.one.demo.service.account;

import java.util.List;

import com.mysema.query.types.expr.BooleanExpression;
import com.sinosoft.one.demo.dao.account.GroupDao;
import com.sinosoft.one.demo.dao.account.UserDao;
import com.sinosoft.one.demo.dao.account.UserInfoDao;
import com.sinosoft.one.demo.model.account.QUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.one.demo.model.account.Group;
import com.sinosoft.one.demo.model.account.User;
import com.sinosoft.one.demo.model.account.UserInfo;
import com.sinosoft.one.demo.service.ServiceException;

/**
 * 安全相关实体的管理类,包括用户和权限组.
 * 
 * @author calvin
 */
//Spring Bean的标识.
@Component
//默认将类中的所有public函数纳入事务管理.
@Transactional(readOnly = true)
public class AccountManager {

	private static Logger logger = LoggerFactory.getLogger(AccountManager.class);

	private UserDao userDao;
	private GroupDao groupDao;
	private UserInfoDao userInfoDao;
    private QUser user=new QUser("user");
	

    public List<User> findUser(){
        //BooleanExpression isCalledDave = user.loginName.eq("Dave");
        //BooleanExpression isBeauford = user.name.eq("Beauford");
        return (List<User>)userDao.findAll(user.name.eq("Dave").or(user.name.eq("Beauford")));   //QSL方式
    }
	@Transactional(readOnly = false)
	public void saveUserInfo(UserInfo entity){
		userInfoDao.save(entity);
	}
	@Transactional(readOnly = false)
	public void deleteUerInfo(Long id){
		userInfoDao.delete(id);
		
	}
	public UserInfo findUserInfo(Long id){
		return userInfoDao.findOne(id);
	}
	public UserInfo findUserInfoByUserId(long userId){
		return userInfoDao.findByUserId(userId);
	}
    public UserInfo UpdateUseInfo(UserInfo entity){
    	return userInfoDao.save(entity);
    }
	//-- User Manager --//
	public User getUser(Long id) {
		return userDao.findOne(id);
	}

	@Transactional(readOnly = false)
	public void saveUser(User user) {
		userDao.save(user);
        user.getUserInfo().setId(user.getId());
        user.getUserInfo().setStrGender(user.getUserInfo().getGender().name());
        userInfoDao.save(user.getUserInfo());
	}

	/**
	 * 删除用户,如果尝试删除超级管理员将抛出异常.
	 */
	@Transactional(readOnly = false)
	public void deleteUser(Long id) {
		if (isSupervisor(id)) {
			throw new ServiceException("不能删除超级管理员用户");
		}
		userDao.delete(id);
        userInfoDao.delete(id);
	}

    /**
     * 修改用户.
     */
    @Transactional(readOnly = false)
    public void updateUser(User user) {
        userDao.save(user);
        if(user.getUserInfo().getId() == null){
            user.getUserInfo().setId(user.getId());
        }
        user.getUserInfo().setStrGender(user.getUserInfo().getGender().name());
        userInfoDao.save(user.getUserInfo());
    }

	/**
	 * 判断是否超级管理员.
	 */
	private boolean isSupervisor(Long id) {
		return id == 1;
	}

	public List<User> getAllUser() {
		return (List<User>) userDao.findAll(new Sort(Direction.ASC, "id"));
	}

	public User findUserByLoginName(String loginName) {
		return userDao.findByLoginName(loginName);
	}

	//-- Group Manager --//
	public Group getGroup(Long id) {
		return groupDao.findOne(id);
	}

	public List<Group> getAllGroup() {
		return (List<Group>) groupDao.findAll((new Sort(Direction.ASC, "id")));
	}

	@Transactional(readOnly = false)
	public void saveGroup(Group entity) {
		groupDao.save(entity);
	}

	@Transactional(readOnly = false)
	public void deleteGroup(Long id) {
		groupDao.delete(id);
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}
	@Autowired
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

}
