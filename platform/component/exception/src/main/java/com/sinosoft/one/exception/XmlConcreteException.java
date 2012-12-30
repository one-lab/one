package com.sinosoft.one.exception;

public class XmlConcreteException {
	private ExceptionLevel level = ExceptionLevel.UNSERIOUS;
	private String exceptionCode = "";
	private String exceptionDesc = "";

	public XmlConcreteException(ExceptionLevel level, String exceptionCode,
			String exceptionDesc) {
		this.level = level;
		this.exceptionCode = exceptionCode;
		this.exceptionDesc = exceptionDesc;
	}

	public ExceptionLevel getLevel() {
		return level;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public String getExceptionDesc() {
		return exceptionDesc;
	}

}
