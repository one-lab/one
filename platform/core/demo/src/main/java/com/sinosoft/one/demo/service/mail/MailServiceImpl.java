package com.sinosoft.one.demo.service.mail;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Intro:
 * User: Kylin
 * Date: 12-10-24
 * Time: 下午3:14
 * To change this template use File | Settings | File Templates.
 */
@Service("mailService")
public class MailServiceImpl implements IMailService {

    private ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    private JavaMailSender mailSender = (JavaMailSender)ctx.getBean("MailSender");


    public void sendTextMail(String from, String to, String caption, String content) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(from);
        mail.setTo(to);
        mail.setSubject(caption);
        mail.setText(content);

        mailSender.send(mail);
    }

    public void sendMimeMail(String from, String to, String caption, String content) {

        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        MimeMessage msg = senderImpl.createMimeMessage();
        try {
            //设置编码格式以防止乱码
            MimeMessageHelper helper = new MimeMessageHelper(msg,true,"utf-8");
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(caption);
            helper.setText(content,true);

            mailSender.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendMailAndAdjunct(String from, String to, String caption, String content, String filePath) {

        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        MimeMessage msg = senderImpl.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(caption);
            helper.addInline("file01",new File(filePath));

            mailSender.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
