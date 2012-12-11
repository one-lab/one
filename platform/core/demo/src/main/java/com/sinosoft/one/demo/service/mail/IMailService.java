package com.sinosoft.one.demo.service.mail;

/**
 * Intro: Provide mail function
 * User: Kylin
 * Date: 12-10-24
 * Time: 下午3:14
 * To change this template use File | Settings | File Templates.
 */
public interface IMailService {

    public void sendTextMail(String from, String to, String caption, String content );

    public void sendMimeMail();

}
