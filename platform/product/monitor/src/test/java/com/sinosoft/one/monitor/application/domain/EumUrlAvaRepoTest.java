package com.sinosoft.one.monitor.application.domain;

import com.sinosoft.one.monitor.application.model.EumUrlAva;
import com.sinosoft.one.monitor.application.repository.EumUrlAvaRepository;
import com.sinosoft.one.monitor.application.repository.EumUrlAvaStaRepository;
import com.sinosoft.one.util.test.SpringTxTestCase;
import junit.framework.Assert;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@DirtiesContext
@ContextConfiguration(locations = {"/spring/applicationContext-test.xml"})
@TransactionConfiguration(defaultRollback=false)
public class EumUrlAvaRepoTest extends SpringTxTestCase {

    @Autowired
    private ApplicationEmuService emuService;

    @Autowired
    private EumUrlAvaRepository avaRepository;

    @Autowired
    private EumUrlAvaStaRepository avaStaRepository;

    @Test
    public void  findEumUrlAvaNewest(){
        Sort sort = new Sort(Sort.Direction.DESC,"recordTime");
        Pageable pageable = new PageRequest(0,1,sort);
        Assert.assertEquals(1, avaRepository.findByEumUrlId("11111", pageable).getContent().size());
    }

    @Test
    public void findByRecordTimeAndEumUrlId(){

        Assert.assertEquals(1, avaStaRepository.findByRecordTimeAndEumUrlId(new Date(), "11111").size());
    }


    @Test
    @Transactional
    public void saveEumUrlAvaTest(){
        Date now = new Date();
        EumUrlAva eumUrlAva = new EumUrlAva();
        eumUrlAva.setEumUrlId("11111");
        eumUrlAva.setInterval(BigDecimal.TEN);
        eumUrlAva.setRecordTime(now);
        avaRepository.save(eumUrlAva);
        EumUrlAva eumUrlAva1 =emuService.getTodayLatestEumUrlAva("11111");
        Assert.assertEquals(0, eumUrlAva1.getRecordTime().compareTo(now));
        //emuService.saveEnumUrlAvailableDetail("11111",true, BigDecimal.ONE);
    }
}
