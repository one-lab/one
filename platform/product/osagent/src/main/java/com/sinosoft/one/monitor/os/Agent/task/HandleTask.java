package com.sinosoft.one.monitor.os.Agent.task;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinosoft.one.monitor.os.Agent.config.OsConfig;
import com.sinosoft.one.monitor.os.Agent.util.HttpConnectionUtil;
import com.sinosoft.one.monitor.os.Agent.util.OsUtil;

/**
 * 调用osUtil类获取cpu,Ram,Disk数据 调用httpconnection,post数据到 monitor
 * 
 * @author chenxiongxi
 * 
 */
public class HandleTask extends TimerTask {
	private static String monitorAdrees = "";
	private static String ID = "";
	private static String cpuInfo = "";
	private static String ramInfo = "";
	private static String diskInfo = "";
	private static String cpuUilitZation = "";
	private static Map<String, Object> osInfo = new HashMap<String, Object>();
	HttpConnectionUtil connectionUtil = null;
	private Timer timer;
	private SimpleDateFormat sdf = new SimpleDateFormat("SSS");
	private long startTime ;
	private long endTime ;
	private static Logger logger = LoggerFactory.getLogger(OsConfig.class);
	public HandleTask(Timer supTimer) {
		this.timer = supTimer;
	}

	@Override
	public void run() {
		System.gc();
			try {
				if(OsConfig.first==true){
					logger.debug(OsConfig.first+"");
					OsConfig.init("config/osConfig.properties");
					OsConfig.first=false;
					logger.debug(OsConfig.interCycleTime+"");
					setPeriod(OsConfig.interCycleTime*60*1000);
				}else{
					connectionUtil = new HttpConnectionUtil();
					Properties properties = new Properties();
					properties.load(OsUtil.getFileStream("config/osConfig.properties",
							HandleTask.class));
					ID = OsConfig.ID;
					cpuUilitZation=OsUtil.getCpuUilitZation();
					
					logger.debug(cpuUilitZation);
					cpuInfo = OsUtil.getCpuInfo();
					logger.debug(cpuInfo);
					ramInfo = OsUtil.getRamInfo();
					diskInfo = OsUtil.getDiskInfo();
					startTime=System.currentTimeMillis();
					OsUtil.executeWithResult("date");
					endTime=System.currentTimeMillis();
					long respondTime=endTime- startTime;
					osInfo.put("ID", ID);
//					osInfo.put("cpuUilitZation", cpuUilitZation);
					osInfo.put("cpuInfo", cpuInfo);
					osInfo.put("ramInfo", ramInfo);
					osInfo.put("diskInfo", diskInfo);
					osInfo.put("respondTime",respondTime+"");
					osInfo.put("thisInterCycleTime", OsConfig.interCycleTime+"");
					monitorAdrees = properties.getProperty("monitorAddress")+ "recieveOsResult";
					Object o = connectionUtil.request(monitorAdrees, osInfo);
					Map<String, Object>requestMap=(Map<String, Object>) o;
					if(requestMap!=null){
						System.out.println("正确返回。。。当前轮询时间为"+OsConfig.interCycleTime);
						System.out.println("传送回来的轮询时间为"+requestMap+  "  ");
						Object object=requestMap.get("newInterCycle");
						if(Integer.valueOf((String) object)!= OsConfig.interCycleTime){
							System.out.println("修改轮询时间");
							OsConfig.interCycleTime= Integer.valueOf((String) requestMap.get("newInterCycle"));
							setPeriod(OsConfig.interCycleTime*60*1000);
						}
					}else{
						OsConfig.first=true;
					}
				}
			} catch (Throwable e) {
				logger.debug(e.getMessage());
				e.printStackTrace();
			}
	}
	
	
	public void setPeriod(long period) {  
        //缩短周期，执行频率就提高  
        setDeclaredField(TimerTask.class, this, "period", period);  
    }  
      
    //通过反射修改字段的值  
    static boolean setDeclaredField(Class<?> clazz, Object obj,  
            String name, Object value) {  
        try {  
        	Field field = clazz.getDeclaredField(name);  
            field.setAccessible(true);  
            field.set(obj, value);  
            return true;  
        } catch (Exception ex) {  
            ex.printStackTrace();  
            return false;  
        }  
    }

}
