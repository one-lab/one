package com.sinosoft.one.exception.service;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.GeProposalBusinessException;
import com.sinosoft.one.exception.GeUnderwriteBusinessException;
import com.sinosoft.one.exception.userexception.ExceptionBuilder;

public class ExceptionTestService {

    /*
      * code方式抛异常 --正确方式
      */
    public static void method_1() throws GeProposalBusinessException {
        System.out.println("code方式正确方法1抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceCode("000");
    }

    public static void method_2() throws GeProposalBusinessException {
        System.out.println("code方式正确方法2抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceCode("001",
                new Throwable());
    }

    /*
      * code方式抛异常 --错误方式
      */
    public static void method_3() throws GeProposalBusinessException {
        System.out.println("code方式错误方法3抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceCode(null);
    }

    public static void method_4() throws GeProposalBusinessException {
        System.out.println("code方式错误方法4抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceCode("xxxx");
    }

    public static void method_5() throws GeProposalBusinessException {
        System.out.println("code方式错误方法5抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceCode("");
    }

    public static void method_6() throws GeProposalBusinessException {
        System.out.println("code方式错误方法6抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceCode(null, null);
    }

    public static void method_7() throws GeProposalBusinessException {
        System.out.println("code方式错误方法7抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceCode("xxx", null);
    }

    public static void method_8() throws GeProposalBusinessException {
        System.out.println("code方式错误方法8抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceCode("", null);
    }

    public static void method_19() throws GeUnderwriteBusinessException {
        System.out.println("code方式错误方法19抛出异常  配置文件未配置级别属性");
        throw ExceptionBuilder.builder(GeUnderwriteBusinessException.class).newInstanceCode("000");
    }
    public static void method_20() throws GeUnderwriteBusinessException {
        System.out.println("code方式错误方法20抛出异常  配置文件级别属性配置错误");
        throw ExceptionBuilder.builder(GeUnderwriteBusinessException.class).newInstanceCode("001");
    }
    /*
      * msg方式抛异常 --正确方式
      */
    public static void method_9() throws GeProposalBusinessException {
        System.out.println("msg方式正确方法9抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceMsg("投保异常");
    }

    public static void method_10() throws GeProposalBusinessException {
        System.out.println("msg方式正确方法10抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceMsg("投保异常",
                new Throwable());
    }

    public static void method_11() throws GeProposalBusinessException {
        System.out.println("msg方式正确方法11抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceMsg("投保异常",
                new Throwable(), ExceptionLevel.MORESERIOUS);
    }

    /*
      * msg方式抛异常 --错误方式
      */
    public static void method_12() throws GeProposalBusinessException {
        System.out.println("msg方式错误方法12抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceMsg("");
    }

    public static void method_13() throws GeProposalBusinessException {
        System.out.println("msg方式错误方法13抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceMsg(null);
    }

    public static void method_14() throws GeProposalBusinessException {
        System.out.println("msg方式错误法14抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceMsg(null, null);
    }

    public static void method_15() throws GeProposalBusinessException {
        System.out.println("msg方式错误方法15抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceMsg(null, null, null);
    }

    public static void method_16() throws GeProposalBusinessException {
        System.out.println("msg方式错误方法16抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceMsg("投保异常",
                new Throwable(), null);
    }

    public static void method_17() throws GeProposalBusinessException {
        System.out.println("msg方式错误方法17抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceMsg("", null);
    }

    public static void method_18() throws GeProposalBusinessException {
        System.out.println("msg方式错误方法18抛出异常");
        throw ExceptionBuilder.builder(GeProposalBusinessException.class).newInstanceMsg("", null, null);
    }

}
