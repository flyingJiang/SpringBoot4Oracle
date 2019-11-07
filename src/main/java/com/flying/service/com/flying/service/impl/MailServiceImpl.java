package com.flying.service.com.flying.service.impl;

import com.flying.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    private String to = "15850539347@163.com";

    @Override
    public String sendMsg() throws MailException{
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo("15850539347@163.com");
            message.setSubject("SimpleMailMessage");
            String msg = "test";
            message.setText(msg);
            mailSender.send(message);
            return "success";
        }catch (Exception me){
            me.printStackTrace();
        }finally {
            System.out.println("mail send finally.");
        }
        return "fail";
    }

    @Override
    public String sendInlineResourceMail() throws MessagingException {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject("sendInlineResourceMail");
            String rscId = "img110";
            String content = "<html><body><img width='250px' src=\'cid:" + rscId + "\'></body></html>";
            String imgPath = "C:/Users/Flying.Jiang/Pictures/123.png";
            helper.setText(content, true);
            File file = new File(imgPath);
            FileSystemResource res= new FileSystemResource(file);
            helper.addInline(rscId, res);
            mailSender.send(message);
            return "success";

        } catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return "fail";
    }

    @Override
    public String sendHtmlMail() throws MessagingException{
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject("sendHtmlMail");
            String content = "<html><head></head><body><h3>哈哈，什么都没有</h3></body></html>";
            helper.setText(content, true);
            mailSender.send(message);
            return "success";

        } catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return "fail";
    }

    @Override
    public String sendAttachmentsMail() throws MessagingException {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject("sendAttachmentsMail");
            String content = "sendAttachmentsMail";
            String imgPath = "C:/Users/Flying.Jiang/Pictures/123.png";
            helper.setText(content, true);
            FileSystemResource res= new FileSystemResource(new File(imgPath));
            String fileName = res.getFilename();
            helper.addAttachment(fileName, res);
            mailSender.send(message);
            return "success";

        } catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return "fail";
    }
}
