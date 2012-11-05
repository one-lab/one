package com.sinosoft.one.demo.service.timer;

import com.sinosoft.one.demo.dao.account.UserDao;
import com.sinosoft.one.demo.model.account.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Intro:
 * User: Kylin
 * Date: 12-10-24
 * Time: 上午11:22
 * To change this template use File | Settings | File Templates.
 */
@Service
public class QuartzService {
    @Autowired
    private UserDao userDao;
    public void invoke() {
        System.out.println("quartz service invoke method begin...............");
        List<User> users = (List<User>)userDao.findAll();
        System.out.println("quartz service invoke method end...............users.size():"+users.size());
    }
}
