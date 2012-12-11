package com.sinosoft.one.demo.dao.mail;

import com.sinosoft.one.demo.model.MailModel;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Intro:
 * User: Kylin
 * Date: 12-10-30
 * Time: 上午10:01
 * To change this template use File | Settings | File Templates.
 */
public interface MailDao extends PagingAndSortingRepository<MailModel, Long> {

    public MailModel findById(String id);
}
