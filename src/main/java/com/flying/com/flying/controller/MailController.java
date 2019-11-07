package com.flying.com.flying.controller;

import com.flying.service.com.flying.service.impl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailController {

    @Autowired
    private MailServiceImpl mailService;

    @RequestMapping("/sendMsg")
    public String sendMsg(String msg) throws MessagingException {
        switch (msg) {
            case "1":
                return mailService.sendMsg();
            case "2":
                return mailService.sendInlineResourceMail();
            case "3":
                return mailService.sendHtmlMail();
            case "4":
                return mailService.sendAttachmentsMail();
            default:
                return "error msg, please check from 1 to 4";

        }
    }
}
