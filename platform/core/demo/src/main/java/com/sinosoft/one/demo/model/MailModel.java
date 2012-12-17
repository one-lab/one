package com.sinosoft.one.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Intro:
 * User: Kylin
 * Date: 12-10-30
 * Time: 上午10:02
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "mailinfo")
public class MailModel {

    private String id;
    private String sendTo;
    private String content;
    private String filePath;
    private String subject;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "sendto")
    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Column(name = "filepath")
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
