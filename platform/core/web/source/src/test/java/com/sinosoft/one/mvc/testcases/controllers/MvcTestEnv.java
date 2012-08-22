package com.sinosoft.one.mvc.testcases.controllers;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import com.sinosoft.one.mvc.MvcFilter;
import com.sinosoft.one.mvc.mock.web.instruction.MockInstructionExecutor;
import com.sinosoft.one.mvc.web.instruction.InstructionExecutorImpl;

import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.mock.web.MockFilterConfig;
import org.springframework.mock.web.MockServletContext;

public class MvcTestEnv {

    private static MvcTestEnv env;

    private MvcFilter mvcFilter;

    private MockInstructionExecutor instructionExecutor;
    
    private InstructionExecutorImpl InstructionExecutorImpl;

    public InstructionExecutorImpl getInstructionExecutorImpl() {
		return InstructionExecutorImpl;
	}

	public synchronized static MvcTestEnv instance() throws ServletException {
        if (env == null) {
            env = new MvcTestEnv();
        }
        return env;
    }

    private MvcTestEnv() throws ServletException {
        File file = new File("target/test");
        ServletContext servletContext = new MockServletContext(file.getPath(),
                new FileSystemResourceLoader());
        instructionExecutor = new MockInstructionExecutor();
        instructionExecutor.setStoresInstructionInRequest(true);
        mvcFilter = new MvcFilter();
        mvcFilter.setInstructionExecutor(instructionExecutor);
        mvcFilter.setContextConfigLocation("classpath*:/applicationContext*.xml");
        mvcFilter.init(new MockFilterConfig(servletContext, "mvcFilter"));
    }

    public MvcFilter getMvcFilter() {
        return mvcFilter;
    }

    public MockInstructionExecutor getInstructionExecutor() {
        return instructionExecutor;
    }

}
