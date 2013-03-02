package com.sinosoft.one.monitor.log;


/**
 * Loggable 工具类.
 * User: carvin
 * Date: 12-11-29
 * Time: 下午12:28
 */
public class Loggables {
    private static User user;
	private static LogConfigs logConfigs;

    public static User getUser() {
        return user;
    }

	public void setUser(User user) {
		Loggables.user = user;
	}

	public static LogConfigs getLogConfigs() {
		return logConfigs;
	}

	public void setLogConfigs(LogConfigs logConfigs) {
		Loggables.logConfigs = logConfigs;
	}

	public static String getUserId() {
        return user != null ? user.getUserCode() : "";
    }
}
