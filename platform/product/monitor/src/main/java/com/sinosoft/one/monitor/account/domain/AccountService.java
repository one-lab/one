package com.sinosoft.one.monitor.account.domain;


import java.util.List;

import com.sinosoft.one.monitor.account.repository.AccountRepository;
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
public class AccountService {

    //private static Logger logger = LoggerFactory.getLogger(AccountManager.class);
	
    private AccountRepository accountRepository;

    @Transactional(readOnly = false)
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    /**
     * 删除用户
     */
    @Transactional(readOnly = false)
    public void deleteAccount(String id) {
        accountRepository.delete(id);
    }

    /**
     * 修改用户.
     */
    @Transactional(readOnly = false)
    public void updateAccount(Account account) {
        accountRepository.save(account);
    }

    public Account getAccount(String id) {
        return accountRepository.findOne(id);
    }

    public List<Account> getAllAccount() {
        return (List<Account>) accountRepository.findAll(new Sort(Direction.ASC, "id"));
    }

    public Account findUserByLoginName(String loginName) {
        return accountRepository.findByLoginName(loginName);
    }
    @Autowired
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
    
    
}
