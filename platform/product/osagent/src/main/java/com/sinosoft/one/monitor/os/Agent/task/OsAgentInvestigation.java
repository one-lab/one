package com.sinosoft.one.monitor.os.Agent.task;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinosoft.one.monitor.os.Agent.config.OsConfig;
import com.sinosoft.one.monitor.os.Agent.util.HttpConnectionUtil;
import com.sinosoft.one.monitor.os.Agent.util.OsUtil;
import com.sinosoft.one.util.thread.ThreadUtils;

public class OsAgentInvestigation implements Runnable{
	
	private static String ID = "";
	private static String cpuInfo = "";
	private static String ramInfo = "";
	private static String diskInfo = "";
	private static String cpuUilitZation = "";
	private HttpConnectionUtil connectionUtil = null;
	private long startTime ;
	private long endTime ;
	private static Logger logger = LoggerFactory.getLogger(OsConfig.class);
	
	private ScheduledExecutorService scheduledExecutorService;
	private ScheduledFuture<?>  scheduledFuture;
	
//	public OsAgentInvestigation(ScheduledExecutorService superScheduledExecutorService ){
//		this.scheduledExecutorService=superScheduledExecutorService;
//	}
	
	public void run() {
		try {
			if(OsConfig.first==true){
				OsConfig.init("config/osConfig.properties");
				logger.debug(OsConfig.interCycleTime+"");
				OsConfig.scheduledFuture.cancel(true);
				OsConfig.scheduledFuture = OsConfig.executorService.scheduleAtFixedRate(new OsAgentInvestigation(),   1, 1, TimeUnit.SECONDS);
				System.out.println(321);
				System.gc();
			}else{
				connectionUtil = new HttpConnectionUtil();
				Properties properties = new Properties();
				properties.load(OsUtil.getFileStream("config/osConfig.properties",
						HandleTask.class));
				ID = OsConfig.ID;
				cpuInfo = OsUtil.getCpuInfo();
				logger.debug(cpuInfo);
				ramInfo = OsUtil.getRamInfo();
				diskInfo = OsUtil.getDiskInfo();
				startTime=System.currentTimeMillis();
				OsUtil.executeWithResult("date");
				endTime=System.currentTimeMillis();
				long respondTime=endTime- startTime;
				Map<String, Object> osInfo = new HashMap<String, Object>();
				osInfo.put("ID", ID);
				osInfo.put("cpuInfo", cpuInfo);
				osInfo.put("ramInfo", ramInfo);
				osInfo.put("diskInfo", diskInfo);
				osInfo.put("respondTime",respondTime+"");
				osInfo.put("thisInterCycleTime", OsConfig.interCycleTime+"");
				String monitorAdrees = properties.getProperty("monitorAddress")+ "recieveOsResult";
				logger.debug(monitorAdrees);
				Object o = connectionUtil.request(monitorAdrees, osInfo);
				Map<String, Object>requestMap=(Map<String, Object>) o;
				if(requestMap!=null){
					logger.debug("正确返回。。。当前轮询时间为",OsConfig.interCycleTime);
					logger.debug("传送回来的轮询时间为",requestMap+  "  ");
					Object object=requestMap.get("newInterCycle");
					if(Integer.valueOf((String) object)!= OsConfig.interCycleTime){
						logger.debug("修改轮询时间");
						OsConfig.scheduledFuture.cancel(true);
						OsConfig.scheduledFuture = OsConfig.executorService.scheduleAtFixedRate(new OsAgentInvestigation(),OsConfig.interCycleTime*60, OsConfig.interCycleTime*60, TimeUnit.SECONDS);
						System.out.println(123);
					}
				}else{
					OsConfig.first=true;
				}
				System.gc();
			}
		} catch (Throwable e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
