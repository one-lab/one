/**
 *
 * 用户异常基类
 *
 * @author zhujinwei
 */
public abstract class UserException extends RuntimeException {

    private Throwable cause = null;
    private final String exceptionKind = "01";
    private String userExceptionCode = "";
    private String subUserExceptionCode = "";
    private String concreteExceptionCode = "";
    private String msg = "";
    private ExceptionGrade grade = ExceptionGrade.UNSERIOUS;

    public UserException(String userExceptionCode, String subUserExceptionCode,
                         String concreteExceptionCode, String msg, Throwable cause,
                         ExceptionGrade grade) {
        if (msg != null) {
            this.msg = msg;
        }
        if (grade != null) {
            this.grade = grade;
        }
        if (userExceptionCode != null) {
            this.userExceptionCode = userExceptionCode;

        }
        if (subUserExceptionCode != null) {
            this.subUserExceptionCode = subUserExceptionCode;
        }
        if (concreteExceptionCode != null) {
            this.concreteExceptionCode = concreteExceptionCode;
        }
        if (!("").equals(this.concreteExceptionCode)
                && !("").equals(this.subUserExceptionCode)
                && !("").equals(this.userExceptionCode)) {
            XmlConcreteException xmlConcreteException = ExceptionConfig
                    .getXmlConcreteException(exceptionKind, userExceptionCode,
                            subUserExceptionCode, concreteExceptionCode);
            if (xmlConcreteException != null) {
                this.msg = xmlConcreteException.getExceptionDesc();
                this.grade = xmlConcreteException.getGrade();
            }
        }

        this.cause = cause;
    }

    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    public String getUserExceptionCode() {
        return userExceptionCode;
    }

    public void setUserExceptionCode(String userExceptionCode) {
        this.userExceptionCode = userExceptionCode;
    }

    public String getSubUserExceptionCode() {
        return subUserExceptionCode;
    }

    public void setSubUserExceptionCode(String subUserExceptionCode) {
        this.subUserExceptionCode = subUserExceptionCode;
    }

    public String getConcreteExceptionCode() {
        return concreteExceptionCode;
    }

    public void setConcreteExceptionCode(String concreteExceptionCode) {
        this.concreteExceptionCode = concreteExceptionCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ExceptionGrade getGrade() {
        return grade;
    }

    public void setGrade(ExceptionGrade grade) {
        this.grade = grade;
    }

    public String getExceptionKind() {
        return exceptionKind;
    }

    private static final long serialVersionUID = 1L;
}
