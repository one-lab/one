package com.sinosoft.one.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ins.framework.exception.BusinessException;

public class ProposalServiceImpl  implements ProposalService {

	public String proposal(String proposalNo) {
		throw new BusinessException("aa", false);
	}

	public String save() {
		System.out.println("--------save---");
		return "0912932130213";
	}

	@LogTraced(description = "此处演示如何进行参数,第一个参数${[0]},第二个参数${[1]}")
	public void testParam(int a, char b) {
		System.out.println("testParam ......test @LogTraced");
	}

	@LogTraced(env= Environment.PRODUCT)
	public void testProductTraced() {
		System.out.println("@ImplTraced(enableId=true,configEnv=Environment.PRODUCT)");
	}

	@LogTraced(env=Environment.DEVLEOP)
	public void testDevelopTraced() {
		System.out
				.println("@ImplTraced(enableId=true,configEnv=Environment.DEVLEOP)");
	}

	@LogTraced(env = Environment.TEST)
	public void testTestTraced() {
		System.out.println("@ImplTraced(enableId=true,configEnv=Environment.TEST)");
	}

	

	public void testlog() {
		Logger dbLogger = LoggerFactory.getLogger("DBLog");
		dbLogger.info("[@Trace:MethodTarce]方法调用dblogger");
	}

	public void testInterfaceTraced() {
		System.out.println("testInterfaceTraced");
	}

    //不记录任何日志
	public void notTracedService() {

	}
}
