package com.sinosoft.one.demo.service.mail;

import com.sinosoft.one.demo.dao.mail.MailDao;
import com.sinosoft.one.demo.model.MailModel;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Intro:
 * User: Kylin
 * Date: 12-10-24
 * Time: 下午3:14
 * To change this template use File | Settings | File Templates.
 */
@Service("mailService")
public class MailServiceImpl implements IMailService {

    @Autowired
    private JavaMailSender mailSender = new JavaMailSenderImpl();

    @Autowired
    MailDao mailDao;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    public void sendTextMail(String from, String to, String caption, String content) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(from);
        mail.setTo(to);
        mail.setSubject(caption);
        mail.setText(content);

//        Properties properties = System.getProperties();
//        properties.setProperty("socks.ProxyHost", "127.0.0.1");
        mailSender.send(mail);
    }

    public void sendMimeMail() {
        MailModel mailModel = mailDao.findById("001");
        String content = generateEmailContent("mailTemplate.ftl",mailModel.getSendTo(),mailModel.getContent());

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom("yangming841022@163.com");
            helper.setTo(mailModel.getSendTo());
            helper.setSubject(mailModel.getSubject());
            helper.setText(content,true);
            helper.addAttachment("tu.gif",new File(mailModel.getFilePath()));

//            String fileName = null;
//            if(attachementFiles != null && attachementFiles.size() > 0){
//                for(File f : attachementFiles) {
//                    fileName = f.getPath();
//                    fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
//
//                    try {
//                        helper.addAttachment(MimeUtility.encodeWord(fileName, encoding,null), f);
//                    } catch (UnsupportedEncodingException e) {
//                        e.printStackTrace();
//                        helper.addAttachment(fileName, f);
//                    }
//                }
//            }

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(message);
    }

    @SuppressWarnings("unchecked")
    public String generateEmailContent(String templateName,String sendto,String content) {
        Map<String,String> map = new HashMap<String, String>();

        map.put("sendto",sendto);
        map.put("content",content);
        try {
            Template temp = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
            return FreeMarkerTemplateUtils.processTemplateIntoString(temp, map);
        } catch (TemplateException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
