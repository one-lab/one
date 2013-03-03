package com.sinosoft.one.monitor.db.oracle.domain;

import com.sinosoft.one.monitor.db.oracle.model.*;
import com.sinosoft.one.monitor.db.oracle.monitorSql.OracleMonitorSql;
import com.sinosoft.one.monitor.db.oracle.repository.InfoRepository;
import com.sinosoft.one.monitor.db.oracle.repository.LasteventRepository;
import com.sinosoft.one.monitor.db.oracle.utils.DBUtil4Monitor;
import com.sinosoft.one.monitor.db.oracle.utils.db.DBUtil;
import com.sinosoft.one.monitor.db.oracle.utils.db.SqlObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * User: Chunliang.Han
 * Date: 13-3-1
 * Time: 下午6:29
 */
@Component
public class OracleSGAServiceImpl implements OracleSGAService {
     @Autowired
    private InfoRepository infoRepository;
    @Autowired
    private LasteventRepository lasteventRepository;

    @Override
    public OracleSGAModel viewSGAInfo(String monitorId) {
        DBUtil4Monitor.changeConnection(monitorId);
        OracleSGAModel oracleSGAModel = new OracleSGAModel();
        String sql1 = OracleMonitorSql.sgaInfo1;
        String sql2 = OracleMonitorSql.sgaInfo2;
        List<Map<String, String>> rsList1 = DBUtil.queryStrMaps(SqlObj.newInstance(sql1));
        //'Fixed SGA Size','Redo Buffers','Buffer Cache Size','Shared Pool Size','Large Pool Size','Java Pool Size'
        String fixedSGASize = rsList1.get(0).get("bytes");
        String redoBuffers = rsList1.get(1).get("bytes");
        String bufferCacheSize = rsList1.get(2).get("bytes");
        String sharedPoolSize = rsList1.get(3).get("bytes");
        String largePoolSize = rsList1.get(4).get("bytes");
        String javaPoolSize = rsList1.get(5).get("bytes");
        List<Map<String, String>> rsList2 = DBUtil.queryStrMaps(SqlObj.newInstance(sql2));
        // 'sql area' ,'library cache','sga dev dict ;
        String sqlArea = rsList2.get(0).get("bytes");
        String libCache = rsList2.get(1).get("bytes");
        String sgaDevDict = rsList2.get(2).get("bytes");

        oracleSGAModel.setBufferCacheSize(bufferCacheSize);
        oracleSGAModel.setDictSize(sgaDevDict);
        oracleSGAModel.setFixedSGASize(fixedSGASize);
        oracleSGAModel.setJavaPoolSize(javaPoolSize);
        oracleSGAModel.setRedoLogCacheSize(redoBuffers);
        oracleSGAModel.setSqlAreaSize(sqlArea);
        oracleSGAModel.setLargePoolSize(largePoolSize);
        oracleSGAModel.setLibCacheSize(libCache);
        oracleSGAModel.setSharePoolSize(sharedPoolSize);
        return oracleSGAModel;
    }

    @Override
    public SGAStateModel viewSGAStateInfo(String monitorId) {
        DBUtil4Monitor.changeConnection(monitorId);
        SGAStateModel sgaStateModel = new SGAStateModel();
        String sql1 = OracleMonitorSql.bufferRatio;
        String sql2 = OracleMonitorSql.dictionaryRatio;
        String sql3 = OracleMonitorSql.libraryRatio;
        String sql4 = OracleMonitorSql.sgaFreeMemory;
        List<Map<String, String>> rsList1 = DBUtil.queryStrMaps(SqlObj.newInstance(sql1));
        List<Map<String, String>> rsList2 = DBUtil.queryStrMaps(SqlObj.newInstance(sql2));
        List<Map<String, String>> rsList3 = DBUtil.queryStrMaps(SqlObj.newInstance(sql3));
        List<Map<String, String>> rsList4 = DBUtil.queryStrMaps(SqlObj.newInstance(sql4));
        sgaStateModel.setBufferHitRate(rsList1.get(0).get("Hit Ratio"));
        sgaStateModel.setDictHitRate(rsList2.get(0).get("dictRatio"));
        sgaStateModel.setLibHitRate(rsList3.get(0).get("libHitRatio"));
        sgaStateModel.setUnusedCache(rsList4.get(0).get("free memory"));
        return sgaStateModel;
    }

    @Override
    public EventInfoModel viewHitRateStaInfo(String monitorId) {
        EventInfoModel eventInfoModel = new EventInfoModel();
        eventInfoModel.setTitle("SGA的指标");
        SimpleDateFormat sdf = new SimpleDateFormat("HH：mm");
        Long time = System.currentTimeMillis();
        Date end = new Date(time);
        Date start = new Date(time - 3600 * 1000);
        eventInfoModel.setStartTime(start.getTime() + "");
        eventInfoModel.setEndTime(end.getTime() + "");
        eventInfoModel.setEventName("连接时间");

        List<Lastevent> lasteventList = lasteventRepository.findLastEventList(monitorId, start, end);

        if (lasteventList == null || lasteventList.size() == 0) {
            return eventInfoModel;
        } else {
            List<OracleSGAHitRateModel> oracleSGAHitRateModelList = new ArrayList<OracleSGAHitRateModel>();
            for(Lastevent lastevent:lasteventList){
                OracleSGAHitRateModel oracleSGAHitRateModel = new OracleSGAHitRateModel();
                oracleSGAHitRateModel.setBufferHitRate(lastevent.getBufferHitRate()+"");
                oracleSGAHitRateModel.setDictHitRate(lastevent.getDickHitRate()+"");
                oracleSGAHitRateModel.setLibHitRate(lastevent.getBufferLibHitRate()+"");

                oracleSGAHitRateModel.setStartTime(start.getTime()+"");
                oracleSGAHitRateModel.setEndTime(end.getTime()+"");
                String recordTime = sdf.format(lastevent.getRecordTime());
                oracleSGAHitRateModel.setRecordTime(recordTime);

                oracleSGAHitRateModelList.add(oracleSGAHitRateModel);
            }
            eventInfoModel.setSgaHitRateModels(oracleSGAHitRateModelList);
        }
        return eventInfoModel;
    }
}
