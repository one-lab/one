package com.sinosoft.one.monitor.db.oracle.domain;

import com.sinosoft.one.monitor.db.oracle.model.Info;
import com.sinosoft.one.monitor.db.oracle.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * User: Chunliang.Han
 * Date: 13-3-3
 * Time: 下午4:37
 */
@Component
public class OracleMonitorTask {
    @Autowired
    private InfoRepository infoRepository;
    @Autowired
    private RecordService recordService;
    public OracleMonitorTask(){
        execute();
    }
    public void execute(){
        List<Info> infoList = (List<Info>) infoRepository.findAll();
        for(Info info:infoList){
            int timeDuring = info.getPullInterval();
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            Runnable monitorRunnable = new MonitorRunnable(info);
            //ScheduledFuture<?> beeperHandle = scheduledExecutorService.scheduleAtFixedRate(monitorRunnable,0,timeDuring, TimeUnit.MINUTES);
            //beeperHandle.cancel(true);
            scheduledExecutorService.scheduleAtFixedRate(monitorRunnable,0,timeDuring, TimeUnit.MINUTES);
        }
    }
    private class MonitorRunnable  implements Runnable{
        Info info ;
        public MonitorRunnable(Info info){
             this.info = info;
        }
        @Override
        public void run() {
            Date date = new Date();
            recordService.insertAva(info,date);
            recordService.insertAvaSta(info,date);
            recordService.insertEventSta(info,date);
            recordService.insertLastEvent(info,date);
        }
    }
}
