package com.sinosoft.one.bpm.variable;

import com.sinosoft.one.bpm.aspect.Variable;

public interface VariableHandler {
	void handler(Object[] args, Variable variable) throws Exception;
}
