package com.sinosoft.one.monitoragent.notification;

public interface MethodInitConfigure {
	
	public String getMethodName() ;

	public String getClassName() ;

	public String getThreshold();

	public String getEnvironment();

	public String getInterval() ;
}
