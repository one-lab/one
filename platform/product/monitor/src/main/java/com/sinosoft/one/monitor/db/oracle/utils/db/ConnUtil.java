package com.sinosoft.one.monitor.db.oracle.utils.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConnUtil {
	
	public static String URL ;
	public static String USER ;
	public static String PASSWORD ;
	/**
	 * 是否需要回收localConnPool中垃圾的阈值
	 * 如果达到这个值则对localConnPool进行垃圾回收
	 */
	public static int SIZE ;
	private static Map<Thread, Connection> localConnPool = new HashMap<Thread, Connection>();

    protected static void clearPool(){
        Connection conn;
        Set<Thread> keyset = localConnPool.keySet();
        if(keyset!=null){
            for(Thread key:keyset){
                conn = localConnPool.get(key);
                close(conn);
                //localConnPool.remove(key);
                localConnPool.put(key,null);
            }
        }
    }
	/**
	 * 获取不到Connection时返回null
	 * 
	 * @return
	 */
	protected static Connection getConnection() {
		Connection conn = localConnPool.get(Thread.currentThread());
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				localConnPool.put(Thread.currentThread(), conn);
			}
		} catch (SQLException e1) {
			// 记录日志
			e1.printStackTrace();
		}
		return conn;
	}
	
	protected static void closeConnection(){
		int localConnPoolSize = localConnPool.size();
		/**
		 * 如果大于SIZE，则对localConnPool进行垃圾回收
		 */
		if(localConnPoolSize>=SIZE){
			Connection conn;
			Set<Thread> keyset = localConnPool.keySet();
			for(Thread key:keyset){
				conn = localConnPool.get(key);
				if(key==null){
					close(conn);
					localConnPool.remove(key);
				}else if(!key.isAlive()){
					close(conn);
					localConnPool.remove(key);
				}else{
					try {
						if(conn.isClosed()){
							localConnPool.remove(key);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			}
		}
	}
	
	private static void close(Connection conn){
		try {
			if(conn!=null&&!conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			// 记录日志
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(null, "d");
		System.out.println(map.get(null));
//		System.out.println(URL);
//		System.out.println(USER);
//		System.out.println(PASSWORD);
//		System.out.println(getConnection());
	}
}
