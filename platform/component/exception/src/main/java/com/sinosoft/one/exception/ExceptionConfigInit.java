package com.sinosoft.one.exception;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异常初始化类
 *
 * @author zhujinwei
 */
public final class ExceptionConfigInit {

    private static boolean isFinishInit = false;

    private String exceptionConfigPath;

    private static final String XML_DEFAULT_ENCODE = "UTF-8";

    /**
     * 初始化
     */
    public void init() {
        parserXml(exceptionConfigPath);
    }

    /**
     * 获取异常配置文件路径
     */
    private String getFilePath(String exceptionConfigPath)
            throws UnsupportedEncodingException {
        String filePath = this.getClass().getClassLoader()
                .getResource(exceptionConfigPath).getPath();
        filePath = java.net.URLDecoder.decode(filePath, "utf-8");
        return filePath;
    }

    /**
     * 解析异常配置文件
     */
    @SuppressWarnings("rawtypes")
    private void parserXml(String exceptionConfigPath) {
        if (!isFinishInit) {
            try {

                String filePath = getFilePath(exceptionConfigPath);
                File file = new File(filePath);
                Document document = new SAXReader().read(file);
                document.setXMLEncoding(XML_DEFAULT_ENCODE);
                /**
                 * 解析配置文件，初始化userExceptionMap
                 */
                Element root = document.getRootElement();
                Element userExceptions = root.element("UserExceptions");
//				Element handleException = root.element("HandleException");
                Element exceptionLevels = root.element("ExceptionLevels");

                for (Iterator it_userException = userExceptions
                        .elementIterator(); it_userException.hasNext();) {
                    Element userException = (Element) it_userException.next();
                    HashMap<String, Object> subUserExceptionMap = new HashMap<String, Object>();
                    for (Iterator it_subUserException = userException
                            .elementIterator(); it_subUserException.hasNext();) {
                        Element subUserException = (Element) it_subUserException
                                .next();
                        HashMap<String, Object> concreteExceptionMap = new HashMap<String, Object>();
                        for (Iterator it_concreteException = subUserException
                                .elementIterator(); it_concreteException
                                .hasNext();) {
                            Element concreteException = (Element) it_concreteException
                                    .next();
                            ExceptionLevel exceptionLevel = ExceptionLevel.UNSERIOUS;
                            if (concreteException.attribute("Level") != null) {
                                String level = concreteException
                                        .attributeValue("Level");
                                exceptionLevel = ExceptionLevel.instanceOf(level);
                            }
                            String code = concreteException
                                    .elementText("ExceptionCode");
                            String desc = concreteException
                                    .elementText("ExceptionDesc");
                            XmlConcreteException xmlConcreteException = new XmlConcreteException(
                                    exceptionLevel, code, desc);
                            concreteExceptionMap.put(code, xmlConcreteException);
                        }
                        subUserExceptionMap.put(
                                subUserException.attributeValue("Code"),
                                concreteExceptionMap);
                    }
                    ExceptionConfig.putSubUserExceptionMap(
                            userException.attributeValue("Code"),
                            subUserExceptionMap);

                }
                /**
                 * 初始化手机号数组Tels和邮件数组Emails
                 */
//				for (Iterator it_telNums = handleException.element("TelNums")
//						.elementIterator(); it_telNums.hasNext();) {
//					Element telNum = (Element) it_telNums.next();
//					ExceptionConfig.addTel(telNum.getText());
//				}

//				for (Iterator it_emailAddresses = handleException.element(
//						"EmailAddresses").elementIterator(); it_emailAddresses
//						.hasNext();) {
//					Element emailAddress = (Element) it_emailAddresses.next();
//					ExceptionConfig.addEmail(emailAddress.getText());
//				}
                /**
                 * 初始化异常处理级别
                 */
                for (Iterator it_exceptionLevels = exceptionLevels
                        .elementIterator(); it_exceptionLevels.hasNext();) {
                    Element exceptionLevel = (Element) it_exceptionLevels
                            .next();
                    String Level = exceptionLevel.getText();
                    String isSave = exceptionLevel
                            .attributeValue("IsSave");
                    String isWarning = exceptionLevel
                            .attributeValue("IsWarning");
                    String desc = exceptionLevel.attributeValue("Description");
                    ExceptionLevelHandle LevelHandle = new ExceptionLevelHandle(
                            Level, desc, isSave, isWarning);
                    ExceptionConfig.putLevelMap(Level, LevelHandle);
                }
            } catch (UnsupportedEncodingException e) {
                Logger dbLogger = LoggerFactory.getLogger("DBLog");
                dbLogger.error("获取异常配置文件路径出错", e);
            } catch (DocumentException e) {
                Logger dbLogger = LoggerFactory.getLogger("DBLog");
                dbLogger.error("解析异常配置文件失败", e);
            } catch (RuntimeException re) {
                Logger dbLogger = LoggerFactory.getLogger("DBLog");
                dbLogger.error("解析异常配置文件失败,出现运行时异常", re);
            } finally {
                Logger logger = LoggerFactory
                        .getLogger(ExceptionConfigInit.class);
                logger.info("异常配置文件解析完毕");
                isFinishInit = true;
            }
        } else {
            Logger logger = LoggerFactory.getLogger(ExceptionConfigInit.class);
            logger.info("异常配置文件已经被解析过");
        }
    }

    /**
     * 是否完成初始化
     *
     * @return boolean
     */
    public static boolean isFinishInit() {
        return isFinishInit;
    }

    public String getExceptionConfigPath() {
        return exceptionConfigPath;
    }

    public void setExceptionConfigPath(String exceptionConfigPath) {
        this.exceptionConfigPath = exceptionConfigPath;
    }
}
