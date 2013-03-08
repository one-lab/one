package com.sinosoft.one.monitor.db.oracle.utils;

import com.sinosoft.one.monitor.db.oracle.model.Info;
import com.sinosoft.one.monitor.db.oracle.monitorSql.OracleMonitorSql;
import com.sinosoft.one.monitor.db.oracle.repository.InfoRepository;
import com.sinosoft.one.monitor.db.oracle.utils.db.ClassLoaderUtil;
import com.sinosoft.one.monitor.db.oracle.utils.db.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

/**
 * User: Chunliang.Han
 * Date: 13-3-2
 * Time: 上午10:15
 */
@Component
public class DBUtil4Monitor {
    @Autowired
    private InfoRepository infoRepository;
    public static void openConnection(String DRIVER,String URL,String USER,String PASSWORD) {
        DBUtil.reStart(DRIVER, URL, USER, PASSWORD);
    }
    public void changeConnection(String monitorId) {
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
    public long connectTime(Info info){
        Date begin = new Date();
        Connection conn = getConnection(info);
        Date end = new Date();
        long connectTime = end.getTime() - begin .getTime() ;
        closeConnection(conn);
        return connectTime;
    }
    public void closeConnection(Connection conn){
        try {
            if(conn!=null&&!conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            // 记录日志
            e.printStackTrace();
        }
    }



    public static Connection getConnection(Info info){
        String ip = info.getIpAddress();
        String port = info.getPort();
        String instanceName = info.getInstanceName();
        String username = info.getUsername();
        String password = info.getPassword();
        String driver = OracleMonitorSql.DRIVER;
        String url = "jdbc:oracle:thin:@"+ip+":"+port+":"+instanceName;
        System.out.print(url);
        Connection conn = null;
        try {
            if (conn == null || conn.isClosed()) {
            	ClassLoaderUtil.loadClass(driver);
                conn = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException e1) {
            // 记录日志
            e1.printStackTrace();
        }
        return conn;
    }
}
