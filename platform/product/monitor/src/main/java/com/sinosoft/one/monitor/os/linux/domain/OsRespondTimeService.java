package com.sinosoft.one.monitor.os.linux.domain;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.os.linux.model.Os;
import com.sinosoft.one.monitor.os.linux.model.OsRespondtime;
import com.sinosoft.one.monitor.os.linux.model.OsStati;
import com.sinosoft.one.monitor.os.linux.repository.OsRespondtimeRepository;
@Component
public class OsRespondTimeService {
	@Autowired
	private OsRespondtimeRepository osRespondtimeRepository;
	/**
	 * 保存响应时间采集数据
	 * @param ava
	 */
	public void saveRespondTime(String osInfoId,String respondTime ,Date sampleTime){
		OsRespondtime osRespondtime=new OsRespondtime();
		Os os=new Os();
		os.setOsInfoId(osInfoId);
		osRespondtime.setOs (os);
		osRespondtime.setSampleDate(sampleTime);
		osRespondtime.setRespondTime(respondTime);
		osRespondtimeRepository.save(osRespondtime);
	}
	
	
	/**
	 * 获取响应时间数据
	 * @param ava
	 */
	public OsRespondtime getRespondTime(){
		return null;
	}
	/**
	 * 保存响应时间统计数据
	 * @param ava
	 */
	public void saveRespondTimeStati(OsStati respondTime){
		
	}
	
	/**
	 * 获取响应时间统计数据
	 * @param ava
	 */
	public OsStati getRespondTimeStati(String osid,String type,Date begin ,Date end){
		return null;
	}
}
