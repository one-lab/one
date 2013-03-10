package com.sinosoft.one.monitor.db.oracle.domain;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.common.AlarmMessageBuilder;
import com.sinosoft.one.monitor.common.AttributeName;
import com.sinosoft.one.monitor.db.oracle.model.Ava;
import com.sinosoft.one.monitor.db.oracle.model.AvaSta;
import com.sinosoft.one.monitor.db.oracle.model.EventSta;
import com.sinosoft.one.monitor.db.oracle.model.Info;
import com.sinosoft.one.monitor.db.oracle.model.Lastevent;
import com.sinosoft.one.monitor.db.oracle.monitorSql.OracleMonitorSql;
import com.sinosoft.one.monitor.db.oracle.repository.AvaRepository;
import com.sinosoft.one.monitor.db.oracle.repository.AvaStaRepository;
import com.sinosoft.one.monitor.db.oracle.repository.EventStaRepository;
import com.sinosoft.one.monitor.db.oracle.repository.LasteventRepository;
import com.sinosoft.one.monitor.db.oracle.utils.DBUtil4Monitor;
import com.sinosoft.one.monitor.db.oracle.utils.db.DBUtil;
import com.sinosoft.one.monitor.db.oracle.utils.db.SqlObj;
import com.sinosoft.one.monitor.utils.AvailableCalculate;
import com.sinosoft.one.monitor.utils.AvailableCalculate.AvailableInf;
import com.sinosoft.one.monitor.utils.AvailableCalculate.AvailableStatistics;
import com.sinosoft.one.monitor.utils.DateUtil;

/**
 * User: Chunliang.Han Date: 13-3-3 Time: 下午10:21
 */
@Component
public class RecordServiceImpl implements RecordService {
	@Autowired
	private AvaRepository avaRepository;
	@Autowired
	private AvaStaRepository avaStaRepository;
	@Autowired
	private EventStaRepository eventStaRepository;
	@Autowired
	private LasteventRepository lasteventRepository;
	@Autowired
    private DBUtil4Monitor dbUtil4Monitor;
	@Autowired
	private AlarmMessageBuilder alarmMessageBuilder;
	private static Date lastDate = new Date(0);
	private static Date avaLastDate = new Date(0);

	@Override
	public void insertLastEvent(Info info, Date date) {
		Lastevent lastevent = new Lastevent();
		// 获取event数据
		dbUtil4Monitor.changeConnection(info.getId());
		String sql1 = OracleMonitorSql.bufferRatio;
		String sql2 = OracleMonitorSql.dictionaryRatio;
		String sql3 = OracleMonitorSql.libraryRatio;
        String sql4 = OracleMonitorSql.activeCount;
		List<Map<String, Object>> rsList1 = DBUtil.queryObjMaps(SqlObj
                .newInstance(sql1));
        List<Map<String, Object>> rsList2 = DBUtil.queryObjMaps(SqlObj
                .newInstance(sql2));
		List<Map<String, Object>> rsList3 = DBUtil.queryObjMaps(SqlObj
                .newInstance(sql3));
        List<Map<String, Object>> rsList4 = DBUtil.queryObjMaps(SqlObj
                .newInstance(sql4));
        double hitRatio = ((BigDecimal)rsList1.get(0).get("Hit Ratio")).doubleValue();
		lastevent.setBufferHitRate(hitRatio);
        int active =   ((BigDecimal)rsList4.get(0).get("active") ).intValue();
		lastevent.setActiveCount(active);
        double libHitRatio = ((BigDecimal)rsList3.get(0).get("libHitRatio") ).doubleValue();
		lastevent.setBufferLibHitRate(libHitRatio);
		long connectionTime = dbUtil4Monitor.connectTime(info);
		lastevent.setConnectTime(connectionTime);
        double dictRatio = ((BigDecimal)rsList2.get(0).get( "dictRatio") ).doubleValue();
		lastevent.setDickHitRate(dictRatio);
		lastevent.setDatabaseId(info.getId());
		lastevent.setRecordTime(date);
		lasteventRepository.save(lastevent);
		
		alarmMessageBuilder.newMessageBase(info.getId())
		.addAlarmAttribute(AttributeName.BufferHitRatio, hitRatio + "")
		.addAlarmAttribute(AttributeName.ResponseTime,  connectionTime + "")
		.addAlarmAttribute(AttributeName.ActiveConnection,  active + "").alarm();

		
		Calendar calender = DateUtil.getCalender();
		calender.setTime(date);
		Calendar newCalender = DateUtil.getCalender();
		newCalender.set(calender.get(Calendar.YEAR),
				calender.get(Calendar.MONTH), calender.get(Calendar.DATE));
		Date newDate = newCalender.getTime();
		if (lastDate.getTime() != newDate.getTime()) {
			insertEventSta(lastevent, newDate);
			lastDate = newDate;
		} else {
			//updateEventSta(lastevent, lastDate);
		}
		Date timePoint = StaTimeEnum.getTime(StaTimeEnum.LAST_24HOUR, date);
		//lasteventRepository.clear(timePoint);
	}

