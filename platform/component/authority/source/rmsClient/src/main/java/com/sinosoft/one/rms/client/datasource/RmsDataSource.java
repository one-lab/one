package com.sinosoft.one.rms.client.datasource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;


import com.sinosoft.one.rms.client.DataRuleStringCreat;

public class RmsDataSource implements DataSource {
	
	private DataSource realDataSource;
	
	private DataRuleStringCreat dataRuleStringCreat;
	
	public RmsDataSource(DataSource dataSource) {
		this.realDataSource = dataSource;
	}
	
	public RmsDataSource() {
		
	}

	public Connection getConnection() throws SQLException {
		return new RmsConnection(realDataSource.getConnection(),dataRuleStringCreat);
	}

	public Connection getConnection(String username, String password)
			throws SQLException {
		return realDataSource.getConnection(username, password);
	}

	public PrintWriter getLogWriter() throws SQLException {
		return realDataSource.getLogWriter();
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
		realDataSource.setLogWriter(out);
	}

	public void setLoginTimeout(int seconds) throws SQLException {
		realDataSource.setLoginTimeout(seconds);
	}

	public int getLoginTimeout() throws SQLException {
		return realDataSource.getLoginTimeout();
	}

	public DataRuleStringCreat getDataRuleStringCreat() {
		return dataRuleStringCreat;
	}

	public void setDataRuleStringCreat(DataRuleStringCreat dataRuleStringCreat) {
		this.dataRuleStringCreat = dataRuleStringCreat;
	}

}
