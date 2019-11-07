package com.flying.service;

import org.springframework.mail.MailException;

import javax.mail.MessagingException;

public interface MailService {

    /**
     * 简单的文本邮件
     * @return
     */
    public String sendMsg() throws MailException;

    /**
     * 富文本邮件
     * 发送富文本邮件需要使用MimeMessageHelper类，MimeMessageHelper支持发送复杂邮件模板，支持文本、附件、HTML、图片等。
     * @return
     */
    public String sendInlineResourceMail() throws MessagingException;

    /**
     * 发送HTML邮件
     * @return
     */
    public String sendHtmlMail() throws MessagingException;

    /**
     * 发送带附件的邮件
     * @return
     */
    public String sendAttachmentsMail() throws MessagingException;
}
