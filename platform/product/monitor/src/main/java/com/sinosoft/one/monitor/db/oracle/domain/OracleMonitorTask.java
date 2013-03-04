package com.sinosoft.one.monitor.db.oracle.domain;

import com.sinosoft.one.monitor.db.oracle.model.Info;
import com.sinosoft.one.monitor.db.oracle.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * User: Chunliang.Han
 * Date: 13-3-3
 * Time: 下午4:37
 */
@Component
public class OracleMonitorTask {
    @Autowired
    private static InfoRepository infoRepository;
    @Autowired
    private static RecordService recordService;
    /**
     * ScheduledExecutorService缓存
     */
    public static final Map<String, ScheduledExecutorService> scheduledExecutorServiceMap = new HashMap<String, ScheduledExecutorService>();
    /**
     * ScheduledFuture<?>缓存
     */
    public static final Map<String, ScheduledFuture<?>> beeperHandleMap = new HashMap<String, ScheduledFuture<?>>();
    
    public OracleMonitorTask(){
        execute();
    }
    public static void execute(){
        List<Info> infoList = (List<Info>) infoRepository.findAll();
        for(Info info:infoList){
        	ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        	execute(scheduledExecutorService,info);
        }
    }
    public static void addTask(Info info){
    	ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    	execute(scheduledExecutorService,info);
    }
    public static void updateTask(Info info){
    	ScheduledFuture<?> beeperHandle = beeperHandleMap.get(info.getId());
    	ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceMap.get(info.getId());
    	beeperHandle.cancel(true);
    	execute(scheduledExecutorService,info);
    }
    public static void deleteTask(Info info){
    	ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceMap.get(info.getId());
    	scheduledExecutorService.shutdown();
    }
    private static void execute(ScheduledExecutorService scheduledExecutorService,Info info){
        int timeDuring = info.getPullInterval();
        Runnable monitorRunnable = new MonitorRunnable(info);
        ScheduledFuture<?>  beeperHandle = scheduledExecutorService.scheduleAtFixedRate(monitorRunnable,0,timeDuring, TimeUnit.MINUTES);
        beeperHandleMap.put( info.getId(),beeperHandle);
        scheduledExecutorServiceMap.put(info.getId(), scheduledExecutorService);
    }
    
    private static class MonitorRunnable  implements Runnable{
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
