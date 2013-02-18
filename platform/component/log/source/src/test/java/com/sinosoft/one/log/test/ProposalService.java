package com.sinosoft.one.log.test;

import com.sinosoft.one.log.LogTraced;

public interface ProposalService {

	String proposal(String proposalNo);

	String save();

	void testParam(int a, char b);

	void notTracedService();

	void testlog();

//	@LogTraced(description = "测试Trace")
	void testInterfaceTraced();

	void testProductTraced();

	void testDevelopTraced();

	void testTestTraced();
}
