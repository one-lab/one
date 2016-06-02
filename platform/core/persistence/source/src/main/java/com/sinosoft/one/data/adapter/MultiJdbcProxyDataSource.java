package com.sinosoft.one.data.adapter;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.model.IllegalMappingException;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.aspectj.AbstractTransactionAspect;
import org.springframework.transaction.aspectj.AnnotationTransactionAspect;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * 多数据源代理dataSource
 * User: ChengQi
 * Date: 13-4-16
 * Time: PM5:37
 */
public class MultiJdbcProxyDataSource implements DataSource {

    private static final InheritableThreadLocal<ConnectionInfo> connectionInfoHolder = new InheritableThreadLocal<ConnectionInfo>();

    private static Logger logger = LoggerFactory.getLogger(MultiJdbcProxyDataSource.class);

    private static Map<?,DataSource> realDataSourceMap = Maps.newConcurrentMap();

    private DataSource getRealDataSource(){
        if(realDataSourceMap.isEmpty()){
            throw new IllegalMappingException("实际的dataSource为空");
        }
        if(connectionInfoHolder.get()==null){
            return realDataSourceMap.values().iterator().next();
        }
        else{
            ConnectionInfo connectionInfo = connectionInfoHolder.get();
            if(logger.isDebugEnabled())
                logger.debug("当前dataSource是:{}",connectionInfo.getRouterFlag());
            return realDataSourceMap.get(connectionInfo.getRouterFlag());
        }

    }

    public void setRealDataSourceMap(Map<?,DataSource> realDataSourceMap){
       this.realDataSourceMap = realDataSourceMap;
    }

    public Connection getConnection() throws SQLException {
        logger.debug("getConnection = " );
        Connection connection = getRealDataSource().getConnection();
        this.connectionInfoHolder.get().setRealConnection(connection);
        return new ConnectionSpy(this,connection);
    }

    public Connection getConnection(String username, String password) throws SQLException {
        logger.debug("getConnection2 = " +username);
        Connection connection = getRealDataSource().getConnection(username,password);
        connectionInfoHolder.get().setRealConnection(connection);
        return new ConnectionSpy(this,connection);
    }

    public PrintWriter getLogWriter() throws SQLException {
        logger.debug("getLogWriter = " );
        return getRealDataSource().getLogWriter();
    }

    public void setLogWriter(PrintWriter out) throws SQLException {
        logger.debug("getLogWriter2 = " );
        getRealDataSource().setLogWriter(out);
    }

    public void setLoginTimeout(int seconds) throws SQLException {
        logger.debug("seconds = " +seconds);
        getRealDataSource().setLoginTimeout(seconds);
    }

    public int getLoginTimeout() throws SQLException {
        logger.debug("is loginTimeOut");
        return getRealDataSource().getLoginTimeout();
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        logger.debug("unwrap = " );
        return getRealDataSource().unwrap(iface);
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        logger.debug("isWrapperFor = " );
        return getRealDataSource().isWrapperFor(iface);
    }

    ConnectionInfo getConnectionInfo(){
        return connectionInfoHolder.get();
    }


    protected static  final class ConnectionInfo<Key>{

        //上一条oldConnectionInfo
        private ConnectionInfo previous;

        private Connection realConnection;

        private Key routerFlag;

        public ConnectionInfo(Key routerFlag){
            if(realDataSourceMap.containsKey(routerFlag))
                this.routerFlag = routerFlag;
            else
                throw new IllegalStateException("传入的路由标识为："+routerFlag+
                        "，没有在当前dataSource中找到匹配的库");
        }

        Key getRouterFlag(){
            return this.routerFlag;
        }

        void setRealConnection(Connection realConnection){
            this.realConnection = realConnection;
        }

        void bindToThread(){
            this.previous = connectionInfoHolder.get();
            connectionInfoHolder.set(this);
        }

        Connection getRealConnection(){
           return this.realConnection;
        }


        public  void set(String flag){
            /*
                事务与set必须是一对一的关联，如果当前没有任何事务,可以随意放置.
                由于事务需要开启连接，而开启连接的时候已经决定了此次的库，所以需要在开启事务之前就开始set。
                但如果是嵌套事务，在在第一个事务之后，第二个事务之前需要set
                如果有事务，需要获取当前事务，并且知道当前事务是否是个新事务，如果是新事务

            */

           // threadLocal.set(flag);
        }
    }
}
