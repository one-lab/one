package com.sinosoft.one.monitor.db.oracle.domain;

import com.sinosoft.one.monitor.db.oracle.model.Info;
import com.sinosoft.one.monitor.db.oracle.model.OracleInfoModel;
import com.sinosoft.one.monitor.db.oracle.monitorSql.OracleMonitorSql;
import com.sinosoft.one.monitor.db.oracle.repository.InfoRepository;
import com.sinosoft.one.monitor.db.oracle.repository.LasteventRepository;
import com.sinosoft.one.monitor.db.oracle.utils.DBUtil4Monitor;
import com.sinosoft.one.monitor.db.oracle.utils.db.DBUtil;
import com.sinosoft.one.monitor.db.oracle.utils.db.SqlObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * User: Chunliang.Han
 * Date: 13-3-1
 * Time: 上午10:03
 */
@Component
public class OracleInfoServiceImpl implements OracleInfoService {

    @Autowired
    private InfoRepository infoRepository;

    @Autowired
    private LasteventRepository lasteventRepository;

    @Override
    @Transactional
    public void saveMonitor(Info info) {
        //插入version,startTime;
        String ip = info.getIpAddress();
        String port = info.getPort();
        String instanceName = info.getInstanceName();
        String username = info.getUsername();
        String password =  info.getPassword();
        String driver = OracleMonitorSql.DRIVER;
        //"jdbc:oracle:thin:@192.168.18.151:1521:orcl"
        String url = "jdbc:oracle:thin:@"+ip+":"+port+":"+instanceName;
        DBUtil4Monitor.openConnection(driver,url,username,password);

        String sql = OracleMonitorSql.versionAndStartUpTime;
        List<Map<String,String>> rsList = DBUtil.queryStrMaps(SqlObj.newInstance(sql));
        Map<String,String> rsObj = rsList.get(0);
        String version = rsObj.get("VERSIONLABLE");
        String startTime = rsObj.get("STARTUPTIME");
        info.setVersion(version);
        info.setStartTime(startTime);
        infoRepository.save(info);
    }

    @Override
    @Transactional
    public void editMonitor(Info info) {
        Info newInfo = infoRepository.findOne(info.getId());
        newInfo.setUsername(info.getUsername());
        newInfo.setPassword(info.getPassword());
        newInfo.setInstanceName(info.getInstanceName());
        newInfo.setName(info.getName());
        newInfo.setPullInterval(info.getPullInterval());
        infoRepository.save(newInfo);
    }

    @Override
    @Transactional
    public void deleteMonitor(String monitorId) {
        infoRepository.delete(monitorId);
    }

    @Override
    public OracleInfoModel getMonitorInfo(String monitorId) {
        //2013-3-1 上午11:10      yyyy年MM月dd日 HH时mm分ss秒 E
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        OracleInfoModel oracleInfoModel = new OracleInfoModel();
        Info info = infoRepository.findOne(monitorId);
        //*健康状况与预警相关 ，暂时不做
        //oracleInfoModel.setHealth();
        oracleInfoModel.setHostName(info.getIpAddress());
        Date lastExecTime = lasteventRepository.findLastExecTime();
        oracleInfoModel.setLastExecTime(sdf.format(lastExecTime));
        Long pullIntervalMillis = info.getPullInterval()*60*1000L;
        Long nextExecTime = lastExecTime.getTime() + pullIntervalMillis;
        oracleInfoModel.setNextExecTime(sdf.format(nextExecTime));
        oracleInfoModel.setMonitorName(info.getName());
        //*操作系统信息，暂时不获取
        //oracleInfoModel.setOs();
        oracleInfoModel.setPort(info.getPort());
        //执行SQL语句查询
        oracleInfoModel.setStartTime(info.getStartTime());
        oracleInfoModel.setVersion(info.getVersion());
        return oracleInfoModel;
    }
}