	private void insertEventSta(Lastevent lastevent, Date inserTime) {
		// 连接时间统计
		EventSta connectTimeSta = new EventSta();
		connectTimeSta.setDatabaseId(lastevent.getDatabaseId());
		connectTimeSta.setEventType("1");
		connectTimeSta.setAvg(lastevent.getConnectTime() / 1.0);
		connectTimeSta.setMax(lastevent.getConnectTime() / 1.0);
		connectTimeSta.setMin(lastevent.getConnectTime() / 1.0);
		connectTimeSta.setEventRecordTime(inserTime);
		connectTimeSta.setEventCount(1);
		// 连接数统计记录
		EventSta activeCountSta = new EventSta();
		activeCountSta.setDatabaseId(lastevent.getDatabaseId());
		activeCountSta.setEventType("2");
		activeCountSta.setAvg(lastevent.getActiveCount() / 1.0);
		activeCountSta.setMax(lastevent.getActiveCount() / 1.0);
		activeCountSta.setMin(lastevent.getActiveCount() / 1.0);
		activeCountSta.setEventRecordTime(inserTime);
        activeCountSta.setEventCount(1);
		// 缓冲区击中率统计记录
		EventSta bufferHitRateSta = new EventSta();
		bufferHitRateSta.setDatabaseId(lastevent.getDatabaseId());
		bufferHitRateSta.setEventType("3");
		bufferHitRateSta.setAvg(lastevent.getBufferHitRate() / 1.0);
		bufferHitRateSta.setMax(lastevent.getBufferHitRate() / 1.0);
		bufferHitRateSta.setMin(lastevent.getBufferHitRate() / 1.0);
		bufferHitRateSta.setEventRecordTime(inserTime);
        bufferHitRateSta.setEventCount(1);
		eventStaRepository.save(connectTimeSta);
		eventStaRepository.save(activeCountSta);
		eventStaRepository.save(bufferHitRateSta);
	}

	private Double getAvg(EventSta connectTimeSta, double count) {
		return (connectTimeSta.getAvg() * connectTimeSta.getEventCount() + count)
				/ (connectTimeSta.getEventCount() + 1);
	}

	private Double getMax(EventSta connectTimeSta, double count) {
		return count > connectTimeSta.getMax() ? count : connectTimeSta
				.getMax();
	}

	private Double getMin(EventSta connectTimeSta, double count) {
		return count < connectTimeSta.getMin() ? count : connectTimeSta
				.getMin();
	}

