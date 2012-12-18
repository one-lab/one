package com.sinosoft.one.exception;

public class XmlConcreteException {
	private ExceptionGrade grade = ExceptionGrade.UNSERIOUS;
	private String exceptionCode = "";
	private String exceptionDesc = "";

	public XmlConcreteException(ExceptionGrade grade, String exceptionCode,
			String exceptionDesc) {
		this.grade = grade;
		this.exceptionCode = exceptionCode;
		this.exceptionDesc = exceptionDesc;
	}

	public ExceptionGrade getGrade() {
		return grade;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public String getExceptionDesc() {
		return exceptionDesc;
	}

}
