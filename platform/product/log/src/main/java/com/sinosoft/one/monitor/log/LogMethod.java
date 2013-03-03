package com.sinosoft.one.monitor.log;

/**
 * Log Method 类.
 * User: carvin
 * Date: 12-12-13
 * Time: 下午1:46
 * To change this template use File | Settings | File Templates.
 */
public class LogMethod {
	private String id;
    private String className;
    private String methodName;

	public LogMethod() {}
    public  LogMethod(String id, String className, String methodName) {
	    this.id = id;
        this.className = className;
        this.methodName = methodName;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public boolean matches(String className, String methodName) {
        return this.className.equalsIgnoreCase(className) && this.methodName.equalsIgnoreCase(methodName);
    }

    public String getFullMethodName() {
        return getClassName() + "." + getMethodName();
    }


    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        } else if(! (o instanceof LogMethod)) {
            return false;
        } else {
            LogMethod targetLogMethod = (LogMethod) o;
            return targetLogMethod.className.equals(this.className) && targetLogMethod.methodName.equals(this.methodName);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + className.hashCode();
        result = prime * result + methodName.hashCode();
        return result;
    }
}
