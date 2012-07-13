package com.sinosoft.web.instruction.reply;

import java.io.IOException;

import net.paoding.rose.web.Invocation;

public interface Reply {
	void populate(Invocation inv) throws IOException;

}
