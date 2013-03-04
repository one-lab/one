package com.sinosoft.one.monitor.db.oracle.domain;

import com.sinosoft.one.monitor.db.oracle.model.*;
import com.sinosoft.one.monitor.db.oracle.monitorSql.OracleMonitorSql;
import com.sinosoft.one.monitor.db.oracle.repository.AvaRepository;
import com.sinosoft.one.monitor.db.oracle.repository.AvaStaRepository;
import com.sinosoft.one.monitor.db.oracle.repository.EventStaRepository;
import com.sinosoft.one.monitor.db.oracle.repository.LasteventRepository;
import com.sinosoft.one.monitor.db.oracle.utils.DBUtil4Monitor;
import com.sinosoft.one.monitor.db.oracle.utils.db.DBUtil;
import com.sinosoft.one.monitor.db.oracle.utils.db.SqlObj;
import com.sinosoft.one.monitor.utils.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * User: Chunliang.Han
 * Date: 13-3-3
 * Time: 下午10:21
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
    private static Date lastDate = new Date(0);
    @Override
    public void insertLastEvent(Info info,Date date) {
        Lastevent lastevent = new Lastevent();
        //获取event数据
        DBUtil4Monitor.changeConnection(info.getId());
        String sql1 = OracleMonitorSql.bufferRatio;
        String sql2 = OracleMonitorSql.dictionaryRatio;
        String sql3 = OracleMonitorSql.libraryRatio;
        List<Map<String, String>> rsList1 = DBUtil.queryStrMaps(SqlObj.newInstance(sql1));
        List<Map<String, String>> rsList2 = DBUtil.queryStrMaps(SqlObj.newInstance(sql2));
        List<Map<String, String>> rsList3 = DBUtil.queryStrMaps(SqlObj.newInstance(sql3));
        lastevent.setBufferHitRate(Double.parseDouble(rsList1.get(0).get("Hit Ratio")));
        lastevent.setActiveCount(Integer.parseInt(rsList1.get(0).get("active")));
        lastevent.setBufferLibHitRate(Double.parseDouble(rsList3.get(0).get("libHitRatio")));
        lastevent.setConnectTime(DBUtil4Monitor.connectTime(info));
        lastevent.setDickHitRate(Double.parseDouble(rsList2.get(0).get("dictRatio")));
        lastevent.setInfo(info);
        lastevent.setRecordTime(date);
        lasteventRepository.save(lastevent);
        Calendar calender = DateUtil.getCalender();
        calender.setTime(date);
        Calendar newCalender = DateUtil.getCalender();
        newCalender.set(
        		calender.get(Calendar.YEAR), 
        		calender.get(Calendar.MONTH), 
        		calender.get(Calendar.DATE));
        Date newDate = newCalender.getTime();
        if(lastDate.getTime() != newDate.getTime()){
        	insertEventSta(lastevent,newDate);
        	lastDate = newDate;
        }else{
        	updateEventSta(lastevent,lastDate);
        }
    }

    private void insertEventSta(Lastevent lastevent,Date inserTime) {
    	//连接时间统计
    	EventSta connectTimeSta = new EventSta();
    	connectTimeSta.setInfo(lastevent.getInfo());
    	connectTimeSta.setEventType("1");
    	connectTimeSta.setAvg(lastevent.getConnectTime()/1.0);
    	connectTimeSta.setMax(lastevent.getConnectTime()/1.0);
    	connectTimeSta.setMin(lastevent.getConnectTime()/1.0);
    	connectTimeSta.setEventRecordTime(inserTime);
    	//连接数统计记录
        EventSta activeCountSta = new EventSta();
        activeCountSta.setInfo(lastevent.getInfo());
        activeCountSta.setEventType("2");
        activeCountSta.setAvg(lastevent.getActiveCount()/1.0);
        activeCountSta.setMax(lastevent.getActiveCount()/1.0);
        activeCountSta.setMin(lastevent.getActiveCount()/1.0);
        activeCountSta.setEventRecordTime(inserTime);
        //缓冲区击中率统计记录
        EventSta bufferHitRateSta = new EventSta();
        bufferHitRateSta.setInfo(lastevent.getInfo());
        bufferHitRateSta.setEventType("3");
        bufferHitRateSta.setAvg(lastevent.getBufferHitRate()/1.0);
        bufferHitRateSta.setMax(lastevent.getBufferHitRate()/1.0);
        bufferHitRateSta.setMin(lastevent.getBufferHitRate()/1.0);
        bufferHitRateSta.setEventRecordTime(inserTime);
        eventStaRepository.save(activeCountSta) ;
    }
    private void updateEventSta(Lastevent lastevent,Date inserTime){
    	//连接时间统计
    	EventSta connectTimeSta = eventStaRepository.findConnectTimeSta(inserTime);
    	connectTimeSta.setInfo(lastevent.getInfo());
    	connectTimeSta.setEventType("1");
    	connectTimeSta.setAvg(lastevent.getConnectTime()/1.0);
    	connectTimeSta.setMax(lastevent.getConnectTime()/1.0);
    	connectTimeSta.setMin(lastevent.getConnectTime()/1.0);
    	connectTimeSta.setEventRecordTime(inserTime);
    	//连接数统计记录
        EventSta activeCountSta = eventStaRepository.findActiveCountSta(inserTime);
        activeCountSta.setInfo(lastevent.getInfo());
        activeCountSta.setEventType("2");
        activeCountSta.setAvg(lastevent.getActiveCount()/1.0);
        activeCountSta.setMax(lastevent.getActiveCount()/1.0);
        activeCountSta.setMin(lastevent.getActiveCount()/1.0);
        activeCountSta.setEventRecordTime(inserTime);
        //缓冲区击中率统计记录
        EventSta bufferHitRateSta = eventStaRepository.findHitRateSta(inserTime);
        bufferHitRateSta.setInfo(lastevent.getInfo());
        bufferHitRateSta.setEventType("3");
        bufferHitRateSta.setAvg(lastevent.getBufferHitRate()/1.0);
        bufferHitRateSta.setMax(lastevent.getBufferHitRate()/1.0);
        bufferHitRateSta.setMin(lastevent.getBufferHitRate()/1.0);
        bufferHitRateSta.setEventRecordTime(inserTime);
        eventStaRepository.save(activeCountSta) ;
    }
    @Override
    public void insertAva(Info info,Date date) {
        Ava ava = new Ava();
        Connection conn = DBUtil4Monitor.getConnection(info);
        if(conn != null){
            ava.setState("1");
        } else{
            ava.setState("0");
        }
        DBUtil4Monitor.closeConnection(conn);
        ava.setRecordTime(date);
        ava.setInfo(info);
        avaRepository.save(ava);
    }

    public void insertAvaSta(Info info,Date date) {
        AvaSta avaSta = new AvaSta();

        avaStaRepository.save(avaSta);
    }
}
