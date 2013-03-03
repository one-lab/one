package com.sinosoft.one.monitor.db.oracle.utils.db;
import java.util.Properties;

public class DBDriver {
	public static void start(){
		Properties dataSource =  ClassLoaderUtil.getProperties("datasource.properties");
		String driver = dataSource.getProperty("ds.driver");
		ConnUtil.URL = dataSource.getProperty("ds.url");
		ConnUtil.USER = dataSource.getProperty("ds.username");
		ConnUtil.PASSWORD = dataSource.getProperty("ds.password");
		ConnUtil.SIZE = Integer.parseInt(dataSource.getProperty("ds.size"));
		ClassLoaderUtil.loadClass(driver);
	}
	public static void start(String DRIVER,String URL,String USER,String PASSWORD,int SIZE){
		ClassLoaderUtil.loadClass(DRIVER);
		ConnUtil.URL = URL;
		ConnUtil.USER = USER;
		ConnUtil.PASSWORD = PASSWORD;
		ConnUtil.SIZE = SIZE;
	}
}
