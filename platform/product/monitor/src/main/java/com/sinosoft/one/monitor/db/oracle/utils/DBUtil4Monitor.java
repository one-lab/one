package com.sinosoft.one.monitor.db.oracle.utils;

import com.sinosoft.one.monitor.db.oracle.model.Info;
import com.sinosoft.one.monitor.db.oracle.monitorSql.OracleMonitorSql;
import com.sinosoft.one.monitor.db.oracle.repository.InfoRepository;
import com.sinosoft.one.monitor.db.oracle.utils.db.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;

/**
 * User: Chunliang.Han
 * Date: 13-3-2
 * Time: 上午10:15
 */
public class DBUtil4Monitor {
    @Autowired
    private static InfoRepository infoRepository;
    public static Connection getCurrConnection(){
        return DBUtil.getConn();
    }
    public static void openConnection(String DRIVER,String URL,String USER,String PASSWORD) {
        DBUtil.reStart(DRIVER, URL, USER, PASSWORD);
    }
    public static void changeConnection(String monitorId) {
        Info info = infoRepository.findOne(monitorId);
        String ip = info.getIpAddress();
        String port = info.getPort();
        String instanceName = info.getInstanceName();
        String username = info.getUsername();
        String password = info.getPassword();
        String driver = OracleMonitorSql.DRIVER;
        String url = "jdbc:oracle:thin:@"+ip+":"+port+":"+instanceName;
        DBUtil.reStart(driver, url, username, password);
    }
}
