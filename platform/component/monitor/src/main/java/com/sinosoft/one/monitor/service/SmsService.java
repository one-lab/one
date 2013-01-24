package com.sinosoft.one.monitor.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.one.monitor.dao.warn.SmsDao;
import com.sinosoft.one.monitor.model.warn.Sms;

@Component
public class SmsService {
	
	@Autowired
	private SmsDao smsDao;
	/**
     * 保存短信预警对象.
     */
    @Transactional(readOnly = false)
    public void addTel(Sms sms) {
        smsDao.save(sms);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 删除短信预警对象.
     */
    @Transactional(readOnly = false)
    public void deleteTel(Sms sms) {
        smsDao.delete(sms);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 根据ID获取短信预警对象.
     */
    public Sms findTel(String id) {
        return smsDao.findOne(id);
    }

    /**
     * 获取短信预警对象.
     */
    public Sms findTel(String owner, String phoneno) {
        return smsDao.findByOwnerAndPhoneNo(owner,phoneno);
    }

    /**
     * 获取所有的短信预警对象.
     */
    public List<Sms> findAllTels() {
        return (List<Sms>)smsDao.findAll(new Sort(Sort.Direction.ASC, "id"));
    }

    @Transactional(readOnly = false)
    public List<Sms> findTels(String phoneno) {
        return null;
    }

    @Transactional(readOnly = false)
    public void updateTel(Sms sms) {
        smsDao.save(sms);
    }

    public void updateEmailAddress(String id, String phoneno, Date date) {
        smsDao.updateSmsPhonenoAndCreateTimeById(id,phoneno,date);
    }

    /**
     * 删除邮箱预警对象.
     */
    @Transactional(readOnly = false)
    public void deleteSms(String id) {
        smsDao.delete(id);
    }
}
