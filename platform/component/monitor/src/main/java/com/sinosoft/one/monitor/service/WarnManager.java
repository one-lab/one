package com.sinosoft.one.monitor.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.one.monitor.dao.warn.EmailDao;
import com.sinosoft.one.monitor.dao.warn.SmsDao;
import com.sinosoft.one.monitor.model.warn.Email;
import com.sinosoft.one.monitor.model.warn.QEmail;
import com.sinosoft.one.monitor.model.warn.QSms;
import com.sinosoft.one.monitor.model.warn.Sms;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-26
 * Time: 下午4:25
 * To change this template use File | Settings | File Templates.
 */
@Component
@Transactional(readOnly = true)
public class WarnManager {
    private static Logger logger = LoggerFactory.getLogger(WarnManager.class);

    @Autowired
    private EmailDao emailDao;
    private QEmail email = new QEmail("email");

    @Autowired
    private SmsDao smsDao;
    private QSms sms = new QSms("sms");

    /**
     * 获取所有的邮件预警对象.
     */
    public List<Email> getAllEmail() {
        return (List<Email>) emailDao.findAll(new Sort(Sort.Direction.ASC, "id"));
    }

    /**
     * 获取所有的短信预警对象.
     */
    public List<Sms> getAllSms() {
        return (List<Sms>) smsDao.findAll(new Sort(Sort.Direction.ASC, "id"));
    }
}
