package com.sinosoft.one.demo.service.account;

import com.mysema.query.types.expr.BooleanExpression;
import com.sinosoft.one.data.jade.dataaccess.procedure.OutProcedureResult;
import com.sinosoft.one.data.jade.dataaccess.procedure.ProcedureResult;
import com.sinosoft.one.data.jade.dataaccess.procedure.ResultSetProcedureResult;
import com.sinosoft.one.data.jade.parsers.util.StringUtil;
import com.sinosoft.one.demo.dao.account.GroupDao;
import com.sinosoft.one.demo.dao.account.UserDao;
import com.sinosoft.one.demo.dao.account.UserInfoDao;
import com.sinosoft.one.demo.model.account.Group;
import com.sinosoft.one.demo.model.account.QUser;
import com.sinosoft.one.demo.model.account.User;
import com.sinosoft.one.demo.model.account.UserInfo;
import com.sinosoft.one.demo.service.ServiceException;
import oracle.jdbc.OracleTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private QUser user = new QUser("user");


    /**
     * QSL方式.
     */
    public List<User> findAllUserByQSL(Map<String, String> mapa) {
        BooleanExpression expression = user.id.isNotNull();

        if (!StringUtil.isEmpty(mapa.get("name"))) {
            expression = expression.and(user.name.like("%" + mapa.get("name") + "%"));
        }
        if (!StringUtil.isEmpty(mapa.get("email"))) {
            expression = expression.and(user.email.like("%" + mapa.get("email") + "%"));
        }
        if (!StringUtil.isEmpty(mapa.get("id"))) {
            expression = expression.and(user.id.eq(Long.valueOf(mapa.get("id"))));
        }
        return (List<User>) userDao.findAll(expression);
    }

    /**
     * 动态QSL方式.
     */
    public List<User> findAllUserByDynamicSQL(String name, String email, Long id) {
        if (!name.isEmpty()) {
            name = "%" + name + "%";
        }
        if (!email.isEmpty()) {
            email = "%" + email + "%";
        }
        return userDao.selectUserForDynamicComplexSql(name, email, id);
    }

    /**
     * JPQL方式.
     */
    public List<User> findAllUserOne() {
        return userDao.findAllUserByJpql();
    }

    /**
     * SQL资源文件方式.
     */
    public List<User> findAllUserTwo() {
        return userDao.findAllUseuByResourse();
    }

    /**
     * JPA资源文件方式.
     */
    public List<User> findAllUserByNamedQueyt(String name) {
        name = "%" + name + "%";
        return userDao.findBySpringDataNamedQuery(name);
    }

    /**
     * ORACLE的存储过程演示.
     */
    public Map<String, OutProcedureResult> findAllUserByOracleProcedure(Long id, String name) {
        if (id == null) {
            id = Long.valueOf(1);
        }
        if (name == null) {
            name = "";
        }
        name = "%" + name + "%";
        ProcedureResult<List<User>> procedureResultUser = new OutProcedureResult<List<User>>(User.class, OracleTypes.CURSOR);
        ProcedureResult<List<String>> procedureResultPhone = new OutProcedureResult<List<String>>(String.class, OracleTypes.CURSOR);
        userDao.procedureResultWithOracle(id, name, procedureResultUser, procedureResultPhone);
        Map<String, OutProcedureResult> outProcedureResultMap = new HashMap<String, OutProcedureResult>();
        outProcedureResultMap.put("users", (OutProcedureResult) procedureResultUser);
        outProcedureResultMap.put("phones", (OutProcedureResult) procedureResultPhone);
        return outProcedureResultMap;
    }

    /**
     * MYSQL的存储过程演示.
     */
    public Map<String, ProcedureResult> findAllUserByMysqlProcedure(Long id, String name) {
        if (id == null) {
            id = Long.valueOf(1);
        }
        if (name == null) {
            name = "";
        }
        name = "%" + name + "%";
        ProcedureResult<List<Long>> procedureResultId = new OutProcedureResult<List<Long>>(Long.class, Types.BIGINT);
        ProcedureResult<List<String>> procedureResultName = new OutProcedureResult<List<String>>(String.class, Types.VARCHAR);
        ProcedureResult<List<UserInfo>> procedureResultUserInfo = new ResultSetProcedureResult<List<UserInfo>>(UserInfo.class);
        userDao.procedureResultWithMysql(id, name, procedureResultId, procedureResultName, procedureResultUserInfo);
        Map<String, ProcedureResult> procedureResultMap = new HashMap<String, ProcedureResult>();
        procedureResultMap.put("ids", procedureResultId);
        procedureResultMap.put("names", procedureResultName);
        procedureResultMap.put("userInfos", procedureResultUserInfo);
        return procedureResultMap;
    }

    @Transactional(readOnly = false)
    public void saveUserInfo(UserInfo entity) {
        userInfoDao.save(entity);
    }

    @Transactional(readOnly = false)
    public void deleteUerInfo(Long id) {
        userInfoDao.delete(id);

    }

    public UserInfo findUserInfo(Long id) {
        return userInfoDao.findOne(id);
    }

    public UserInfo findUserInfoByUserId(long userId) {
        return userInfoDao.findByUserId(userId);
    }

    public UserInfo UpdateUseInfo(UserInfo entity) {
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
        if (user.getUserInfo().getId() == null) {
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
