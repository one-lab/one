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
     * ScheduledFuture<?>缓存
     */
    public static final Map<String, ScheduledFuture<?>> beeperHandleMap = new HashMap<String, ScheduledFuture<?>>();
    /**
     * 定义任务处理器，线程池的长度设定为100
     */
    public static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(100);
    public OracleMonitorTask(){
        execute();
    }
    public static void execute(){
        List<Info> infoList = (List<Info>) infoRepository.findAll();
        for(Info info:infoList){
        	execute(scheduledExecutorService,info);
        }
    }
    public static void addTask(Info info){
    	execute(scheduledExecutorService,info);
    }
    public static void updateTask(Info info){
    	deleteTask(info);
    	execute(scheduledExecutorService,info);
    }
    public static void deleteTask(Info info){
    	ScheduledFuture<?> beeperHandle = beeperHandleMap.get(info.getId());
    	beeperHandle.cancel(true);
    	beeperHandleMap.remove(info.getId());
    }
    private static void execute(ScheduledExecutorService scheduledExecutorService,Info info){
        int timeDuring = info.getPullInterval();
        Runnable monitorRunnable = new MonitorRunnable(info);
        ScheduledFuture<?>  beeperHandle = scheduledExecutorService.scheduleAtFixedRate(monitorRunnable,0,timeDuring, TimeUnit.MINUTES);
        beeperHandleMap.put(info.getId(),beeperHandle);
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
            recordService.insertLastEvent(info,date);
        }
    }
}
