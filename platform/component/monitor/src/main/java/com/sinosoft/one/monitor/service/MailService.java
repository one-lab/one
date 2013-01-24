package com.sinosoft.one.monitor.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.sinosoft.one.monitor.dao.WarnDao;
import com.sinosoft.one.monitor.dao.warn.EmailDao;
import com.sinosoft.one.monitor.model.Warn;
import com.sinosoft.one.monitor.model.warn.Email;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@Component
public class MailService {
	@Autowired
	private JavaMailSender mailSender = new JavaMailSenderImpl();
	@Autowired
	private EmailDao emailDao;
	@Autowired
	private WarnDao warnDao;
	private String template;
	private String sendFrom;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	public void sendMimeMail(Warn warn) {
		List<Email> list = emailDao.findAllByAppname(warn.getAppId());
		Map<String, String> map = new HashMap<String, String>();
		StringBuilder subject = new StringBuilder();
		subject.append("来自应用");
		subject.append(warn.getAppId() + "的");
		subject.append(this.getGrade(warn) + "预警");
		
		map.put("subject", subject.toString());
		map.put("content", warn.getContent());

		for (Email email : list) {
			map.put("sendto", email.getOwner());
			String content = generateEmailContent(template, map);
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper;
			try {
				helper = new MimeMessageHelper(message, true, "utf-8");
				helper.setFrom(sendFrom);
				helper.setTo(email.getAddress());
				helper.setSubject(map.get("subject"));
				helper.setText(content, true);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			mailSender.send(message);
			// 更新发送邮件的状态并保存
			warn.setSendemail("1");
			warnDao.save(warn);
		}
	}
    /**
     * 增加邮箱预警对象.
     */
    @Transactional(readOnly = false)
    public void addEmail(Email email) {
        emailDao.save(email);
    }

    /**
     * 删除邮箱预警对象.
     */
    @Transactional(readOnly = false)
    public void deleteEmail(Email email) {
        emailDao.delete(email);
    }

    /**
     * 删除邮箱预警对象.
     */
    @Transactional(readOnly = false)
    public void deleteEmail(String id) {
        emailDao.delete(id);
    }

    /**
     * 根据ID查询邮箱预警对象.
     */
    public Email findEmail(String id) {
        return emailDao.findOne(id);
    }

    public Email findEmail(String owner, String address) {
        return emailDao.findByOwnerAndAddress(owner, address);
    }

    /**
     * 查询所有的邮箱预警对象.
     */
    public List<Email> findAllEmails() {
        return (List<Email>)emailDao.findAll(new Sort(Sort.Direction.ASC, "id"));
    }

    public List<Email> findEmails(String address) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 更新预警对象.
     */
    @Transactional(readOnly = false)
    public void updateEmail(Email email) {
        emailDao.save(email);
    }

    public void updateEmailAddress(String id,String address,Date date){
        emailDao.updateEmailAddressAndCreateTimeById(id,address,date);
    }
	private String generateEmailContent(String templateName,
			Map<String, String> map) {
		try {
			Template temp = freeMarkerConfigurer.getConfiguration()
					.getTemplate(templateName);
			return FreeMarkerTemplateUtils.processTemplateIntoString(temp, map);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getGrade(Warn warn) {
		String grade = "";
		if ("00".equals(warn.getGrade())) {
			grade = "普通";
		} else if ("01".equals(warn.getGrade())) {
			grade = "紧急";
		} else if ("02".equals(warn.getGrade())) {
			grade = "非常紧急";
		} else if ("03".equals(warn.getGrade())) {
			grade = "异常紧急";
		} else {
			grade = "其他";
		}
		return grade;
	}

	public String getSendFrom() {
		return sendFrom;
	}

	public void setSendFrom(String sendFrom) {
		this.sendFrom = sendFrom;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
}
