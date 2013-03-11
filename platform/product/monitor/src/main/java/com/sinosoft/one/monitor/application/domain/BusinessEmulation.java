package com.sinosoft.one.monitor.application.domain;

import com.sinosoft.one.monitor.application.model.*;
import com.sinosoft.one.monitor.application.repository.EumUrlAvaRepository;
import com.sinosoft.one.monitor.application.repository.EumUrlAvaStaRepository;
import com.sinosoft.one.monitor.common.AlarmMessageBuilder;
import com.sinosoft.one.monitor.common.AlarmSource;
import com.sinosoft.one.monitor.common.AttributeName;
import com.sinosoft.one.monitor.common.ResourceType;
import com.sinosoft.one.monitor.utils.AvailableCalculate;
import com.sinosoft.one.monitor.utils.ResponseUtil;
import com.sinosoft.one.util.thread.ThreadUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 业务仿真
 * User: ChengQi
 * Date: 13-3-4
 * Time: PM3:44
 */
@Component
@Lazy(false)
public class BusinessEmulation {

    private static Logger logger = LoggerFactory.getLogger(BusinessEmulation.class);

    private static final int CORE_POOL_SIZE = 200;

    //default_interval set is 5m*60sec
    private static final int DEFAULT_INTERVAL = 5*60;

    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(CORE_POOL_SIZE, new ThreadUtils.CustomizableThreadFactory("appEMU"));

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ApplicationEmuService applicationEmuService;

	@Autowired
	private AlarmMessageBuilder alarmMessageBuilder;



    @PostConstruct
    public void init(){
      List<Application> applications =  applicationService.findValidateApplication();
      logger.info("{}:,  {}",BusinessEmulation.class.toString(),applications.size());
      for(Application application:applications){
          application.setEnumUrls(applicationEmuService.findEumUrlByApplicationId(application.getId()));
          long interval = DEFAULT_INTERVAL;
          if(application.getInterval()!=null){
              interval =   interval(application.getInterval().longValue());
          }
          if(application.getEnumUrls().isEmpty())
              continue;
          //延时时间按照
          executorService.scheduleAtFixedRate(new Investigation(application), interval,
                  interval , TimeUnit.SECONDS);

      }
    }

    @Transactional(readOnly = false)
    private void recordEnum(EumUrl url, boolean result, BigDecimal interval){
	    if(!result) {
		    alarmMessageBuilder.newMessageBase(url.getApplication().getId())
				    .alarmSource(AlarmSource.EUM)
				    .addAlarmAttribute(AttributeName.Availability, "0")
		            .subResourceType(ResourceType.APPLICATION_SCENARIO_URL)
		            .subResourceId(url.getUrlId()).alarm();
	    }

        //记录当天的统计信息
        applicationEmuService.saveEnumUrlAvailableStatistics(url.getId(),result,interval);
        //记录至今天访问明细
        applicationEmuService.saveEnumUrlAvailableDetail(url.getId(),result,interval);
    }


    /**
     * reStart allApplication emulation
     */
    public void restart(){
        executorService.shutdown();
        init();
    }

    private long interval(long interval){
       return (interval == 0?DEFAULT_INTERVAL:interval)*60;
    }

    private class Investigation implements Runnable {

        private Logger loggerInv = LoggerFactory.getLogger(Investigation.class);

        private final Application application;

        private final List<EumUrl> urls ;

        public Investigation(final Application application){
            this.application = application;
            this.urls = this.application.getEnumUrls();
        }


        @Override
        public void run() {

            System.out.println("application id = " + application.getId() + " time is = " + new Date() + " url is = " + urls.size());
            //  loggerInv.info("Investigation {} has started, url size is : {}",application.getApplicationName(),urls.size());
            try {
                for (EumUrl url : urls) {
                    recordEnum(url, ResponseUtil.getResponseCode(createHttpUrl(url.getUrl()))!= 404, this.application.getInterval());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String createHttpUrl(String url) {
            StringBuilder str = new  StringBuilder();
            if(url.contains("http://")||url.contains("https://")){
                url =  StringUtils.removeStart(url,"http://");
                url =  StringUtils.removeStart(url,"https://");
                url = StringUtils.substring(url,15);
                url = StringUtils.removeStart(url,"/");
            }
            str.append("http://").append(application.getApplicationIp()).append(":");
            str.append(application.getApplicationPort());
            str.append("/");
            str.append(application.getApplicationName());
            if(url.startsWith("/"))
                str.append(url);
            else
                str.append("/").append(url);
            return str.toString();
        }

    }


}
