package com.sinosoft.one.monitor.db.oracle.domain;

import com.google.common.collect.MapMaker;
import com.sinosoft.one.monitor.db.oracle.model.Info;
import com.sinosoft.one.monitor.db.oracle.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * User: Chunliang.Han
 * Date: 13-3-3
 * Time: 下午4:37
 */
@Component
@Lazy(false)
public class OracleMonitorTask {
    @Autowired
    private  InfoRepository infoRepository;
    @Autowired
    private  RecordService recordService;
    /**
     * ScheduledFuture<?>缓存
     */
    private static ConcurrentMap<String, ScheduledFuture<?>> beeperHandleMap = new MapMaker().concurrencyLevel(32).makeMap();//监控站点线程

    /**
     * 定义任务处理器，线程池的长度设定为100
     */
    public  ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(100);
    public OracleMonitorTask(){}
    @PostConstruct
    public  void execute(){
        System.out.println("启动oracle监听服务。。。");
        List<Info> infoList = (List<Info>) infoRepository.findAll();
        for(Info info:infoList){
        	execute(scheduledExecutorService,info);
        }
    }
    public  void addTask(Info info){
    	execute(scheduledExecutorService,info);
    }
    public  void updateTask(Info info){
    	deleteTask(info);
    	execute(scheduledExecutorService,info);
    }
    public  void deleteTask(Info info){
    	ScheduledFuture<?> beeperHandle = beeperHandleMap.get(info.getId());
    	beeperHandle.cancel(true);
    	beeperHandleMap.remove(info.getId());
    }
    private  void execute(ScheduledExecutorService scheduledExecutorService,Info info){
        int timeDuring = info.getPullInterval();
        Runnable monitorRunnable = new MonitorRunnable(info);
        ScheduledFuture<?>  beeperHandle = scheduledExecutorService.scheduleAtFixedRate(monitorRunnable,timeDuring,timeDuring, TimeUnit.MINUTES);
        beeperHandleMap.put(info.getId(),beeperHandle);
    }
    
    private  class MonitorRunnable  implements Runnable{
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
