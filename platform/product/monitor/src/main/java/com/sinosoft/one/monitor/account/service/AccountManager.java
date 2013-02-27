package com.sinosoft.one.monitor.account.service;


import java.util.List;

import com.sinosoft.one.monitor.account.dao.AccountDao;
import com.sinosoft.one.monitor.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 */
//Spring Bean的标识.
@Component
public class AccountManager {

    //private static Logger logger = LoggerFactory.getLogger(AccountManager.class);

    private AccountDao accountDao;

    @Transactional(readOnly = false)
    public void saveAccount(Account account) {
        accountDao.save(account);
    }

    /**
     * 删除用户
     */
    @Transactional(readOnly = false)
    public void deleteAccount(String id) {
        accountDao.delete(id);
    }

    /**
     * 修改用户.
     */
    @Transactional(readOnly = false)
    public void updateAccount(Account account) {
        accountDao.save(account);
    }

    public Account getAccount(String id) {
        return accountDao.findOne(id);
    }

    public List<Account> getAllAccount() {
        return (List<Account>) accountDao.findAll(new Sort(Direction.ASC, "id"));
    }

    public Account findUserByLoginName(String loginName) {
        return accountDao.findByLoginName(loginName);
    }
    @Autowired
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
    
    
}
