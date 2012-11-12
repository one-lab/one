package com.sinosoft.one.rms.client.sqlparser;

import java.sql.Connection;

public interface RmsSQLParser {
	 public  String parser(Connection connection, String sql)throws Exception;
}
