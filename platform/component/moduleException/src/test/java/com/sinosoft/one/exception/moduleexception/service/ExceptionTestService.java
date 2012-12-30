package com.sinosoft.one.exception.moduleexception.service;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.moduleexception.businessexception.ExceptionBuilder;
import com.sinosoft.one.exception.moduleexception.businessexception.MaintainServiceException;
import com.sinosoft.one.exception.moduleexception.businessexception.PaymentCommonException;
import com.sinosoft.one.exception.moduleexception.businessexception.UserServiceException;

public class ExceptionTestService {

    /*
     * code方式抛异常 --正确方式
     */
    public static void method_1() throws UserServiceException {
        System.out.println("code方式正确方法1抛出异常");
        throw ExceptionBuilder.builder(UserServiceException.class).newInstanceCode("000");
    }

    public static void method_2() throws UserServiceException {
        System.out.println("code方式正确方法2抛出异常");
        try {
            throw new IllegalAccessException();
        }catch (Exception e){
            throw UserServiceException.newInstanceMsg("user模块具体异常描述001",
                    e);
        }

    }

    /*
     * code方式抛异常 --错误方式
     */
    public static void method_3() throws UserServiceException {
        System.out.println("code方式错误方法3抛出异常");
        throw UserServiceException.newInstanceCode(null);
    }

    public static void method_4() throws UserServiceException {
        System.out.println("code方式错误方法4抛出异常");
        throw UserServiceException.newInstanceCode("xxxx");
    }

    public static void method_5() throws UserServiceException {
        System.out.println("code方式错误方法5抛出异常");
        throw UserServiceException.newInstanceCode("");
    }

    public static void method_6() throws UserServiceException {
        System.out.println("code方式错误方法6抛出异常");
        throw UserServiceException.newInstanceCode(null, null);
    }

    public static void method_7() throws UserServiceException {
        System.out.println("code方式错误方法7抛出异常");
        throw UserServiceException.newInstanceCode("xxx", null);
    }

    public static void method_8() throws UserServiceException {
        System.out.println("code方式错误方法8抛出异常");
        throw UserServiceException.newInstanceCode("", null);
    }

    public static void method_19() throws MaintainServiceException {
        System.out.println("code方式错误方法19抛出异常  配置文件未配置级别属性");
        throw MaintainServiceException.newInstanceCode("000");
    }
    public static void method_20() throws MaintainServiceException {
        System.out.println("code方式错误方法20抛出异常  配置文件级别属性配置错误");
        throw MaintainServiceException.newInstanceCode("001");
    }
    /*
     * msg方式抛异常 --正确方式
     */
    public static void method_9() throws UserServiceException {
        System.out.println("msg方式正确方法9抛出异常");
        throw UserServiceException.newInstanceMsg("投保异常");
    }

    public static void method_10() throws UserServiceException {
        System.out.println("msg方式正确方法10抛出异常");
        throw UserServiceException.newInstanceMsg("投保异常",
                new Throwable());
    }

    public static void method_11() throws UserServiceException {
        System.out.println("msg方式正确方法11抛出异常");
        throw UserServiceException.newInstanceMsg("投保异常",
                new Throwable(), ExceptionLevel.MORESERIOUS);
    }

    /*
     * msg方式抛异常 --错误方式
     */
    public static void method_12() throws UserServiceException {
        System.out.println("msg方式错误方法12抛出异常");
        throw UserServiceException.newInstanceMsg("");
    }

    public static void method_13() throws UserServiceException {
        System.out.println("msg方式错误方法13抛出异常");
        throw UserServiceException.newInstanceMsg(null);
    }

    public static void method_14() throws UserServiceException {
        System.out.println("msg方式错误法14抛出异常");
        throw UserServiceException.newInstanceMsg(null, null);
    }

    public static void method_15() throws UserServiceException {
        System.out.println("msg方式错误方法15抛出异常");
        throw UserServiceException.newInstanceMsg(null, null, null);
    }

    public static void method_16() throws UserServiceException {
        System.out.println("msg方式错误方法16抛出异常");
        throw UserServiceException.newInstanceMsg("投保异常",
                new Throwable(), null);
    }

    public static void method_17() throws UserServiceException {
        System.out.println("msg方式错误方法17抛出异常");
        throw UserServiceException.newInstanceMsg("", null);
    }

    public static void method_18() throws UserServiceException {
        System.out.println("msg方式错误方法18抛出异常");
        throw UserServiceException.newInstanceMsg("", null, null);
    }
    //测试PaymentCommonException异常
    public static void method_49() throws PaymentCommonException {
//		System.out.println("msg方式错误方法18抛出异常");
        throw PaymentCommonException.newInstanceCode("002");
    }
}
