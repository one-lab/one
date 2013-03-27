package com.sinosoft.one.monitor.os.Agent.startApp;

import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinosoft.one.monitor.os.Agent.config.OsConfig;
import com.sinosoft.one.monitor.os.Agent.task.HandleTask;
import com.sinosoft.one.monitor.os.Agent.task.OsAgentInvestigation;
import com.sinosoft.one.util.thread.ThreadUtils;

/**
 * 启动类
 * 
 * @author chenxiongxi
 * 
 */
public class OsAgent {
	private static final int CORE_POOL_SIZE = 200;
	private static Logger logger = LoggerFactory.getLogger(OsAgent.class);
	private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(CORE_POOL_SIZE, new ThreadUtils.CustomizableThreadFactory("osAgent"));
	/*
	 * osAgent 入口
	 */
	public static void main(String[] args) {
//		do {
		OsAgentInvestigation osAgentInvestigation=new OsAgentInvestigation();
		osAgentInvestigation.start();
//		} while (OsConfig.newTimer);
//		  investigation.setScheduledFuture(scheduledFuture);
//		Timer handleTaskTimer = new Timer();
//		logger.debug("handleTask start");
//		handleTaskTimer.schedule(new HandleTask(handleTaskTimer), OsConfig.began * 1000,OsConfig.interCycleTime *60*1000);
		
	
	}
}
