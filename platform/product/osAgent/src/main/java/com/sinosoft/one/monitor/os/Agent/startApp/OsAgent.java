package com.sinosoft.one.monitor.os.Agent.startApp;

import java.util.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinosoft.one.monitor.os.Agent.config.OsConfig;
import com.sinosoft.one.monitor.os.Agent.task.HandleTask;

/**
 * 启动类
 * 
 * @author chenxiongxi
 * 
 */
public class OsAgent {
	private static Logger logger = LoggerFactory.getLogger(OsAgent.class);

	/*
	 * osAgent 入口
	 */
	public static void main(String[] args) {
	
		Timer handleTaskTimer = new Timer();
		logger.debug("handleTask start");
		handleTaskTimer.schedule(new HandleTask(handleTaskTimer), OsConfig.began * 1000,OsConfig.interCycleTime *60*1000);
	}
}
