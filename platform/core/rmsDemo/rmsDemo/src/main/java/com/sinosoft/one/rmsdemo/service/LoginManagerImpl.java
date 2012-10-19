package com.sinosoft.one.rmsdemo.service;

import com.sinosoft.one.rmsdemo.model.User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-9-20
 * Time: 下午4:13
 * To change this template use File | Settings | File Templates.
 */
@Service
public class LoginManagerImpl implements LoginManager {
    private final Map<String, User> userMap = new ConcurrentHashMap<String, User>();
    private final AtomicLong idValue = new AtomicLong();

    public LoginManagerImpl(){
        super();
    }
    public User findByLoginName(String loginName) {
        userMap.put("admin",new User("admin","admin"));
        return userMap.get(loginName);
    }
}
