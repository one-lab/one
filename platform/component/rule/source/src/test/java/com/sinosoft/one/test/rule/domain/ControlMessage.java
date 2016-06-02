package com.sinosoft.one.test.rule.domain;

import java.io.Serializable;

public class ControlMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8452290012548288915L;
	private boolean resultFlag=false;
	private String resultMessage;
	public boolean isResultFlag() {
		return resultFlag;
	}
	public void setResultFlag(boolean resultFlag) {
		this.resultFlag = resultFlag;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}	
}
