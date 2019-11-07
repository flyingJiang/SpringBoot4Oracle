package com.flying.service;

import com.flying.service.com.flying.service.impl.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailException;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest//(classes = MailServiceImpl.class)
public class TestMailService {

    @Autowired
    private MailServiceImpl mailService;

    @Test
    public void testSendMsg(){
        try{
            mailService.sendMsg();
            System.out.println("成功了");
        } catch (MailException e) {
            e.printStackTrace();
            System.out.println("失败了");
        }
    }

    @Test
    public void testSendInlineResourceMail(){
        try {
            mailService.sendInlineResourceMail();
            System.out.println("成功了");
        } catch (MessagingException e) {
            System.out.println("失败了");
            e.printStackTrace();
        }
    }

    @Test
    public void testSendHtmlMail(){
        try {
            mailService.sendHtmlMail();
            System.out.println("成功了");
        } catch (MessagingException e) {
            System.out.println("失败了");
            e.printStackTrace();
        }
    }

    @Test
    public void testSendAttachmentsMail(){
        try {
            mailService.sendAttachmentsMail();
            System.out.println("成功了");
        } catch (MessagingException e) {
            System.out.println("失败了");
            e.printStackTrace();
        }
    }
}