	private void updateEventSta(Lastevent lastevent, Date inserTime) {
		String monitorId = lastevent.getDatabaseId();
		// 连接时间统计
		EventSta connectTimeSta = eventStaRepository.findConnectTimeSta(
				monitorId, inserTime);
		connectTimeSta.setDatabaseId(lastevent.getDatabaseId());
		connectTimeSta.setEventType("1");
		Double connectTime = (double) lastevent.getConnectTime();
		Double connectTimeAvg = getAvg(connectTimeSta, connectTime);
		Double connectTimeMax = getMax(connectTimeSta, connectTime);
		Double connectTimeMin = getMin(connectTimeSta, connectTime);
		connectTimeSta.setAvg(connectTimeAvg);
		connectTimeSta.setMax(connectTimeMax);
		connectTimeSta.setMin(connectTimeMin);
		connectTimeSta.setEventCount(connectTimeSta.getEventCount() + 1);
		connectTimeSta.setEventRecordTime(inserTime);
		// 连接数统计记录
		EventSta activeCountSta = eventStaRepository.findActiveCountSta(
				monitorId, inserTime);
		activeCountSta.setDatabaseId(lastevent.getDatabaseId());
		activeCountSta.setEventType("2");
		Double activeCount = (double) lastevent.getActiveCount();
		Double activeCountAvg = getAvg(connectTimeSta, activeCount);
		Double activeCountMax = getMax(connectTimeSta, activeCount);
		Double activeCountMin = getMin(connectTimeSta, activeCount);
		connectTimeSta.setAvg(activeCountAvg);
		connectTimeSta.setMax(activeCountMax);
		connectTimeSta.setMin(activeCountMin);
		connectTimeSta.setEventCount(connectTimeSta.getEventCount() + 1);
		activeCountSta.setEventRecordTime(inserTime);
		// 缓冲区击中率统计记录
		EventSta bufferHitRateSta = eventStaRepository.findHitRateSta(
				monitorId, inserTime);
		bufferHitRateSta.setDatabaseId(lastevent.getDatabaseId());
		bufferHitRateSta.setEventType("3");
		Double bufferHitRateCount = (double) lastevent.getActiveCount();
		Double bufferHitRateAvg = getAvg(connectTimeSta, bufferHitRateCount);
		Double bufferHitRateMax = getMax(connectTimeSta, bufferHitRateCount);
		Double bufferHitRateMin = getMin(connectTimeSta, bufferHitRateCount);
		connectTimeSta.setAvg(bufferHitRateAvg);
		connectTimeSta.setMax(bufferHitRateMax);
		connectTimeSta.setMin(bufferHitRateMin);
		connectTimeSta.setEventCount(connectTimeSta.getEventCount() + 1);
		bufferHitRateSta.setEventRecordTime(inserTime);
		eventStaRepository.save(connectTimeSta);
		eventStaRepository.save(activeCountSta);
		eventStaRepository.save(bufferHitRateSta);
	}
	@Override
	public void insertAva(Info info, Date date) {
		Ava ava = new Ava();
		Connection conn = DBUtil4Monitor.getConnection(info);
		if (conn != null) {
			ava.setState("1");
		} else {
			ava.setState("0");
			alarmMessageBuilder.newMessageBase(info.getId())
			.addAlarmAttribute(AttributeName.Availability,  "0").alarm();
		}
		dbUtil4Monitor.closeConnection(conn);
		ava.setRecordTime(date);
		ava.setDatabaseId(info.getId());
		ava.setInterval(info.getPullInterval());
		avaRepository.save(ava);
		Calendar calender = DateUtil.getCalender();
		calender.setTime(date);
		Calendar newCalender = DateUtil.getCalender();
		newCalender.set(calender.get(Calendar.YEAR),
				calender.get(Calendar.MONTH), calender.get(Calendar.DATE));
		Date newDate = newCalender.getTime();
		if (avaLastDate.getTime() != newDate.getTime()) {
			insertAvaSta(ava, newDate,info.getPullInterval());
			avaLastDate = newDate;
		} else {
			//updateAvaSta(ava, lastDate,info.getPullInterval());
		}
		Date timePoint = StaTimeEnum.getTime(StaTimeEnum.LAST_24HOUR, date);
		//avaRepository.clear(timePoint);
	}

