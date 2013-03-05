package com.sinosoft.one.monitor.application.domain;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.Date;

@DirtiesContext
@ContextConfiguration(locations = {"/spring/applicationContext-test.xml"})
public class EumUrlAvaRepoTest extends SpringTxTestCase {

    @Autowired
    private EumUrlAvaRepository avaRepository;

    @Autowired
    private EumUrlAvaStaRepository avaStaRepository;

    @Test
    public void  findEumUrlAvaNewest(){
        Sort sort = new Sort(Sort.Direction.DESC,"recordTime");
        Pageable pageable = new PageRequest(0,1,sort);
        Assert.assertEquals(1, avaRepository.findByEumUrl_Id("11111", pageable).getContent().size());
    }

    @Test
    public void findByRecordTimeAndEumUrlId(){

        Assert.assertEquals(1, avaStaRepository.findByRecordTimeAndEumUrl_Id(new Date(), "11111").size());
    }



}