	private void insertAvaSta(Ava ava, Date inserTime,int interval) {
		AvaSta avaSta = new AvaSta();
		avaSta.setDatabaseId(ava.getDatabaseId());
		avaSta.setAvaRecordTime(inserTime);
		if(StringUtils.equals(ava.getState(), "0")){
			// 正常运行时间
			avaSta.setNormalRuntime(0);
			// 总停机时间
			avaSta.setTotalPoweroffTime(interval);
			// 总停机次数
			avaSta.setPoweroffCount(1);
			// 平均故障间隔时间
			avaSta.setAvgFailureTime(0);
			// 可用次数统计
			avaSta.setAvCount(0);
			avaSta.setUnavCount(1);
			// 未知时间总数
			avaSta.setUnknowTime(0);
			
    	} else if(StringUtils.equals(ava.getState(), "1")){
			// 正常运行时间
			avaSta.setNormalRuntime(interval);
			// 总停机时间
			avaSta.setTotalPoweroffTime(0);
			// 总停机次数
			avaSta.setPoweroffCount(0);
			// 平均故障间隔时间
			avaSta.setAvgFailureTime(interval);
			// 可用次数统计
			avaSta.setAvCount(1);
			avaSta.setUnavCount(0);
			// 未知时间总数
			avaSta.setUnknowTime(0);
    	}
		avaStaRepository.save(avaSta);
	}

	private void updateAvaSta(Ava ava,Date inserTime,int interval){
    	AvaSta avaSta = avaStaRepository.findAvaStaByTime(ava.getDatabaseId(),inserTime);
        //总停机次数
    	int falseCount = (int) avaSta.getPoweroffCount();
    	//可用次数
    	long avCount = avaSta.getAvCount();
    	//不可用次数
    	long unAvCount = avaSta.getUnavCount();
    	if(StringUtils.equals(ava.getState(), "0")){
            avaSta.setPoweroffCount(++falseCount);
            avaSta.setUnavCount(++unAvCount);
    	}else if(StringUtils.equals(ava.getState(), "1")){
    		avaSta.setAvCount(++avCount);
    	}
    	List<AvailableCalculate.AvailableCountsGroupByInterval> avCountList = avaRepository.findAvCount(inserTime);
    	List<AvailableCalculate.AvailableCountsGroupByInterval> unAvCountList = avaRepository.findUnAvCount(inserTime);
    	
    	AvailableCalculate.AvailableCalculateParam avaCalParam = new AvailableCalculate.AvailableCalculateParam(
    			new AvailableStatistics(avaSta.getNormalRuntime(), avaSta.getTotalPoweroffTime(), falseCount),
    			avCountList,unAvCountList,interval,ava.getState().equals("1"),
    			new AvailableInf(ava.getRecordTime(),ava.getState().equals("1"),new Long(ava.getInterval()).intValue())
    	);
    	
//    	AvailableCalculate availableCalculate =  AvailableCalculate.calculate(
//    			avaSta.getAvaRecordTime(), avaSta.getNormalRuntime(), avaSta.getTotalPoweroffTime(), 
//    			avCountList, unAvCountList, falseCount, interval);
    	AvailableCalculate availableCalculate =  AvailableCalculate.calculate(avaCalParam);
        //正常运行时间
        avaSta.setNormalRuntime(availableCalculate.getAliveTime().longValue());
        //总停机时间
        avaSta.setTotalPoweroffTime(availableCalculate.getStopTime().longValue());
        //总停机次数
        avaSta.setPoweroffCount(falseCount);
        //平均故障间隔时间
        avaSta.setAvgFailureTime(availableCalculate.getTimeBetweenFailures().longValue());
        //未知时间
        long unKnownTime = availableCalculate.getUnknownTime().longValue();
        avaSta.setUnknowTime(unKnownTime);
        
        avaStaRepository.save(avaSta);
    }
}
